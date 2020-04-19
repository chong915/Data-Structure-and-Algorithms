/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dstutorial7;

/**
 *
 * @author Windows 10
 */
public class DSTutorial7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Q1
        //in-order traversal --> 1, 5, 7, 25, 30, 40, 50, 71, 80, 99
        //pre-order traversal --> 50, 30, 25, 1, 7, 5, 40, 71, 80, 99
        //post-order traversal --> 5, 7, 1, 25, 40, 30, 99, 80, 71, 50
        
        /*Q2
        BST<Character> tree = new BST<>();
        tree.add('F');
        tree.add('A');
        tree.add('C');
        tree.add('U');
        tree.add('L');
        tree.add('T');
        tree.add('Y');
        System.out.println("The number of elements in the tree : " + tree.getSize());
        System.out.print("The tree elements - PREORDER : ");
        tree.setOrder(BST.PREORDER);
        tree.showTree();
        System.out.print("\nThe tree elements - INORDER : ");
        tree.setOrder(BST.INORDER);
        tree.showTree();
        System.out.print("\nThe tree elements - POSTORDER : ");
        tree.setOrder(BST.POSTORDER);
        tree.showTree();
        
        System.out.println("\nRemove 1 Character L");
        tree.remove('L');
        System.out.println("The number of elements in the tree : " + tree.getSize());
        System.out.print("The tree elements - INORDER : ");
        tree.setOrder(BST.INORDER);
        tree.showTree();
        System.out.print("\n The tree elements - PREORDER : ");
        tree.setOrder(BST.PREORDER);
        tree.showTree();
        System.out.print("\nThe tree elements - POSTORDER : ");
        tree.setOrder(BST.POSTORDER);
        tree.showTree();
        */
        //Q3
        BSTArrayImplementation<Character> tree = new BSTArrayImplementation<>();
        Character[]array = {'F', 'A', 'C', 'U', 'L', 'T', 'Y'};
        for(Character element : array)
            tree.addNode(element);
       
        System.out.print("The tree elements - PREODER : ");
        tree.preOrder(0);
        tree.showTree();
        tree.resetQueue();
        System.out.print("\nThe tree elements - INORDER : ");
        tree.inOrder(0);
        tree.showTree();
        tree.resetQueue();
        System.out.print("\nThe tree elements - POSTORDER : ");
        tree.postOrder(0);
        tree.showTree();
        
        
        System.out.println("\nRemove 1 Character L");
        tree.removeNode('L');
        System.out.println("The number of elements in the tree : " + tree.getSize());
        tree.resetQueue();
        tree.preOrder(0);
        System.out.print("The tree elements - PREORDER :");
        tree.showTree();
        
        tree.resetQueue();
        tree.inOrder(0);
        System.out.print("\nThe tree elements - INORDER : ");
        tree.showTree();
        
        tree.resetQueue();
        tree.postOrder(0);
        System.out.print("\nThe tree elements - POSTORDER : ");
        tree.showTree();
        
    }
    
}
