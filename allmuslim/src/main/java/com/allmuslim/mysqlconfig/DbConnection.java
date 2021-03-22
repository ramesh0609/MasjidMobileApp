package com.allmuslim.mysqlconfig;

import java.sql.Connection;
import java.sql.DriverManager;



public class DbConnection {
	
	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
		
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/allmuslim?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		Class.forName(driver);
		con=DriverManager.getConnection(url,"root","root");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		if(con!=null)
		{
			System.out.println("connection success");
		}else
		{
			System.out.println("connection failed");
			
		}
		
		return con;
	}
	
	/* */ 
}
