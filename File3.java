package FileQuestion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class File3 {
    public static void main(String[] arcs){
        FileWriter fw = null;
        try {
            Date dat = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss.SSS秒 開始");
            File fp = new File("C:\\Users\\guest1Day\\Desktop\\1234567890.text");
            fw = new FileWriter(fp);
            fw.write(sdf.format(dat) + "\r\n\r\n");
            fw.write("今回紹介する標準クラスはLinkedListだ。\r\n\r\n");
            fw.write("ちなみに標準クラスとはJava側があらかじめ用意してくれているクラスライブラリのことである。\r\n\r\n");
            fw.write("必要に応じて大半の標準クラスの機能をインポートすることで使用することができる。\r\n\r\n");
            fw.write("intやString等も標準クラスの1つであるため、全てとは言い切れないのである。\r\n\r\n");
            fw.write("本題に戻り、LinkedListクラスは旧版から存在し、ArrayListが末尾への情報追加や削除が得意なことに対し、先頭も得意なのが特徴と言える。\r\n\r\n");
            fw.write("しかしながら、このクラスはLink構造になっているため、ArrayListに比べ情報の取り出しが不得意である。\r\n\r\n");
            fw.write("メリットとしては順序番号がないため、要素の追加や削除をするたびに順序番号の再配置が行われないため、追加、削除、書き換え時にはArrayListより高速である。\r\n\r\n");
            fw.write("これもjava.utilパッケージ内にあるため、「import java.util.LinkedList」と宣言するだけで使用できる。\r\n\r\n");
            fw.write("LinkedListも収納できるものはArrayListと同じくObject型だけである。\r\n\r\n");
            fw.write("LinkedList<String> lL = new LinkedList<String>();\r\n\r\n");
            fw.write("lL.add(\"a\"); lLにaが格納される。\r\n\r\n");
            fw.write("lL.addFirst(\"b\"); lLの先頭にbが格納される。\r\n\r\n");
            fw.write("lL.add(\"c\"); lLの末尾にcが格納される。\r\n\r\n");
            fw.write("String s = lL.getFirst(); sには先頭のcが代入される。\r\n\r\n");
            fw.write("String t = lL.getLast(); tには末尾のtが代入される\r\n\r\n");
            Date dat2 = new Date();
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss.SSS秒 終了");
            fw.write(sdf2.format(dat2));
        } catch (IOException ex) {
            Logger.getLogger(File3.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(File3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
