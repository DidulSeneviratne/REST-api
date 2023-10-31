package com.api.demo2.service;

import com.api.demo2.model.EmployeeModel;
import com.api.demo2.model.EmployeeResponse;

public interface EmployeeService {
	
	public EmployeeResponse saveNewEmployee(EmployeeModel model);
	public EmployeeResponse getAllEmployees();
	public EmployeeResponse getEmployeeById(int id);
	public EmployeeResponse updateEmployeeSalary(EmployeeModel model);
	public EmployeeResponse deleteEmployee(EmployeeModel model);

}
