/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dstutorial7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import queue.Queue1;

/**
 *
 * @author Windows 10
 */
public class BSTArrayImplementation<T extends Comparable<T>> implements ArrayBST<T> {
    private T[]array;
    private int size = 20;
    private Queue1<T> Q = new Queue1<>();
    
    public BSTArrayImplementation(){
        array = (T[]) new Comparable[size];
    }
    @Override
    public boolean isEmpty() {
        return (array[0] == null);
    }

    @Override
    public int getSize() {
        int size = 0;
        for(T element : array){
            if(element != null)
                size++;
            
        }
        return size;
    }

    @Override
    public int getHeight() {
        int power = 1;
        int count = 0;
        for(T element : array){
            if(element == null)
                break;
            count++;
        }
        int height = 0;
        while(power <= count){
            power = power * 2;
            height++;
        }
        return height;
    }

    @Override
    public void addNode(T t) {
        
        if(array[0] == null)
            array[0] = t;
        else{
            int i = 0;
            while(true){
                if(array[i] == null)
                    break;
                if(t.compareTo(array[i]) < 0){
                    i = 2*i + 1;
                }
                else{
                    i = 2*i + 2;
                }
                
            }
            System.out.println("Add node at index : " + i);
            array[i] = t;
        }
//        int temp;
//        if(array[(h*2)+1] == null)
//            temp = (h*2);
//        else
//            temp = (h*2)+1;
//        array[temp] = t;
    }
    public void resetQueue(){
        Q = new Queue1<>();
    }
    public void showTree(){
        Q.showQueue();
    }
    @Override
    public void inOrder(int i) {
        if(array[i]!= null){
            if((2*i+1)<size && array[2*i+1]!= null)
                inOrder(2*i+1);
            if(array[i] != null){
                Q.enqueue(array[i]);
            }
            if((2*i+2)<size && array[2*i+2]!= null)
                inOrder(2*i+2);
        }
    }

    @Override
    public void preOrder(int i) {
        if(array[i]!= null){
            if(array[i] != null){
                Q.enqueue(array[i]);
            }
            if((2*i+1)<size && array[2*i+1]!= null)
                preOrder(2*i+1);
            
            if((2*i+2)<size && array[2*i+2]!= null)
                preOrder(2*i+2);
        }
    }

    @Override
    public void postOrder(int i) {
        if(array[i]!= null){
            if((2*i+1)<size && array[2*i+1]!= null)
                postOrder(2*i+1);
            
            if((2*i+2)<size && array[2*i+2]!= null)
                postOrder(2*i+2);
            if(array[i] != null){
                Q.enqueue(array[i]);
            }
        }
    }
    public void showArray(){
        for(T element : array)
            System.out.println(element);
    }
    
    @Override
    public void removeNode(T t) {
        array[0] = remove(0, t);
    }
    private static int i = -1;
    public T remove(int a,T t){
        i++;
        if(array[a] == null)
            return null;
        else if(t.compareTo(array[a]) < 0)
            array[2*a+1] = remove((2*a+1), t);
        else if(t.compareTo(array[a]) > 0)
            array[2*a+2] = remove((2*a+2), t);
        else{
            array[a] = remove(a);
        }
        return array[a];    
    }
    public T remove(int a){
        
        if((2*a+1)>size || (array[2*a+1]==null && array[2*a+2]!=null)){
            T temp = array[2*a+2];
            array[2*a+2] = null;
            return temp;
        }
        else if((2*a+2)>size|| (array[2*a+2] == null && array[2*a+1]!= null)){
            T temp = array[2*a+1];
            array[2*a+1] = null;
            return temp;
        }
        else{
            T t = getPredecessor(a);
            array[a] = t;
            if(array[2*a+1]!= null)
                array[2*a+1] = remove(2*a+1, t);
            else
                array[2*a+2] = remove(2*a+2, t);
        }
        return array[a];
    }
    public T getPredecessor(int a){
        T[]arrayCopy = Arrays.copyOf(array, array.length);
        while(a<size && arrayCopy[a]!= null)
            arrayCopy[a] = arrayCopy[a*2+2];
        return arrayCopy[a];
    }
    
}
