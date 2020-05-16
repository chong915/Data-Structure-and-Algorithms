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
public class SortTest<T extends Comparable<T>> {
    private int size = 10;
    private final int MAXCHAR = 26;
    private T[] value = (T[]) new Comparable[size];
    Random r = new Random();
    
    public SortTest(){
        for(int i=0;i<size;i++){
            Character c = (char)('A' + r.nextInt(MAXCHAR));
            value[i] = (T) c;
        }
    }
    public boolean isSorted(){
        for(int i=0;i<value.length;i++){
            if(value[i].compareTo(value[i+1]) < 0)
                return false;
        }
        return true;
    }
    public void showValue(){
        for(int i=0;i<value.length;i++){
            System.out.print(value[i] + " ");
        }
        System.out.println();
    }
    public void swap(int index1, int index2){
        T temp = value[index1];
        value[index1] = value[index2];
        value[index2] = temp;
    }
    public int getMaxIndex(int start){
        T temp = value[start];
        int index = start;
        for(int i=start+1;i<value.length;i++){
            if(temp.compareTo(value[i]) < 0){
                index = i;
                temp = value[i];
            }
        }
        return index;
    }
    public void selectionSort(){
        for(int i=0;i<value.length-1;i++){
            swap(i, getMaxIndex(i));
            showValue();
        }
    }
    public void bubbleSort(){
        for(int iteration = 0;iteration<value.length;iteration++){
            for(int i=0;i<value.length-1-iteration;i++){
                if(value[i].compareTo(value[i+1]) < 0)
                    swap(i, i+1);
            }
            showValue();
        }
    }
    public void insertionSort(){
        int j;
        for(int i=1;i<value.length;i++){
            for(j=0;j<i;j++){
                if(value[i].compareTo(value[j]) > 0){
                    swap(i, j);
                    break;
                }
            }
            for(j=j+1; j<i;j++)
                swap(i, j);
            showValue();
        }
    }
    public void mergeSort(){
        mergeSort(0, value.length-1);
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
        T[] temp = (T[]) new Comparable[size];
        int index = leftFirst;
        int start = leftFirst;
        while((leftFirst <= leftLast) && (rightFirst <= rightLast)){
            if(value[leftFirst].compareTo(value[rightFirst]) > 0){
                temp[index] = value[leftFirst];
                leftFirst++;
            }
            else{
                temp[index] = value[rightFirst];
                rightFirst++;
            }
            index++;
        }
        while(leftFirst<=leftLast){
            temp[index] = value[leftFirst];
            leftFirst++;
            index++;
        }
        while(rightFirst <= rightLast){
            temp[index] = value[rightFirst];
            rightFirst++;
            index++;
        }
        for(int i=start;i<=rightLast;i++)
            value[i] = temp[i];
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
                if(temp.compareTo(value[first]) > 0)
                    correctSide = false;
                else{
                    first++;
                    if(first <= last)
                        correctSide = true;
                    else
                        correctSide = false;
                }
            }
            if(first<= last)
                correctSide = true;
            else
                correctSide = false;
            while(correctSide){
                if(temp.compareTo(value[last]) < 0)
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
