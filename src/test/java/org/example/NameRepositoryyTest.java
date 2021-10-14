package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameRepositoryyTest {

    private String [] data;

    @Before
    public void setUp()  {
        NameRepositoryy.clear();
        String [] startedData = {"Haris Gusinac","Erik Svensson","Peter Andersson"};
        data = startedData;
        NameRepositoryy.setName(startedData);
    }

    @Test
    public void getSize() {
        int expectedSize =3;
        int actual= NameRepositoryy.getSize();

        assertEquals(actual,expectedSize);
    }

    @Test
    public void setName() {
        NameRepositoryy.clear();
        String [] data = {"Haris Gusinac","Bajro Gusinac"};
        int expectedSize =2;

        NameRepositoryy.setName(data);

        assertEquals(NameRepositoryy.getSize(),expectedSize);
    }

    @Test
    public void clear() {


        int expectedSize=0;
        NameRepositoryy.clear();
        assertEquals(NameRepositoryy.getSize(),expectedSize);
    }

    @Test
    public void findAll() {
        String [] expected = data;

        NameRepositoryy.setName(expected);
        String [] result = NameRepositoryy.findAll();

        assertArrayEquals(result,expected);
    }

    @Test
    public void find() {
        String fullname = "Haris gusinac";
        String expected = "Haris Gusinac";

        String result = NameRepositoryy.find(fullname);

        assertEquals(result,expected);
    }

    @Test
    public void add() {
        String fullname = "Erik Svennson";
        assertTrue(NameRepositoryy.add(fullname));
        assertEquals(4,NameRepositoryy.getSize());
    }
    @Test
    public void add_false(){
        String fullName ="Peter andersson";
        assertFalse(NameRepositoryy.add(fullName));
        assertEquals(3,NameRepositoryy.getSize());
    }

  /*
    @Test
    public void remove() {


        boolean result = NameRepositoryy.remove("Haris Gusianc");


        assertTrue(result);

        assertEquals(true,NameRepositoryy.getSize());
    }
    */
}