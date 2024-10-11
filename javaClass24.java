public class javaClass24 {
    // Recursion ...
    // factorial using iteration
    public static void factorialusingIteration(int n){
        int f=1;
        for(int i=1;i<=5;i++){
            f*=i;
        } System.out.println(f);
    }

    // factorial using Recursion...
    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        int fN=n*factorial(n-1);
        return fN;
    }

    // print numbers from n to 1
    public static void printDec(int n){
        if(n==1){
            System.out.print(n);
            return;
        }
        System.out.print(n+" ");
        printDec(n-1);
    }
    
    // print numbers from 1 to n
    public static void printInc(int n){
        if(n==1){
            System.out.print(n+" ");
            return;
        }
        printInc(n-1);
        System.out.print(n+" ");
    }

    // print sum of first n natural numbers ...
    public static int sum(int n){
        if(n==1)
            return 1;
        return n+sum(n-1);
    }

    // print Nth fibonachi number ...
    public static int fib(int n){
        if(n==0||n==1)
            return n;
        return fib(n-1)+fib(n-2);
    }

    // check if a given array is sorted or not ...
    public static boolean isSorted(int arr[],int i){
        if(i==arr.length-1)
            return true;
        if(arr[i]>arr[i+1])
            return false;
        
        return isSorted(arr, i+1);
    }

    // WAF to find the first occurence of an element in an array
    public static int firstOccurence(int arr1[],int key,int i){
        if(i==arr1.length)
            return -1;
        if(arr1[i]==key)
            return i;
        return firstOccurence(arr1, key, i+1);
    }

    // WAF to find the last occurence of an element in an array
    public static int lastOccurence(int arr1[],int key, int j){
        if(j==-1)
            return -1;
        if(arr1[j]==key)
            return j;
        
        return lastOccurence(arr1, key, j-1);
    }

    // WAF to find the last occurence of an element in an array in alternative method
    public static int lastOccurenceAlternative(int arr1[],int key, int i){
        if(i==arr1.length)
            return -1;
        int isFound=lastOccurenceAlternative(arr1, key, i+1);
        if(isFound==-1&&arr1[i]==key)
            return i;
        return isFound;
    }

    // print x^n ...O(n)
    public static int pow(int x, int n){
        if(n==0)
            return 1;
        return x*pow(x, n-1);
    }

    // print x^n in O(logn)
    public static long powOptimal(int x,int n){
        if(n==0)
            return 1;
        long halfpower=powOptimal(x, n/2);
        long halfpowersq=(halfpower*halfpower)%1000000007;
        if((n&1)==0)
            return halfpowersq%1000000007;
        return (x*halfpowersq)%1000000007;
    }

    // Tiling Problems ...
    public static int tilingProblem(int n){
        if(n==0||n==1)
            return 1;
        return tilingProblem(n-1)+tilingProblem(n-2);
    }
    // Stair case problem ... 
    // it is equivalent to Tiling Problem ...
    public static int stairCaseProblem(int n){
        if(n==0)
            return 1;
        if(n==1||n==2||n==3)
            return n;
        return stairCaseProblem(n-1)+stairCaseProblem(n-2);
    }

    // Remove Duplicates in a String ...
    public static void removeDuplicates(String str,int idx, StringBuilder newStr, boolean map[]){
        if(idx==str.length()){
            System.out.println(newStr);
            return;
        }

        char currChar=str.charAt(idx);
        if(map[currChar-'a']==true){
            //duplicate
            removeDuplicates(str, idx+1, newStr, map);
        } else{
            map[currChar-'a']=true;
            removeDuplicates(str, idx, newStr.append(currChar), map);
        }
    }

    // Friends Pairing Problem ...
    public static int friendPairing(int n){
        if(n==1||n==2)
            return n;
        return friendPairing(n-1)+((n-1)*friendPairing(n-2));
    }

    // Binary String Problem ... for consecutive ones
    public static void printBinString(int n,int lastPlace,String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        printBinString(n-1, 0, str+"0");
        if(lastPlace==0)
            printBinString(n-1, 1, str+"1");
    }

    // Binary String Problem   for consecutive 0s
    public static void printBinString0(int n,int lastPlace,String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        printBinString0(n-1, 1, str+"1");
        if(lastPlace==1)
            printBinString0(n-1, 0, str+"0");
    }


    public static void main(String[] args) {
        // Recursion ...
        int n=5;
        // factorial using Iteration...
        factorialusingIteration(5);
        // factorial using recursion ...
        System.out.println(factorial(n));

        printDec(n);System.out.println();
        printInc(n);System.out.println();

        System.out.println(sum(n));
        
        int pos=5;
        System.out.println(fib(pos));
        System.out.print("First "+pos+" fibonacchi numbers = ");
        for(int i=0;i<=pos;i++){
            System.out.print(fib(i)+" ");
        }

        int arr[]={1,2,3,4,5};
        int i=0;System.err.println();
        System.out.println(isSorted(arr, i));

        int arr1[]={8,3,6,9,5,10,2,5,3};
        int key=5;
        System.out.println(firstOccurence(arr1,key,0));

        int j=arr1.length-1;
        System.out.println(lastOccurence(arr1, key, j));
        System.out.println(lastOccurenceAlternative(arr1, key, 0));

        System.out.println("pow = "+pow(2, 10));
        System.out.println("pow optimal--------");
        System.err.println("pow optimal = "+powOptimal(12, 21));

        System.out.println(tilingProblem(4));
        System.out.println(stairCaseProblem(5));
        String str="appnacollege";
        removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);

        System.out.println(friendPairing(3));
        printBinString(3, 0, "");System.out.println();
        printBinString0(3, 1, "");
        
    }
}
