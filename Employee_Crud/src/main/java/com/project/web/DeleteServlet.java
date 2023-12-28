package com.project.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.log4j.Logger;

import com.project.dao.EmployeesDao;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private static Logger logger = Logger.getLogger(DeleteServlet.class.getName());  
	protected void doGet(HttpServletRequest request,
						HttpServletResponse response)
		throws ServletException, IOException
	{
		String empid = request.getParameter("id");
		int id = Integer.parseInt(empid);
		
	//	logger.info("DeleteServlet called for employee ID: " + id);
		  
		// GeekUsersDao.delete method is called with the
		// corresponding id and then it is redirected to
		// viewservlet
		EmployeesDao.delete(id);
		//logger.info("Employee with ID " + id + " deleted successfully.");
		
		response.sendRedirect("ViewServlet");
	}
}

