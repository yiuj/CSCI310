
import java.io.*;
import java.util.*;

/**
* Implementation of a directed weighted graph
*/
public class Graph {
    // adjacency list representing the graph
    HashMap<String, ArrayList<String> > adjListArray;
    // maps strings (two locations concatenated) to edge weights
    HashMap<String, Integer> edgeWeights;
        
    /**
    * Constructor for Graph
    */
    public Graph()
    {
        adjListArray = new HashMap<String, ArrayList<String> >();   
        edgeWeights = new HashMap<String, Integer>();
    }

    /**
    * Adds a new vertex to the graph
    *
    * @param    name    The name of the new vertex
    */
    public void addVertex(String name) {
        adjListArray.put(name, new ArrayList<String>());
    }

    /**
    * Adds a new vertex to the graph
    *
    * @param    src     The source destination of the directed edge
    * @param    dest    The final destination of the directed edge
    * @param    cost    The weight of the directed edge
    */
    public void addEdge(String src, String dest, int cost) {
        if(!adjListArray.containsKey(src)) {
            this.addVertex(src);
        }
        if(!adjListArray.containsKey(dest)) {
            this.addVertex(dest);
        }
        this.adjListArray.get(src).add(dest);
        this.edgeWeights.put(src + " " + dest, cost);
    }

    /**
    * Gets all adjacent locations to a given location
    *
    * @param    v       The vertex of which to find the adjacent vertices
    * 
    * @return   An ArrayList of vertices that v is adjacent to. If vertex does not exist, return null.
    */
    public ArrayList<String> adjacentTo(String v) {
        if(adjListArray.containsKey(v)) {
            return adjListArray.get(v);
        }
        return null;
    }

    // /**
    // * Utility method to print the graph represented as an adjacency list
    // */
    // public void printGraph()
    // {       
    //     for (String name: adjListArray.keySet()){
    //         System.out.print(name);
    //         System.out.print(" ---> ");
    //         for(int i=0; i<adjListArray.get(name).size(); i++) {
    //             System.out.print(adjListArray.get(name).get(i) + " ");
    //         }
    //         System.out.println("");  
    //     } 
    // }

    // /**
    // * Utility method to print the edge weights / costs
    // */
    // public void printCosts()
    // {
    //     for (String name: edgeWeights.keySet()){
    //         System.out.print(name);
    //         System.out.print(" ---> ");
    //         System.out.print(edgeWeights.get(name));
    //         System.out.println("");  
    //     } 
    // }
}