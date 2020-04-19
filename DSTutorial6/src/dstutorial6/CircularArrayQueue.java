/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dstutorial6;

/**
 *
 * @author Windows 10
 */
public class CircularArrayQueue<T> {
    private final int capacity = 10;
    private int front, rear, count;
    private T[] queue;
    
    public CircularArrayQueue(){
        front = rear = count = 0;
        queue = (T[]) new Object[capacity];
    }
    public CircularArrayQueue(int initialCapacity){
        front = rear = count = 0;
        queue = (T[])new Object[initialCapacity];
    }
    
    public void enqueue(T element){
        if(size() == queue.length)
            System.out.println("The queue is full");
        else{
            queue[rear] = element;
            rear = (rear + 1) % queue.length;
            count++;
        }
    }
    public T dequeue(){
        if(isEmpty()){
            System.out.println("The queue is empty");
            return null;
        }
        else{
            T result = queue[front];
            queue[front] = null;
            front = (front + 1) % queue.length;
            count--;
            return result;
        }
    }
    public T first(){
        if(isEmpty()){
            System.out.println("The queue is empty");
            return null;
        }
        return queue[front];
    }
    
    public boolean isEmpty(){
        return (count == 0);
    }
    
    public int size(){
        return count;
    }
    
    public String toString(){
        String result = "";
        int scan = 0;
        while(scan < queue.length){
            if(queue[scan]!= null)
                result+= queue[scan].toString() + "\n";
            scan++;
        }
        return result;
    }
    
}
