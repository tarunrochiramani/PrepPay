package com.tr.geeks4geeks;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TinyURLTest {
    TinyURL tinyURL = new TinyURL();

    @Test
    public void can() {
        String temp = "http://www.crazyforcode.com/design-tinyurl-service/";
        String temp1 = "http://www.crazyforcode.com/nesigd-tinylru-ecivres/";

        String s = tinyURL.idToShortURL(temp.hashCode());
        String s1 = tinyURL.idToShortURL(temp1.hashCode());

        Assert.assertNotNull(s);
        Assert.assertNotNull(s1);
    }

    @Test
    public void can1() {
        tinyURL.numDistinct("rabbbit", "rabbit");
    }
}
