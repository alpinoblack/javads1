package org.orca.data_structures.hash_tables.probing;

public class HashTable {

    private HashItem[] hashTable;

    public HashTable(HashItem[] hashTable) {
        this.hashTable = new HashItem[Constants.TABLE_SIZE];
    }


    public void put(int key, int value) {

        int hashIdx = hash(key);

        while (hashTable[hashIdx] != null) {
            hashIdx = (hashIdx + 1) % Constants.TABLE_SIZE;
        }

        hashTable[hashIdx] = new HashItem(key, value);


    }

    public int get(int key) {
        int hashIdx = hash(key);

        while (hashTable[hashIdx] != null && hashTable[hashIdx].getKey() != key) {
            hashIdx = (hashIdx + 1) % Constants.TABLE_SIZE;
        }

        if (hashTable[hashIdx] == null) {
            return -1;
        } else {
            return hashTable[hashIdx].getKey();
        }
    }


    private int hash(int key) {
        return key % Constants.TABLE_SIZE;
    }
}
