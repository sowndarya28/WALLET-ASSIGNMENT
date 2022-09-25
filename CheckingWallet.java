package Wallet;

public class CheckingWallet extends Wallet  {
	//transaction fee
	// this amount will be deducted on every transaction on this account
	
	
	

	public CheckingWallet(int accountNumber) {
		// TODO Auto-generated constructor stub
		super(accountNumber);
		
	}

	@Override
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		if(amount>0) {
			balance+=amount;
			System.out.println("The current amount deposited is"+amount);
			System.out.println("The current balance after deposit"+balance);
			
		}
		else
		{
			System.out.println("Negative balance cannot be deposited");
			
		}
	}
		
	

	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		if(amount>0)
		{
			if(amount<=balance)
			balance-=amount;
			System.out.println("The current amount withdrawn is"+amount);
			System.out.println("The current balance after withdrawal"+balance);
			
			
		}
		else
		{
			System.out.println("Negative amount cant be withdrawn");
		}
		
	}

	@Override
	public double chkbalance(int accountNumber) {
		// TODO Auto-generated method stub
		System.out.println(balance);
		return balance;
	}

}
