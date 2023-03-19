package com.kshrd.registration.controller;

import com.kshrd.registration.utillity.GenerateCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "Welcome home...!";
    }

    @GetMapping("/all")
    public String allUser(){
        return "Welcome all users...!";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Welcome admin...!";
    }

    @GetMapping("/user")
    public String user(){
        return "Welcome user...!";
    }


}
