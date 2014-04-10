package edu.grinnell.csc207.bresette.hw6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;

public class RPNCalculatorUI
{
  public static void main(String[] args)
    throws IOException
  {
    Stack<String> myStack = new Stack<String>();
    PrintWriter pen = new PrintWriter(System.out, true);
    BufferedReader eyes = new BufferedReader(new InputStreamReader(System.in));
    boolean run = true;

    while (run)
      {
        String input = eyes.readLine();

        if (input.equals("p"))
          {
            if (!myStack.isEmpty())
              {
                String output = myStack.peek();
                pen.println(output);
              }
            else
              {
                pen.println("The stack is empty");
              }
          }
        else if (input.equals("s"))
          {
            if (!myStack.isEmpty())
              {
                String elements = myStack.toString();
                pen.println(elements);
              }
            else
              {
                pen.println("The stack is empty");
              }
          }
        else if (input.equals("c"))
          {
            myStack.clear();
          }
        else if (input.equals("q"))
          {
            run = false;
          }
        else
          {
            String[] expression = input.split(" ");

            for (int i = 0; i < expression.length; i++)
              {
                RPNCalculator.evaluate(expression[i], myStack);
              }
          }
      }
  }
}
