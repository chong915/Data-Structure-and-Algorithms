/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author Windows 10
 */
public class ColourCard {
    private int available = 40;
    ArrayList<String>list = new ArrayList<>();
    
    public ColourCard(){
        String[]color = {"Blue", "Green", "Red", "Yellow"};
        String[]number = {"One", "Two", "Three", "Four", "Five", "Six",
                          "Seven", "Eight", "Nine", "Ten"};
        for(int i=0;i<color.length;i++){
            for(int j=0;j<number.length;j++){
                list.add(number[j] + " " + color[i]);
            }
        }
    }
    public Queue<String> draw(int n){
        //Draw n cards from the deck
        if(list.isEmpty()){
            System.out.println("The deck is empty");
            return null;
        }
        Queue<String> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            int index = (int)(Math.random()*list.size());
            q.add(list.remove(index));
        }
        return q;
    }
    public void showDeck(){
        System.out.println(list.toString());
    }
    public int getSize(){
        return list.size();
    }

    public int compare(String a, String b){
        String[]split_a = a.split(" ");
        String[]split_b = b.split(" ");
        
        if(convertToNumber(split_a[0]) > convertToNumber(split_b[0])){
            return 1;
        }
        else if(convertToNumber(split_a[0]) < convertToNumber(split_b[0])){
            return -1;
        }
        else{
            String color_A = split_a[1];
            String color_B = split_b[1];
            
            if(color_A.compareTo(color_B) < 0)
                return 1;
            else if(color_A.compareTo(color_B) > 0)
                return -1;
            else 
                return 0;
        }
            
    }
     public int convertToNumber(String a){
        String str = a.toLowerCase();
        switch(str){
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            case "ten":
                return 10;
        }
        return 0;
    }
    
}
