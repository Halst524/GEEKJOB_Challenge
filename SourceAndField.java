/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;


import static java.lang.System.out;

/**
 *
 * @author guest1Day
 */
public class SourceAndField {
    public static void main(String[] arcs){
        int num1 = 10;
        boolean pin1 = false;
        
        alpha al = new alpha();//これでalphaクラスに接続できる。
        
        al.getter(num1, pin1);
        
        //　その２　上記変数を画面表示する。
        al.shower();
        
    }
}
class alpha{// 変数を２つ置く。
    int num = 119;
    boolean pin = true;
    
    public void getter(int a,boolean b){
        
        this.num = a;
        this.pin = b;
    }
    
    public void shower(){//　num1、pin1に格納したものを表示？
        System.out.println(num + "\n" + pin);
    }
}




