 /*
    You are given a sorted list of distinct integers from 0 to 99, 
    for instance [0, 1, 2, 50, 52, 75]. 
    Your task is to produce a string that describes numbers missing from the list; 
    in this case "3-49,51,53-74,76-99".

Examples:

[] “0-99”
[0] “1-99”
[3, 5] “0-2,4,6-99”
    */


import java.io.*;
import java.util.*;

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        ArrayList<Integer> testNumbers = new ArrayList <> ();
       testNumbers.add(0);
        testNumbers.add(1);
        testNumbers.add(3);
        testNumbers.add(4);
        testNumbers.add(5);
        
        testNumbers.add(98);
         testNumbers.add(99);
        System.out.println(getMissingIntervals(testNumbers));
/       
    }
    
    public static String getMissingIntervals (ArrayList <Integer> numbers)
    {
        if (numbers == null)
        {
            throw new IllegalArgumentException("Null array given");
        }
        
        if (numbers.size() == 0)
        {
            return  "0-99";
        } 
        
        
            StringBuilder resultString = new StringBuilder();
             if ((numbers.get(0) != 0)&&(numbers.get(0)!=1)) {
                resultString.append("0-");
                 resultString.append((numbers.get(0)-1));
                 resultString.append(",");
                 System.out.println (resultString.toString());
            } 
            
            for (int i = 1; i<numbers.size()-1; i++)
            {
                
                System.out.println("Current number is " + numbers.get(i));
                
                if (numbers.get(i)>(numbers.get(i-1)+2))
                {
                    resultString.append((numbers.get(i-1)+1));
                    resultString.append("-");
                    resultString.append((numbers.get(i)-1));
                    System.out.println (resultString.toString());
                } else if(((numbers.get(i)>(numbers.get(i-1)+1))
                           &&(numbers.get(i)!=99)
                           &&(numbers.get(i)!=1))) {
                   resultString.append((numbers.get(i-1)+1));
                   System.out.println (resultString.toString());
                }
                if ((numbers.get(i)>(numbers.get(i-1)+1))&&(numbers.get(i)>1)&&(numbers.get(i)<98)) 
                {
                resultString.append(",");
                }
            }
            
            if (numbers.get(numbers.size()-1)<98)
            {
                System.out.println("Last number is " + numbers.get(numbers.size()-1));
                resultString.append((numbers.get(numbers.size()-1)+1));
                resultString.append("-99");
                System.out.println (resultString.toString());
            } else if (numbers.get(numbers.size()-1) == 98) 
            {
                System.out.println("Last number is " + numbers.get(numbers.size()-1));
                resultString.append("99");
                System.out.println (resultString.toString());
            } else if (numbers.get(numbers.size()-2)<98)
            {
                System.out.println("Last number is " + numbers.get(numbers.size()-1));
                resultString.append(numbers.get(numbers.size()-2)+1);
                resultString.append("-98");
                System.out.println (resultString.toString());
            }
        
        return resultString.toString();
        }
        
        
    }
    
   
