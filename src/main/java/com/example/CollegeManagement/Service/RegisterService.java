package com.example.CollegeManagement.Service;

import com.example.CollegeManagement.Model.Register;
import com.example.CollegeManagement.Repository.RegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService
{

    @Autowired
    private RegisterRepo repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Register register(Register reg)
    {
        reg.setPassword(encoder.encode(reg.getPassword()));
        return  repo.save(reg);
    }

    public void deleteUser(int id)
    {
        repo.deleteById(id);
    }

}
