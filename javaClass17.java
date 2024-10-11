// import java.util.*;
public class javaClass17 {

    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void bubbleSort(Integer arr[]){
        System.out.println("This is bubble sort");
        for(int turn=0;turn<arr.length-1;turn++){
            for(int j=0;j<arr.length-1-turn;j++){
                if(arr[j]>arr[j+1]){
                    //swap
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    // homw work
    public static void optimizeBubbleSort(int sorted[]){
        System.out.print("optimizecode for best case in bubble sort");
        for(int i=0;i<sorted.length-1;i++){
            if(sorted[i]>sorted[i+1]){
                //swap
                int temp=sorted[i];
                sorted[i]=sorted[i+1];
                sorted[i+1]=temp;
            }
        }
        System.out.println();
        for(int i=0;i<sorted.length;i++){
            System.out.print(sorted[i]+" ");
        }
    }

    public static void selectionSort(Integer arr[]){
        for(int i=0;i<arr.length-1;i++){
            int minPos=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minPos]>arr[j]){
                    minPos=j;
                }
            }
            //swap
            //swapping between current poisition to minimum position
            int temp=arr[minPos];
            arr[minPos]=arr[i];
            arr[i]=temp;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void insertionSort(Integer arr[]){
        for(int i=1;i<arr.length;i++){
            int curr=arr[i];
            int prev=i-1;
            //finding out the correct pos to insert
            while(prev>=0 && arr[prev]>curr){
                arr[prev+1]=arr[prev];
                prev--;
            }
            //insertion
            arr[prev+1]=curr;

        }
    }
    
    public static void insertionSort1(Integer arr[]){
        for(int i=1;i<arr.length;i++){
            int curr=arr[i];
            int prev=i-1;
            while(prev>=0&&arr[prev]>curr){
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=curr;
        }
    }

    public static void countingSort(int arr[]){
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            largest=Math.max(largest,arr[i]);
        }

        int count[]=new int[largest+1];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }

        //soring
        int j=0;
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("-----This is java class 17- sorting-----");
        // System.out.println();
        // Integer arr[]={5,4,1,3,2};
        // int arr[]={5,4,1,3,2};
        int arr[]={1,4,1,3,2,4,3,7};
        // bubbleSort(arr);


        // int sorted[]={1,2,3,4,5};
        // System.out.println();
        // optimizeBubbleSort(sorted);

        // System.out.println();
        // System.out.println("selction sort");
        // selectionSort(arr);

        // System.out.println("insertion sort");
        // insertionSort1(arr);
        // System.out.println();
        // System.out.println("---java inbuild function---");
        // Arrays.sort(arr,0,3);
        // Arrays.sort(arr);

        //for reverse order we use collections functions
        // Arrays.sort(arr,0,3,Collections.reverseOrder());

        System.out.println("---counting sort---");
        countingSort(arr);
        printArr(arr);
    }
}
