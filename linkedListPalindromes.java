 /* package whatever; // don't place package name! */

import java.io.*;

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Entry new1 = new Entry <Character> (new Character ('R'), null);
        Entry new2 = new Entry <Character>  (new Character ('A'), new1);
        Entry new3 = new Entry <Character>  (new Character ('D'), new2);
        Entry new4 = new Entry <Character>  (new Character ('A'), new3);
        Entry new5 = new Entry <Character> (new Character ('N'), new4);
        
        new5.print();
        System.out.println("Is a palindrome? "+palindromeCheck(new5));
        
    }
    
    private static boolean palindromeCheck (Entry <Character> phrase)
    {
        
        if (phrase == null) {
            return false;
        } else {
        Entry forward = phrase;
        Entry backward = new Entry (forward.getElement(), null);
            
        while  (forward!=null)
        {
            backward = new Entry (forward.getElement(), backward);
            forward = forward.getNext();
        }
        
        forward = phrase;
        
        while (forward!=null) {
            
            if (!(backward.getElement().equals(forward.getElement())))
            {
                System.out.println("Met "+backward.getElement() + " and " + forward.getElement());
                return false;
            }
            else {
                forward = forward.getNext();
                backward = backward.getNext();
            }
            
        } 
        return true;
        }
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
