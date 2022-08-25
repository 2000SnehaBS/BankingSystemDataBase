package com.java.bankingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BankingSystemDataBase {
	
	private static Connection connection = null;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		BankingSystemDataBase db = new BankingSystemDataBase();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String dbURL = "jdbc:mysql://localhost:3307/bankdb";
			String username = "root";
			String password = "6dBs@8122000";
			
			connection = DriverManager.getConnection(dbURL, username, password);
			System.out.println("Enter your choice");
		    System.out.println("Enter 1 for Creating Customer Account");
		    System.out.println("Enter 2 for Login");
		    int choice = Integer.parseInt(sc.nextLine());
		    
		   switch (choice) {
		case 1:
			 
			db.CreatingCustomerAccount();
			
			break;
		case 2:
			System.out.println("   ");
			break;

		default:System.out.println("Please enter the valid number");
			break;
		}
		   
		    
		}
        catch(Exception e) {
        	throw new RuntimeException("Something went wrong");
        }
	}
	
	public void CreatingCustomerAccount () throws SQLException{
		
		String sql = "insert into customer_details(First_Name,User_Name,Age,Address,Mobile_Number,E_Mail_ID,Date_Of_Birth,Account_No, Avail_Balance) values (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareCall(sql);
		
		System.out.println("Enter the FirstName");
		preparedStatement.setString(1, sc.nextLine());
		
		System.out.println("Enter the Username");
		preparedStatement.setString(2, sc.nextLine());
		
		System.out.println("Enter the LastName");
		preparedStatement.setString(3, sc.nextLine());
		
		System.out.println("Enter the Age");
		preparedStatement.setInt(4,Integer.parseInt(sc.nextLine()));
		
		System.out.println("Enter the Address");
		preparedStatement.setString(5, sc.nextLine());
		
		System.out.println("Enter the Mobile Number");
		preparedStatement.setString(6, sc.nextLine());
		
		System.out.println("Enter the EmialId");
		preparedStatement.setString(7, sc.nextLine());
		
		System.out.println("Enter the Date Of Birth");
		preparedStatement.setString(8, sc.nextLine());
		
		System.out.println("Enter the Account Numner");
		preparedStatement.setInt(9,Integer.parseInt(sc.nextLine()));
		
		System.out.println("Enter the Deposit Amount");
		preparedStatement.setDouble(10,Integer.parseInt(sc.nextLine()));
		
		int rows = preparedStatement.executeUpdate();
		if(rows>0) {
			System.out.println("Successfully completed");
		}
		
	
	}

}
