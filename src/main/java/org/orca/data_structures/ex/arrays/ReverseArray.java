package org.orca.data_structures.ex.arrays;

public class ReverseArray {

    public ReverseArray() {
    }

    private void swap(int[] arr, int index1, int index2){

        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

    }

    public int[] reverseArrayInPlace(int[] arr) {

        int mid = arr.length / 2;

        for (int i = 0; i < mid; i++) {

            swap(arr, i, arr.length  - 1 - i);

        }

        return arr;

    }

}
