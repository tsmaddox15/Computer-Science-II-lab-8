/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs1181_lab8_maddox;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author Taylor Maddox Instructor: Rick Volker TA: Sai Polamarasetty
 */
public class CS1181_Lab8_Maddox {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean cont = false;
        int radixFunction = 0;
        System.out.print("Enter the size for the array to be sorted: ");
        int arraySize = keyboard.nextInt();

        //Checks if radix is withing the 2-20, if not repeats till a valid input
        while (cont == false) {
            System.out.print("Enter a radix sort function. Value must be betwen  2 and 20: ");
            int inputRadix = keyboard.nextInt();
            //int inputRadix = 10;
            if (inputRadix >= 2 && inputRadix <= 20) {

                radixFunction = inputRadix;
                cont = true;

            } else {
                System.out.println("Invalid input try again.");
            }
        }

        //Creates a sort object.
        Sort sort = new Sort();
        
        //Call to fill the array.
        int[] array = sort.fill(arraySize);
        System.out.println("Array before sorting:");
        System.out.println(Arrays.toString(array));
        System.out.println("");
        
        //Call to sort the array
        int[] arraySorted = sort.radixSort(array, radixFunction);
        System.out.println("Array sorted: ");
        System.out.println(Arrays.toString(arraySorted));
    }

}
