import java.util.Deque;
import java.util.LinkedList;

public class StackandQueueDeque {
    static class Stack {
        static Deque<Integer> deque=new LinkedList<>();
        public static void push(int x){
            deque.addLast(x);
        }
        public static int pop(){
            return deque.removeLast();
        }
        public static int peek(){
            return deque.getLast();
        }
        public static boolean isEmpty(){
            return deque.isEmpty();
        }
    }
    
    static class Queue{
        static Deque<Integer> deque=new LinkedList<>();
        public static void add(int x){
            deque.addLast(x);
        }
        public static int remove(){
            return deque.removeFirst();
        }
        public static int peek(){
            return deque.getFirst();
        }
        public static boolean isEmpty(){
            return deque.isEmpty();
        }
    }
    public static void main(String[] args) {
        // Stack s=new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // while (!s.isEmpty()) {
        //     System.out.println(s.pop());
        // }

        // Queue q=new Queue();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // while (!q.isEmpty()) {
        //     System.out.print(q.remove()+" ");
        // }
            
    }
}
