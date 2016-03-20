package com.normasys.conf.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
    
    @Id
    private long id;
    
    private String name;
    
    private String prenom;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    

}
