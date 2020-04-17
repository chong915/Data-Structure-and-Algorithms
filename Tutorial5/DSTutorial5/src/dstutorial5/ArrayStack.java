/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dstutorial5;

/**
 *
 * @author Windows 10
 */
public interface ArrayStack<T> {
    
    public boolean isEmpty();
    
    public boolean isFull();
    
    public int getSize();
    
    public void push(T a);
    
    public void pop();
    
    public T peek();
    
    public void showStack();
    
}
