public class javaClass15 {
    public static void swap(int a,int b){
      int temp=a;
        a=b;
        b=temp;
        System.out.println("a = "+a);
        System.out.println("b = "+b);  
    }

    public static void sum(int n){
        int totalSum=0;
        for(int i=0;i<=n;i++){
            totalSum=totalSum+i;
        }
        System.out.println("Toal sum = "+totalSum);
    }
    
    public static int factorial(int n){
        int f=1;
        for(int i=1;i<=n;i++){
            f=f*i;
        }
        return f;
    }

    public static int binCoefficient(int n,int r){
        int nfact=factorial(n);
        int rfact=factorial(r);
        int nminusrFact=factorial(n-r);
        int binomialCoefficient=nfact/(rfact*nminusrFact);
        return binomialCoefficient;
    }

    // public static boolean isPrime(int n){
    //     boolean isPrime=true;
    //     for(int i=2;i<=n-1;i++){
    //         if(n%i==0){
    //             isPrime=false;
    //             break;
    //         }
    //     }
    //     return isPrime;
    // }

    //optimized method of isPrime
    public static boolean isPrime(int n){ 
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static void PrimeinRange(int n){
        System.out.print("prime numbers are: ");
        for(int i=2;i<=n;i++){
            if(isPrime(i)==true){
                System.out.print(i+" ");
            }
        }
    }

    public static void binToDec(int binNUm){
        int a=binNUm;
        int pow=0;
        int decNum=0;
        while(binNUm>0){
            int lastDigit=binNUm%10;
            decNum=decNum+(lastDigit*(int)Math.pow(2,pow));
            pow++;
            binNUm=binNUm/10;
        }
        System.out.println();
        System.out.println("Decimal of "+a+" = "+decNum);
    }

    public static void decToBin(int decNum){
        int MyNum=decNum;
        int binNum=0,pow=0;
        System.out.print("Binary of "+MyNum+" = ");
        while(decNum>0){
            int rem=decNum%2;
            binNum=binNum+(rem*(int)Math.pow(10,pow));
            pow++;
            decNum=decNum/2;
        }
        System.out.println(binNum);
    }

    

    public static void main(String[] args) {
        swap(5, 10);
        sum(5);
        System.out.println("factorial = "+factorial(4));
        System.out.println("Binomial Coefficient = "+binCoefficient(5, 2));
        System.out.println(isPrime(2));
        System.out.println(isPrime(500));
        PrimeinRange(100);
        binToDec(101);
        decToBin(8);
    }
}
