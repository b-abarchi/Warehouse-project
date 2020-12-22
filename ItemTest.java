package prob1;

public class ItemTest {

	public static void main(String[] args) {
		testConstructor();
		testItemCost();
		testToString();
	}
	
	/**
	 * Verify that the name & weight are initialized with the constructor.
	 */
	public static void testConstructor() {
		System.out.println("-->testConstructor"); 
		Item i = new Item("Crackers", 2.25);
		System.out.print("expected: Crackers, 2.25\nActual:"); 
		System.out.print(i.getName() + ", "+ i.getWeight()+ "\n\n"); 
	}

	/**
	 * Verify that the cost method works correctly.
	 */
	public static void testItemCost() {
		System.out.println("-->testItemCost"); 
		Item i = new Item("Crackers", 2.25);
		System.out.print("expected cost: $4.5 \nActual:"); 
		System.out.print("$" + i.Cost()+ "\n\n"); 
	}

	/**
	 * Verify that the toString method produces a string exactly
	 * as specified in the assignment document. 
	 */
	public static void testToString() {
		System.out.println("-->testToString"); 
		Item i = new Item("Crackers", 2.25);
		System.out.println(i);
	}

}
