/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dstutorial5;

import java.util.Random;

/**
 *
 * @author Windows 10
 */
public class DSTutorial5 {

    //Ques 3
    public static void reverseSentence(String str){
        if(str.length()<=1){
            System.out.print(str);
        }
        else{
            System.out.print(str.charAt(str.length()-1));
            reverseSentence(str.substring(0,str.length()-1));
        }
    }
    
    public static void reverseWords(String str){
        String[]sentence=str.split(" ");
        
        if(sentence.length<=1){
            System.out.print(sentence[0]);
        }
        else{
            System.out.print(sentence[sentence.length-1] + " ");
            String temp="";
            for(int i=0;i<sentence.length-1;i++){
                temp += sentence[i] + " ";
            }
            reverseWords(temp);
        }
        
    }
    
    //Ques 4
    
    public static int fibonacciStack(int n){
        if (n == 1 || n == 2)
            return 1;
        Stack1<Integer>stack = new Stack1<>();
        stack.push(1);
        stack.push(1);
        n = n - 2;
        for(int i =0;i<n;i++){
            Integer x = stack.pop();
            Integer y = stack.pop();
            Integer z = x + y;
            stack.push(x);
            stack.push(z);
        }
        return stack.pop();
    }
       
    
    public static int fibonacci(int n){
        if(n ==1 ||n==2)
            return 1;
        else
            return fibonacci(n-1) + fibonacci(n-2);
        
    }
    
    //Ques 5
    public static boolean isBalancedParenthesis(String str){
        if(str.length() %2 !=0){
            System.out.println("Not even");
            return false;
            
        }
        
        else{
            Stack1<Character>stack = new Stack1<>();
            for(int i=0;i<str.length();i++){
                if(str.charAt(i) !=')')
                    stack.push(str.charAt(i));
                else{
                    if(stack.isEmpty())
                        return false;
                    if((Character)stack.pop() != '('){
                        System.out.println("Error");
                        return false;
                    }
                }
            }
            
        }
        return true;
    }
    
    public static Stack1 alternateStack(int[]arr){
        Stack1<Integer>stack= new Stack1<>();
        boolean isOdd = true;
        int track = 0;
        
        while(track <arr.length){
            
        for(int i=0;i<arr.length;i++){
            stack.showStack();
            System.out.println();
            for(int value : arr)
                System.out.print(value + " ");
            System.out.println();
            System.out.println(track);
            if(arr[i] == -1){
                track++;
                continue;
            }
            if(isOdd){
                if(arr[i] %2 == 1){
                    stack.push(arr[i]);
                    isOdd = false;
                    arr[i] = -1;
                    track=0;
                }
                else
                    track++;
                
            }
            else{
                if(arr[i] %2 == 0){
                    stack.push(arr[i]);
                    isOdd = true;
                    arr[i] = -1;
                    track=0;
                }
                else
                    track++;
            }
        }
        
        }
        return stack;
    }  
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Ques 1
        Stack<Character> stack = new Stack<>();
        System.out.println("Stack implementation using Linked List");
        
        System.out.println("Inseret three nodes into the stack");
        stack.insertNode('A');
        stack.insertNode('N');
        stack.insertNode('D');
        stack.showList();
        
        System.out.println("\nPop one node from the stack");
        stack.pop();
        stack.showList();
        
        System.out.println("\nThe element on the top of the stack is : " + stack.peek());
        stack.showList();
        
        System.out.println("\nThe number of elements in the stack is " + stack.getSize());
        */
        
        /*
        ArrayStackImplementation arrayStack = new ArrayStackImplementation();
        System.out.println("Stack implementation using Array");
        
        System.out.println("Insert three nodes into the stack");
        arrayStack.push('A');
        arrayStack.push('N');
        arrayStack.push('D');
        arrayStack.showStack();
        
        System.out.println("\nPop one node from the stack");
        arrayStack.pop();
        arrayStack.showStack();
        
        System.out.println("\nThe element on the top of the stack is : " + arrayStack.peek());
        arrayStack.showStack();
        
        System.out.println("\nThe number of elements in the stack is " + arrayStack.getSize());
        */
        
        /*
        Stack1<String> stack = new Stack1<>();
        System.out.println("Insert three nodes into the stack");
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        
        System.out.println("The number of elements in the stack is " + stack.getSize());
        stack.showStack();
        
        System.out.println("\nPop one node from the stack");
        stack.pop();
        
        System.out.println("The number of elements in the stack is " + stack.getSize());
        stack.showStack();
        
        System.out.println("\nThe element on the top of the stack is " + stack.peek());
        stack.showStack();
        
        System.out.println();
        */
        
        /*Ques 4
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a sentence : ");
        String str = sc.nextLine();
        System.out.println("Original sentence " + str);
        System.out.print("The sentence in reverse order : ");
        reverseSentence(str);
        System.out.print("\nThe word in reverse order : ");
        reverseWords(str);
        */
        
        /*Ques 4
        System.out.println("Fibonacci(1) : " + fibonacci(1));
        System.out.println("Fibonacci(5) : " + fibonacci(5)); 
        System.out.println("Fibonacci(8) : " + fibonacci(8));
        System.out.println("Fibonacci(14) : " + fibonacci(14));
        */
        
        /*Ques 5
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the parentheses : ");
        String str = sc.next();
        if(isBalancedParenthesis(str))
            System.out.println(str + " is balanced");
        else
            System.out.println(str + " is not balanced");
        */
        
//        int[]arr=new int[1000];
//        Random r = new Random();
//        System.out.print("The random numbers are : ");
//        for(int i=0;i<1000 ;i++){
//            arr[i] = r.nextInt(100)+1;
//            System.out.print(arr[i] + " ");
//        }
//        
//        Stack1 sortedAlternateStack = alternateStack(arr); 
//        sortedAlternateStack.showStack();
        
        System.out.println(fibonacciStack(5));
        
                
    }
    
    public static String infixToPostfix(String a){
        String str="";
        char c = ' ';
        Stack1<Character> stack = new Stack1<>();
        
        for(int i=0;i<a.length();i++){
            if(Character.isLetterOrDigit(a.charAt(i)))
                str += a.charAt(i);
            else if(a.charAt(i) == '(')
                stack.push(a.charAt(i));
            else if(a.charAt(i) == ')'){
                c = stack.pop();
                while(c != '('){
                    str+=c;
                    c = stack.pop();
                }
            }
            else{
                if(!stack.isEmpty()){
                    if(stack.peek() == '(')
                        stack.push(a.charAt(i));
                    else{
                        c = stack.peek();
                        while(getPriority(a.charAt(i)) <= getPriority(c)){
                            str += stack.pop();
                            if(!stack.isEmpty()){
                                c=stack.peek();
                                if(c == '(')
                                    break;
                            }
                            else
                                break;
                        }
                        stack.push(a.charAt(i));
                    }
                }
                else
                    stack.push(a.charAt(i));
            }
        }
        while(!stack.isEmpty())
            str += stack.pop();
        
        return str;
    }
    
    public static int getPriority(char a){
        switch(a){
            case '*':
            case '/':
            case '%':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }
        
}
    

