package com.api.demo2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.demo2.dao.EmployeeDao;
import com.api.demo2.model.EmployeeModel;
import com.api.demo2.model.EmployeeResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	public EmployeeDao dao;

	@Override
	public EmployeeResponse saveNewEmployee(EmployeeModel model) {
		// TODO Auto-generated method stub
		return dao.saveEmployeeData(model);
	}

	@Override
	public EmployeeResponse getAllEmployees() {
		// TODO Auto-generated method stub
		return dao.getAllEmployees();
	}

	@Override
	public EmployeeResponse getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return dao.getEmployeeId(id);
		
	}

	@Override
	public EmployeeResponse updateEmployeeSalary(EmployeeModel model) {
		// TODO Auto-generated method stub
		return dao.updateEmployee(model);
	}

	@Override
	public EmployeeResponse deleteEmployee(EmployeeModel model) {
		// TODO Auto-generated method stub
		return dao.deleteEmployee(model);
	}
	
}
