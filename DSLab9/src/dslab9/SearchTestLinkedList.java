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
public class SearchTestLinkedList<T extends Comparable<T>> {
    private final int MAX = 21;
    private final int size = 10;
    LinkedList<T>value = new LinkedList<>();
    private Random r;
    public static final int INTEGER = 0, CHARACTER = 1;
    
    public SearchTestLinkedList(int type){
        r = new Random();
        for(int i=0;i<size;i++){
            if(type == INTEGER){
                Integer num = r.nextInt(MAX);
                value.addNode((T) num);
            }
        }
    }
    
    public void showValue(){
        Node currentNode = value.getHead();
        for(int i=0;i<size;i++){
            System.out.print(currentNode.getData() + " --> ");
            currentNode = currentNode.getLink();
        }
    }
    
    public boolean linearSearchContains(T t){
        Node currentNode = value.getHead();
        for(int i=0;i<size;i++){
            if(t.compareTo((T)currentNode.getData()) == 0)
                return true;
            currentNode = currentNode.getLink();
        }
        return false;
    }
    
    public int linearSearchCount(T t){
        int count = 0;
        Node currentNode = value.getHead();
        for(int i=0;i<size;i++){
            if(t.compareTo((T)currentNode.getData()) == 0)
                count++;
            currentNode = currentNode.getLink();
        }
        return count;
    }
    
    public boolean containsWithinRange(T start, T end){
        Node currentNode = value.getHead();
        for(int i=0;i<size;i++){
            if(start.compareTo((T)currentNode.getData()) <= 0  && end.compareTo((T)currentNode.getData()) >= 0){
                return true;
            }
            currentNode = currentNode.getLink();
        }
        return false;
    }
    
    public int countWithinRange(T start, T end){
        int count = 0;
        Node currentNode = value.getHead();
        for(int i=0;i<size;i++){
            if(start.compareTo((T)currentNode.getData()) <= 0 && end.compareTo((T)currentNode.getData()) >= 0){
                count++;
            }
            currentNode = currentNode.getLink();
        }
        return count;
    }
}




