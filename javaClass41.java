
import java.util.ArrayList;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;



public class javaClass41 {
    static class Student implements Comparable<Student>{
        String name;
        int rank;
        public Student(String name,int rank){
            this.name=name; 
            this.rank=rank;
        }
        @Override
        public int compareTo(Student s2) {
            return this.rank-s2.rank;
        }
    }

    // minHeap
    static class Heap {
        ArrayList<Integer> arr=new ArrayList<>();

        public void add(int data){  //O(logn)
            arr.add(data);

            int x=arr.size()-1; // x is child index
            int par=(x-1)/2;   // par index

            while(arr.get(x)<arr.get(par)){ //O(logn)
                // swap
                int temp=arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                x=par;
                par=(x-1)/2;
            }
        }

        public int peek(){
            return arr.get(0);
        }
        private void heapify(int i){
            int left=2*i+1;
            int right=2*i+2;
            int minIdx=i;

            if(left<arr.size()&&arr.get(minIdx)>arr.get(left))
            minIdx=left;
            if(right<arr.size()&&arr.get(minIdx)>arr.get(right))
            minIdx=right;

            if(minIdx!=i){
                // swap
                int temp=arr.get(i);
                arr.set(i,arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }
        public int remove(){
            int data=arr.get(0);

            //step 1 - swap first & last
            int temp=arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //step 2 - delete last 
            arr.remove(arr.size()-1);

            // step 3 - heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty(){
            return arr.size()==0;
        }
    }

    public static void heapSort(int arr[]){
        // step 1 - build maxHeap
        int n=arr.length;
        for(int i=n/2;i>=0;i--){
            heapify(arr, i, n);
        }
        // step 2 - push largest at end
        for(int i=n-1;i>0;i--){
            // swap
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            heapify(arr, 0, i);
        }
    }
    public static void heapify(int arr[],int i,int size){
        int left=2*i+1;
        int right=2*i+2;
        int maxIdx=i;
        if(left<size&&arr[left]>arr[maxIdx])
        maxIdx=left;
        if(right<size&&arr[right]>arr[maxIdx])
        maxIdx=right;

        if(maxIdx!=i){
            // swap
            int temp=arr[i];
            arr[i]=arr[maxIdx];
            arr[maxIdx]=temp;

            heapify(arr, maxIdx, size);
        }
    }
    static class Point implements Comparable<Point>{
        int idx;
        int dist;
        public Point(int idx,int dist){
            this.idx=idx;
            this.dist=dist;
        }
        @Override
        public int compareTo(Point p2) {
           return this.dist-p2.dist;
        }
    }
    static class Soldier implements Comparable<Soldier>{
        int soldiers;
        int index;
        public Soldier(int soldiers,int index){
            this.soldiers=soldiers;
            this.index=index;
        }
        @Override
        public int compareTo(Soldier s2){
            if(this.soldiers==s2.soldiers)
            return this.index-s2.index;
            return this.soldiers-s2.soldiers;
        }
    }
    // first approach of sliding window - Deque appraoch
    public static List<Integer> maxSlidingWindow(int []window,int sliding){
        List<Integer> arr=new ArrayList<>();
        Deque<Integer> q=new LinkedList<>();
        for(int i=0;i<window.length;i++){
            while(!q.isEmpty()&&window[q.getLast()]<window[i])
            q.removeLast();
            q.addLast(i);
            while(q.getFirst()<=i-sliding)q.removeFirst();
            if(i>=sliding-1)arr.add(window[q.getFirst()]);
        }
        return arr;
    }
    // second appraoch of sliding window - proirityQueue
    static class Info implements Comparable<Info>{
        int val;
        int idx;
        public Info(int val,int idx){
            this.val=val;
            this.idx=idx;
        }
        @Override
        public int compareTo(Info i2){
            //Decending
            return i2.val-this.val;
        }
    }
    public static int[] maxSliding(int []win,int k){
        int arr[]=new int[win.length-k+1];
        PriorityQueue<Info> pq=new PriorityQueue<>();
        for(int i=0;i<win.length;i++){
            while(!pq.isEmpty()&&pq.peek().idx<=i-k)
            pq.remove();
            pq.add(new Info(win[i], i));
            if(i>=k-1)arr[i-k+1]=pq.peek().val;
        }
        return arr;
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(7);

        while (!pq.isEmpty())
        System.out.print(pq.remove()+" ");

        System.out.println();

        PriorityQueue<Student> pq1=new PriorityQueue<>();

        pq1.add(new Student("A", 4));
        pq1.add(new Student("B", 5));
        pq1.add(new Student("C", 1));
        pq1.add(new Student("D", 12));

        while (!pq1.isEmpty()) {
            System.out.println(pq1.peek().name+" -> "+pq1.peek().rank);
            pq1.remove();
        }
        
        Heap minHeap=new Heap();
        minHeap.add(2);
        minHeap.add(3);
        minHeap.add(4);
        minHeap.add(5);
        minHeap.add(10);
        minHeap.add(6);


        while(!minHeap.isEmpty()){
            System.out.println(minHeap.peek());
            minHeap.remove();
        }

        // Heap Sort
        int arr[]={1,2,4,5,3};
        heapSort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        // NearBy Cars Proble
        int pts[][]={{3,3},{5,-1},{-2,4}};
        int k=2;
        PriorityQueue<Point> pt=new PriorityQueue<>();
        for(int i=0;i<pts.length;i++){
            int distance=(int)Math.pow(pts[i][0],2)+(int)Math.pow(pts[i][1],2);
            pt.add(new Point(i, distance));
        }
        while(k!=0){
            System.out.print("C"+pt.remove().idx+" ");
            k--;
        }
        System.out.println();

        // connect N ropes
        int ropes[]={2,3,3,4,6};
        PriorityQueue<Integer> cn=new PriorityQueue<>();
        for(int i=0;i<ropes.length;i++)
        cn.add(ropes[i]);
        int cost=0;
        while(!cn.isEmpty()){
            int a=cn.remove();
            if(cn.isEmpty())break;
            int b=cn.remove();
            cost+=a+b;
            cn.add(a+b);
        }
        System.out.println(cost);

        // Weakest Soldiers 
        int mat[][]={{1,0,0,0},
                    {1,1,1,1},
                    {1,0,0,0},
                    {1,0,0,0}};
        int iteration=2;
        int ans[]=new int[iteration];
        PriorityQueue<Soldier> sl=new PriorityQueue<>();
        for(int i=0;i<mat.length;i++){
            int sum=0;
            for(int j=0;j<mat[0].length;j++){
                sum+=mat[i][j];
            }
            sl.add(new Soldier(sum,i));
        }
        for(int i=0;i<iteration;i++){
            ans[i]=sl.remove().index;
        }
        for(int i=0;i<ans.length;i++)
        System.out.print("Soldier("+ans[i]+") ");

        System.out.println();

        int window[]={1,3,-1,-3,5,3,6,7};
        int sliding=3;
        // first approach - Deque
        System.out.println(maxSlidingWindow(window, sliding));
        // second approach - PriorityQueue
        int win[]={1,3,-1,-3,5,3,6,7};
        int slide=3;
        int newarr[]=maxSliding(win, slide);
        for(int i:newarr)
        System.err.print(i+" ");
        
    }
}
