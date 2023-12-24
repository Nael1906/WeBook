package com.example.models;

public class Book {
    private int id; 
    private String name;
    private String code; 
    private String description;
    private boolean isBorrowed;
    
    public Book(int id, String name, String code, String description, boolean isBorrowed) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.isBorrowed = isBorrowed;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isBorrowed() {
        return isBorrowed;
    }
    public void setBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", code=" + code + ", description=" + description + ", isBorrowed="
                + isBorrowed + "]";
    } 
}
