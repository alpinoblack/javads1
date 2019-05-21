package org.orca.data_structures.hash_tables.chaining;

public class HashTable {

    private HashItem[] hashTable;

    public HashTable(HashItem[] hashTable) {
        this.hashTable = new HashItem[Constants.TABLE_SIZE];
    }


    public void put(int key, int value){

        int hashIdx = hash(key);

        if (hashTable[hashIdx] == null) {
            hashTable[hashIdx] = new HashItem(key, value);
        } else {

            HashItem currentHashItem = hashTable[hashIdx];

            while (currentHashItem.getNextHashItem() != null) {
                currentHashItem = currentHashItem.getNextHashItem();
            }

            currentHashItem.setNextHashItem(new HashItem(key, value));

        }
    }

    public int get(int key){
        int hashIdx = hash(key);

        if (hashTable[hashIdx] == null) {
            return -1;
        } else {
            HashItem hashItem = hashTable[hashIdx];
            while (hashItem != null && hashItem.getKey() != key) {
                hashItem = hashItem.getNextHashItem();
            }

            if (hashItem == null){
                return -1;
            } else {
                return hashItem.getValue();
            }
        }

    }



    private int hash(int key) {
        return key % Constants.TABLE_SIZE;
    }
}
