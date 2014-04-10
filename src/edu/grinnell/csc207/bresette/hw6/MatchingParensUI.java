package edu.grinnell.csc207.bresette.hw6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatchingParensUI
{
  public static void main(String[] args)
      throws IOException
    {
      BufferedReader eyes = new BufferedReader(new InputStreamReader(System.in));
      String expression = eyes.readLine();
      MatchingParens.matchingParens(expression);
    }
}
