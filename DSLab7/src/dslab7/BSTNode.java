/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab7;

/**
 *
 * @author Windows 10
 */
public class BSTNode<T> {
    private T data;
    private BSTNode leftLink;
    private BSTNode rightLink;
    
    public BSTNode(T data, BSTNode a, BSTNode b){
        this.data = data;
        leftLink = a;
        rightLink = b;
    }
    public void setData(T t){
        data = t;
    }
    public T getData(){
        return data;
    }
    public void setLeft(BSTNode<T> a){
        leftLink = a;
    }
    public BSTNode<T> getLeft(){
        return leftLink;
    }
    public void setRight(BSTNode<T> a){
        rightLink = a;
    }
    public BSTNode<T> getRight(){
        return rightLink;
    }
}
