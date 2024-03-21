package com.jeanpierre.javapi.model;

public class Employe {

    private int id;
    private String name;
    private String lastname;
    private String role;
    private int age;
    private String salary;
    
    public Employe(int id, String name, String lastname, String role, int age, String salary) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.role = role;
        this.age = age;
        this.salary = salary;
    }

    public Employe() {
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSalary() {
        return this.salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

}
