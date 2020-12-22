package prob1;

import java.util.Arrays;

public class Warehouse{
	protected Item[] item = new Item[10];
	protected int numItems = 0;
	private	RefrigeratedItem[] refrigeratedItem = new RefrigeratedItem[3];
	public Item[] getItem() {
		return item;
	}
	public int getNumItems() {
		return numItems;
	}
	public Warehouse() {}
	//add item
public void addItem(Item i) { 
	if(numItems <= item.length)	{
		item[numItems++] = i;
	}
}
//get item using index
public Item getItem(int loc) {
	if(loc > 0 && loc <= numItems) {
		return item[loc];
	}
	return null;}
//get item using name
public Item getItem(String name) {
	for(int i = 0; i < numItems;i++) {
		if(item[i].getName().equals(name)) {
			return item[i];
		}
	}
	return null;}
// get the temperature avg
public double getAverageTemp() {
	double avg = 0;
	double total = 0;
	for(int i = 0; i < numItems;i++) {
		Item t = item[i] ;
		if(t instanceof RefrigeratedItem) {
		total += ((RefrigeratedItem) t).getTemp();
		}
		avg = total / getNumRefrigeratedItems();
	}
	return avg;
	
}
public int getNumRefrigeratedItems() {
	int count=0;
	for(int i=0; i < numItems; i++) {
		Item t = item[i] ;
		if(t instanceof RefrigeratedItem) {
			count++;
		}
	}
	return count;
}
public RefrigeratedItem[] getRefrigeratedItems() {
	int j = 0;

	for(int i = 0; i < numItems; i++) {
		Item t = item[i] ;
		if(t instanceof RefrigeratedItem) {
			refrigeratedItem[j++] = (RefrigeratedItem)t;
		}
	}
	return refrigeratedItem;
}
public double getTotalCost() {
	double totalCost = 0;
	for(int i = 0; i < numItems; i++) {
		totalCost += item[i].Cost(); 
	}
	return totalCost;
}

public double getTotalCostRefrigerated() {
	double totalCost = 0;
	for(int i = 0; i < numItems; i++) {
		Item t = item[i] ;
		if(t instanceof RefrigeratedItem) {
			totalCost += item[i].Cost(); 
		}
	}
	return totalCost;
	
}

public Item removeItem(int loc) {
	if(loc > 0 && loc <= numItems) {
	Item returnedItem = item[loc];
	for(int i = loc + 1; i < numItems; i++) {
		item[i - 1] = item[i];
	}
		numItems--;
		return returnedItem;
	}
	return null;
	}
public Item removeItem(String name) {
	for(int i = 0; i < numItems; i++) {
		if(item[i].getName().equals(name)) {
			int loc = i; 
			Item returnedItem = item[loc];
			for(int j = loc + 1; j < numItems; i++) {
				item[j - 1] = item[j];
				numItems--;
			}
				
				return returnedItem;
		}
	}
	return null;
	}
@Override
public String toString() {
	String msg = "";
	for(int i = 0; i <  numItems;i++) {
		msg += item[i].toString() + "\n";
	
	}
	return msg;
}

	


}
