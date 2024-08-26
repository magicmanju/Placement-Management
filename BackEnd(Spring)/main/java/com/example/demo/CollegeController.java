package com.example.demo;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class CollegeController {

    @Autowired
    private CollegeService service;

    @PostMapping("/registercollege")
    public College registercollege(@RequestBody College college) {
        return service.registercollege(college);
    }

    @GetMapping("/getcollege")
    public List<College> getcollege() {
        return service.getcollege();
    }

    @PutMapping("/updatecollege")
    public College updatecollege(@RequestBody College college) {
        return service.updatecollege(college);
    }

    @DeleteMapping("/deletecollege")
    public void delete(@RequestParam Integer id) {
        service.deletecollege(id);
    }
}
