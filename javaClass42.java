import java.util.*;

public class javaClass42 {

    public static void MajorityElement(int arr[]){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
        int size=arr.length/3;
        for (Integer keys : map.keySet()) {
            if(map.get(keys)>size) System.out.println(keys);
        }
    }

    public static boolean validAnagram(String s,String t){
        if(s.length()!=t.length())return false;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(map.containsKey(ch)){
                if(map.get(ch)==1)map.remove(ch);
                else map.put(ch, map.get(ch)-1);
            } else return false;
        }
        return map.isEmpty();
    }

    public static String startingPoint(HashMap<String,String> ticket){
        HashSet<String> set=new HashSet<>();
        for(String key:ticket.keySet()){
            set.add(ticket.get(key));
        }
        for(String key:ticket.keySet()){
            if(!set.contains(key))
            return key;
        }
        return null;
    }
    // largest subarray with 0 sum
    public static int maxLen(int arr[], int n){
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int len=0;
        for(int j=0;j<n;j++){
            sum+=arr[j];
            if(sum==0)len=j+1;
            if(map.containsKey(sum))
            len=Math.max(len,j-map.get(sum));
            else
            map.put(sum,j);
        }
        return len;
    }
 
    // sub array sum with equal to k
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int ans=0,sum=0;
        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
            if(map.containsKey(sum-k))ans+=map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        return ans;
    }
    public static void main(String[] args) {
        // Hashing
        HashMap<String,Integer> map=new HashMap<>();
        //insert -O(1)
        map.put("India", 100);
        map.put("China", 150);
        map.put("Us", 50);
        System.out.println(map);

        // Get - O(1)
        int pop=map.get("India");
        System.out.println(pop);
        System.out.println(map.get("Eng"));

        // containskey - O(1)
        System.out.println(map.containsKey("India"));

        // Remove - O(1)
        System.out.println(map.remove("China"));
        System.out.println(map);
        //size
        System.out.println(map.size());
        //clear
        map.clear();
        //isEmpty
        System.out.println(map.isEmpty());

        map.put("India", 100);
        map.put("China", 150);
        map.put("Us", 50);
        map.put("Indonesia", 6);
        map.put("Nepal", 5);
        System.out.println(map);

        // Iteration
        Set<String> keys=map.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("key="+k+", value="+map.get(k));
        }
        System.out.println();

        // Linked hash map - keys are insertion oreder
        LinkedHashMap<String,Integer> lmap=new LinkedHashMap<>();
        lmap.put("India", 100);
        lmap.put("China", 150);
        lmap.put("Us", 50);
        lmap.put("Indonesia", 6);
        lmap.put("Nepal", 5);
        // TreeMap
        System.out.println("TreeMap");
        TreeMap<String,Integer> tmap=new TreeMap<>();
        tmap.put("India", 100);
        tmap.put("China", 150);
        tmap.put("Us", 50);
        tmap.put("Indonesia", 6);
        tmap.put("Nepal", 5);
        System.out.println(tmap); // return it in keys sorted order
        System.out.println(lmap); // return it in inertion orderd
        System.out.println(map); // retur it in ranoom order 
        // Majority Element 
        int[] arr={1,3,2,5,1,3,1,5,1};
        MajorityElement(arr);
        System.out.println(validAnagram("knee", "keen"));

        // HashSet
        HashSet<Integer> set=new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(2);
        set.add(1);
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        // set.clear();
        // System.out.println(set.isEmpty());
        System.out.println(set.remove(1));
        System.out.println(set);
        System.out.println(set.contains(4));
        System.out.println();

        // Iterator in HashSet
        HashSet<String> cities=new HashSet<>();
        cities.add("Balasore");
        cities.add("Bhadrak");
        cities.add("Puri");
        cities.add("Cuttuck");
        cities.add("Bhubaneswar");
        cities.add("Delhi");
     
        Iterator<String> it=cities.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println();
        for (String city : cities) {
            System.out.println(city);
        }
        System.out.println();

        // LinkedHashSet
        LinkedHashSet<String> city=new LinkedHashSet<>();
        city.add("Balasore");
        city.add("Bhadrak");
        city.add("Puri");
        city.add("Cuttuck");
        city.add("Bhubaneswar");
        city.add("Delhi");
        
        @SuppressWarnings("rawtypes")
        Iterator itr=city.iterator();
        while(itr.hasNext())
        System.out.println(itr.next());System.out.println();
        for(String s:city)
        System.out.println(s);
        System.out.println(city);
        // city.remove("Delhi");
        // System.out.println(city);


        //TreeSet
        TreeSet<String> ncity=new TreeSet<>();
        ncity.add("Balasore");
        ncity.add("Bhadrak");
        ncity.add("Puri");
        ncity.add("Cuttuck");
        ncity.add("Bhubaneswar");
        ncity.add("Delhi");
        System.out.println(ncity);
        
        @SuppressWarnings("rawtypes")
        Iterator itt= ncity.iterator();
        while (itt.hasNext()) {
            System.out.println(itt.next());
        }

        // count distnict numbers
        int num[]={4,3,2,5,6,7,3,4,2,1};
        HashSet<Integer> countdist=new HashSet<>();
        for(int i=0;i<num.length;i++)
        countdist.add(num[i]);
        System.out.println("Distnict number = "+countdist.size());
        
        // union and intersection between two arrays
        int arr1[]={7,3,9};
        int arr2[]={6,3,9,2,9,4};
        HashSet<Integer> ui=new HashSet<>();
        for(int i:arr1)
        ui.add(i);
        for(int i:arr2)
        ui.add(i);
        System.out.println("union = "+ui.size());
        ui.clear();
        for(int i:arr1)
        ui.add(i);
        int intersection=0;
        for(int i=0;i<arr2.length;i++){
            if(ui.contains(arr2[i])){
                intersection++;
                ui.remove(arr2[i]);
            }
        }
        System.out.println("Intersection = "+intersection);

        HashMap<String,String> ticket=new HashMap<>();
        ticket.put("Chennai","Bengaluru");
        ticket.put("Mumbai","Delhi");
        ticket.put("Goa","Chennai");
        ticket.put("Delhi","Goa");
        String start=startingPoint(ticket);
        System.out.print(start);
       
        for(@SuppressWarnings("unused") String key:ticket.keySet()){
            System.out.print(" -> "+ticket.get(start));
            start=ticket.get(start);
        }System.out.println();

        // largest sun array with 0 sum
        int sum0[]={15,-2,2,-8,1,7,10};
        System.out.println("largest sub array with 0 sum = "+maxLen(sum0, sum0.length));

        int nums[]= {10 , 2, -2, -20, 10};
        int k=-10;
        System.out.println("subarrys sum with equal to k = "+subarraySum(nums, k));
        
    }    
}
