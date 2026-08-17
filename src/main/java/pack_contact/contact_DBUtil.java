package pack_contact;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class contact_DBUtil {
	private static final int CONSTANT_5 = 5;

	private static final int CONSTANT_4 = 4;

	private static final int CONSTANT_3 = 3;

	private static final String CONSTANT_1234 = "1234";

	
	private static boolean success;
	String url = "jdbc:mysql://localhost:3306/contact";
	String user = "root";
	String pass = CONSTANT_1234;
	
	public static List<contact> validate(String fname) {
		return extracted_validate(fname);
	}

	private List<contact> extracted_validate(String fname) {
		ArrayList<contact> cont = new ArrayList<>();
		
		String url = "jdbc:mysql://localhost:3306/contact";
		String user = "root";
		String pass = "1234";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,pass);
			Statement stmt = conn.createStatement();
			
            String sql = "select * from inquiry where name = '"+fname+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            if (rs.next())
			{
                String name = rs.getString(1);
                String email = rs.getString(2);
                String mobile = rs.getString(CONSTANT_3);
                String message = rs.getString(CONSTANT_4);
                String id = rs.getString(CONSTANT_5);
                
                contact c = new contact(name, email, mobile, message, id);
                cont.add(c);
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
		
		return cont;
		}
	
	public static boolean insert(String name, String email, String mobile, String message) {
		return extracted_insert(name, email, mobile, message);
	}

	private boolean extracted_insert(String name, String email, String mobile, String message) {
		
		String url = "jdbc:mysql://localhost:3306/contact";
		String user = "root";
		String pass = "1234";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, pass);
			
            Statement stmt = conn.createStatement();
			
			String sql="insert into inquiry values ('"+ name +"','"+ email +"','"+ mobile +"','"+ message +"',0)";
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
	
	public static boolean update(String name, String email, String mobile, String message) {
		return extracted_update(name, email, mobile, message);
	}

	private boolean extracted_update(String name, String email, String mobile, String message) {
		
		String url = "jdbc:mysql://localhost:3306/contact";
		String user = "root";
		String pass = "1234";
		
		try 
        {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, pass);
			
            Statement stmt = conn.createStatement();
			
			String sql="update inquiry set name = '"+ name +"', email='"+email+"', mobile='"+mobile+"', message='"+message+"' where name = '"+name+"'";
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
	
	public static boolean delete(String name) {
		return extracted_delete(name);
	}

	private boolean extracted_delete(String name) {
		
		String url = "jdbc:mysql://localhost:3306/contact";
		String user = "root";
		String pass = "1234";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, pass);
			
            Statement stmt = conn.createStatement();
			
			String sql="delete from inquiry where name = '"+ name +"'";
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
}
