import java.io.*;

class myCode
{
     public static void main (String[] args) throws java.lang.Exception
    {
        
        char[] str = {'g', 'b', 'e', 'c', 'd'};
         char[] newStr = reverseChar(str);
         System.out.println (newStr);
    } 
    
    /* Does a string have unique chars? */
    public static boolean uniqueChars (String str)
    {
        
        for (int i=0; i<str.length(); i++) {
            char current = str.charAt(i);
            for (int j=0; j<i; j++) 
            {
                 if (current == str.charAt(j)) {
                    return false;
                }
            }
            
        }
        return true;
    }
    
    /* Reverse a string in place */
    
    public static char [] reverseChar (char [] myArr) 
    {
        for (int i = 0; i< myArr.length/2; i++)
        {
            char temp = myArr[i];
            
            myArr[i]=myArr[myArr.length-i-1];
            myArr[myArr.length-i-1] = temp;
        }
        return myArr;
                                 
    }
}
