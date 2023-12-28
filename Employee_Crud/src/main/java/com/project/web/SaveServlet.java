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
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	//private static Logger logger=Logger.getLogger(SaveServlet.class.getName());
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
						HttpServletResponse response)
		throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Getting all the request parameters from
		// index.html
		String name = request.getParameter("name");
	String password = request.getParameter("password");
	    
		String designation = request.getParameter("designation");
        Float salary=(float) Integer.parseInt(request.getParameter("salary"));
				
                
		// GeekUsers object is created
		Employees emp = new Employees();

		// Collected parameters like name, numberOfPosts and
		// technologiesPreferred are set for the object so
		// that it can be retrieved in other places
		emp.setName(name);
		emp.setPassword(password);
		emp.setDesignation(designation);
		emp.setSalary(salary);
			

		// Calling save method in GeekUsersDao by passing
		// geekUser
		int status = EmployeesDao.add(emp);

		// This is possible when the record is saved
		// successfully
		if (status > 0) {
			//logger.info("record saved successfully");
			//out.print("<p>Record saved successfully!</p>");

			request.getRequestDispatcher("index.html")
				.include(request, response);
		}
		else {
			// If there is an issue in saving the record, we
			// need to show this message
			//logger.error("unable to save the record");
			//out.println("Sorry! unable to save record");
		}

		out.close();
	}
}
