package Test;

import java.util.ArrayList;
import java.util.Random;

class Dealer extends Human{
    Random rand = new Random();
    protected ArrayList<Integer> myCards = new ArrayList<>();       //手札は増えていくためArrayListである必要がある
    protected ArrayList<Integer> cards = new ArrayList<>();         //山札は引いたカードを消去していく必要がある
    protected int num;                                              //不要物    山札から取り出した要素の位置を入れる
    protected int result = 0;                                       //不要物    手札の合計値を入れる
    protected ArrayList<Integer> draw = new ArrayList<>();          //不要物    山札から取り出した要素を入れる
    
    public Dealer(){
        for(int i = 1;i <= 4;i++){          //4マーク分
            for(int j = 1;j <= 13;j++){     //1マーク分
                if(j < 10){
                    cards.add(j);   //10未満はそのまま
                } else {
                    cards.add(10);  //10以上は10と扱う
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
    public ArrayList<Integer> deal(ArrayList<Integer> al){     //最初にプレイヤーとディーラーに2枚渡す処理
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