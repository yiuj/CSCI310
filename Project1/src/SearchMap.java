import java.io.*;
import java.util.LinkedList;

public class SearchMap {
    public class Graph
    {
        int V;
        LinkedList<Integer> adjListArray[];
            
        // constructor 
        public Graph(int V)
        {
            this.V = V;
                
            // define the size of array as 
            // number of vertices
            adjListArray = new LinkedList[V];
                
            // Create a new list for each vertex
            // such that adjacent nodes can be stored
            for(int i = 0; i < V ; i++){
                adjListArray[i] = new LinkedList<>();
            }
        }
        // Adds an edge to an undirected graph
        public void addEdge(int src, int dest)
        {
            // Add an edge from src to dest. 
            this.adjListArray[src].addFirst(dest);
                
            // Since graph is undirected, add an edge from dest
            // to src also
            this.adjListArray[dest].addFirst(src);
        }
        // A utility function to print the adjacency list 
        // representation of graph
        public void printGraph()
        {       
            for(int v = 0; v < this.V; v++)
            {
                System.out.println("Adjacency list of vertex "+ v);
                System.out.print("head");
                for(Integer pCrawl: this.adjListArray[v]){
                    System.out.print(" -> "+pCrawl);
                }
                System.out.println("\n");
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

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("inputfile.txt");
            //out = new FileOutputStream("output.txt");
            int i;
            char c;
            // while((i = in.read()) != -1) {
            //     // converts integer to character
            //     c = (char)i; 
            //     // prints character
            //     System.out.print(c);
            // }
        } finally {
            if (in != null) {
                in.close();
            }
        }

        int V = 5;
        Graph graph = new Graph(V);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
      
        // print the adjacency list representation of 
        // the above graph
        graph.printGraph();
    }
}
