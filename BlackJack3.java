package Test;

public class BlackJack3 {
    
        public static void main(String[] args) {
        User user = new User();
        Dealer dealer = new Dealer();
        dealer.deal(user.draw);
        dealer.deal(dealer.draw);
        
        user.setCard(user.draw);
        user.open();
        for(;user.checkSum();){
            dealer.hit(user.draw);
            user.setCard(user.draw);
            user.open();
            user.checkSum();
        }
        
        dealer.setCard(dealer.draw);
        dealer.open();
        for(;user.result < 22 && dealer.checkSum();){
            dealer.hit(dealer.draw);
            dealer.setCard(dealer.draw);
            dealer.open();
            dealer.checkSum();
        }
        System.out.println((user.myCards) + "←手札[プレイヤー]合計→" + (user.result));
        System.out.println((dealer.myCards) + "←手札[ディーラー]合計→" + (dealer.result));
        if(user.result > 21 && dealer.result <= 21){
            System.out.println("プレイヤーがバストしました");
        } else if(dealer.result > 21 && user.result <= 21){
            System.out.println("ディーラーがバストしました");
        } else if(dealer.result > 21 && user.result > 21){
            System.out.println("両者バストしたので");
        }
        if((user.result > dealer.result && user.result <= 21) || (dealer.result > 21 && user.result <= 21)){
            System.out.println("プレイヤーの勝利です");
        } else if((user.result == dealer.result) && (user.result <= 21)){
            System.out.println("引き分けです");
        } else {
            System.out.println("プレイヤーの負けです");
        }
        if((user.result == 21 || dealer.result == 21) && (user.result == dealer.result)){
            System.out.println("Black Jack!");
        }

        }    
}
