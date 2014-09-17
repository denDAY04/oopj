package computerscience;

import java.util.ArrayList;
import java.util.Arrays;



/**
 * @revision 1.0
 * @author Andreas Stensig Jensen
 * @contributers Mathias Nordahl, Jonas Grum-Schwensen, Rasmus Loft 
 */
public class ArraySorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arrSize = 10000;
        long timeBegin, timeEnd;            // For quick-sort time calculation
        
        /* Assortment type of the values in the array.
        0 = random; 1 = ascending; 2 = descending */
        int arrType = 0;         
        
        /* Six arrays are needed for each test at different arrSize: 
        Three for Insertion sort and three for Quick sort. Three because there 
        will be done three runs of the same sort, on the same array-values, to
        minimize meassuring errors.
        */
        ArrayList<int[]> testArrIns;                // For insertion sort
        ArrayList<int[]> testArrQui;                // For quick sort
        
        
        /* Do full-copy of array values into the six arrays */
        int[] tempArr = generateArray(arrSize, arrType);
        testArrIns = new ArrayList<>();
        testArrQui = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            testArrIns.add(Arrays.copyOf(tempArr, arrSize));
            testArrQui.add(Arrays.copyOf(tempArr, arrSize));
        }

        /* Sorting of the six arrays, in pairs of Insertion & quick sort with 
        each iteration. */
        long timeIns, timeQui;
        for (int i = 0; i < 3; i++) {
            /* Insertion sort */ 
            timeIns = insertionSort(testArrIns.get(i));
            System.out.println("Insertion sort elapsed time: " + timeIns 
                               + " ms." );
            /* Quick sort */
            timeBegin = System.currentTimeMillis();
            Arrays.sort(testArrQui.get(i));
            timeEnd = System.currentTimeMillis();
            timeQui = timeEnd - timeBegin;
            System.out.println("Quick sort elapsed time: " + timeQui 
                                + " ms.");
            System.out.println("");                     // empty line 
            
        }
        
       /* For cross-checking that the array is sorted */ 
//        for (int i = 0; i < arrSize; i++) {
//            System.err.println("" + testArrIns.get(0)[i]);
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
        int j;                                         // Secondary index value

        timeBegin = System.currentTimeMillis();
        for (int i = 1; i < arr.length; i++) {
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

            /* Descending assortment */
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
