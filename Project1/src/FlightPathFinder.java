import java.io.*;
import java.util.*;

/**
* Helps find paths from a starting location to the final location
*/
public class FlightPathFinder {
    private HashMap<String, String>  prev = new HashMap<String, String>();
    private HashMap<String, Integer> dist = new HashMap<String, Integer>();

    /**
    * Constructor for the FlightPathFinder
    *
    * @param    graph    The given graph in which to find the path
    * @param    src      The beginning location
    */
    public FlightPathFinder(Graph graph, String src) {

        
        Queue<String> queue = new LinkedList<String>();
        queue.add(src);
        dist.put(src, 0);
        
        // Running BFS on the graph
        while (!queue.isEmpty()) {
            String v = queue.poll();
            for (String w : graph.adjacentTo(v)) {
                if (!dist.containsKey(w)) {
                    queue.add(w);
                    dist.put(w, 1 + dist.get(v));
                    prev.put(w, v);
                }
            }
        }
    }

    /**
    * Gets a list of locations from the starting location to the given location
    *
    * @param    dest    The final location of the path
    *
    * @return   An ArrayList of strings that represents the path from the start location to the
    *           final destination 
    */
    public ArrayList<String> pathTo(String dest) {
        ArrayList<String> path = new ArrayList<String>();
        while (dest != null && dist.containsKey(dest)) {
            path.add(dest);
            dest = prev.get(dest);
        }
        return path;
    }
}