//package org.uw.sort.test;
//
//import java.util.Arrays;
//import java.util.Random;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.uw.sort.QuickSort;
//
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;
//
//public class QuicksortTest {
//
//  private Comparable[] numbers;
//  private final static int SIZE = 7;
//  private final static int MAX = 20;
//
//  @Before
//  public void setUp() throws Exception {
//    numbers = new Comparable[SIZE];
//    Random generator = new Random();
//    for (int i = 0; i < numbers.length; i++) {
//      numbers[i] = generator.nextInt(MAX);
//    }
//  }
//
//  @Test
//  public void testNull() {
//    QuickSort.sort(null);
//  }
//
//  @Test
//  public void testEmpty() {
//    QuickSort.sort(numbers);
//    QuickSort.sort(new Comparable[0]);
//  }
//
//  @Test
//  public void testSimpleElement() {
//    QuickSort.sort(numbers);
//    Comparable[] test = new Comparable[1];
//    test[0] = 5;
//    QuickSort.sort(test);
//  }
//
//  @Test
//  public void testSpecial() {
//    QuickSort.sort(numbers);
//    Comparable[] test = { 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 };
//    QuickSort.sort(test);
//    if (!validate(test)) {
//      fail("Should not happen");
//    }
//    printResult(test);
//  }
//
//  @Test
//  public void testQuickSort() {
//    for (Comparable i : numbers) {
//      System.out.println(i + " ");
//    }
//    long startTime = System.currentTimeMillis();
//
//    QuickSort.sort(numbers);
//    
//
//    long stopTime = System.currentTimeMillis();
//    long elapsedTime = stopTime - startTime;
//    System.out.println("QuickSort " + elapsedTime);
//
//    if (!validate(numbers)) {
//      fail("Should not happen");
//    }
//    assertTrue(true);
//  }
//
//  @Test
//  public void testStandardSort() {
//    long startTime = System.currentTimeMillis();
//    Arrays.sort(numbers);
//    long stopTime = System.currentTimeMillis();
//    long elapsedTime = stopTime - startTime;
//    System.out.println("Standard Java sort " + elapsedTime);
//    if (!validate(numbers)) {
//      fail("Should not happen");
//    }
//    assertTrue(true);
//  }
//
//  private boolean validate(Comparable[] numbers) {
//    for (int i = 0; i < numbers.length - 1; i++) {
//      if (numbers[i].compareTo(numbers[i + 1]) > 0) {
//        return false;
//      }
//    }
//    return true;
//  }
//
//  private void printResult(Comparable[] numbers) {
//    for (int i = 0; i < numbers.length; i++) {
//      System.out.print(numbers[i]);
//    }
//    System.out.println();
//  }
//} 