package stored_procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class inparam {

	public static void main(String[] args) {
		
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Aksh@123");
			CallableStatement cs=con.prepareCall("call inparam(?,?,?)");
			
			cs.setInt(1, 102);
			cs.setString(2,"james");
			cs.setDouble(3,0.1);
			cs.executeUpdate();
		}
		catch (Exception e) 
        { 
            System.out.println(e); 
        }  
			
		}
	}


