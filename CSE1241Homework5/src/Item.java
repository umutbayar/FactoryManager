/*In this item class I have created variables to hold the id and item count of the factory workers.
 *  I have created methods to retrieve and set them from another class.
 *  Name=Umut Surname=Bayar  Number=150120043
 */
public class Item {

	private int id;
	public static int numberOfItems=0;

	public Item(int id){
	this.id=id;
	numberOfItems++;
	}
	 public void setId(int id) {
	        this.id = id;
	    }

	    public void setNumberOfItems(int numberOfItems) {
	        Item.numberOfItems = numberOfItems;
	    }

	    public int getNumberOfItems() {
	        return numberOfItems;
	    }

	   public int getId() {
	        return id;
	    }	
}
