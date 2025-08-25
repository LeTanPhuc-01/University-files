import java.util.*;

public class Prims {
    
    public void getMST(Graph g, String src) {
        // Step 1: Initialize data structures
        HashMap<String, Integer> d = new HashMap<>();  // Distance labels
        HashMap<String, String> parent = new HashMap<>();  // Parent nodes
        Set<String> visited = new HashSet<>();  // Visited nodes

        // Step 2: Initialize distance labels to infinity for all nodes except source
        for (String vertex : g.v) {
            d.put(vertex, Integer.MAX_VALUE);
            parent.put(vertex, "-1");  // Initialize parent to -1
        }
        d.put(src, 0);  // Source node has distance 0

        // Step 3: Build the priority queue based on distance labels
        PriorityQueue<String> pq = buildQueue(d);

        // Step 4: Prim's algorithm main loop
        while (!pq.isEmpty()) {
            // Extract the vertex with minimum distance
            String u = pq.poll();
            visited.add(u);

            // Process all adjacent vertices of u
            for (String v : g.adj.get(u)) {
                // Get the weight of edge u-v
                int weight;
                if (g.w.containsKey(u + "-" + v)) {
                    weight = g.w.get(u + "-" + v);
                } else {
                    weight = g.w.get(v + "-" + u);  // Handle undirected edge
                }

                // If v is not visited and weight is less than current distance
                if (!visited.contains(v) && weight < d.get(v)) {
                    // Update distance and parent
                    d.put(v, weight);
                    parent.put(v, u);
                    
                    // Update priority queue
                    pq.remove(v);  // Remove and re-add to update priority
                    pq.add(v);
                }
            }
        }

        // Step 5: Build and print the MST
        buildMST(parent, src);
    }

    // Helper method to build priority queue based on distance labels
    public static PriorityQueue<String> buildQueue(HashMap<String, Integer> d) {
        PriorityQueue<String> pQueue = new PriorityQueue<>(
                Comparator.comparingInt(d::get)
        );
        pQueue.addAll(d.keySet());
        return pQueue;
    }

    // Recursive method to build and print the MST
    private void buildMST(HashMap<String, String> parent, String node) {
        for (Map.Entry<String, String> entry : parent.entrySet()) {
            if (entry.getValue().equals(node) && !entry.getValue().equals("-1")) {
                System.out.println(node + " --> " + entry.getKey());
                buildMST(parent, entry.getKey());
            }
        }
    }
}

// Graph class already provided
class Graph {
    HashMap<String, ArrayList<String>> adj;
    Set<String> v = new HashSet<>();
    HashMap<String, Integer> w = new HashMap<>();
 
    public Graph(HashMap<String, ArrayList<String>> adj) {
        this.adj = adj;
    }
 
    public void addEdge(String u, String v, int w) {
        adj.get(u).add(v);
        adj.get(v).add(u);
        this.v.add(u);
        this.v.add(v);
        this.w.put(u+"-"+v, w);
    }
}

// Main class for testing
class Main {
    public static void main(String[] args) {
        int V = 4;
        HashMap<String, ArrayList<String>> adjList = new HashMap<>(V);
        for (int i = 1; i <= V; i++) {
            adjList.put("v"+i, new ArrayList<>());
        }
     
        Graph g = new Graph(adjList);
        g.addEdge("v1", "v2", 9);
        g.addEdge("v1", "v4", 3);
        g.addEdge("v1", "v3", 8);
        g.addEdge("v4", "v3", 7);
        g.addEdge("v3", "v2", 4);
     
        // Call Prims algorithm here
        Prims prims = new Prims();
        prims.getMST(g, "v1");
    }
}