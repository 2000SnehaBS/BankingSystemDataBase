package banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BankDb {
	public static Connection conn = null;
	public static Statement stmt = null;
	public static ResultSet rs = null;
	private static String url = "jdbc:mysql://localhost:3307/bankingsystem";
	private static String userName = "root";
	private static String passWord = "6dBs@8122000";
	
	public static void main(String[] args) {
		int ch = 0;
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		try {
			conn = DriverManager.getConnection(url,userName,passWord);
			stmt = conn.createStatement();
			
			while(true) {
				System.out.println("*********WELCOME************");
				System.out.println("Enter 1 to create new customer Account");
				System.out.println("Enter 2 DepositMoney");
				System.out.println("Enter 3 WithdrawMoney");
				System.out.println("Enter 4 to CloseAccount");
				System.out.println("Enter your choice");
				
				try {
					ch = sc1.nextInt();
				}
				catch(Exception e) {
					e.printStackTrace();
					main(args);
				}
				switch(ch) {
				case 1 :System.out.println("***Creating a new customer account***");
						System.out.println("Enter Customet ID");
						String customerid= sc2.nextLine();
						System.out.println("Enter the FirstName");
						String firstName = sc2.nextLine();
						System.out.println("Enter Username");	
						String username = sc2.nextLine();
						System.out.println("Enter Lastname");
						String lastName = sc2.nextLine();
						System.out.println("Enter the age");
						int age = sc1.nextInt();
						System.out.println("Enter the address");
						String address = sc2.nextLine();
						System.out.println("Enter mobile number");
						long mobileNumber = sc1.nextLong();
						System.out.println("Enter emialId");
						String eMailID = sc2.nextLine();
						System.out.println("Enter the date of birth");
						String dateofbirth = sc2.nextLine();
						System.out.println("Enter the Initial balance");
						int balance = sc1.nextInt();
						
						BankSystem.createCustomerAccount(customerid,firstName, username, lastName, age, address, mobileNumber,eMailID, dateofbirth, balance);
						break;
				
				case 2 :System.out.println("Enter Customer ID");
						String customerid1 = sc2.nextLine();
						System.out.println("Enter username");
						String username1 = sc2.nextLine();
						System.out.println("Enter amount");
						int amount = sc1.nextInt();
						BankSystem.depositMoney(customerid1,username1, amount);
								
						break;
					
				case 3 :System.out.println("enter Customer id");
						String id2 = sc2.nextLine();
						System.out.println("Enter username");
						String username2 = sc2.nextLine();
						System.out.println("Enter the amount to withdraw");
						int amount1 = sc1.nextInt();
						BankSystem.withDrawMoney(id2,username2, amount1);								
						break;
					 
				case 4 :System.out.println("Enter customer Id");
						String customerid2 = sc2.nextLine();
						BankSystem.closeAccount(customerid2);
								
						break;
					
						default : System.out.println("Please enter the valid input");
						
					}
				}
				
				
				
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
}
