import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class javaClass49 {
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
    static class Info{
        int vertex;
        int cost;
        int stops;
        public Info(int vertex,int cost,int stops){
            this.vertex=vertex;
            this.cost=cost;
            this.stops=stops;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++) graph[i]=new ArrayList<>();
        graph[0].add(new Edge(0, 1, 100));
        graph[1].add(new Edge(1, 3, 600));
        graph[1].add(new Edge(1, 2, 100));
        graph[2].add(new Edge(2, 0, 100));
        graph[2].add(new Edge(2, 3, 200));
    }
    public static int cheapestFlight(ArrayList<Edge>[] graph,int src,int dst,int k){
        int[] dist=new int[graph.length];
        for(int i=0;i<dist.length;i++) dist[i]=Integer.MAX_VALUE;
        dist[src]=0;
        Queue<Info> q=new LinkedList<>();
        q.add(new Info(src, 0, 0));
        while(!q.isEmpty()){
            Info curr=q.remove();
            if(curr.stops>k) break;
            for(Edge e:graph[curr.vertex]){
                int u=e.src;
                int v=e.dest;
                int wt=e.wt;
                if(dist[u]!=Integer.MAX_VALUE&&curr.cost+wt<dist[v]&&curr.stops<=k){
                    dist[v]=curr.cost+wt;
                    q.add(new Info(v, dist[v], curr.stops+1));
                }
            }
        }

        return dist[dst]!=Integer.MAX_VALUE?dist[dst]:-1;
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // cheapest flights with in k stops
         ArrayList<Edge>[] graph=new ArrayList[4];
         createGraph(graph);
         int ans=cheapestFlight(graph,0,3,1);
         System.out.println("cheapest cost of flight in k stops: "+ans);
    }
}
