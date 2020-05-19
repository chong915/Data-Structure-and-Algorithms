/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dstutorial10;

import java.util.ArrayList;

/**
 *
 * @author Windows 10
 */
public class DSTutorial10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Creating a graph with 7 vertices and 7 edges");
        Graph graph = new Graph(7);
        graph.addEdge('A', 'B', 0.4);
        graph.addEdge('A', 'C', 0.3);
        graph.addEdge('B', 'C', 0.1);
        graph.addEdge('B', 'D', 0.2);
        graph.addEdge('B', 'E', 0.7);
        graph.addEdge('C', 'F', 0.3);
        graph.addEdge('F', 'G', 0.4);
        
        graph.printGraph();
        System.out.println();
        graph.printAdjacentList();
        System.out.println("Removing edge from B to C");
        graph.removeEdge('B', 'C');
        graph.printGraph();
        System.out.print("Weightage from C to F : ");
        System.out.println(graph.getWeight('C', 'F'));
        System.out.print("The adjacent of B : ");
        ArrayList<Character> adjacent = graph.getAdjacent('B');
        for(Character temp : adjacent)
            System.out.print(temp + " ");
        System.out.println();
    }
    
}
