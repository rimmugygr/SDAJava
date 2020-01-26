package programowanie1.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SilniaTest {

    @Before
    public void setup(){
        System.out.println("Before");
    }

    @After
    public void clean(){
        System.out.println("Afterek");
    }

    @org.junit.Test
    public void testSilnia6() {
        System.out.println("test5");

        long silniaValue = Silnia.silnia(6);

        assertEquals(720,silniaValue);
    }

    @Test
    public void testSilnia5(){
        System.out.println("test6");
        long silniaValue=Silnia.silnia(5);
        assertEquals(120,silniaValue);
    }



}