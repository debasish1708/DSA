import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class javaClass35 {
    public static long findMinSum(int[] A,int[] B,int N) { 
        Arrays.sort(A);
        Arrays.sort(B);
        long ans=0;
        for(int i=0;i<N;i++){
            ans+=Math.abs(A[i]-B[i]);
        }
        return ans;
    }

    // Indian Coins
    @SuppressWarnings("unused")
    static List<Integer> IndianCoins(int N)
    {
        // code here
        int coins[]={2000,500,200,100,50,20,10,5,2,1};
        List<Integer> arr=new ArrayList<>();
        int count=0;
        for(int i=0;i<coins.length;i++){
            if(coins[i]<=N){
                while(coins[i]<=N){
                    count++;
                    arr.add(coins[i]);
                    N-=coins[i];
                }
            }
        }
        System.out.println(arr);
        return arr;
    }

    static class Job {
        int deadLine;
        int profit;
        int id;
        public Job(int i, int d, int p) {
            id=i;
            deadLine=d;
            profit=p;
        }
        
    }


    public static void main(String[] args) {
        // Greedy Approach
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9}; // end time basis sorted 

        // sorting
        // 2-d array
        int activities[][]=new int[start.length][3];
        for(int i=0;i<start.length;i++){
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
        }
        // Lamda function -> shortform
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
        int maxAct=0;
        ArrayList<Integer> ans=new ArrayList<>();
        maxAct=1;
        ans.add(activities[0][0]);
        int lastEnd=activities[0][2];

        for(int i=1;i<end.length;i++){
            if(activities[i][1]>lastEnd){
                // activity select
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd=activities[i][2];
            }
        }
        System.out.println(ans);
        System.out.println(maxAct);
        
        int value[]={60, 100, 120};
        int weight[]={10,20,30};
        int W=50;
        double ratio[][]=new double[value.length][2];
        for(int i=0;i<value.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=value[i]/(double)weight[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        double res=0;
        int capacity=W;
        for(int i=value.length-1;i>=0;i--){
            int idx=(int)ratio[i][0];
            if(capacity>=weight[idx]){
                res+=value[idx];
                capacity-=weight[idx];
            } else{
                res+=(ratio[i][1]*capacity);
                capacity=0;
                break;
            }
        }
        
        System.out.println(res);

        int A[]={4,1,8,7};
        int B[]={2,3,6,5};
        int N=4;
        System.out.println(findMinSum(A, B, N));
        // System.out.println();
        
        // System.out.println();
        // Max Length Chain of Pairs ...
        int pairs[][]={{5, 24},{39, 60},{5, 28},{27, 40},{50, 90}};
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int maxpairs=1;
        int lastSelectEnd=pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0]>lastSelectEnd){
                maxpairs++;
                lastSelectEnd=pairs[i][1];
            }
        }
        System.out.println("max chain length = "+maxpairs);
        IndianCoins(1060);
        // System.out.println(arr);

        // job sequcing Problem
        int jobInfo[][]={{4,20},{1,10},{1,40},{1,30}};
        ArrayList<Job> jobs=new ArrayList<>();
        for(int i=0;i<jobInfo.length;i++){
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        // Collections.sort(jobs, (a,b) -> a.profit-b.profit); //ascending sortingh
        Collections.sort(jobs, (a,b) -> b.profit-a.profit); //descending sortingh
        ArrayList<Integer> seq=new ArrayList<>();
        
        int time=0;
        for(int i=0;i<jobs.size();i++){
            Job curr=jobs.get(i);
            if(curr.deadLine>time){
                time++;
                seq.add(curr.id);
            }
        }
        System.out.println(seq);

        // int n=4,m=6;
        Integer costVer[]={2,1,3,1,4};
        Integer costHor[]={4,1,2};

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h=0,v=0;
        int hp=1,vp=1;
        int cost=0;
        while (h<costHor.length&&v<costVer.length) {
            // vertical cost < horizontal cost
            if(costVer[v]<=costHor[h]){ // horizontal cut
                cost+=(costHor[h]*vp);
                hp++;
                h++;
            } else{ //vertical cut
                cost+=(costVer[v]*hp);
                vp++;
                v++;
            }
        }
        while (h<costHor.length) {
            cost+=(costHor[h]*vp);
                hp++;
                h++;
        }
        while (v<costVer.length) {
            cost+=(costVer[v]*hp);
            vp++;
            v++;
        }
        System.out.println("min cost = "+cost);
    }
}
