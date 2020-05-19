/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Windows 10
 */
public class DSLab9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Q1
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N : ");
        int N = sc.nextInt();
        SearchTest<Integer>map = new SearchTest<>(SearchTest.ASCENDING, SearchTest.INTEGER, N,10,20);
        System.out.println("The matrix are : ");
        map.showValue();
        
        System.out.println("Linear Search");
        System.out.print("Enter a number to search : ");
        int key = sc.nextInt();
        boolean found = map.linearSearchcontains(key);
        if(found){
            System.out.printf("%d is found", key);
            System.out.printf("\nThe number of %d in the matrix is %d\n", key, map.linearSearchCount(key));
            String[]indices = map.linearSearchgetIndices(key);
            for(String index : indices)
                System.out.print(index);
        }
        else
            System.out.printf("%d is not found", key);
        */
        
        /*Q2
        Scanner sc = new Scanner(System.in);
        SearchTestLinkedList<Integer>map = new SearchTestLinkedList<>(SearchTestLinkedList.INTEGER);
        System.out.print("The random integers are : ");
        map.showValue();
        System.out.println("\nLinear Search");
        System.out.print("Enter a number to search : ");
        int key = sc.nextInt();
        boolean found = map.linearSearchContains(key);
        if(found){
            System.out.printf("%d is found", key);
            System.out.printf("\nThe number of %d in the data set is %d", key, map.linearSearchCount(key));
        }
        else{
            System.out.printf("%d is not found", key);
        }
        
        System.out.print("\nEnter two numbers to search (begin end) : ");
        int start = sc.nextInt();int end = sc.nextInt();
        boolean isWithinRange = map.containsWithinRange(start, end);
        if(isWithinRange){
            System.out.printf("The integer can be found in between %d and %d", start, end);
            System.out.printf("\nThe number of elements in between %d and %d in the data set is %d", start, end, map.countWithinRange(start, end));
        }
        else{
            System.out.printf("No integer can be found in between %d and %d", start, end);
        }
        System.out.println();
        */
        
        /*Q3
        Scanner sc = new Scanner(System.in);
        ArrayMap<String,String>map = new ArrayMap<>();
        String[]code = {"100-101","200-101","200-120","210-260"};
        String[]name = {"ICND 1", "ICND 2", "CCNA Routing and Switching", "CCNA Security"};
        
        for(int i=0;i<code.length;i++){
            map.put(code[i], name[i]);
        }
        System.out.println("The number of courses is " + map.getSize());
        map.showHashTable();
        
        System.out.println("\nAdding a new course");
        map.put("300-101", "ROUTE");
        System.out.println("The number of courses is " + map.getSize());
        map.showHashTable();
        
        System.out.println("\nModifying 210-260");
        map.put("210-260", "CCNA RS Security");
        System.out.println("The number of courses is " + map.getSize());
        map.showHashTable();
        
        System.out.println("\nRemoving the course 200-101");
        map.remove("200-101");
        System.out.println("The number of courses is " + map.getSize());
        map.showHashTable();
        
        System.out.print("\nEnter a course code to search : ");
        String key = sc.next();
        System.out.printf("Course %s : %s ", key, map.get(key));
        System.out.println();
        */
        
        /*Q4
        Integer[]pid = null;
        String[]desc = null;
        int index = 0;
        
        try{
            Scanner s = new Scanner(new File("lab9Q4.txt"));
            int lines = 0;
            while(s.hasNextLine()){
                lines++;
                s.nextLine();
            }
            pid = new Integer[lines];
            desc = new String[lines];
            s.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        
        try{
            BufferedReader br = new BufferedReader(new FileReader("lab9Q4.txt"));
            String temp;
            while((temp = br.readLine()) != null){
                String[]sentence = temp.split(" ", 2);
                pid[index] = Integer.parseInt(sentence[0]);
                desc[index] = sentence[1];
                index++;
            }
            br.close();
            int lines = index;
            ArrayHashTableHashing<Integer,String>map = new ArrayHashTableHashing<>(lines);
            for(int i=0;i<pid.length;i++){
                map.put(pid[i], desc[i]);
            }
            map.showHashTable();
            System.out.println("The Hash Table size is " + map.getSize());
            System.out.print("Enter a PID to search : ");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            boolean found = map.containsKey(num);
            if(found){
                System.out.printf("Product ID : %d  ", num, map.get(num));
                System.out.println("\nLocation : " + map.getIndex(num));
            }
            else{
                System.out.printf("Product ID : %d cannot be found\n", num);
            }
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        */   
        
        //Q5
        String[]pid = null;
        String []desc = null;
        
        try{
            Scanner s = new Scanner(new File("lab9Q4.txt"));
            int countLines = 0;
            while(s.hasNextLine()){
                countLines++;
                s.nextLine();
            }
            s.close();
            pid = new String[countLines];
            desc = new String[countLines];
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        
        try{
            BufferedReader br = new BufferedReader(new FileReader("lab9Q4.txt"));
            String temp;
            int index = 0;
            System.out.println("The data set from the File");
            while((temp = br.readLine()) != null){
                String[]sentence = temp.split(" ", 2);
                System.out.println(sentence[0] + ":" + sentence[1]);
                pid[index] = sentence[0];
                desc[index] = sentence[1];
                index++;
            }
            br.close();
            
            System.out.print("\nHash Table Using Hash Chain");
            ChainHashTable<String,String>map = new ChainHashTable<>(pid.length);
            for(int i=0;i<pid.length;i++){
                map.insert(pid[i], desc[i]);
            }
            map.showTable();
            System.out.println("\n\nHash Values : ");
            map.getHashValues();
            System.out.println("\nThe Hash Table size is " + map.getSize());
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a PID to search : ");
            String key = sc.nextLine();
            String str;
            if((str = map.getValue(key)) == null)
                System.out.printf("Product ID %s cannot be found\n", key);
            else{
                System.out.printf("Product ID : %s  %s", key, str);
                System.out.println("\nThe elements in the same location are : ");
                System.out.println(map.getBucket(key));
            }
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
