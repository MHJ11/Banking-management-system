public class Employee {
	public String name, empId;
	public double salary;
	public int totalEmployee=0,maximumEmployee=0;
	
	public void setName(String empName){
		this.name=empName;
	}
	public void setId(String id){
		this.empId=id;
	}
	public void setSalary(double sal){
		this.salary=sal;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getId(){
		return this.empId;
	}
	public double getSalary(){
		return this.salary;
	}
	
	/*public void insertEmployee(Employee e){
		if(totalEmployee<maximumEmployee){
			accounts[totalAccounts++]=a;
			System.out.println("Account Succesfully Inserted");
		}
		else System.out.println("Too many Accounts");
	}
	public void removeEmployee(Employee e);
	public Employee getEmployee(int empId);
	public void showAllEmployees( );
	
	*/
}