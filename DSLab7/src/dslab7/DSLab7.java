/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import queue.Queue1;

/**
 *
 * @author Windows 10
 */
public class DSLab7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Q1
        BST<Integer> tree = new BST<>();
        Random r = new Random();
        Integer[]random = {5, 16, 19, 18, 16, 17, 9, 0, 1, 9};
//        for(int i=0;i<random.length;i++){
//            random[i] = r.nextInt(21);
//        }
        System.out.print("The random numbers are ");
        for(int i=0;i<random.length;i++){
            System.out.print(random[i] + " ");
        }
        for(int i=0;i<random.length;i++){
            tree.add(random[i]);
        }
        System.out.println("\nThe number of elements in the tree : " + tree.getSize());
        System.out.print("The tree elements - PREORDER : ");
        tree.setOrder(BST.PREODER);
        tree.showTree();
        
        System.out.print("\nThe tree elements - INORDER : ");
        tree.setOrder(BST.INORDER);
        tree.showTree();
        
        System.out.print("\nThe tree elements - POSTORDER : ");
        tree.setOrder(BST.POSTORDER);
        tree.showTree();
        System.out.println("\nThe minimum number is : " + tree.getMinimum());
        System.out.println("The maximum number is " + tree.getMaximum());
        
        System.out.println("The total is : " + tree.getTotalValue());
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to search : ");
        int number = sc.nextInt();
        System.out.println("The number of occurence of " + number + " is " + tree.count(number));
        */
        /*Q2
        try{
            BST<String> tree = new BST<>();
            Map<String, Integer>map = new HashMap<String, Integer>();
            
            Scanner s = new Scanner(new File("lab7Q2.txt"));
            
            while(s.hasNext()){
                String sentence = s.nextLine();
                sentence = sentence.replaceAll("[^a-zA-Z0-9_-]"," ");
                //System.out.println(sentence);
                String[]split = sentence.split("\\s+");
                //System.out.println(split.length);
//                for(String element : split)
//                    System.out.println(element + " ");
                for(int i=0;i<split.length;i++){
                    String temp = split[i].toLowerCase();
                    if(!tree.contains(temp)){
                        tree.add(temp);
                        map.put(temp, 1);
                    }
                    else
                        map.put(temp, map.get(temp) + 1);
                }
            }
            //System.out.println("BST".compareTo("computer"));
            tree.setOrder(BST.INORDER);
            Queue1<String>Q = tree.returnQueue();
            Map<String, String> updatedMap = new LinkedHashMap<>();
            while(!Q.isEmpty()){
                String temp = Q.dequeue();
                Integer occurence = map.get(temp);
                String occurenceLeadingZeros = String.format("%04d", occurence);
                updatedMap.put(temp, occurenceLeadingZeros);
            }
            System.out.println("Word Frequency Generator Program");
            Iterator iterator = updatedMap.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry pair = (Map.Entry)iterator.next();
                System.out.println(pair.getValue() + " " + pair.getKey() + " --> ");
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        */
        //Q3
        Scanner sc = new Scanner(System.in);
        ExpressionTree tree = new ExpressionTree();
        System.out.print("Enter the expression : ");
        String input = sc.next();
        tree.insert(input);
        tree.traverse(1);
        System.out.println();
        tree.traverse(2);
        System.out.println();
        tree.traverse(3);
    }
    
}
