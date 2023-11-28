package com.soppingWebsite.service;

import com.soppingWebsite.model.Product;
import com.soppingWebsite.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        if(product.getProductId() != null) {
            throw new IllegalArgumentException("Invalid id.");
        }
        productRepository.createProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        if(productRepository.getProductById(product.getProductId()) == null) {
            throw new IllegalArgumentException("Product does not exist.");
        }
        productRepository.updateProduct(product);
    }

    @Override
    public void deleteProductById(Long productId) {
        if(productRepository.getProductById(productId) == null) {
            throw new IllegalArgumentException("Product does not exist.");
        }
        productRepository.deleteProductById(productId);
    }

    @Override
    public Product getProductById(Long productId) {
        if(productRepository.getProductById(productId) == null) {
            throw new IllegalArgumentException("Product does not exist.");
        }
        return productRepository.getProductById(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public List<Product> getProductsContainingSearchText(String searchText) {
        return productRepository.getProductsContainingSearchText(searchText);
    }
}
