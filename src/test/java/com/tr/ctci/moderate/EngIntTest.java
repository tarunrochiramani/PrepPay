package com.tr.ctci.moderate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class EngIntTest {
    EngInt engInt = new EngInt();

    @Test
    public void canConvert() {
        assertEquals("Zero" , engInt.toEnglish(0));
        assertEquals("Eleven" , engInt.toEnglish(11));
        assertEquals("Ninety Nine" , engInt.toEnglish(99));
        assertEquals("One Hundred Ninety Nine" , engInt.toEnglish(199));
        assertEquals("One Thousand One Hundred Ninety Nine" , engInt.toEnglish(1199));
        assertEquals("Eleven Thousand One Hundred Ninety Nine" , engInt.toEnglish(11199));
        assertEquals("One Hundred Eleven Thousand One Hundred Ninety Nine" , engInt.toEnglish(111199));
        assertEquals("One Million One Hundred Eleven Thousand One Hundred Ninety Nine" , engInt.toEnglish(1111199));
    }
}
