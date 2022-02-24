package com.smh.framework;

import com.smh.framework.model.Role;
import com.smh.framework.model.User;
import com.smh.framework.repository.RoleRepository;
import com.smh.framework.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FrameworkApplication {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(FrameworkApplication.class, args);
    }

    @PostConstruct
    protected void init() {
        List<Role> roleList = null;
        if (roleRepository.findAll().isEmpty()) {
            List<Role> roles = new ArrayList<>();
            roles.add(createRole("1", "ADMIN"));
            roles.add(createRole("2", "USER"));
            roleList = roleRepository.saveAll(roles);
        }
        if (userRepository.findAll().isEmpty()) {
            User user = new User();
            user.setUserName("admin");
            user.setPassword(passwordEncoder.encode("admin"));
            user.setActive(true);
            user.setRoles(roleList);
            userRepository.save(user);
        }
    }

    private Role createRole(String roleCode, String roleTitle) {
        Role role = new Role();
        role.setCode(roleCode);
        role.setTitle(roleTitle);
        return role;
    }

}
