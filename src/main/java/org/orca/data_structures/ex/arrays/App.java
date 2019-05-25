package org.orca.data_structures.ex.arrays;

public class App {

    private static void printArr(int[] arr){
        for (int e : arr) {
            System.out.println(e);
        }
    }

    public static void main(String[] args){

        ReverseArray reverseArray = new ReverseArray();

        int[] arr = new int[]{1,2,3};

        int[] reversedArr = reverseArray.reverseArrayInPlace(arr);

        printArr(reversedArr);

        CheckIfAnagram checkIfAnagram = new CheckIfAnagram();

        String str1 = "abc";
        String str2 = "cca";

        System.out.println(checkIfAnagram.checkIfAnagrams(str1.toCharArray(), str2.toCharArray()));


    }
}
