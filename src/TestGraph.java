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

    /** A JUnit test method to test adjacentTo(). */
    @Test
    public void testAdjacentTo() {
        Graph graph = new Graph();
        graph.addEdge("P", "O", 200);
        graph.addEdge("P", "X", 300);
        graph.addEdge("O", "X", 400);
        assertTrue("P had 2 adjacent locations", graph.adjacentTo("P").size() == 2);
        assertTrue("O had 1 adjacent locations", graph.adjacentTo("O").size() == 1);
        assertTrue("X had 0 adjacent locations", graph.adjacentTo("X").size() == 0);
    }
}