package com.zensar;


import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.bean.Employee;

public class EmployeeController extends HttpServlet {
	

		public void doGet(HttpServletRequest request, HttpServletResponse response) {
		String requestAction = request.getParameter("requestAction");
		if(requestAction.equalsIgnoreCase("viewAll")) {
		System.out.println("I am inside doGet() method now...");
		EmployeeRepository employeeRepository = new EmployeeRepository();
		List<Employee> listOfAllEmployees = employeeRepository.getAllEmployees();
		System.out.println("listOfAllEmployees:"+listOfAllEmployees);
		RequestDispatcher rd = request.getRequestDispatcher("viewAllEmployees.jsp");
		request.setAttribute("listOfAllEmployees", listOfAllEmployees);
		try {
		rd.forward(request, response);
		}catch(Exception e) {
		System.out.println("Exception Occured:"+e);
		}
		}
		else if(requestAction.equalsIgnoreCase("delete")) {
			// code for employee deletion
			System.out.println("We are going to delete an employee");
			/*EmployeeRepository employeeRepository = new EmployeeRepository();
			int employeeid = Integer.parseInt(request.getParameter("employeeid"));
			employeeRepository.deleteEmployee(employeeid);
		
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			try {
			rd.forward(request, response);
			}catch(Exception e) {
			System.out.println("Exception Occured:"+e);*/
			}
			}
		

		 public void doPost(HttpServletRequest request, HttpServletResponse response) {
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String employeeName = request.getParameter("employeeName");
		String designation = request.getParameter("designation");
		int salary = Integer.parseInt(request.getParameter("salary"));
		String gender = request.getParameter("gender");
		System.out.println("employeeId:"+employeeId);
		System.out.println("employeeName:"+employeeName);
		System.out.println("designation:"+designation);
		System.out.println("salary:"+salary);
		EmployeeRepository employeeRepository = new EmployeeRepository();
		Employee employee = new Employee(employeeId, employeeName, designation, salary, gender);
		employeeRepository.addEmployee(employee);
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		try {
		rd.forward(request, response);
		}catch(Exception e) {
		System.out.println("Exception Occured:"+e);
		}
		}

       }