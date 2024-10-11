

public class javaClass43 {
    static class Node{
        Node[] children;
        boolean eow;
        public Node(){
            children=new Node[26]; // a to z
            for(int i=0;i<26;i++) children[i]=null;
            eow=false;
        }
    }

    static Node root=new Node();

    public static void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                // add new Node;
                curr.children[idx]=new Node();
            }
            if(i==word.length()-1)curr.children[idx].eow=true;
            curr=curr.children[idx];
        }
    }


    public static boolean search(String key){
        Node curr=root;
        for(int i=0;i<key.length();i++){
            int idx=key.charAt(i)-'a';
            Node node=curr.children[idx];
            if(node==null)return false;
            if(i==key.length()-1&&node.eow!=true)return false;
            curr=curr.children[idx];
        }
        return true;
    }
    public static boolean wordBreak(String key){
        if(key.length()==0)return true;
        for(int i=1;i<=key.length();i++){
            String FirstPart=key.substring(0, i);
            String SecondPart=key.substring(i);
            if(search(FirstPart)&&wordBreak(SecondPart))return true;
        }
        return false;
    }
    public static boolean startWithProblem(String key){
        Node curr=root;
        for(int i=0;i<key.length();i++){
            int idx=key.charAt(i)-'a';
            if(curr.children[idx]==null)return false;
            curr=curr.children[idx];
        }
        return true;
    }
    // static int count=0;
    public static int countNode(Node root){
        if(root==null)return 0;
        int count=0;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                count+=countNode(root.children[i]);
                // System.out.print(count+"->"+i+" ");
                // count++;countNode(root.children[i]);
            }
        }
        return count+1;
    }
    // Longest WOrd with all Prefixes
    public static String ans="";
    public static void longestWord(Node root,StringBuilder temp){
        if(root==null)return;
        for(int i=0;i<26;i++){
            if(root.children[i]!=null&&root.children[i].eow==true){
                temp.append((char)(i+'a'));
                if(temp.length()>ans.length()){
                    ans=temp.toString();
                }
                longestWord(root.children[i],temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    // Shortest Unique prefix for every word
    static class TrieNode{
        TrieNode[] children;
        int freq;
        public TrieNode(){
            children=new TrieNode[26];
            for(int i=0;i<26;i++)children[i]=null;
            freq=0;
        }
    }

    static TrieNode root1=new TrieNode();
    public static void insert(TrieNode root,String word){
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(root.children[idx]==null){
                root.children[idx]=new TrieNode();
                root.children[idx].freq=1;
            } else root.children[idx].freq+=1;
            root=root.children[idx];
        }
    }
    
    public static String search(TrieNode root,String key){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<key.length();i++){
            int idx=key.charAt(i)-'a';
            sb.append(key.charAt(i));
            if(root.children[idx].freq==1)break;
            root=root.children[idx];
        }
        
        return sb.toString();
    }



    public static void main(String[] args) {
        // Trie Data Structure
        // String[] words={"the","a","there","their","any"};
        // for(int i=0;i<words.length;i++){
        //     insert(words[i]);
        // }
        
        // System.out.println(search("their"));
        // System.out.println(search("thor"));
        // System.out.println(search("an"));

        // String[] Dictionary={"i","like","sam","samsung","mobile","ice"};
        // String key="ilikesamsung";
        // for(int i=0;i<Dictionary.length;i++)insert(Dictionary[i]);
        // System.out.println("possible word break = "+wordBreak(key));
        
        // System.out.println(startWithProblem("thei"));
        // System.out.println(startWithProblem("b"));
        // System.out.println(startWithProblem("an"));
        // System.out.println(startWithProblem("these"));


        // String str="apple";

        // for(int i=0;i<str.length();i++){
        //     String sufflix=str.substring(i);
        //     insert(sufflix);
        // }

        // System.out.println(countNode(root));
        // countNode(root);
        // System.out.println(count+1);

        //Longest word with all Prefixes

        String word[]={"a","banana","app","appl","ap","apply","apple"};;
        for(int i=0;i<word.length;i++){
            insert(word[i]);
        }

        longestWord(root, new StringBuilder(""));
        System.out.println(ans);


        String[] arr={"zebra", "dog", "duck", "dove"};
        int N=4;
        for(int i=0;i<N;i++)insert(root1,arr[i]);
         String[] ans=new String[N];
         for(int i=0;i<N;i++){
             String unique=search(root1,arr[i]);
             ans[i]=unique;
         }
        
         for(String i:ans)System.out.print(i+" ");

    }   
}
