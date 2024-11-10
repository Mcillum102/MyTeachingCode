package javajerry;

import java.util.Arrays;

public class Class6 {
    
    public static void main(String[] args) {

        String s =  new String("hello e");

        // System.out.println(s.indexOf("e",2));

        int[] numberArray = new int[3];

        String[] stringArray = new String[5];
        
        numberArray[0] = 110;
        numberArray[1] = 100;
        numberArray[2] = 90;

        // System.out.println(numberArray[1]); // print at index

        // A for loop example to print each items out
        for (int i = 0; i < numberArray.length; i++) {
            System.out.println(numberArray[i] + " ");
        }

        /* For each loop
         * 1. the variable you use to represent the items MUST be the same type as the arrayu
         * This only works for arrays
         */
        for (int i : numberArray) {
            System.out.println(i);
        }


        // Create an array using set
        int[] intArray = {1,2,3,4,5};

        String[] strArray = {"Hello", "nihao"};
        String sssss = "nihao";
        // We are not able to directly print array as it is in Python
        System.out.println(intArray); // This will show the address of array.
     }
}
