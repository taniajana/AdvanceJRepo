package com.zensar.utility;
import java.sql.*;

public class DButil {

	public static Connection getMySqlDbConnection() {
		
		
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/java_traning";
		String dbusername = "root";
		String dbpassword = "root@123";
		Connection con = null;
		try {
		Class.forName(driverClassName);
		con = DriverManager.getConnection(url, dbusername, dbpassword);

		 }catch(Exception e) {
		System.out.println("Exception while creating db connection:"+e);
		}
	
	return con;	
	}
}

