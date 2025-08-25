public class Edge {
    int src, dest, weight;
    public Edge(int src, int dest, int weight){
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    public int getSrc(){
        return src;
    }
    public int getDest(){
        return dest;
    }
    public String toString(){
        return "(" + src + "," + dest + ")" + "Weight: " + weight;
    }
    

}
