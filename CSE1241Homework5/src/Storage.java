/*In the Storage class, I created an array of items to hold the capacity variable to hold the maximum
 *   number of items to be stored and the items to be assigned to it.I created the get and set methods to access them
 *   Name=Umut Surname=Bayar Number=150120043;
 */
import java.util.Arrays;
public class Storage {

    private int capacity;
    private Item[] items;

    public Storage(int capacity){
        this.capacity = capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public int getCapacity() {
        return capacity;
    }

    public Item[] getItems() {
        return items;
    }

    public void addItem(Item newItem){
    	if (this.items == null) {
    		Item[] arrays = new Item[1];
    		arrays[0] = newItem;
    		this.items = arrays;
    	} else {
        	resizeArray(this.items);
        	this.items[items.length - 1] = newItem;
    	}
    }
    public void resizeArray(Item[] items) {
    	this.items = Arrays.copyOf(items, items.length + 1);
    }

}