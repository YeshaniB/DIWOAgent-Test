package emolyee;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class empForm_DBUtil {
	private static final int CONSTANT_6 = 6;

	private static final int CONSTANT_5 = 5;

	private static final int CONSTANT_4 = 4;

	private static final int CONSTANT_3 = 3;

	private static final String CONSTANT_1234 = "1234";

	
	private static boolean success;
	String url = "jdbc:mysql://localhost:3306/laund";
	String user = "root";
	String pass = CONSTANT_1234;
	
	public static boolean insert(String name, String email, String phone, String u_name,String pwd) {
		return extracted_insert(name, email, phone, u_name, pwd);
	}

	private boolean extracted_insert(String name, String email, String phone, String u_name,String pwd) {
		
		String url = "jdbc:mysql://localhost:3306/laund";
		String user = "root";
		String pass = "1234";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, pass);
			
            Statement stmt = conn.createStatement();
			
			String sql="insert into employee values ('"+ name +"','"+ email +"','"+ phone +"','"+ u_name +"','"+ pwd+"',0)";
			int rs = stmt.executeUpdate(sql);
			
			if (rs > 0)
			{
                success = true;
            }
			else 
            {
            	success = false;
            }
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return success;
		}




public static List<employee> validate1(String fname) {
	return extracted_validate1(fname);
}

private List<employee> extracted_validate1(String fname) {
	ArrayList<employee> emp = new ArrayList<>();
	
	//boolean success;
	String url = "jdbc:mysql://localhost:3306/laund";
	String user = "root";
	String pass = "1234";
	
	try 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url,user,pass);
		Statement stmt = conn.createStatement();
		
        String sql = "select * from employee where name = '"+fname+"'";
        ResultSet rs = stmt.executeQuery(sql);
        
        if (rs.next())
		{
            String name = rs.getString(1);
            String email = rs.getString(2);
            String phone = rs.getString(CONSTANT_3);
            String uname = rs.getString(CONSTANT_4);
            String pwd = rs.getString(CONSTANT_5);
            String id = rs.getString(CONSTANT_6);
            
            employee c = new employee(name, email, phone,  uname, pwd, id);
            emp.add(c);
        }
		else 
        {
        	success = false;
        }
        
	}
	
	catch (Exception e)
	{
		e.printStackTrace();
	}
	
	return emp;
	}


//delete

public static boolean delete(String name) {
	return extracted_delete(name);
}

private boolean extracted_delete(String name) {
	
	//create database connection
	
	String url = "jdbc:mysql://localhost:3306/laund";
	String user = "root";
	String pass = "1234";
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);
		
		Statement stmt = con.createStatement();
		
		String sql = "delete from employee where name ='"+ name +"'";
		int results = stmt.executeUpdate(sql);
		
		if(results > 0 ) {
            success = true;
        }
		
		else {
			success = false;
		}
		
		
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	
	
	return success;
}
//update
public static boolean update(String name, String email, String phone, String uname, String pwd) {
	return extracted_update(name, email, phone, uname, pwd);
}

private boolean extracted_update(String name, String email, String phone, String uname, String pwd) {
	 
	String url = "jdbc:mysql://localhost:3306/laund";
	String user = "root";
	String pass = "1234";
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);
		
		Statement stmt = con.createStatement();
		
		String sql = "update employee set name ='"+ name +"',email='"+email+"',phone='"+phone+"', uname='"+uname+"',pwd='"+pwd+"' where name ='"+name+"'";
		int results = stmt.executeUpdate(sql);
		
		if(results > 0 ) {
            success = true;
        }
		
		else {
			success = false;
		}
		
		
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	
	
	return success;
}
}




