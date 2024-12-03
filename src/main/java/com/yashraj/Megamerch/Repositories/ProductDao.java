package com.yashraj.Megamerch.Repositories;

import com.yashraj.Megamerch.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product,Long> {

    public List<Product> findAllByCategory_id(int id);
}
