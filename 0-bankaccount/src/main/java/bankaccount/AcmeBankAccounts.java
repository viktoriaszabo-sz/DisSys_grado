package bankaccount;
import java.util.ArrayList;
import java.util.Random;


public class AcmeBankAccounts { 

	Random rand = new Random();
	
	 int balance = 0;  
	 String holder;  
	 int accountNumber;  
	 int idAccounts = 1; //First number account  to use 
	 static int BankBalance = 0; // Total bank balance 
	 int initialBalance = 0;

	 static ArrayList<AcmeBankAccounts> accounts = new ArrayList<>();
	 
    AcmeBankAccounts (String holder, int initialBalance) { 
    	 // Create a new bank account for a client holder with an initial balance >= 0 
        // it will assign to the bank account an idAccount 
        // To be coded by the student 
    	this.holder = holder; 
    	this.initialBalance = initialBalance;
    	this.balance = initialBalance;
    	BankBalance += this.balance; 
	    this.accountNumber = rand.nextInt(1000000000) + 100000000;
	    idAccounts++; 
	 // Add this instance to the accounts list
	    accounts.add(this);
    } 
    
    public static void printBankData() {
        // Print the total Balance of the bank and the current accounts.
        // To be coded by the student
    	System.out.println("Total Bank Balance: " + BankBalance);
        for (AcmeBankAccounts account : accounts) {
            System.out.println("Account Number: " + account.accountNumber + ", Balance: " + account.balance);
        }
    }
    
    public void  withdrawal (int amount) { 
    // For the current account, withdrawal the indicated amount 
    // Decrement also the Bank balance 
    // To be coded by the student 
    	int withdrawing = amount;
    	System.out.println("Withdrawing " + amount + " euros from your account."+"\nYour balance details are:");
    	System.out.println("Beginning balance: " + balance);
    	balance = balance - withdrawing;
    	BankBalance = BankBalance - withdrawing;
    	System.out.println("Withdrawn: " + withdrawing);
    	System.out.println("Current balance: " + balance);
    } 
    
    public void deposit(int amount) { 
    // To be coded by the student 
    	int deposit = amount;
    	System.out.println("Depositing " + amount + " euros into your account."+"\nYour balance details are:");
    	System.out.println("Beginning balance: " + balance);
    	balance = balance + deposit;
    	BankBalance = BankBalance + deposit;
    	System.out.println("Deposited: " + deposit);
    	System.out.println("Current balance: " + balance);
    } 
    
    public void transfer (AcmeBankAccounts destinationAccount, int amount) { 
        // Transfert the amount to the destination Account 
        // To be coded by the student 
    	
    	this.balance = this.balance - amount;
    	
    	destinationAccount.balance += amount;
    	
    	// and more line for the object who called the function
    } 
    
    public void printAccountData() { 
    // print the account number, holder and  account balance 
    // To be coded by the student 
    	System.out.println("Account number: " + this.accountNumber + "\nBank account holder's name: " + this.holder + "\nBalance: " + this.balance); 
    } 
    
    public static void main(String[] args) { 
    AcmeBankAccounts cJuan = new AcmeBankAccounts ("Juan", 2000); 
    AcmeBankAccounts cPepe = new AcmeBankAccounts ("Pepe", 3000); 
    cJuan.printAccountData(); 
    cPepe.printAccountData(); 
    cJuan.transfer(cPepe, 1000); 
    cJuan.printAccountData(); 
    cPepe.printAccountData();
    
    cPepe.withdrawal(100);
    cPepe.deposit(50);
    
   	AcmeBankAccounts.printBankData();
    } 
} 