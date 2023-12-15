package com.example.product_be.services;

import com.example.product_be.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> getAll(Pageable pageable);
    Product save(Product product);
    void delete(long id);
    Product findById(long id);
    List<Product> findByName(String name);

}
