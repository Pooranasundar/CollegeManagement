package com.example.CollegeManagement.Repository;

import com.example.CollegeManagement.Model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepo extends JpaRepository<Register, Integer>
{

    Register findByUserName(String username);

}
