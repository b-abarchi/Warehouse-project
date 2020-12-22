package prob1;

public class RefrigeratedItemTest {

	public static void main(String[] args) {
		testConstructorMain();
     	testConstructorAcceptsItem();   
		testItemCost();
     	testToString();
	}
	
	/**
	 * Verify that the name, weight, & temp are initialized with the main constructor.
	 */
	public static void testConstructorMain() {
		System.out.println("-->testConstructorMain"); 
		RefrigeratedItem r = new RefrigeratedItem("Pizza", 2.56, 40.00); 
		System.out.print("expected: Pizza, 2.56, 40.0\nActual:"); 
		System.out.print(r.getName()+ ", "+ r.getWeight()+ ", " + r.getTemp() + "\n\n");	}

	/**
	 * Verify that the name, weight, & temp are initialized with the second constructor.
	 */
	public static void testConstructorAcceptsItem() {
		System.out.println("-->testConstructorAcceptsItem"); 
		Item i = new Item("Pizza", 2.56);
		RefrigeratedItem r = new RefrigeratedItem(i, 40.00); 
		System.out.print("expected: Pizza, 2.56, 40.0\nActual:"); 
		System.out.print(r.getName() + ", "+ r.getWeight()+ ", "+ r.getTemp() +"\n\n");	
	}

	/**
	 * Verify that the cost method works correctly.
	 */
	public static void testItemCost() {
		System.out.println("-->testItemCost"); 
		Item i = new Item("turkey", 3.0);
		RefrigeratedItem r = new RefrigeratedItem(i, 10.00); 
		System.out.print("expected cost: 15.0 \nActual cost:"); 
		System.out.print(r.Cost() +"\n\n");	 
	}

	/**
	 * Verify that the toString method produces a string exactly
	 * as specified in the assignment document. 
	 */
	public static void testToString() {
		System.out.println("-->testToString"); 
		Item i = new Item("Ice Cream", 1.00);
		RefrigeratedItem r = new RefrigeratedItem(i, 20.00); 
		System.out.println(r);
		
	}

}
