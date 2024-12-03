package com.yashraj.Megamerch.Services;

import com.yashraj.Megamerch.Model.Product;
import com.yashraj.Megamerch.Repositories.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> getAllProduct() {
        return productDao.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productDao.save(product);
    }

    @Override
    public void removeProductById(Long id) {
        productDao.deleteById(id);

    }

    @Override
    public Optional<Product> getProductById(Long id) {
       return productDao.findById(id);

    }

    @Override
    public List<Product> getProductByCategory_Id(int id) {
        List<Product> products=productDao.findAllByCategory_id(id);
        return products;
    }
}
