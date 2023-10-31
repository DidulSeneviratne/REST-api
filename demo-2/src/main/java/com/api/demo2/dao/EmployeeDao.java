package com.api.demo2.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.api.demo2.model.EmployeeModel;
import com.api.demo2.model.EmployeeResponse;
import com.api.demo2.rowmapper.EmployeeRowWrapper;

@Component
public class EmployeeDao {
	
	@Autowired
	public JdbcTemplate jdbc;
	
	public EmployeeResponse deleteEmployee(EmployeeModel model){
		EmployeeResponse res = new EmployeeResponse();
		try{
			String query = "delete from employee where id="+model.getId();
			int x = jdbc.update(query);
			if(x>0){
				res=getAllEmployees();
			} else{
				res.setStatus("Failed");
				res.setMessage("Unable to remove data");
			}
		}catch(Exception ex){
			res.setStatus("Failed");
			res.setMessage(ex.getMessage());
		}
		return res;
	}
	
	public EmployeeResponse updateEmployee(EmployeeModel model){
		EmployeeResponse res = new EmployeeResponse();
		try{
			String query = "update employee set salary='"+model.getSalary()+"' where id="+model.getId();
			int x = jdbc.update(query);
			if(x>0){
				res = getEmployeeId(model.getId());
			}else{
				res.setStatus("Failed");
				res.setMessage("Unable to update");
			}
		}catch(Exception ex){
			res.setStatus("Failed");
			res.setMessage(ex.getMessage());
		}
		return res;
	}
	
	public EmployeeResponse getEmployeeId(int id){
		EmployeeResponse res = new EmployeeResponse();
		try {
			String query = "select * from employee where id="+id;
			EmployeeRowWrapper empRowMapper = new EmployeeRowWrapper();
			List<EmployeeModel> empList = jdbc.query(query, empRowMapper);
			if(empList!=null&&empList.size()>0){
				res.setStatus("Success");
				res.setMessage("Data Found");
				res.setData(empList);
			}else{
				res.setStatus("Failed");
				res.setMessage("Data not found");
			}
		}catch(Exception ex){
			res.setStatus("Failed");
			res.setMessage(ex.getMessage());
		}
		return res;
		
	}
	
	public EmployeeResponse getAllEmployees(){
		EmployeeResponse res = new EmployeeResponse();
		try {
			String query = "select * from employee";
			EmployeeRowWrapper empRowMapper = new EmployeeRowWrapper();
			List<EmployeeModel> empList = jdbc.query(query, empRowMapper);
			if(empList!=null&&empList.size()>0){
				res.setStatus("Success");
				res.setMessage("Data Found");
				res.setData(empList);
			}else{
				res.setStatus("Failed");
				res.setMessage("Data not found");
			}
		}catch(Exception ex){
			res.setStatus("Failed");
			res.setMessage(ex.getMessage());
		}
		return res;
	}
	
	public EmployeeResponse saveEmployeeData(EmployeeModel model){
		EmployeeResponse res = new EmployeeResponse();
		try{
			String query="insert into employee(name,salary,department)value('"+model.getName()+"','"+model.getSalary()+"','"+model.getDepartment()+"')";
			int x = jdbc.update(query);
			if(x>0){
				res.setStatus("Success");
				res.setMessage("Data saved successfully");
			}else{
				res.setStatus("Failed");
				res.setMessage("Unable to save data");
			}
		}catch(Exception ex){
			res.setStatus("Failed");
			res.setMessage(ex.toString());
		}
		return res;
	}

}
