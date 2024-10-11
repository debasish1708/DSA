import java.util.*;
import java.util.LinkedList;

public class javaClass47 {
    static class Edge{
        int src;
        int dest;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++)graph[i]=new ArrayList<>();

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void createNewGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++)graph[i]=new ArrayList<>();

        graph[0].add(new Edge(0, 3));
        graph[2].add(new Edge(2, 3));
        
        graph[3].add(new Edge(3, 1));
        
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    
    public static void dfs(ArrayList<Edge>[] graph){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]) dfsUtil(graph,vis,i);
        }
    }
    public static void dfsUtil(ArrayList<Edge>[] graph, boolean vis[], int curr){
        vis[curr]=true;
        System.out.print(curr+" ");
        for(int i=0;i<graph[curr].size();i++){
            int neighbour=graph[curr].get(i).dest;
            if(neighbour!=-1&&!vis[neighbour])dfsUtil(graph, vis, neighbour);
        }
    }

    public static void calculateIndegree(ArrayList<Edge>[] graph,int[] indegree){
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                int dest=graph[i].get(j).dest;
                indegree[dest]++;
            }
        }
    }
    public static void kahnsAlgoTopSort(ArrayList<Edge>[] graph){
        // create a in-degree array
        int[] indegree=new int[graph.length];
        calculateIndegree(graph, indegree);
        Queue<Integer> q=new LinkedList<>();
        // for(int i:indegree)System.out.print(i+" ");
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)q.add(i);
        }
        
        //bfs
        while(!q.isEmpty()){
            int curr=q.remove();
            System.out.print(curr+" ");

            for(int i=0;i<graph[curr].size();i++){
                int dest=graph[curr].get(i).dest;
                indegree[dest]--;
                if(indegree[dest]==0)
                    q.add(dest);
            }
        }
    }

    public static void pritAllPath(ArrayList<Edge>[] graph,int src,int dest,String path){
        // base case
        if(src==dest) System.out.println(path+dest);
        for(int i=0;i<graph[src].size();i++){
            int target=graph[src].get(i).dest;
            pritAllPath(graph, target, dest, path+src+" ");
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // Graphs
        /*
                5------>0<--------4
                |                 |
                |                 |>
                >2------->3------->1
         */
        ArrayList<Edge>[] graph=new ArrayList[6];
        ArrayList<Edge>[] newGraph=new ArrayList[6];
        createGraph(graph);
        createNewGraph(newGraph);
        dfs(graph);System.out.println();
        dfs(newGraph);

        System.out.println();
        
        int count=1;
        for(int i=1;i<=4;i++){
            for(int j=i;j<4;j++){
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                if(j%2==0)
                System.out.print("* ");
                else{
                    System.out.print(count+" ");
                    count++;
                }

            }
            System.out.println();
        }
        kahnsAlgoTopSort(graph); // course schedule II - leetcode practice
        System.out.println();
        pritAllPath(newGraph, 5, 1, "");
        // System.out.println();

        // DIjkstra's Algorithm - shortest path from the source to all vertices
        Dijkstras dijkstras=new Dijkstras();
        dijkstras.print();
    }
}
