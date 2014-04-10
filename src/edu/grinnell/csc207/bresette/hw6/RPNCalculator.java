package edu.grinnell.csc207.bresette.hw6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;

public class RPNCalculator
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
                if (expression[i].equals("+"))
                  {
                    String val1 = myStack.pop();
                    String val2 = myStack.pop();
                    Integer sum =
                        Integer.parseInt(val1) + Integer.parseInt(val2);
                    myStack.push(Integer.toString(sum));
                  }
                else if (expression[i].equals("-"))
                  {
                    String val1 = myStack.pop();
                    String val2 = myStack.pop();
                    Integer diff =
                        Integer.parseInt(val2) - Integer.parseInt(val1);
                    myStack.push(Integer.toString(diff));
                  }
                else if (expression[i].equals("*"))
                  {
                    String val1 = myStack.pop();
                    String val2 = myStack.pop();
                    Integer product =
                        Integer.parseInt(val1) * Integer.parseInt(val2);
                    myStack.push(Integer.toString(product));
                  }
                else if (expression[i].equals("/"))
                  {
                    String val1 = myStack.pop();
                    String val2 = myStack.pop();
                    Integer quotient =
                        Integer.parseInt(val2) / Integer.parseInt(val1);
                    myStack.push(Integer.toString(quotient));
                  }
                else
                  {
                    myStack.push(expression[i]);
                  }
              }
          }
      }
  }
}
