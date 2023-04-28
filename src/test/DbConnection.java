package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbConnection extends UserInput {
	
	static String name;
	
	static String pdname = UserInputSearch();
	
	public String selectstatment() throws SQLException, ClassNotFoundException {
		
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");

		Statement stmt = con.createStatement();

		ResultSet result = stmt.executeQuery("select * from amazonprd where name = "+ pdname);

		while (result.next()) {

			System.out.println("Product Id " + result.getInt("ID"));
			System.out.println("Product name " + result.getString("name"));
			String productname = result.getString("name");
			if(productname.equalsIgnoreCase(pdname)) {
				 name = productname;
			}else {
				System.out.println("No search results");
			}
			
		
		con.close();
		
		}
		return name;
	}

	}

	
