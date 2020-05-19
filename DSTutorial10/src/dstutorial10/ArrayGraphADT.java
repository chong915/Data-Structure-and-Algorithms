/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dstutorial10;

import java.util.ArrayList;

/**
 *
 * @author Windows 10
 */
public interface ArrayGraphADT<V, E> {
    
    public boolean isEmpty();
    public boolean isFull();
    public int getVerticeSize();
    public void clear();
    public void addVertice(V v);
    public int hasVertice(V v);
    public void addEdge(E e);
    public void deleteEdge(E e);
    public boolean isEdge(V v1, V v2);
    public int getWeight(E e);
    public void markVertice(V v);
    public boolean isMarked(V v);
    public ArrayList getAdjacent(V v);
    
}
