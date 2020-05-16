/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dstutorial9;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Windows 10
 */
public class SearchTest<T extends Comparable<T>> {
    private final int MAX = 100;
    private final int MAXCHAR = 26;
    private T[] value;
    private int orderType, size;
    private Random r;
    public static final int ASCENDING = 1, DESCENDING = 0;
    
    public SearchTest(int orderType,T b, int size){
        this.orderType = orderType;
        this.size = size;
        value = (T[]) new Comparable[size];
        r = new Random();
        char c;
        for(int i=0;i<size;i++){
            if(b instanceof Integer)
                value[i] =(T)(Integer) r.nextInt(MAX);
            else if(b instanceof Double)
                value[i] = (T)(Double)(0.01 * r.nextInt(MAX));
            else if(b instanceof Character){
                c = (char)('A' + r.nextInt(MAXCHAR));
                value[i] = (T)(Character)c;
            }
            else if(b instanceof String){
                c = (char)('A' + r.nextInt(MAXCHAR));
                value[i] = (T)(c + ""); 
            }
        }
    }
    
    public void swap(int index1, int index2){
        T temp = value[index1];
        value[index1] = value[index2];
        value[index2] = temp;
    }
    
    public void binarySearch(T t){
        binarySearch(0, value.length-1, t);
    }
    public void binarySearch(int start, int end, T t){
        int middle = (start+end)/2;
        if(end < start){
            System.out.println("Not found");
            return;
        }
        if(value[middle].compareTo(t) == 0)
            System.out.println(t + " is found at index " + middle);
        else if((value[middle].compareTo(t) > 0 && orderType == ASCENDING)||
                value[middle].compareTo(t) < 0 && orderType == DESCENDING){
            binarySearch(start, middle-1,t);
        }
        else{
            binarySearch(middle+1,end,t);
        }
    }
    
    public void mergeSort(){
        mergeSort(0,value.length-1);
    }
    public void mergeSort(int first, int last){
        if(first < last){
            int middle = (first+last)/2;
            mergeSort(first, middle);
            mergeSort(middle+1,last);
            merge(first,middle,middle+1,last);
        }
    }
    public void merge(int leftFirst, int leftLast, int rightFirst, int rightLast){
        T[]temp =(T[]) new Comparable[size];
        int index = leftFirst;
        int currentIndex = leftFirst;
        
        while( (leftFirst<=leftLast) && (rightFirst <= rightLast) ){
            if((value[leftFirst].compareTo(value[rightFirst]) < 0 && orderType == ASCENDING) ||
                value[leftFirst].compareTo(value[rightFirst]) > 0 && orderType == DESCENDING){
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
    
    public void showValue(){
        for(int i=0;i<value.length;i++){
            System.out.print(value[i] + " ");
        }
    }
    
    public boolean contains(T t){
        for(int i=0;i<value.length;i++){
            if(value[i].compareTo(t) ==  0)
                return true;
        }
        return false;
    }
    public int occurence(T t){
        int count = 0;
        for(int i=0;i<value.length;i++){
            if(value[i].compareTo(t) == 0)
                count++;
        }
        return count;
    }
    public Integer[] indices(T t){
        LinkedList<Integer>list = new LinkedList<>();
        for(int i=0;i<value.length;i++){
            if(value[i].compareTo(t) == 0)
                list.add(i);
        }
        Integer[]indices = list.toArray(new Integer[list.size()]);
        return indices;
    }
    public boolean containsWithinRange(T start,T end){
//        T start = null;
//        T end = null;
//        if(b instanceof Integer){
//            start =(T)(Integer) Character.getNumericValue(a.charAt(0));
//            end = (T)(Integer)Character.getNumericValue(a.charAt(1));
//        }
//        else if(b instanceof Character){
//            start =(T)(Character) a.charAt(0);
//            end = (T) (Character) a.charAt(1);
//        }
        LinkedList<Integer>list = new LinkedList<>();
        int count = 0;
        boolean found = false;
        for(int i=0;i<value.length;i++){
            if(value[i].compareTo(start) >= 0 && value[i].compareTo(end) <= 0){
                count++;
                found = true;
                list.add(i);
            }
        }
        if(found){
            if(start instanceof Character){
                System.out.printf("The character can be found in between %c and %c"
                ,start,end);
                System.out.printf("\nThe number of elements in between %c and %c in the data set is %d"
                ,start,end,count);
                System.out.printf("\nThe location of the elements in between %c and %c are ",
                        start,end);
                Character[]temp = list.toArray(new Character[list.size()]);
                System.out.println();
                for(Character c : temp)
                    System.out.print(c + " ");
            }
            else if(start instanceof Integer){
                System.out.printf("The integer can be found in between %d and %d",
                        start, end);
                System.out.printf("\nThe number of the elements in between %d and %d in the data set is %d",
                        start, end, count);
                System.out.printf("\nThe location of the elements in between %d and %d are ",
                        start, end);
                Integer[]temp = list.toArray(new Integer[list.size()]);
                for(Integer number : temp)
                    System.out.print(number + " ");
            }
            return true;
        }
        else{
            System.out.println("No character can be found between N and P");
            return false;
        }
    }
}
