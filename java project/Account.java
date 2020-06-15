public abstract class Account implements ITransactions{
	protected int accountNumber;
	protected double balance;
	void setAccountNumber(int number){
		this.accountNumber=number;
	}
	public void setBalance(double bal){
		this.balance=bal;
	}
	public int getAccountNumber( ){
		return this.accountNumber;
	}
	public double getBalance( ){
		return this.balance;
	}
	abstract void showInfo( );
	
//IT transactions

public void deposit(double amount){
	double addedBalance=0;
	if(amount>0){
		addedBalance=this.getBalance()+amount;
		this.setBalance(addedBalance);
		System.out.println("Successfully Deposited");
	}
	else System.out.println("Invalid Amount");
		
}

public void withdraw(double amount){
	double subbedBalance=0;
	if(amount<=this.getBalance() && amount>0){
		subbedBalance=this.getBalance()-amount;
		this.setBalance(subbedBalance);
		System.out.println("Successfully Withdrawn");
		}
	else System.out.println("Invalid Amount");
}
public void transfer(Account a, double amount){
	System.out.println(this.getBalance());
	System.out.println(amount);
	if(this.getBalance()>=amount){
		this.withdraw(amount);
		a.deposit(amount);
		System.out.println("Transfer Succesfull");
	}
}

}