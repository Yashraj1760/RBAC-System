package com.yashraj.Megamerch.Services;

import com.yashraj.Megamerch.Model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryServies {

    public Category addCatgory(Category category);

    public List<Category> getAllCategory();

    public void categoryDeleteByid(int id);

    public Optional<Category> findCatgeroyById(int id);
}
