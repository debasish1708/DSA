import java.util.*;

public class javaClass29 {
    //ArrayList

    //reverse of arraylist or swapping element
    public static ArrayList<Integer> rev(ArrayList<Integer> list){
        for(int i=0;i<=list.size()/2;i++){
            int temp=list.get(i);
            list.set(i, list.get(list.size()-1-i));
            list.set(list.size()-1-i, temp);
        }
        return list;
    }

    public static int maxValue(ArrayList<Integer> list){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<list.size();i++){
            max=Math.max(max, list.get(i));
            min=Math.min(max, list.get(i));
        }
        System.out.println("min value = "+min);
        return max;
    }

    //Container with Most Water ...
    // it is similar to trapping rain water
    // Brute force approach-O(n^2)
    public static int ContainerWithMostWater(int height[]){
        int tw=0;
        // for(int i=0;i<height.length;i++){
        //     for(int j=i+1;j<height.length;j++){
        //         int width=j-i;
        //         int minheight=Math.min(height[i],height[j]);
        //         tw=Math.max(tw, width*minheight);
        //     }
        // }

        // two pointer approach ..
        int lp=0,rp=height.length-1;
        while(lp<rp){
            int width=rp-lp;
            int minheight=Math.min(height[lp],height[rp]);
            tw=Math.max(tw, width*minheight);
            if(height[lp]<height[rp]){
                lp++;
            } else
                rp--;
        }
        return tw;
    }

    // brute force for arraylist approach O(n^2)
    public static int mostwater(ArrayList<Integer> heights){
        int tw=0;
        // two pointer approach
        int lp=0,rp=heights.size()-1;
        while (lp<rp) {
            int width=rp-lp;
            int minheight=Math.min(heights.get(lp),heights.get(rp));
            tw=Math.max(tw, width*minheight);
            if(heights.get(lp)<heights.get(rp)){
                lp++;
            } else
                rp--;
        }
        return tw;
    }

    // pair sum
    public static boolean pairSum(ArrayList<Integer> pair, int target){
        int lp=0,rp=pair.size()-1;
        while(lp!=rp){
            if(pair.get(lp)+pair.get(rp)==target){
                return true;
            } else if(pair.get(lp)+pair.get(rp)<target){
                lp++;
            } else
                rp--;
        }

        return false;
    }

    // pair sum 2 - Sorted and roated ArrayList ...
    public static boolean pairSum2(ArrayList<Integer> pair2, int target2){
        // finding pivot elemnt
        int rp=-1;int n=pair2.size();
        for(int i=0;i<pair2.size();i++){
            if(pair2.get(i)>pair2.get(i+1)){
                rp=i;
                break;
            }
        }
        // two pointer approach ...
        int lp=rp+1;
        while (lp!=rp) {
            if(pair2.get(lp)+pair2.get(rp)==target2){
                return true;
            } else if(pair2.get(lp)+pair2.get(rp)<target2){
                lp=(lp+1)%n;
            } else
                rp=(n+rp-1)%n;
        }
        return false;
    }
    
    public static void main(String[] args) {
        //Array List
        // ArrayList<Integer> list=new ArrayList<>();
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);
        // System.out.println(list);
        // System.out.println(list.contains(5));
        // for(int i=0;i<list.size();i++){
        //     System.out.print(list.get(i)+" ");
        // } System.out.println();
        // System.out.println(rev(list));
        // System.out.println("max value = "+maxValue(list));
        // Collections.sort(list); //ascending
        // System.out.println(list);
        // // decending
        // Collections.sort(list, Collections.reverseOrder());
        // System.err.println(list);
        // // System.out.println(rev(list));
        // // 2-D ArrayList
        // ArrayList<ArrayList<Integer>> mainList=new ArrayList<>();
        // ArrayList<Integer> sub1=new ArrayList<>();
        // sub1.add(1);
        // sub1.add(2);
        // mainList.add(sub1);
        // ArrayList<Integer> sub2=new ArrayList<>();
        // sub2.add(3);
        // sub2.add(4);
        // mainList.add(sub2);
        
        // System.out.println(mainList);
        // // print by loop
        // for(int i=0;i<mainList.size();i++){
        //     ArrayList<Integer> currList=mainList.get(i);
        //     for(int j=0;j<currList.size();j++){
        //         System.out.print(currList.get(j)+" ");
        //     }
        //     System.err.println();
        // }
        ArrayList<ArrayList<Integer>> mainList=new ArrayList<>();
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        ArrayList<Integer> list3=new ArrayList<>();

        for(int i=1;i<=3;i++){
            list1.add(i*1);
            list2.add(i*2);
            list3.add(i*3);
        }
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);
        System.err.println(mainList);

        for(int i=0;i<mainList.size();i++){
                ArrayList<Integer> currList=mainList.get(i);
                for(int j=0;j<currList.size();j++){
                    System.out.print(currList.get(j)+" ");
                }
                System.err.println();
            }
        // bruit force approach for Container with most water
        int height[]={1,8,6,2,5,4,8,3,7}; 
        System.out.println("area of water = "+ContainerWithMostWater(height));

        // by arraylist method 
        ArrayList<Integer> heights=new ArrayList<>();
        heights.add(1);
        heights.add(8);
        heights.add(6);
        heights.add(2);
        heights.add(5);
        heights.add(4);
        heights.add(8);
        heights.add(3);
        heights.add(7);
        // System.out.println(heights);
        System.out.println("trapping water = "+mostwater(heights));

        ArrayList<Integer> pair=new ArrayList<>();
        pair.add(1);
        pair.add(2);
        pair.add(3);
        pair.add(4);
        pair.add(5);
        pair.add(6);
        int target=7;
        System.out.println(pairSum(pair, target));

        ArrayList<Integer> pair2=new ArrayList<>();
        pair2.add(11);
        pair2.add(15);
        pair2.add(6);
        pair2.add(8);
        pair2.add(9);
        pair2.add(10);
        int target2=16;
        System.out.println(pairSum2(pair2, target2));
    }
}
