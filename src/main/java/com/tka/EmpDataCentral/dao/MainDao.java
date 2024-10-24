package com.tka.EmpDataCentral.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.EmpDataCentral.entity.Country;
import com.tka.EmpDataCentral.entity.Employee;

@Repository
public class MainDao {
	
	@Autowired
	SessionFactory factory;

	public String addCountry(Country c) {
		Session session = null;
		Transaction tx = null;
		String msg=null;
		try {
		session=factory.openSession();
		tx=session.beginTransaction();
		session.persist(c);
		tx.commit();
		msg="Country Added Successfully...";
		
		}catch(Exception e) {
			if(tx!=null) {
			
				tx.rollback();
			}
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		
		return msg;
	}

	public String updateCountry(Country c,int id) {
		Session session = null;
		Transaction tx = null;
		String msg=null;
		Country country=null;
		try {
		session=factory.openSession();
		tx=session.beginTransaction();
		country=session.get(Country.class,id);
		country.setCname(c.getCname());
		session.merge(country);
		
		tx.commit();
		msg="Country Updated Successfully...";
		
		}catch(Exception e) {
			if(tx!=null) {
			
				tx.rollback();
			}
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		
		return msg;
	
	}

	public String deleteCountry(int id) {
		Session session = null;
		Transaction tx = null;
		String msg=null;
		Country country=null;
		try {
		session=factory.openSession();
		tx=session.beginTransaction();
		country=session.get(Country.class,id);
		session.remove(country);
		
		tx.commit();
		msg="Country deleted Successfully...";
		
		}catch(Exception e) {
			if(tx!=null) {
			
				tx.rollback();
			}
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		
		return msg;
	}

	public List<Country> getallCountry() {
		Session session = null;
		Transaction tx = null;
		List<Country> list=null;
		String hqlQuery="from Country";
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			Query<Country> query = session.createQuery(hqlQuery,Country.class);
			list=query.list();
			tx.commit();
			
		}catch(Exception e) {
			if(tx!=null) {
			
				tx.rollback();
			}
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return list;
		
	}

	public Country getParticulerCountryById(int id) {
		Session session = null;
		Transaction tx = null;
		Country country=null;
		try {
		session=factory.openSession();
		tx=session.beginTransaction();
		country=session.get(Country.class,id);
		
		tx.commit();
		
		}catch(Exception e) {
			if(tx!=null) {
			
				tx.rollback();
			}
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return country;
	}

	public String addEmployee(Employee emp) {
		Session session = null;
		Transaction tx = null;
		String msg=null;
		try {
		session=factory.openSession();
		tx=session.beginTransaction();
		session.persist(emp);
		tx.commit();
		msg="Employee Added Successfully...";
		
		}catch(Exception e) {
			if(tx!=null) {
			
				tx.rollback();
			}
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		
		return msg;
	}

	public String updateEmployee(Employee emp, long id) {
		Session session = null;
		Transaction tx = null;
		String msg=null;
		Employee employee =null;
		try {
		session=factory.openSession();
		tx=session.beginTransaction();
		employee=session.get(Employee.class,id);
		employee.setName(emp.getName());
		session.merge(employee);
		
		tx.commit();
		msg="Employee Updated Successfully...";
		
		}catch(Exception e) {
			if(tx!=null) {
			
				tx.rollback();
			}
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}

	public String deleteEmployee(long id) {
		Session session = null;
		Transaction tx = null;
		String msg=null;
		Employee employee = null;
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			employee=session.get(Employee.class,id);
			session.remove(employee);
			
			tx.commit();
			msg="Employee is deleted Successfully...";
			
			}catch(Exception e) {
				if(tx!=null) {
				
					tx.rollback();
				}
			}finally {
				if(session!=null) {
					session.close();
				}
			}
			
			return msg;
	}

	public List<Employee> getallEmployee() {
		Session session = null;
		Transaction tx = null;
		List<Employee> list=null;
		String hqlQuery="from Employee";
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			Query<Employee> query = session.createQuery(hqlQuery,Employee.class);
			list=query.list();
			tx.commit();
			
		}catch(Exception e) {
			if(tx!=null) {
			
				tx.rollback();
			}
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return list;
	}

	public Employee getParticulerEmployeeById(long id) {
		Session session = null;
		Transaction tx = null;
		Employee employee =null;
		try {
		session=factory.openSession();
		tx=session.beginTransaction();
		employee=session.get(Employee.class,id);
		
		tx.commit();
		
		}catch(Exception e) {
			if(tx!=null) {
			
				tx.rollback();
			}
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return employee;
	}

	public Employee login(Employee emp) {
		Session session=null;
		Transaction tx=null;
		Employee employee=null;
		String hqlQuery="from Employee where emailid=:emailid and mobno=:mobno";
		try {	
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Query<Employee> query= session.createQuery(hqlQuery,Employee.class);
			query.setParameter("emailid", emp.getEmailid());
			query.setParameter("mobno", emp.getMobno());
			employee= query.uniqueResult();
			tx.commit();
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}		
		return employee;
	}

	public List<Employee> salaryRange(double startSal, double endSal) {
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
		String hqlQuery="from Employee where salary between :startSal and :endSal";
		try {	
			session=factory.openSession();
			tx=session.beginTransaction();
			Query<Employee> query=session.createQuery(hqlQuery,Employee.class);
			query.setParameter("startSal", startSal);
			query.setParameter("endSal", endSal);
			list=query.list();
			tx.commit();
			
		}catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}		
		
		return list;
	}

}
