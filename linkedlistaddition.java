/* package whatever; // don't place package name! */

import java.io.*;

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Entry new1 = new Entry <Integer> (6, null);
        Entry new2 = new Entry <Integer>  (1, new1);
        Entry new3 = new Entry <Integer>  (7, new2);
        
        new3.print();
        
        Entry new4 = new Entry <Integer>  (2, null);
        Entry new5 = new Entry <Integer>  (9, new4);
        Entry new6 = new Entry <Integer>  (5, new5);
        
        new6.print();
        
        Entry <Integer> result = addDigits(new6, new3);
        result.print();
        
    }
    
    private static Entry <Integer> addDigits (Entry <Integer> d1, Entry <Integer> d2)
    {
        Entry result = new Entry <Integer> (0, null);
        Integer addingValue = 0;
        if ((d1==null)||(d2==null))
        {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        
       do {
            Integer res = d1.getElement() + d2.getElement() + addingValue;
           // addingValue = res / 10;
           // res = res % 10; 
            if (res >=10) 
            {
                res-=10; 
                addingValue = 1;
            } else {
                addingValue = 0;
            }
            System.out.println("Creating sum node "+res);
            result.setElement(res);
            result = new Entry (0, result);
            d1 = d1.getNext();
            d2 = d2.getNext();
        } while ((d1.getNext()!=null)&&(d2.getNext()!=null));
        
        int last = d1.getElement()+d2.getElement()+addingValue;
        addingValue = last / 10;
        last = last % 10;
        result.setElement(last);
        if(addingValue != 0) {
            result = new Entry (1, result);
        }
        return result;
    }
    
     private static class Entry <E>
    {
       private E element;
       private Entry<E> next;
       

        Entry(E element, Entry<E> next)
        {
            this.element = element;
            this.next = next;
        }
        
        public E getElement()
        {
            return element;
        }
        
        public void setElement (E elem)
        {
            this.element = elem;
        } 
        
        public void setNext (Entry nextEntry)
        {
            this.next = nextEntry;
        }
        
        
        public Entry<E> getNext ()
        {
            return next;
        }
        
        public void print()
        {
            Entry current = this;
            System.out.println("Printing list");
                
            while (current.getNext()!=null)
            {
                System.out.println(current.element);
                current = current.getNext();
            }
            
            System.out.println(current.element);
                
            System.out.println("No more elements");
        }
        
        
        
    }
}
