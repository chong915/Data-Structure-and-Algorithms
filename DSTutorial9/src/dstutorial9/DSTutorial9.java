/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dstutorial9;

import java.util.Scanner;

/**
 *
 * @author Windows 10
 */
public class DSTutorial9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Q1
        Scanner sc = new Scanner(System.in);
        SearchTest<Character>list = new SearchTest<>(SearchTest.ASCENDING,'c',10);
        list.showValue();
        list.mergeSort();
        System.out.println("\nLinear Search");
        list.showValue();
        System.out.print("\nEnter a letter to search : ");
        Character c = sc.next().charAt(0);
        boolean found = list.contains(c);
        if(found){
            System.out.printf("%c is found",c);
            System.out.printf("\nThe number of %c in the data set is ",c);
            Integer[]indices = list.indices(c);
            System.out.println(list.occurence(c));
            System.out.printf("The location of the %c are : ",c);
            for(Integer index : indices)
                System.out.print(index + " ");
        }
        else
            System.out.printf("%c is not found",c);
        
        System.out.print("\nEnter two letters to search (begin end) : ");
        String a = sc.next();
        list.containsWithinRange(a,'c');
        */
        /*Q2
        Scanner sc = new Scanner(System.in);
        SearchTest<Integer>list1 = new SearchTest<>(SearchTest.ASCENDING,1,10);
        list1.showValue();
        System.out.println("\nMerge Sort : ");
        list1.mergeSort();
        list1.showValue();
        System.out.println("\nBinary Search");
        System.out.print("Enter a number to search: ");
        int key = sc.nextInt();
        list1.binarySearch(key);
        System.out.print("Enter two numbers to search (begin end) : ");
        int start = sc.nextInt();int end = sc.nextInt();
        list1.containsWithinRange(start, end);
        */
        
        //Q3
        Scanner sc = new Scanner(System.in);
        HashTable<String,String>map = new HashTable<>();
        String[]key = {"100-101","200-101","200-120","210-260"};
        String[]value = {"ICND 1", "ICND 2", "CCNA Routing and Switching", "CCNA Security"};
        for(int i=0; i<key.length; i++){
            map.put(key[i], value[i]);
        }
        System.out.println("Hash Table");
        System.out.println("The number of elements in the Hash Table " + map.getSize());
        map.showTable();
        //map.remove("210-260");
        System.out.print("\nEnter a code to search : ");
        String code = sc.nextLine();
        System.out.printf("Course %s : %s", code, map.getValue(code));
        System.out.println();
    }
    
}
