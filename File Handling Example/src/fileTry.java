import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;

public class fileTry {
    
    public static void main(String[] args) {
        
        /* try {
            FileWriter writer = new FileWriter("myfile.txt");
            writer.write("La la la");
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } */

        try {
                FileReader reader = new FileReader("art.txt");
                int data = reader.read();

                while(data != -1)
                {
                    System.out.print((char)data);
                    data = reader.read();
                }
                reader.close();

            } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
    }
}
