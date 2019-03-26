package handlers;

import drivers.BattleshipGalatica;
import gui.ThirdScene;
//import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BtnPlaceShipHandler implements EventHandler<ActionEvent>{

    BattleshipGalatica session;
    int x;
    int y;
    
    public BtnPlaceShipHandler(BattleshipGalatica session, int x, int y){
        this.session = session;
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void handle(ActionEvent event){
        
        session.getGame().placeNextShip(x, y);
        session.getGame().getPlayerOneShips().boardDisplay();
        if (session.getGame().allShipsPlaced() == true){
            ThirdScene scene = new ThirdScene(session);
            scene.setup();
        }
    }
}
