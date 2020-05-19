/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dslab10;

/**
 *
 * @author Windows 10
 */
public class Edge {
    private Vertex source;
    private Vertex dest;
    private double weight;
    
    public Edge(Vertex source, Vertex dest, double weight){
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
    public Vertex getDest(){
        return dest;
    }
    public double getWeight(){
        return weight;
    }
    
}
