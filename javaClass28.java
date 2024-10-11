public class javaClass28 {
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    // Backtracking ...
    public static void changeArr(int arr[],int i, int val){
        //base case
        if(i==arr.length){
            printArr(arr);
            return;
        }
        
        //recursion
        arr[i]=val;
        changeArr(arr, i+1, val+1);
        arr[i]=arr[i]-2;  //backtracking step

    }

    // find subset using back tracking ...
    public static void findSubset(String str, String ans, int i){
        //Base case
        if(i==str.length()){
            System.out.print(ans+" ");
            return;
        }

        //recursion
        //yes choice
        findSubset(str, ans+str.charAt(i), i+1);

        // No choice
        findSubset(str, ans, i+1);

    }

    // find permutation in a String ..
    public static void findPermutation(String str,String ans){
        //Base case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        // recursion
        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            String Newstr=str.substring(0, i)+str.substring(i+1);
            findPermutation(Newstr, ans+curr);
        }
    }

    //n-Queens Problem
    // is Safe function
    public static boolean isSafe(char board[][], int row , int col){
        // vertical up
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q')
                return false;
        }

        //diagonal left up
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q')
                return false;
        }

        //diagonal right up
        for(int i=row-1,j=col+1;i>=0&&j<board[0].length;i--,j++){
            if(board[i][j]=='Q')
                return false;
        }

        return true;
    }

    public static boolean nQueens(char board[][], int row){
        //Base case
        if(row==board.length){
            // printBoard(board);
            count++;
            return true;
        }

        //column recursion
        for(int j=0;j<board.length;j++){
            if(isSafe(board, row, j)){
                board[row][j]='Q';
                if(nQueens(board, row+1)){
                    return true;
                }
                board[row][j]='x';
            }
        }  
        return false;
    }

    //N-Knight Problem Hw- working on it
    //isSafeKnight 
    public static boolean isSafeKnight(char board[][],int row, int col){
        for(int i=row-1;i>=0;i--){
            if(board[i][col-2]=='K')
                return false;
        }
        return true;
    }
    public static void nKinghts(char board[][],int row){
        //Base case
        if(row==board.length){
            printBoard(board);
            return;
        }

        //Recursion
        for(int j=0;j<board[0].length;j++){
            if(isSafeKnight(board,row,j)){
                board[row][j]='K';
                nKinghts(board,row+1);
                board[row][j]='x';
            }
        }
    }
    // work is not complete yet


    public static void printBoard(char board[][]){
        System.err.println("-------chess board-------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.err.println();
        }
    }

    static int count=0;
    
    // Grid ways
    public static int gridWays(int i,int j,int n,int m){
        //Base case
        if(i==n-1&&j==m-1)
            return 1;
        else if(i==n||j==m)
            return 0;
        //recursion
        int w1=gridWays(i, j+1, n, m);
        int w2=gridWays(i+1, j, n, m);

        return w1+w2;
    }
    
    //Grid ways optimal
    static long fact(int n){
        long f=1;
        for(int i=1;i<=n;i++){
            f*=i;
        }

        return f;
    }
    public static long gridWaysOptimal(int n,int m){
        return fact((n-1)+(m-1))/(fact(n-1)*fact(m-1));
    }
    
    //gfg
    // Bruit force approach
    public static char nthCharacter(String s, int r, int n)
    {
        //code here
        int length=s.length();
        StringBuilder temp;
        for (int count = 1; count <= r; count++) {
        temp = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '1')
                temp.append("10");
            else
                temp.append("01");
        }
        s = temp.toString();
    }
    return s.charAt(n);
    }

    // gfg*

    // sudoko Problem
    // isSafesudoku function for solving sudoku
    public static boolean isSafesudoku(int sudoku[][],int row, int col, int digit){
        //column
        for(int i=0;i<sudoku.length;i++){
            if(sudoku[i][col]==digit)
                return false;
        }

        for(int j=0;j<sudoku[0].length;j++){
            if(sudoku[row][j]==digit)
                return false;
        }

        //grid 
        int sr=(row/3)*3;
        int sc=(col/3)*3;  //3*3 grid
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }

        return true;
    }
    
    public static boolean sudokuSolver(int sudoku[][], int row, int col){
        //base case
        if(row==9){
            return true;
        } 

        //recursion
        int nextRow=row,nextCol=col+1;
        if(col+1==9){
            nextRow=row+1;
            nextCol=0;
        }

        if(sudoku[row][col]!=0){
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for(int digit=1;digit<=9;digit++){
            if(isSafesudoku(sudoku, row, col, digit)){
                sudoku[row][col]=digit;
                if(sudokuSolver(sudoku, nextRow, nextCol)){ //solution is exist or not
                    return true;
                }
                sudoku[row][col]=0;
            }
        }
        return false;
    }

    public static void printBoard(int sudoku[][]){
        System.err.println("-------Sudoku Solver-------");
        for(int i=0;i<sudoku.length;i++){
            for(int j=0;j<sudoku[0].length;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.err.println();
        }
    }


    public static void main(String[] args) {
        // BACKTRACKING ...
        int arr[]=new int[5];
        changeArr(arr, 0, 1);System.out.println();
        printArr(arr);System.out.println();

        String str="abc";
        findSubset(str, "", 0);System.out.println();
        findPermutation(str, "");

        int n=4;
        char board[][]=new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='x';
            }
        }
        if(nQueens(board, 0)){
            printBoard(board);
        } else{
            System.out.println("No solution exit");
        }
        System.out.println("total ways to to solve n queens = "+count);
        // nKinghts(board,0);

        System.out.println("Total no of Grid ways = "+gridWays(0,0,10,10));
        System.out.println("grid ways in liner time complexity applying permutation and combination formula");
        System.err.println("Total no of Grid ways optimal = "+gridWaysOptimal(10, 10));


        //gfg
       System.out.println("nth char is = "+nthCharacter("1100", 2,3)); 


       //suduko probelm
        int sudoku[][]={ {0, 0, 8, 0, 0, 0, 0, 0, 0},
        {4, 9, 0, 1, 5, 7, 0, 0, 2},
        {0, 0, 3, 0, 0, 4, 1, 9, 0},
        {1, 8, 5, 0, 6, 0, 0, 2, 0},
        {0, 0, 0, 0, 2, 0, 0, 6, 0},
        {9, 6, 0, 4, 0, 5, 3, 0, 0},
        {0, 3, 0, 0, 7, 2, 0, 0, 4},
        {0, 4, 9, 0, 3, 0, 0, 5, 7},
        {8, 2, 7, 0, 0, 9, 0, 1, 3} };

        int sudoku1[][]={ {0, 0, 6, 0, 9, 0, 2, 0, 0},
        {0, 0, 0, 7, 0, 2, 0, 0, 0},
        {0, 9, 0, 5, 0, 8, 0, 7, 0},
        {9, 0, 0, 0, 3, 0, 0, 0, 6},
        {7, 5, 0, 0, 0, 0, 0, 1, 9},
        {1, 0, 0, 0, 4, 0, 0, 0, 5},
        {0, 1, 0, 3, 0, 9, 0, 8, 0},
        {0, 0, 0, 2, 0, 1, 0, 0, 0},
        {0, 0, 9, 0, 8, 0, 1, 0, 0} };

        if(sudokuSolver(sudoku, 0, 0)){
            printBoard(sudoku);
        } else{
            System.out.println("sudoku has not any solution");
        }
        System.out.println();

        if(sudokuSolver(sudoku1, 0, 0)){
            printBoard(sudoku1);
        } else{
            System.out.println("sudoku has not any solution");
        }

    }   
}
