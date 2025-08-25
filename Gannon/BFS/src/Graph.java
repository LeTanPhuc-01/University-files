import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
public class Graph {
    int vertices;
    LinkedList<Integer>[] adjList;
    @SuppressWarnings("unchecked")
    public Graph(int vertices){
        this.vertices = vertices;
        adjList = new LinkedList[this.vertices];
        for (int i = 0; i < vertices; ++i){
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v){
        adjList[u].add(v);
    }
    // void bfs(int startNode){
    //     int currNode;
    //     Queue<Integer> queue = new LinkedList<>();
    //     boolean[] visited = new boolean[this.vertices];
    //     // curr node = visited, then enqueue its children
    //     visited[startNode] = true;
    //     // start to explor children of currNode ADD THE START NODE BEFORE ENTERING THE LOOP
    //     queue.add(startNode);
    //     System.out.println("bFS: ");
    //     while(!queue.isEmpty()){
    //         currNode = queue.poll();
            
    //         System.out.println("Visited node: " + currNode);
    //         // explore its children and enqueue
    //         for(int neighbor : adjList[currNode]){
    //             if(!visited[neighbor]){
    //                 visited[neighbor] = true;
    //                 queue.add(neighbor);
    //             }
    //         }

    //     }
    // }
    void bfs(int startNode){
        System.out.println("BFS: ");
        int currNode;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[this.vertices];
        queue.add(startNode);
        visited[startNode] = true;
        while(!queue.isEmpty()){
            currNode = queue.poll();
            System.out.println("Visited: " + currNode);
            for(int neighbor : adjList[currNode]){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
    
    void dfs(int startNode){
        System.out.println("DFS: ");
        int currNode;
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[this.vertices];
        stack.push(startNode);
        visited[startNode] = true;
        while(!stack.isEmpty()){
            currNode = stack.pop();
            System.out.println("Visited: " + currNode);
            List<Integer> neighbors = adjList[currNode];
            // put the "first" node in first
            for(int i = neighbors.size() -1; i>=0; i--){
                int neighbor = neighbors.get(i);
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }

        }
    }
}

