package com.yashraj.Megamerch.Services;

import com.yashraj.Megamerch.Model.CustomUserDetails;
import com.yashraj.Megamerch.Model.User;
import com.yashraj.Megamerch.Repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userDao.findUserByEmail(email);
        user.orElseThrow(()-> new UsernameNotFoundException("user doesn't exist "));
        return user.map(CustomUserDetails::new).get();
    }
}
