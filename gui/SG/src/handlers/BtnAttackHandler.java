package handlers;

import drivers.BattleshipGalatica;
import gui.ThirdScene;
//import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/*
Handler which handles events when the user is clicking to attack the opponent's board.
 */
public class BtnAttackHandler implements EventHandler<ActionEvent>{

    // current session and (x, y) pos of the click.
    BattleshipGalatica session;
    int x;
    int y;

    /**
     * Construct handler object with session and click position.
     */
    public BtnAttackHandler(BattleshipGalatica session, int x, int y){
        this.session = session;
        this.x = x;
        this.y = y;
    }

    /**
     * Override the handle method; plays a round based on the click recieved.
     */
    @Override
    public void handle(ActionEvent event){
        
        //todo
        session.getGame().playRound(x, y);

    }
}
