package com.api.demo2.model;

import java.util.List;

public class EmployeeResponse {
	private String status;
	private String message;
	private List<EmployeeModel> data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<EmployeeModel> getData() {
		return data;
	}
	public void setData(List<EmployeeModel> data) {
		this.data = data;
	}
	
}
