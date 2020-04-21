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
public class ExpressionTree<T> {
    private BSTNode root;
    
    public ExpressionTree(){
        root = null;
    }
    
    public void insert(String s)
    {
        Conversion c = new Conversion(s);
        s = c.inToPost();
        Stack stk = new Stack();
        s = s + "#";
        int i = 0;
        char symbol = s.charAt(i);
        BSTNode newNode;
        while (symbol != '#')
        {
            if (symbol >= '0' && symbol <= '9' || symbol >= 'A'
                    && symbol <= 'Z' || symbol >= 'a' && symbol <= 'z')
            {
                newNode = new BSTNode(symbol, null, null);
                stk.push(newNode);
            } else if (symbol == '+' || symbol == '-' || symbol == '/'
                    || symbol == '*')
            {
                BSTNode ptr1 = (BSTNode) stk.pop();
                BSTNode ptr2 = (BSTNode) stk.pop();
                newNode = new BSTNode(symbol, null, null);
                newNode.setLeft(ptr2);
                newNode.setRight(ptr1);
                stk.push(newNode);
            }
            symbol = s.charAt(++i);
        }
        root = (BSTNode) stk.pop();
    }
 
    public void traverse(int type)
    {
        switch (type)
        {
            case 1:
                System.out.print("Preorder Traversal:--> ");
                preOrder(root);
                break;
            case 2:
                System.out.print("Inorder Traversal:--> ");
                inOrder(root);
                break;
            case 3:
                System.out.print("Postorder Traversal:--> ");
                postOrder(root);
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }
 
    private void preOrder(BSTNode localRoot)
    {
        if (localRoot != null)
        {
            System.out.print(localRoot.getData() + " ");
            preOrder(localRoot.getLeft());
            preOrder(localRoot.getRight());
        }
    }
 
    private void inOrder(BSTNode localRoot)
    {
        if (localRoot != null)
        {
            inOrder(localRoot.getLeft());
            System.out.print(localRoot.getData() + " ");
            inOrder(localRoot.getRight());
        }
    }
 
    private void postOrder(BSTNode localRoot)
    {
        if (localRoot != null)
        {
            postOrder(localRoot.getLeft());
            postOrder(localRoot.getRight());
            System.out.print(localRoot.getData() + " ");
        }
    }
}
