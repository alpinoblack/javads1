package org.orca.data_structures.bst;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    public BinarySearchTree() {
        super();
    }

    @Override
    public void insert(T data) {

        if (root == null) {
            root = new Node<>(data);
        } else {
            insert(data);
        }

    }

    @Override
    public void traversal() {

    }

    private void insertNode(T newData, Node<T> node) {

        if (newData.compareTo(node.getData()) < 0) {
            if (node.getLeftChild() != null) {
                insert(newData);
            } else {
                Node<T> newNode = new Node<>(newData);
                node.setLeftChild(newNode);
            }
        } else {
            if (node.getRightChild() != null) {
                insert(newData);
            } else {
                Node<T> newNode = new Node<>(newData);
                node.setRightChild(newNode);
            }
        }


    }

    @Override
    public void delete(T data) {

    }

    @Override
    public T getMaxValue() {
        if (root == null) return  null;
        return getMax(root);
    }

    @Override
    public T getMinValue() {
        if (root == null) return  null;
        return getMin(root);
    }

    private T getMax(Node<T> node) {
        if (node.getRightChild() != null) {
            return getMin(node.getRightChild());
        }
        return node.getData();
    }


    private T getMin(Node<T> node) {
        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        }
        return node.getData();
    }
}
