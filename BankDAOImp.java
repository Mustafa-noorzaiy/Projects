package BankDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BankDAOImp implements BankDAO{

	BankAccount ba = new BankAccount();
	
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    final String DB_URL = "jdbc:mysql://mustafadb.c1iscnoqfqrd.us-west-2.rds.amazonaws.com:3306/myDB?verifyServerCertificate=false&useSSL=true";
    final String USER = "admin";
    final String PASS = "Herat040";
    
    Connection conn = null;

    Scanner sc = new Scanner(System.in);
    
   
	@Override
	public void get() {
		System.out.println(ba.getAccountNumber() +" "+ba.getFirstName()+ "  "+ ba.getLastName());
		ba.info();
		
	}
	
	@Override
	public void update() {
		System.out.println("This feature is under maintenance please check later");
	}

	@Override
	public void delete() {
		try {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	System.out.println("Connecting to database...");
	     
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      Statement stmt = conn.createStatement();
		
		      String sql = "DELETE FROM BANK2 WHERE AccountNumber=123";
		      stmt.executeUpdate(sql);
		      
		      System.out.println("You have successfully deleted your account");
			
		} catch (SQLException | ClassNotFoundException e) {
			((Throwable) e).printStackTrace();
		}
		
	}

	@Override
	public void create() {
		try {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	System.out.println("Connecting to database...");
	     
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      Statement stmt = conn.createStatement();
		
		       String sql = "CREATE TABLE BANK2 " +
	                  "(AccountNumber INTEGER not NULL, " +
	                  " FirstName VARCHAR(255), " + 
	                  " LastName VARCHAR(255), " + 
	                  " Phone INTEGER,"+
	                  " Email VARCHAR(255))";
		       
		      stmt.executeUpdate(sql);
		      
		      System.out.println("Created table in given database...");
			
		} catch (SQLException | ClassNotFoundException e) {
			((Throwable) e).printStackTrace();
		}
		
	}
	

	public void call() {
	
		System.out.println("***** Welcome to Bank ***** \n Enter 1 to AWS database \n 2 to delete data from Database \n 3 to Get information \n 4 to update  \n"
				+ "9 to Exit");
		System.out.println("Enter 5 for Current Customer to start Banking");
			int cr = sc.nextInt();
			if (cr == 1) {
				create();
				call();
			}

			else if (cr == 2) {
				delete();
				call();
			} else if (cr == 3) {
				get();
				call();
			} else if (cr == 4) {
				update();
				call();
			}
			
			else if (cr==5) {
			System.out.println("Please Enter your Account Number Then Press Enter");

			int AccountNumber = sc.nextInt();
			ba.setAccountNumber(AccountNumber);

			System.out.println("Enter Your Name");
			String firstName = sc.next();
			ba.setFirstName(firstName);

			System.out.println("Enter Your Last Name ");
			String lastName = sc.next();
			ba.setLastName(firstName);

			System.out.println("Register your Email Address");
			String email = sc.next();
			ba.setEmail(email);

			System.out.println("Enter your phone Number");
			int phone = sc.nextInt();
			ba.setPhoneNumber(phone);

			System.out.println("How much you want to deposit");
			int deposit = sc.nextInt();
			ba.setDeposit(deposit);

			System.out.println("Enter amount you want to cash back");
			int withdraw = sc.nextInt();
			ba.setWithdraw(withdraw);

			System.out.println("Your balance is: ");
			System.out.println(ba.getBlance());
			}
			else if (sc.nextInt()==9) {
				System.out.println("Thanks for your visiting BYE !!!");
			}
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Connecting to database...");
				
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				
				
				
			Statement stmt = conn.createStatement();
			PreparedStatement pst = conn.prepareStatement(
					"insert into BANK(AccountNumber,firstName,lastName,email,phone,deposit,withdraw,balance) values(?,?,?,?,?,?,?,?)");

			pst.setLong(1, ba.getAccountNumber());
			pst.setString(2, ba.getFirstName());
			pst.setString(3, ba.getLastName());
			pst.setString(4, ba.getEmail());
			pst.setLong(5, ba.getPhoneNumber());
			pst.setLong(6, (long) ba.getDeposit());
			pst.setLong(7, (long) ba.getWithdraw());
			pst.setLong(8, (long) ba.getBlance());

			int i = pst.executeUpdate();
			if (i != 0) {
				System.out.println("Data has successfully added in database");
			} else {
				System.out.println("failed to add data");
			}}
		
		
		catch (Exception e) {
			System.out.println(e);
		}
	call();
	}
	
	
	
	
	
	
	}


