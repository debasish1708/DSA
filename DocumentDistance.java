import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DocumentDistance {
    public static void main(String[] args) {
        try {
            File document1=new File("./Document/D1.txt");
            Scanner doc1_reader=new Scanner(document1);
            while (doc1_reader.hasNextLine()) {
                String data=doc1_reader.nextLine();
                System.out.println(data);
            }
            doc1_reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error is Occurred");
            e.printStackTrace();
        }
        
    }
}
