/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author guest1Day
 */
public class Extendable extends alpha{
    void clear(int a,boolean b){
        this.num = a;
        this.pin = b;
    }
}
class onlyDo{
    public static void main(String[] arcs){
        Extendable ext = new Extendable();
        ext.clear(0, false);
        
    }
    
}
