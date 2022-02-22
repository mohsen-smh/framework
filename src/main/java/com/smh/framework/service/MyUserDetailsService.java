package com.smh.framework.service;

import com.smh.framework.model.MyUserDetails;
import com.smh.framework.model.User;
import com.smh.framework.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser=userRepository.findByUserName(username);
        optionalUser.orElseThrow(()-> new UsernameNotFoundException("userName Not Found!!!"));

        return optionalUser.map(MyUserDetails::new).get();
    }
}
