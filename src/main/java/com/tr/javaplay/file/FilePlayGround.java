package com.tr.javaplay.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FilePlayGround {
    public void fileWriteRead() throws IOException {
        File file = new File("tarun.txt");
        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write("Creating a file test");
        fileWriter.flush();
        fileWriter.close();

        char[] charArray = new char[50];
        FileReader fileReader = new FileReader(file);
        fileReader.read(charArray);

        System.out.println(charArray.length);
        for (char c : charArray) {
            System.out.println(c);
        }
        fileReader.close();

        file.delete();
    }


    public void serializeDog() throws IOException {
        Dog dog = initializeAnimal();

        File file = new File("dog.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(dog);
    }

    public Dog deserializeDog() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(new File("dog.txt"));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Dog dog = (Dog) objectInputStream.readObject();
        return dog;
    }

    public void serializeAnimal(Animal animal) throws IOException {
        File file = new File("animal.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(animal);
    }

    public Animal deserializeAnimal() throws IOException, ClassNotFoundException {
        File file = new File("animal.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        return (Animal) objectInputStream.readObject();
    }

    public <T extends Animal> T deserializeAnimalWithGenerics(T type) throws IOException, ClassNotFoundException {
        File file = new File("animal.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        return (T) objectInputStream.readObject();
    }

    private Dog initializeAnimal() {
        Brand brand = new Brand();
        brand.setName("Gucci");

        Collar collar = new Collar();
        collar.setSize(4);
        collar.setBrand(brand);

        Dog dog = new Dog();
        dog.setName("Tommy");
        dog.setCollar(collar);

        return dog;
    }
}
