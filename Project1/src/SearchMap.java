
import java.io.*;
import java.util.*;

/**
* SearchMap reads an input file flight paths and outputs the paths to each destination from the source
*/
public class SearchMap {
    /**
    * The main method is what runs when running "java SearchMap <inputfile> <outputfile>"
    *
    * @param args   This array of Strings contains the arguments for SearchMap.
    *               For it to run properly, there must be two arguments, <inputfile> and <outputfile>.
    */
    public static void main(String[] args) throws IOException{
        if(args.length==2) {
            FlightMap f = new FlightMap();
            String inputfile = args[0];
            String outputfile = args[1];

            Scanner sc = new Scanner(new File(inputfile));

            Graph graph = new Graph();

            String start = sc.next();

            // Creating graph
            while (sc.hasNextLine()) {
                String src = sc.next();
                String dest = sc.next();
                int cost = Integer.parseInt(sc.next());
                graph.addEdge(src, dest, cost);
            }
            writeToOutput(graph, start, f, outputfile);
            
        } 
        else {
            System.out.println("Incorrect input: call java SearchMap <inputfile> <outputfile>");
        }
    }

    /**
    * This method prints the required format of flight paths to a given or new output file. 
    *
    * @param graph      The graph that represents the flight paths from location to location
    * @param start      The string that represents the starting point of the graph
    * @param f          The FlightMap object that can find paths and costs
    * @param outputfile The string that represents the given or new output file
    */
    public static boolean writeToOutput(Graph graph, String start, FlightMap f, String outputfile) {
        // OUTPUT
        try {
            PrintWriter writer = new PrintWriter(outputfile, "UTF-8");
            writer.printf("%-15s%15s%15s\n", "Destination", "Flight Route from " + start, "Total Cost");
            for (String dest: graph.adjListArray.keySet()){
                String cost = f.getCost(graph, start, dest);
                if(!cost.equals("$0")) {
                    writer.print(dest + "\t\t\t\t");
                    writer.printf("%-13s\t\t\t", f.getPath(graph, start, dest));
                    writer.printf("%-20s\n", cost);
                }
            } 
            writer.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
