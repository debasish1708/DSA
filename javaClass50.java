import java.util.Arrays;

public class javaClass50 {

    // find nth fibonacci number using recursion
    // public static int fib(int n){
    //     if(n==0||n==1)return n;
    //     return fib(n-1)+fib(n-2);
    // } 

    // find nth fibonacci number using Dynamic Programming
    // memoization technique - top Down 
    public static int fib(int n,int f[]){
        if(n==0||n==1)return n;
        if(f[n]!=0)return f[n];
        f[n]=(fib(n-1,f)+fib(n-2,f))%1000000007;
        return f[n];
    }

    // find nth fibonacci number using Dynamic Programming
    // tabulation technique - bottom up
    public static int fib(int n){
        if(n<=1)return n;
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        int mod=1000000007;
        for(int i=2;i<=n;i++)
        dp[i]=(dp[i-1]+dp[i-2])%mod;
        return dp[n];
    }

    private static int countWays(int n,int[] dp) {
        if(n==0||n==1||n==2||n==3)return n;
        if(dp[n]!=-1)return dp[n];
        return dp[n]=(countWays(n-1,dp)+countWays(n-2,dp))%1000000007;
    }
    
    public static void main(String[] args) {
        // Dynamic Programming
        // Scanner sc=new Scanner(System.in);
        // System.out.print("Enter n: ");
        // int n=sc.nextInt();
        int f[]=new int[51];
        for(int i=0;i<=50;i++)
        System.out.print(fib(i,f)+" ");
        System.out.println();System.out.println();
        for(int i=0;i<=50;i++)
        System.out.print(fib(i)+" ");
        System.out.println();
        

        System.out.println("--------------------");
        int[] dp=new int[6];
        Arrays.fill(dp, -1);
        System.out.println(countWays(5, dp)); // same as per previous tabuailazation
    }
}
