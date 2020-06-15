public class Customer implements AccountOperations{
	private String name;
	private int nid;
	public int totalAccounts=0,maximumAccounts=10;
	Account accounts[]=new Account[maximumAccounts];
	
	public void setName(String customerName){
		this.name=customerName;
	}
	
	public void setNid(int customerNid){
		this.nid=customerNid;
	}
	public String getName(){
		return this.name;
	}
	
	public int getNid(){
		return this.nid;
	}

//Account Operations
	public void insertAccount(Account a){
		
		if(totalAccounts<maximumAccounts){
			accounts[totalAccounts++]=a;
			System.out.println("Account Succesfully Inserted");
		}
		else System.out.println("Too many Accounts");
		
	}
	public void removeAccount(Account a){
		int index=0;
		boolean found=false;
		for(int i=0;i<totalAccounts;i++){
			if(accounts[i]==a){
				index=i;
				found=true;
				break;
			}
		}
		if(found){
			for(int i=index;i<totalAccounts-1;i++)
				accounts[i]=accounts[i+1];
			totalAccounts--;
			System.out.println("Account removed\n");
		}
		else System.out.println("Account not found\n");
	}
	
	
	public Account getAccount(int number){
		int i;
		for( i=0;i<totalAccounts;i++){
			if(accounts[i].accountNumber==number){
				break;
			}
		}
		return accounts[i];
	}
	
	
	
	public void showAllAccounts( ){
		
		
		for(int i=0;i<totalAccounts;i++){
			System.out.println("Account Number:"+accounts[i].getAccountNumber( ));
			System.out.println("Account Balance:"+accounts[i].getBalance( )+"\n");
		}
	}
}
