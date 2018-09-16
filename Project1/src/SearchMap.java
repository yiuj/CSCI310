import java.io.*;

public class SearchMap {
    public static void main(String[] args) throws IOException{
        System.out.println("Searching Map");

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("inputfile.txt");
            //out = new FileOutputStream("output.txt");
            int i;
            char c;
            while((i = in.read()) != -1) {
            
                // converts integer to character
                c = (char)i;
                
                // prints character
                System.out.print(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
}
