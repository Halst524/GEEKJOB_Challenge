package StringQuestion;

public class String1 {
    public static void main(String[] arcs){
        String name = "山田 太郎（仮名）";
        System.out.println("バイト数\t" + name.getBytes().length);
        System.out.println("文字数\t" + name.length());
    }
}
