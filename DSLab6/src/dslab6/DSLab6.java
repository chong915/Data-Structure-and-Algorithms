/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Windows 10
 */
public class DSLab6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Q1
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter transactions : ");
        String str = sc.nextLine();
        //"|" is a control chracter in regex and \ is a control character in Java
        //So, need to pass "\\|"
        String[]split = str.split("\\|");
        System.out.println(split.length);
        Queue<String[]> q = new LinkedList<>();
        //Split each transaction into two parts, Type(Deposit or Withdraw) and amount
        for(int i=0;i<split.length;i++){
            String[]split1 = split[i].trim().split(" ");
            String[]temp = {split1[0], split1[1]};
            q.add(temp);
        }
        transactions(q);
        */
        /*Q2
        try{
            Scanner s = new Scanner(new File("lab6Q2.txt"));
            Queue<String> productCode = new LinkedList<>();
            Queue<Queue<String>> queues = new LinkedList<>();
            
            while(s.hasNextLine()){
                String sentence = s.nextLine();
                String[]split = sentence.split(" ");
                for(int i=0;i<split.length-1;i = i+2){
                    String code = split[i];
                    String product = split[i+1];
                    
                    if(!productCode.contains(code)){
                        productCode.add(code);
                        Queue<String> temp = new LinkedList<>();
                        temp.add(code);
                        queues.add(temp);
                    }
                    for(Queue<String>temp : queues){
                        if(temp.peek().equalsIgnoreCase(code))
                            temp.add(product);
                    }
                    
                }
            }
            System.out.println("Product Code in Queue : " + productCode.toString());
            System.out.println("List of product by categories");
            for(Queue<String> element : queues){
                System.out.println("Product " + productCode.remove());
                //Remove the first element of each queue in the queues,
                //which is the product code
                element.remove();
                System.out.println(element.toString());
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        */
        //Q3
        //ColorCardDeck();
        
        //Q4
        //stockShares("lab6Q4.txt");
        
        //Q5
        PriorityQueue network = new PriorityQueue();
        network.add("Video", 1, 1);
        network.showQueue();
        network.add("Voice", 2, 2);
        network.showQueue();
        network.add("Data", 0, 3);
        network.showQueue();
        network.add("Data", 0, 4);
        network.add("Voice", 2, 5);
        network.add("Video", 1, 6);
        network.showQueue();
        network.add("Voice", 2, 7);
        network.add("Voice", 2, 8);
        network.add("Data", 0, 9);
        network.add("Video", 1, 10);
        network.showQueue();
        
    }
    
    public static void stockShares(String filename){
        try{
            Scanner s = new Scanner(new File(filename));
            //Create a queue of integer array where each array stores the day on which the shares are bought
            //and number of shares bought
            // and its price
            Queue<Integer[]> q = new LinkedList<>();
            Queue<Integer[]> queueCopy;
            while(s.hasNextLine()){
                String temp = s.nextLine();
                String[] split = temp.split(" ");
                //Index 0 : Day , 1 : B or S , 2 : amount of shares, 3 : price of shares
                if(split[1].equalsIgnoreCase("B")){
                    q.add(new Integer[]{Integer.parseInt(split[0]), 
                                        Integer.parseInt(split[2]),
                                        Integer.parseInt(split[3])});
                }
                //If the stock shares are sold
                else{
                    //Calculate the total capital gain or loss
                    q.add(new Integer[]{Integer.parseInt(split[0]), 
                                        Integer.parseInt(split[2]), 
                                        Integer.parseInt(split[3])});
                    //Store it in the copy Queue so that it can be printed out later
                    queueCopy = new LinkedList<>(q);
                    int shares_sold = Integer.parseInt(split[2]);
                    int price_sold = Integer.parseInt(split[3]);
                    int count = 0;
                    int total = 0;
                    while(count < shares_sold){
                        Integer[] temp1 = q.remove();
                        //If the difference between the number of shares sold
                        //and the total sold is greater than current number
                        //of shares
                        
                        if((shares_sold-count) > temp1[1]){
                            total += temp1[1]*(price_sold-temp1[2]);
                            count +=temp1[1];
                        }
                        
                        else{
                            total += (shares_sold-count) *(price_sold-temp1[2]);
                            count += temp1[1];
                        }
                        
                    }
                    System.out.print("List of Transactions");
                    while(!queueCopy.isEmpty()){
                        Integer[] print = queueCopy.remove();
                        if(!queueCopy.isEmpty())
                            System.out.printf("\nDay %d : Buy %d shares at RM %d --> ",print[0], print[1], print[2] );
                        else{
                            System.out.printf("\nDay %d : Sell %d shares at RM %d --> ",print[0], print[1], print[2]);
                            System.out.println("\nTotal Gain " + total);
                        }
                    }
                    
                }
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public static void ColorCardDeck(){
        ColourCard deck = new ColourCard();
        Queue<String> player_1 = deck.draw(5);
        System.out.println("Player 1 Card");
        System.out.println(player_1.toString());
        System.out.println(deck.getSize());
        System.out.println("\nThe current deck : ");
        deck.showDeck();
        
        Queue<String> player_2 = deck.draw(5);
        System.out.println("Player 2 Card");
        System.out.println(player_2.toString());
        System.out.println(deck.getSize());
        System.out.println("\nThe current deck : ");
        deck.showDeck();
        
        int player_1_score = 0;
        int player_2_score = 0;
        while(!player_1.isEmpty() && !player_2.isEmpty()){
            String card_1 = player_1.remove();
            String card_2 = player_2.remove();
            if(deck.compare(card_1, card_2) > 0)
                player_1_score++;
            else if(deck.compare(card_1, card_2) < 0)
                player_2_score++;
        }
        System.out.println("Player 1 Score : " + player_1_score);
        System.out.println("Player 2 Score : " + player_2_score);
        if(player_1_score > player_2_score){
            System.out.println("Player 1 WINS!");
        }
        else if(player_1_score > player_2_score){
            System.out.println("Player 2 WINS!");
        }
        else{
            System.out.println("Draw");
        }
    }
    
    
    
    public static void transactions(Queue<String[]> q){
        int balance = 500;
        System.out.println("Initial Balance : " + balance);
        
        while(!q.isEmpty()){
            String[]temp = q.remove();
            if (temp[0].equalsIgnoreCase("D")){
                balance += Integer.parseInt(temp[1]);
                System.out.printf("\nDeposit %d             New Balance %d ",Integer.parseInt(temp[1]), balance);
            }
            else if(temp[0].equalsIgnoreCase("W")){
                if(balance < Integer.parseInt(temp[1])){
                    System.out.printf("\nWithdraw %d Rejected   New Balance %d ",Integer.parseInt(temp[1]), balance);
                }
                else{
                    balance -= Integer.parseInt(temp[1]);
                    System.out.printf("\nWithdraw %d            New Balance %d ",Integer.parseInt(temp[1]), balance);
                }
            }
        }
    }
    
}
