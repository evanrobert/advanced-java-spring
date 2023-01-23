package platform.codingnomads.co.ioc.lab.initial;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class GameWeArePlaying {
   private gamePlayed GamePlayed;
   @Autowired
    public void setGamePlayed(gamePlayed gamePlayed) {
       this.GamePlayed = gamePlayed;
   }
    public void startGame() {
        System.out.println(GamePlayed.getGame() + " is starting");
    }
    public   void endGame(){
        System.out.println(GamePlayed.getGame() +  " is stopping");








    }


}
