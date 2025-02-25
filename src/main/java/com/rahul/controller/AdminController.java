package com.rahul.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rahul.entity.Admin;
import com.rahul.service.AdminService;

@RestController
@RequestMapping("/api/auth")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/signup")
    public ResponseEntity<String> registerAdmin(@RequestBody Admin admin) {
        // You can add validation for password strength, etc.
        adminService.registerAdmin(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body("Admin registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Admin admin) {
        Optional<Admin> adminOptional = adminService.findByUsername(admin.getUsername());
        if (adminOptional.isPresent() && adminOptional.get().getPassword().equals(admin.getPassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
