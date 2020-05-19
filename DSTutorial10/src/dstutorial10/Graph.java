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
public class Graph<V> {
    private final int vertices;
    private double[][] twoD_array;
    ArrayList<V>list;
    
    public Graph(int v){
        vertices = v;
        list = new ArrayList<>();
        twoD_array = new double[vertices+1][vertices+1];
        for(char i = 'A';i<='G';i++){
            twoD_array[0][i - 64] = i;
            twoD_array[i-64][0] = i;
        }
        
    }
    public void addEdge(char source, char dest, double weight){
        try{
            twoD_array[(int)source-65 + 1][(int)dest-65+1] = weight;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("The vertices does not exists");
        }
    }
    
    public void removeEdge(char source, char dest){
        try{
            double temp = twoD_array[(int)source - 65 + 1][(int)dest - 65 + 1];
            if(temp != 0)
                twoD_array[(int)source - 65 + 1][(int)dest - 65 + 1] = 0;
            else
                throw new ArrayIndexOutOfBoundsException();
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("The edge does not exist");
        }
    }
    
    public double getWeight(char source, char dest){
        try{
            return twoD_array[(int)source -65+1][(int)dest-65+1];
        }catch(ArrayIndexOutOfBoundsException index){
            System.out.println("The vertices does not exist");
        }
        return -1;
    }
    
    public ArrayList getAdjacent(char source){
        ArrayList<Character> list = new ArrayList<>();
        int row = (int)(source - 64);
        for(int j = 1;j<twoD_array.length;j++){
            if(twoD_array[row][j] != 0){
                list.add((char)(j + 64));
            }
        }
        return list;
    }
    
    public void printGraph(){
        for(int i=1;i<twoD_array.length;i++){
            for(int j=0;j<twoD_array.length;j++){
                if(j == 0)
                    System.out.print((char)twoD_array[i][j] + " --> \n -> ");
                else{
                    if(twoD_array[i][j] != 0)
                        System.out.print((char)twoD_array[0][j] + " : " + twoD_array[i][j] + " -> ");
                }
            }
            System.out.println();
        }
    }
    
    public void printAdjacentList(){
        System.out.print("   ");
        for(int i=1;i<twoD_array.length;i++){
            System.out.print((char)twoD_array[0][i] + "\t ");
        }
        System.out.println("");
        for(int i=1;i<twoD_array.length;i++){
            for(int j=0;j<twoD_array.length;j++){
                if(j == 0)
                    System.out.print((char)twoD_array[i][j] + " ");
                else
                    System.out.printf("%.1f\t", twoD_array[i][j]);
            }
            System.out.println();
        }
    }
    
}
