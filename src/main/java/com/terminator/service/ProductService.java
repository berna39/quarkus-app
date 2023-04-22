package com.terminator.service;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import com.terminator.dto.ProductDto;
import com.terminator.model.Product;

@ApplicationScoped
public class ProductService {
    
    public List<Product> findAll(){
        return Product.listAll();
    }

    @Transactional
    public Product saveProduct(ProductDto productDto){
        Product product = new Product();

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.persist();

        return product;
    }

    @Transactional
    public Product updateProduct(Long id, ProductDto productDto){
        Optional<Product> productOp = Product.findByIdOptional(id);

        if(productOp.isEmpty()) throw new NullPointerException("Product not found");

        Product product = productOp.get();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.persist();

        return product;
    }

    @Transactional
    public void deleteProduct(Long id){
        Optional<Product> product = Product.findByIdOptional(id);

        if(product.isEmpty()) throw new NullPointerException("Product not found");

        product.get().delete();
    }
}
