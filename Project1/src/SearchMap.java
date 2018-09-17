
import java.io.*;
import java.util.*;

/**
* SearchMap reads an input file flight paths and outputs the paths to each destination from the source
*/
public class SearchMap {
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
            
            // OUTPUT
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
        } 
        else {
            System.out.println("Incorrect input: call java SearchMap <inputfile> <outputfile>");
        }
    }
}
