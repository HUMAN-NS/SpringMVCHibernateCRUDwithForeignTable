package com.jwt.model;
 
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 

@Entity
@Table(name = "SAL_TBL")
public class Salary implements Serializable {
 
    private static final long serialVersionUID = -3465813074586302847L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    
    @Column(name="year")
    private int year;
 
    @Column(name="month")
    private String month;
 
    @Column(name="salary")
    private String salary;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ref")
    private Employee employee;
    
    public Salary() {
    	super();
    	    }

    public Salary(int salId, int salYear, String salMonth, String salSalary, Employee employee) {
    		super();
    		this.id = salId;
    		this.year = salYear;
    		this.month = salMonth;
    		this.salary = salSalary;
    		this.employee = employee;
    }
   
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
    
    public int getYear() {
        return year;
    }
 
    public void setYear(int year) {
        this.year = year;
    }
    
    public String getMonth() {
        return month;
    }
 
    public void setMonth(String month) {
        this.month = month;
    }
 
    public String getSalary() {
        return salary;
    }
 
    public void setSalary(String salary) {
        this.salary = salary;
    }
    
    
 
    public Employee getEmployee()
    {
        return employee;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }
  
 
}