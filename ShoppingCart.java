import java.util.*;

public class ShoppingCart implements Cart {

	 private ArrayList<SelectedItem> ItemList = new ArrayList<SelectedItem>();
	 private SelectedItem tempItem;
	 private boolean firstItem = true;
	 
	public void addItem(SelectedItem newItem) {
		if(firstItem) {
			ItemList.add(newItem);
		} else {
			for(int i = 0; i < ItemList.size(); i++) {
				tempItem = ItemList.get(i);
				if(newItem.getItemNumber() == tempItem.getItemNumber()) {
					tempItem.setQuantity(tempItem.getQuantity() + 1);
				} else {
					ItemList.add(newItem);
					break;
				}
			}
		}
	}

	public void deleteItem(int deleteItemNumber) {
		
		for(int i = 0; i < ItemList.size(); i++) {
			tempItem = ItemList.get(i);
			if(deleteItemNumber == tempItem.getItemNumber()) {
				ItemList.remove(i);
			}
		}
		
	}

	public double getTotal() {
		double total = 0;
		for(int i = 0; i < ItemList.size(); i++) {
			tempItem = ItemList.get(i);
			total = total + (tempItem.getUnitPrice() * tempItem.getQuantity());
		}
		return total;
	}

	public double getTax() {
		double tax;
		tax = getTotal() * 0.045;
		return tax;
	}

	public double getShipping() {
		double shipping;
		if(getTotal() <= 10) {
			shipping = 2.50;
		} else {
			shipping = getTotal();
		}
		return shipping;
	}

    public String toString() {
    	String output = "";
    	
    	for(int i = 0; i < ItemList.size(); i++) {
    		tempItem = ItemList.get(i);
    		output = output + "Item: " + tempItem.getDescription() + System.lineSeparator() + "Quantity: " + tempItem.getQuantity() +
    			System.lineSeparator() + "Unit Price: $" + tempItem.getUnitPrice() + System.lineSeparator() + "Total Price: $" + 
    				(tempItem.getUnitPrice() * tempItem.getQuantity()) + System.lineSeparator() + System.lineSeparator();
    	}
    	
    	output = output + "Total: $" + getTotal() + System.lineSeparator();
    	output = output + "Tax: $" + getTax() + System.lineSeparator();
    	output = output + "Shipping: $" + getShipping() + System.lineSeparator();
    	output = output + "GRAND TOTAL: $" + (getTotal() + getTax() + getShipping()) + System.lineSeparator();
    	
    	return output;
    }
	
}
