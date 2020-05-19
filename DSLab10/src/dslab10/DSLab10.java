/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab10;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Windows 10
 */
public class DSLab10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Q1
        Graph<Character> graph = new Graph();
        for(char i = 'A';i<='G';i++)
            graph.addVertex(i);
        graph.addEdge('A', 'B', 1);
        graph.addEdge('A', 'C', 1);
        graph.addEdge('B', 'D', 1);
        graph.addEdge('B', 'E', 1);
        graph.addEdge('C', 'F', 1);
        graph.addEdge('F', 'G', 1);
        
        graph.showGraph();
        System.out.println("Depth First Traversal : ");
        Set depth = graph.depthFirstTraversal(graph, 'A');
        System.out.println(depth.toString());
        System.out.println("Breath First Traversal : ");
        Set breadth = graph.breadthFirstTraversal(graph, 'A');
        System.out.println(breadth.toString());
        */
        //Q2
        Graph<Character>graph = new Graph<>();
        System.out.println("Creating a graph with 8 vertices and 10 edges");
        for(char i='A';i<='H';i++)
            graph.addVertex(i);
        graph.addEdge('A', 'B', 0.4);
        graph.addEdge('A', 'C', 0.7);
        graph.addEdge('A', 'G', 0.8);
        graph.addEdge('B', 'C', 0.1);
        graph.addEdge('B', 'D', 0.2);
        graph.addEdge('B', 'E', 0.7);
        graph.addEdge('C', 'F', 0.3);
        graph.addEdge('E', 'H', 0.5);
        graph.addEdge('F', 'H', 0.4);
        graph.addEdge('G', 'H', 0.8);
        
        graph.showGraph();
        System.out.println("\nUnweighted Shortest Path from A to H Using DFS");
        List<Character> DFS_Path = graph.shortestPath(graph, 'A', 'H',Graph.DFS, true);
        System.out.println(DFS_Path.toString());
        
        System.out.println("\nUnweighted Shortest Path from A to H Using BFS");
        List<Character> BFS_Path = graph.shortestPath(graph, 'A', 'H', Graph.BFS, true);
        System.out.println(BFS_Path.toString());
        
        System.out.println("\nWeighted Shortest Path from A to H ");
        List<Character> DFS_ByCost = graph.Weighted_ShortestPath(graph, 'A', 'H', true);
        System.out.println(DFS_ByCost.toString());
    }
    
}
