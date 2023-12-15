package com.example.product_be.controllers;

import com.example.product_be.models.Product;
import com.example.product_be.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductAPI {

    @Autowired
    IProductService productService;

    @GetMapping
    public Page<Product> getAll(@RequestParam(defaultValue = "0") int page){
        return productService.getAll(PageRequest.of(page,4));
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable long id){
        return productService.findById(id);
    }


    @GetMapping("/search")
    public List<Product> findByName(@RequestParam(defaultValue = "") String name){
        return productService.findByName(name);
    }

    @PostMapping
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }
    @PostMapping("/upImg")
    public String upImg(@RequestParam MultipartFile file){
        String name = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(),new File("C:\\Users\\Admin\\Downloads\\project_fe\\Product_FE\\img\\" + name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/Demo/img/"+name;
    }

    @PutMapping
    public Product edit(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
         productService.delete(id);
    }

}
