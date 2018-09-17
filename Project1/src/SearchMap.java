import java.io.*;
import java.util.*;

public class SearchMap {
    public class Graph
    {
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

        public void addVertex(String name)
        {
            adjListArray.put(name, new ArrayList<String>());
        }

        // Adds an edge to a directed graph
        public void addEdge(String src, String dest, int cost)
        {
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
        // A utility function to print the adjacency list 
        // representation of graph
        public void printGraph()
        {       
            // for(int v = 0; v < adjListArray.size(); v++)
            // {
            //     System.out.println("Adjacency list of vertex "+ v);
            //     System.out.print("head");
            //     for(Integer pCrawl: this.adjListArray[v]){
            //         System.out.print(" -> "+pCrawl);
            //     }
            //     System.out.println("\n");
            // }
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
    public static void main(String[] args) throws IOException{
        try
        {
            SearchMap obj = new SearchMap ();
            obj.run (args);
        }
        catch (Exception e)
        {
            e.printStackTrace ();
        }
    }

    public void run (String[] args) throws Exception
    {
        // put your code here
        System.out.println("Searching Map");

        Scanner sc = new Scanner(new File("inputfile.txt"));

        Graph graph = new Graph();

        String start = sc.next();

        while (sc.hasNextLine()) {
            String src = sc.next();
            String dest = sc.next();
            int cost = Integer.parseInt(sc.next());
            graph.addEdge(src, dest, cost);
        }

        graph.printGraph();
        graph.printCosts();
    }
}
