package com.example.demo.controller;


import com.example.demo.entities.Password;
import com.example.demo.request.PasswordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class PasswordController {
    @Autowired
    Password password;
    @PostMapping
    public ResponseEntity<Password> isAGoodPass(PasswordRequest pwr){
        password = new Password(pwr.getPassword());
        return new ResponseEntity(password, HttpStatus.ACCEPTED);
    }

}
