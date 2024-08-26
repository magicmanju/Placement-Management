package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "college") // Specify the table name
public class College {

    @Id
    private Integer id;
    private String name;
    private String location;
    private String admin;

    public College() {
        super();
    }

    public College(Integer id, String name, String admin, String location) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
        this.admin = admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "College [id=" + id + ", name=" + name + ", admin=" + admin + ", location=" + location + "]";
    }
}
