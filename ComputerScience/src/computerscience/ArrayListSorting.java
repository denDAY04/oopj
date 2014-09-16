/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscience;

import java.util.ArrayList;
import java.util.Arrays;



/**
 *
 * @author AndreasStensig
 */
public class ArrayListSorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arrSize = 10000;
        long timeBegin, timeEnd;                        // For quick-sort
        ArrayList<Integer> testArr = generateArray(arrSize, 0);      // Randome
        //ArrayList<Integer> testArr = generateArray(arrSize, 1);      // Best-case
        //ArrayList<Integer> testArr = generateArray(arrSize, 2);      // worst-case
        /* Full-copy of array for quick-sort */
        Object[] testArrCopy = testArr.toArray();
        
        /* Insertion sort */
        long time = insertionSort(testArr);
        System.err.println("Isertion sort elapsed time: " + time + " ms = "
                            + time / 60000.0 + " minutes");
        
        /* Quick-sort */
        timeBegin = System.currentTimeMillis();
        Arrays.sort(testArrCopy);
        timeEnd = System.currentTimeMillis();
        long time2 = timeEnd - timeBegin;
        System.err.println("Quick sort elapsed time: " + time2 + " ms = "
                            + time2 / 60000.0 + " minutes");
        
       /* For cross-checking that the original array is sorted */ 
//        for (int i = 0; i < testArr.size(); i++) {
//            System.err.println("" + testArr.get(i).toString());
//        }
    }


    /**
     * Insertion sorting algorithm.
     *
     * @param arr the array that is to be sorted (of type int). Note that the
     *            array is manipulated directly, and not copied and returned.
     *
     * @return the time it took to sort the array, in milliseconds.
     */
    public static long insertionSort(ArrayList<Integer> arr) {
        Integer currentValue;   // Value we are currently comparing against array
        long timeBegin, timeEnd;
        Integer temp;
        int j;
        
        timeBegin = System.currentTimeMillis();
        for (int i = 1; i < arr.size(); i++) {
            currentValue = arr.get(i);
            j = i;
            while (j > 0 && arr.get(j - 1).compareTo(currentValue) > 0) {
                temp = arr.get(j-1);
                arr.set(j, temp);
                arr.set(j-1, currentValue);
                j--;
            }
                
        }
        
//        for (int i = 1; i < arr.size(); i++) {
//            j = i;
//            currentValue = arr.get(i);
//            while ((j > 0) && (arr.get(j-1) > currentValue)) {
//                arr. = arr.get(j - 1);
//                arr.get(j-1) = currentValue;
//                j--;
//            }
//        }
        timeEnd = System.currentTimeMillis();

        return timeEnd - timeBegin;
    }

    /**
     * Generate an array of primitive int values with the length being an
     * argument and the mode controlling the assortment.
     *
     * @param length length of the array.
     * @param mode   specifies the assortment of the array: 0 for random; 1 for
     *               ascending; 2 for descending.
     *
     * @return the filled array, or an array with empty values if the mode was
     *         out of range.
     */
    public static ArrayList generateArray(int length, int mode) {
        ArrayList<Integer> arr = new ArrayList<>();

        switch (mode) {

            /* Random assortment */
            case 0:
                int scalar = 1000000;
                for (int i = 0; i < length; i++) {
                    arr.add((int) (Math.random() * scalar));
                }
                break;

            /* Ascending assortment */
            case 1:
                for (int i = 0; i < length; i++) {
                    arr.add(i + 1);
                }
                break;

            /* Descending assortment*/
            case 2:
                for (int i = length; i > 0; i--) {
                    arr.add(i);
                }
                break;
        }
        return arr;
    }

}
