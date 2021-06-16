package poscopy;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {

	public static Connection mycon(){
		 
		 
	     Connection con = null ;
	     
	     try {
	         
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","root","Mysql@@123");
	         return con;
	         
	         
	     } catch (ClassNotFoundException | SQLException e) {
	         
	         System.out.println(e);
	         return null;
	     }
	     
	 
	 
	 }   

}
