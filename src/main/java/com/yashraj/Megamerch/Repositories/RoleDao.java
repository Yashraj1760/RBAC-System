package com.yashraj.Megamerch.Repositories;

import com.yashraj.Megamerch.Model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Roles,Integer> {
}
