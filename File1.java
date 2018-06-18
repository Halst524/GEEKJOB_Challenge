package FileQuestion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class File1 {
    public static void main(String[] arcs){
        File fp = new File("C:\\Users\\guest1Day\\Desktop\\prof.text");
        try {
            fp.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(File1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            FileWriter fw = new FileWriter(fp);
            fw.write("Hi!I'm virus:)");
            fw.write("If you want to vanish this text file,you must buy iTunes card(of cource,the highest price;))");
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(File1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
