package com.jwt.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.jwt.dao.SalaryDao;
import com.jwt.model.Salary;
 
@Service
@Transactional
public class SalaryServiceImpl implements SalaryService {
 
    @Autowired
    private SalaryDao salaryDAO;
 
    @Override
    @Transactional
    public void addSalary(Salary salary) {
      salaryDAO.addSalary(salary);
    }
 
    @Override
    @Transactional
    public List<Salary> getAllSalary() {
        return salaryDAO.getAllSalary();
    }
 
    @Override
    @Transactional
    public void deleteSalary(Integer salaryId) {
        salaryDAO.deleteSalary(salaryId);
    }
 
    public Salary getSalary(int empid) {
        return salaryDAO.getSalary(empid);
    }
 
    public Salary updateSalary(Salary salary) {
        // TODO Auto-generated method stub
        return salaryDAO.updateSalary(salary);
    }
 
    public void setSalaryDAO(SalaryDao salaryDAO) {
        this.salaryDAO = salaryDAO;
    }

	@Override
	public List<Salary> getAllSalary(Integer employeeId) {
		
		 return salaryDAO.getAllSalary(employeeId);
		
	}
 
}