
import java.io.*;
import java.util.*;

public class SearchMap {
    public static void main(String[] args) throws IOException{
        if(args.length==2) {
            FlightMap f = new FlightMap();
            String inputfile = args[0];
            String outputfile = args[1];
            // put your code here
            // System.out.println("Searching Map");

            Scanner sc = new Scanner(new File(inputfile));

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

            // System.out.println("Testing SearchMap...");
            
            //OUTPUT
            PrintWriter writer = new PrintWriter(outputfile, "UTF-8");
            writer.printf("%-15s%15s%15s\n", "Destination", "Flight Route from " + start, "Total Cost");
            for (String dest: graph.adjListArray.keySet()){
                String cost = f.getCost(graph, start, dest);
                if(!cost.equals("$0")) {
                    writer.print(dest + "\t\t\t\t");
                    writer.printf("%-13s\t\t\t", f.getPath(graph, start, dest));
                    writer.printf("%-20s\n", cost);
                    // writer.print( + "\t\t");
                    // writer.print(cost + "\n");
                }
            } 
            writer.close();
            System.out.println("Success");
            // f.run(args);
            // SearchMap obj = new SearchMap ();
            // obj.run (args);
        } 
        else {
            System.out.println("Incorrect input: call java SearchMap <inputfile> <outputfile>");
        }
    }
}
