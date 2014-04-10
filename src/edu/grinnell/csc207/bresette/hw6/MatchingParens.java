package edu.grinnell.csc207.bresette.hw6;

import java.io.PrintWriter;
import java.util.Stack;

public class MatchingParens
{
  // +---------+----------------------------------------------------
  // | Helpers |
  // +---------+
  /**
   * Creates a string of dashes of length num
   * @param num, an integer which determines the length of the string
   * @return a string of dashes
   */
  public static String dashes(int num)
  {
    String allDashes = "";
    for (int i = 0; i < num; i++)
      {
        allDashes = allDashes + "-";
      } // for()
    return allDashes;
  } // dashes(int)

  /**
   * Creates a string of spaces of length num
   * @param num, an integer which determines the length of the string
   * @return a string of spaces
   */
  public static String spaces(int num)
  {
    String allSpaces = "";
    for (int i = 0; i < num; i++)
      {
        allSpaces = allSpaces + " ";
      } // for
    return allSpaces;
  } // spaces(int)

  /**
   * prints out a picture that shows the nesting of parentheses in the given expression
   * @param expression, a String expression
   */
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
          } // if it is an opening symbol
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
              } // if not empty
            else
              {
                pen.println(spaces(i) + expression.charAt(i) + "<- UNMATCHED");
              } // else
          } // else if it is a closing symbol
      } // for
    if (!myStack.empty())
      {
        while (!myStack.empty())
          {
            int unmatchedIndex = (Integer) myStack.pop();
            String unmatchedChar = (String) myStack.pop();
            pen.println(spaces(unmatchedIndex) + unmatchedChar + "<- UNMATCHED");
          } // while not empty
      } // if not empty
  } // matchingParens(String)
} // class MatchingParens
