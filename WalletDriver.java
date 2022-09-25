package Wallet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class WalletDriver {

	 public static void main(String [] args)throws SQLException {
		//String dbURL ="jdbc:oracle:thin:@localhost:1521:xe";
			//String username = "system";
			//String password ="12345";
			
			
			//Connection conn = DriverManager.getConnection(dbURL,username,password);
			//System.out.println("connected to db successfully");
			
				
			
		
			
			//Statement stmt = conn.createStatement();
			//System.out.println("Inserting records into the table..."); 
			

	        Scanner keyboard = new Scanner(System.in);
	        
	        // Create array of Accounts
	        Wallet accounts [] = new Wallet[10];
	        int numAccounts = 0; 

	        int choice;

	        do {
	            choice = menu(keyboard);
	            System.out.println();
	            
	            if(choice == 1) {
	                accounts[numAccounts++] = createAccount(keyboard);
	            } else if(choice == 2) {
	                doDeposit(accounts, numAccounts, keyboard);
	            } else if(choice == 3) {
	                doWithdraw(accounts, numAccounts, keyboard);
	            } 
	            else if(choice==4)
	            {
	            	doChkBalance(accounts, numAccounts, keyboard);
	            }
	             else {
	                System.out.println("GoodBye!");
	            }
	            System.out.println();
	        } while(choice != 5);
	    }
	   
	    public static int searchAccount(Wallet accounts [], int count, int walletNumber) {

	        for(int i=0; i<count; i++) {
	            if(accounts[i].getWalletNumber() == walletNumber) {
	                return i;
	            }
	        }

	        return -1; 
	    }

	    /**
	     * Function to perform Deposit on a selected account
	     */
	    public static void doDeposit(Wallet accounts [], int count, Scanner keyboard) {
	        // Get the account number
	        System.out.print("\nPlease enter account number: ");
	        int accountNumber = keyboard.nextInt();

	        // search for account
	        int index = searchAccount(accounts, count, accountNumber);

	        if(index >= 0) {
	            // Amount
	            System.out.print("Please enter Deposit Amount: ");
	            double amount = keyboard.nextDouble();

	            accounts[index].deposit(amount);
	        } else {
	            System.out.println("No account exist with AccountNumber: " + accountNumber);
	        }
	    }

	    public static void doWithdraw(Wallet accounts [], int count, Scanner keyboard) {
	        // Get the account number
	        System.out.print("\nPlease enter account number: ");
	        int accountNumber = keyboard.nextInt();

	        // search for account
	        int index = searchAccount(accounts, count, accountNumber);

	        if(index >= 0) {
	            // Amount
	            System.out.print("Please enter Withdraw Amount: ");
	            double amount = keyboard.nextDouble();
	            accounts[index].withdraw(amount);
	        } else {
	            System.out.println("No account exist with AccountNumber: " + accountNumber);
	        }
	    }
	    
	    public static void doChkBalance(Wallet accounts [], int count, Scanner keyboard) {
	        // Get the account number
	        System.out.print("\nPlease enter account number: ");
	        int accountNumber = keyboard.nextInt();

	        // search for account
	        int index = searchAccount(accounts, count, accountNumber);

	        if(index >= 0) {
	           
	            System.out.println("balance is: " + accounts[index].chkbalance(accountNumber));
	        }
	    }

	    

	    /**
	     * Function to create a new Account
	     */
	    public static Wallet createAccount(Scanner keyboard) {

	        Wallet wallet = null; 
	    

	        int accountNumber;
	        System.out.print("Enter Account Number: ");
	        accountNumber = keyboard.nextInt();

	        
	            wallet = new CheckingWallet(accountNumber);
	        
	        return wallet;
	    }

	    /**
	     * Menu to display options and get the user's selection
	     * 
	     * @param keyboard
	     * @return choice
	     */
	    public static int menu(Scanner keyboard) {
	        System.out.println("Bank Account Menu");
	        System.out.println("1. Create New Account");
	        System.out.println("2. Deposit Funds");
	        System.out.println("3. Withdraw Funds");
	        System.out.println("4. Check balance");
	        System.out.println("5. Quit");

	        int choice;

	        do {
	            System.out.print("Enter choice: ");
	            choice = keyboard.nextInt();
	        } while(choice < 1 || choice > 5);

	        return choice;
	    
	 }
}
