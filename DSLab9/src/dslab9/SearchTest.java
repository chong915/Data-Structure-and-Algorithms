/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab9;

import java.util.Random;

/**
 *
 * @author Windows 10
 */
public class SearchTest<T extends Comparable<T>> {
    private int MAX = 100;
    private final int MAXCHAR = 26;
    private T[][]value;
    private int orderType, size;
    private Random r;
    public static final int ASCENDING = 1, DESCENDING = 0;
    public static final int INTEGER = 0, DOUBLE = 1, CHARACTER = 2; 
    
    public SearchTest(int sortType, int type, int size, int minValue,int maxValue){
        orderType = sortType;
        this.size = size;
        MAX = maxValue-minValue;
        value = (T[][]) new Comparable[size][size];
        r = new Random();
        char c;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(type == INTEGER)
                    value[i][j] = (T)(Integer)(minValue + r.nextInt(MAX));
                else if(type == DOUBLE)
                    value[i][j] = (T)(Double)(minValue + (r.nextDouble() * r.nextInt(MAX)));
                else if(type == CHARACTER)
                    value[i][j] = (T)(Character)(char)('A' + r.nextInt(MAXCHAR));
                else{
                    c = (char)('A' + r.nextInt(MAXCHAR));
                    value[i][j] = (T)(c + "");
                }
            }
        }
    }
    public void showValue(){
        for(int i=0;i<value.length;i++){
            for(int j=0;j<value.length;j++){
                //If there's only one digit, print two spaces
                if((Integer)(value[i][j])/9 == 0)
                    System.out.print(value[i][j] + "  ");
                else
                    System.out.print(value[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int linearSearchCount(T t){
        int count = 0;
        for(int i=0;i<value.length;i++){
            for(int j=0;j<value.length;j++){
                if(value[i][j].compareTo(t) == 0)
                    count++;
            }
        }
        return count;
    }
    public boolean linearSearchcontains(T t){
        for(int i=0;i<value.length;i++){
            for(int j=0;j<value[i].length;j++){
                if(value[i][j].compareTo(t) == 0)
                    return true;
            }
        }
        return false;
    }
    public String[] linearSearchgetIndices(T t){
        String[]indices = new String[linearSearchCount(t)];
        int index = 0;
        for(int i=0;i<value.length;i++){
            for(int j=0;j<value[i].length;j++){
                if(value[i][j].compareTo(t) == 0){
                    indices[index] = "[" + i + ","+ j + "] ";
                    index++;
                }
            }
        }
        return indices;
    }
    
}
