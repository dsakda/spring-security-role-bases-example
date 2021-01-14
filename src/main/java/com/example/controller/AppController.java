package com.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/content")
public class AppController {

    @GetMapping("/all")
    public String allAccess() {
        return "All Access.";
    }

    @GetMapping("/creator")
    @PreAuthorize("hasRole('CREATOR') or hasRole('ADMIN')")
    public String creatorAccess() {
        return "Creator Access.";
    }

    @GetMapping("/editor")
    @PreAuthorize("hasRole('EDITOR') or hasRole('ADMIN')")
    public String editorAccess() {
        return "Editor Access.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Access.";
    }
}
