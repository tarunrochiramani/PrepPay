package com.tr.javaplay.file;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Dog extends Animal implements Serializable {
    private transient Collar collar;

    public Collar getCollar() {
        return collar;
    }

    public void setCollar(Collar collar) {
        this.collar = collar;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();

        objectOutputStream.writeInt(this.collar.getSize());
        objectOutputStream.writeBytes(this.collar.getBrand().getName());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();

        Collar collar = new Collar();
        collar.setSize(objectInputStream.readInt());

        Brand brand = new Brand();

        objectInputStream.readByte();

        this.collar = collar;
    }

}
