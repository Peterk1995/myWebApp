package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// setup connection variables
		String user = "springstudent"; //user id
		String pass = "springstudent"; //sql scripts created this
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.jdbc.Driver";
		
		// get connection to database
		// Setup try because things could go wrong
		try { 
			PrintWriter out = response.getWriter();
			
			out.println("CONNECTING TO DATABASE: PLEASE WAIT! " + jdbcUrl);
			
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			out.println("Connection success");
			
			myConn.close();
			
			
			
		} catch(Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}
		
		
		
		
	}

}
