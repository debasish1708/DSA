import java.util.*;
import java.util.LinkedList;

public class javaClass38 {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    // Kth Level Order Traverse using Iteration Method ...
    public static void KthlevelOrder(Node root,int level){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        int k=1;
        while (!q.isEmpty()) {
            Node curr=q.remove();
            if(k==level){
                while (curr!=null) {
                    System.out.print(curr.data+" ");
                    curr=q.remove();
                }
                break;
            }
            if(curr==null){
                k++;
                if(q.isEmpty())
                break;
                else
                q.add(null);
            } else {
                if(curr.left!=null)
                q.add(curr.left);
                if(curr.right!=null)
                q.add(curr.right);
            }
        }
    }

    // Kth Level Order Traverse using Recursion Method ...
    public static void kthLevel(Node root,int k){
        if(root==null)
        return;
        if(k==1){
            System.out.print(root.data+" ");
            return;
        }
        kthLevel(root.left, k-1);
        kthLevel(root.right, k-1);
    }

    // Lowest Common Ancestor ...
    public static boolean getPath(Node root,int n,ArrayList<Node> path){
        if(root==null)
        return false;
        path.add(root);
        if(root.data==n)
        return true;
        boolean foundLeft=getPath(root.left, n, path);
        boolean foundRight=getPath(root.right, n, path);
        if(foundLeft||foundRight)
        return true;
        path.remove(path.size()-1);
        return false;
    }
    public static Node lca(Node root,int n1,int n2){
        ArrayList<Node> path1=new ArrayList<>();
        ArrayList<Node> path2=new ArrayList<>();
        getPath(root,n1,path1);
        getPath(root, n2, path2);

        int i=0;
        for(; i<path1.size()&&i<path2.size();i++){
            if(path1.get(i)!=path2.get(i))
            break;
        }
        return new Node(path1.get(i-1).data);
    }

    public static Node lca2(Node root,int n1,int n2){
        if(root==null||root.data==n1||root.data==n2)
        return root;
        Node leftLca=lca2(root.left, n1, n2);
        Node rightLca=lca2(root.right, n1, n2);
        if(rightLca==null)
        return leftLca;
        if(leftLca==null)
        return rightLca;
        return root;
    }
    public static int minDist(Node root, int n){
        if(root==null)
        return -1;
        if(root.data==n)
        return 0;
        int leftSearch=minDist(root.left, n);
        int rightSearch=minDist(root.right, n);
        if(leftSearch==-1&&rightSearch==-1)
        return -1;
        return Math.max(leftSearch, rightSearch)+1;
    }
     public static int minDistance(Node root,int n1,int n2){
        Node lca=lca2(root, n1, n2);
        int dist1=minDist(lca, n1);
        int dist2=minDist(lca, n2);
        return dist1+dist2;
     }

     public static int kAncestor(Node root,int n,int k){
        if(root==null)
        return -1;
        if(root.data==n)
        return 0;
        int leftDist=kAncestor(root.left, n, k);
        int rightDist=kAncestor(root.right, n, k);
        if(leftDist==-1&&rightDist==-1)
        return -1;
        if(Math.max(leftDist, rightDist)+1==k)
        System.out.println(root.data);
        return Math.max(leftDist, rightDist)+1;
     }

     public static int transfrom(Node root){
        if(root==null)
        return 0;
        int leftchild=transfrom(root.left);
        int rightchild=transfrom(root.right);
        int data=root.data;
        int newLeft=root.left==null?0:root.left.data;
        int newRight=root.right==null?0:root.right.data;
        root.data=newLeft+leftchild+newRight+rightchild;
        return data;
     }
     public static void preOrder(Node root){
        if(root==null)
        return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
     }

    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        KthlevelOrder(root,3);
        System.out.println();
        kthLevel(root, 3);System.out.println();
        System.out.println(lca(root, 4, 5).data);
        System.out.println(lca2(root, 4, 6).data);
        System.out.println("minDistance = "+minDistance(root, 4, 7));
        kAncestor(root, 5, 1);
        transfrom(root);
        preOrder(root);
    }
}
