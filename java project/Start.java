import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
public class Start{
	public static void main(String[] args){
		
		
		
		
		
		Bank Ab=new Bank();
		
		int option;
		Scanner scan=new Scanner(System.in);
		boolean x=true;
		
		while(x){
		System.out.println("1. Employee Management  \n2. Customer Management  \n3. Customer Account Management  \n4. Account Transactions  \n5. Exit");
		
		option=scan.nextInt();
		
		switch(option){
			case 1:
				employeeManagement(Ab);
				break;
			case 2:
				customerManagement(Ab);
				break;
			case 3:
				customerAccountManagement(Ab);
				break;
			case 4:
				accountTransactions(Ab);
				break;
			case 5:
				x=false;
				break;
			default:
			System.out.println("Invalid Input.Please Try again");
			break;
			
		}
		}
		
		
		
		
	}
	
	
	
	public static void employeeManagement(Bank a){
		System.out.println("1. Insert New Employee \n2. Remove Existing Employee \n3. Show All Employees");
		Scanner scan=new Scanner(System.in);
		int choice=scan.nextInt();
		
		double salary;
		String name,id;
		
		Employee e=new Employee();
		switch(choice){
			case 1:
			try{
			FileWriter fout=new FileWriter("employee.txt",true);
			
			
			System.out.println("Employee Name:");
			name=scan.next();
			e.setName(name);
			fout.write(name+" ");
			
			System.out.println("Employee ID:");
			id=scan.next();
			e.setId(id);
			fout.write(id+" ");
			
			System.out.println("Employee Salary:");
			salary=(double)scan.nextInt();
			e.setSalary(salary);
			fout.write( Double.toString(salary)+"\n");
			a.insertEmployee(e);
			
			fout.close();
			break;
			}
			
			catch(FileNotFoundException E)
		{
			System.out.println("File not Found Exception");
		}
		
		catch(IOException E)
		{
			System.out.println("IOException");
		}
			
			
			case 2:
			if(a.totalEmployee==0){
			System.out.println("There are no Employees inside Bank");
			break;
		}
			
			System.out.println("Employee ID:");
			id=scan.next();
			e=a.getEmployee(id);
			if(e.getId().equals(id))
				a.removeEmployee(e);
			
			else	System.out.println("Employee not found\n");
				
			 
			break;
			case 3:
			a.showAllEmployees( );
			break;
			
		}
	}
	
	public static void customerManagement(Bank a){
		
		System.out.println("1. Insert New Customer \n2. Remove Existing Customer \n3. Show All Customer");
		Scanner scan=new Scanner(System.in);
		int choice=scan.nextInt();
		
		String name;
		int nid;
		
		Customer c=new Customer();
		switch(choice){
			case 1:
			try{
			
			FileWriter fout=new FileWriter("customer.txt",true);			
				
			System.out.println("Customer Name:");
			name=scan.next();
			c.setName(name);
			fout.write(name+" ");
			
			System.out.println("Customer NID:");
			nid=scan.nextInt();
			c.setNid(nid);
			fout.write(Integer.toString(nid)+"\n");
			fout.close();
			
			a.insertCustomer(c);
			break;
			}
			
			catch(FileNotFoundException E)
		{
			System.out.println("File not Found Exception");
		}
		
		catch(IOException E)
		{
			System.out.println("IOException");
		}
			
			
			case 2:
			if(a.totalCustomers==0){
				System.out.println("There are no Customers inside Bank");
				break;
			}
			System.out.println("Customer NID:");
			nid=scan.nextInt();
			c=a.getCustomer(nid);
			if(c.getNid()!=nid)
				System.out.println("Customer not found\n");
			else a.removeCustomer(c);
			break;
			case 3:
			a.showAllCustomers( );
			break;
			
		}
		}
	
	public static void customerAccountManagement(Bank b){
		System.out.println("1.Insert New Account \n2.Remove Existing Account \n3.Show All Accounts");
	
	Scanner scan=new Scanner(System.in);
		int choice=scan.nextInt();
		
		String name;
		int accountNumber,tenureYear,type,nid;
		double balance,interestRate;
		Account a;
		Customer c=new Customer();
		
		switch(choice){
			case 1:
			try{
			FileWriter fout=new FileWriter("account.txt",true);
			
			System.out.println("Customer NID:");
			nid=scan.nextInt();
			c=b.getCustomer(nid);
			if(c.getNid()!=nid){
				System.out.println("Customer not found\n");
				break;
			}
			System.out.println("1.Savings Account \n2.Fixed Account");
			type=scan.nextInt();
			if(type==1){
			SavingsAccount s=new SavingsAccount();
			
			
		    System.out.println("Account Number:");
			accountNumber=scan.nextInt();
			s.setAccountNumber(accountNumber);
			fout.write(Integer.toString(accountNumber)+" ");
			
			System.out.println("Account Balance:");
			balance=scan.nextDouble();
			s.setBalance(balance);
			fout.write(Double.toString(balance)+" ");
			
			System.out.println("Interest Rate:");
			interestRate=scan.nextDouble();
			s.setInterestRate(interestRate);
			fout.write(Double.toString(interestRate)+"%"+"\n");
			
			fout.close();
			
			c.insertAccount(s);
		} 
			if(type==2){
			FixedAccount f=new FixedAccount();
			
		
		    System.out.println("Account Number:");
			accountNumber=scan.nextInt();
			f.setAccountNumber(accountNumber);
			fout.write(Integer.toString(accountNumber)+" ");
			
			System.out.println("Account Balance:");
			balance=scan.nextDouble();
			f.setBalance(balance);
			fout.write(Double.toString(balance)+" ");
			
			System.out.println("Tenure Year:");
			tenureYear=scan.nextInt();
			f.setTenureYear(tenureYear);
			fout.write(Integer.toString(tenureYear)+"\n");
			c.insertAccount(f);
			
			fout.close();
			}
			}
			
			catch(FileNotFoundException E)
		{
			System.out.println("File not Found Exception");
		}
		
		catch(IOException E)
		{
			System.out.println("IOException");
		}
			
			break;
			
			
			case 2:
			if(b.totalCustomers==0){
				System.out.println("There are no Customers inside Bank");
				break;
			}
			System.out.println("Customer ID:");
			nid=scan.nextInt();
			c=b.getCustomer(nid);
			if(c.getNid()!=nid){
				System.out.println("Customer not found\n");
				break;
			}
			System.out.println("Account Number:");
			accountNumber=scan.nextInt();
			a=c.getAccount(accountNumber);
			if(a.getAccountNumber()!=accountNumber){
				System.out.println("Account Not Found\n");
			break;
			}
			c.removeAccount(a);
			break;
			case 3:
			System.out.println("Customer NID:");
			nid=scan.nextInt();
			c=b.getCustomer(nid);
			if(c.getNid()!=nid){
				System.out.println("Customer not found\n");
				
			break;
			}
			c.showAllAccounts();
			break;
	
	}
	}
	
	public static void accountTransactions(Bank b){
		System.out.println("1.Deposit Money \n2.Withdraw Money \n3.Transfer Money");
		Scanner scan=new Scanner(System.in);
		int choice=scan.nextInt();
		int nid,accountNumber;
		double amount;
		
		Customer c=new Customer();
		Account a;
		Account a2;
		switch(choice){
			case 1:
			if(b.totalCustomers==0){
				System.out.println("There are No Customers In Bank");
			    break;
			}
			System.out.println("Customer NID:");
			nid=scan.nextInt();
			c=b.getCustomer(nid);
			
			if(c.totalAccounts==0){
				System.out.println("Customer Has No Accounts");
			    break;
			}
			
			System.out.println("Customer Account Number:");
			accountNumber=scan.nextInt();
		
			a=c.getAccount(accountNumber);
			
			
			System.out.println("Deposit Amount:");
			amount=scan.nextDouble();
			
			try{
				a.deposit(amount);
			}
			catch(NullPointerException x){
				System.out.println("Customer Does Not Own This Account");
				
				
			}
			break;
			
			
			case 2:
			if(b.totalCustomers==0){
				System.out.println("There are No Customers In Bank");
			    break;
			}
			System.out.println("Customer NID:");
			nid=scan.nextInt();
			c=b.getCustomer(nid);
			
			if(c.totalAccounts==0){
				System.out.println("Customer Has No Accounts");
			    break;
			}
			
			System.out.println("Customer Account Number:");
			accountNumber=scan.nextInt();
			a=c.getAccount(accountNumber);
			
			System.out.println("Withdraw Amount:");
			amount=scan.nextDouble();
			
			a.withdraw(amount);
			
			break;
			case 3:
			if(b.totalCustomers==0){
				System.out.println("There are No Customers In Bank");
			    break;
			}
			System.out.println("Customer NID:");
			nid=scan.nextInt();
			c=b.getCustomer(nid);
			
			if(c.totalAccounts==0){
				System.out.println("Customer Has No Accounts");
			    break;
			}
			
			
			System.out.println("Your Account Number:");
			accountNumber=scan.nextInt();
			a=c.getAccount(accountNumber);
			
			
			System.out.println("Deposit Customer NID:");
			nid=scan.nextInt();
			c=b.getCustomer(nid);
			
			if(c.totalAccounts==0){
				System.out.println("Customer Has No Accounts");
			    break;
			}
			
			
			System.out.println("Deposit Account Number:");
			accountNumber=scan.nextInt();
			a2=c.getAccount(accountNumber);
			
			
			System.out.println("Transfer Amount:");
			amount=scan.nextDouble();
			
			a.transfer(a2,amount);
			
			break; 
			
			
			
	}
}
}
