package com.example.CollegeManagement.Service;

import com.example.CollegeManagement.Model.Register;
import com.example.CollegeManagement.Model.UserPrincipal;
import com.example.CollegeManagement.Repository.RegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class MyUserDetailsService implements UserDetailsService
{
    @Autowired
    private RegisterRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Register register = repo.findByUserName(username);

        if (register == null)
        {
            System.out.println("User not Found");
            throw new UsernameNotFoundException(("User not Found"));
        }

        System.out.println(register.getUserName()+ " " + register.getPassword() + " " + register.getRole());

        return new UserPrincipal(register);
    }
}
