/* package whatever; // don't place package name! */

import java.io.*;
import java.util.*;

/**
You are given an int N and you are asked to find all int A : 
1) A ^ N > N
2) A < N

1 < N < 200000000
*/

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
      
        int n = 13;
        ArrayList myList = findXors(n);
        if (myList == null) {
            System.out.println("Incorrect input");
        } else {
            for (int i=0; i<myList.size(); i++) System.out.println (myList.get(i));
        }
    }
    
    public static ArrayList findXors(int n) {
        if (n<1 || n > 200000000)
            return null;
        else {
            ArrayList xorList = new ArrayList();
            for (int a = 1; a < n; a ++)
            {
                if ((a^n)>n)
                {
                    xorList.add(a);
                }
            }
            return xorList;
        }
    }
}
