package com.daou.wiki.service.impl;

import com.daou.wiki.data.dto.ProductDto;
import com.daou.wiki.data.dto.ProductResponseDto;
import com.daou.wiki.data.entity.Product;
import com.daou.wiki.data.repository.ProductRepository;
import com.daou.wiki.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDto getProduct(Long number) {
        LOGGER.info("[getProduct] input number: {}", number);

        Product product = productRepository.findById(number).get();

        LOGGER.info("[getProduct] productNumber: {}, name: {}", product.getNumber(), product.getName());
        return ProductResponseDto.builder()
                .name(product.getName())
                .number(product.getNumber())
                .price(product.getPrice())
                .stock(product.getStock()).build();
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        LOGGER.info("[saveProduct] productDto: {}", productDto.toString());

        Product product = Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .stock(productDto.getStock())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Product savedProduct = productRepository.save(product);
        LOGGER.info("[saveProduct] savedProduct: {}", savedProduct);

        /*
         * return type: void | 작업 성공여부 | 현재는 dto 로 내려주었음
         * */
        return ProductResponseDto.builder()
                .number(savedProduct.getNumber())
                .name(savedProduct.getName())
                .price(savedProduct.getPrice())
                .stock(savedProduct.getStock())
                .build();
    }

    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        Product foundProduct = productRepository.findById(number).get();
        foundProduct.setName(name);
        Product changedProduct = productRepository.save(foundProduct);

        return ProductResponseDto.builder()
                .number(changedProduct.getNumber())
                .name(changedProduct.getName())
                .price(changedProduct.getPrice())
                .stock(changedProduct.getStock())
                .build();
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productRepository.deleteById(number);
    }
}