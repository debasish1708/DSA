import java.util.*;

public class QueueTwoStacks {
    // public static class Queue{
    //     static Stack<Integer> s1=new Stack<>();
    //     static Stack<Integer> s2=new Stack<>();

    //     // isEmpty
    //     public static boolean isEmpty(){
    //         return s1.isEmpty();
    //     }
    //     // add
    //     public static void add(int data){
    //         while(!s1.isEmpty())
    //             s2.push(s1.pop());
    //         s1.push(data);
    //         while(!s2.isEmpty())
    //             s1.push(s2.pop());
    //     }

    //     //peek
    //     public static int peek(){
    //         if(isEmpty()){
    //             System.out.println("queue is empty");
    //             return -1;
    //         }
    //         return s1.peek();
    //     }

    //     //remove
    //     public static int remove(){
    //         if(isEmpty()){
    //             System.out.println("queue is empty");
    //             return -1;
    //         }
    //         return s1.pop();
    //     }
    // }
    public static class Queue{
       static Stack<Integer> s1=new Stack<>();
       static Stack<Integer> s2=new Stack<>();
        //add
        public static void add(int data){
            s1.push(data);
        }
        public static boolean isEmpty(){
            return s1.isEmpty();
        }
        //remove
        public static int remove(){
            while (!s1.isEmpty())
            s2.push(s1.pop());
            int result=s2.pop();
            while (!s2.isEmpty())
            s1.push(s2.pop());
            return result;
        }
        //peek
        public static int peek(){
            while (!s1.isEmpty())
            s2.push(s1.pop());
            int result=s2.peek();
            while (!s2.isEmpty())
            s1.push(s2.pop());
            return result;
        }
    }
    public static void main(String[] args) {
        // Queue q=new Queue();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        
        // while (!q.isEmpty()) {
        //     System.out.print(q.remove()+" ");
        // }
    }
}
