import org.junit.Test;
import static org.junit.Assert.*;

/** A JUnit test class to test the class Graph. */
public class TestGraph {
    /** A JUnit test method to test addVertex(). */
    @Test
    public void testAddVertex() {
        Graph graph = new Graph();
        graph.addVertex("P");
        assertTrue("Graph has vertex P", graph.adjListArray.containsKey("P"));
    }
    
    /** A JUnit test method to test addEdge(). */
    @Test
    public void testAddEdge() {
        Graph graph = new Graph();
        graph.addEdge("P", "O", 200);
        assertTrue("Graph has vertex P", graph.adjListArray.containsKey("P"));
        assertTrue("Graph has vertex O", graph.adjListArray.containsKey("O"));
        assertTrue("Graph has edge weight from P to O, 200", graph.edgeWeights.get("P O") == 200);
    }
}