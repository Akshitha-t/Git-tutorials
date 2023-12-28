
package com.project.web;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;
//import java.util.Locale;
//import java.util.ResourceBundle;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.log4j.Logger;

import com.project.dao.EmployeesDao;
import com.project.model.Employees;

/**
 * Servlet implementation class ViewServlet
 */

@WebServlet("/ViewServlet")

public class ViewServlet extends HttpServlet {
	

//private static Logger logger=Logger.getLogger(ViewServlet.class.getName());
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		   
		response.setContentType("text/html");
		PrintWriter printWriter=response.getWriter();
		printWriter.println("<a href='index.html'>Add New Employee</a>");
		printWriter.println("<h1>Employees List</h1>");
		//logger.info("employees list");
		List<Employees> list=EmployeesDao.getAllEmployees();
		
		printWriter.print("<table border='1' bordercolor='#009879' width='50%'");
		printWriter.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Designation</th><th>Salary</th><th>Edit</th><th>Delete</th></tr>");
		for(Employees e:list){
			// each row is identified by means of its id
			// hence on click of 'edit', it is sent as
			// <a href='EditServlet?id="+e.getId()+"'>edit</a>
			// on click of 'delete', it is sent as
			// <a href='DeleteServlet?id="+e.getId()+"'>delete</a>
			printWriter.print("<tr><td >"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td><td>"+e.getDesignation()+"</td><td>"+e.getSalary()+"<td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");
		}
		printWriter.print("</table>");
		
		printWriter.close();
	}
}