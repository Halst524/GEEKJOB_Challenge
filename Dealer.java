package Test;

import java.util.ArrayList;
import java.util.Random;

class Dealer extends Human{
    Random rand = new Random();
    protected ArrayList<Integer> myCards = new ArrayList<>();
    protected ArrayList<Integer> cards = new ArrayList<>();
    protected int num;
    protected int result = 0;
    protected ArrayList<Integer> draw = new ArrayList<>();
    
    public Dealer(){
        for(int i = 1;i <= 4;i++){
            for(int j = 1;j <= 13;j++){
                if(j < 10){
                    cards.add(j);
                } else {
                    cards.add(10);
                }
            }
        }
    }
    
    @Override
    public int open() {
            result = 0;
        for(int i = 0;i < myCards.size();i++){
            result += myCards.get(i);
        }
    return result;
    }
    @Override
    public void setCard(ArrayList<Integer> al) {
        myCards.clear();
        for(int i = 0;i < al.size();i++){
            myCards.add(al.get(i));
        }
    }
    @Override
    public boolean checkSum(){
        return 17 > result;
    }
    public ArrayList<Integer> deal(ArrayList<Integer> al){
        for(int i = 0 ; i < 2 ; i++){
            num = rand.nextInt(cards.size());
            al.add(cards.get(num));
            cards.remove(num);
            
        }
        return al;
    }
    public ArrayList<Integer> hit(ArrayList<Integer> al){
        num = rand.nextInt(cards.size());
        al.add(cards.get(num));
        cards.remove(num);
        return al;
    }
}