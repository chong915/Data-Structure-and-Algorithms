/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dstutorial7;

/**
 *
 * @author Windows 10
 */
public class BSTNode<T> {
    private T data;
    private BSTNode leftLink;
    private BSTNode rightLink;
    
    public BSTNode(){
        this.data = null;
        this.leftLink = null;
        this.rightLink = null;
    }
    public BSTNode(T data, BSTNode leftLink, BSTNode rightLink){
        this.data = data;
        this.leftLink = leftLink;
        this.rightLink = rightLink;
    }
    public void setData(T data){
        this.data = data;
    }
    public T getData(){
        return data;
    }
    public void setLeft(BSTNode a){
        this.leftLink = a;
    }
    public BSTNode<T> getLeft(){
        return leftLink;
    }
    public void setRight(BSTNode<T> a){
        this.rightLink = a;
    }
    public BSTNode<T> getRight(){
        return rightLink;
    }
    
}
