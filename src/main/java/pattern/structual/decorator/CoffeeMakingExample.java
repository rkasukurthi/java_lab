package pattern.structual.decorator;

import org.junit.Test;

/**
 * This example illustrates the use of decorates using coffee making scenario.
 * 
 * @see http://en.wikipedia.org/wiki/Decorator_pattern
 * @author zluo
 */
public class CoffeeMakingExample {

  /** Coffee interface defines the functions of Coffee implemented by decorator **/
  public static interface Coffee {
    public double getCost();

    public String getIngredient();
  }

  /** Extension of a simple coffee without any extra ingredients **/
  public static class SimpleCoffee implements Coffee {
    public double getCost() {
      return 1.0;
    }
    public String getIngredient() {
      return "Coffee";
    }
  }
  
  /** Abstract decorator class **/
  public static abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;
    protected String separator = ",";

    public CoffeeDecorator(Coffee decoratedCoffee) {
      this.decoratedCoffee = decoratedCoffee;
    }

    /** Implement the getCost in interface Coffee **/
    public double getCost() {
      return decoratedCoffee.getCost();
    }

    public String getIngredient() {
      return decoratedCoffee.getIngredient();
    }
  }

  /** Coffee mixed with milk **/
  public class Milk extends CoffeeDecorator {
    public Milk(Coffee decoratedCoffee) {
      super(decoratedCoffee);
    }

    public double getCost() {
      return super.getCost() + 0.5;
    }

    public String getIngredient() {
      return decoratedCoffee.getIngredient() + separator + "Milk";
    }
  }

  /** Coffee mixed with Whip **/
  public class Whip extends CoffeeDecorator {
    public Whip(Coffee decoratedCoffee) {
      super(decoratedCoffee);
    }

    public double getCost() {
      return super.getCost() + 0.7;
    }

    public String getIngredient() {
      return decoratedCoffee.getIngredient() + separator + "Whip";
    }
  }

  /** Coffee mixed with Whip **/
  public class Sprinkle extends CoffeeDecorator {
    public Sprinkle(Coffee decoratedCoffee) {
      super(decoratedCoffee);
    }

    public double getCost() {
      return super.getCost() + 0.2;
    }

    public String getIngredient() {
      return decoratedCoffee.getIngredient() + separator + "Sprinkle";
    }
  }

  @Test
  public void decoratorTest() {
    Coffee c = new SimpleCoffee();
    System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getIngredient());

    c = new Milk(new SimpleCoffee());
    System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getIngredient());

    c = new Sprinkle(new Milk(new SimpleCoffee()));
    System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getIngredient());

    c = new Whip(new Sprinkle(new Milk(new SimpleCoffee())));
    System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getIngredient());

    // Note that you can also stack more than one decorator of the same type
    c = new Sprinkle(new Whip(new Sprinkle(new Milk(new SimpleCoffee()))));
    System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getIngredient());
  }
}
