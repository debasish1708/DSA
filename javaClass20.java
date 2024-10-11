public class javaClass20 {
    // Bit-Manipulation...
    public static void oddOrEven(int n){
        if(n==0)
            System.out.println("neither odd nor even");
        else if((n&1)==0)
            System.out.println("Even");
        else
            System.out.println("odd");
    }
    public static int getithbit(int n,int i){
        if((n&(1<<i))==0){
            return 0;
        } else
            return 1;
    }
    public static int setithbit(int n,int i){
        return (n|(1<<i));
    }
    public static int clearithbit(int n,int i){
        // System.out.println(n&(~(1<<i)));
        return n^(1<<i);
    }
    public static int updateithbit(int n,int i,int newBit){
        // if(newBit==0)
        //     return clearithbit(n, i);
        // else
        //     return setithbit(n, i);
        
        n=clearithbit(n, i);
        return n|(newBit<<i);
    }

    public static int clearLastithbits(int n,int i){
        return n&(-1<<i);
    }
    
    public static int clearRangeOfBits(int n,int i,int j){
        int a=-1<<j+1;
        int b=(1<<i)-1;
        return n&(a|b);
    }
    
    public static boolean power2ornot(int n){
        return (n&(n-1))==0;  
    }

    public static int setBits(int n){
        int count=0;
        while (n>0) {
            if((n&1<<0)!=0)
                count++;
            n=n>>1;
        }
        return count;
    }

    public static int fastExpo(int a,int n){
        int ans=1;
        while (n>0) {
            if((n&1)!=0)
                ans=ans*a;
            a*=a;
            n=n>>1;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(5&6);
        System.out.println(6&1);
        System.out.println(5|6);
        System.out.println(5^6);
        System.out.println(~5);
        System.out.println(~0);
        System.out.println(5<<2);
        System.out.println(6>>1);
        System.out.println(8>>2);
        oddOrEven(10);
        System.out.println("ith bit = "+getithbit(10, 2));
        System.out.println(setithbit(10, 2));
        System.out.println(clearithbit(10, 1));
        System.out.println(updateithbit(13, 2, 0));
        System.out.println(clearLastithbits(15, 2));
        System.out.println(clearRangeOfBits(10, 2, 4));
        System.out.println(power2ornot(16));
        System.out.println(setBits(10));
        System.out.println(fastExpo(2, 3));
    }
}
