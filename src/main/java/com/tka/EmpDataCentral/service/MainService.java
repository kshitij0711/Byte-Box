package com.tka.EmpDataCentral.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.EmpDataCentral.dao.MainDao;
import com.tka.EmpDataCentral.entity.Country;
import com.tka.EmpDataCentral.entity.Employee;

@Service
public class MainService {

	@Autowired
	MainDao dao;
	
	public String addCountry(Country c) {
		
		String msg = dao.addCountry(c);
		if(Objects.isNull(msg)) {
			msg = "Country is not added";
		}
		return msg;
	}

	public String updateCountry(Country c,int id) {
		
		String msg = dao.updateCountry(c,id);
		if(Objects.isNull(msg)) {
			msg="Country is Not Updated";
		}
		return msg;
	}

	public String deleteCountry(int id) {
		
		String msg = dao.deleteCountry(id);
		if(Objects.isNull(msg)) {
			msg = "Country is deleted";
		}
		return msg;
	}

	public List<Country> getallCountry() {
		
		List<Country> list = dao.getallCountry();
		return list;
	}

	public Country getParticulerCountryById(int id) {
		Country con = dao.getParticulerCountryById(id);
		return con;
	}

	public String addEmployee(Employee emp) {
		String msg = dao.addEmployee(emp);
		if(Objects.isNull(msg)) {
			msg = "Employee Added Successfully";
		}
		return msg;
	}

	public String updateEmployee(Employee emp, long id) {
		String msg = dao.updateEmployee(emp,id);
		if(Objects.isNull(msg)) {
			msg="Employee is Not Updated";
		}
		return msg;
	}

	public String deleteEmployee(long id) {
		String msg = dao.deleteEmployee(id);
		if(Objects.isNull(msg)) {
			msg = "Employee is deleted";
		}
		return msg;
	}

	public List<Employee> getallEmployee() {
		List<Employee>list = dao.getallEmployee();
		return list;
	}

	public Employee getParticulerEmployeeById(long id) {
		Employee emp = dao.getParticulerEmployeeById(id);
		return emp;
	}

	public Map login(Employee emp) {
		Employee obj= dao.login(emp);
		Map map=new HashMap();
		if(Objects.isNull(obj)) {
			map.put("msg", "Invalid User");
			map.put("user", obj);
		}else {
			map.put("msg", "Valid User");
			map.put("user", obj);
		}
		
		return map;
	}

	public List<Employee> salaryRange(double startSal, double endSal) {
		List<Employee> list= dao.salaryRange(startSal,endSal);
		return list;
	}

}
