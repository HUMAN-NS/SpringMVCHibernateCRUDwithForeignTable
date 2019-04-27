package com.jwt.model;
 
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity
@Table(name = "EMP_TBL")
public class Employee implements Serializable {
 
    private static final long serialVersionUID = -3465813074586302847L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
 
    @Column(name="name")
    private String name;
 
    @Column(name="email")
    private String email;
 
    @Column(name="address")
    private String address;
 
    @Column(name="telephone")
    private String telephone;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="employee")
    private Set<Salary> salary;

    
    public Employee() {
    	super();
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
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }
 
    public String getTelephone() {
        return telephone;
    }
 
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public Set<Salary> getSalary()
    {
        return salary;
    }

    public void setSalary(Set<Salary> salary)
    {
        this.salary = salary;
    }

    @Override
    public String toString()
    {
        return "Employee [id=" + id + ", empName=" + name + "]";
    }
   
   
 
}