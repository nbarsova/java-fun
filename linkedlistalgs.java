/* package whatever; // don't place package name! */

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;


class myCode
{
    
    
    public static void main (String[] args) throws java.lang.Exception
    {
        Entry new1 = new Entry <Integer> (1, null);
        Entry new2 = new Entry <Integer>  (5, new1);
        Entry new3 = new Entry <Integer>  (3, new2);
        Entry new4 = new Entry <Integer>  (7, new3);
        Entry new5 = new Entry <Integer>  (8, new4);
        Entry new6 = new Entry <Integer>  (16, new5);
        Entry new7 = new Entry <Integer>  (2, new6);
        
        new7.print();
        
        Entry new8 = splitList2(new7, 4);
        
        new8.print();
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
    /*  Write code to partition a linked list around a value x, 
        such that all nodes less than x
        come before alt nodes greater than or equal to 
    */
    public static Entry <Integer> splitList (Entry<Integer> list, Integer splitValue)
    {
        System.out.println("Splitting started");
        Entry <Integer> currentPointer = list;
        Entry <Integer> prevPointer=null;
            
        Entry <Integer> head = list;
        do
        {
            System.out.println("Current node is "+currentPointer.getElement());
            if (prevPointer!=null) {
                System.out.println("Previous node is "+prevPointer.getElement());
            }
            Entry<Integer> nextNode = currentPointer.getNext();

            if (currentPointer.getElement()<=splitValue)
            {
                System.out.println("Moving " +currentPointer.getElement());
                Integer value = currentPointer.getElement();
                
               
                head = new Entry (value, head);
                System.out.println("New head is "+value);
 //               prevPointer = currentPointer;
                   
                if (nextNode!=null) {
                    currentPointer.setNext(nextNode.getNext());
                    currentPointer.setElement(nextNode.getElement());
                } else {
                   currentPointer = null;
                    prevPointer.setNext(null);
                }

            } else 
            {
                prevPointer = currentPointer;
                currentPointer = nextNode;
            }

        }
        while (currentPointer!=null); 
        
        return head;

    }
    
    private static Integer getKthEntry (Entry <Integer> myList, int k)
    {
        int counter = 0;
        Entry current = myList;
        while (counter<k)
        {
            if (current.getNext()!=null)
            {
                System.out.println(myList.getElement());
                current = current.getNext();
                counter++;
            } else {
                throw new IllegalArgumentException(k + " is bigger than list size: "+(counter+1));
            }
        }
        return (Integer) current.getElement();
    }
    
    
    
    
    
    
    
    public static void printList(LinkedList <Integer> list)
    {
        ListIterator it = list.listIterator(0);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    
    public static LinkedList <Integer> removeDoubles (LinkedList <Integer> list)
    {
        System.out.println("Removing doubles started");
        LinkedList <Integer> uniqueList = new LinkedList <Integer> ();
        ListIterator <Integer> oldListIt = list.listIterator();
        
        while (oldListIt.hasNext()) {
            Integer curr = (Integer) oldListIt.next();
            ListIterator <Integer> newListIt = uniqueList.listIterator();
            boolean isNotUnique = false;
            while (newListIt.hasNext())
            {
                if (curr.equals(newListIt.next()))
                {
                    isNotUnique = true;
                    break;
                }
            }
            
            if (!isNotUnique)
            {
                uniqueList.add(curr);
            }
        }
        return uniqueList;
    }
    
    
    
    
    public static Entry <Integer> splitList2 (Entry<Integer> list, Integer splitValue)
    {
      if (list == null) {
          throw new NullPointerException();
      }
      Entry<Integer> greater = null;
      Entry<Integer> lastElementG = null;  
      Entry<Integer> lessOrEqual = null;
        
      Entry<Integer> current = list;  
      
      while(current != null) {
          int value = current.getElement();
          Entry<Integer> next  = current.getNext();
      
          if(value <= splitValue) {
              current.setNext(lessOrEqual);
              lessOrEqual = current; 
          } else {
              current.setNext(greater);
              greater = current;
              if(lastElementG == null) {
                  lastElementG = current;
              }
          }
        current = next;
          
      }
      if (lastElementG != null) {
          lastElementG.setNext(lessOrEqual);
          return greater;
      } else {
          return lessOrEqual;
      }
    }    
    
    
}
