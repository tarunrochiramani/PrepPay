package com.tr.ctci.stacksAndQueues;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AnimalShelterTest {

    private AnimalShelter animalShelter = new AnimalShelter();

    @Before
    public void canEnqueue() {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();

        animalShelter.enqueue(dog1);
        animalShelter.enqueue(dog2);
        animalShelter.enqueue(cat1);
        animalShelter.enqueue(cat2);
    }

    @Test
    public void dequeueAny() {
        int firstAnimalDequeueOrder = animalShelter.dequeueAny().getOrder();
        int secondAnimalDequeueOrder =animalShelter.dequeueAny().getOrder();
        int thirdAnimalDequeueOrder =animalShelter.dequeueAny().getOrder();
        int fourthAnimalDequeueOrder =animalShelter.dequeueAny().getOrder();

        assertTrue(firstAnimalDequeueOrder < secondAnimalDequeueOrder);
        assertTrue(secondAnimalDequeueOrder < thirdAnimalDequeueOrder);
        assertTrue(thirdAnimalDequeueOrder < fourthAnimalDequeueOrder);
    }

    @Test
    public void dequeueDog() {
        Dog newDog = new Dog();
        animalShelter.enqueue(newDog);
        assertEquals(1, animalShelter.dequeueDogs().getOrder());
    }

    @Test
    public void dequeueCat() {
        Cat newCat = new Cat();
        animalShelter.enqueue(newCat);
        assertEquals(3, animalShelter.dequeueCats().getOrder());
    }




}
