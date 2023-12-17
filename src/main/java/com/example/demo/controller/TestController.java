package com.example.demo.controller;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.SQLException;
@RestController
@RequestMapping("/misha")
public class TestController {

    @Autowired
    private DataSource dataSource;
    
    @GetMapping("/test")
    public String testDatabaseConnection() {
        try (Connection connection = dataSource.getConnection()) {
            return "Connection to the database established!";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Failed to connect to the database.";
        }
        
    }
}