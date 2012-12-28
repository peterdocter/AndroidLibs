package info.linxiangyu.helper;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class SHA1Test {

    @Test
    public void test() throws NoSuchAlgorithmException {
        assertEquals(SHA1.toSHA1("HYQ"), "00cf613b06e252a2b04f3bc037714c4f9f120d46");
    }

}
