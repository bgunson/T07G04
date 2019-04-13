package handlers;

import drivers.BattleshipGalactica;
import gui.AttackScene;
//import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BtnAttackHandler implements EventHandler<ActionEvent>{

    BattleshipGalactica session;
    int x;
    int y;
     /**
     *  @param session is used to change the session
     *  @param x changes the current x
     *  @param y changes the current y
     */
    public BtnAttackHandler(BattleshipGalactica session, int x, int y){
        this.session = session;
        this.x = x;
        this.y = y;
    }
    
    @Override
      /**
     *  shoots the shot using the given coordinates
     */
    public void handle(ActionEvent event){
        
        
        session.getGame().playRound(x, y);

    }
}
