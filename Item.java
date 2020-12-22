	package prob1;
	
	public class Item {
	protected String name;
	protected double weight;
	public Item(String name, double weight) {
		super();
		this.name = name;
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public double getWeight() {
		return weight;
	}
	public double Cost() {
		double cost = 0;
		cost = weight * 2;
		return cost;
	}
	@Override
	public String toString() {
		String msg = "";
		return msg += String.format("name= %s, cost= $%.2f, weight= %.2f", getName(), Cost(), getWeight());
	}
	
	}
