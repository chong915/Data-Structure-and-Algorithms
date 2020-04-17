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
public class ArrayStackImplementation<T> implements ArrayStack<T> {
    final int N = 10;
    int count = 0;
    Stack1<Character> stack = new Stack1<>();
    
    public ArrayStackImplementation(){
        
    }
    
    public ArrayStackImplementation(Character a){
        stack.push(a);
        count = 1;
    }
    
    @Override
    public boolean isEmpty() {
        if(count == 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean isFull() {
        if(count == N)
            return true;
        else
            return false;
    }

    @Override
    public int getSize() {
        return count;
    }

    @Override
    public void push(T a) {
        stack.push((Character) a);
        count++;
    }

    @Override
    public void pop() {
        stack.pop();
        count--;
    }

    @Override
    public T peek() {
        return (T) stack.peek();
    }

    @Override
    public void showStack() {
        stack.showStack();
    }
    
}
