package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.JDBCConnection;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName=req.getParameter("username");
		String password=req.getParameter("password");
	
		String msg="";
		try {
			String query = "select * from userDetail where userName = ? and password = ?";
			PreparedStatement pstmt = JDBCConnection.getConnection().prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			ResultSet rset = pstmt.executeQuery();
			System.out.println(rset);
			if(rset != null && rset.next()) {
				RequestDispatcher r=req.getRequestDispatcher("learningQSP.html"); 
				r.forward(req, resp);
				//msg="<href>https://www.javatpoint.com/servlet-tutorial</href>";
			} else {
				msg="<h1>Login Failed <br/>Entered Invalid Username or Password";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * Writer out=resp.getWriter(); out.write(msg);
		 */
	}

}
