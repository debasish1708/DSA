import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    // impleMent Kruskal's algorithm using disjoint set
    static class Edge{
        int src,dest,wt;
        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    static void createGraph(List<Edge> edges){
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }
    static int n = 4; //vertices
    static int[] par=new int[n];
    static int[] rank=new int[n];

    private static void init(){
        for(int i=0;i<n;i++) par[i]=i;
    }

    // find - recurstion & compression O(1)
    private static int find(int x){
        if(x==par[x]) return x;
        return par[x]=find(par[x]);
    }

    // union - O(1)
    private static void union(int a,int b){
        int parA = find(a);
        int parB = find(b);
        if(rank[parA]==rank[parB]){
            par[parB]=parA;
            rank[parA]++;
        } else if(rank[parA]<rank[parB]){
            par[parA]=parB;
        } else {
            par[parB]=parA;
        }
    }

    private static int kruskalAlgorithm(List<Edge> edges,int V) {
        // sort edges based on weight
        edges.sort((a, b) -> a.wt - b.wt); // O(E log E)
        int mstCost=0,count=0;
        for(int i=0;count<V-1;i++){ // O(V)
            Edge e=edges.get(i);
            int parA= find(e.src);
            int parB= find(e.dest);
            if(parA==parB) continue; // cycle
            union(e.src, e.dest);
            mstCost+=e.wt;
            count++;
        }
        return mstCost;
    }
    public static void main(String[] args) {
        init();
        // System.out.println(find(3));
        // union(1,3);
        // System.out.println(find(3));
        // union(2,4);
        // union(3,6);
        // union(1, 4);
        // System.out.println(find(3));
        // System.out.println(find(4));
        // union(1,5);
        // System.out.println(rank[1]);
        // System.out.println();
        System.out.println("Minimum Spanning Tree Cost: ");
        int V=4;
        List<Edge> edges = new ArrayList<>();
        createGraph(edges);
        System.out.println(kruskalAlgorithm(edges, V));
    }
}
