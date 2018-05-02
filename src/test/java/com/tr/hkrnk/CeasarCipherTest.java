package com.tr.hkrnk;

import com.tr.hkrnk.CeasarCipher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CeasarCipherTest {
    private CeasarCipher ceasarCipher = new CeasarCipher();

    @Test
    public void canCipher() {
        Assert.assertEquals("okffng-Qwvb", ceasarCipher.cipher("middle-Outz", 2));
    }
}
