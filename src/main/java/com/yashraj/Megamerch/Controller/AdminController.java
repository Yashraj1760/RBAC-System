package com.yashraj.Megamerch.Controller;

import com.yashraj.Megamerch.Model.Category;
import com.yashraj.Megamerch.Services.CategoryServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AdminController {
    @Autowired(required = true)
    private CategoryServies categoryServies;
    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String getCategories(Model model){
        model.addAttribute("categories",categoryServies.getAllCategory());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String getCategoriesAdd(Model model){
        model.addAttribute("category",new Category());
        return "categoriesAdd";
    }
    @PostMapping("/admin/categories/add")
    public String postCategoryAdd(@ModelAttribute("category") Category category){
        categoryServies.addCatgory(category);

        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/categories/delete/{id}")
    public String categoryDelete(@PathVariable int id){
        categoryServies.categoryDeleteByid(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String categoryUpdate(@PathVariable int id , Model model){
        Optional<Category> opt = categoryServies.findCatgeroyById(id);
        if (opt.isPresent()){
            model.addAttribute("category",opt.get());
            return "categoriesAdd";
        }else
            return "404";
    }

}
