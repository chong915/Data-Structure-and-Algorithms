/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author Windows 10
 */
public class DSLab5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        /* Q1
        Stack <String> stack = new Stack<>();
        stack.push("Orange");
        stack.push("Red");
        stack.push("Blue");
        stack.push("Orange");
        stack.push("Yellow");
        stack.push("Yellow");
        stack.push("Blue");
        
        System.out.println("The candies in the container : ");
        ListIterator iterator = stack.listIterator(stack.size());
        while(iterator.hasPrevious())
            System.out.print(" <-- " + iterator.previous());
        
        System.out.println("\nAli takes all the candies one by one from the container and eats the blue ones");
        System.out.println("He puts back the rest of candies in the container");
        
        Stack<String>temp = new Stack<>();
        while(!stack.isEmpty()){
            if(!stack.peek().equalsIgnoreCase("Blue"))
                temp.push(stack.pop());
            else
                stack.pop();
        }
        
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
        
        System.out.println("The candies in the container : ");
        ListIterator iterator1 = stack.listIterator(stack.size());
        while(iterator1.hasPrevious())
            System.out.print(" <-- " + iterator1.previous());
        */
        
        /*Q2
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter infix expression :");
        String input = sc.nextLine();
        String postfix = infixToPostfix(input);
        System.out.printf("The postfix expression is: %s",postfix);
        //System.out.printf("\nThe result is: %s", postfixEvaluation(postfix.replaceAll("\\s", "")));
        System.out.printf("\nThe result is: %s", postfixEvaluation(postfix));
        System.out.println();
        */
        /*Q3
        int[][]board = {{0,0,0,0,0},
                        {0,0,0,0,0},
                        {0,0,0,0,0},
                        {0,0,0,0,0},
                        {0,0,0,0,0}};
    
        solveNQueensStack(board,0);
        System.out.println("\nTotal number of solutions: " + total_solutions);
        */
//        if(solveNQUtil(board,0) == false)
//            System.out.println("There's no solution for N Queens");
//        else{
//            for(int i=0;i<4;i++){
//                for(int j=0;j<4;j++){
//                    if(board[i][j] == 1)
//                        System.out.print("Q");
//                    else
//                        System.out.print("*");
//                }
//                System.out.println();
//            }
//        }
          
        /*Q4
        matches("System.out.print(str.charAt(3)");
        System.out.println("\\");
        matches("\\(No Error");
        matches("int[]num = 1,2}");
        matches("if (arr[{3] < 4)");
        */
        
        /*Q5
        System.out.println(testXML("test.txt"));
        */
        
        //Q6
        Scanner input = new Scanner(System.in);
        //To get the filename
        System.out.print("Enter filename : ");
        String filename = input.next();
        Scanner sc = new Scanner(new File(filename));
        //To get the width and height of the maze
        int lines = 1;
        String firstLine = sc.nextLine();
        int width = firstLine.length();
        while(sc.hasNextLine()){
            sc.nextLine();
            lines++;
        }
        sc.close();
        Scanner s = new Scanner(new File(filename));
        char[][] maze = new char[lines][width];
        //To get the two-dimensional maze and store it in the variable maze
        for(int i=0;i<lines;i++){
            String sentence = s.nextLine();
            for(int j=0;j<width;j++){
                maze[i][j] = sentence.charAt(j);
            }
        }
        //Print it out
        for(int i=0;i<lines;i++){
            for(int j=0;j<width;j++){
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
        Stack<int[]>stack = new Stack<>();
        List<Integer[]> visited = new ArrayList<>();
        
        //Find where the 'S' is located in the maze as the starting point
        int[]start = findStart(maze);
        System.out.println(start[0] + ", " + start[1]);
        //System.out.println(deepContains(visited, new Integer[]{1, 3}));
        solveMazeStack(maze, start[0], start[1], stack, visited);
        
    }
    static int n = 0;
    static List<Integer[]>global_visited = new ArrayList<>();
    public static boolean solveMazeStack(char maze[][], int x, int y, Stack<int[]>stack, List<Integer[]>visited){
        stack.push(new int[]{x, y});
        global_visited.add(new Integer[]{x,y});
        System.out.print("(" + x + ", " + y + "), " + " --> ");
        
        //Check if it reaches the finish line 
        if(maze[x][y] == 'F'){
            System.out.println("\nThe solution is:");
            Iterator iterator = stack.iterator();
            while(iterator.hasNext()){
                int[] temp = (int[]) iterator.next();
                int x_value = temp[0];
                int y_value = temp[1];
                System.out.print("(" + temp[0] + ", " + temp[1] + ") --> ");
                if(!iterator.hasNext())
                    System.out.print("end");
                maze[x_value][y_value] = '.';
                //System.out.print(maze[temp[0]][temp[1]]);
            }
            //To modify the start and finish from '.' to 'S' and 'F'
            int[] start = stack.firstElement();
            maze[start[0]][start[1]] = 'S';
            int[] dest = stack.lastElement();
            maze[dest[0]][dest[1]] = 'F';
            
            System.out.println();
            for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[i].length;j++){
                System.out.print(maze[i][j]);
                }
                System.out.println();
            }
            return true;
        }
        //Try going to right
        if(maze[x][y+1] != '#' && !deepContains(global_visited, new Integer[]{x,y+1})){
            
            if(solveMazeStack(maze, x, (y + 1), stack,visited) == true)
                return true;
            
        }
        //Try going up
        if(maze[x-1][y] != '#' && !deepContains(global_visited, new Integer[]{x-1, y})){
            if(solveMazeStack(maze, x-1, y, stack, visited) == true)
                return true;
            
        }
        //Try going left
        if(maze[x][y-1] != '#' && !deepContains(global_visited, new Integer[]{x, y-1})){
            if(solveMazeStack(maze, x, y-1, stack, visited) == true)
                return true;
        }
        //Try going down
        if(maze[x+1][y] != '#' && !deepContains(global_visited, new Integer[]{x+1, y})){
            if(solveMazeStack(maze, x+1, y, stack, visited) == true)
                return true;
        }
        stack.pop();
        return false;
    }
    public static boolean deepContains(List<Integer[]> list, Integer[] probe) {
    for (Integer[] element : list) {
      if (Arrays.deepEquals(element, probe)) {
        return true;
      }
    }
    return false;
  }
    public static int[]findStart(char[][]maze){
        int[]start = new int[2];
        label1:
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[i].length;j++){
                if(maze[i][j] == 'S'){
                    start[0] = i;
                    start[1] = j;
                    break label1;
                }
            }
        }
        return start;
    }
    
//    /* A recursive utility function to solve Maze problem */
//boolean solveMazeUtil(char maze[][], int x, int y, int sol[][]) 
//{ 
//    // if (x, y is goal) return true 
//    if (x == N - 1 && y == N - 1 && maze[x][y] == 1) { 
//        sol[x][y] = 1; 
//        return true; 
//    } 
//  
//    // Check if maze[x][y] is valid 
//    if (isSafe(maze, x, y) == true) { 
//        // mark x, y as part of solution path 
//        sol[x][y] = 1; 
//  
//        /* Move forward in x direction */
//        if (solveMazeUtil(maze, x + 1, y, sol) == true) 
//            return true; 
//  
//        /* If moving in x direction doesn't give solution then 
//           Move down in y direction  */
//        if (solveMazeUtil(maze, x, y + 1, sol) == true) 
//            return true; 
//  
//        /* If none of the above movements work then BACKTRACK:  
//            unmark x, y as part of solution path */
//        sol[x][y] = 0; 
//        return false; 
//    } 
//  
//    return false; 
//} 
    
    public static boolean testXML(String filename) throws FileNotFoundException{
        Scanner s = new Scanner(new File(filename));
        Stack<String>stack = new Stack<>();
        
        int n = 0;
        //Loop through every lines
        while(s.hasNextLine()){
            String sentence = s.nextLine();
            System.out.println(sentence);
            System.out.println(n);
            n++;
            Iterator iterator = stack.iterator();
            while(iterator.hasNext())
                System.out.print(iterator.next() + " ");
            System.out.println();
            
            
            Stack<Character>tempStack = new Stack<>();
            String str = "";
            
            //Check one line at a time
            for(int i=0; i<sentence.length(); i++){
                //Check if the character is '/',if yes, continue to the next character coz have already
                //push it onto the stack in the previous character loop, see the code below
                if(sentence.charAt(i) == '/')
                    continue;
                
                //Check if the character is '>', if yes, continue to check if it's empty.
                //If it's empty, just push it onto the stack, else
                //Check if the top of stack is '/',if yes, complete the str and compare it to the topOfStack of outerloop stack variable
                //Else, push the element onto the outer loop stack and don't forget to reset the str as well
                if(sentence.charAt(i) == '>'){
                    String temp = '<' + str + '>';
                    String rootElement = "";
                    
                    //If the stack is not empty, get its root element(First element)
                    if(!stack.isEmpty())
                        rootElement = stack.firstElement();
                    
                    //If the stack is empty, just push it onto the stack
                    if(stack.isEmpty())
                        stack.push(temp);
                    
                    
                    //If the top of tempStack is '/', compare this ending element with its begin element
                    else if(tempStack.peek() == '/'){
                        String previous = stack.pop();
                        tempStack.pop(); //To pop '/'
                        String current = tempStack.pop() + str + ">";
                        
                        if(current.equals(previous))
                            continue;
                        
                        else if(current.equalsIgnoreCase(previous)){
                            System.out.println(current);
                            System.out.printf("Begin Element : %s Invalid ending element : %s",
                                    previous, "</" + current.substring(1));
                            return false;
                        }
                        else{
                            System.out.printf("Begin element : %s Invalid ending element : %s",
                                    previous, "</" + current.substring(1));
                            return false;
                        }
                    }
                    else{
                        //Else if the stack already contains the element, return false
                        
                            if(rootElement.equals(temp)){
                                System.out.println("Duplicate element :" + temp);
                                return false;
                            }
                        
                        stack.push(temp);
                        tempStack.pop();
//                        String topOfStack = stack.peek();
//                        if(topOfStack.equals(temp)){
//                            System.out.println("One element confirmed");
//                            stack.pop();
//                            continue;
//                        }
                    }
                    str = "";
                }
                //Check if the character is '<', if yes, push it onto the tempStack and if the next character is
                //'/', push it onto the tempStack as well
                else if(sentence.charAt(i) == '<'){
                    tempStack.push('<');
                    if(sentence.charAt(i+1) == '/')
                        tempStack.push('/');
                }
                
                //Else, add character to the variable str if the top of the tempStack is '<' or '/'
                //Put try and catch block coz have to deal with empty stack sometimes
                else{
                try{
                    if(tempStack.peek() == '<' || tempStack.peek() == '/'){
                        str += sentence.substring(i,i+1);
                        System.out.println(str);
                
                }}catch(Exception e){
                    continue;
                
                    }
                }
            }
            }
        
        return true;
    }
    
    
    public static boolean matches(String str){
        Stack<Character>stack = new Stack<>();
        char [] checks = {'(', ')', '[', ']', '{', '}'};
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            
            if(c == '\\'){
                stack.push(c);
                continue;
            }
            //Check if the character is special character
            for(int j=0; j<checks.length; j++){
                //System.out.println(stack.size());
                if(c == checks[j]){
                    if(!stack.isEmpty()){
                        Character topOfStack = stack.peek();
                        if(topOfStack == '\\'){
                            stack.pop();
//                            System.out.println(stack.peek());
//                            System.out.println(stack.size());
                           break;
                        }
                        //System.out.println(topOfStack);
                        switch(c){
                            case')':
                                if(topOfStack != '('){
                                    switch(topOfStack){
                                        case'{':
                                            System.out.println("Missing }");
                                            return false;
                                        case '(':
                                            System.out.println("Missing )");
                                            return false;
                                        case '[':
                                            System.out.println("Missing ]");
                                            return false;
                                        default:
                                            System.out.println("Extra )");
                                            return false;
                                    }
                                }
                                stack.pop();
                                break;
                            case ']':
                                if(topOfStack != '['){
                                    switch(topOfStack){
                                        case'{':
                                            System.out.println("Missing }");
                                            return false;
                                        case '(':
                                            System.out.println("Missing )");
                                            return false;
                                        case '[':
                                            System.out.println("Missing ]");
                                            return false;
                                        default:
                                            System.out.println("Extra )");
                                            return false;
                                    }
                                    //System.out.println("Extra ]");
                                    //return false;
                                }
                                stack.pop();
                                break;
                            case '}':
                                if(topOfStack != '{')
                                switch(topOfStack){
                                        case'{':
                                            System.out.println("Missing }");
                                            return false;
                                        case '(':
                                            System.out.println("Missing )");
                                            return false;
                                        case '[':
                                            System.out.println("Missing ]");
                                            return false;
                                        default:
                                            System.out.println("Extra )");
                                            return false;
                                    }
                                stack.pop();
                                break;
                            case '(':case'[':case'{':
                                //System.out.println("Push");
                                stack.push(c);
                                break;
                        }
                    }
                    else
                        stack.push(c);
                }
                
            }
        }
        if(!stack.isEmpty()){
            char c = stack.pop();
            switch(c){
                case'(':
                    System.out.println("Missing )");
                    break;
                case '{':
                    System.out.println("Missing }");
                    break;
                case '[':
                    System.out.println("Missing ]");
                    break;
                case '}':
                    System.out.println("Extra }");
                    break;
                case ']':
                    System.out.println("Extra ]");
                    break;
                case ')':
                    System.out.println("Extra )");
                    break;
            }
            return false;
        }
        System.out.println("The expression is balanced");
        return true;
    }
    
    
    public static String infixToPostfix(String a){
        String str = "";
        char c = ' ';
        Stack<Character> stack = new Stack<>();
        //Loop through every character in the string
        for(int i=0;i<a.length(); i++){
            
            //Check if the character is operand
            if(Character.isLetterOrDigit(a.charAt(i))){
                str += a.charAt(i);
                if ((i+1) >= a.length() || !Character.isDigit(a.charAt(i+1))) { //EXCEPTION OCCURS
                    str += ' ';
                } 
            }
            //Check if the character is open bracket or closed bracket
            else if(a.charAt(i) == '(')
                stack.push(a.charAt(i));
            else if(a.charAt(i) == ')'){
                c = stack.pop();
                while(c != '('){
                    str += c;
                    c = stack.pop();
                }
            }
            else{
                if(!stack.isEmpty()){
                    if (stack.peek() == '(')
                        stack.push(a.charAt(i));
                    else{
                        c = stack.peek();
                        while(getPriority(a.charAt(i)) <= getPriority(c)){
                            str += stack.pop() + " ";
                            if(!stack.isEmpty()){
                                c = stack.peek();
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
            str += stack.pop() + " ";
        
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
    
    public static int postfixEvaluation(String a){
        Stack<Integer> stack = new Stack<>();
        int num1 = 0, num2 = 0, result = 0;
        for(int i=0; i<a.length(); i++){
            if (a.charAt(i) == ' ')
                continue;
//            if(Character.isDigit(a.charAt(i+1)))
//                stack.add(a.charAt(i) + "");
            // If the scanned character is an operand  
            // (number here),extract the number 
            // Push it to the stack. 
            if(Character.isDigit(a.charAt(i)))
            { 
                int n = 0; 
                char c = a.charAt(i);
                //extract the characters and store it in num 
                while(Character.isDigit(c)) 
                { 
                    n = n*10 + (int)(c-'0'); 
                    i++; 
                    c = a.charAt(i); 
                } 
                i--; 
                
                //push the number in stack 
                stack.push(n); 
            } 
            else{
                num2 = stack.pop();
                num1 = stack.pop();
                result = getResult(num1, num2, a.charAt(i));
                stack.push(result);
            }
        }
        return stack.pop();
//            try {  
//                Integer tempDigit = Integer.parseInt(a[i]);  
//                digit.add(tempDigit);
//            } catch(NumberFormatException e){  
//                operator.add(a[i]);
//            }  
        }

        
        
        
//        for(int i=0; i<a.length();i++){
//            if(Character.isLetterOrDigit(a.charAt(i))){
//                temp = a.substring(i, i+1);
//                stack.push(temp);
//            }
//            else{
//                num2 = Integer.parseInt(stack.pop());
//                num1 = Integer.parseInt(stack.pop());
//                result = getResult(num1, num2, a.charAt(i));
//                stack.push(String.valueOf(result));
//            }
//        }
//        result = Integer.parseInt(stack.pop());
//        return result;
    
    
    public static int getResult(int a, int b, char c){
        switch(c){
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            case '%':
                return a%b;
        }
        return 0;
    }
    
    static boolean isSafe(int board[][], int row, int col){
        int i, j;
        
        //Check this row on left side
        for(i=0; i< col; i++)
            if(board[row][i] == 1)
                return false;
        //Check upper diagonal on left side
        for(i = row, j = col; j>=0 && i>=0; i--, j--)
            if(board[i][j] == 1)
                return false;
        //Check lower diagonal on left side
        for(i = row, j = col; j>=0 && i<N; i++, j--)
            if(board[i][j] == 1)
                return false;
        
        return true;
    }
    
    final static int N = 4;
    static int total_solutions = 0;
    static void solveNQueensStack(int board[][], int col){
        Stack<Integer>stack = new Stack<>();
        int current = 0;
        boolean position = false;
        while(true){
            //System.out.println(col);
            position = false;
            //displayBoard(board);
            for(int i=current; i<N; i++){
                
                if(isSafe(board, i, col)){
                    stack.push(i);
                    board[i][col] = 1;
                    position = true;
                    current = 0;
                    col++;
                    break;
                }
            }
            if(!position){
                if(stack.isEmpty())
                    break;
                else{
                    current = stack.pop();
                    board[current][col-1] = 0;
                    current++;
                    col--;
                }
                
            }
            if(stack.size() == N){
                total_solutions++;
                Iterator iterator = stack.iterator();
                char[][]display = new char[N][N];
                int column = 0;
                while(iterator.hasNext()){
                    int temp = (int) iterator.next();
                    for(int i=0;i<N;i++){
                        if(temp == i)
                            display[i][column] = 'Q';
                        else
                            display[i][column] = '*';
                    }
                    column++;
                }
                for(int i=0; i<N;i++){
                    for(int j=0;j<N;j++){
                        System.out.print(display[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }
    }
    static void displayBoard(int[][]board){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    static boolean solveNQUtil(int board[][], int col){
        /* base case: If all queens are placed 
           then return true */
        if (col >= N) 
            return true; 
  
        /* Consider this column and try placing 
           this queen in all rows one by one */
        for (int i = 0; i < N; i++) { 
            /* Check if the queen can be placed on 
               board[i][col] */
            if (isSafe(board, i, col)) { 
                /* Place this queen in board[i][col] */
                board[i][col] = 1; 
  
                /* recur to place rest of the queens */
                if (solveNQUtil(board, col + 1) == true) 
                    return true; 
  
                /* If placing queen in board[i][col] 
                   doesn't lead to a solution then 
                   remove queen from board[i][col] */
                board[i][col] = 0; // BACKTRACK 
            } 
        }
        return false;
    }
}
