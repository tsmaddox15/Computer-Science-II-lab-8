/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs1181_lab8_maddox;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tsmad_000
 */



    
public class Sort {
    
    private class tnode {

        int value;
        tnode left;
        tnode right;

        public tnode(int value, tnode left, tnode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public Sort() {

    }

    /**
     * Creates an array and fills it with random numbers from 0-10000.
     *
     * @param arraySize, The size of the array
     * @return array, contains an array with random integer values.
     */
    public int[] fill(int arraySize) {
        int[] array = new int[arraySize];
        for (int i = 0; i < array.length; i++) {
            int num = (int) (Math.random() * 10000 + 0);
            array[i] = num;

        }
        return array;
    }

    /**
     * Sorts the array of numbers with ascending order. Can sort based on different bases.
     *
     * @param array, The array before the sorting
     * @param radix, What base we want to sort.
     * @return array, array that has been sorted.
     */
    public int[] radixSort(int[] array, int radix) {
        int maxDigit = 1;

        //Creates an arraylist for the buckets than creates another arraylist within the buckets to hold multiple values.
        List<Integer>[] buckets = new ArrayList[radix];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        //Determines the largest number in the array.
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        //Determines how many digits are in the larget nummber in the array.
        for (int i = radix; i < max; maxDigit++) {
            i *= radix;
        }

        //Puts the values inside the bucke arraylist based on each digit.
        int divisor = 1;
        for (int i = 0; i < maxDigit; i++) {
            for (int j = 0; j < array.length; j++) {
                int index = (array[j] / divisor) % (radix);
                buckets[index].add(array[j]);
            }

            divisor *= radix;

            //Takes the values from the bucket and puts them back into the array sorted than emptys the buckets to repeat the process.
            int c = 0;
            for (int a = 0; a < radix; a++) {
                for (int b = 0; b < buckets[a].size(); b++) {
                    array[c] = buckets[a].get(b);
                    c++;
                }
                buckets[a].clear();
            }
        }
        return array;
    }
}
