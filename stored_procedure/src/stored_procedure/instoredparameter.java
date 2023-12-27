package stored_procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class instoredparameter {

	public static void main(String[] args)  throws Exception{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Aksh@123");
		CallableStatement stmt=con.prepareCall("{call status_info()}");
		//stmt.setInt(1, 3);
		
		ResultSet rs=stmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
			
		}
		con.close();
	 
		

	}

}
