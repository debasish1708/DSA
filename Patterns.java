import java.util.ArrayList;

public class Patterns {
    public static void hollow_rectangle(int totRows,int totCols){
        //outer loop
        for(int i=1;i<=totRows;i++){
            //inner loop
            for(int j=1;j<=totCols;j++){
                //boundry cell- (i,j)
                if(i==1||i==totRows||j==1|j==totCols){
                    System.out.print("*");
                } else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void inverted_rotatedHalf_pyramid(int totRows){
        //outer loop
        for(int i=1;i<=totRows;i++){
            //inner loop
            for(int j=1;j<=totRows-i;j++){
                //spaces
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                //stars
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void inverted_half_pyramid_with_numbers(int totRows){
        //outer loop
        for(int i=1;i<=totRows;i++){
            //inner loop
            for(int j=1;j<=totRows-i+1;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static void FLOYDS_Triangle(int totRows){
        int n=1;
        //outer loop
        for(int i=1;i<=totRows;i++){
            //inner loop
            for(int j=1;j<=i;j++){
                System.out.print(n+" ");
                n++;
            }
            System.out.println();
        }
    }

    public static void OneZeroTrangle(int totRows){
        //outer loop
        for(int i=1;i<=totRows;i++){
            //inner loop
            for(int j=1;j<=i;j++){
                if((i+j)%2==0){
                    System.out.print(1+" ");
                } else{
                    System.out.print(0+" ");
                }
            }
            System.out.println();
        }
    }

    public static void Butterfly_pattern(int n){
        //outer loop for 1st half
        for(int i=1;i<=n;i++){
            //inner loop for 2nd half
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
        //outer loop for 2nd half
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

    public static void Solid_Rhombus(int n){
        //outer loop
        for(int i=1;i<=n;i++){
            //inner loop
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void Hollow_Rhombus(int n){
        //outer loop
        for(int i=1;i<=n;i++){
            //inner loop spaces
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }

            //hollow rectangle - star
            for(int j=1;j<=n;j++){
                if(i==1||i==n||j==1||j==n){
                    System.out.print("*");
                } else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void Diamond(int n){
        //outer loop for 1st half
        for(int i=1;i<=n;i++){
            //inner loop for 1st half
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i+(i-1);j++){
                System.out.print("*");
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
            System.out.println();
        }
    }

    public static void numberPyramid(int n){
        //outer loop
        for(int i=1;i<=n;i++){
            //inner lop
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print(i+" ");
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

    public static void full_Pyramid(int n){
        //outer loop
        for(int i=1;i<=n;i++){
            //inner loop
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void inverted_full_Pyramid(int n){
        //outer loop
        for(int i=1;i<=n;i++){
            //inner loop
            for(int j=1;j<=i-1;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n-i+1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void Hollow_FullPyramid(int n){
        //outer loop
        for(int i=1;i<=n;i++){
            //inner loop
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printPat(int n){
        //outer loop
        for(int i=1;i<=n;i++){
            //inner loop
            for(int j=n;j>=1;j--){
                for(int k=n;k>=i;k--){
                    System.out.print(j+" ");
                }
            }
            System.out.println();
        }
    }

    public static ArrayList<String> numberPattern(int N){
        // code here
        for(int i=1;i<=N;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            for(int j=i-1;j>=1;j--){
                System.out.print(j);
            }
            System.out.print(" ");
        }
        return null;
    }

    public static void pinPattern(){
        System.out.println();
        for(int i=0;i<=9;i++){
            for(int j=0;j<=9;j++){
                for(int k=0;k<=9;k++){
                    for(int l=0;l<=9;l++){
                        System.out.print(i+""+j+""+k+""+l+" ");
                    }
                }
            }
        }    
    }

    public static void printMatrix(int Matrix[][]){
        for(int i=0;i<Matrix.length;i++){
            for(int j=0;j<Matrix[0].length;j++){
                System.out.print(Matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void  printdigonalSpiral(int Matrix[][]){
        for(int i=0;i<Matrix.length;i++){
            
        }
    }

    public static void main(String[] args) {
        hollow_rectangle(4, 5);
        inverted_rotatedHalf_pyramid(4);
        inverted_half_pyramid_with_numbers(5);
        FLOYDS_Triangle(5);
        OneZeroTrangle(5);
        Butterfly_pattern(4);
        Solid_Rhombus(5);
        Hollow_Rhombus(5);
        Diamond(4);
        numberPyramid(5);
        palindromic_pattern(5);
        full_Pyramid(6);
        inverted_full_Pyramid(6);
        printPat(3);
        // work on hollow_fullPyramid is not complete yet
        Hollow_FullPyramid(6);
        numberPattern(3);System.out.println();
        // pinPattern();
        int Matrix[][]={{1,2,3},
                        {4,5,6},
                        {7,8,9}};
        printMatrix(Matrix);System.out.println();
        printdigonalSpiral(Matrix);
    }
}
