package com.jwt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.Salary;

@Repository
public class SalaryDaoImpl implements SalaryDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public void addSalary(Salary salary) {
  
        sessionFactory.getCurrentSession().saveOrUpdate(salary);
 
    }
 
    @SuppressWarnings("unchecked")
    public List<Salary> getAllSalary() {
 
        return sessionFactory.getCurrentSession().createQuery("from Salary")
                .list();
    }
 
    @Override
    public void deleteSalary(Integer salaryId) {
        Salary salary = (Salary) sessionFactory.getCurrentSession().load(
                Salary.class, salaryId);
        if (null != salary) {
           
            this.sessionFactory.getCurrentSession().delete(salary);
                  }
 
    }
 
    public Salary getSalary(int salid) {
        return (Salary) sessionFactory.getCurrentSession().get(
                Salary.class, salid);
    }
 
    @Override
    public Salary updateSalary(Salary salary) {
        sessionFactory.getCurrentSession().update(salary);
        return salary;
    }

	@SuppressWarnings("unchecked")
	public List<Salary> getAllSalary(Integer employeeId) {
				
		return (List<Salary>) sessionFactory.getCurrentSession().createQuery("from Salary where id_ref=:employeeId").setParameter("employeeId", employeeId)
                .list();
		
	}
 
}