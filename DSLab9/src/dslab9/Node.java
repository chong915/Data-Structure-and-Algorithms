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
public class Node<T> {
    private T data;
    private Node link;
    
    public Node(T data, Node link){
        this.data = data;
        this.link = link;
    }
    public void setData(T t){
        data = t;
    }
    public T getData(){
        return data;
    }
    public void setLink(Node link){
        this.link = link;
    }
    public Node getLink(){
        return link;
    }
}
