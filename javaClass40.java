import java.util.ArrayList;

public class javaClass40 {
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static Node createBst(int arr[],int si,int ei){
        if(si>ei)return null;
        int mid=(si+ei)/2;
        Node root=new Node(arr[mid]);
        if(si==ei)return root;
        root.left=createBst(arr,si,mid-1);
        root.right=createBst(arr,mid+1,ei);
        return root;
    }
    public static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void inorder(Node root,ArrayList<Integer> arr){
        if(root==null)return;
        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }
    public static void preOrder(Node root){
        if(root==null)return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static Node createBst(ArrayList<Integer> arr,int si,int ei){
        if(si>ei)return null;
        int mid=(si+ei)/2;
        Node root=new Node(arr.get(mid));
        root.left=createBst(arr, si, mid-1);
        root.right=createBst(arr, mid+1, ei);
        return root;
    }
    public static Node balanceBst(Node root){
        ArrayList<Integer> arr=new ArrayList<>();
        inorder(root,arr);
        root=createBst(arr, 0, arr.size()-1);
        return root;
    }

    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        public Info(boolean isBST,int size,int min,int max){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }
    public static int maximum;
    public static Info largest(Node root){
        if(root==null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftInfo=largest(root.left);
        Info rightInfo=largest(root.right);
        
        int size=leftInfo.size+rightInfo.size+1;
        int min=Math.min(root.data,Math.min(leftInfo.min,rightInfo.min));
        int max=Math.max(root.data,Math.max(leftInfo.max,rightInfo.max));
        
        if(leftInfo.max>=root.data||rightInfo.min<=root.data)
        return new Info(false,size,min,max);
        
        if(leftInfo.isBST&&rightInfo.isBST){
            maximum=Math.max(maximum,size);
            return new Info(true,size,min,max);
        }
        return new Info(false,size,min,max);
    }

    public static Node merge(Node root1,Node root2){
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        inorder(root1,arr1);
        inorder(root2,arr2);
        int i=0,j=0;
        while(i<arr1.size()&&j<arr2.size()){
            if(arr1.get(i)<arr2.get(j)){
                arr.add(arr1.get(i));
                i++;
            } else{
                arr.add(arr2.get(j));
                j++;
            }
        }
        while(i<arr1.size()){
            arr.add(arr1.get(i));
            i++;
        }
        while(j<arr2.size()){
            arr.add(arr2.get(j));
            j++;
        }
        return createBst(arr, 0, arr.size()-1);
    }

    
    public static void main(String[] args) {
        // Sorted Array to BST
        int arr[]={1,2,3,4,5,6,7,8};
        Node root=createBst(arr,0,arr.length-1);
        preOrder(root);
        /*
                            8
                          /  \
                         6    10
                        /      \
                       5        11
                      /          \
                     3            12
         */
        Node bt=new Node(8);
        bt.left=new Node(6);
        bt.left.left=new Node(5);
        bt.left.left.left=new Node(3);
        bt.right=new Node(10);
        bt.right.right=new Node(11);
        bt.right.right.right=new Node(12);

        /*
                           8
                         /   \
                        5     11
                       / \   /  \
                      3   6  10  12
         */
        System.out.println();
        bt=balanceBst(bt);
        preOrder(bt);System.out.println();
        
        Node root1=new Node(50);
        root1.left=new Node(30);
        root1.left.left=new Node(5);
        root1.left.right=new Node(20);
        root1.right=new Node(60);
        root1.right.left=new Node(45);
        root1.right.right=new Node(70);
        root1.right.right.left=new Node(65);
        root1.right.right.right=new Node(80);
        largest(root1);
        System.out.println("largest size of BST = "+maximum);

        //merge 2 bst
        Node bst1=new Node(2);
        bst1.left=new Node(1);
        bst1.right=new Node(4);

        Node bst2=new Node(9);
        bst2.left=new Node(3);
        bst2.right=new Node(12);

        Node finalBst=merge(bst1,bst2);
        inorder(finalBst);System.out.println();
        preOrder(finalBst);System.out.println();
        
        
    }
}
