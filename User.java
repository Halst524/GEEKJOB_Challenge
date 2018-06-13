package Test;

import java.util.ArrayList;

class User extends Human{
    protected ArrayList<Integer> myCards = new ArrayList<>();
    int result = 0;
    protected ArrayList<Integer> draw = new ArrayList<>();
    
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
}