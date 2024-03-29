package com.selforderingmenu.service;

import com.selforderingmenu.entity.Category;
import com.selforderingmenu.entity.ChildCategory;
import com.selforderingmenu.entity.Product;
import com.selforderingmenu.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public void saveProduct(Product product) {
        Product newProduct = new Product();
        newProduct.setChildCategory(product.getChildCategory());
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        newProduct.setUrl(product.getUrl());
        productRepository.save(newProduct);
    }

    public void updateProduct(Product product){
        Product productInDb = productRepository.getById(product.getId());
        productInDb.setPrice(product.getPrice());
        productInDb.setDescription(product.getDescription());
        productInDb.setChildCategory(product.getChildCategory());
        productInDb.setName(product.getName());
        productInDb.setUrl(product.getUrl());
        productRepository.save(productInDb);
    }

    public List<Product> getAllProduct(){
        return     productRepository.findAll();
    }

    public List<Product> getProductByCategory(ChildCategory category){
        return productRepository.findByChildCategory(category);
    }

    public void  deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public List<Product> findByCategory(Category category){
        return productRepository.findByChildCategory_Category(category);
    }
}
