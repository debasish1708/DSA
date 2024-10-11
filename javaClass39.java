
import java.util.ArrayList;

public class javaClass39 {
    //Bst
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
    public static void inOrder(Node root){
        if(root==null)return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static boolean search(Node root,int key){
        if(root==null)
        return false;
        if(root.data==key)
        return true;
        if(root.data>key)
        return search(root.left,key);
        else
        return search(root.right, key);
    }
    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val)
        root.left=insert(root.left, val);
        else
        root.right=insert(root.right, val);
        return root;
    }


    public static Node inOrderSuccessor(Node root){
        while(root.left!=null)
        root=root.left;
        return root;
    }
    public static Node delete(Node root,int val){
        if(root==null)
        return null;
        if(root.data<val)
        root.right=delete(root.right, val);
        else if(root.data>val)
        root.left=delete(root.left, val);
        else{ //voila
            // case 1 - leaf Node
            if(root.left==null&&root.right==null){
                return null;
            }

            //case 2 - single chile
            if(root.left==null)
            return root.right;
            else if(root.right==null)
            return root.left;

            //case 3 - two children
            Node IS=inOrderSuccessor(root.right);
            root.data=IS.data;
            root.right=delete(root.right, IS.data);

        }
        return root;
    }

    public static void printInRange(Node root,int k1,int k2){
        if(root==null)return;
        if(root.data>=k1&&root.data<=k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        } else if(root.data<k1){
            printInRange(root.right, k1, k2);
        } else
            printInRange(root.left, k1, k2);
    }

    public static void rootToLeafPath(Node root,ArrayList<Integer> path){
        if(root==null)return;
        path.add(root.data);
        if(root.left==null&&root.right==null){
            System.out.println(path);
        }
        rootToLeafPath(root.left, path);
        rootToLeafPath(root.right, path);
        path.remove(path.size()-1);
    }

    public static boolean isValidBST(Node root,Node min,Node max){
        if(root==null)
        return true;
        if(min!=null&&root.data<=min.data)
        return false;
        else if(max!=null&&root.data>=max.data)
        return false;
        return isValidBST(root.left, min, root)&&isValidBST(root.right, root, max);
    }

    //designed by me
    public static void createMirror(Node root){
        if(root==null)return;
        Node temp=root.left;
        root.left=root.right;
        root.right=temp;
        createMirror(root.left);
        createMirror(root.right);
    }
    //designed by shradha didi
    public static Node createMirrorImage(Node root){
        if(root==null)return null;
        Node leftside=createMirrorImage(root.left);
        Node rightside=createMirrorImage(root.right);
        root.left=rightside;
        root.right=leftside;
        return root;
    }

    public static void main(String[] args) {
        //BST
        Node root=new Node(4);
        root.left=new Node(2);
        root.right=new Node(5);
        root.left.left=new Node(1);
        root.left.right=new Node(3);
        root.right.right=new Node(6);
        inOrder(root);System.out.println();
        System.out.println(search(root, 3));
        int values[]={8,5,3,1,4,6,10,11,14};
        Node root1=null;
        for(int i=0;i<values.length;i++){
            root1=insert(root1, values[i]);
        }
        // inOrder(root1);
        // delete(root1, 5);System.out.println();
        // inOrder(root1);System.out.println();

        printInRange(root1, 5, 12);
        ArrayList<Integer> path=new ArrayList<>();
        System.out.println();
        rootToLeafPath(root1, path);
        System.out.println(isValidBST(root1, null, null));
        //creating a new bst for mirroriging it
        Node node=new Node(8);
        node.left=new Node(5);
        node.right=new Node(10);
        node.left.left=new Node(3);
        node.left.right=new Node(6);
        node.right.right=new Node(11);
        // after mirror tree convert
        /*
                        8
                       / \
                     10   5
                    /    / \
                   11   6   3
                   MIrror a bst
         */
        System.out.println("---Before Mirror---");
        inOrder(node);
        System.out.println("\n---afeter Mirror---");
        // createMirror(node);
        node=createMirrorImage(node);
        inOrder(node);
    }
}
