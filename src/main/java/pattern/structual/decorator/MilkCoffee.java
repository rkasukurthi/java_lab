package pattern.structual.decorator;

public class MilkCoffee extends CoffeeDecorator
{
    double cost;
    String ingredient;
    
	public MilkCoffee(Coffee decoratedCoffee) {
		super(decoratedCoffee);
		cost=0.5;
		ingredient="Coffee";
	}

}
