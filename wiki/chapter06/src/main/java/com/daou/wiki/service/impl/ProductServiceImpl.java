package com.daou.wiki.service.impl;

import com.daou.wiki.data.dao.ProductDAO;
import com.daou.wiki.data.dto.ProductDto;
import com.daou.wiki.data.dto.ProductResponseDto;
import com.daou.wiki.data.entity.Product;
import com.daou.wiki.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public ProductResponseDto getProduct(Long number) {
        Product product = productDAO.selectProduct(number);

        return ProductResponseDto.builder()
                .name(product.getName())
                .number(product.getNumber())
                .price(product.getPrice())
                .stock(product.getStock()).build();
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Product product = Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .stock(productDto.getStock())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Product savedProduct = productDAO.insertProduct(product);

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
        Product product = productDAO.updateProductName(number, name);

        return ProductResponseDto.builder()
                .number(product.getNumber())
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productDAO.deleteProduct(number);
    }
}