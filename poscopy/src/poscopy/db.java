package poscopy;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {

	public static Connection mycon(){
		 
		 
	     Connection con = null ;
	     
	     try {
	         
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         con = DriverManager.getConnection("jdbc:mysql://15.206.117.96:3306/sampledb","azeeb","Mysql@@123");
	         return con;
	         
	         
	     } catch (ClassNotFoundException | SQLException e) {
	         
	         System.out.println(e);
	         return null;
	     }
	     
	 
	 
	 }   

}
