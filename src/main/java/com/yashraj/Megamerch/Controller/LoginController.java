package com.yashraj.Megamerch.Controller;


import com.yashraj.Megamerch.Model.Roles;
import com.yashraj.Megamerch.Model.User;
import com.yashraj.Megamerch.Repositories.RoleDao;
import com.yashraj.Megamerch.Repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
     @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
     @Autowired
    private UserDao userDao ;
    @Autowired
    private RoleDao roleDao;

    @GetMapping("/login")
    public String loginGet(){
        return "login";
    }

    @GetMapping("/register")
    public String registerGet(){
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute("user") User user, HttpServletRequest req )throws ServletException {
        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        List<Roles> roles=new ArrayList<>();
        roles.add(roleDao.findById(2).get());
        user.setRoles(roles);
        userDao.save(user);
        req.login(user.getEmail(),password);
        return "redirect:/";
    }
}
