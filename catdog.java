// package whatever; // don't place package name!

import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.Collection;

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println("Hello Java");

        Cat catOne = new Cat ("Cat one", 5);
        Dog dogOne = new Dog ("Dog one", 10);
        
        Cat catTwo = new Cat ("Cat two", 20);
        Dog dogTwo = new Dog ("Dog two", 30);
        
        AnimalShelter newShelter = new AnimalShelter();
        newShelter.enqueue(catOne);
        newShelter.enqueue(dogOne);
        newShelter.enqueue(dogTwo);
        newShelter.enqueue(catTwo);
        
        newShelter.showLongTailedDogs();

        /*
        Cat thisCat = newShelter.deQueueCat();
        Animal thisAnimal = newShelter.deQueueAny();
        Cat anotherCat= newShelter.deQueueCat();
      */  

    }
    
    public static class Animal
    {
        private String name;
        private int tailLength=0;
        
        public Animal (String name, int tail)
        {
            this.name = name;
            this.tailLength = tail;
            System.out.println(name);
        }
        
        public void deQueue ()
        {
            System.out.print(name + " is removed from shelter");
        }
        
        public int getTailLength()
        {
            return tailLength;
        }
        
        public void describe ()
        {
            System.out.println("My name is "+name+ " and my tail length is "+ tailLength);
        }
        
    }
    
    
    public static class Cat extends Animal
    {
        
        public Cat (String name, int tail)
        {
            super(name, tail);
            System.out.println("Creating a cat");
            
        }
        
        public void deQueue ()
        {
            super.deQueue();
            System.out.println(" and takes a jug of milk with him");
            
        }
    }
    
    public static class Dog extends Animal
    {
        
        public Dog(String name, int tail)
        {
            super(name, tail);
            System.out.println("Creating a dog");
            
        }
        
        public void deQueue ()
        {
            super.deQueue();
            System.out.println(" and takes a leash with him");
            
        }
    }
    
    public static class AnimalShelter
    {
        private List<Animal> myShelter = new LinkedList<Animal>();
        private List<Cat> myCatShelter = new LinkedList<Cat>();
        private List<Dog> myDogShelter = new LinkedList<Dog>();
        
        public void enqueue (Animal animal)
        {
            
            if (animal instanceof Cat)
            {
                myShelter.add(animal);
                myCatShelter.add((Cat)animal);
            } else if (animal instanceof Dog) 
            {
                myShelter.add(animal);
                myDogShelter.add((Dog)animal);
            } else {
                System.out.println("Strange animal!");
            }
        }
        
        public Animal deQueueAny()
        {
            Animal taken = myShelter.remove(0);
            if (taken instanceof Cat)
            {
             myCatShelter.remove(taken);
            } else if (taken instanceof Dog) 
            {
                myDogShelter.remove(taken);
            }
            taken.deQueue();
            return taken;
            
        }
        
        public Cat deQueueCat()
        {
            Cat taken = myCatShelter.remove(0);
            myShelter.remove(taken);
            taken.deQueue();
            return taken;
        }
        
        public Dog deQueueDog()
        {
            Dog taken = myDogShelter.remove(0);
            myShelter.remove(taken);
            taken.deQueue();
            return taken;
        }
        
        public void showLongTailedDogs ()
        {
            
            
            List<Dog> longTailedDogs = myDogShelter.stream()
            .filter(p -> (p.getTailLength()>=5))            
            .collect(Collectors.toList());
            
            longTailedDogs.forEach(p -> p.describe());               
            
            
            
        }
    }
    
}

