/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab8;

import java.util.Random;

/**
 *
 * @author Windows 10
 */
public class SortingComparison {
    private int[][]num;
    
    public SortingComparison(int[][]num){
        this.num = num;
    }
    
    public void showValues(){
        for(int i=0;i<num.length;i++){
            for(int j=0;j<num[i].length;j++){
              System.out.print(num[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void swap(int row, int index1, int index2){
        int temp = num[row][index1];
        num[row][index1] = num[row][index2];
        num[row][index2] = temp;
    }
    
    public void selectionSort(){
        long start = System.currentTimeMillis();
        for(int i=0;i<num.length;i++)
            selectionSort(i);
        long end = System.currentTimeMillis();
        long duration = (end-start)/1000;
        System.out.println("Selection Sort : " + duration + "s");
    }
    public void selectionSort(int row){
        for(int i=0;i<num[row].length-1;i++){
            int index = i;
            int temp = num[row][i];
            for(int j=i+1;j<num[row].length;j++){
                if(num[row][j] < temp){
                    index = j;
                    temp = num[row][j];
                }
            }
            swap(row, i, index);
        }
    }
    
    public void bubbleSort(){
        long start = System.currentTimeMillis();
        for(int row=0;row<num.length;row++)
            bubbleSort(row);
        long end = System.currentTimeMillis();
        long duration = (end-start)/1000;
        System.out.println("Bubble Sort : " + duration + "s");
    }
    
    public void bubbleSort(int row){
        for(int iteration=0;iteration<num[row].length-1;iteration++){
            for(int j=0;j<num[row].length-1-iteration;j++){
                if(num[row][j] > num[row][j+1])
                    swap(row, j, j+1);
            }
        }
    }
    
    public void insertionSort(){
        long start = System.currentTimeMillis();
        for(int row=0;row<num.length;row++)
            insertionSort(row);
        long end = System.currentTimeMillis();
        long duration = (end-start)/1000;
        System.out.println("Insertion Sort : " + duration + "s");
    }
    
    public void insertionSort(int row){
        int j;
        for(int i=1;i<num[row].length;i++){
            for(j=0;j<i;j++){
                if(num[row][i] < num[row][j]){
                    swap(row, i, j);
                    break;
                }
            }
            for(j=j+1;j<i;j++)
                swap(row, j, i);
        }
    }
    
    public void mergeSort(){
        long start = System.currentTimeMillis();
        for(int row=0;row<num.length;row++)
            mergeSort(row,0, num[row].length-1);
        long end = System.currentTimeMillis();
        long duration = (end-start)/1000;
        System.out.println("Merge Sort : " + duration + "s");
    }
    
    public void mergeSort(int row, int first, int last){
        if(first<last){
            int middle = (first+last)/2;
            mergeSort(row, first, middle);
            mergeSort(row, middle+1, last);
            merge(row, first, middle, middle+1, last);
        }
    }
    
    public void merge(int row, int leftFirst, int leftLast, int rightFirst, int rightLast){
        int[]temp = new int[num[row].length];
        int index = leftFirst;
        int currentIndex = leftFirst;
        while(leftFirst <= leftLast && rightFirst <= rightLast){
            if(num[row][leftFirst] < num[row][rightFirst]){
                temp[index] = num[row][leftFirst];
                leftFirst++;
            }
            else{
                temp[index] = num[row][rightFirst];
                rightFirst++;
            }
            index++;
        }
        while(leftFirst <= leftLast){
            temp[index] = num[row][leftFirst];
            leftFirst++;
            index++;
        }
        while(rightFirst <= rightLast){
            temp[index] = num[row][rightFirst];
            rightFirst++;
            index++;
        }
        for(int i=currentIndex;i<=rightLast;i++)
            num[row][i] = temp[i];
    }
    
    public void quickSort(){
        long start = System.currentTimeMillis();
        for(int row=0;row<num.length;row++)
            quickSort(row, 0, num[row].length-1);
        long end = System.currentTimeMillis();
        long duration = (end-start)/1000;
        System.out.println("Quick Sort : " + duration + "s");
    }
    
    public void quickSort(int row,int first, int last){
        if(first < last){
            int splitIndex = split(row, first, last);
            quickSort(row, first, splitIndex-1);
            quickSort(row, splitIndex+1, last);
        }
    }
    
    public int split(int row, int first, int last){
        boolean correctSide;
        int splitValue = num[row][first];
        int index = first;
        first++;
        while(first <= last){
            correctSide = true;
            while(correctSide){
                if(splitValue < num[row][first])
                    correctSide = false;
                else{
                    first++;
                    if(first <= last)
                        correctSide = true;
                    else
                        correctSide = false;
                }
            }
            if(first <= last)
                correctSide = true;
            else
                correctSide = false;
            while(correctSide){
                if(splitValue >= num[row][last])
                    correctSide = false;
                else{
                    last--;
                    if(first <= last)
                        correctSide = true;
                    else
                        correctSide = false;
                }
            }
            if(first < last){
                swap(row, first, last);
                first++;
                last--;
            }
        }
        swap(row,index,last);
        return last;
        
    }
    
}
