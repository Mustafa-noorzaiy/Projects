package BankDao;

public class BankAccount {
	private int accountNumber;
	private double blance;
	private String firstName;
	private String lastName;
	private String email;
	private long phoneNumber;
	private double deposit;
	private double withdraw;


	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {

		String s = String.valueOf(accountNumber);
		if (s.matches("[0-9]+")) {
			this.accountNumber = accountNumber;
		} else {
			System.out.println("please enter only numbers");
		}
	}

	public double getBlance() {
		return blance=deposit-withdraw;
	}
	public void setBlance(double blance) {
		this.blance = blance;
		if(blance<0) {
			System.out.println("You don't have enough money");
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName.contains("123456789!@#$%^&*()")) {
			System.out.println("Name should be only letters");
		} else {
			this.firstName = firstName;
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName.contains("123456789!@#$%^&*()")) {
			System.out.println("Name should be only letters");
		} else {
			this.lastName = lastName;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
		int a[] = new int[10];
		for (int i = 0; i < 10; i++) {
			if (a[i] < 0 || a[i] > 9) {
				System.out.println("Wrong input");
			}
		}
	}

	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit+blance;
	}

	public double getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
		
		if (withdraw < 1) {
			System.out.println("You have: " + blance + "You need to deposit in order to take it");
		}
	}

	public void recipt() {
		System.out.println("Dear " + firstName + " and your blance is: " + blance);
	}

	public void info() {
		System.out.println(firstName + " " + accountNumber + " " + blance + " " + email + " " + " " + phoneNumber);
		
	
		}

	
}


