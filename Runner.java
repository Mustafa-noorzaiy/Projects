package BankDao;

import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		BankAccount ba = new BankAccount();
		BankDAOImp imp = new BankDAOImp();
		Scanner sc = new Scanner(System.in);
		imp.call();
			
	}
		
}