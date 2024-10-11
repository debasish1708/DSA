
public class javaClass18 {

    public static boolean search(int matrix[][],int key,int n,int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==key){
                    System.out.println("found at cell ("+i+","+j+")");
                    return true;
                }
            }
        }
        return false;
    }

    public static void largestSmallest(int matrix[][]){
        int largest=Integer.MIN_VALUE;
        int smallest=Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(largest<matrix[i][j]){
                    largest=matrix[i][j];
                }
                if(smallest>matrix[i][j]){
                    smallest=matrix[i][j];
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==largest){
                    System.out.println("found large at cell ("+i+","+j+")");
                }
                if(matrix[i][j]==smallest){
                    System.out.println("found small at cell ("+i+","+j+")");
                }
            }
        }
        System.out.print("largest number is: "+largest);
        System.out.println("\nsmallest number is: "+smallest);
    }

    public static void printRowColumn(int matrix[][]){
        System.out.println("---pritn the first row---");
        for(int i=0;i<=0;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
        }
        System.out.println("\n---print the second row---");
        for(int i=1;i<=1;i++){
            for(int j=0;j<matrix[1].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
        }
        System.out.println("\n---print the third row---");
        for(int i=2;i<=2;i++){
            for(int j=0;j<matrix[2].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
        }

        System.out.println("\n---print the first column for better time complexity---");
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<=0;j++){
                System.out.print(matrix[i][j]); 
                System.out.println();
            }
        }
        System.out.println("\n---print the first column---");
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
               if(j==0){
                System.out.print(matrix[i][j]);
                System.out.println();
               } 
            }
        }
        System.out.println("\n---print the second column---");
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
               if(j==1){
                System.out.print(matrix[i][j]);
                System.out.println();
               } 
            }
        }
        System.out.println("\n---print the third column---");
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
               if(j==2){
                System.out.print(matrix[i][j]);
                System.out.println();
               } 
            }
        }
        
    }

    public static void printSpiral(int Matrix[][]){
        int startRow=0,startCol=0,endRow=Matrix.length-1,endCol=Matrix[0].length-1;
        while(startRow<=endRow && startCol<=endCol){
            //top
            for(int j=startCol;j<=endCol;j++){
                System.out.print(Matrix[startRow][j]+" ");
            }
            //right
            for(int i=startRow+1;i<=endRow;i++){
                System.out.print(Matrix[i][endCol]+" ");
            }
            //bottom
            for(int j=endCol-1;j>=startCol;j--){
                if(startRow==endRow){
                    break;
                }
                System.out.print(Matrix[endRow][j]+" ");
            }
            //left
            for(int i=endRow-1;i>=startRow+1;i--){
                if(startCol==endCol){
                    break;
                }
                System.out.print(Matrix[i][startCol]+" ");
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
    }

    //woring on it....
    // it is not complete yet...
    // public static void printdigonalSpiral(int Matrix[][]){
    //     System.out.println();
    //     // int startRow=0,startCol=0,endRow=Matrix.length-1,endCol=Matrix[0].length-1;
    //     for(int i=0;i<Matrix.length;i++){
    //         for(int j=0;j<Matrix[0].length;j++){
    //             System.out.print(Matrix[i][j]+" ");
    //         }
    //         System.out.println();
    //     }
    //     int sumindex[]=new int[16];
    //     int k=0;
    //     for(int i=0;i<Matrix.length;i++){
    //         for(int j=0;j<Matrix[0].length;j++){
    //             sumindex[k]=i+j;
    //             k++;
    //         }
    //     }
    //     for(int i=0;i<sumindex.length;i++){
    //         System.out.print(sumindex[i]+" ");
    //     }
    // }
    // public static void printdigonalSpiral(int Matrix[][]){
    //     for(int i=0;i<Matrix.length;i++){
    //         System.out.print(Matrix[i][i]+" ");
    //     }
    // }
    
    public static void diagonalSum(int Matrix[][]){ //O(n^2)
        int sum=0;
        for(int i=0;i<Matrix.length;i++){
            for(int j=0;j<Matrix[0].length;j++){
                if(i==j){
                    sum+=Matrix[i][j];
                }
                else if(i+j==Matrix.length-1){
                    sum+=Matrix[i][j];
                }
            }
        }
        System.out.println("Total Diagonal Sum = "+sum);
    }

    public static int diagonalSumOptimal(int Matrix[][]){ //O(n)
        int sum=0;
        for(int i=0;i<Matrix.length;i++){
            //pd
            sum+=Matrix[i][i];
            //sd
            if(i!=Matrix.length-i-1)
            sum+=Matrix[i][Matrix.length-i-1];
        }
        return sum;
    }
    
    // top right approach
    public static boolean stairCaseSearchForSortedMatrix(int Matrix1[][],int key){
        int row=0,col=Matrix1[0].length-1;
        while (row<=Matrix1.length-1 && col>=0) {
            if(Matrix1[row][col]==key){
                System.out.println("found key at index = ("+row+","+col+")");
                return true;
            } else if(key<Matrix1[row][col]){
                col--;
            } else
                row++;
        }
        System.out.println("key is not found");
        return false;
    }

    // bottom left approach
    public static boolean stairCaseSearchSortedMatrix(int Matrix1[][],int key){
        int row=Matrix1[0].length-1,col=0;
        while (row>=0&&col<=Matrix1.length-1) {
            if(key==Matrix1[row][col]){
                System.out.println("found key at index = ("+row+","+col+")");
                return true;
            } else if(key<Matrix1[row][col]){
                row--;
            } else
                col++;
        }
        System.out.println("key is not found");
        return false;
    }

    public static void main(String[] args) {

            int matrix[][]=new int[3][3];
            System.out.println(matrix.length);
            System.out.println(matrix[0].length);
            int n=matrix.length, m=matrix[0].length;
            int k=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    matrix[i][j]=k+1;
                    k++;
                }
            }

            //output
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }
            search(matrix, 5, n, m);
            largestSmallest(matrix);
            
            printRowColumn(matrix);
            
            System.out.println("---New Matrix is---");
            int Matrix[][]={{1,2,3,4},
                            {5,6,7,8},
                            {9,10,11,12},
                            {13,14,15,16}};
            for(int i=0;i<Matrix.length;i++){
                for(int j=0;j<Matrix[0].length;j++){
                    System.out.print(Matrix[i][j]+" ");
                }
                System.out.println();
            }

            System.out.print("Spiral matrix = ");
            printSpiral(Matrix);

            //working on it...
            // printdigonalSpiral(Matrix);

            System.out.println();
            diagonalSum(Matrix);
            System.out.println("diagonal Sum = "+diagonalSumOptimal(Matrix));
            int Matrix1[][]={{10,20,30,40},
                            {15,25,35,45},
                            {27,29,37,48},
                            {32,33,39,50}};
            int key=33;
            stairCaseSearchForSortedMatrix(Matrix1, key);
            stairCaseSearchSortedMatrix(Matrix1, key);
    }
}
