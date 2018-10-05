package nl.hva.ict.ds;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class LinkedListTest {
    protected LinkedList<String> testList;

    @Before
    public void setup() {
        testList = new LinkedList<>();
    }

    @Test
    public void describeSettingJVMArguments() {
        System.out.println("In IntelliJ under run configurations and Debug you can pass program arguments");
       assertTrue(true);

    }
    //NewTest


    @Test
    public void addToEmptyList() {
        testList.add("one");

        assertTrue(testList.size() != 0);
        assertEquals("one", testList.get(0));
    }

    @Test
    public void addToListWithOneElement() {
        testList.add("one");
        testList.add("two");

        assertTrue(testList.size() != 0);
        assertEquals("two", testList.get(1));
    }

    @Test
    public void getFirstElement() {
        testList.add("one");

        assertEquals("one", testList.get(0));
    }

    @Test
    public void getLastElement() {
        testList.add("one");
        //LastElement is index 0 when adding only one element
        assertEquals("one", testList.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeIndexIsNotAllowed() {
        testList.get(-1);
    }

    @Test
    public void deleteFromListWithSingleElement() {
        testList.add("one");
        testList.delete("one");

        assertEquals(0, testList.size());
    }

    @Test
    public void deleteFromListWithMultipleOccurences() {
        testList.add("one");
        testList.add("one");
        testList.delete("one");

        assertEquals(0, testList.size());
    }

    @Test
    public void deleteFromListWithMultipleOccurrencesAndMoreElements() {
        testList.add("one");
        testList.add("two");
        testList.add("one");
        testList.delete("one");

        assertEquals(1, testList.size());
    }

    @Test
    public void sizeOfEmptyList() {
        assertEquals(0, testList.size());
    }

    @Test
    public void sizeOfListWithOneElement() {
        testList.add("one");
        assertEquals(1, testList.size());
    }

    // Extra unit tests go here
    @Test
    public void printAllTest(){
        testList.add("5");
        testList.add("4");
        testList.add("3");
        String expectedOutput = "5, 4, 3";
//        assertTrue(testList.printFromHeadToTail() == expectedOutput);
        assertEquals(expectedOutput, testList.printFromHeadToTail());
    }

    //Tests for index value over the maximum instead of under
    @Test(expected = IllegalArgumentException.class)
    public void invalidValueTest(){
        testList.add("5");
        testList.add("4");
        testList.add("3");

        testList.get(6);


    }
}
