
public class javaClass16 {

    public static void update(int marks[],int nonChangeble){
        nonChangeble=10;
        for(int i=0;i<marks.length;i++){
            marks[i]=marks[i]+1;
            // System.out.println(marks[i]);
        }
    }

    public static int linearSearch(int numbers[],int key){
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // int marks[]=new int[3];
        // Scanner sc=new Scanner(System.in);
        // System.out.print("Enter phy mark: ");
        // marks[0]=sc.nextInt();
        // System.out.print("Enter che mark: ");
        // marks[1]=sc.nextInt();
        // System.out.print("Enter math mark: ");
        // marks[2]=sc.nextInt();

        // System.out.println("phy ="+marks[0]+" che = "+marks[1]+" math = "+marks[2]);
        // int percentage=(marks[0]+marks[1]+marks[2])/3;
        // System.out.println("percentage = "+percentage+"%");
        // System.out.println(marks.length);
        int marks[]={97,98,99};
        int nonChangeble=5;
        update(marks,nonChangeble);
        System.out.println(nonChangeble);
        //print our marks
        for(int i=0;i<marks.length;i++){
            System.out.print(marks[i]+" ");
        }
        System.out.println();
        int numbers[]={2,4,6,8,10,12,14,16};
        int key=10;
        int index=linearSearch(numbers, key);
        if(index==-1){
            System.out.println("not found");
        } else
        System.out.println(index);
    }
}
