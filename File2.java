package FileQuestion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class File2 {
    public static void main(String[] arcs) throws IOException{
        File fp = new File("C:\\Users\\guest1Day\\Desktop\\prof.text");
        try {
            FileReader fr = new FileReader("C:\\Users\\guest1Day\\Desktop\\prof.text");
            BufferedReader br = new BufferedReader(fr);
            System.out.println(br.readLine());
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(File2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
