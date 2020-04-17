package com;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.JDBCConnection;
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name = req.getParameter("name");
		String emailId = req.getParameter("emailId");
		String phoneNo = req.getParameter("phoneNo");
		String userName=req.getParameter("userName");
		String password=req.getParameter("password");
		System.out.println("AKS query name "+name);
		String msg="";
		//msg="<h1>Account created successfull<br/>"+ name+ emailId +phoneNo + userName;
		try {
			Connection con = JDBCConnection.getConnection();
			Statement stmt = con.createStatement();
			String query = "insert into userDetail (name, emailId, phoneNo, userName, password) values ("
					+"'"+ name + "'"+","+"'" + emailId + "'"+"," + phoneNo
					+ ","+ "'" +userName+ "'"+","+"'" +  password+"'" +")";
			System.out.println("AKS query "+query);
			int result = stmt.executeUpdate(query);
			System.out.println("AKS "+ result);
			if(result == 1) {
				msg="<h1>Account created successfull<br/>";
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.forward(req, resp);
				return;
			} else {
				msg="<h1>Signup Failed<br/>";
				Writer out=resp.getWriter();
				out.write(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*Writer out=resp.getWriter();
		out.write(msg);*/
	}
}
