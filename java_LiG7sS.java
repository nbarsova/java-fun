//*******************************************************************
// NOTE: please read the 'More Info' tab to the right for shortcuts.
//*******************************************************************

import java.lang.Math; // headers MUST be above the first class

// one class needs to have a main() method
public class HelloWorld
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    
    int digits = 1;
    
    int border = 1;
    
    for (int i=0; i<digits; i++)
    {
      border = border*10;
    }
      
    System.out.println (border);
    
    int currentFib = 1;
    int prevFib = 0;
    
    while (currentFib<border)
    {
      currentFib+=prevFib;
    }
    
    System.out.println ("Smallest fibbonacci number with "+digits+1+" digits is" + currentFib);
    
  }
  
 
}

