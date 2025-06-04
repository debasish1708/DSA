import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DocumentDistance {
    public static void main(String[] args) {
        /*
         * Document Distance Algorithm
         * 
         */
        try {
            File document1=new File("./Document/D1.txt");
            File document2=new File("./Document/D2.txt");
            Scanner doc1_reader=new Scanner(document1,"UTF-8");
            Scanner doc2_reader=new Scanner(document2,"UTF-8");

            while (doc1_reader.hasNextLine()) {
                String data=doc1_reader.nextLine();
                System.out.println(data);
            }

            while(doc2_reader.hasNextLine()){
                String data=doc2_reader.nextLine();
                System.out.println(data);
            }

            doc1_reader.close();
            doc2_reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error is Occurred");
            e.printStackTrace();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
}
