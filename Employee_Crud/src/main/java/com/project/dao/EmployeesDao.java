package com.project.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



//import org.apache.log4j.Logger;

import com.project.model.Employees;

public class EmployeesDao {
	private static String jdbcURL = "jdbc:mysql://localhost:3306/crud";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "Aksh@123"; 
   // BasicConfigurator.configure();
 // private static Logger logger = Logger.getLogger(EmployeesDao.class.getName());  
   // private static final Logger logger = Logger.getLogger(EmployeesDao.class.getName());

    public static Connection getConnection(){
        Connection con=null;        
        try {
             // This is the way of connecting MySQL
        	
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            System.out.println("Message.. " + e.getMessage());
            e.printStackTrace();            
        } catch (ClassNotFoundException e) {
            System.out.println("Message.. " + e.getMessage());
            e.printStackTrace();
        }        
        return con;
    }
    // Rest of the methods like Save,
    // Update, Delete etc., should come here

public static List<Employees> getAllEmployees()
{
	List<Employees> list = new ArrayList<Employees>();

	try {
		Connection con = EmployeesDao.getConnection();
		//logger.info("Selecting all employees from the database");
		PreparedStatement ps = con.prepareStatement("select * from Employees");
			
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Employees emp = new Employees();
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setPassword(rs.getString(3));
			emp.setDesignation(rs.getString(4));
			emp.setSalary(rs.getFloat(5));
			list.add(emp);
		}
		con.close();
	}
	catch (Exception e) {
		//logger.error("An error occurred while getting all employees", e);
		e.printStackTrace();
	}

	return list;
}
public static int add(Employees emp)
{
	int status = 0;
	try {
		Connection con = EmployeesDao.getConnection();
		// Using PreparedStatement, we can execute any SQL
		// statement In order to save the record, we need to
		// insert the details in 'geekusers' table "e" is an
		// object of type "GeekUsers" which exactly resembles
		// geekusers table From html page, the values has
		// been passed to a servlet and from there, this
		// method is called
		//logger.info("inserting employees into the database");
		PreparedStatement ps = con.prepareStatement(
			"insert into Employees(name,password,designation,salary) values (?,?,?,?)");
		ps.setString(1, emp.getName());
		ps.setString(2, emp.getPassword());
		ps.setString(3, emp.getDesignation());
		ps.setFloat(4, emp.getSalary());

		status = ps.executeUpdate();

		con.close();
	}
	catch (Exception ex) {
		System.out.println("Message.." + ex.getMessage());
		ex.printStackTrace();
	}

	return status;
}
public static int update(Employees emp)
{
	int status = 0;
	try {
		Connection con = EmployeesDao.getConnection();
		// AS we are not sure about what fields need to be
		// updated, we are setting for all the fields by
		// means of update query This will update the record
		// for the corresponding geekUserId
		//logger.info("updating employees to the database");
		PreparedStatement ps = con.prepareStatement(
			"update employees set name=?,password=?,designation=?,salary=? where Id=?");
		ps.setString(1, emp.getName());
		ps.setString(2, emp.getPassword());
		ps.setString(3, emp.getDesignation());
		ps.setFloat(4, emp.getSalary());
		ps.setInt(5, emp.getId());

		status = ps.executeUpdate();

		con.close();
	}
	catch (Exception ex) {
		//logger.debug("An error occurred while getting all employees", ex);
	
		ex.printStackTrace();
	}

	return status;
}
public static int delete(int id)
{
	int status = 0;
	try {
		Connection con = EmployeesDao.getConnection();
		// delete query is given to delete the record for
		// the given geekUserId
	//	logger.info("deleting the employees from database");
		PreparedStatement ps = con.prepareStatement(
			"delete from employees where Id=?");
		ps.setInt(1, id);
		status = ps.executeUpdate();
		con.close();
	}
	catch (Exception e) {
	//	logger.error("An error occurred while deleting employees",e);
		e.printStackTrace();
	}

	return status;
}
public static Employees getEmployeessById(int id)
{
	Employees emp = new Employees();

	try {
		Connection con = EmployeesDao.getConnection();
		// We are getting the details for a specific user
		// and hence the query has to be sent in the below
		// way
	//	logger.info("selecting all the employees from database");
		PreparedStatement ps = con.prepareStatement(
			"select * from Employees where Id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setPassword(rs.getString(3));
			emp.setDesignation(rs.getString(4));
			emp.setSalary(rs.getFloat(5));
		}
		con.close();
	}
	catch (Exception ex) {
	//	logger.error("An error occurred while getting all employees",ex);
		ex.printStackTrace();
	}

	return emp;
}

}




