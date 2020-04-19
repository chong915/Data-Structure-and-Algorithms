/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab6;

/**
 *
 * @author Windows 10
 */
public class PriorityQueue {
    private Packet head;
    
    public PriorityQueue(){
        head = null;
    }
    public boolean isEmpty(){
        return (head == null);
    }
    public void add(String type, int priority,int number){
        Packet newNode = new Packet(type, priority, number, null);
        if(head == null)
            head = newNode;
        else{
            Packet currentNode = head;
            //If there's only one element in the queue
            if(currentNode.getLink() == null){
                if(newNode.getPriority() > currentNode.getPriority()){
                    newNode.setLink(head);
                    head = newNode;
                }
                else{
                    head.setLink(newNode);
                }
            }
            else{
                boolean found = false;
                while(currentNode.getLink() != null){
                    if(newNode.getPriority() > currentNode.getLink().getPriority()){
                        newNode.setLink(currentNode.getLink());
                        currentNode.setLink(newNode);
                        found = true;
                        break;
                    }
                    currentNode = currentNode.getLink();
                }
                if(!found)
                    currentNode.setLink(newNode);
            }
        }
    }
    public String remove(){
        if(head == null){
            System.out.println("The Queue is empty");
            return null;
        }
        else{
            String temp = head.getData();
            head = head.getLink();
            return temp;
        }
    }
    public void showQueue(){
        if(isEmpty())
            System.out.println("The Queue is empty");
        else{
            Packet currentNode = head;
            while(currentNode!=null){
                System.out.print(" <-- " + currentNode.getData());
                currentNode = currentNode.getLink();
            }
            System.out.println();
        }
    }
    
}
