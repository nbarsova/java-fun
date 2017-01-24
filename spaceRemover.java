/* Write a method to replace all spaces in a string with'%20'. You may assume that
the string has sufficient space at the end of the string to hold the additional
characters, and that you are given the "true" length of the string. (Note: if implementing
in Java, please use a character array so that you can perform this operation
in place.)
EXAMPLE
Input: "Mr John Smith
Output: "Mr%20Dohn%20Smith"
 */

import java.io.*;
import java.util.Arrays;

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String myStr = "Mr John Smith";
        char[] test = Arrays.copyOf(myStr.toCharArray(), myStr.length() + 6);
        System.out.println(replaceSpaces(test, myStr.length()));
    }
    
    public static char[] replaceSpaces (char[] myString, int length)
    {
        int  k = myString.length-1;
        for (int i = length; i>=0; i--, k --)
        {
            if (myString [i] != ' ')
            {
                char temp = myString[k];
                myString[k] = myString [i];
                myString [i] = temp;
                
            } else 
            {
                myString[k] = '0';
                myString[k-1] = '2';
                myString[k-2] = '%';
                k -= 2;
                
            }

        }
        
        
        return myString;
        
    }
}        
