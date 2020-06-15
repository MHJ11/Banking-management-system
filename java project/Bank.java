public class Bank implements CustomerOperations,EmployeeOperations{
	public int totalCustomers=0,maximumCustomers=1000;
	public int totalEmployee=0,maximumEmployee=100;
	Customer customers[]=new Customer[maximumCustomers];
	Employee employees[]=new Employee[maximumEmployee];
	
	
	//Customer OPerations
	public void insertCustomer(Customer c){
		if(totalCustomers<maximumCustomers)
			customers[totalCustomers++]=c;
		else System.out.println("Too many customers\n");
	}
	
	public void removeCustomer(Customer c){
		int index=0;
		boolean found=false;
		for(int i=0;i<totalCustomers;i++){
			if(customers[i]==c){
				index=i;
				found=true;
				break;
			}
		}
		if(found){
			for(int i=index;i<totalCustomers-1;i++)
				customers[i]=customers[i+1];
			totalCustomers--;
			System.out.println("Customer removed\n");
		}
		else System.out.println("Customer not found\n");
	}
	
	public Customer getCustomer(int id){
		int i;
		for( i=0;i<totalCustomers;i++){
			if(customers[i].getNid()==id){
				break;
			}
			if(i==totalCustomers-1)
				break;
		}
		return customers[i];
	}
	
	public	void showAllCustomers( ){
		
		for(int i=0;i<totalCustomers;i++){
			System.out.println("Name:"+customers[i].getName()+"\n"+"NID:"+customers[i].getNid()+"\n");
		}
	}
	
	
	//Employee Operations
	
	public void insertEmployee(Employee e){
		if(totalEmployee<maximumEmployee){
			employees[totalEmployee++]=e;
			System.out.println("Employee Succesfully Inserted");
		}
		else System.out.println("Too many Employees");
	}
	
	public void removeEmployee(Employee e){
		int index=0;
		boolean found=false;
		for(int i=0;i<totalEmployee;i++){
			if(employees[i]==e){
			
				
				index=i;
				found=true;
				break;
			}
		}
		if(found){
			for(int i=index;i<totalEmployee-1;i++)
				employees[i]=employees[i+1];
			totalEmployee--;
			System.out.println("Employee removed\n");
		}
		else System.out.println("Employee not found\n");
	}
		
	public Employee getEmployee(String empId){
		int i;
		boolean val=false;
		for( i=0;i<totalEmployee;i++){
			
			if(employees[i].getId().equals(empId)){
				
				break;
				
				
			}
		}
		return employees[i];
		
	}
	public  void showAllEmployees( ){
		int i;
		for( i=0;i<totalEmployee;i++){
			System.out.println("Employee Name:"+employees[i].getName()+ "\nEmployee Id: "+employees[i].getId());
			}
		}
	}
	
	
