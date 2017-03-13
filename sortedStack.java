/* package whatever; // don't place package name! */

import java.io.*;

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        
 /*       MyQueue mq = new MyQueue <Integer> ();
        
        for (int i=0; i<5; i++)
        {
            mq.push(new Integer(i));
        }
        
        for (int i=0; i<3; i++)
        {
            System.out.println(mq.pop());
        }
        
        
        mq.push(new Integer(5));
        mq.push(new Integer(6));
        
        for (int i=0; i<4; i++)
        {
            System.out.println(mq.pop());
        }
        
        */
            
       SortedStack ss = new SortedStack();
        
       ss.push(0);
        ss.push(2);
        ss.push(5);
        ss.push(3);
        ss.push(2);
        
        for (int i=0; i<5; i++)
        {
            System.out.println(ss.pop());
        }
    }
    
    private static class SortedStack {
        private Stack <Integer> smallStack = new Stack <Integer>();
        private Stack <Integer> bigStack = new Stack <Integer> ();
            
        public Integer pop ()
        {
            return smallStack.pop();
        }
        
        public void push (Integer value)
        {
            if ((smallStack.peek()==null) || (value>smallStack.peek()))
            {
                smallStack.push(value);
            } else 
            {
                while (smallStack.peek()>value)
                {
                    bigStack.push(smallStack.pop());
                }
                
                smallStack.push(value);
                
                while (bigStack.peek()!=null)
                {
                    smallStack.push(bigStack.pop());
                }
                    
            }
        }
        
    }
    
    
    private static class MyQueue <T>
    {
        private Stack <T> mainStack = new Stack <T> ();
        private Stack <T> auxStack = new Stack <T> ();
        private boolean sorted = false;
        
        public T pop () 
        {
            
            if (!sorted&&(mainStack.peek() == null))
                return null;
    
            if ((sorted == true)&&(auxStack.peek()!=null))
                return auxStack.pop();
                
            if (auxStack.peek()==null)
            {
                System.out.println("Reversing stacks");
                while (mainStack.peek()!=null)
                {
                    auxStack.push(mainStack.pop());
                }
                sorted = true;
                return auxStack.pop();
            }
            
            return null;
            
        }
        
        public void push (T value)
        {
            mainStack.push(value);
        }
        
        
    }
    
    private static class Stack<T> {
        private Node<T> top;

        public T pop() {
            if(top == null)
                return null;
            T value = top.getValue();
            top = top.getNext();
            return value;
        }

        public void push(T value) {

            // should have a check for null here?
            top = new Node(value, top);
        }

        public T peek() {
            if (top == null) {
                return null;
            }
            return top.getValue();
        }
}

private static class Node<T> {
    T value;
    Node<T> next;
    
    Node (T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
    
    public void setValue(T value) {
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }
    
    public void setNext(Node<T> next) {
        this.next = next;
    }
    
    public Node<T> getNext() {
        return next;
    }
}
}
