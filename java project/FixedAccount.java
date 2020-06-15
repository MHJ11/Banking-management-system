public class FixedAccount extends Account{
	public int tenureYear;
	public void setTenureYear(int year){
		this.tenureYear=year;
	}
	public int getTenureYear( ){
		return this.tenureYear;
	}
	
	
	public void showInfo( ){
		System.out.println("Account Number: "+getAccountNumber());
		System.out.println("Balance: "+this.getBalance());
		System.out.println("Account Type: Fixed Account");
		System.out.println("Tenure Year: "+this.getTenureYear());
	}
}