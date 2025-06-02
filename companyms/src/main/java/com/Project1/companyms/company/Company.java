package com.Project1.companyms.company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
@Entity
public class Company {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;



    public Company() {
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
