import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

/** A JUnit test class to test the class Graph. */
public class TestFlightMap {
    /** A JUnit test method to test getPath(). */
    @Test
    public void testGetPath() {
        Graph graph = new Graph();
        graph.addEdge("P", "O", 200);
        graph.addEdge("O", "X", 400);
        graph.addEdge("X", "Z", 600);
        FlightMap fm = new FlightMap();
        assertTrue("Checks if path is right", fm.getPath(graph, "P", "Z").equals("P,O,X,Z"));
    }

    /** A JUnit test method to test getCost(). */
    @Test
    public void testGetCost() {
        Graph graph = new Graph();
        graph.addEdge("P", "O", 200);
        graph.addEdge("O", "X", 400);
        graph.addEdge("X", "Z", 600);
        FlightMap fm = new FlightMap();
        assertTrue("Checks if path is right", fm.getCost(graph, "P", "Z").equals("$1200"));
    }
}