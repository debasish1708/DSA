
// javaClass47

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstras {
    void print(){
        System.out.println("Dijkastras Algorithm is on Dijkastras.java file");
    }
    // Digstras Algorithm

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

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));
        
        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5,1));

        graph[4].add(new Edge(4, 3,2));
        graph[4].add(new Edge(4, 5,5));


    }

    static class Pair{
        int node;
        int dist;
        public Pair(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }

    public static void dijkstras(ArrayList<Edge>[] graph,int src){
        int dist[]=new int[graph.length]; //dist[i] - src to i
        for(int i=0;i<graph.length;i++){
            if(i!=src) dist[i]=Integer.MAX_VALUE;
        }

        boolean vis[]=new boolean[graph.length];
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.add(new Pair(src, 0));
        //bfs
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!vis[curr.node]){
                vis[curr.node]=true;
                // neighbour
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e=graph[curr.node].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    if(dist[u]+wt<dist[v]){ // updated distance from source to v
                         dist[v]=dist[u]+wt;
                         pq.add(new Pair(v,dist[v]));
                    }
                }
            }
        }

        for(int distance:dist) System.out.print(distance+" ");

    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        /*
                           7
                     1- - - -- - 3
                2  / |           | \ 1
                 /   |           |   \
                0    |1          |2    5
                 \   |           |   /
                4  \ |           | / 5
                    2 - - - - - -4
                          3
         */               
        int V=6;
        ArrayList<Edge>[] graph=new ArrayList[V];
        createGraph(graph);

        int src=0;
        dijkstras(graph, src);
    }    
}
