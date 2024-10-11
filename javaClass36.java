
import java.util.*;
import java.util.LinkedList;

public class javaClass36 {
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

    public static class BinaryTree{
        static int idx=-1;
        public Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1)
            return null;
            Node newNode=new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;
        }
        public void preorder(Node root){
            if(root==null)
                return;
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
        public void inorder(Node root){
            if(root==null)
            return;
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        public void postorder(Node root){
            if(root==null)
            return;
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }

        public void levelorder(Node root){
            if(root==null)
            return;
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode=q.remove();
                if(currNode==null){
                    // System.out.println();
                    if(q.isEmpty())
                    break;
                    else
                    q.add(null);
                } else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null)
                    q.add(currNode.left);
                    if(currNode.right!=null)
                    q.add(currNode.right);
                }
            }
        }

        public int height(Node root){
            if(root==null)
            return 0;

            int lh=height(root.left);
            int rh=height(root.right);
            return Math.max(lh,rh)+1;
        }
        public int countNodes(Node root){
            if(root==null)
            return 0;
            int lcount=countNodes(root.left);
            int rcount=countNodes(root.right);
            return lcount+rcount+1;
        }

        public int sum(Node root){
            if(root==null)
            return 0;
            int ld=sum(root.left);
            int rd=sum(root.right);
            return ld+rd+root.data;
        }
        // O(N^2)
        public int diam(Node root){
            if(root==null)
            return 0;
            int ldiam=diam(root.left);
            int lh=height(root.left);
            int rdiam=diam(root.right);
            int rh=height(root.right);
            int self=lh+rh+1;
            return Math.max(self,Math.max(ldiam,rdiam));
        }

        static class Info{
            int diam;
            int ht;
            public Info(int diam,int ht){
                this.diam=diam;
                this.ht=ht;
            }
        }
        public Info diameter(Node root){
            if(root==null)
            return new Info(0, 0);
            Info leftInfo=diameter(root.left);
            Info rightInfo=diameter(root.right);

            int diam=Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
            int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;

            return new Info(diam, ht);
        }

        public boolean isIdentical(Node root, Node subRoot){
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
        public boolean isSubTree(Node root, Node subRoot){
                if(root==null)
                return false;
                if(root.data==subRoot.data){
                    if(isIdentical(root,subRoot))
                        return true;
                }
                return isSubTree(root.left, subRoot)||isSubTree(root.right, subRoot);
        }

    }
    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        /*
                        1
                       / \
                      2   3
                     / \   \
                    4   5   6
         */
        BinaryTree tree=new BinaryTree();
        Node root= tree.buildTree(nodes);
        
        tree.preorder(root);
        System.out.println();
        tree.inorder(root);
        System.out.println();
        tree.postorder(root);
        System.out.println();
        tree.levelorder(root);
        System.out.println();
        System.out.println(tree.height(root));
        // System.out.println();
        System.out.println(tree.countNodes(root));
        System.out.println(tree.sum(root));
        System.out.println(tree.diam(root));
        System.out.println(tree.diameter(root).diam);
        
        /*
                      2  
                     / \  
                    4   5   
         */
        Node subRoot=new Node(2);
        subRoot.left=new Node(4);
        subRoot.right=new Node(5);
        System.out.println(tree.isSubTree(root,subRoot));

    }
}
