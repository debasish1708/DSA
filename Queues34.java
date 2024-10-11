import java.util.*;
import java.util.LinkedList;
public class Queues34 {
    public static String FirstNonRepeating(String A)
    {
        // code here
        StringBuilder sb=new StringBuilder();
        Queue<Character> q=new LinkedList<>();
        int count[]=new int[26];
        for(int i=0;i<A.length();i++){
            char ch=A.charAt(i);
            q.add(ch);
            count[ch-'a']++;
            while(!q.isEmpty()&&count[q.peek()-'a']>1)
            q.remove();
            if(q.isEmpty())
            sb.append(-1+" ");
            else
            sb.append(q.peek()+" ");
        }
        return sb.toString();
    }

    public static Queue<Integer> rearrangeQueue(Queue<Integer> q) {
        // code here
        Queue<Integer> first=new LinkedList<>();
        int size=0;
        int N=q.size();
        while(size!=N/2){
            first.add(q.remove());
            size++;
        }
        while(!first.isEmpty()){
            q.add(first.remove());
            q.add(q.remove());
        }
        return q;
    }
    public static void main(String[] args) {
        // Queue<Integer> q=new ArrayDeque<>();
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        // while (!q.isEmpty()) {
        //     System.out.print(q.remove()+" ");
        // }
        // System.out.println();
        System.out.println(FirstNonRepeating("aabccxb"));
        rearrangeQueue(q);
        while (!q.isEmpty()) {
            System.out.print(q.remove()+" ");
        }
        System.out.println();
        Deque<Integer> deque=new LinkedList<>();
        deque.addFirst(3);
        deque.addFirst(2);
        deque.addFirst(1);
        System.out.println(deque);
        deque.removeFirst();
        System.out.println(deque);
    }
}
