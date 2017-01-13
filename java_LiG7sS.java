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
/*  
  private static long fibonacci(int n) {
        if(n < 1) {
            throw new IllegalArgumentException("Minimal length of any number is 1");
        }
        
        if(n == 1) {
            return 0;
        }
        long compareTo = (int) Math.pow(10, n - 1);
        long f1 = 1;
        long f2 = 1;
        long f3 = 2;
        while(f3 < compareTo) {
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
        }
        return f3;
    }
  
 */
}

