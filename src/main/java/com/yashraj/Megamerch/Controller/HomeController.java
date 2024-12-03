package com.yashraj.Megamerch.Controller;

import com.yashraj.Megamerch.Model.Product;
import com.yashraj.Megamerch.Services.CategoryServies;
import com.yashraj.Megamerch.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.yashraj.Megamerch.Global.GlobalData.cart;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryServies categoryServies;

    @GetMapping({"/","/index"})
    public String home(Model model){
        model.addAttribute("cartCount", cart.size());
        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("categories",categoryServies.getAllCategory());
        model.addAttribute("products",productService.getAllProduct());
        model.addAttribute("cartCount", cart.size());
        return "shop";
    }

    @GetMapping("/shop/category/{id}")
    public String shop(Model model , @PathVariable int id){
        model.addAttribute("categories",categoryServies.getAllCategory());
        model.addAttribute("products",productService.getProductByCategory_Id(id));
        model.addAttribute("cartCount", cart.size());
        return "shop";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model , @PathVariable long id){
        model.addAttribute("product",productService.getProductById(id).get());
        model.addAttribute("cartCount", cart.size());
        return "viewProduct";
    }
}
