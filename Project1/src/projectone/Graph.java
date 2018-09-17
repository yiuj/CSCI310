
import java.io.*;
import java.util.*;

public class Graph {
    HashMap<String, ArrayList<String> > adjListArray;
    HashMap<String, Integer> edgeWeights;
        
    // constructor 
    public Graph()
    {
            
        // define the size of array as 
        // number of vertices
        adjListArray = new HashMap<String, ArrayList<String> >();
        
        edgeWeights = new HashMap<String, Integer>();
        // Create a new list for each vertex
        // such that adjacent nodes can be stored
        // for(int i = 0; i < V ; i++){
        //     adjListArray[i] = new LinkedList<>();
        // }
    }

    public void addVertex(String name) {
        adjListArray.put(name, new ArrayList<String>());
    }

    // Adds an edge to a directed graph
    public void addEdge(String src, String dest, int cost) {
        if(!adjListArray.containsKey(src)) {
            this.addVertex(src);
        }
        if(!adjListArray.containsKey(dest)) {
            this.addVertex(dest);
        }
        // Add an edge from src to dest. 
        this.adjListArray.get(src).add(dest);
        this.edgeWeights.put(src + " " + dest, cost);
    }

    public ArrayList<String> adjacentTo(String v) {
        if(adjListArray.containsKey(v)) {
            return adjListArray.get(v);
        }
        return null;
    }

    // A utility function to print the adjacency list 
    // representation of graph
    public void printGraph()
    {       
        for (String name: adjListArray.keySet()){
            System.out.print(name);
            System.out.print(" ---> ");
            for(int i=0; i<adjListArray.get(name).size(); i++) {
                System.out.print(adjListArray.get(name).get(i) + " ");
            }
            System.out.println("");  
        } 
    }

    public void printCosts()
    {
        for (String name: edgeWeights.keySet()){
            System.out.print(name);
            System.out.print(" ---> ");
            System.out.print(edgeWeights.get(name));
            System.out.println("");  
        } 
    }
}