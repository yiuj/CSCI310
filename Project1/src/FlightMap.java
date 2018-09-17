
import java.io.*;
import java.util.*;

/**
* FlightMap has two functions that can get a path between two destations and find the cost of that trip
*/
public class FlightMap {

    /**
    * Gets the path from a source to a destination in a given graph
    *
    * @param    graph   The given graph in which to find the path
    * @param    src     The beginning location
    * @param    dest    The final location
    *
    * @return   A formatted string listing the locations in the path from src to dest 
    */
    public String getPath(Graph graph, String src, String dest) {
        String pathString = src;

        FlightPathFinder pf = new FlightPathFinder(graph, src);
        ArrayList<String> pth = pf.pathTo(dest);

        int cost = 0;
        String last = src;
        for (int i=pth.size()-2; i>=0; i--) {
            pathString += "," + pth.get(i);
            cost += graph.edgeWeights.get(last + " " + pth.get(i));
            last = pth.get(i);
        }
        return pathString;
    }

    /**
    * Gets the cost of traveling from a source to a destination in a given graph
    *
    * @param    graph   The given graph in which to find the path
    * @param    src     The beginning location
    * @param    dest    The final location
    *
    * @return   A formatted string showing the cost of the flight path
    */
    public String getCost(Graph graph, String src, String dest) {
        FlightPathFinder pf = new FlightPathFinder(graph, src);
        
        ArrayList<String> pth = pf.pathTo(dest);

        int cost = 0;
        String last = src;
        for (int i=pth.size()-2; i>=0; i--) {
            cost += graph.edgeWeights.get(last + " " + pth.get(i));
            last = pth.get(i);
        }
        return "$" + Integer.toString(cost);
    }
}
