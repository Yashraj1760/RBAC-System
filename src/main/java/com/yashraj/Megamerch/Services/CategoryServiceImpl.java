package com.yashraj.Megamerch.Services;

import com.yashraj.Megamerch.Model.Category;
import com.yashraj.Megamerch.Repositories.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryServies {
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public Category addCatgory(Category category) {
       Category savedCategory = categoryDao.save(category);
       return savedCategory;
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryDao.findAll();
    }

    @Override
    public void categoryDeleteByid(int id) {
        categoryDao.deleteById(id);
    }

    @Override
    public Optional<Category> findCatgeroyById(int id) {
        return categoryDao.findById(id);
    }
}
