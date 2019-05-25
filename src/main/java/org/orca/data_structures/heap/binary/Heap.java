package org.orca.data_structures.heap.binary;

public class Heap {

    private int[] heap;

    private int heapSize = 0;

    public Heap(){
        this.heap = new int[Constants.CAPACITY];
    }

    public void insert(int item) {
        if (isHeapFull()) throw new RuntimeException("heap is full !!!");

        this.heap[heapSize] = item;
        heapSize++;

        //check if Heap properties are violated
        fixUp(heapSize - 1);
    }

    private boolean isHeapFull() {
        return heapSize == Constants.CAPACITY;
    }

    private void fixUp(int index){

        int parentIndx = (index - 1)/2;

        if (index > 0 && heap[index] > heap[parentIndx]) {
            swap(index, parentIndx);
            fixUp(parentIndx);
        }

    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public int poll(){
        int max = getMax();

        swap(0, heapSize - 1);
        heapSize--;

        fixDown(0);

        return max;
    }

    private void fixDown(int index) {

        int indexLeft = 2*index + 1;
        int indexRight = 2*index + 2;

        int indexLargest = index;

        if (indexLeft < heapSize && heap[indexLeft] > heap[index]){
            indexLargest = indexLeft;
        }

        if (indexRight  < heapSize && heap[indexRight] > heap[index]){
            indexLargest = indexLeft;
        }

        if (index != indexLargest) {
            swap(index, indexLargest);
            fixDown(indexLargest);
        }

    }

    public void heapSort() {
        int size = heapSize;

        for (int i=0; i<size; i++){
            int max = poll();
            System.out.println(max + " ");
        }
    }

    public int getMax(){
        return heap[0];
    }
}
