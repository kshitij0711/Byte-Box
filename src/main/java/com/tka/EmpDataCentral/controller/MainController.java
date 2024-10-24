package com.tka.EmpDataCentral.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.EmpDataCentral.entity.Country;
import com.tka.EmpDataCentral.entity.Employee;
import com.tka.EmpDataCentral.service.MainService;

@RestController
@RequestMapping("api")
public class MainController {
		
		@Autowired
		MainService service;
	
		@PostMapping("addcountry")
		public ResponseEntity<String> addCountry(@RequestBody Country c) {
			String msg = service.addCountry(c);
			return ResponseEntity.ok(msg);
		}
		
		@PutMapping("updatecountry/{id}")
		public ResponseEntity<String> updateCountry(@RequestBody Country c,@PathVariable int id){
			String msg = service.updateCountry(c,id);
			return ResponseEntity.ok(msg);
			
		}
		
		@DeleteMapping("deleteCountry/{id}")
		public ResponseEntity<String> deleteCountry(@PathVariable int id){
			String msg = service.deleteCountry(id);
			return ResponseEntity.ok(msg);
			
		}
		
		@GetMapping("getallcountry")
		public ResponseEntity<List<Country>> getallCountry(){
			
			List<Country> list = service.getallCountry();
			return ResponseEntity.ok(list);
		}
		
		@GetMapping("getcountrybyid/{id}")
		public ResponseEntity<Country> getParticulerCountryById(@PathVariable int id){
			Country con = service.getParticulerCountryById(id);
			return ResponseEntity.ok(con);
			
		}
		
		@PostMapping("addemp")
		public ResponseEntity<String> addEmployee(@RequestBody Employee emp){
			
			String msg = service.addEmployee(emp);
			return ResponseEntity.ok(msg);
		}
		
		@PutMapping("updateemp/{id}")
		public ResponseEntity<String> updateEmployee(@RequestBody Employee emp,@PathVariable long id){
			String msg = service.updateEmployee(emp,id);
			return ResponseEntity.ok(msg);
		}
		
		@DeleteMapping("deleteemp/{id}")
		public ResponseEntity<String> deleteEmployee(@PathVariable long id){
			String msg = service.deleteEmployee(id);
			return ResponseEntity.ok(msg);
		}
		
		@GetMapping("getallemp")
		public ResponseEntity<List<Employee>> getallEmployee(){
			
			List<Employee> list = service.getallEmployee();
			return ResponseEntity.ok(list);
		}
		
		@GetMapping("getemployeebyid/{id}")
		public ResponseEntity<Employee> getParticulerEmployeeById(@PathVariable long id){
			Employee emp  = service.getParticulerEmployeeById(id);
			return ResponseEntity.ok(emp);
		}
		
		@PostMapping("login")
		public ResponseEntity<Map> login(@RequestBody Employee emp) {
			Map map= service.login(emp);
			return ResponseEntity.ok(map);
		}
		
		@GetMapping("salaryRange/{startSal}/{endSal}")
		public ResponseEntity<List<Employee>> salaryRange(@PathVariable double startSal,@PathVariable double endSal){
			List<Employee> list=service.salaryRange(startSal,endSal);
			return ResponseEntity.ok(list);
		}
}
