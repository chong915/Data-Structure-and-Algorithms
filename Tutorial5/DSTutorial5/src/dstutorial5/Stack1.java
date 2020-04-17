/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dstutorial5;

/**
 *
 * @author Windows 10
 */
public class Stack1<T> {
    ListNode head;
    
    public Stack1(){
        head = null;
    }
    public Stack1(T a){
        head = new ListNode(a,null);
    }
    
    public boolean isEmpty(){
        return (head == null);
    }
    public void push(T a){
        if(head == null)
            head = new ListNode(a,null);
        else{
            head = new ListNode(a,head);
        }
    }
    
    public T pop(){
        if(head == null){
            System.out.println("The stack is empty !");
            return null;
        }
        else{
            T temp = (T) head.getData();
            head = head.getLink();
            return (T) temp;
        }
    }
    
    public T peek(){
        if(head == null){
            System.out.println("There's no element in the stack");
            return null;
        }
        else{
            return (T) head.getData();
        }   
    }
    
    public int getSize(){
        if(head == null)
            return 0;
        else{
            int count = 0;
            ListNode currentNode = head;
            while(currentNode != null){
                currentNode = currentNode.getLink();
                count++;
            }
            return count;    
        }
    }
    
    public void showStack(){
        if(head == null){
            System.out.println("The stack is empty");
            return;
        }
        else{
            ListNode currentNode = head;
            while(currentNode != null){
                System.out.print(" <-- " + currentNode.getData());
                currentNode = currentNode.getLink();
            }
            
        }
    }
}
