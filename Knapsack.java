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
    }
}
