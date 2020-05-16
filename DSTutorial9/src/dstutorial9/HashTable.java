/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dstutorial9;

/**
 *
 * @author Windows 10
 */
public class HashTable<K extends Comparable<K>, V extends Comparable<V>> {
    private MapNode head;
    
    public HashTable(){
        head = null;
    }
    public boolean isEmpty(){
        return (head == null);
    }
    public int getSize(){
        int count = 0;
        MapNode currentNode = head;
        while(currentNode != null){
            count++;
            currentNode = currentNode.getLink();
        }
        return count;
    }
    
    public void showTable(){
        MapNode currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode.toString());
            currentNode = currentNode.getLink();
        }
    }
    
    public void clear(){
        head = null;
    }
    
    public void put(K k, V v){
        if(head == null)
            head = new MapNode(k, v, null);
        else{
            MapNode currentNode = head;
            
            //If there's only one MapNode in HashTable
            if(getSize() == 1){
                if(currentNode.getKey().compareTo(k) == 0)
                    currentNode.setValue(v);
                else{
                    MapNode newNode = new MapNode(k, v, null);
                    currentNode.setLink(newNode);
                }
                return;
            }
            //More than one MapNode
            while(currentNode.getLink() != null){
                if(currentNode.getKey().compareTo(k) == 0){
                    //V temp = (V) currentNode.getValue();
                    currentNode.setValue(v);
                    return;
                }
                else
                    currentNode = currentNode.getLink();
            }
            
            MapNode newNode = new MapNode(k, v, null);
            currentNode.setLink(newNode);
        }
    }
    
    public void remove(K k){
        if(head == null)
            return;
        else{
            MapNode currentNode = head;
            MapNode previousNode = null;
            boolean found = false;
            
            while(currentNode != null){
                if(currentNode.getKey().compareTo(k) == 0){
                    found = true;
                    break;
                }
                else{
                    previousNode = currentNode;
                    currentNode = currentNode.getLink();
                }
            }
            if(found){
                //If there's only one MapNode in the HashTable
                if(previousNode == null){
                    head = head.getLink();
                    return;
                }
                MapNode nextLink = currentNode.getLink();
                previousNode.setLink(nextLink);
            }
        }
    }
    
    public V getValue(K k){
        MapNode currentNode = head;
        while(currentNode != null){
            if(currentNode.getKey().compareTo(k) == 0)
                return (V)currentNode.getValue();
            else
                currentNode = currentNode.getLink();
        }
        return null;
    }
    
    public boolean containsKey(K k){
        MapNode currentNode = head;
        while(currentNode != null){
            if(currentNode.getKey().compareTo(k) == 0)
                return true;
            else
                currentNode = currentNode.getLink();
        }
        return false;
    }
    
    public boolean containsValue(V v){
        MapNode currentNode = head;
        while(currentNode != null){
            if(currentNode.getValue().compareTo(v) == 0)
                return true;
            else
                currentNode = currentNode.getLink();
        }
        return false;
    }
    
}
