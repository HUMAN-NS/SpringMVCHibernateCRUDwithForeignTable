package com.jwt.service;
 
import java.util.List;
 
import com.jwt.model.Salary;
 
public interface SalaryService {
     
    public void addSalary(Salary salary);
    
    public List<Salary> getAllSalary(Integer employeeId);
    
    public List<Salary> getAllSalary();
 
    public void deleteSalary(Integer salaryId);
 
    public Salary getSalary(int salaryid);
 
    public Salary updateSalary(Salary salary);
}