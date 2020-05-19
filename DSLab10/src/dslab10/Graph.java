/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Windows 10
 */
public class Graph<V> {
    private Map<Vertex<V>, List<Edge>> map;
    
    public Graph(){
        map = new LinkedHashMap<>();
    }
    
    public void showGraph(){
        for(Map.Entry<Vertex<V>, List<Edge>> entry : map.entrySet()){
            System.out.println(entry.getKey().getVertex() + " -->");
            List<Edge> list = entry.getValue();
            System.out.print(" -> ");
            for(Edge edge : list){
                V label = (V) edge.getDest().getVertex();
                double weight = edge.getWeight();
                System.out.print(label + " : " + weight + " -> ");
            }
            System.out.println();
        }
    }
    
    public void addVertex(V v){
        Vertex v1 = new Vertex(v);
        List<Edge>list = new ArrayList<>();
        map.putIfAbsent(v1, list);
    }
    
    public void removeVertex(V v){
        Vertex vertex = new Vertex(v);
        map.remove(vertex);
    }
    public void addEdge(V v1, V v2,double weight){
        Vertex vertex1 = new Vertex(v1);
        Vertex vertex2 = new Vertex(v2);
        Edge edge = new Edge(vertex1, vertex2, weight);
        //Remember to override hashCode and equals method in Vertex because we 
        //need to compare vertex1 that we just created by value not by reference
        //since the reference is different between this vertex and the vertex in
        //the map.keys()
        List<Edge>temp = map.get(vertex1);
        temp.add(edge);
    }
    public void removeEdge(V v1, V v2){
        Vertex source = new Vertex(v1);
        Vertex dest = new Vertex(v2);
        List<Edge> listV1 = map.get(source);
        if(listV1 != null){
            for(Edge temp : listV1){
                if(temp.getDest() == dest)
                    listV1.remove(temp);
            }
        }
    }
    
    public boolean hasEdge(V v1, V v2){
        if(v1 == null || v2 == null)
            return false;
        Vertex source = new Vertex(v1);
        Vertex dest = new Vertex(v2);
        List<Edge> list = map.get(source);
        for(Edge edge : list){
            if(edge.getDest() == dest)
                return true;
        }
        return false;
    }
    
    public double getWeightage(V source, V dest){
        for(Map.Entry<Vertex<V>, List<Edge>> entry : map.entrySet()){
            if(entry.getKey().getVertex() == source){
                List<Edge> list = entry.getValue();
                for(Edge edge : list){
                    V to = (V) edge.getDest().getVertex();
                    if(to == dest)
                        return edge.getWeight();
                }
            }
        }
        return -1;
    }
    
    public List<Edge> getAdjacent(V v){
        return map.get(new Vertex(v));
    }
    
    public Set<V> depthFirstTraversal(Graph<V> graph,V root){
        Set<V> visited = new LinkedHashSet<>();
        Stack<V> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            V vertex = stack.pop();
            if(!visited.contains(vertex)){
                visited.add(vertex);
                for(Edge edge : graph.getAdjacent((V) vertex)){
                    stack.push((V) edge.getDest().getVertex());
                }
            }
        }
        return visited;
    }
    
    public Set<V> breadthFirstTraversal(Graph<V> graph, V root){
        Set<V> visited = new LinkedHashSet<>();
        Queue<V> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);
        while(!queue.isEmpty()){
            V vertex = queue.poll();
            for(Edge edge : graph.getAdjacent(vertex)){
                if(!visited.contains(edge.getDest().getVertex())){
                    visited.add((V) edge.getDest().getVertex());
                    queue.add((V) edge.getDest().getVertex());
                }
            }
        }
        return visited;
    }
    
    public static final int BFS = 1, DFS = 0;
    public List shortestPath(Graph<V> graph, V source, V dest, int choice, boolean print){
        if(choice == DFS)
            return DFS(graph, source, dest, new ArrayList<>(), null, print);
        else if(choice == BFS)
            return BFS(graph, source, dest, true);
        return null;
    }
    
    public ArrayList DFS(Graph<V> graph, V source, V dest, ArrayList<V>path, ArrayList<V>shortest, boolean print){
        ArrayList<V> copyPath = new ArrayList<>(path);
        copyPath.add(source);
        if(print)
            System.out.println("Current DFS path : " + copyPath.toString() );
        if(source == dest)
            return copyPath;
        for(Edge edge : graph.getAdjacent(source)){
            V node = (V) edge.getDest().getVertex();
            if(!path.contains(node)){
                if(shortest == null || path.size() < shortest.size()){
                    ArrayList<V>newPath = DFS(graph, node, dest, copyPath, shortest, print);
                    if(newPath != null){
                        shortest = newPath;
                    }
                }
            }
            else{
                if(print)
                    System.out.println("Already visited " + node.toString());
            }
        }
        return shortest;
    }
    
    public ArrayList Weighted_ShortestPath(Graph graph, V source, V dest, boolean print){
        ArrayList<V> temp = DFS_ByCost(graph, null, source, dest, 0, new ArrayList<>(), null, print);
        System.out.printf("Best Cost : %.2f\n",bestCost);
        return temp;
    }
    
    double bestCost = Double.MAX_VALUE;
    double cost = 0;
    public ArrayList DFS_ByCost(Graph<V> graph,V previous, V source, V dest, double currentCost, ArrayList<V>path, ArrayList<V>shortest, boolean print){
        ArrayList<V> copyPath = new ArrayList<>(path);
        copyPath.add(source);
        
        if(previous != null)
            cost += getWeightage(previous, source);
        currentCost = cost;
        if(print)
            System.out.println("Current DFS path : " + copyPath.toString() );
        System.out.println("Current cost = " + currentCost);
        if(source == dest){
            System.out.println("Reached destination, cost = " + cost);
            if(cost < bestCost){
                bestCost = cost;
            }
            return copyPath;
        }
        for(Edge edge : graph.getAdjacent(source)){
            V node = (V) edge.getDest().getVertex();
            if(!path.contains(node)){
                if(shortest == null || currentCost < bestCost){
                    ArrayList<V>newPath = DFS_ByCost(graph, source, node, dest, currentCost, copyPath, shortest, print);
                    
                    if(newPath != null && cost <= bestCost){
                        shortest = newPath;
                      }
                    cost = currentCost;
                }
            }
            else{
                if(print)
                    System.out.println("Already visited " + node.toString());
            }
        }
        //System.out.printf("DFS by cost -> Total Cost : %.2f\n", bestCost);
        return shortest;
    }
    
    
    public List BFS(Graph<V> graph, V start, V end, boolean print){
        List<V> initPath = new LinkedList<>();
        initPath.add(start);
        Queue<List<V>>pathQueue = new LinkedList<>();
        pathQueue.add(initPath);
        while(pathQueue.size() != 0){
            List<V> tempPath = pathQueue.remove();
            if(print)
                System.out.println("Current BFS path : " + tempPath.toString());
            V lastNode = tempPath.get(tempPath.size()-1);
            if (lastNode == end)
                return tempPath;
            for(Edge edge : graph.getAdjacent(lastNode)){
                V nextNode = (V) edge.getDest().getVertex();
                if(!tempPath.contains(nextNode)){
                    List<V>temp = new LinkedList<>(tempPath);
                    temp.add(nextNode);
                    pathQueue.add(temp);
                }
            }
        }
        return null;
    }
    
    
}
