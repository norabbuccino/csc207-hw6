package edu.grinnell.csc207.bresette.hw6;

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
        Integer sum = Integer.parseInt(val1) + Integer.parseInt(val2);
        myStack.push(Integer.toString(sum));
      } // if equals +
    else if (expression.equals("-"))
      {
        String val1 = myStack.pop();
        String val2 = myStack.pop();
        Integer diff = Integer.parseInt(val2) - Integer.parseInt(val1);
        myStack.push(Integer.toString(diff));
      } // if equals -
    else if (expression.equals("*"))
      {
        String val1 = myStack.pop();
        String val2 = myStack.pop();
        Integer product = Integer.parseInt(val1) * Integer.parseInt(val2);
        myStack.push(Integer.toString(product));
      } // if equals *
    else if (expression.equals("/"))
      {
        String val1 = myStack.pop();
        String val2 = myStack.pop();
        Integer quotient = Integer.parseInt(val2) / Integer.parseInt(val1);
        myStack.push(Integer.toString(quotient));
      } // if equals /
    else
      {
        myStack.push(expression);
      } // else
  } // evaluate(String, Stack<String>)
} // class RPNCalculator
