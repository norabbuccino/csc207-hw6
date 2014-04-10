package edu.grinnell.csc207.bresette.hw6;

import java.math.BigDecimal;
import java.util.Stack;

public class RPNCalculator
{
  /**
   * Evaluates the expression in String and puts the necessary things onto the stack
   * @param expression, a String expression
   * @param myStack, a Stack
   */
  public static void evaluate(String expression, Stack<String> myStack)
  {

    if (expression.equals("+"))
      {
        String val1 = myStack.pop();
        String val2 = myStack.pop();
        BigDecimal sum =
            BigDecimal.valueOf(Double.parseDouble(val1))
                      .add(BigDecimal.valueOf(Double.parseDouble(val2)));
        myStack.push(sum.toString());
      } // if equals +
    else if (expression.equals("-"))
      {
        String val1 = myStack.pop();
        String val2 = myStack.pop();
        BigDecimal diff =
            BigDecimal.valueOf(Double.parseDouble(val2))
                      .subtract(BigDecimal.valueOf(Double.parseDouble(val1)));
        myStack.push(diff.toString());
      } // if equals -
    else if (expression.equals("*"))
      {
        String val1 = myStack.pop();
        String val2 = myStack.pop();
        BigDecimal product =
            BigDecimal.valueOf(Double.parseDouble(val1))
                      .multiply(BigDecimal.valueOf(Double.parseDouble(val2)));
        myStack.push(product.toString());
      } // if equals *
    else if (expression.equals("/"))
      {
        String val1 = myStack.pop();
        String val2 = myStack.pop();
        BigDecimal quotient =
            BigDecimal.valueOf(Double.parseDouble(val2))
                      .divide(BigDecimal.valueOf(Double.parseDouble(val1)));
        myStack.push(quotient.toString());
      } // if equals /
    else if (expression.equals("^"))
      {
        String val1 = myStack.pop();
        String val2 = myStack.pop();
        BigDecimal power =
            BigDecimal.valueOf(Double.parseDouble(val2))
                      .pow(Integer.parseInt(val1));
        myStack.push(power.toString());
      }
    else
      {
        myStack.push(expression);
      } // else
  } // evaluate(String, Stack<String>)
} // class RPNCalculator
