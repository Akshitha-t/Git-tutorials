package stored_procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class emptable_stored {

	public static void main(String[] args) {
		
        try
        { 
           Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Aksh@123"); 
            CallableStatement cs=con.prepareCall("{call update_emp_sal(?,?)}"); 
            cs.setInt(1,103); 
            cs.setDouble(2,0.1); 
            cs.executeUpdate(); 
           
        } 
        
        catch (Exception e) 
        { 
            System.out.println(e); 
        } 
        

}
	
}
	
