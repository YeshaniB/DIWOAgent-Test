package pack_customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class customer_DBUtil {
	private static final int CONSTANT_8 = 8;

	private static final int CONSTANT_7 = 7;

	private static final int CONSTANT_6 = 6;

	private static final int CONSTANT_5 = 5;

	private static final int CONSTANT_4 = 4;

	private static final int CONSTANT_3 = 3;

	private static final String CONSTANT_1234 = "1234";

	
	private static boolean success;
	String url = "jdbc:mysql://localhost:3306/project";
	String user1 = "root";
	String pass = CONSTANT_1234;
	
	public static boolean insert(String name, String address, String email, String mobile, String nic, String user, String password) {
		return extracted_insert(name, address, email, mobile, nic, user, password);
	}

	private boolean extracted_insert(String name, String address, String email, String mobile, String nic, String user, String password) {
		
		String url = "jdbc:mysql://localhost:3306/project";
		String user1 = "root";
		String pass = "1234";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user1, pass);
			
            Statement stmt = conn.createStatement();
			
			String sql="insert into customer values ('"+name+"','"+address+"','"+email+"','"+mobile+"','"+nic+"','"+user+"','"+password+"',0)";
			int rs = stmt.executeUpdate(sql);
			
			if (rs > 0)
			{
                success = true;
            }
			else 
            {
            	success = true;
            }
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return success;
		}
	
	
	
	public static List<customer> validate(String fname) {
		return extracted_validate(fname);
	}

	private List<customer> extracted_validate(String fname) {
		ArrayList<customer> cus = new ArrayList<>();
		
		//boolean success;
		String url = "jdbc:mysql://localhost:3306/project";
		String user = "root";
		String pass = "1234";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,pass);
			Statement stmt = conn.createStatement();
			
            String sql = "select * from customer where name = '"+fname+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            if (rs.next())
			{
                String name = rs.getString(1);
                String address = rs.getString(2);
                String email = rs.getString(CONSTANT_3);
                String mobile = rs.getString(CONSTANT_4);
                String nic = rs.getString(CONSTANT_5);
                String user1 = rs.getString(CONSTANT_6);
                String password = rs.getString(CONSTANT_7);
                String id = rs.getString(CONSTANT_8);
                
                customer c = new customer(name,address, email, mobile, nic, user1, password, id);
                cus.add(c);
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
		
		return cus;
		}
	
	
	public static boolean delete_servlet(String fname) {
		return extracted_delete_servlet(fname);
	}

	private boolean extracted_delete_servlet(String fname) {
		
		boolean isSuccess = false;
		
		//create database connection
		
		String url = "jdbc:mysql://localhost:3306/project";
		String user = "root";
		String pass = "1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			
			String sql = "delete from customer where name='"+fname+"'";
															
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
		
		
		return isSuccess;
		}
	/*update eka...........*/
	public static boolean update_Servelet(String name,String address,String email,String mobile,String nic,String username,String password) {
		return extracted_update_Servelet(name, address, email, mobile, nic, username, password);
	}

	private boolean extracted_update_Servelet(String name,String address,String email,String mobile,String nic,String username,String password) {
		boolean success = false;
		
		/*int convId = Integer.parseInt(name);*/
		
		
		
		String url = "jdbc:mysql://localhost:3306/project";
		String user = "root";
		String pass = "1234";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "update customer set name= '"+name+"', address= '"+address+"', email= '"+email+"', mobile= '"+mobile+"',nic= '"+nic+"', user= '"+username+"', password= '"+password+"' where name= '"+name+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if (rs > 0) {
				success = true;
			}
			
			else {
				success = false;
			}
			
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return success;
		
		
		}
		
		

	
}
