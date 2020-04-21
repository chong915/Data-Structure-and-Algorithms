/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab7;

import java.util.Stack;

/**
 *
 * @author Windows 10
 */
public class Expression {
    private Stack<Character> operand = new Stack<>();
    private Stack<Character> operator = new Stack<>();
    private Stack<BSTNode> st = new Stack<>();
    
    public Expression(String a){
        for(int i=0;i<a.length();i++){
            char str = a.charAt(i);
            if(isOperator(str)){
                operator.push(str);
            }
            else
                operand.push(str);
        }
        String output = "";
        while(!operator.isEmpty()){
            char op1 = operand.pop();
            char op2 = operand.pop();
            char operator1 = operator.pop();
            BSTNode<Character> right = new BSTNode<>(op1, null, null);
            BSTNode<Character> left = new BSTNode<>(op2, null, null);
            BSTNode<Character> operatorNode = new BSTNode<>(operator1, null, null);
            BSTNode<Character> newNode = new BSTNode(operatorNode, left, right);
            st.add(newNode);
        }
    }
    public boolean isOperator(char a){
        switch(a){
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
            default:
                return false;
        }
    }
    
}
