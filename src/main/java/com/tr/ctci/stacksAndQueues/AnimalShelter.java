package com.tr.ctci.stacksAndQueues;

import java.util.LinkedList;

public class AnimalShelter {
    private int counter = 0;
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();

    public void enqueue(Animal animal) {
        counter++;
        animal.setOrder(counter);
        if (animal instanceof Dog) {
            dogs.addLast((Dog) animal);
        } else {
            cats.addLast((Cat) animal);
        }
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty()) {
            return dequeueCats();
        } else if (cats.isEmpty()) {
            return dequeueDogs();
        }

        if (dogs.peek().getOrder() < cats.peek().getOrder()) {
            return dequeueDogs();
        }

        return dequeueCats();
    }

    public Cat dequeueCats() {
        return cats.poll();
    }

    public Dog dequeueDogs() {
        return dogs.poll();
    }
}


abstract class Animal {
    private int order;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        return order == animal.order;
    }

    @Override
    public int hashCode() {
        return order;
    }
}

class Dog extends Animal {}
class Cat extends Animal {}
