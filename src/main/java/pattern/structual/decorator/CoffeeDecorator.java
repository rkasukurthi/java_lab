package pattern.structual.decorator;

public abstract class CoffeeDecorator {
	protected Coffee decoratedCoffee;
	protected String separator = ",";

	public CoffeeDecorator(Coffee decoratedCoffee) {
		this.decoratedCoffee = decoratedCoffee;
	}

	/**
	 * Implement the getCost in interface Coffee
	 */
	public double getCost() {
		return decoratedCoffee.getCost();
	}

	public String getIngredient() {
		return decoratedCoffee.getIngredient();
	}
}
