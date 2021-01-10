package com.zensar.bean;

public class Employee {

	private int employeeid;
	private String employeename;
	private String designation;
	private int salary;
	private String gender;
	
	public Employee() {
		
	}

	public Employee(int employeeid, String employeename, String designation, int salary, String gender) {
		super();
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.designation = designation;
		this.salary = salary;
		this.gender = gender;
	}

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", employeename=" + employeename + ", designation=" + designation
				+ ", salary=" + salary + ", gender=" + gender + "]";
	}
	
	
	
}
