package com.project.web;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.log4j.Logger;

import com.project.dao.EmployeesDao;
import com.project.model.Employees;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private static Logger logger = Logger.getLogger(EditServlet.class.getName());
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update Employee</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		//logger.info("EditServlet called for employee ID: " + id);
	
		// We need to get the id from view servlet
		// request and it has to be parsed with
		// Integer.parseInt in order to get as number
		// Then specific user is retrieved by means 
		// of GeekUsersDao.getGeekUsersById(id)
		Employees e=EmployeesDao.getEmployeessById(id);
		//logger.info("Employee with ID " + id + " edited successfully.");
		
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
		out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPassword()+"'/></td></tr>");
		out.print("<tr><td>Designation:</td><td><input type='text' name='designation' value='"+e.getDesignation()+"'/></td></tr>");
		out.print("<tr><td>Salary:</td><td><input type='digit' name='salary' value='"+e.getSalary()+"'/></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}
