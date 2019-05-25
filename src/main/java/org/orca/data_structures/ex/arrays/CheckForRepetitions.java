package org.orca.data_structures.ex.arrays;

/**
 * all values are smaller than length of the array
 */
public class CheckForRepetitions {

    public CheckForRepetitions() {
    }

    public void CheckForRepetitions(int[] arr){

        for(int i =0; i<arr.length; i++){

            if (arr[Math.abs(arr[i])]> 0 ) {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            } else {
                System.out.println(Math.abs(arr[i]) + "is a repetition");
            }  

        }
    }
}
