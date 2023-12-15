package com.example.product_be.services.impl;

import com.example.product_be.models.Product;
import com.example.product_be.repositorys.IProductRepo;
import com.example.product_be.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepo iProductRepo;

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return iProductRepo.findAll(pageable);
    }

    @Override
    public Product save(Product product) {
        return iProductRepo.save(product);
    }

    @Override
    public void delete(long id) {
         iProductRepo.deleteById(id);
    }

    @Override
    public Product findById(long id) {
        return iProductRepo.findById(id).get();
    }

    @Override
    public List<Product> findByName(String name) {
        return iProductRepo.findAllByNameContaining(name);
    }

}
