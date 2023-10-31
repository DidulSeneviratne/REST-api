package com.api.demo2.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.api.demo2.model.EmployeeModel;

public class EmployeeRowWrapper implements RowMapper<EmployeeModel> {

	@Override
	public EmployeeModel mapRow(ResultSet rs, int rowNum)throws SQLException{
		EmployeeModel model = new EmployeeModel();
		model.setId(rs.getInt("id"));
		model.setName(rs.getString("name"));
		model.setSalary(rs.getInt("salary"));
		model.setDepartment(rs.getString("department"));
		return model;
	}

}
