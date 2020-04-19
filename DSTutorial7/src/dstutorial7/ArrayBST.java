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
public interface ArrayBST<T extends Comparable<T>> {
    boolean isEmpty();
    int getSize();
    int getHeight();
    void addNode(T t);
    void inOrder(int i);
    void preOrder(int i);
    void postOrder(int i);
    void removeNode(T t);
    
}
