import java.util.Stack;

public class javaClass33 {
    public static boolean isValid(String str){
        Stack<Character> s=new Stack<>();   
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            //opening
            if(ch=='('||ch=='{'||ch=='[')
                s.push(ch);
            //closing
            else{
                if(s.isEmpty())
                    return false;
                //pair
                 if((s.peek()=='('&&ch==')')
                    ||(s.peek()=='{'&&ch=='}')
                    ||(s.peek()=='['&&ch==']'))
                        s.pop();
                else
                    return false;
            }
        }
        if(s.isEmpty())
         return true;
        return false;
    }

    // Duplicate Parentheses
    public static boolean isDuplicate(String str){
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);

            //closing
            if(ch==')'){
                int count=0;
                while(s.pop()!='('){
                    count++;
                }
                if(count<=1)
                    return true;
            }
            else if(ch=='}'){
                int count=0;
                while(s.pop()!='{'){
                    count++;
                }
                if(count<=1)
                    return true;
            }
            else if(ch==']'){
                int count=0;
                while(s.pop()!='['){
                    count++;
                }
                if(count<=1)
                    return true;
            }
            // opening 
            else{
                s.push(ch);
            }
        }
        return false;
    }

    // Max area in Histogram
    public static int maxAreaHistogram(int heights[]){
        int nextSmallerLeft[]=new int[heights.length];
        int nextSmallerRight[]=new int[heights.length];
        Stack<Integer> s=new Stack<>();

        //for width nextSmaller left
        for(int i=0;i<heights.length;i++){
            while(!s.isEmpty()&&heights[s.peek()]>=heights[i])
                s.pop();
            if(s.isEmpty())
                nextSmallerLeft[i]=-1;
            else
                nextSmallerLeft[i]=s.peek();
            s.push(i);
        }

        s=new Stack<>();
        //for width nextSmaller Right
        for(int i=heights.length-1;i>=0;i--){
            while(!s.isEmpty()&&heights[s.peek()]>=heights[i])
                s.pop();
            if(s.isEmpty())
                nextSmallerRight[i]=heights.length;
            else
                nextSmallerRight[i]=s.peek();
            s.push(i);
        }

        int mx=0;
        for(int i=0;i<heights.length;i++){
            int area=(nextSmallerRight[i]-nextSmallerLeft[i]-1)*heights[i];
            mx=Math.max(area, mx);
        }

        return mx;
    }
    public static void main(String[] args) {
        String str="({})[]";
        System.out.println(isValid(str));
        String str1="((a+b)+(c))";
        System.out.println(isDuplicate(str1));
        int heights[]={2,1,5,6,2,3};
        System.out.println(maxAreaHistogram(heights));
    }
}
