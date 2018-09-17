import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

/** A JUnit test class to test the class Graph. */
public class TestFlightPathFinder {
    /** A JUnit test method to test addVertex(). */
    @Test
    public void testPathTo() {
        Graph graph = new Graph();
        graph.addEdge("P", "O", 200);
        graph.addEdge("O", "X", 400);
        graph.addEdge("X", "Z", 600);
        FlightPathFinder fpf = new FlightPathFinder(graph, "P");
        ArrayList<String> path = fpf.pathTo("Z");
        assertTrue("Path at [3] is P", path.get(3).equals("P"));
        assertTrue("Path at [2] is O", path.get(2).equals("O"));
        assertTrue("Path at [1] is X", path.get(1).equals("X"));
        assertTrue("Path at [0] is Z", path.get(0).equals("Z"));
    }
}