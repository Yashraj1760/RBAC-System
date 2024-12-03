package com.yashraj.Megamerch.Repositories;

import com.yashraj.Megamerch.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User,Integer> {

    Optional<User> findUserByEmail(String email);
}
