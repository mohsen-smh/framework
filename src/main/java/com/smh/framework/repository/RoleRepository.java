package com.smh.framework.repository;

import com.smh.framework.model.Role;
import com.smh.framework.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {

}
