package info.linxiangyu.helper;

import org.junit.Test;

import junit.framework.TestCase;


public class MD5Test extends TestCase {

    @Test
    public void test() {
        assertEquals("b3143e5314d8473a7514f352bb7ff5ac", MD5.toMD5("HYQ"));
    }

}
