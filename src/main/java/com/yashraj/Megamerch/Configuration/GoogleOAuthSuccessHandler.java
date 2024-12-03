package com.yashraj.Megamerch.Configuration;

import com.yashraj.Megamerch.Model.Roles;
import com.yashraj.Megamerch.Model.User;
import com.yashraj.Megamerch.Repositories.RoleDao;
import com.yashraj.Megamerch.Repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GoogleOAuthSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        String email = token.getPrincipal().getAttributes().get("email").toString();
        if (!userDao.findUserByEmail(email).isPresent()) {
            User user = new User();
            user.setFirstName(token.getPrincipal().getAttributes().get("given_name").toString());
            user.setLastName(token.getPrincipal().getAttributes().get("family_name").toString());
            user.setEmail(token.getPrincipal().getAttributes().get("email").toString());
            List<Roles> roles=new ArrayList<>();
            roles.add(roleDao.findById(2).get());
            user.setRoles(roles);
            userDao.save(user);
        }
        redirectStrategy.sendRedirect(httpServletRequest,httpServletResponse,"/");
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);
    }
}
