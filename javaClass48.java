import java.util.ArrayList;

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
    
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++) graph[i]=new ArrayList<>();
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
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
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // Bellman Ford Algorithm
        ArrayList<Edge>[] graph=new ArrayList[5];
        createGraph(graph);
        BellmanFordAlgoForShortestPath(graph, 0);
    }
}
