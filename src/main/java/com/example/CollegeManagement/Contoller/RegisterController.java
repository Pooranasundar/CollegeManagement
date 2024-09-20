package com.example.CollegeManagement.Contoller;

import com.example.CollegeManagement.Model.Register;
import com.example.CollegeManagement.Repository.RegisterRepo;
import com.example.CollegeManagement.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController
{
    @Autowired
    private RegisterRepo repo;

    @Autowired
    private RegisterService service;

    @GetMapping("/hello")
    public String hello()
    {
        return "Hello User";
    }

    @GetMapping("/hello/poorna")
    public String helloPoorna()
    {
        return "Hello Poorna";
    }

    @PostMapping("/register")
    public ResponseEntity<String> addUser(@RequestBody Register reg)
    {
        service.register(reg);
        return ResponseEntity.ok("Register successful");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id)
    {
        service.deleteUser(id);
        return ResponseEntity.ok("Delete successful");
    }

}
