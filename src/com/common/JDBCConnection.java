package com.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;
import com.sun.istack.internal.logging.Logger;

public class JDBCConnection  {
	Logger logger = Logger.getLogger(getClass());
	
	static Connection con=null;
	static Statement stmt=null;
	static ResultSet rs=null;
	static String url = "jdbc:mysql://localhost:3306/Raushan";;
	static String userName = "root";
	static String password = "abhishek";
	
	
	public static Connection  getConnection() {
		
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection(url,userName,password);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
