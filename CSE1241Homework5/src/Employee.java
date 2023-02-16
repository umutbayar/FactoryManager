/*In the Employee class, I used the get and set methods to create and access variables and methods to
 *  keep the factory employees' name, surname, working hour and working speed. Also in this class, I assigned
 *   a random item number to the employees with the item array. Then I used the string method to write it down.
 *   Name= Umut Surname=Bayar Number=150120043
 */
public class Employee {
    private int id;
    private String name;
    private String surname;
    private int workHour;
    private int speed;
    private Item[] items;
    private Payroll payroll;

    public Employee(int id, String name, String surname, int workHour, int speed){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.workHour = workHour;
        this.speed = speed;
    }

    public void setWorkHour(int workHour) {
        this.workHour = workHour;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPayroll(Payroll payroll) {
        this.payroll = payroll;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getWorkHour() {
        return workHour;
    }

    public int getId() {
        return id;
    }

    public int getSpeed() {
        return speed;
    }

    public Item[] getItems() {
        return items;
    }

    public Payroll getPayroll() {
        return payroll;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Item[] startShift(){
        int numOfItems = speed * workHour;
        Item[] items = new Item[numOfItems];
        for (int i = 0; i < numOfItems; i++){
            items[i] = new Item((int) (Math.random() * 100));
        }
        this.items = items;
        return items;
    }
    public Payroll endShift(){
        Payroll payroll = new Payroll(workHour, items.length);
        this.payroll = payroll;
        return payroll;
    }
    public String toString(){
    	return "This is the employee with id " + id + " speed " + speed + ". The work hour is " + workHour + " and the produced item count is " + items.length + ".";
    }
}