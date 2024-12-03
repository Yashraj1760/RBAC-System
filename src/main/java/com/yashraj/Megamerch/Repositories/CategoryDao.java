package com.yashraj.Megamerch.Repositories;

import com.yashraj.Megamerch.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao  extends JpaRepository<Category,Integer> {
}
