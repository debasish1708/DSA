

public class KnapsackVariation {
    // subset sum problem - Memoization
    private static Boolean[][] t;
    private static boolean isSubsetSum(int[] arr,int sum,int n){
        if(sum==0)return true;
        if(n==0)return false;
        if(t[n][sum]!=null) return t[n][sum];
        if(arr[n-1]<=sum){
            return t[n][sum]=isSubsetSum(arr, sum-arr[n-1], n-1) || isSubsetSum(arr, sum, n-1);
        }
        return t[n][sum]=isSubsetSum(arr, sum, n-1);
    }

    // subset sum problem - Top Down
    private static boolean isSubsetSumTopDown(int[] arr,int sum,int n){
        for(int i=0;i<t.length;i++) t[i][0]=true;
        for(int j=1;j<t[0].length;j++) t[0][j]=false;
        for(int i=1;i<t.length;i++){
            for(int j=1;j<t[0].length;j++){
                if(arr[i-1]<=j) {
                    t[i][j]=t[i-1][j-arr[i-1]] || t[i-1][j];
                } else {
                    t[i][j]=t[i-1][j];
                }
            }
        }
        
        return t[arr.length][sum];
    }
    // same as subset sum problem only the equal logic is chagne sum/2 even or odd
    public static boolean equalSumPartition(int[] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++) sum+=arr[i];
        if(sum%2!=0) return false;
        t=new Boolean[arr.length+1][sum/2+1];
        // initializaton
        for(int i=0;i<t.length;i++) t[i][0]=true;
        for(int j=1;j<t[0].length;j++) t[0][j]=false;
        
        for(int i=1;i<t.length;i++){
            for(int j=1;j<t[0].length;j++){
                if(arr[i-1]<=j) {
                    t[i][j]=t[i-1][j-arr[i-1]] || t[i-1][j];
                } else {
                    t[i][j]=t[i-1][j];
                }
            }
        }
        
        return t[arr.length][sum/2];
    }
    public static void main(String[] args) {
        // knapsack variations
        int[] arr={3, 34, 4, 12, 5, 2};
        int sum=12;
        t=new Boolean[arr.length+1][sum+1];
        System.out.println(isSubsetSum(arr, sum, arr.length));
        System.out.println(isSubsetSumTopDown(arr, sum, sum));
        System.out.println(equalSumPartition(arr));
    }
}
