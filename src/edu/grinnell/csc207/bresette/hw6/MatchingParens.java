package edu.grinnell.csc207.bresette.hw6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;

public class MatchingParens
{
  public static String dashes(int num)
  {
    String allDashes = "";
    for (int i = 0; i < num; i++)
      {
        allDashes = allDashes + "-";
      }
    return allDashes;
  }

  public static String spaces(int num)
  {
    String allSpaces = "";
    for (int i = 0; i < num; i++)
      {
        allSpaces = allSpaces + " ";
      }
    return allSpaces;
  }

  public static <T> void matchingParens(String expression)
  {
    Stack<T> myStack = new Stack<T>();
    PrintWriter pen = new PrintWriter(System.out, true);
    for (int i = 0; i < expression.length(); i++)
      {
        if (expression.charAt(i) == '(' || expression.charAt(i) == '['
            || expression.charAt(i) == '{' || expression.charAt(i) == '<'
            || expression.charAt(i) == '`')
          {
            myStack.push((T) Character.toString(expression.charAt(i)));
            myStack.push((T) Integer.valueOf(i));
          }
        else if (expression.charAt(i) == ')' || expression.charAt(i) == ']'
                 || expression.charAt(i) == '}' || expression.charAt(i) == '>'
                 || expression.charAt(i) == '\'')
          {
            if (!myStack.empty())
              {
                int closeIndex = i;
                int openIndex = (Integer) myStack.pop();
                String openChar = (String) myStack.pop();
                pen.println(spaces(openIndex) + openChar
                            + dashes(closeIndex - openIndex - 1)
                            + expression.charAt(i));
              }
            else
              {
                pen.println(spaces(i) + expression.charAt(i) + "<- UNMATCHED");
              }
          }
      }
    if (!myStack.empty())
      {
        while (!myStack.empty())
          {
            int unmatchedIndex = (Integer) myStack.pop();
            String unmatchedChar = (String) myStack.pop();
            pen.println(spaces(unmatchedIndex) + unmatchedChar + "<- UNMATCHED");
          }
      }
  }
}
