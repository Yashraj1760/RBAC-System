package com.yashraj.Megamerch.Controller;

import com.yashraj.Megamerch.Global.GlobalData;
import com.yashraj.Megamerch.Model.Product;
import com.yashraj.Megamerch.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.yashraj.Megamerch.Global.GlobalData.cart;


@Controller
public class CartController {
    @Autowired
    private ProductService productService;


    @GetMapping("/addToCart/{id}")
    public String addCart(@PathVariable long id){
        cart.add(productService.getProductById(id).get());
        return "redirect:/shop";

    }
    @GetMapping("/cart")
    public String getCart(Model model){
        model.addAttribute("cartCount", cart.size());
        model.addAttribute("total", cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("cart", cart);
        return "cart" ;

    }

    @GetMapping("/cart/removeItem/{index}")
    public String removeCart(@PathVariable int index){

        cart.remove(index);
        return "redirect:/cart";
    }
    @GetMapping("/checkout")
    public String checkOut(Model model){
        model.addAttribute("total", cart.stream().mapToDouble(Product::getPrice).sum());
        return "checkout";
    }


}
