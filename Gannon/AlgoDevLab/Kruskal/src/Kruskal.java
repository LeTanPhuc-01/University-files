import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
public class Kruskal {
    public static void main(String[] args){
        int vertices = 5;
        int [] p = new int[vertices];
        //initialize parent array
        Arrays.fill(p, -1);
        ArrayList<Edge> edges = new ArrayList<>();
        ArrayList<Edge> mst = new ArrayList<>();
        createGraph(edges);
        sortGraph(edges);

        for(Edge e: edges){
            int u = e.getSrc();
            int v = e.getDest();
            if(compressedFind(u, p) != compressedFind(v, p)){
                mst.add(e);
                weightedUnion(u, v, p);
            }
        }
        for(Edge e: mst) 
        {
            System.out.println(e);
        }
    }
    public static void createGraph(ArrayList<Edge> edges){
        edges.add(new Edge(1, 2, 9));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, 3));
        edges.add(new Edge(4, 3, 7));
        edges.add(new Edge(3, 2, 4));
    }
    public static void sortGraph(ArrayList<Edge> edges){
        edges.sort(Comparator.comparingInt(edge -> edge.weight));
    }

    public static void weightedUnion(int u, int v, int[] p){
        int rootU = compressedFind(u, p);
        int rootV = compressedFind(v, p);
        
        if (rootU != rootV) {
            if (Math.abs(p[rootU]) > Math.abs(p[rootV])) {
                p[rootU] += p[rootV];
                p[rootV] = rootU;
            } else {
                p[rootV] += p[rootU];
                p[rootU] = rootV;
            }
        }
    }
    public static int compressedFind(int u, int[] p){
        if(p[u] < 0)
            return u;
        p[u] = compressedFind(p[u], p);
        return p[u];
    }
}
