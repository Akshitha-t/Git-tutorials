package stored_procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class outparam {

	public static void main(String[] args) throws SQLException {
		   try {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Aksh@123");
		CallableStatement cs=con.prepareCall("call inout_param(?)");
		cs.registerOutParameter(1,Types.INTEGER);
		cs.setInt(1, 2);
		cs.execute();
		System.out.println("counter:"+ cs.getInt(1));

	}
		   catch (Exception e){
			   System.out.println(e);
		   }
			   
		   }
	

}
