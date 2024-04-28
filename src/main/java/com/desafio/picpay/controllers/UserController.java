package com.desafio.picpay.controllers;

import com.desafio.picpay.application.UserService;
import com.desafio.picpay.controllers.requests.CreateUserRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/user", produces = {"application/json"})
@Tag(name = "user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping()
    @Operation(summary = "get by id", method = "GET")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping()
    @Operation(summary = "create user", method = "POST")
    public ResponseEntity<?> create(CreateUserRequest request) {
        service.create(request);
        return ResponseEntity.noContent().build();
    }

}
