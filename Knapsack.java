import java.util.Arrays;

public class Knapsack {
    // fractional kanpsak solution

    // 0-1 knapsack solution (Recursion)
    private static int knapsackRec(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W == 0) return 0;
        if(wt[n-1]<=W){
            int yes=val[n-1]+knapsackRec(wt, val, W-wt[n-1], n-1);
            int no=knapsackRec(wt, val, W, n-1);
            return Math.max(yes, no);
        }

        return knapsackRec(wt, val, W, n-1);
    }

    // 0-1 knapsack solution (Memoization)
    private static int[][] t;
    private static int knapsackMemo(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W == 0) return 0;
        if (t[n][W] != -1) return t[n][W];

        if (wt[n - 1] <= W) {
            int yes = val[n - 1] + knapsackMemo(wt, val, W - wt[n - 1], n - 1);
            int no = knapsackMemo(wt, val, W, n - 1);
            return t[n][W] = Math.max(yes, no);
        } 

        return t[n][W] = knapsackMemo(wt, val, W, n - 1);
    }
    // Tabulation in DP for knapsack
    private static int knapsackTopDown(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int[][] t = new int[n + 1][W + 1];
        // initialization
        for(int i=0;i<n+1;i++) t[i][0]=0;
        for(int j=0;j<W+1;j++) t[0][j]=0;
        for (int i=1;i<n+1;i++) {
            for (int j=1;j<W+1;j++) {
                if (wt[i-1]<=j) {
                    t[i][j]=Math.max(val[i-1]+t[i-1][j-wt[i-1]], t[i-1][j]);
                } else {
                    t[i][j]=t[i-1][j];
                }
            }
        }
    
        return t[n][W];
    }
    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int W = 7;

        System.out.println(knapsackRec(wt, val, W, 4)); // not optimal solution
        t = new int[4 + 1][W + 1];
        for (int i = 0; i <= 4; i++) {
            Arrays.fill(t[i], -1);
        }
        System.out.println(knapsackMemo(wt, val, W, 4)); // optimal solution using memoization
        for(int i = 0; i <= 4; i++) {
            for (int j = 0; j <= W; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Tablulation in DP");
        System.out.println(knapsackTopDown(W, val, wt));
    }
}
