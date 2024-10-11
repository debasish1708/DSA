import java.util.*;

public class StackB {
    // public static class Stack{
    //     static ArrayList<Integer> list=new ArrayList<>();
    //     public static boolean isEmpty(){
    //         return list.size()==0;
    //     }

    //     //push
    //     public static void push(int data){
    //         list.add(data);
    //     }

    //     //pop
    //     public static int pop(){
    //         if(isEmpty())
    //             return -1;
    //         int top=list.get(list.size()-1);
    //         list.remove(list.size()-1);
    //         return top;
    //     }

    //     //peek
    //     public static int peek(){
    //         if(isEmpty())
    //             return -1;
    //         return list.get(list.size()-1);
    //     }
    // }


    public static void pushAtBottom(Stack<Integer> s, int data){
        // base case
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        //recursion
        int top=s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static String reverseString(String str){
        Stack<Character> s=new Stack<>();
        int idx=0;
        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result=new StringBuilder("");
        while(!s.isEmpty()){
            result.append(s.pop());
        }
        return result.toString();

    }

    //reverse a stack
    // tc=O(n)and sc=O(n)
    public static void reverseStack(Stack<Integer> s){
        Stack<Integer> ans=new Stack<>();
        while(!s.isEmpty()){
            ans.push(s.pop());
        }
        while(!ans.isEmpty()){
            System.out.println(ans.pop());
        }
    }

    // reverse a stack sc=O(1);
    public static void revStack(Stack<Integer> s){
        //base case
        if(s.isEmpty())
            return;
        //recursion
        int top=s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }
    public static void printStack(Stack<Integer> s){
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    // stock span problem
    public static void stockSpan(int stocks[], int span[]){
        Stack<Integer> s=new Stack<>();
        span[0]=1;
        s.push(0);
        for(int i=1;i<stocks.length;i++){
            int currPrice=stocks[i];
            while(!s.isEmpty()&&currPrice>=stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=i+1;
            } else{
                int prevHigh=s.peek();
                span[i]=i-prevHigh;
            }

            s.push(i);
        }
    }

    // Next Greater Element ...
     public static void nextGreaterElement(int arr[]){
        int nextGreater[]=new int[arr.length];
        Stack<Integer> s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while (!s.isEmpty()&&arr[s.peek()]<=arr[i]) {
                s.pop();
            } if(s.isEmpty()){
                nextGreater[i]=-1;
            } else{
                nextGreater[i]=arr[s.peek()];
            }
            s.push(i);
        }
        for(int i=0;i<nextGreater.length;i++){
            System.out.print(nextGreater[i]+" ");
        }
     }
    public static void main(String[] args) {
        // Stack s=new Stack();

        Stack<Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        pushAtBottom(s, 4);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
        System.out.println(reverseString("HelloWorld"));
        s.push(1);
        s.push(2);
        s.push(3);
        // reverseStack(s);
        revStack(s);
        printStack(s);
        
        int stocks[]={100,80,60,70,60,85,100};
        int span[]=new int[stocks.length];
        stockSpan(stocks, span);
        for(int i=0;i<span.length;i++){
            System.out.print(span[i]+" ");
        }
        
        System.out.println();
        int arr[]={6,8,0,1,3};
        nextGreaterElement(arr);
        
    }
}
