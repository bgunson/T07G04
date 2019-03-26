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
    private Button[][] hitButtons = new Button[10][10];
    private int flash = 0;

    
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
                
                hitButtons[j][i] = new Button();
                hitButtons[j][i].setPrefSize(39,39);
                hitButtons[j][i].setMinSize(39,39);
                hitButtons[j][i].setMaxSize(39,39);
                hitButtons[j][i].setStyle("-fx-background-color: #000080");
                hitButtons[j][i].setOnAction(pHandler);
                
                root.add(hitButtons[j][i], j+24, i);
                root.setHalignment(hitButtons[j][i],HPos.CENTER);
            }
        }

        new AnimationTimer(){
            public void handle(long now){
                flash++;
                if (flash == 50)
                    flash = 0;
                
                // Updates players Board as shots are fired
                Board playerShips = getSession().getGame().getPlayerOneShips();
                for (int i = 0; i < 10; i++){
                    for (int j = 0; j < 10; j++){
                        //System.out.println("j,i,grid: "+j+" "+i+" "+a.grid[j][i]);
                        if(playerShips.grid[j][i] == "G")
                            playerShipsButtons[j][i].setStyle("-fx-background-color: #008000");
                        else if (playerShips.grid[j][i] == "D"){
                            if (flash > 25)
                                playerShipsButtons[j][i].setStyle("-fx-background-color: #FF0000");
                            else
                                playerShipsButtons[j][i].setStyle("-fx-background-color: #008000");                                
                        }
                            else if (playerShips.grid[j][i] == "F")
                            playerShipsButtons[j][i].setStyle("-fx-background-color: #C0C0C0");
                        else
                            playerShipsButtons[j][i].setStyle("-fx-background-color: #000000");  
                    }
                }

                Board playerHits = getSession().getGame().getPlayerOneHits();
                for (int i = 0; i < 10; i++){
                    for (int j = 0; j < 10; j++){
                        //System.out.println("j,i,grid: "+j+" "+i+" "+a.grid[j][i]);
                        if(playerHits.grid[j][i] == "H")
                            hitButtons[j][i].setStyle("-fx-background-color: #00FFFF");
                        else if (playerHits.grid[j][i] == "M")
                            hitButtons[j][i].setStyle("-fx-background-color: #008080"); 
                        else if (playerHits.grid[j][i] == " ")
                            hitButtons[j][i].setStyle("-fx-background-color: #000080"); 
                        
                    }
                }                
                
            }            
        }.start();
        
        setScene(new Scene(root, 1000, 500));
        display();
    }

}
