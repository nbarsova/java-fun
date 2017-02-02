/* Given an image represented by an NxN matrix, where each pixel in the image is
4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
place? */

import java.io.*;

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        int [][] testMatrix = {{1,2,3,4,5}, {6,7,8,9,10}, 
        {11,12,13,14,15}, {16,17,18,19,20}, {21,22,23,24,25}};
         System.out.println ("Original");
        for (int i=0; i<testMatrix.length; i++)
        {
            for (int j=0; j<testMatrix[0].length; j++)
            {
                System.out.print (testMatrix[i][j] + " ");
            }
            System.out.println ("");
        }
        
       
        testMatrix = rotate (testMatrix);
         
         System.out.println ("Rotated");
          for (int i=0; i<testMatrix.length; i++)
        {
            for (int j=0; j<testMatrix[0].length; j++)
            {
                System.out.print (testMatrix[i][j] + " ");
            }
            System.out.println("");
        }
        
     }
    
    public static int [][] rotate (int [][] myMatrix) {
        int N = myMatrix.length;
        
        for (int i=0; i<N-1-i; i++)
        {
            
            System.out.println("");
            
            for (int j=i; j<N-1-i; j++)
            {
                System.out.println("i = " + i + ", j = " +j);
                
                int temp1 = myMatrix[i][j];
                System.out.println("temp1 = " + temp1);
                
                int temp2 = myMatrix[j][N-1-i];
                System.out.println("temp2 = " + temp2);
                int temp3 = myMatrix[N-1-i][N-j-1];
                System.out.println("temp3 = " + temp3);
                int temp4 = myMatrix[N-j-1][i];
                System.out.println("temp4 = " + temp4);
                myMatrix[i][j] = temp4;
                myMatrix[N-j-1][i] = temp3;
                myMatrix[N-i-1][N-j-1] = temp2;
                myMatrix[j][N-i-1] = temp1;
                System.out.println("");
               
            }
        }
        return myMatrix;
    }
}
