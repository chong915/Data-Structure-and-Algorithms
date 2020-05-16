/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab8;

import java.util.Arrays;

/**
 *
 * @author Windows 10
 */
public class maxHeapSort<T extends Comparable<T>> {
    private int capacity;
    private int size = 0;
    T[]items;

    
    public maxHeapSort(int c){
        capacity = c;
        items = (T[])new Comparable[c];
    }
    
    private int getLeftChildIndex(int parentIndex){ return 2 *  parentIndex + 1;}
    private int getRightChildIndex(int parentIndex){ return 2 * parentIndex + 2;}
    private int getParentIndex(int childIndex){ return (childIndex-1)/2;}
    
    private boolean hasLeftChild(int index){ return getLeftChildIndex(index) < size;}
    private boolean hasRightChild(int index){ return getRightChildIndex(index) < size;}
    private boolean hasParent(int index){ return getParentIndex(index) >= 0;}
    
    private T leftChild(int index){ return items[getLeftChildIndex(index)];}
    private T rightChild(int index){ return items[getRightChildIndex(index)];}
    private T parent(int index){ return items[getParentIndex(index)];}
    
    public void showHeap(){
        for(int i=0;i<size;i++){
            System.out.print(items[i] + " ");
        }
    }
    
    public void heapSort(){
        int sizeCopy = size;
        while(size >0){
            swap(0,size-1);
            size--;
            heapifyDown();
        }
        size = sizeCopy;
        showHeap();
    }
    
    public int getSize(){
        return size;
    }
    
    private void swap(int index1, int index2){
        T temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }
    
    private void ensureExtraCapacity(){
        if(size == capacity){
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }
    
    public T peek(){
        if(size == 0) throw new IllegalStateException();
        return items[0];
    }
    
    public T poll(){
        if(size == 0) throw new IllegalStateException();
        T item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }
    
    public void add(T item){
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }
    
    public void heapifyUp(){
        int index = size - 1;
        while(hasParent(index) && (parent(index).compareTo(items[index]) < 0)){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }
    
    public void heapifyDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int largerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && (rightChild(index).compareTo(leftChild(index)) > 0))
                largerChildIndex = getRightChildIndex(index);
            if(items[index].compareTo(items[largerChildIndex])> 0)
                break;
            else{
                swap(index, largerChildIndex);
                index = largerChildIndex;
            }
        }
    }
}
