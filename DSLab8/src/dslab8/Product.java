/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab8;

/**
 *
 * @author Windows 10
 */
public class Product {
    String pid;
    String sid;
    double price;
    int quantity;
    
    public Product(String pid, String sid, double price, int quantity){
        this.pid = pid;
        this.sid = sid;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String toString(){
        return pid + " : " + sid + " : " + price + " : " + quantity;
    }
    
}
