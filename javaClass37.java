import java.util.*;
import java.util.LinkedList;


public class javaClass37 {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static boolean isIdentical(Node root, Node subRoot){
        if(root==null&&subRoot==null)
        return true;
        else if(root==null||subRoot==null||root.data!=subRoot.data)
        return false;

        if(!isIdentical(root.left, subRoot.left))
        return false;
        if(!isIdentical(root.right, subRoot.right))
        return false;

        return true;
    }
    public static boolean isSubTree(Node root, Node subRoot){
            if(root==null)
            return false;
            if(root.data==subRoot.data){
                if(isIdentical(root,subRoot))
                    return true;
            }
            return isSubTree(root.left, subRoot)||isSubTree(root.right, subRoot);
    }

    static class Info {
        Node node;
        int hd;
        public Info(Node node,int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    public static void TopView(Node root){
        //level Order
        int min=0,max=0;
        Queue<Info> q=new LinkedList<>();
        HashMap<Integer,Node> map=new HashMap<>();
        q.add(new Info(root, 0));
        q.add(null);
        
        while (!q.isEmpty()) {
            Info curr=q.remove();
            if(curr==null){
                if(q.isEmpty())
                break;
                else
                q.add(null);
            }
            else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }
                if(curr.node.left!=null){
                    q.add(new Info(curr.node.left, curr.hd-1));
                    min=Math.min(min,curr.hd-1);
                }
                if(curr.node.right!=null){
                    q.add(new Info(curr.node.right, curr.hd+1));
                    max=Math.max(max,curr.hd+1);
                }
            }
        }

        for(int i=min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
    }

    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.right=new Node(4);
        root.left.right.right=new Node(5);
        root.left.right.right.right=new Node(6);
        TopView(root);System.out.println();

        Node subRoot=new Node(4);
        subRoot.right=new Node(5);
        subRoot.right.right=new Node(6);
        System.out.println(isSubTree(root,subRoot));
    }
}
