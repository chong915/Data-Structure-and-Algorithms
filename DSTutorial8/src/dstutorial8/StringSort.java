/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dstutorial8;

import java.util.Random;

/**
 *
 * @author Windows 10
 */
public class StringSort<T extends Comparable<T>> {
    private int size = 10;
    private T[]value = (T[])new Comparable[size];
    Random r = new Random();
    
    public StringSort(){
        for(int i=0;i<value.length;i++){
            String temp = "";
            for(int j=0;j<8;j++){
                Character c = (char)('a' + r.nextInt(26));
                temp += c;
            }
            value[i] = (T) temp;
        }
    }
    public void showValue(){
        for(T element : value){
            System.out.print(element + " ");
        }
        System.out.println();
    }
    public void mergeSort(){
        mergeSort(0,value.length-1);
    }
    public void mergeSort(int first, int last){
        if(first < last){
            int middle = (first+last)/2;
            mergeSort(first, middle);
            mergeSort(middle+1, last);
            merge(first, middle, middle+1, last);
        }
    }
    public void merge(int leftFirst, int leftLast, int rightFirst, int rightLast){
        T[] temp = (T[])new Comparable[size];
        int index = leftFirst;
        int currentIndex = leftFirst;
        
        while(leftFirst <= leftLast && rightFirst<= rightLast){
            if(value[leftFirst].compareTo(value[rightFirst]) < 0){
                temp[index] = value[leftFirst];
                leftFirst++;
            }
            else{
                temp[index] = value[rightFirst];
                rightFirst++;
            }
            index++;
        }
        while(leftFirst <= leftLast){
            temp[index] = value[leftFirst];
            leftFirst++;
            index++;
        }
        while(rightFirst <= rightLast){
            temp[index] = value[rightFirst];
            rightFirst++;
            index++;
        }
        for(int i=currentIndex;i<=rightLast;i++)
            value[i] = temp[i];
    }
    
    public void swap(int index1, int index2){
        T temp = value[index1];
        value[index1] = value[index2];
        value[index2] = temp;
    }
    public void quickSort(){
        quickSort(0, value.length-1);
    }
    public void quickSort(int first, int last){
        if(first < last){
            int splitIndex = splitIndex(first, last);
            quickSort(first, splitIndex-1);
            quickSort(splitIndex+1, last);
        }
    }
    public int splitIndex(int first, int last){
        boolean correctSide = true;
        T temp = value[first];
        int index = first;
        first++;
        while(first <= last){
            while(correctSide){
                if(temp.compareTo(value[first]) < 0)
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
                if(temp.compareTo(value[last]) > 0)
                    correctSide = false;
                else{
                    last--;
                    if(first<= last)
                        correctSide = true;
                    else
                        correctSide = false;
                }
            }
            if(first < last){
                swap(first, last);
                first++;
                last--;
            }
        }
        swap(index, last);
        return last;
    }
}
