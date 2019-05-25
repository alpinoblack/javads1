package org.orca.data_structures.ex.arrays;

import java.util.Arrays;

public class CheckIfAnagram {

    public CheckIfAnagram() {

    }

    public boolean checkIfAnagrams(char[] str1, char[] str2) {

        if (str1.length != str2.length) {
            return false;
        }

        Arrays.sort(str1);
        Arrays.sort(str2);

        for(int i = 0; i < str1.length; i ++) {
            if (str1[i] != str2[i]){
                return false;
            }
        }

        return true;

    }
}
