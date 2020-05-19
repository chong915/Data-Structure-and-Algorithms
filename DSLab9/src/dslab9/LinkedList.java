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
public class LinkedList<T extends Comparable<T>> {
    private Node<T> head;
    
    public LinkedList(){
        head = null;
    }
    
    public Node getHead(){
        return head;
    }
    
    public int length(){
        int count = 0;
        Node<T> currentNode = head;
        while(currentNode != null){
            currentNode = currentNode.getLink();
            count++;
        }
        return count;
    }
    public void clear(){
        head = null;
    }
    public boolean isEmpty(){
        return (head == null);
    }
    public void showList(){
        Node <T> currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode.toString());
            currentNode = currentNode.getLink();
        }
    }
    
    //insert at the back
    public void addNode(T a){
        Node newNode = new Node(a,null);
        Node currentNode = head;
        if(head == null)
            head = newNode;
        else{
            while(currentNode.getLink() !=null )
                currentNode = currentNode.getLink();
            currentNode.setLink(newNode);
        }
    }
    
    //delete from the back
    public void deleteNode(){
        Node currentNode = head;
        Node previousNode = head;
        if(head !=null){
            if(currentNode.getLink() == null)
                head = null;
            else{
                while(currentNode.getLink() != null){
                    previousNode = currentNode;
                    currentNode = currentNode.getLink();
                }
                previousNode.setLink(null);
            }
        }
        else
            System.out.println("The list is empty.");
    }
    public void addFrontNode(T a){
        head = new Node(a,head);
    }
    public void deleteFrontNode(){
        if(head != null)
            head = head.getLink();
        else
            System.out.println("The list is empty");
    }
    public boolean contains(T t){
        boolean found = false;
        Node currentNode = head;
        while(currentNode != null){
            if(t.compareTo( (T)currentNode.getData()) == 0){
                found = true;
                break;
            }
            currentNode = currentNode.getLink();
        }
        return found;
    }
    
    public void addNodeByPosition (T a,int index){
        if(index == 0)
            addFrontNode(a);
        else if (index == length())
            addNode(a);
        else if(index > length())
            System.out.println("Invalid index. No node inserted");
        else{
            Node newNode = new Node(a,null);
            Node currentNode = head;
            for(int i = 1;i<index ; i++)
                currentNode = currentNode.getLink();
            Node tempNode = currentNode.getLink();
            currentNode.setLink(newNode);
            newNode.setLink(tempNode);
            
        }
    }
    public void deleteNodeByPosition(int index){
        if(index == 0)
            deleteFrontNode();
        else if(index == length()-1)
            deleteNode();
        else if(index >= length())
            System.out.println("Invalid index. No node deleted");
        else{
            Node currentNode = head;
            for(int i=1;i<index;i++)
                currentNode = currentNode.getLink();
            Node tempNode = currentNode.getLink();
            currentNode.setLink(tempNode.getLink());
            tempNode = null ;
        }
    }
    
    public void setFront(T t){
        if(head != null)
            head.setData(t);
        else
            System.out.println("Invalid update. List is empty");
    }
    public void setBack(T t){
        if(head != null){
            Node currentNode = head;
            while(currentNode.getLink() != null)
                currentNode =currentNode.getLink();
            currentNode.setData(t);
        }
        else
            System.out.println("Invalid update. List is empty");
    }
    
    public void set(T t,int index){
        if(index == 0)
            setFront(t);
        else if(index == length()-1)
            setBack(t);
        else if(index >= length())
            System.out.println("Invalid index. Update failed.");
        else{
            Node currentNode = head;
            for(int i=1;i<=index;i++)
                currentNode = currentNode.getLink();
            currentNode.setData(t);
        }
    }
    
    public T getFront(){
        if(head != null)
            return (T)head.getData();
        else
            return null;
    }
    
    public T getBack(){
        if(head != null){
            Node currentNode = head;
            while(currentNode.getLink() != null)
                currentNode = currentNode.getLink();
            return (T) currentNode.getData();
        }
        else
            return null;
    }
    public T get(int index){
        if(index == 0)
            return getFront();
        else if (index == length()-1)
            return getBack();
        else if(index >= length())
            return null;
        else{
            Node currentNode = head;
            for(int i=1;i<=index;i++)
                currentNode = currentNode.getLink();
            return (T) currentNode.getData();
        }
    }
}