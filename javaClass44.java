import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class javaClass44 {
    static class Edge{
        int src,dest,wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }


    // create Graph
    public static void creteGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));
        
        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));
        
        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));
        
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));
        
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));
        
        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));
        
        graph[6].add(new Edge(6,5,1));
    }


    //BFS Traversal
    public static void bfs(ArrayList<Edge> graph[]){
        Queue<Integer> q=new LinkedList<>();
        boolean vis[]=new boolean[graph.length];
        q.add(0);
        while(!q.isEmpty()){
            int curr=q.remove();
            if(!vis[curr]){ //visit curr
                vis[curr]=true;
                System.out.print(curr+" ");
                for(int i=0;i<graph[curr].size();i++){
                    Edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }


    //dfs
    public static void dfs(ArrayList<Edge> graph[],List<Integer> arr,boolean []visit,int curr){
        
        if(visit[curr])return;
        visit[curr]=true;
        arr.add(curr);
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!visit[e.dest]){
                dfs(graph, arr, visit, e.dest);
            }
        }
    }


    public static boolean hasPath(ArrayList<Edge>[] graph,int src,int dest,boolean vis[]){
        if(src==dest)return true;
        vis[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if(!vis[e.dest]&&hasPath(graph, e.dest, dest, vis))return true;
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph,boolean vis[],int curr,int par){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            int neighbour=e.dest;
            //case 1
            if(vis[neighbour]&&neighbour!=par)return true;
            //case 2
            if(vis[neighbour]&&neighbour==par)continue;
            //case 3
            if(!vis[neighbour]&&detectCycleUtil(graph, vis, neighbour, curr))return true;
        }
        return false;
    }

    public static boolean detectCycle(ArrayList<Edge> []graph){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(detectCycleUtil(graph, vis, i, -1))return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        /*
                     (5)
                0 ------- 1
                         / \
                     (1)/   \ (3)
                       /     \
                      2 ----- 3
                      |  (1)
                   (2)|
                      |
                      4
         */

         int V=5; // V for vertices;
         // int arr[]=new int[5];
         ArrayList<Edge> graph[]=new ArrayList[V]; //null -> empty arrayList
         for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
         }

         // 0 - vertex
         graph[0].add(new Edge(0,1,5));

         // 1 -vertex
         graph[1].add(new Edge(1,0,5));
         graph[1].add(new Edge(1,2,1));
         graph[1].add(new Edge(1,3,3));

         // 2 - vertex
         graph[2].add(new Edge(2, 1, 1));
         graph[2].add(new Edge(2, 3, 1));
         graph[2].add(new Edge(2, 4, 2));
         
         // 3 -vertex
         graph[3].add(new Edge(3, 1, 3));
         graph[3].add(new Edge(3, 2, 1));
         
         //4 -vertex
         graph[4].add(new Edge(4, 2, 2));

         
         // 2's neibhours
         for(int i=0;i<graph[2].size();i++){
            Edge e=graph[2].get(i);
            System.out.println(e.dest);
         }
         

         // new Graph for BFS
         /*
                       1 ----- 2
                      /        | \
                     0         |  5 -- 6  
                      \        | /    
                       2 ----- 4   
          */

          ArrayList<Edge> newGraph[]=new ArrayList[7];
          creteGraph(newGraph);
          bfs(newGraph);System.out.println();

          // dfs 
          List<Integer> arr=new ArrayList<>();
          boolean visit[]=new boolean[7];
          dfs(newGraph,arr,visit,0);
          System.out.println(arr);

         // Has path
         boolean vistied[]=new boolean[7];
         System.out.println(hasPath(newGraph, 0, 5, vistied));

         // Detect Cycle in a graph
         System.out.println(detectCycle(newGraph));
         

    }
}
