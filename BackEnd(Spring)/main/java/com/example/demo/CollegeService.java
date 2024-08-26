package com.example.demo;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CollegeService {

    @Autowired
    private CollegeRepository repo;

    public College registercollege(College college) {
        return repo.save(college);
    }

    public List<College> getcollege() {
        return repo.findAll();
    }
    public void deletecollege(Integer id) {
        repo.deleteById(id);
    }

    public College updatecollege(College college) {
        Integer id = college.getId();
        College clg = repo.findById(id).get();
        clg.setName(college.getName());
        clg.setLocation(college.getLocation());
        clg.setAdmin(college.getAdmin()); // Update college admin correctly
        return repo.save(clg);
    }

    
}
