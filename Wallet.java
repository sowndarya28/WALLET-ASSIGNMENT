package Wallet;

public abstract class Wallet {

	public Wallet() {
		// TODO Auto-generated constructor stub
	}
	
	private int walletNumber;
	protected double balance;
	
	public Wallet(int walletNumber) {
		super();
		this.walletNumber = walletNumber;
		this.balance = 0;
	}

	public int getWalletNumber() {
		return walletNumber;
	}

	public double getBalance() {
		return balance;
	}

	public abstract void deposit(double amount);
	public abstract void withdraw(double amount);
	public abstract double chkbalance(int accountNumber);
	
	
// A bank account can only increase or decrease its balance using withdraw and deposit and hence there is no set balance method
//hence no setter
}
