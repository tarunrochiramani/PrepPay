package com.tr.javaplay.file;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(JUnit4.class)
public class FilePlayGroundTest {
    FilePlayGround filePlayGround = new FilePlayGround();

    @Test
    public void canFileWriteRead() throws IOException {
          filePlayGround.fileWriteRead();
    }

    @Test
    public void canSerializeDog() throws IOException {
        filePlayGround.serializeDog();
    }

    @Test
    public void canDeserializeDog() throws Exception {
        Dog dog = filePlayGround.deserializeDog();

        assertNotNull(dog);
    }

    @Test
    public void canSerializeAnimal() throws IOException {
        Cat cat = new Cat();
        cat.setName("I am a cat");
        cat.setNum(5);

        filePlayGround.serializeAnimal(cat);
    }

    @Test
    public void canDeserializeAnimal() throws IOException, ClassNotFoundException {
        Cat cat = (Cat) filePlayGround.deserializeAnimal();

        assertNotNull(cat);
        assertFalse(cat.getName().equals("I am an Animal"));
    }

    @Test
    public void cannotSearchWithoutOverrideEquals() throws Exception {
        Cat cat = new Cat();
        cat.setName("I am a cat");
        cat.setNum(5);

        filePlayGround.serializeAnimal(cat);

        Map<Cat, String> mymap = new HashMap<Cat, String>();
        mymap.put(cat, "blah");

        Cat cat1 = filePlayGround.deserializeAnimalWithGenerics(cat);
        cat1.setNum(cat.getNum());
        cat1.setName(cat.getName());

        assertNull(mymap.get(cat1));
    }



}
