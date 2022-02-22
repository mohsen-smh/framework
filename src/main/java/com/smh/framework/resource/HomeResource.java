package com.smh.framework.resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest/core")
@RestController
public class HomeResource {

    @GetMapping("/all")
    public String home(){
        return "hello World!!!";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("secured/all")
    public String secured(){
        return "secured Hello World!!!";
    }

}
