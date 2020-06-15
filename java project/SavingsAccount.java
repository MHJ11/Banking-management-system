public class SavingsAccount extends Account{
	public double interestRate;
	public void setInterestRate(double rate){
		this.interestRate=rate;
	}
	public double getInterestRate( ){
		return this.interestRate;
	}
	
	public void showInfo( ){
		
		System.out.println("Account Number: "+getAccountNumber());
		System.out.println("Balance: "+this.getBalance());
		System.out.println("Account Type: Savings Account "+"\n"+"Interest Rate: "+this.interestRate+"\n");
	}
}