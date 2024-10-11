public class javaClass19 {

    public static void printLetters(String fullname){
        for(int i=0;i<fullname.length();i++){
            System.out.print(fullname.charAt(i)+" ");
        }
        System.out.println();
    }
    public static boolean ispalindrome(String str){
        for(int i=0;i<=str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }

    public static float getShortestPath(String path){
        int x=0,y=0;
        for(int i=0;i<path.length();i++){
            char dir=path.charAt(i);
            //south
            if(dir=='S'){
                y--;
            }
            //noth 
            else if(dir=='N'){
                y++;
            }
            //west 
            else if(dir=='W'){
                x--;
            }
            //east 
            else
                x++;
        }
        System.out.println(x+","+y);
        if(x>0){
            for(int i=0;i<x;i++){
                System.out.print("E");
            }
        } else if(x<0){
            for(int i=0;i>x;i--){
                System.out.print("W");
            }
        } if(y>0){
            for(int i=0;i<y;i++){
                System.err.print("N");
            }
        } else if(y<0){
            for(int i=0;i>y;i--){
                System.out.print("S");
            }
        }
        System.out.println();
        return (float)Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
    }

    public static String subString(String str1,int si,int ei){
        String substr="";
        for(int i=si;i<ei;i++){
            substr+=str1.charAt(i);
        }
        return substr;
    }
    public static String toUpperCase(String str2){
        StringBuilder sb=new StringBuilder("");

        char ch=Character.toUpperCase(str2.charAt(0));
        sb.append(ch);
        for(int i=1;i<str2.length();i++){
            if(str2.charAt(i)==' '&& i<str2.length()-1){
                sb.append(str2.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str2.charAt(i)));
            } else
                sb.append(str2.charAt(i));
        }
        return sb.toString();
    }
    public static String compressString(String compress){
        String newStr="";
        for(int i=0;i<compress.length();i++){
            Integer count=1;
            while(i<compress.length()-1 && compress.charAt(i)==compress.charAt(i+1)){
                count++;
                i++;
            } 
            newStr+=compress.charAt(i);
            if(count>1){
                newStr+=count.toString();
            }
        }
        return newStr;
    }
    public static String compressStringUsingStringBuilder(String compress){
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<compress.length();i++){
            Integer count=1;
            while(i<compress.length()-1 && compress.charAt(i)==compress.charAt(i+1)){
                count++;
                i++;
            } 
            sb.append(compress.charAt(i));
            if(count>1){
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // char arr[]={'a','b','c','d'};
        // String str="abcd";
        // String str2=new String("xyz");

        // // Strings are IMMUTABLE..

        // Scanner sc=new Scanner(System.in);
        // String name=sc.nextLine();
        // System.out.println(name);

        String fullname="Tony Stark";
        // System.out.println(fullname.length());

        // //concatenation
        // String firstName="Debasish";
        // String lastName="Das";
        // String fname=firstName+" "+lastName;
        // System.out.println(fname);
        // System.out.println(fname.charAt(1));
        // System.out.println(fname.length());

        printLetters(fullname);
        String str="racecar";
        System.out.println(ispalindrome(str));
        String path="WNEENESENNN";
        System.out.println(getShortestPath(path));
        String s1="Debasish";
        String s2="Debasish";
        String s3=new String("Debasish");
        if(s1==s2){
            System.out.println("Strings are equal");
        } else
            System.out.println("strings are not equal");
        
        if(s1==s3){
            System.out.println("Strings are equal");
        } else
            System.out.println("strings are not equal");
        
        if(s1.equals(s3)){
            System.out.println("Strings are equal");
        } else
            System.out.println("strings are not equal");
        String str1="HelloWorld";
        System.out.println(str1.substring(0,5));
        // System.out.println(subString(str1, 0, 5));

        String fruits[]={"apple","mango","banana"};
        String largest=fruits[0];
        for(int i=1;i<fruits.length;i++){
            if(largest.compareTo(fruits[i])<0){
                largest=fruits[i];
            }
        }
        System.out.println(largest);
        StringBuilder sb=new StringBuilder("");
        for(char ch='a';ch<='z';ch++){
            sb.append(ch);
        }   
        System.out.print(sb);
        System.out.println("\n"+sb.length());

        String str2="hi, i am debaish das";
        System.out.println(toUpperCase(str2));

        String compress="aaabbcccdd";
        System.out.println(compressString(compress));
        System.out.println(compressStringUsingStringBuilder(compress));
    }
}
