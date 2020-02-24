package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneretedTest {
    Genereted genereted = new Genereted();
    String a = genereted.generate();
    String b = genereted.generate();
    String c = genereted.generate();
    String d = genereted.generate();
    String e = genereted.generate();
    String f = genereted.generate();
    String g = genereted.generate();
    String h = genereted.generate();
    @Test
    void isValidString() {
        assertTrue(genereted.generate().matches("[0-9A-Z]*"));
    }
    @Test
    void isValidLenght() {
        assertTrue(a.length()==b.length()  && c.length()==d.length()
                && e.length()==f.length() && g.length()==h.length() && a.length()==d.length()
                && f.length()==g.length() && a.length()==g.length());
    }
    @Test
    void isUniqual() {
        assertTrue(!a.equals(b) && !c.equals(d) && !e.equals(f) && !g.equals(h)
                && !a.equals(d) && !f.equals(g) && !a.equals(g));
    }
    @Test
    void isNextValid(){
        assertTrue(Integer.parseInt(a.substring(32)) +1 == Integer.parseInt(b.substring(32)) &&
                Integer.parseInt(c.substring(32)) +1 == Integer.parseInt(d.substring(32)) );


    }
}