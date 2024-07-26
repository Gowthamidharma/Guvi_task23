package task23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mysql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// connect to Database with url, username,password
		String db_url ="jdbc:mysql://localhost:3306";
		String user ="root";
		String password="root";
		//establish connection using connection interface 
		try {
			Connection connection=DriverManager.getConnection(db_url, user, password);
		// 	validate connection
		if(connection!=null) {
			System.out.println("Connection sucessful");
			
		}else {
			System.out.println("Connection unsucessful");
			
		}
		//  perform operation using statment interface
		Statement stmt= connection.createStatement();
		String createDB = "create database employee_details";
		String useDB= "use employee_details";
		String createTable ="create table empl_details(empcode int, empname varchar(20),empage int, esalary int)";
		String insert ="insert into empl_details values(101,'Jenny',25,10000),(102,'Jacky',30,20000),(103,'Joe',20,40000),(104,'John',40,80000),(105,'Shameer',25,90000)";
		String select= "select * from empl_details ";
		
		// using select class with condition
		
		// condition 1
		//String select= "select * from empl_details where esalary<80000";
		
		//condition 2
		//String select = "select empname,empage from empl_details where empage<30";
		
		stmt.execute(createDB);
		stmt.execute(useDB);
		stmt.execute(createTable);
		stmt.executeUpdate(insert);
		
		
		//retrieve the data with resultset interface 
		
		ResultSet rSet =stmt.executeQuery(select);
		 
		 // iterate and print the db for select with condition and without condition			
			
		while(rSet.next()) { 
			System.out.println(rSet.getInt("empcode")+ "   "+rSet.getString("empname") + "   " +rSet.getInt("empage") + "  " +rSet.getInt("esalary"));
			  
		}
			 
				// iterate for the condition 2 and print only the empname and empage	
				
				/*
				 * while (rSet.next()) { System.out.println(rSet.getString("empname")+ "  "
				 * +rSet.getInt("empage")); }
				 */
		 	 
		 // close connection
		 
		 connection.close();
		 		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
;
