/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dstutorial8;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Windows 10
 */
public class DSTutorial8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Q1
        //SortTest<Character> sorting = new SortTest<>();
        //System.out.print("The random characters are : ");
        //sorting.showValue();
        //System.out.println("Selection Sort - Descending Order");
        //sorting.selectionSort();
        //System.out.println("Bubble Sort - Descending Order : ");
        //sorting.bubbleSort();
        //System.out.println("Insertion Sort - Descending Order : ");
        //sorting.insertionSort();
        //System.out.println("Merge Sort - Descending Order : ");
        //sorting.mergeSort();
        //sorting.showValue();
        //System.out.println("Quick Sort - Descending Order : ");
        //sorting.quickSort();
        //sorting.showValue();
        
        /*Q2
        StringSort<String> sort = new StringSort<>();
        System.out.print("The random String are : ");
        sort.showValue();
        //System.out.println("Merge Sort - Ascending Order");
        //sort.mergeSort();
        //sort.showValue();
        System.out.println("Quick Sort - Ascending Order");
        sort.quickSort();
        sort.showValue();
        */
        /*Q3
        Random r = new Random();
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<10;i++){
            list.add(r.nextInt(101));
        }
        System.out.println("The random integers are : " + list.toString());
        selectionSort(list);
        System.out.println("Selection Sort - Ascending Order");
        System.out.println(list.toString());
        */
        
        //Q4
        Random r = new Random();
        LinkedList<Integer> bubble = new LinkedList<>();
        for(int i=0;i<10;i++){
            bubble.add(r.nextInt(101));
        }
        System.out.println("The random integers are : " + bubble.toString());
        bubbleSort(bubble);
        System.out.println("Bubble Sort - Descending Order");
        System.out.println(bubble.toString());
    }
    
    public static void bubbleSort(LinkedList<Integer> a){
        for(int iteration = 0;iteration<a.size()-1;iteration++){
            for(int i=0;i<a.size()-1-iteration;i++){
                if(a.get(i).compareTo(a.get(i+1)) < 0){
                    Integer temp = a.get(i);
                    a.set(i, a.get(i+1));
                    a.set(i+1, temp);
                }
            }
        }
    }
    
    public static void selectionSort(LinkedList<Integer> a){
        for(int i=0;i<a.size()-1;i++){
            //Integer temp = a.get(i);
            int index = i;
            int j;
            Integer temp = a.get(i);
            for(j=i+1;j<a.size();j++){
                if(temp.compareTo(a.get(j)) > 0){
                    //temp = a.get(j);
                    index = j;
                    temp = a.get(j);
                }
            }
            int index1 = i;
            int index2 = index;
            Integer temp1 = a.get(index1);
            a.set(index1, a.get(index2));
            a.set(index2, temp1);
        }
    }
    
}
