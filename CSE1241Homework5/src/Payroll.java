/*I created variables in the payroll class to count the number of items and to keep track of the working hours.
 *  To access them, I added the get and set methods. And I added the string method to transcribe it.
 *   I also created a method for calculating the salary of the employees.
 *	Name=Umut Surname=Bayar  Number=150120043    
 */
public class Payroll {

	private int workHour=0,itemCount=0;
	public Payroll(int workHour,int itemCount){
		this.itemCount=itemCount;
		this.workHour=workHour;
	}
	public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public void setWorkHour(int workHour) {
        this.workHour = workHour;
    }

    public int getItemCount() {
        return itemCount;
    }

    public int getWorkHour() {
        return workHour;
    }
    public String toString(){
        return "The work hour is " + workHour + " and the produced item count is " + itemCount + ".";
    }
    public int calculateSalary(){
        return itemCount * 2 + workHour * 3;
    }
}

