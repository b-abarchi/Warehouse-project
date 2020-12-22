package prob1;

import java.util.Arrays;

public class WarehouseTest {

	public static void main(String[] args) {
		testAddItem();
		testAddItem_Multiple();
		testGetItem_WithIndex();
		testGetItem_WithName();
		testGetAverageTemp();
    	testGetRefrigeratedItems();
		testGetTotalCost();
		testGetTotalCostRefrigerated();
		testRemoveItem_WithIndex();
		testRemoveItem_WithName();
		testToString();
	}
	
	/**
	 * Add one item and check the number of items to verify.
	 */
	public static void testAddItem() {
		System.out.println("-->testAddItem"); 
		Warehouse w = new Warehouse();
		Item i = new Item("Crackers", 2.25);
		w.addItem(i);
		System.out.print("expected # of items: 1 \nActual:" + w.getNumItems() + "\n\n"); 
	}

	/**
	 * Add three items and check the number of items to verify. At least one should be a refrigerated item.
	 */
	public static void testAddItem_Multiple() {
		System.out.println("-->testAddItem_Multiple"); 
		Warehouse w = createWarehouseWith3Items();
		System.out.print("expected # of items: 3 \nActual:" + w.getNumItems() + "\n\n"); 
	}
	
	/**
	 * Add three items and retrieve the one at index 1.
	 */
	public static void testGetItem_WithIndex() {
		System.out.println("-->testGetItem_WithIndex");
		int loc = 2;
		Warehouse w = createWarehouseWith3Items();
		Item i = w.getItem(2);
		String expected = "Ice cream";
		String msg = "3 items, getItem(" + loc + "): expected=" + expected +", actual=";
		System.out.println(msg+ "\n" + i + "\n\n");

		
	}

	/**
	 * Add three items and try to find one with a name that exists.
	 */
	public static void testGetItem_WithName() {
		System.out.println("-->testGetItem_WithName"); 
		String name = "Cookies";
		Warehouse w = createWarehouseWith3Items();
		Item i = w.getItem("Cookies");
		String expected = "Cookies";
		String msg = "3 items, getItem(" + name + "): expected=" + expected +", actual=";
		System.out.println(msg+ "\n" + i + "\n\n");
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Verify the average temperature. 
	 */ 
	//each item has temperature = 10.00
	public static void testGetAverageTemp() {
		System.out.println("-->testGetAverageTemp"); 
		Warehouse w = createWarehouseWith5Items();
		String expected = "10.00";
		String msg = "5 items, 3 refrigeratedItems getAverageTemp(): expected=" + expected +", actual=";
		System.out.println(msg+ "\n" + w.getAverageTemp() + "\n\n");
	}
	
	/**
	 * Add 5 items, 3 of which are refrigerated. Verify that the 3 are returned in array.
	 */
	public static void testGetRefrigeratedItems() {
		System.out.println("-->testGetRefrigeratedItems"); 
		Warehouse w = createWarehouseWith5Items();
		String expected = "Array of 3 refrigerated items";
		String msg = "5 items, 3 refrigeratedItems getRefrigeratedItems(): expected=" + expected +", actual=";
		System.out.println(msg+ "\n" + Arrays.toString(w.getRefrigeratedItems()) + "\n\n");
	}
	
	/**
	 * Add 5 items, 3 of which are refrigerated. Verify the total cost.
	 */
	public static void testGetTotalCost() {
		System.out.println("-->testGetTotalCost()"); 
		Warehouse w = createWarehouseWith5Items();
		String expected = "55.5";
		String msg = "5 items, 3 refrigeratedItems getTotalCost(): expected=" + expected +", actual=";
		System.out.println(msg+ "\n" + w.getTotalCost() + "\n\n");
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Verify the total cost of the 3 refrigerated items
	 */
	public static void testGetTotalCostRefrigerated() {
		System.out.println("-->testGetTotalCostRefrigerated"); 
		Warehouse w = createWarehouseWith5Items();
		String expected = "44.5";
		String msg = "5 items,3 refrigeratedItems getTotalCostRefrigerated(): expected=" + expected +", actual=";
		System.out.println(msg+ "\n" + w.getTotalCostRefrigerated() + "\n\n");
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Remove the one at position 2 and 
	 * verify: the item is returned, and the number of items is decremented.
	 */
	public static void testRemoveItem_WithIndex() {
		System.out.println("-->testRemoveItem_WithIndex"); 
		int loc = 2;
		Warehouse w = createWarehouseWith5Items();
		Item i = w.removeItem(2);
		String expected = "Ice cream";
		String msg = "5 items,3 refrigeratedItems removeItem(" + loc + "): expected=" + expected +", actual=";
		System.out.println(msg+ "\n" + i + "\n\n");

	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Remove one with a name that exists and 
	 * verify: the item is returned, and the number of items is decremented.
	 */
	public static void testRemoveItem_WithName() {
		System.out.println("-->testRemoveItem_WithName"); 
		String name = "nuggets";
		Warehouse w = createWarehouseWith5Items();
		Item i = w.removeItem("nuggets");
		String expected = "nuggets";
		String msg = "5 items,3 refrigeratedItems removeItem(" + name + "): expected=" + expected +", actual=";
		System.out.println(msg+ "\n" + i + "\n\n");
	}

	/**
	 * Verify that the toString method produces a string exactly
	 * as specified in the assignment document. 
	 */
	public static void testToString() {
		System.out.println("-->testToString"); 
		Warehouse w = createWarehouseWith5Items();
		System.out.println(w);
	}
	public static Item createTestItem(String name, double weight){
		Item item = new Item(name, weight);
		return item;
	};
	public static Item createRefrigeratedItem(String name, double weight, double temp){
		RefrigeratedItem r = new RefrigeratedItem(name, weight, temp); 
		return r;
	};
	//Add 3 items,  1 of which 1 is refrigerated
	public static Warehouse createWarehouseWith3Items() {
	Warehouse warehouse = new Warehouse();
	warehouse.addItem(createTestItem("Pizza",3.00));
	warehouse.addItem(createTestItem("Cookies",2.50));
	warehouse.addItem(createRefrigeratedItem("Ice Cream", 2.00, 10.00));
	return warehouse;
}
	// Add 5 items, 3 of which are refrigerated
	public static Warehouse createWarehouseWith5Items() {
		Warehouse warehouse = createWarehouseWith3Items();
		warehouse.addItem(createRefrigeratedItem("nuggets", 2.75, 10.00));
		warehouse.addItem(createRefrigeratedItem("Salmon", 4.00, 10.00));
		return warehouse;
	}
}
