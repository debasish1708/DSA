import java.util.ArrayList;
import java.util.PriorityQueue;

public class javaClass48 {

    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    static class Pair{
        int vertex;
        int cost;
        public Pair(int vertex,int cost){
            this.vertex=vertex;
            this.cost=cost;
        }
    }
    
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++) graph[i]=new ArrayList<>();
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    public static void createGraph1(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++) graph[i]=new ArrayList<>();
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 2, 50));

    }

    // Bellman Ford Algorithm ...
    public static void BellmanFordAlgoForShortestPath(ArrayList<Edge>[] graph,int src){
        int dist[]=new int[graph.length];
        for(int i=0;i<dist.length;i++) dist[i]=Integer.MAX_VALUE;
        dist[src]=0;

        // O(V)
        for(int i=0;i<graph.length-1;i++){
            // O(E)
            for(int j=0;j<graph.length;j++){
                for(Edge e:graph[j]){
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if(dist[u]!=Integer.MAX_VALUE&&dist[u]+wt<dist[v]){
                        dist[v]=dist[u]+wt;
                    }
                }
            }
        }

        // check for negative weight cycle
        for(int j=0;j<graph.length;j++){
            for(Edge e:graph[j]){
                int u=e.src;
                int v=e.dest;
                int wt=e.wt;
                if(dist[u]!=Integer.MAX_VALUE&&dist[u]+wt<dist[v]){
                    System.out.println("The graph have negative weights");
                    return;
                }
            }
        }

        for(int i:dist) System.out.print(i+" ");
    }

    // prims algo O(ELogE)
    public static void primsAlgo(ArrayList<Edge>[] graph){
        boolean[] vis=new boolean[graph.length];
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new Pair(0, 0));
        int cost=0;
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!vis[curr.vertex]){
                vis[curr.vertex]=true;
                cost+=curr.cost;
                for(Edge e:graph[curr.vertex])
                    pq.add(new Pair(e.dest, e.wt));
            }
        }

        System.out.println("minimu spanning tree cost: "+cost);
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // Bellman Ford Algorithm
        ArrayList<Edge>[] graph=new ArrayList[5];
        createGraph(graph);
        BellmanFordAlgoForShortestPath(graph, 0);
        System.out.println();

        ArrayList<Edge>[] graph1=new ArrayList[4];
        createGraph1(graph1);
        // prims algorithm for Minimum Spanning Tree cost
        primsAlgo(graph1);
    }
}
