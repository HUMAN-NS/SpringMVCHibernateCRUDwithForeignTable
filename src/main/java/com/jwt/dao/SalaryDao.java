package com.jwt.dao;
 
import java.util.List;
import com.jwt.model.Salary;
 
public interface SalaryDao {
 
    public void addSalary(Salary salary);
 
    public List<Salary> getAllSalary();
    
    public List<Salary> getAllSalary(Integer employeeId);
 
    public void deleteSalary(Integer salaryId);
 
    public Salary updateSalary(Salary salary);
 
    public Salary getSalary(int salaryid);
}