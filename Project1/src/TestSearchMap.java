import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

/** A JUnit test class to test the class Graph. */
public class TestSearchMap {
    /** A JUnit test method to test writeToOutput(). */
    @Test
    public void testWriteToOutput() {
        Graph graph = new Graph();
        graph.addEdge("P", "O", 200);
        graph.addEdge("O", "X", 400);
        graph.addEdge("X", "Z", 600);
        FlightMap fm = new FlightMap();
        SearchMap sm = new SearchMap();
        assertTrue("Checks if file successfully written to", sm.writeToOutput(graph, "P", fm, "out.txt"));
    }
}