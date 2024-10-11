import java.util.*;
import java.util.LinkedList;

public class javaClass45 {
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

        graph[7].add(new Edge(7,8,1));
    }

    static class Edges{
        int src;
        int dest;
        public Edges(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    static void createDirectedGraph(ArrayList<Edges> graph[]){
        for(int i=0;i<graph.length;i++)graph[i]=new ArrayList<>();
        graph[0].add(new Edges(0, 2));

        graph[1].add(new Edges(1, 0));

        graph[2].add(new Edges(2, 3));

        graph[3].add(new Edges(3, 0));
    }

    static void directedAcyclicGraph(ArrayList<Edges> graph[]){
        for(int i=0;i<graph.length;i++)graph[i]=new ArrayList<>();

        graph[2].add(new Edges(2, 3));

        graph[3].add(new Edges(3, 1));

        graph[4].add(new Edges(4, 0));
        graph[4].add(new Edges(4, 1));

        graph[5].add(new Edges(5, 0));
        graph[5].add(new Edges(5, 2));
    }
    
    public static void bfs(ArrayList<Edge>[] graph){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i])
            bfsUtil(graph, i, vis);
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph,int src,boolean vis[]){
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int curr=q.remove();
            if(!vis[curr]){
                vis[curr]=true;
                System.out.print(curr+" ");
                for(int i=0;i<graph[curr].size();i++){
                    Edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i])
            dfsUtil(graph, i, vis);
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph,int src,boolean vis[]){
        if(vis[src])return;
        vis[src]=true;
        System.out.print(src+" ");

        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if(!vis[e.dest])dfsUtil(graph, e.dest, vis);
        }
    }


    // Barpartite - bfs approach
    public static boolean isBipartite(ArrayList<Edge>[] graph)
    {
        // Code here
        int V=graph.length;
        int color[]=new int[V];
        for(int i=0;i<V;i++)color[i]=-1;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                q.add(i);
                color[i]=0;
                if(!Bipartiteutil(graph,q,color))return false;
            }
        }
        
        return true;
    }

    public static boolean Bipartiteutil(ArrayList<Edge>[] graph,Queue<Integer> q,int color[]){
        while(!q.isEmpty()){
            int curr=q.remove();
            for(int i=0;i<graph[curr].size();i++){
                int neighbour=graph[curr].get(i).dest;
                // case 1 - col same
                if(color[curr]==color[neighbour])return false;
                // case 3 - no color
                if(color[neighbour]==-1){
                    int nextcol=color[curr]==0?1:0;
                    color[neighbour]=nextcol;
                    q.add(neighbour);
                }
                // case 2 - col opposite
                if(color[curr]!=color[neighbour]&&color[neighbour]!=-1)continue;
            }
        }
        
        return true;
    }

    // isCycle exist in a deirected graph 
    public static boolean isCycle(ArrayList<Edges> graph[]){
        boolean vis[]=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length]; // explicit stack to track call stack
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(isCycleUtil(graph, vis, stack, i))return true;
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edges> graph[],boolean vis[],boolean stack[],int curr){
        vis[curr]=true;
        stack[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            int neighbour=graph[curr].get(i).dest;
            if(stack[neighbour])return true;
            if(!vis[neighbour]&&isCycleUtil(graph, vis, stack, neighbour))return true;
        }
        stack[curr]=false;
        return false;
    }

    // topologicalSorting
    public static void topologicalSorting(ArrayList<Edges> graph[]){
        boolean vis[]=new boolean[graph.length];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<graph.length;i++){
            if(!vis[i]) topologicalSortingUtil(graph,vis,s,i);
        }
        while(!s.isEmpty())System.out.print(s.pop()+" ");
    }

    public static void topologicalSortingUtil(ArrayList<Edges> graph[],boolean vis[],Stack<Integer> s,int curr){
            vis[curr]=true;
            for(int i=0;i<graph[curr].size();i++){
                int neighbour=graph[curr].get(i).dest;
                if(!vis[neighbour]) topologicalSortingUtil(graph,vis,s,neighbour);
            }
            s.push(curr);
    }

    

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // Graph - Connected Components
        // new Graph for BFS
         /*
                       1 ----- 2
                      /        | \
                     0         |  5 -- 6  7 --- 8
                      \        | /    
                       2 ----- 4   
          */
        ArrayList<Edge> graph[]=new ArrayList[9];
        creteGraph(graph);
        bfs(graph);System.out.println();
        dfs(graph); System.out.println();

        // Bipartite graph or not 
        // if graph doesnot has cycle by default is a bi partite graph
        System.out.println(isBipartite(graph));

        ArrayList<Edges> graphs[]=new ArrayList[4];
        createDirectedGraph(graphs);
        System.out.println(isCycle(graphs));

        ArrayList<Edges>[] dag=new ArrayList[6];
        directedAcyclicGraph(dag);
        topologicalSorting(dag);
        System.out.println();


        // stack of array for practice new building data structures
        Stack<Integer>[] arr=new Stack[3];
        for(int i=0;i<arr.length;i++)arr[i]=new Stack<>();

        arr[0].push(1);
        arr[0].push(2);

        arr[1].push(2);
        arr[1].push(3);

        arr[2].push(3);
        arr[2].push(4);
        arr[2].pop();

        for(int i=0;i<arr.length;i++){
            Stack<Integer> s=arr[i];
            while (!s.isEmpty()) {
                System.out.print(s.pop()+" ");
            }
            System.out.println();
        }
        
    }
}
