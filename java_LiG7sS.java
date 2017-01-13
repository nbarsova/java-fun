/
public class HelloWorld
{
  public static void main(String[] args)
  {
    
    int x = 1;
    
    int border = 1;
    
    for (int i=0; i<x; i++)
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
    
    System.out.println ("Smallest fibbonacci number with "+x+1+" digits is" + currentFib);
    
  }
  
 
}

