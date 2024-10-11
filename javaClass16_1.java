
public class javaClass16_1 {

    public static int getLargest(int numbers[]){
        int largest=Integer.MIN_VALUE;//-infinity
        int smallest=Integer.MAX_VALUE;// +infinity
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]>largest){
                largest=numbers[i];
            }
        }
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]<smallest){
                smallest=numbers[i];
            }
        }
        System.out.println("smallest value = "+smallest);
        return largest;
    }

    public static int binarySearch(int numbers[],int key){
        int start=0,end=numbers.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(numbers[mid]==key){
                return ++mid;
            } else if(numbers[mid]<key){
                start=mid+1;
            } else{
                end=mid-1;
            }
        }
        return -1;
    }

    //it take too much space complexity
    public static void reverseArray(int array[]){
        int newarray[]=new int[array.length];
        int i=0;
        for(int j=array.length-1;j>=0;j--){
                newarray[i]=array[j];
                i++;
        }

        System.out.print("reverse array = ");
        //print newarray
        for(int k=0;k<=newarray.length-1;k++){
            System.out.print(newarray[k]+ " ");
        }
    }

    //in this it not take too much space complexity
    public static void reverse(int array[]){
        int first=0,last=array.length-1;
        while(first<last){
            //swap
            int temp=array[last];
            array[last]=array[first];
            array[first]=temp;
            first++;
            last--;
        }
    }

    public static void pairsArray(int array[]){
        int tp=0;
        for(int i=0;i<=array.length-1;i++){
            for(int j=i+1;j<=array.length-1;j++){
                System.out.print("("+array[i]+","+array[j]+")"+" ");
                tp++;
            }
            System.out.println();
        }
        System.out.print("total pair = "+tp);//total pair=n(n-1)/2;
    }

    public static void printSubarray(int array[]){
        int tsa=0;
        for(int i=0;i<array.length;i++){
            for(int j=i;j<array.length;j++){
                for(int k=i;k<=j;k++){ //print
                    System.out.print(array[k]+" "); //subarray
                }
                tsa++;
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("Total subarray = "+tsa); //n(n+1)/2;
    }
 
    // home work - problem to add subarray and find maximum sum
    // the time complexity is O(n^3) so it is bad TC.
    public static void printMaxSumOfSubarray(int array[]){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<array.length;i++){
            int sum=0;
            for(int j=i;j<array.length;j++){
                for(int k=j;k<=j;k++){ //print
                    sum+=array[k];
                    System.out.print(sum+" ");
                    if(max<sum){
                        max=sum;
                    }
                    if(min>sum){
                        min=sum;
                    }
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("maximum value = "+max);
        System.out.println("minimum value = "+min);
    }

    // Optimization way of Max Subarray  = Prefix array..
    public static void printMaxSumOfSubarrayUsingPrefixArray(int array[]){
        int PrefixArray[]=new int[array.length];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        PrefixArray[0]=array[0];
        for(int i=1;i<array.length;i++){
            PrefixArray[i]=PrefixArray[i-1]+array[i];
        }

        for(int i=0;i<array.length;i++){
            int sum=0;
            for(int j=i;j<array.length;j++){
                sum=i==0?PrefixArray[j]:PrefixArray[j]-PrefixArray[i-1];
                System.out.print(sum+"  ");
                if(max<sum){
                        max=sum;
                }
                if(min>sum){
                        min=sum;
                }
            }
            System.out.println();
        }
        System.out.println("maximum sum = "+max);
        System.out.println("minimum sum = "+min);
    }

    //Kadanes algorithm for maximum sum of sub array...
    public static void printMaxSumOfSubarrayUsingKadanesAlgorithm(int newarray[]){
        int max=Integer.MIN_VALUE;
        int cs=0;
        for(int i=0;i<newarray.length;i++){
            cs+=newarray[i];
            if(cs<0){
                cs=0;
            }
            max=Math.max(max, cs);
        }
        System.out.println("our max subarray sum = "+max);
    }

    //Kadanes algorithm for maximum sum of sub array...(negative numbers)
    public static void printMaxSumOfSubarrayUsingKadanesAlgorithmForNegativeNumber(int newnegativearray[]){
        boolean kadanes=true;
        for(int i=0;i<newnegativearray.length;i++){
            if(newnegativearray[i]<0){
                kadanes=false;
            } else{
                kadanes=true;break;
            }
        }
        if(kadanes==false){
            System.out.println("kadanes rule is not applicable");
            System.out.println("so we have apply some changes on \nkandanes algorithm to solve it\n");
            int max=Integer.MIN_VALUE;
            for(int i=0;i<newnegativearray.length;i++){
                if(newnegativearray[i]>max){
                    max=newnegativearray[i];
                }
            }
            System.out.println("---------------------------");
            System.out.println("our max subarray sum = "+max);
            System.out.println("---------------------------");
        } else {
            System.out.println("kadanes is applicable");
            int max=Integer.MIN_VALUE;
            int cs=0;
            for(int i=0;i<newnegativearray.length;i++){
                cs+=newnegativearray[i];
                if(cs<0){
                cs=0;
              }
                max=Math.max(max, cs);
            }
        System.out.println("our max subarray sum = "+max);
        }
    }

    //trapping Rainwater..
    public static void trappingRainwater(int height[]){  // Time complexity is O(n)..
        int leftMaxBoundry[]=new int[height.length];
        int rightMaxBoundry[]=new int[height.length];
        System.out.print("left max boundry = ");
        leftMaxBoundry[0]=height[0];
        for(int i=1;i<leftMaxBoundry.length;i++){
            leftMaxBoundry[i]=Math.max(leftMaxBoundry[i-1], height[i]);
            //print left max boundry..
            System.out.print(leftMaxBoundry[i]+" ");
        }
        System.err.print("\nright max boundry = ");
        rightMaxBoundry[height.length-1]=height[height.length-1];
        for(int i=rightMaxBoundry.length-2;i>=0;i--){
                rightMaxBoundry[i]=Math.max(rightMaxBoundry[i+1], height[i]);
        }
        // print righr max boundry..
        for(int i=0;i<leftMaxBoundry.length;i++){
            System.out.print(rightMaxBoundry[i]+" ");
        }

        int trappedWatter=0;
        for(int i=0;i<height.length;i++){
            int waterLevel=Math.min(leftMaxBoundry[i], rightMaxBoundry[i]);
            trappedWatter=trappedWatter+(waterLevel-height[i]);
        }
        if(trappedWatter==0){
            System.out.println("\nthere is no right boundry to trap the water");
        } else
        System.out.print("\n------------------------");
        System.out.println("\ntotal trapped watter = "+trappedWatter+" liter");
        System.out.println("------------------------");
    }
 
    //Buy and Sell Stocks 
    public static void buyandSellStocks(int prices[]){//TC = O(n^2);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[i]<prices[j]){
                    int profit=prices[j]-prices[i];
                    if(profit>max){
                        max=profit;
                    }
                }
            }
        }
        System.out.println("maximum profit = "+max+" O(n^2)-TC");
    }

    //Buy and sell stocks 
    public static int BuySellStock(int prices[]){ //TC = O(n)
        int buyprice=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            if(buyprice<prices[i]){
                int profit=prices[i]-buyprice;
                maxProfit=Math.max(maxProfit,profit);
            } else{
                buyprice=prices[i];
            }
        }
        return maxProfit;
    }

    //sell and buy stock (short selling concept)
    public static int ShortSellingStock(int prices[]){  //O(n)
        int maxprofit=0;
        int sellPrice=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            if(sellPrice>prices[i]){
                int profit=sellPrice-prices[i];
                maxprofit=Math.max(maxprofit, profit);
            } else
            sellPrice=prices[i];
        }

        return maxprofit;
    }

    
    public static void main(String[] args) {
        int numbers[]={2,4,6,8,10,12,14};
        System.out.println("size of array = "+numbers.length);
        System.out.println("Largest value = "+getLargest(numbers));
        int key=8;
        // System.out.println("the index is : "+binarySearch(numbers,key));
        int index=binarySearch(numbers, key);
        if(index==-1){
            System.out.println("not found");   
        } else
        System.out.println("the index is = "+index);
        
        int array[]={1,-2,6,-1,3};
        System.out.print("original array = ");
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
        reverseArray(array);
        reverse(array);
        reverse(array);
        System.out.println();
        System.out.print("reverse(space complexity=O(1)) array = ");
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }

        System.out.println();
        pairsArray(array);

        System.out.println();
        printSubarray(array);

        printMaxSumOfSubarray(array);

        printMaxSumOfSubarrayUsingPrefixArray(array);

        int newarray[]={-2,-3,4,-1,-2,1,5,-3};
        printMaxSumOfSubarrayUsingKadanesAlgorithm(newarray);

        int newnegativearray[]={23 ,41, 84, -8, 42, -54, 1, 2, 28, 49, -32, -16, -33, -44, -100, -30, 68, -47, 59, -94, 35, -18};
        System.out.println();
        System.out.println(newnegativearray.length);
        printMaxSumOfSubarrayUsingKadanesAlgorithmForNegativeNumber(newnegativearray);

        //trapping Rainwater..
        System.out.println();
        int height[]={4,2,0,6,3,2,5};
        trappingRainwater(height);

        //buy and sell stocks
        System.out.println();
        int prices[]={7,1,5,3,6,4};
        buyandSellStocks(prices);

        System.out.print("maximum profit = ");
        System.out.print(BuySellStock(prices)+" O(n)-TC");

        System.out.println();
        System.out.println("maximum profit in short selling = "+ShortSellingStock(prices));
    }
}
