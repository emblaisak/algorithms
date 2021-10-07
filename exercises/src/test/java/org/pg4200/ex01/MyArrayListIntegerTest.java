package org.pg4200.ex01;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListIntegerTest {

    // This method is called to get a new instance
   private MyArrayListInteger getNewInstance() {
       return new MyArrayListInteger();
   }

   // List-variable to be assigned
   private MyArrayListInteger list;

   @BeforeEach
    public void initTest() {
       // Creates a new ArrayList
       list = getNewInstance();
   }

   @Test
    public void testEmpty() {
       // Test if a new container is empty
       assertEquals(0, list.size());
   }

   @Test
    public void testAddOneElement() {
       int size = list.size();

       list.add(22);

       assertEquals(size + 1, list.size());
   }

   @Test
   public void testAddAndRetrieveElement() {
       Integer value = 63;

       list.add(value);

       Integer listValue = list.get(0);

       assertEquals(value, listValue);
   }

   @Test
    public void testAdd5Elements() {
       Integer a = 30;
       Integer b = 209;
       Integer c = 6;

       list.add(a);
       list.add(b);
       list.add(c);
       list.add(b);
       list.add(a);

       assertEquals(a, list.get(0));
       assertEquals(b, list.get(1));
       assertEquals(c, list.get(2));
       assertEquals(b, list.get(3));
       assertEquals(a, list.get(4));
   }

   @Test
   public void testOutOfIndex() {
       list.add(48);

       assertNull(list.get(-5));
       assertNull(list.get(1));

       assertNotNull(list.get(0));
   }
}
