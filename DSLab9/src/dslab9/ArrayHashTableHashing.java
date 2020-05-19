/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab9;

import java.util.Random;

/**
 *
 * @author Windows 10
 */
public class ArrayHashTableHashing<K extends Comparable<K>, V extends Comparable<V>> implements ArrayHashTable<K, V> {
    private int arraySize;
    private int size = 0;
    private K[]key;
    private V[]value;
    private Random r;
    
    public ArrayHashTableHashing(int arraySize){
        this.arraySize = arraySize;
        key = (K[])new Comparable[arraySize];
        value = (V[])new Comparable[arraySize];
    }
    
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean isFull() {
        return (size == arraySize);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        key = null;
        value = null;
    }

    @Override
    public void showHashTable() {
        for(int i=0;i<arraySize;i++){
            if(key[i] != null)
                System.out.println(key[i] + " : " + value[i]);
        }
    }

    @Override
    public boolean containsKey(K k) {
        for(int i=0;i<arraySize;i++){
            if(key[i].compareTo(k) == 0)
                return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(V v) {
        for(int i=0;i<arraySize;i++){
            if(value[i].compareTo(v) == 0)
                return true;
        }
        return false;
    }

    public int getIndex(K k){
        for(int i=0;i<arraySize;i++){
            if(key[i].compareTo(k) == 0)
                return i;
        }
        return -1;
    }
    
    @Override
    public V get(K k) {
        for(int i=0;i<arraySize;i++){
            if(key[i].compareTo(k) == 0)
                return value[i];
        }
        return null;
    }

    @Override
    public void put(K k, V v) {
        if(isFull()){
            System.out.println("The Hash Table is full");
            return;
        }
        int index = hashFunction(k);
        key[index] = k;
        value[index] = v;
        size++;
    }
    
    public int hashFunction(K k){
        int index = (Integer)k%arraySize;
        while(key[index] != null){
            index++;
            if(index % arraySize == 0)
                index = 0;
        }
        return index;
    }
    
    @Override
    public void remove(K k) {
        for(int i=0;i<arraySize;i++){
            if(key[i].compareTo(k) == 0){
                key[i] = null;
                value[i] = null;
                size--;
                return;
            }
        }
    }
    
}
