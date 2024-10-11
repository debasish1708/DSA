import java.util.ArrayList;

public class LinkedList {
    // Linked List
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public int size;

    // Methods
    public void addFirst(int data){
        //step-1=create new Node
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }

        //step2= newNode next=head
        newNode.next=head; //link

        //step 3= head=newNode
        head=newNode;
    }

    public void addLast(int data){
        //step1 
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode; //link
        tail=newNode;
    }

    public void add(int idx, int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newNode=new Node(data);
        size++;
        Node temp=head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        // i=idx-1 ; temp-> prev
        newNode.next=temp.next;
        temp.next=newNode;
    }

    public int removeFirst(){
        if(size==0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size==0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;

        }

        // prev i= size-2;
        Node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        int val=prev.next.data;  //tail.data
        prev.next=null;
        tail=prev;
        size--;

        return val;
    }

    public int itrSearch(int key){ //O(n)
        Node temp=head;
        int idx=0;
        while(temp!=null){
            if(temp.data==key)
                return idx;
            temp=temp.next;
            idx++;
        }
        return -1;
    }


    public int helper(Node head, int key){
        if(head==null)
            return -1;
        if(head.data==key)
            return 0;
        int idx=helper(head.next, key);
        if(idx==-1)
            return -1;
        return idx+1;
    }
    public int recSearch(int key){
        return helper(head, key);
    }

    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        head=prev;
    }

    public void deleteNthfromEnd(int n){
        if(size==n){
            head=head.next;
            return;
        }

        // sixe -n
        int i=1;
        int iToFind=size-n;
        Node prev=head;
        while (i<iToFind) {
            prev=prev.next;
            i++;
        }

        prev.next=prev.next.next;
        return;

    }

    // it is iterative method tc=O(n) ans sc= O(n)
    public boolean isPalindromeUsingArrayList(){
        Node temp=head;
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<size;i++){
            ans.add(temp.data);
            temp=temp.next;
        }
        for(int i=0;i<ans.size()/2;i++){
            if(ans.get(i)!=ans.get(ans.size()-1-i))
                return false;
        }

        return true;
    }

    // it is optimized of palindrome tc=O(n) ans sc=O(1)
    public Node findMid(Node head){
        Node slow_ptr=head;
        Node fast_ptr=head;
        while(fast_ptr!=null&&fast_ptr.next!=null){
            slow_ptr=slow_ptr.next;
            fast_ptr=fast_ptr.next.next;;
        }
        // System.out.println(slow_ptr.data);
        return slow_ptr;
    }
    public boolean checkisPalindrome(){
        // step-1 find the mid node
        Node mid=findMid(head);

        if(head==null||head.next==null)
            return true;

        // reverse 2nd half
       Node prev=null;
       Node curr=mid.next;
       Node next;
       while (curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
       }
       Node righthead=prev;
       Node lefthead=head;
       while(lefthead!=null&&righthead!=null){
        if(lefthead.data!=righthead.data)
            return false;
        lefthead=lefthead.next;
        righthead=righthead.next;
       }

        return true;
    }

    public void print(){
        if(head==null){
            System.out.print("LL is empty->");
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    
    public static void main(String[] args) {
        // linked List
        LinkedList ll=new LinkedList();
        // ll.print();
        ll.addFirst(2);
        // ll.print();
        ll.addFirst(1);
        // ll.print();
        ll.addLast(3);
        ll.addLast(2);
        // ll.print();
        ll.addLast(1);
        
        // ll.add(2,3);
        ll.print();
        // System.out.println(ll.size);
        // ll.removeFirst();
        // ll.print();;
        // System.out.println(ll.size);
        // ll.removeLast();
        // ll.print();
        // System.out.println(ll.size);
        System.out.println("found at index = "+ll.itrSearch(2));
        System.out.println("found at index using recursion = "+ll.recSearch(2));
        // ll.reverse();
        // ll.print();
        // ll.deleteNthfromEnd(3);
        ll.print();
        System.out.println(ll.isPalindromeUsingArrayList());
        // System.out.println(ll.checkisPalindrome());
        // ll.print();
        
    }
}



