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
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private static Logger logger=Logger.getLogger(EditServlet2.class.getName());
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in edit servlet2");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String empid=request.getParameter("id");
		int id=Integer.parseInt(empid);
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String designation=request.getParameter("designation"); 
		System.out.println("in salary start");
		Float salary=(float) Float.parseFloat(request.getParameter("salary"));
		System.out.println("out edit end+salary");
		Employees emp=new Employees();
		emp.setId(id);
		emp.setName(name);
		emp.setPassword(password);
		emp.setDesignation(designation);
		emp.setSalary(salary);
		
		// GeekUsersDao.update method is called
		// along with the modified values for geekUser
		//logger.info("editservlet2 called");
		int status=EmployeesDao.update(emp);
		//logger.info("saved and updated the employee details ");
		if(status>0){
			response.sendRedirect("ViewServlet");
		}else{
		//	logger.error("unable to upate record");
			//out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}
