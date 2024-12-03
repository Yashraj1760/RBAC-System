package com.yashraj.Megamerch.Controller;

import com.yashraj.Megamerch.Dto.ProductDTO;
import com.yashraj.Megamerch.Model.Product;
import com.yashraj.Megamerch.Services.CategoryServies;
import com.yashraj.Megamerch.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class AdminProductController {
    private static String uploadDir=System.getProperty("user.dir")+"/src/main/resources/static/productImages";
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryServies categoryServies;

    @GetMapping("/admin/products")
    public String getAllproducts(Model model){
        model.addAttribute("products",productService.getAllProduct());
        return "products";
    }

    @GetMapping("/admin/products/add")
    public String getAddproduct(Model model){
        model.addAttribute("productDTO",new ProductDTO());
        model.addAttribute("categories",categoryServies.getAllCategory());
        return "productsAdd";
    }
    @PostMapping("/admin/products/add")
    public String postAddProduct(@ModelAttribute("products")ProductDTO productDTO,
                                 @RequestParam("productImage")MultipartFile file,
                                 @RequestParam("imgName")String imgName)throws IOException{

        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(categoryServies.findCatgeroyById(productDTO.getCategoryId()).get());
        product.setPrice(productDTO.getPrice());
        product.setWeight(productDTO.getWeight());
        product.setDescription(productDTO.getDescription());
        String imageUUID;
        if (!file.isEmpty()){
            imageUUID=file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir,imageUUID);
            Files.write(fileNameAndPath,file.getBytes());
        }else {
            imageUUID=imgName;
        }
        product.setImageName(imageUUID);

        productService.addProduct(product);

        return "redirect:/admin/products";

    }
    @GetMapping("/admin/product/delete/{id}")
    public String productDelete(@PathVariable long id){
        productService.removeProductById(id);
        return "redirect:/admin/products";
    }
    @GetMapping("/admin/product/update/{id}")
    public String productUpdate(@PathVariable long id ,Model model){
        ProductDTO productDTO =new ProductDTO();
        Product product= productService.getProductById(id).get();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setCategoryId(product.getCategory().getId());
        productDTO.setPrice(product.getPrice());
        productDTO.setWeight(product.getWeight());
        productDTO.setDescription(product.getDescription());
        productDTO.setImageName(product.getImageName());


        model.addAttribute("categories",categoryServies.getAllCategory());
        model.addAttribute("productDTO", productDTO);

        return "productsAdd";
    }
}
