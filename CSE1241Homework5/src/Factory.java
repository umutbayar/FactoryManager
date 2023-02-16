/*In the last class factory class, I created the name variable 
 * to hold the factory name, the employees variable to hold the employees, the storage area 
 * variable to hold the storage area of ​​the factory, the payroll variable for payment,
the itemprice variable for the value of each item. To access them, I created the get and set method.
name =Umut Surname=Bayar Number=150120043
 */
import java.util.Arrays;

public class Factory {

    private String name;
    private Employee[] employees;
    private Storage storage;
    private Payroll[] payrolls;
    private double itemPrice;

    public Factory(String name, int capacity, double itemPrice) {
    	Storage storage = new Storage(capacity);
    	
    	this.storage = storage;
        this.name = name;
        this.itemPrice = itemPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void setPayrolls(Payroll[] payrolls) {
        this.payrolls = payrolls;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getName() {
        return name;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public Storage getStorage() {
        return storage;
    }

    public Payroll[] getPayrolls() {
        return payrolls;
    }

    public double getItemPrice() {
        return itemPrice;
    }
    public double getRevenue(){
        Item[] arr = storage.getItems();
        if (arr == null) {
        	return 0;
        } else {
        	double revenue = arr.length * itemPrice;
            return revenue;
        }
    }
    public double getPaidSalaries(){
    	double totalSalaries = 0;
    	for (int i = 0; i < this.payrolls.length; i++) {
    		totalSalaries = totalSalaries + this.payrolls[i].calculateSalary();
    	}
    	return totalSalaries;
    }
    public void removeEmployee(int id) {
    	if (employees == null) {
    		System.out.println("There are no employees!");
    	} else if (!checkForEmployee(id)) {
    		System.out.println("Employee does not exist!");
    	} else if (employees.length == 1) {
    		employees = null;
    	} else {
    		int employeeIndex = employeeIndexFinder(id);
    		Payroll payroll = employees[employeeIndex].endShift();
    		addPayroll(payroll);
    		for (int i = employeeIndex; i < this.employees.length - 1; i++) {
    			this.employees[i] = this.employees[i + 1];
    		}
    	}
    }
    public void addEmployee(Employee newEmployee){
    	if (employees == null) {
    		Employee[] arr = new Employee[1];
    		arr[0] = newEmployee;
    		this.employees = arr;
        	Item[] items = newEmployee.startShift();
        	for (int i = 0; i < items.length; i++) {
        		this.storage.addItem(items[i]);
        	}
    	} else {
        	this.employees = resizeEmployeeArray(employees);
        	this.employees[employees.length - 1] = newEmployee;
        	
        	Item[] newItems = newEmployee.startShift();
        	for (int i = 0; i < newItems.length; i++) {
        		this.storage.addItem(newItems[i]);
        	}
    	}
    	
    }
    public Employee[] resizeEmployeeArray(Employee[] employees) {
    	return Arrays.copyOf(employees, employees.length + 1);

    }
    public boolean checkForEmployee(int id) {
    	for (int i = 0; i < employees.length; i++) {
    		if (employees[i].getId() == id) {
    			return true;
    		}
    	}
		return false;
    }
    public void addPayroll(Payroll payroll) {
    	if (this.payrolls == null) {
    		Payroll[] arr = new Payroll[1];
    		arr[0] = payroll;
    		this.payrolls = arr;
    	} else {
    		this.payrolls = expandPayrollArray(payrolls);
    		this.payrolls[payrolls.length - 1] = payroll;
    	}
    }
    public Payroll[] expandPayrollArray(Payroll[] payrolls) {
    	return Arrays.copyOf(payrolls, payrolls.length + 1);
    }
    public int employeeIndexFinder(int id) {
    	if (employees == null) {
    		System.out.println("no employee to find");
    		return -1;
    	} else {
    		for (int i = 0; i < employees.length; i++) {
        		if (employees[i].getId() == id) {
        			return i;
        		}
        	}
    	}
    	System.out.println("no such employee");
    	return -1;
    }
    
}