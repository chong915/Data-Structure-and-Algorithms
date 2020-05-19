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
public interface ArrayHashTable<K, V> {
    public static final int MAX = 20;
    
    public boolean isEmpty();
    
    public boolean isFull();
    
    public int getSize();
    
    public void clear();
    
    public void showHashTable();
    
    public boolean containsKey(K k);
    
    public boolean containsValue(V v);
    
    public V get(K k);
    
    public void put(K k, V v);
    
    public void remove(K k);
}
