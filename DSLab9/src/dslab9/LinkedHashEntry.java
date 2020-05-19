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
public class LinkedHashEntry<K, V> {
    private K key;
    private V value;
    private LinkedHashEntry link;
    
    public LinkedHashEntry(K key, V value){
        this.key = key;
        this.value = value;
        this.link = null;
    }
    public void setKey(K k){
        key = k;
    }
    public K getKey(){
        return key;
    }
    public void setValue(V v){
        value = v;
    }
    public V getValue(){
        return value;
    }
    public void setLink(LinkedHashEntry a){
        link = a;
    }
    public LinkedHashEntry getLink(){
        return link;
    }
}
