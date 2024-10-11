import java.util.ArrayList;
import java.util.Stack;

public class gfgStack {

    // public static void printStack(Stack<Integer> s){
    //     while(!s.isEmpty()){
    //         System.out.print(s.pop()+" ");
    //     }
    // }

    // public static void pushAtBottom(Stack<Integer> s, int data){
    //     // base case
    //     if(s.isEmpty()){
    //         s.push(data);
    //         return;
    //     }

    //     //recursion
    //     int top=s.pop();
    //     pushAtBottom(s, data);
    //     s.push(top);
    // }
    // // sort a stack
    // public static void sort(Stack<Integer> s){
    //     if(s.isEmpty()){
    //         return;
    //     }

    //     // recursion
    //     int top=s.pop();
    //     sort(s);
    //     if(s.isEmpty())
    //         s.push(top);
        
    //     else if(s.peek()>top){

    //     } else
    //         s.push(top);
    // }

    // public static long getMaxArea(long hist[], long n) 
    // {
    //     // your code here
    //     int nextSmallerLeft[]=new int[(int) n];
    //     int nextSmallerRight[]=new int[(int) n];
        
    //     Stack<Integer> s=new Stack<>();

    //     //for width nextSmaller left
    //     for(int i=0;i<n;i++){
    //         while(!s.isEmpty()&&hist[s.peek()]>=hist[i])
    //             s.pop();
    //         if(s.isEmpty())
    //             nextSmallerLeft[(int) i]=-1;
    //         else
    //             nextSmallerLeft[(int) i]=s.peek();
    //         s.push(i);
    //     }

    //     s=new Stack<>();
    //     //for width nextSmaller Right
    //     for(int i=(int) (n-1);i>=0;i--){
    //         while(!s.isEmpty()&&hist[s.peek()]>=hist[i])
    //             s.pop();
    //         if(s.isEmpty())
    //             nextSmallerRight[(int) i]=hist.length;
    //         else
    //             nextSmallerRight[(int) i]=s.peek();
    //         s.push(i);
    //     }

    //     long mx=0;
    //     for(long i=0;i<n;i++){
    //         long area=(nextSmallerRight[(int) i]-nextSmallerLeft[(int) i]-1)*hist[(int) i];
    //         mx=Math.max(area, mx);
    //     }
        
    //     return mx;
    // }

    public static void sorting(Stack<Integer> tempStack, int data){
        //base case
        if(tempStack.isEmpty()){
            tempStack.push(data);
            return;
        }
        if(tempStack.peek()>=data){
            tempStack.push(data);
            return;
        }

        //recursion
        int top=tempStack.pop();
        sorting(tempStack, data);
        tempStack.push(top);

    }

    public static void sort(Stack<Integer> s){
        Stack<Integer> tempStack = new Stack<>();

        while (!s.isEmpty()) {
            int data = s.pop();
            sorting(tempStack, data);
        }
        while (!tempStack.isEmpty()) {
            s.push(tempStack.pop());
        }
    }


    public static void subset(String s,String ans,int idx){
        if(idx==s.length()){
            System.out.println(ans);
            return;
        }
        //yes
        subset(s,ans+s.charAt(idx),idx+1);
        //no
        subset(s,ans,idx+1);
    }

    public static void solve(char Nquuen[][],int row){
        if(row==Nquuen.length){
            printArr(Nquuen);
            return;
        }

        for(int j=0;j<Nquuen[0].length;j++){
            Nquuen[row][j]='Q';
            solve(Nquuen, row+1);
            Nquuen[row][j]='X';
        }
    }

    public static void printArr(char Nqueen[][]){
        System.out.println();
        for(int i=0;i<Nqueen.length;i++){
            for(int j=0;j<Nqueen[0].length;j++)
                System.out.print(Nqueen[i][j]+" ");
                System.out.println();
        }
    }


    public static boolean isSafe(int newRow,int newCol,boolean visited[][],int m[][],int n){
       if((newRow>=0&&newRow<n)&&(newCol>=0&&newCol<n)&&visited[newRow][newCol]!=true&&m[newRow][newCol]==1){
            return true;
       }
        else
        return false;
    }
    public static void find(ArrayList<String> ans,String result,int row,int col,boolean visited[][],int m[][],int n){
        //base case
        if(row==n-1&&col==n-1){
            ans.add(result);
            return;
        }

        // Down
        if(isSafe(row+1,col,visited,m,n)){
            visited[row][col]=true;
            find(ans, result+'D', row+1, col, visited, m, n);
            visited[row][col]=false;
        }
        // left
        if(isSafe(row,col-1,visited,m,n)){
            visited[row][col]=true;
            find(ans, result+'L', row, col-1, visited, m, n);
            visited[row][col]=false;
        }
        // right
        if(isSafe(row,col+1,visited,m,n)){
            visited[row][col]=true;
            find(ans, result+'R', row, col+1, visited, m, n);
            visited[row][col]=false;
        }
        // Up
        if(isSafe(row-1,col,visited,m,n)){
            visited[row][col]=true;
            find(ans, result+'U', row-1, col, visited, m, n);
            visited[row][col]=false;
        }

    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans=new ArrayList<>();
        boolean visited[][]=new boolean[n][n];
        find(ans,"",0,0,visited,m,n);
        // System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        // Stack<Integer> s=new Stack<>();
        // s.push(11);
        // s.push(2);
        // s.push(32);
        // s.push(3);
        // s.push(41);
        // sort(s);
        // while(!s.isEmpty())
        //     System.out.println(s.pop());

        // find subset
        // subset("abc","",0);

        // char Nquuen[][]=new char[2][2];
        // for(int i=0;i<Nquuen.length;i++){
        //     for(int j=0;j<Nquuen[0].length;j++){
        //         Nquuen[i][j]='X';
        //         // System.out.print(Nquuen[i][j]+" ");
        //     }
        //     // System.out.println();
        // }

        // solve(Nquuen,0);
        int n=4;
        int m[][] = 
        {{1, 0, 0, 0},
         {1, 1, 0, 1}, 
         {1, 1, 0, 0},
         {0, 1, 1, 1}};
         // DDRDRR DRDDRR
         System.out.println(findPath(m, n));
    }
}
