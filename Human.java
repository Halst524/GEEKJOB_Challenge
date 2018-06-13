package Test;

import java.util.ArrayList;

abstract class Human{
    ArrayList<Integer> myCards;
    abstract public int open();
    abstract public void setCard(ArrayList<Integer> al);
    abstract public boolean checkSum();
}
