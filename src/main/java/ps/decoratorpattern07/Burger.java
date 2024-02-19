package ps.decoratorpattern07;

public class Burger {

	String burgerType;
	public Burger addVeggies() {
		System.out.println("Adding veggies to the burger");
		return new Burger(this.burgerType+="Veggies");
	}
	public Burger addCheese() {
		System.out.println("Adding cheese to the burger");
		return new Burger(this.burgerType+="Cheese");
	}
	public Burger(String burgerType) {
		super();
		this.burgerType = burgerType;
	}
	public String getBurgerType() {
		return burgerType;
	}
	public void setBurgerType(String burgerType) {
		this.burgerType = burgerType;
	}
	
}
