package pattern.behavioral.interpretor;

import java.util.HashMap;
import java.util.Stack;

/**
 * An Interpreter Example of parse reversed polish
 * 
 * @author zluo
 */
public class InterpreterExample {
  // context
  static HashMap<String, Expression> context = new HashMap<String, Expression>();

  interface Expression {
    public int interpret();
  }

  /** Number Expression **/
  static class Number implements Expression {
    private int number;

    public Number(int number) {
      this.number = number;
    }

    public int interpret() {
      return number;
    }
  }
  /** Variable Expression **/
  static class Variable implements Expression {
    private String name;

    public Variable(String name) {
      this.name = name;
    }

    public int interpret() {
      if (null == context.get(name))
        return 0;
      return context.get(name).interpret();
    }
  }
  
  /** Operation Expression 
   *  contains Left and Right operators, 
   */
  static abstract class OperationExpression implements Expression {
    Expression left;
    Expression right;

    public OperationExpression(Expression left, Expression right) {
      super();
      this.left = left;
      this.right = right;
    }
  }

  /** Plus Operator **/
  static class Plus extends OperationExpression {
    public Plus(Expression left, Expression right) {
      super(left, right);
    }

    public int interpret() {
      return left.interpret() + right.interpret();
    }
  }

  /** Minus Operator **/
  static class Minus extends OperationExpression {
    public Minus(Expression left, Expression right) {
      super(left, right);
    }

    public int interpret() {
      return left.interpret() - right.interpret();
    }
  }
  
  /** Interpret Engine **/
  static class Evaluator {
    private Expression syntaxTree;

    public Evaluator(String expression) {
      Stack<Expression> expressionStack = new Stack<Expression>();

      for (String token : expression.split(" ")) {
        if (token.equals("+")) {
          expressionStack.push(new Plus(expressionStack.pop(), expressionStack.pop()));
        } else if (token.equals("-")) {
          expressionStack.push(new Minus(expressionStack.pop(), expressionStack.pop()));
        } else
          expressionStack.push(new Variable(token));
      }
      syntaxTree = expressionStack.pop();
    }

    public int interpret() {
      return syntaxTree.interpret();
    }
  }

  public static void main(String[] args) {
    String expression = "w x z - + x + z -";
    context.put("w", new Number(5));
    context.put("x", new Number(10));
    context.put("z", new Number(42));

    int result = new Evaluator(expression).interpret();
    System.out.println("Result is : " + result);
  }
}
