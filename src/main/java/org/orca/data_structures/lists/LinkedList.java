package org.orca.data_structures.lists;

public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root = null;
    private int sizeOfList;

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
            System.out.println("node " + nodeIdx + "is " + currentNode.toString());
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

}