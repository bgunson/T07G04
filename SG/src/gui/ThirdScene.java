package gui;

import logic.Game;
import logic.Board;
import drivers.BattleshipGalatica;
import handlers.BtnAttackHandler;
import javafx.geometry.Orientation;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.animation.AnimationTimer;
import javafx.geometry.HPos;
import javafx.geometry.Pos;

public class ThirdScene extends BaseScene{
    
    private Button[][] playerShipsButtons = new Button[10][10];
    private Button[][] hitPaneButtons = new Button[10][10];

    
    public ThirdScene(BattleshipGalatica session){
        super(session);
    }
    
    @Override
    public void setup(){
        
        GridPane root = new GridPane();

        Game a = getSession().getGame();
        a.getPlayerOneShips().boardDisplay();

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                playerShipsButtons[j][i] = new Button();
                playerShipsButtons[j][i].setPrefSize(39,39);
                playerShipsButtons[j][i].setMinSize(39,39);
                playerShipsButtons[j][i].setMaxSize(39,39);
                playerShipsButtons[j][i].setStyle("-fx-background-color: #000000");
                root.add(playerShipsButtons[j][i], j, i);
                root.setHalignment(playerShipsButtons[j][i],HPos.CENTER);
            }
        }
        
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 5; j++){
                Button q = new Button();
                q.setPrefSize(39,39);
                q.setMinSize(39,39);
                q.setMaxSize(39,39);
                q.setStyle("-fx-background-color: #FFFFFF");
                root.add(q, j+12, i);
            }
        }
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                BtnAttackHandler pHandler = new BtnAttackHandler(getSession(), j, i);
                
                hitPaneButtons[j][i] = new Button();
                hitPaneButtons[j][i].setPrefSize(39,39);
                hitPaneButtons[j][i].setMinSize(39,39);
                hitPaneButtons[j][i].setMaxSize(39,39);
                hitPaneButtons[j][i].setStyle("-fx-background-color: #000080");
                hitPaneButtons[j][i].setOnAction(pHandler);
                
                root.add(hitPaneButtons[j][i], j+24, i);
                root.setHalignment(hitPaneButtons[j][i],HPos.CENTER);
            }
        }

        new AnimationTimer(){
            public void handle(long now){
                
                // Updates players Board as shots are fired
                Board a = getSession().getGame().getPlayerOneShips();
                for (int i = 0; i < 10; i++){
                    for (int j = 0; j < 10; j++){
                        //System.out.println("j,i,grid: "+j+" "+i+" "+a.grid[j][i]);
                        if(a.grid[j][i] == "G")
                            playerShipsButtons[j][i].setStyle("-fx-background-color: #008000");
                        else if (a.grid[j][i] == "D")
                            playerShipsButtons[j][i].setStyle("-fx-background-color: #FF0000");
                        else if (a.grid[j][i] == "F")
                            playerShipsButtons[j][i].setStyle("-fx-background-color: #C0C0C0");
                        else
                            playerShipsButtons[j][i].setStyle("-fx-background-color: #000000");  
                    }
                }
            }            
        }.start();
        
        setScene(new Scene(root, 1000, 500));
        display();
    }

}
