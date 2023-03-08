package com.daou.wiki.data.dao.impl;

import com.daou.wiki.data.dao.ProductDAO;
import com.daou.wiki.data.entity.Product;
import com.daou.wiki.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product selectProduct(Long number) {
        return productRepository.getReferenceById(number);
    }

    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        Product updatedProduct;
        if (selectedProduct.isPresent()) {
            Product product = selectedProduct.get();

            product.setName(name);
            product.setUpdatedAt(LocalDateTime.now());

            updatedProduct = productRepository.save(product);
        } else {
            throw new Exception();
        }

        return updatedProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        if (selectedProduct.isPresent()) {
            Product product = selectedProduct.get();
            productRepository.delete(product);
        } else {
            throw new Exception();
        }
    }
}
