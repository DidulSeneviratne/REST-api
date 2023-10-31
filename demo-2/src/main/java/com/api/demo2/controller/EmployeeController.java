package com.api.demo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.demo2.model.EmployeeModel;
import com.api.demo2.model.EmployeeResponse;
import com.api.demo2.service.EmployeeService;

import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping("/save")
	public EmployeeResponse saveEmployee(@RequestBody EmployeeModel model){
		return service.saveNewEmployee(model);
	}
	
	@GetMapping("/getall")
	public EmployeeResponse getAllEmployee(){
		return service.getAllEmployees();
	}
	
	@GetMapping("/byid/{id}")
	public EmployeeResponse getEmpById(@PathVariable("id")int id){
		return service.getEmployeeById(id);
	}
	
	@GetMapping("/byid_queryparam")
	public EmployeeResponse getEmpByIdQueryParam(@PathParam("id")int id){
		return service.getEmployeeById(id);
	}
	
	@PutMapping("/update")
	public EmployeeResponse updateEmployeeSalary(@RequestBody EmployeeModel model){
		return service.updateEmployeeSalary(model);
	}
	
	@DeleteMapping("/delete")
	public EmployeeResponse deleteEmployee(@RequestBody EmployeeModel model){
		return service.deleteEmployee(model);
	}
	
}
