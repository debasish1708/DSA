import java.util.*;
public class javaRevision {

    public static void useTernary(int n){
        String a=(n%2==0)?"even":"odd";
        System.out.println(a);
    }
    public static void sum(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=i;
        }System.out.println("sum = "+sum);
    }
    public static void printReverse(int n){
        System.out.print("Reverse = ");
        while(n>0){
            int lastDigit=n%10;
            System.out.print(lastDigit);
            n/=10;
        }
    }

    // Pattern practice...
    public static void Butterfly_pattern(int n){
        //outer loop for 1st half
        for(int i=1;i<=n;i++){
            //inner loop for 1st half
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        // outer loop for 2nd half
        for(int i=1;i<=n;i++){
            //inner loop for 2nd half
            for(int j=1;j<=n-i+1;j++){
                System.out.print("*");
            }
            for(int j=1;j<=2*(i-1);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n-i+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void Hollow_Rhombus(int n){
        //outer loop
        for(int i=1;i<=n;i++){
            //inner loop
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                if(j==1||j==n||i==1||i==n){
                    System.out.print("* ");
                } else
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void Diamond(int n){
        //outer loop for 1st half
        for(int i=1;i<=n;i++){
            //inner loop for 2nd half
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i+(i-1);j++){
                System.out.print("*");
            }
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
        //outer loop for 2nd half
        for(int i=1;i<=n;i++){
            //inner loop for 2nd half
            for(int j=1;j<=i-1;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=1+2*(n-i);j++){
                System.out.print("*");
            }
            for(int j=1;j<=i-1;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void palindromic_pattern(int n){
        //outer loop
        for(int i=1;i<=n;i++){
            //inner loop
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=i;j>=1;j--){
                System.out.print(j);
            }
            for(int j=2;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void factorial(int n){
        int f=1;
        for(int i=1;i<=n;i++){
            f=f*i;
        }
        System.out.print(f);
    }

    public static boolean prime(int n){
        boolean a=true;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i == 0){
                a=false;return a;
            } else
            a=true;
        }
        return true;
    }

    public static void printprimeRange(int n){
        for(int i=2;i<=n;i++){
            if(prime(i)==true){
                System.out.print(i+" ");
            }
        }
    }

    public static void B2D(int n){
        int sum=0;int i=0;
        while(n>0){
            int l_d=n%10;
            sum+=(l_d*(int)(Math.pow(2, i)));
            i++;
            n/=10;

        }
        System.out.print(sum);
    }

    public static void D2B(int n){
        int sum=0,i=0;
        while (n>0) {
            int l_d=n%2;
            sum+=l_d*Math.pow(10, i);
            i++;
            n/=2;
        } 
        System.out.println(sum);
    }

    public static int binarySearch(int arr[],int key){
        int start=0,end=arr.length-1;
        while (start<=end) {
            int mid=(int)(start+end)/2;
            if(arr[mid]==key){
                return mid;
            } else if(arr[mid]<key){
                start=mid+1;
            } else
            end=mid-1;
        }
        return -1;
    }

    // this is taking a time complexity of O(1)-it is a optimal time complexity
    public static void reverse(int arr[]){
        int start=0,end=arr.length-1;
        while (start<end) {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    public static void pairsArray(int arr[]){
        int tp=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                System.out.print("("+arr[i]+","+arr[j]+")");
                tp++;
            }
            System.out.println();
        }
        System.out.println(tp);
    }

    public static void printSubarray(int arr[]){
        int tsa=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                } System.out.print(" ");tsa++;
            }
            System.out.println();
        }
        System.out.println(tsa);
    }
    public static void printSubarraySum(int arr[]){
        int tsa=0;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                for(int k=j;k<=j;k++){
                    sum+=arr[k];System.out.print(sum+" ");
                } System.out.print(" ");tsa++;
            }
            System.out.println();
        }
        System.out.println(tsa);
    }

    public static void printMaxSubArraySum(int arr[]){
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                for(int k=j;k<=j;k++){
                    sum+=arr[k];
                    if(sum>max){
                        max=sum;
                    }
                    if(sum<min){
                        min=sum;
                    }
                }
            }
        }
        System.out.println();
        System.out.println(max);
        System.out.println(min);
    }

    public static void printMaxSubArraySumUsingPrefixArray(int arr1[]){
        int maximum=Integer.MIN_VALUE,minimum=Integer.MAX_VALUE;
        int prefix[]=new int[arr1.length];
        prefix[0]=arr1[0];
        for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i-1]+arr1[i];
        }
        System.out.print("prefix array = ");
        for(int i=0;i<prefix.length;i++){
            System.out.print(prefix[i]+" ");
        }
        System.out.println();
        for(int i=0;i<prefix.length;i++){
            for(int j=i;j<prefix.length;j++){
                int sum=i==0?prefix[j]:prefix[j]-prefix[i-1];
                System.out.print(sum+" ");
                maximum=Math.max(maximum, sum);
                minimum=Math.min(minimum, sum);
            }
            System.out.println();

        }
        System.out.println("\nmax sum = "+maximum);
        System.out.println("min sum = "+minimum);
    }

    public static void printMaxSubarrayUsingKadansAlgorithm(int arr2[]){
        int cs=0,ms=Integer.MIN_VALUE;
        boolean kadanes=true;
        for(int i=0;i<arr2.length;i++){
            if(arr2[i]<0){
                kadanes=false;
            } else{
                kadanes=true;break;
            }
        }
        if(kadanes){
            for(int i=0;i<arr2.length;i++){
                if(cs+arr2[i]<0){
                    cs=0;
                } else
                    cs+=arr2[i];
                ms=Math.max(ms, cs);
            }
            System.out.println("max sum using kadanes = "+ms);
        } else {
            for(int i=0;i<arr2.length;i++){
                ms=Math.max(ms, arr2[i]);
            }
            System.out.println("max sum using kadanes = "+ms);
        }

    }
    
    public static void trappingRainWater(int boundry[]){
        int leftMaxboundry[]=new int[boundry.length];
        int rightMaxboundry[]=new int[boundry.length];
        leftMaxboundry[0]=boundry[0];
        for(int i=1;i<leftMaxboundry.length;i++){
            leftMaxboundry[i]=Math.max(boundry[i], leftMaxboundry[i-1]);
        }
        for(int i=0;i<leftMaxboundry.length;i++){
            System.out.print(leftMaxboundry[i]+" ");
        }
        rightMaxboundry[rightMaxboundry.length-1]=boundry[boundry.length-1];
        for(int i=rightMaxboundry.length-2;i>=0;i--){
            rightMaxboundry[i]=Math.max(boundry[i], rightMaxboundry[i+1]);
        } System.out.println();
        for(int i=0;i<rightMaxboundry.length;i++){
            System.out.print(rightMaxboundry[i]+" ");
        }

        int tw=0;
        for(int i=0;i<boundry.length;i++){
            int wl=Math.min(leftMaxboundry[i], rightMaxboundry[i]);
            tw+=wl-boundry[i];
        } System.out.println();
        if(tw==0)
            System.out.println("there is no right boundry for trapping the rain water");
        else
            System.out.println("trapping rain water = "+tw+" litre");
    }

    public static int buyandSellStocks(int stock[]){
        int buyprice=Integer.MAX_VALUE,maxprofit=0;
        for(int i=0;i<stock.length;i++){
            if(buyprice<stock[i]){
                int profit=stock[i]-buyprice;
                maxprofit=Math.max(maxprofit, profit);
            } else
                buyprice=stock[i];
        }
        return maxprofit;
    }

    public static int ShortSellingStock(int stock[]){
        int sellPrice=Integer.MIN_VALUE,maxprofit=0;
        for(int i=0;i<stock.length;i++){
            if(sellPrice>stock[i]){
                int profit=sellPrice-stock[i];
                maxprofit=Math.max(maxprofit, profit);
            } else
                sellPrice=stock[i];
        }
        return maxprofit;
    }

    //sorting algorithm...
    //bubble sorting
    public static void bubbleSort(int arr3[]){
        for(int i=0;i<arr3.length-1;i++){
            for(int j=0;j<=arr3.length-2-i;j++){
                if(arr3[j]>arr3[j+1]){
                    int temp=arr3[j];
                    arr3[j]=arr3[j+1];
                    arr3[j+1]=temp;
                }
            }
        }
        for(int i=0;i<arr3.length;i++){
            System.out.print(arr3[i]+" ");
        }
    }

    //Selection sorting...
    public static void selectionSort(int arr4[]){
        for(int i=0;i<arr4.length-1;i++){
            int smallest=i;
            for(int j=i+1;j<=arr4.length-1;j++){
                if(arr4[smallest]>arr4[j]){
                    smallest=j;
                }
            }
            //swaping... 
            int temp=arr4[smallest];
            arr4[smallest]=arr4[i];
            arr4[i]=temp;
        }
        for(int i=0;i<arr4.length;i++){
            System.out.print(arr4[i]+" ");
        }
    }
    //insertion sorting ...O(n^2)
    public static void insertionSort(int arr5[]){
        // Idea is pick an element from unsorted part and place
        // it to the right position in sorted part
        for(int i=1;i<arr5.length;i++){
            int curr=arr5[i];
            int prev=i-1;
            while (prev>=0&&arr5[prev]>curr) {
                arr5[prev+1]=arr5[prev];
                prev--;
            }
            arr5[prev+1]=curr;
        }
        for(int i=0;i<arr5.length;i++){
            System.out.print(arr5[i]+" ");
        }
    }

    //counting sort...~=O(n)
    public static void countingSort(int arr9[]){
        //it is best case for +ve low range
        //if quantity is very much but the value is low then it is an optimize algorithm...
        int duplicateArray[]=new int[arr9.length];
        for(int i=0;i<duplicateArray.length;i++){
            duplicateArray[arr9[i]]++;
        }
        //sorting...
        int j=0;
        for(int i=0;i<duplicateArray.length;i++){
            while(duplicateArray[i]>0){
                arr9[j]=i;
                duplicateArray[i]--;
                j++;
            }
        }
        for(int i=0;i<arr9.length;i++){
            System.out.print(arr9[i]+" ");
        }
    }

    //2-d array or matrix
    //spiral matrix
    public static void spiralMatrix(int arr10[][]){
        int startRow=0,endRow=arr10.length-1,startCol=0,endCol=arr10[0].length-1;
        while (startRow<=endRow&&startCol<=endCol) {
            //top
            for(int i=startRow;i<=endCol;i++){
                System.out.print(arr10[startRow][i]+" ");
            }
            //right
            for(int i=startRow+1;i<=endRow;i++){
                System.out.print(arr10[i][endCol]+" ");
            }
            //buttom
            for(int i=endCol-1;i>=startCol;i--){
                if(startRow==endRow){
                    break;
                }
                System.out.print(arr10[endRow][i]+" ");
            }
            //left
            for(int i=endRow-1;i>=startRow+1;i--){
                if(startCol==endCol){
                    break;
                }
                System.out.print(arr10[i][startCol]+" ");
            }
            startRow++;
            endCol--;
            endRow--;
            startCol++;
        }
    }

    //Diagonal sum
    public static void diagonalSum(int arr10[][]){
        int sum=0;
        for(int i=0;i<arr10.length;i++){
            sum+=arr10[i][i];
            if(arr10[i][arr10.length-1-i]!=arr10[i][i]){
                sum+=arr10[i][arr10.length-1-i];
            }
        }
        System.out.println(sum);
    }

    //StairCase Search for sorted Matrix...  top right approach
    public static boolean stairCaseSearch(int sortedMatrix[][],int keys){
        // topright approach...
        int row=0,col=sortedMatrix[0].length-1;
        while (row<=sortedMatrix.length-1&&col>=0) {
            if(sortedMatrix[row][col]==keys){
                System.out.println("key is found at index: ("+row+","+col+")");return true;
            }
            else if(keys<sortedMatrix[row][col])
                col--;
            else
                row++;
        }
        System.out.println("key is not found");
        return false;
    }

    //stair case search for sorted matrix... buttom left approach
    public static boolean stairCaseSearchSortedMatrix(int sortedMatrix[][],int keys){
        int row=sortedMatrix.length-1,col=0;
        while (row>=0&&col<=sortedMatrix[0].length-1) {
            if(sortedMatrix[row][col]==keys){
                System.out.println("key is found at index: ("+row+","+col+")");return true;
            } else if(keys<sortedMatrix[row][col])
                row--;
            else
                col++;
        }
        System.out.println("key is not found");
        return false;
    }

    // Chapter Strings
    // Strings are immutable in java languages
    public static boolean checkPalindrome(String str){
        for(int i=0;i<=str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static String shortestPath(String path){
        int x=0,y=0;
        StringBuilder str=new StringBuilder("");
        for(int i=0;i<path.length();i++){
            if(path.charAt(i)=='W')
                x--;
            else if(path.charAt(i)=='E')
                x++;
            else if(path.charAt(i)=='N')
                y++;
            else
                y--;
        }
        System.out.println(Math.sqrt(x*x+y*y));
        if(x>0){
            for(int i=0;i<x;i++){
                // System.out.print("E");
                str.append('E');
            }
        } else if(x<0){
            for(int i=0;i>x;i--){
                // System.out.print("W");
                str.append('W');
            }
        } if(y>0){
            for(int i=0;i<y;i++){
                // System.err.print("N");
                str.append('N');
            }
        } else if(y<0){
            for(int i=0;i>y;i--){
                // System.out.print("S");
                str.append('S');
            }
        }
        return str.toString();
    }

    public static void printSubString(String str1,int si,int ei){
        String str="";
        for(int i=si;i<=ei;i++){
            str+=str1.charAt(i);
        }
        System.out.println(str);
    }

    public static String printtoUpperCase(String str2){
        StringBuilder sb=new StringBuilder("");
        sb.append(Character.toUpperCase(str2.charAt(0)));
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

    public static String printCompress(String compress){
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<compress.length();i++){
            Integer count=1;
            while (i<compress.length()-1&&compress.charAt(i)==compress.charAt(i+1)) {
                count++;
                i++;
            }
            sb.append(compress.charAt(i));
            if(count>1)
                sb.append(count.toString());
        }
        return sb.toString();
    }

    public static String printDecompress(String decompress){
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<decompress.length();i++){
            if(Character.isDigit(decompress.charAt(i))){
                int digitValue = Character.getNumericValue(decompress.charAt(i));
                if(digitValue==1){
                    sb.append(decompress.charAt(i-1));
                }
                while (digitValue>1) {
                    sb.append(decompress.charAt(i-1));
                    digitValue--;
                }
            } else
                sb.append(decompress.charAt(i));
        }
        return sb.toString();
    }

    //Bit-Manipulation ...
    // is odd or even in bit manipulation ...
    public static boolean isOddEven(int n){
        return (n&1<<0)==0;
    }

    //get ith bit
    public static int getithBit(int n,int i){
        if((n&(1<<i))==0)
            return 0;
        else
            return 1;
    }

    public static int setithBit(int n,int i){
        return (n|1<<i);
    }

    public static int clearithBit(int n,int i){
        return n&(~(1<<i));
    }
    public static int updateithBit(int n,int i,int newBit){
        n=clearithBit(n, i);
        return n|newBit<<i;
    }

    public static int clearLastithBit(int n,int i){
        return n&-1<<i;
    }

    public static int clearRangeofBits(int n,int i,int j){
        int a=-1<<j+1;
        int b=1<<i-1;
        int BitMask=a|b;
        return n&BitMask;
    }
    public static boolean power2ornot(int n){
        return (n&n-1)==0;
    }
    public static int countSetBit(int n){
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
                ans*=a;
            a*=a;
            n=n>>1;
        }
        return ans;
    }
    

    // Recursion ...
    // print 1 t n by recursion
    public static void printNum(int n){
        if(n==1){
            System.out.print(n+" ");
            return;
        }

        printNum(n-1);
        System.out.print(n+" ");

    }

    // print n to 1
    public static void printNum1(int n){
        if(n==1){
            System.out.print(n+" ");
            return;
        }

        System.out.print(n+" ");
        printNum1(n-1);
    }

    
    // geeks for geeks
    public static int circularSubarraySum(int a[], int n) {
        
        // Your code here
        boolean d=true;
        int cs=0,ms=Integer.MIN_VALUE;
        
        int b[]=new int[n];
        b[0]=a[n-1];
        for(int i=1,j=0;j<n-1;i++,j++){
            b[i]=a[j];
        }

        for(int i=0;i<b.length;i++){
            System.out.print(b[i]+" ");
        }
        
        // for all negative value
        for(int i=0;i<b.length;i++){
            if(b[i]<0){
                d=false;
            } else{
                d=true;break;
            }
        }
        
        
        if(d==true){
            for(int i=0;i<b.length;i++){
            if(b[i]+cs<0){
                cs=0;
            } else{
                cs+=b[i];
            }
            ms=Math.max(ms,cs);
            }
        } 
         
        else{
            for(int i=0;i<b.length;i++){
                ms=Math.max(ms,b[i]);
            }
        }
        
        return ms;
    }
    
    public static void main(String[] args) {
        // revision previous question..

        // use ternary operator to check even or odd..
        useTernary(11);
        //sum of first natural number..
        sum(4);
        // print reverse of n
        printReverse(10899);
        System.out.println();
        Butterfly_pattern(4);
        Hollow_Rhombus(5);
        Diamond(4);
        palindromic_pattern(5);
        factorial(5);
        System.out.println();
        System.out.println(prime(17));
        printprimeRange(100);
        System.out.println();
        B2D(1111);
        System.out.println();
        D2B(11);
        int arr[]={2,4,6,8,10};
        int key=10;
        System.out.println(binarySearch(arr, key));
        reverse(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        reverse(arr);System.out.println();
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        pairsArray(arr);
        printSubarray(arr);
        printSubarraySum(arr);
        printMaxSubArraySum(arr);
        int arr1[]={1,-2,6,-1,3};
        printMaxSubArraySumUsingPrefixArray(arr1);
        int arr2[]={-2,-3,4,-1,-2,1,5,-3};
        // int arr2[]={-1,-2,-3,-4,-5};
        printMaxSubarrayUsingKadansAlgorithm(arr2);
        int boundry[]={4,2,0,6,3,2,5};
        trappingRainWater(boundry);
        int stock[]={7,1,5,3,6,4};
        System.out.println("max profit = "+buyandSellStocks(stock));
        System.out.println("max profit shortselling = "+ShortSellingStock(stock));
        int arr3[]={5,4,1,3,2};
        bubbleSort(arr3); System.out.println();
        int arr4[]={5,4,1,3,2};
        selectionSort(arr4);System.out.println();
        int arr5[]={5,4,1,3,2};
        insertionSort(arr5);System.out.println();
        //inbuilt sorting...
        int arr6[]={5,4,1,3,2};
        Arrays.sort(arr6,0,arr6.length);
        for(int i=0;i<arr6.length;i++){
            System.out.print(arr6[i]+" ");
        }
        //for reverse order...
        System.out.println();
        Integer arr7[]={5,4,1,3,2};
        Arrays.sort(arr7,Collections.reverseOrder());
        for(int i=0;i<arr7.length;i++){
            System.out.print(arr7[i]+" ");
        }
        System.out.println();
        Integer arr8[]={5,4,1,3,2};
        Arrays.sort(arr8,0,arr8.length,Collections.reverseOrder());
        for(int i=0;i<arr8.length;i++){
            System.out.print(arr8[i]+" ");
        }
        System.out.println();
        System.out.println("counting sort");
        int arr9[]={1,4,1,3,2,4,3,7};
        countingSort(arr9);

        //2-D array or Matrix
        System.out.println();
        int k=0;
        int arr10[][]=new int[4][4];
        for(int i=0;i<arr10.length;i++){
            for(int j=0;j<arr10[0].length;j++){
                arr10[i][j]=k+1;
                k++;
            }
        }
        // print matrix
        for(int i=0;i<arr10.length;i++){
            for(int j=0;j<arr10[0].length;j++){
                System.out.print(arr10[i][j]+" ");
            } System.out.println();
        }
        spiralMatrix(arr10);System.out.println();
        diagonalSum(arr10);

        int sortedMatrix[][]={{10,20,30,40},
                              {15,25,35,45},
                              {27,29,37,48},
                              {32,33,39,50}};
        for(int i=0;i<sortedMatrix.length;i++){
            for(int j=0;j<sortedMatrix[0].length;j++){
                System.out.print(sortedMatrix[i][j]+" ");
            }System.out.println();
        }
        int keys=32;
        stairCaseSearch(sortedMatrix,keys);
        stairCaseSearchSortedMatrix(sortedMatrix, keys);
        String str="racecar";
        System.out.println(checkPalindrome(str));
        String path="WNEENESENNN";
        System.out.println(shortestPath(path));

        //print the largest string
        String fruits[]={"apple","mango","banana"};
        String largest=fruits[0];
        for(int i=1;i<fruits.length;i++){
            if(fruits[i].compareTo(largest)>0){
                largest=fruits[i];
            }
        }
        System.out.println(largest);
        String str1="Debasish";
        int si=1,ei=4;
        printSubString(str1, si, ei);

        String str2="hi, i am debaish das";
        System.out.println(printtoUpperCase(str2));

        String compress="aaabbcccdd";
        System.out.println(printCompress(compress));

        String decompress="a3b2c3d2";
        System.out.println(printDecompress(decompress));

        //Bit-Manipulation ...
        int n=10;
        System.out.println(isOddEven(n));
        System.out.println(getithBit(n, 0));
        System.out.println(setithBit(n, 2));
        System.out.println(clearithBit(n, 2));
        System.out.println(updateithBit(n, 1, 0));
        System.out.println(clearLastithBit(n, 1));
        System.out.println(clearRangeofBits(n, 0, 2));
        System.out.println(power2ornot(n));
        System.out.println(countSetBit(n));
        System.out.println(fastExpo(5, 3));


        int a[]={20 ,28 ,2 ,6 ,18, 12, -28 ,3, -3, -26, 1 ,6 ,6 ,-27, -6, -7, 28, -26, 13, 30, -5, -6};
        int x=22;
        System.out.println(circularSubarraySum(a, x));


        // Recursion

        printNum(10);System.out.println();
        printNum1(10);
    }   
}
