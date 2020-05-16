/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Windows 10
 */
public class DSLab8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        /*Q1
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N Special Random Number within 0-100 : ");
        int size = sc.nextInt();
        int[]num = new int[size];
        
        Random r = new Random();
        for(int temp : num)
            temp = r.nextInt(101);
        System.out.print("The Special Numbers are : ");
        for(int temp : num)
            System.out.print(temp + " ");
        mergeSort(num);
        System.out.print("\nAfter Merge Sort : ");
        for(int temp : num)
            System.out.print(temp + " ");
        
        */
        
        /*Q2
        Product[]product;
        Scanner s = new Scanner(new File("lab8Q2.txt"));
        int count = 0;
        while(s.hasNextLine()){
            s.nextLine();
            count++;
        }
        s.close();
        product = new Product[count];
        
        System.out.println("Reading data from product text file");
        BufferedReader br = new BufferedReader(new FileReader("lab8Q2.txt"));
        String temp;
        int index = 0;
        while((temp = br.readLine()) != null){
            String[]sentence = temp.split(",");
            product[index] = new Product(sentence[0], sentence[1], Double.parseDouble(sentence[2]), Integer.parseInt(sentence[3].trim()));
            index++;
        }
        for(Product p : product)
            System.out.println(p.toString());
        
        quickSort(product);
        System.out.println("After Quick Sort (Price, PID) : ");
        for(Product tmp : product)
            System.out.println(tmp.toString());
        */
        
        /*Q3
        Random r = new Random();
        int[][]num = new int[1000][100000];
        for(int i=0;i<num.length;i++){
            for(int j=0;j<num[i].length;j++)
                num[i][j] = r.nextInt(100);
        }
//        for(int[]row : num){
//            for(int value : row)
//                System.out.print(value + " ");
//            System.out.println();
//        }
        
        SortingComparison selectionSort = new SortingComparison(num);
        selectionSort.selectionSort();
        
        SortingComparison bubbleSort = new SortingComparison(num);
        bubbleSort.bubbleSort();
        
        SortingComparison insertionSort = new SortingComparison(num);
        insertionSort.insertionSort();
        
        SortingComparison mergeSort = new SortingComparison(num);
        mergeSort.mergeSort();
        
        SortingComparison quickSort = new SortingComparison(num);
        quickSort.quickSort();
        */
        
        //Q4
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.print("Enter N characters : ");
        int size = sc.nextInt();
        char[]num = new char[size];
        maxHeapSort<Character> maxHeap = new maxHeapSort<>(size);
        System.out.print("The characters are : ");
        for(int i=0;i<num.length;i++){
            num[i] = (char)('A' + r.nextInt(26));
            System.out.print(num[i] + " ");
            maxHeap.add(num[i]);
        }
        System.out.println();
        System.out.println("MaxHeap Sort - Ascending Order");
        maxHeap.heapSort();
        System.out.println();
        
        //Using minHeapSort
        minHeapSort<Character> minHeap = new minHeapSort<>(size);
        for(int i=0;i<size;i++){
            minHeap.add(num[i]);
        }
        int size1 = minHeap.getSize();
        System.out.println("MinHeap Sort - Ascending Order");
        for(int i=0;i<size1;i++){
            System.out.print(minHeap.poll() + " ");
        }
        
    }
    
    public static void quickSort(Product[]product){
        quickSort(product, 0, product.length-1);
    }
    
    public static void quickSort(Product[]product, int first, int last){
        if(first<last){
            int splitIndex = split(product, first, last);
            quickSort(product, first, splitIndex-1);
            quickSort(product, splitIndex+1, last);
        }
    }
    
    public static int split(Product[]product, int first, int last){
        boolean correctSide;
        Double splitValue = product[first].price;
        String splitPid = product[first].pid;
        int index = first;
        first++;
        
        while(first <= last){
            correctSide = true;
            while(correctSide){
                //If prices are the same, compare them by product id
                if(splitValue.compareTo(product[first].price) == 0){
                    if(splitPid.compareToIgnoreCase(product[first].pid) < 0)
                        correctSide = false;
                    else{
                        first++;
                        if(first <= last)
                            correctSide = true;
                        else
                            correctSide = false;
                    }
                }
                else if((splitValue.compareTo(product[first].price) < 0))
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
                if(splitValue.compareTo(product[last].price) == 0){
                    if(splitPid.compareToIgnoreCase(product[last].pid) >=0)
                        correctSide = false;
                    else{
                        last--;
                        if(first <= last)
                            correctSide = true;
                        else
                            correctSide = false;
                    }
                }
                if(splitValue.compareTo(product[last].price) >= 0)
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
                swap(product, first, last);
                first++;
                last--;
            }
        }
        swap(product,index, last);
        return last;
    }
    
    public static void swap(Product[]product, int index1, int index2){
        Product temp = product[index1];
        product[index1] = product[index2];
        product[index2] = temp;
    }
    
    public static void mergeSort(int[]num){
        mergeSort(num, 0, num.length-1);
    }
    
    public static void mergeSort(int[]num, int first, int last){
        if(first<last){
            int middle = (first + last)/2;
            mergeSort(num, first, middle);
            mergeSort(num, middle+1, last);
            merge(num, first, middle, middle+1, last);
        }
    }
    public static void merge(int[]num, int leftFirst, int leftLast, int rightFirst, int rightLast){
        int[]temp = new int[num.length];
        int index = leftFirst;
        int currentIndex = leftFirst;
        
        while(leftFirst <= leftLast && rightFirst <= rightLast){
            if(num[leftFirst]%2 == 1 && num[rightFirst]%2 ==1){
                if(num[leftFirst] <= num[rightFirst]){
                    temp[index] = num[leftFirst];
                    leftFirst++;
                }
                else{
                    temp[index] = num[rightFirst];
                    rightFirst++;
                }
                index++;
            }
            else if(num[leftFirst]%2 ==1){
                temp[index] = num[leftFirst];
                leftFirst++;
                index++;
            }
            else if(num[rightFirst]%2 == 1){
                temp[index] = num[rightFirst];
                rightFirst++;
                index++;
            }
            else{
                if(num[leftFirst] <= num[rightFirst]){
                    temp[index] = num[leftFirst];
                    leftFirst++;
                }
                else{
                    temp[index] = num[rightFirst];
                    rightFirst++;
                }
                index++;
            }
        }
        while(leftFirst <= leftLast){
            temp[index] = num[leftFirst];
            leftFirst++;
            index++;
        }
        while(rightFirst <= rightLast){
            temp[index] = num[rightFirst];
            rightFirst++;
            index++;
        }
        for(int i=currentIndex;i<=rightLast;i++)
            num[i] = temp[i];
    }
}
