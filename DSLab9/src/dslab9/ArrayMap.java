/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab9;

/**
 *
 * @author Windows 10
 */
public class ArrayMap<K extends Comparable<K>, V extends Comparable<V>> implements ArrayHashTable<K, V>{
    private int arraySize = 20;
    private K[]key = (K[]) new Comparable[arraySize];
    private V[]value = (V[]) new Comparable[arraySize];
    int size = 0;
    
    public ArrayMap(){
        
    }
    
    public void put(K k, V v){
        if(isEmpty()){
            key[0] = k;
            value[0] = v;
            size++;
            return;
        }
        for(int i=0;i<size;i++){
            if(key[i].compareTo(k) == 0){
                value[i] = v;
                return;
            }
        }
        key[size] = k;
        value[size] = v;
        size++;
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
        for(int i=0;i<size;i++){
            System.out.print(key[i] + ":" + value[i] + " | ");
        }
    }

    @Override
    public boolean containsKey(K k) {
        for(int i=0;i<size;i++){
            if(key[i].compareTo(k) == 0)
                return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(V v) {
        for(int i=0;i<size;i++){
            if(value[i].compareTo(v) == 0)
                return true;
        }
        return false;
    }

    @Override
    public V get(K k) {
        for(int i=0;i<size;i++){
            if(key[i].compareTo(k) == 0)
                return value[i];
        }
        return null;
    }

    @Override
    public void remove(K k) {
        for(int i=0;i<size;i++){
            if(key[i].compareTo(k) == 0){
                for(int j=i;j<size-1;j++){
                    key[j] = key[j+1];
                    value[j] = value[j+1];
                }
                key[size] = null;
                value[size] = null;
                size--;
                return;
            }
        }
    }
    
}
