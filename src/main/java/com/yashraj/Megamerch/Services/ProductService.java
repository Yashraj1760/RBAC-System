package com.yashraj.Megamerch.Services;

import com.yashraj.Megamerch.Model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> getAllProduct();

    public Product addProduct(Product product);

    public void removeProductById(Long id);

    public Optional<Product> getProductById(Long id);

    public List<Product> getProductByCategory_Id(int id);

}
