package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.models.User;
import com.tweteroo.api.services.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService service;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<User>> listAll() {
        List<User> users = service.findAll();

        return ResponseEntity.ok().body(users);
    }
}
