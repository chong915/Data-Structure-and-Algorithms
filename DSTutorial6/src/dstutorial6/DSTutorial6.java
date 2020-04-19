/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dstutorial6;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Windows 10
 */
public class DSTutorial6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Q1
        Queue<Character> queue = new Queue<>();
        System.out.println("Queue implementation using Linked List");
        System.out.println("Enqueue three nodes");
        queue.enqueue('B');
        queue.enqueue('M');
        queue.enqueue('W');
        queue.showQueue();
        
        System.out.println("Dequeue one node");
        queue.dequeue();
        queue.showQueue();
        
        System.out.println("The front node of the queue is " + queue.peek());
        System.out.println("The queue size is " + queue.getSize());
        */
        
        /*Q2 Linear ArrayQueue 
        ArrayQueue<Character> array_queue = new ArrayQueue<>(10);
        System.out.println("Queue Implementation using Array");
        System.out.println("Enqueue three nodes");
        array_queue.queueEnqueue('B');
        array_queue.queueEnqueue('M');
        array_queue.queueEnqueue('W');
        array_queue.queueDisplay();
        
        System.out.println("\nDequeue one node");
        array_queue.queueDequeue();
        array_queue.queueDisplay();
        
        System.out.println("\nThe front node of the queue is " + array_queue.queueFront());
        System.out.println("The queue size is " + array_queue.getSize());
        */
        /*Q2 Circular ArrayQueue
        CircularArrayQueue<Character> circularArrayQueue = new CircularArrayQueue<>(3);
        circularArrayQueue.enqueue('B');
        circularArrayQueue.enqueue('M');
        circularArrayQueue.enqueue('W');
        circularArrayQueue.dequeue();
        circularArrayQueue.dequeue();
        circularArrayQueue.enqueue('B');
        circularArrayQueue.enqueue('M');
        System.out.println(circularArrayQueue.toString());
        */
        
        //Q3
        //purchasePhone();
        
        /*Q4 and Q5
        isPalindrome("Was it a car or a cat I saw?");
        isPalindrome("?civic#");
        isPalindrome("race car");
        isPalindrome("redrawer");
        isPalindrome("put    it up");
        */
        //Q6
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence : ");
        String str = sc.nextLine();
        String[]split = str.split(" ");
        Queue<String> q = new Queue<>();
        for(int i=0;i<split.length;i++){
            q.enqueue(split[i]);
        }
        System.out.print("The original queue : ");
        q.showQueue();
        reverseQueue(q);
        System.out.print("Reverse all the elements in the queue : ");
        q.showQueue();
    }
    
    public static void reverseQueue(Queue<String> q){
        if(q.isEmpty())
            return;
        String data = q.dequeue();
        reverseQueue(q);
        q.enqueue(data);
    }
    
    public static boolean isPalindrome(String str){
        //(Additional code for Q5)Remove special characters and whitespace from the string
        String temp = str;
        str = str.replaceAll("[^a-zA-Z0-9]", "");
        str = str.replaceAll("\\s", "");
        
        int length = str.length();
        Queue<Character> q = new Queue();
        Stack<Character> st = new Stack();
        
        for(int i=0;i<length;i++){
            q.enqueue(str.charAt(i));
            st.push(str.charAt(i));
        }
        while(!q.isEmpty()){
            if(Character.toLowerCase(q.dequeue()) !=(Character.toLowerCase(st.pop()))){
                System.out.println(temp + " is not a palindrome");
                return false;
            }
        }
        System.out.println(temp + " is a palindrome");
        return true;
    }
    
    public static void purchasePhone(){
        Queue<String>queue = new Queue<>();
        int[] sets = {1,2,2,3,1,2,2,1,1,3,3,1,3,2,2,1}; 
        int available = 30;
        int i = 1;
        int customer = 0;
        while(available > 0){
            queue.enqueue("Customer " + i + " : "+ sets[i-1] + " set(s)");
            available = available - sets[i-1];
            queue.showQueue();
            customer++;
            i++;
        }
        System.out.println("Number of customer : " + customer);
    }
    
}
