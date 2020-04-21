/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab7;

import queue.Queue1;

/**
 *
 * @author Windows 10
 */
public class BST<T extends Comparable<T>> {
    private BSTNode root;
    
    public BST(){
        root = null;
    }
    public void add(T t){
        root = add(root, t);
    }
    public BSTNode<T> add(BSTNode<T> a,T t){
        if(a == null)
            a = new BSTNode(t, null, null);
        else if(t.compareTo(a.getData()) <= 0)
            a.setLeft(add(a.getLeft(), t));
        else if(t.compareTo(a.getData()) > 0)
            a.setRight(add(a.getRight(), t));
        return a;
    }
    public int getSize(){
        return getSize(root);
    }
    public int getSize(BSTNode<T> a){
        if(a == null)
            return 0;
        return getSize(a.getLeft()) + getSize(a.getRight()) + 1;
    }
    public T getMinimum(){
        return (T) getMinimum(root);
    }
    public T getMinimum(BSTNode<T> a){
        while(a.getLeft()!= null)
            a = a.getLeft();
        return a.getData();
    }
    public T getMaximum(){
        if(root == null)
            return null;
        return (T) getMaximum(root);
    }
    public T getMaximum(BSTNode<T> a){
        while(a.getRight()!= null)
            a = a.getRight();
        return a.getData();
    }
    
    public boolean contains(T t){
        return find(root, t);
    }
    public boolean find(BSTNode<T> a, T t){
        if(a == null)
            return false;
        if(t.compareTo(a.getData()) < 0)
            return find(a.getLeft(), t);
        else if(t.compareTo(a.getData()) > 0)
            return find(a.getRight(), t);
        else
            return true;
    }
    
    private static int totalValue = 0;
    public int getTotalValue(){
        totalValue = 0;
        getTotalValue(root);
        return totalValue;
    }
    public void getTotalValue(BSTNode<T> a){
        if(a!= null){
            getTotalValue(a.getLeft());
            totalValue += (Integer)a.getData();
            getTotalValue(a.getRight());
        }
    }
    
    public int count(T t){
        return count(root, t);
    }
    private static int count = 0;
    public int count(BSTNode<T> a, T t){
        if(a == null)
            return count;
        if(t.compareTo(a.getData()) == 0){
            count++;
//            if(t.compareTo(a.getLeft().getData()) < 0 ){
//                if(t.compareTo(a.getRight().getData()) > 0){
//                    return count;
//                }
//            }
        }
        if(t.compareTo(a.getData()) <= 0)
            count = count(a.getLeft(), t);
        if(t.compareTo(a.getData()) >= 0)
            count = count(a.getRight(), t);
        return count;
    }
    public static final int PREODER = 1;
    public static final int INORDER = 2;
    public static final int POSTORDER = 3;
    
    Queue1<T> Q;
    public void showTree(){
        Q.showQueue();
    }
    public Queue1<T> returnQueue(){
        return Q;
    }
    public void setOrder(int a){
        Q = new Queue1<>();
        int traverse = a;
        if(traverse == PREODER)
            preOrder(root);
        else if(traverse == INORDER)
            inOrder(root);
        else if(traverse == POSTORDER)
            postOrder(root);
    }
    public void preOrder(BSTNode<T> a){
        if(a!= null){
            Q.enqueue(a.getData());
            preOrder(a.getLeft());
            preOrder(a.getRight());
        }
    }
    public void inOrder(BSTNode<T> a){
        if(a!=null){
            inOrder(a.getLeft());
            Q.enqueue(a.getData());
            inOrder(a.getRight());
        }
    }
    public void postOrder(BSTNode<T> a){
        if(a!=null){
            postOrder(a.getLeft());
            postOrder(a.getRight());
            Q.enqueue(a.getData());
        }
    }
}
