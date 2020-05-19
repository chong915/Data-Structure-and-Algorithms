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
public class ChainHashTable<K extends Comparable<K>,V extends Comparable<V>> {
    private int tableSize;
    private int size;
    private LinkedHashEntry<K, V>[]table;
    
    public ChainHashTable(int tableSize){
        size = 0;
        this.tableSize = tableSize;
        table = new LinkedHashEntry[tableSize];
        for(int i=0;i<tableSize;i++)
            table[i] = null;
    }
    
    public void getHashValues(){
        for(int i=0;i<tableSize;i++){
            if(table[i] != null){
                LinkedHashEntry temp = table[i];
                while(temp != null){
                    System.out.print(temp.getKey() + ":" + temp.getValue() + " ");
                    System.out.println("Hash Value : " + hashFunction((K)temp.getKey()));
                    temp = temp.getLink();
                }
            }
        }
    }
    
    public void showTable(){
        for(int i=0;i<tableSize;i++){
            System.out.print("\nBucket " + (i+1) + " : ");
            LinkedHashEntry entry = table[i];
            while(entry!=null){
                System.out.print(entry.getValue() + " --> ");
                entry = entry.getLink();
            }
        }
    }
    
    public int getSize(){
        return size;
    }
    public void clear(){
        table = null;
    }
    
    public int hashFunction(K k){
        int hash = ((String)k).hashCode();
        hash %= tableSize;
        if(hash<0)
            hash += tableSize;
        
        return hash;
    }
    
    public void insert(Comparable<K> k, V v){
        int hash = hashFunction((K) k);
        if(table[hash] == null)
            table[hash] = new LinkedHashEntry(k, v);
        else{
            LinkedHashEntry entry = table[hash];
            while(entry.getLink() != null && k.compareTo((K) entry.getKey()) != 0)
                entry = entry.getLink();
            if(entry.getKey().equals(k))
                entry.setValue(v);
            else
                entry.setLink(new LinkedHashEntry(k, v));
        }
        size++;
    }
    
    public V getValue(K k){
        int hash = hashFunction(k);
        if(table[hash] == null)
            return null;
        LinkedHashEntry entry = table[hash];
        while(entry != null && !entry.getKey().equals(k))
            entry = entry.getLink();
        if (entry == null)
            return null;
        else
            return (V) entry.getValue();
    }
    public String getBucket(K k){
        int hash = hashFunction(k);
        String str = "";
        LinkedHashEntry temp = table[hash];
        while(temp != null){
            str += temp.getKey() + " : " + temp.getValue() + " --> ";
            temp = temp.getLink();
        }
        return str;
    }
    
    public void remove(K k){
        int hash = hashFunction(k);
        if(table[hash] == null)
            return;
        LinkedHashEntry previousEntry = null;
        LinkedHashEntry entry = table[hash];
        while(entry.getLink() != null && k.compareTo((K)entry.getKey()) != 0){
            previousEntry = entry;
            entry = entry.getLink();
        }
        if(k.compareTo((K)entry.getKey()) == 0){
            if(previousEntry == null)
                table[hash] = entry.getLink();
            else
                previousEntry.setLink(entry.getLink());
        }
        size--;
    }
    
}
