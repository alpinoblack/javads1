package org.orca.data_structures.lists;

import java.util.NoSuchElementException;

public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root = null;
    private int sizeOfList = 0;

    private void insertDataAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(this.root);
        this.root = newNode;
    }

    private void insertDataAtEnd(T data, Node<T> currentNode) {

        if (currentNode.getNextNode() == null){
            Node<T> newNode = new Node<>(data);
            currentNode.setNextNode(newNode);
        } else {
            insertDataAtEnd(data, currentNode.getNextNode());
        }


    }

    public void remove(T data) {

        if (this.root == null) return;

        if (this.root.getData().compareTo(data) == 0) {
            this.root = this.root.getNextNode();
        } else {
            remove(data, root, root.getNextNode());
        }

    }

    private void remove(T data, Node<T> previousNode, Node<T> currentNode) {

        while(currentNode != null) {
            if (currentNode.getData().compareTo(data) == 0) {
                previousNode.setNextNode(currentNode.getNextNode());
                --this.sizeOfList;
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

    }

    public void traverseList() {

        Node<T> currentNode = this.root;
        int nodeIdx = sizeOfList;
        while (currentNode != null) {
            System.out.println("node " + nodeIdx + " is " + currentNode.toString());
            currentNode = currentNode.getNextNode();
            nodeIdx--;
        }

    }

    public int size() {
        return this.sizeOfList;
    }

    public void insert(T data) {

        ++this.sizeOfList;

        if (root == null) {
            this.root = new Node<>(data);
        } else {
            insertDataAtBeginning(data);
        }


    }

    @Override
    public void reverseList(){
        if (root != null) {
            root = reverseListAux(null, root);
        }
    }

    private Node<T> reverseListAux(Node<T> previous, Node<T> current){
        if (current.getNextNode() != null){
            Node<T> nextCurrent = current.getNextNode();
            current.setNextNode(previous);
            return reverseListAux(current, nextCurrent);
        } else {
            current.setNextNode(previous);
            return current;
        }
    }

    private Node<T> findNodeNthFromEnd(int n) {

        if (n > sizeOfList) {
            throw new NoSuchElementException("list is too short!");
        } else {
            Node<T> probeNode = root;
            Node<T> tracerNode = root;
            while(probeNode.getNextNode() !=  null && n > 0) {
                probeNode = probeNode.getNextNode();
                n--;
            }

            while(probeNode.getNextNode()!= null) {
                probeNode = probeNode.getNextNode();
                tracerNode = tracerNode.getNextNode();
            }

            return tracerNode;

        }

    }

    @Override
    public void shiftRight(int numOfShifts){
        if (root != null && numOfShifts != 0 && sizeOfList != 0 && numOfShifts % sizeOfList > 0) {

            int effectiveShifts = numOfShifts % sizeOfList;

            Node<T> newLast = findNodeNthFromEnd(effectiveShifts);

            Node<T> newRoot = newLast.getNextNode();

            newLast.setNextNode(null);

            Node<T> lastNodeOfNewNodeSubList = newRoot;

            while(lastNodeOfNewNodeSubList.getNextNode() != null) {
                lastNodeOfNewNodeSubList = lastNodeOfNewNodeSubList.getNextNode();
            }

            lastNodeOfNewNodeSubList.setNextNode(root);

            root = newRoot;

        }
    }

}