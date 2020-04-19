/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab6;

/**
 *
 * @author Windows 10
 */
public class Packet {
    private String type;
    private int priority;
    private int number;
    private Packet link;
    
    public Packet(String type,int priority,int number, Packet link){
        this.type = type;
        this.priority = priority;
        this.number = number;
        this.link = link;
    }
    
    public String getType(){
        return type;
    }
    public int getPriority(){
        return priority;
    }
    public void setLink(Packet link){
        this.link = link;
    }
    public Packet getLink(){
        return link;
    }
    public String getData(){
        return type + " " + number  + " (Priority = " + priority + ")"; 
    }
    public int getNumber(){
        return number;
    }
}
