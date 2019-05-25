package org.orca.data_structures.lists;

public class App {

    public static void main(String[] args) {

        List<Integer> integerList = new LinkedList<>();

        integerList.insert(10);
        integerList.insert(-2);
        integerList.insert(3);
        integerList.insert(100);

        System.out.println(integerList.size());

        integerList.traverseList();

        integerList.reverseList();

        integerList.traverseList();

    }

}
