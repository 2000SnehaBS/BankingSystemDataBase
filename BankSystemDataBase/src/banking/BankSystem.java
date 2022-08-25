package banking;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankSystem{
	static ResultSet rs = null;
	public static void createCustomerAccount(String id, String firstName, String username, String lastName, String age, String address, String mobileNumber, String eMailId, String dateofbirth, String balance) {
		try {
			String sql ="insert into customer(id,first_name,user_name,last_name,age,address,mobile_number,email_id,date_of_birth,balance) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = BankDb.conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, firstName);
			stmt.setString(3, username);
			stmt.setString(4, lastName);
			stmt.setString(5, age);
			stmt.setString(6, address);
			stmt.setString(7, mobileNumber);
			stmt.setString(8, eMailId);
			stmt.setString(9,dateofbirth);
			stmt.setString(10, balance);
			int rowsSelected = stmt.executeUpdate();
			if(rowsSelected>0) {
				System.out.println(" Account created successfully");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			main(args);
		}
	}
}
