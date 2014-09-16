/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerscience;

import java.util.Arrays;



/**
 *
 * @author AndreasStensig
 */
public class ArraySorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arrSize = 10000;
        long timeBegin, timeEnd;                        // For quick-sort
        int[] testArr = generateArray(arrSize, 0);      // Randome
        //int[] testArr = generateArray(length, 1);     // Best case
        //int[] testArr = generateArray(length, 2);     // Worst case
        /* Full-copy of array for quick-sort */
        int[] testArrCopy = Arrays.copyOf(testArr, testArr.length);
        
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
//        for (int i = 0; i < length; i++) {
//            System.err.println("" + testArr[i]);
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
    public static long insertionSort(int[] arr) {
        int currentValue;   // Value we are currently comparing against array
        long timeBegin, timeEnd;
        int j, temp;

        timeBegin = System.currentTimeMillis();
        for (int i = 1; i < (arr.length); i++) {
            j = i;
            currentValue = arr[i];
            while ((j > 0) && (arr[j-1] > currentValue)) {
                arr[j] = arr[j - 1];
                arr[j - 1] = currentValue;
                j--;
            }
        }
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
    public static int[] generateArray(int length, int mode) {
        int[] arr = new int[length];

        switch (mode) {

            /* Random assortment */
            case 0:
                int scalar = 1000000;
                for (int i = 0; i < length; i++) {
                    arr[i] = (int) (Math.random() * scalar);
                }
                break;

            /* Ascending assortment */
            case 1:
                for (int i = 0; i < length; i++) {
                    arr[i] = (i + 1);
                }
                break;

            /* Descending assortment*/
            case 2:
                int k = 0;
                for (int i = length; i > 0; i--) {
                    arr[k++] = i;
                }
                break;
        }
        return arr;
    }

}
