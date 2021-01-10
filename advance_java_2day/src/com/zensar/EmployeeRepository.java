package com.zensar;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zensar.bean.Employee;
import com.zensar.utility.DButil;

public class EmployeeRepository {

	public void addEmployee(Employee emp) {
		Connection con = DButil.getMySqlDbConnection();
		String sql = "insert into employee values(?,?,?,?,?)";

		try {
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setInt(1,emp.getEmployeeid());
	        pst.setString(2, emp.getEmployeename());
	        pst.setString(3, emp.getDesignation());
	        pst.setInt(4, emp.getSalary());
	        pst.setString(5,emp.getGender());
	        int result = pst.executeUpdate();
	        if(result==0) {
	            System.out.println("Database Operation Failed");
	        }else {
	            System.out.println("Database Operation Successful");
	        }
	        }catch(Exception e) {
	            System.out.println("Exception Occured:"+e);
	        }
	}
	public List<Employee> getAllEmployees(){
		List<Employee> listOfAllEmployees = new ArrayList<Employee>();
	
		Connection con =DButil.getMySqlDbConnection();
		String sql="select * from employee";
		try {
		PreparedStatement pst=con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
		int employeeId = rs.getInt("employee_id");
		String employeeName = rs.getString("employee_name");
		String designation = rs.getString("designation");
		int salary = rs.getInt("salary");
		String gender = rs.getString("gender");
		Employee employee = new Employee(employeeId, employeeName, designation, salary, gender);
		listOfAllEmployees.add(employee);
		}
		}catch(Exception e) {
		System.out.println("Exception Occured:"+e);
		}
		System.out.println("listOfAllEmployees:"+listOfAllEmployees);
		
				return listOfAllEmployees;
		}
	public void deleteEmployee(int employeeid) {
			Connection con = DButil.getMySqlDbConnection();
			String sql = "delete from employee where employee_id=?";
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setInt(1, employeeid);
				int result = pst.executeUpdate();
				if (result == 0) {
					System.out.println("Deletion Failed");
				} else {
					System.out.println("Deletion Successful");
				}
			} catch (Exception e) {
				System.out.println("Exception Occured:" + e);
			}
		}
		
	}




