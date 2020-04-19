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
public class ArrayQueue<T> {
    private int front, rear, capacity;
    private T queue[];
    
    public ArrayQueue(int c){
        front = rear = 0;
        capacity = c;
        queue = (T[]) new Object[capacity];
    }
    
    public void queueEnqueue(T data){
        if(capacity == rear){
            System.out.printf("\nQueue is full\n");
            return;
        }
        else{
            queue[rear] = data;
            rear++;
        }
    }
    public void queueDequeue(){
        if(front == rear){
            System.out.printf("\nQueue is empty\n");
        }
        else{
            for(int i=0;i<rear-1;i++){
                queue[i] = queue[i+1];
            }
            rear--;
        }
    }
    public void queueDisplay(){
        if(front == rear){
            System.out.printf("\nQueue is Empty\n");
        }
        else{
            for(int i=front;i<rear;i++){
                System.out.print(queue[i] + " <-- ");
            }
        }
    }
    public T queueFront(){
        T temp = null;
        if(front == rear){
            System.out.println("Queue is empty");
        }
        else{
            temp = (T) queue[0];
        }
        return temp;
    }
    public int getSize(){
        return rear;
    }
}
