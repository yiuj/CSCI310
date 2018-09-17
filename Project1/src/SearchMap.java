import java.io.*;
import java.util.*;

public class SearchMap {
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

    public class PathFinder {

        // prev[v] = previous vertex on shortest path from s to v
        // dist[v] = length of shortest path from s to v
        private HashMap<String, String>  prev = new HashMap<String, String>();
        private HashMap<String, Integer> dist = new HashMap<String, Integer>();

        // run BFS in graph G from given source vertex s
        public PathFinder(Graph G, String s) {

            // put source on the queue
            Queue<String> queue = new LinkedList<String>();
            queue.add(s);
            dist.put(s, 0);
            
            // repeated remove next vertex v from queue and insert
            // all its neighbors, provided they haven't yet been visited
            while (!queue.isEmpty()) {
                String v = queue.poll();
                for (String w : G.adjacentTo(v)) {
                    if (!dist.containsKey(w)) {
                        queue.add(w);
                        dist.put(w, 1 + dist.get(v));
                        prev.put(w, v);
                    }
                }
            }
        }

        // is v reachable from the source s?
        public boolean hasPathTo(String v) {
            return dist.containsKey(v);
        }

        // return the length of the shortest path from v to s
        public int distanceTo(String v) {
            if (!hasPathTo(v)) return Integer.MAX_VALUE;
            return dist.get(v);
        }

        // return the shortest path from v to s as an Iterable
        public ArrayList<String> pathTo(String v) {
            ArrayList<String> path = new ArrayList<String>();
            while (v != null && dist.containsKey(v)) {
                path.add(v);
                v = prev.get(v);
            }
            return path;
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

        // graph.printGraph();
        // graph.printCosts();

        System.out.println("Testing SearchMap...");
        
        //OUTPUT
        PrintWriter writer = new PrintWriter("outputfile.txt", "UTF-8");
        writer.printf("%-15s%15s%15s\n", "Destination", "Flight Route from " + start, "Total Cost");
        for (String dest: graph.adjListArray.keySet()){
            String cost = getCost(graph, start, dest);
            if(!cost.equals("$0")) {
                writer.print(dest + "\t\t\t\t");
                writer.printf("%-13s\t\t\t", getPath(graph, start, dest));
                writer.printf("%-20s\n", cost);
                // writer.print( + "\t\t");
                // writer.print(cost + "\n");
            }
        } 
        writer.close();
    }

    public String getPath(Graph graph, String src, String dest) {
        String pathString = src;

        PathFinder pf = new PathFinder(graph, src);
        ArrayList<String> pth = pf.pathTo(dest);

        int cost = 0;
        String last = src;
        for (int i=pth.size()-2; i>=0; i--) {
            pathString += "," + pth.get(i);
            // System.out.print("   " + pth.get(i));
            cost += graph.edgeWeights.get(last + " " + pth.get(i));
            last = pth.get(i);
        }
        return pathString;
    }
    public String getCost(Graph graph, String src, String dest) {
        PathFinder pf = new PathFinder(graph, src);
        
        ArrayList<String> pth = pf.pathTo(dest);

        int cost = 0;
        String last = src;
        for (int i=pth.size()-2; i>=0; i--) {
            // System.out.print("   " + pth.get(i));
            cost += graph.edgeWeights.get(last + " " + pth.get(i));
            last = pth.get(i);
        }
        return "$" + Integer.toString(cost);
    }
}
