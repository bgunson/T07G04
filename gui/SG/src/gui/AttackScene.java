package gui;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.Game;
import logic.Board;
import Audio.AudioController;
import drivers.BattleshipGalactica;
import handlers.BtnAttackHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.animation.AnimationTimer;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import logic.ShipTeam;
import javafx.scene.shape.Circle;
import java.io.*;

public class AttackScene extends BaseScene{

    private final Button[][] playerShipsButtons = new Button[10][10];
    private final Button[][] hitButtons = new Button[10][10];
    private int frame = 0;
    
    public String individualFrames[][] = { // animates the playerHits
            {"44","45","54","55"}, // Frame 1
            {"34","35","43","53","64","65","46","56"}, // Frame 2
            {"33","42","52","63","74","75","66","57","47","36","25","24"}, // Frame 3
            {"41","51","62","73","84","85","76","67","58","48","37","26","15","14","23","32"}, // Frame 4
            {"21","31","40","50","61","71","82","83","94","95","86","87","78","68","59","49","38","28","17","16","05","04","13","12"}, // Frame 5
            {"03","02","11","20","30", "60","70","81","92","93", "96","97","88","79","69", "39","29","18","07","06"}, // Frame 6
            {"00","90","99","09"} }; // Frame 7


    public AttackScene(BattleshipGalactica session){
        super(session);
    }

    @Override
    /**
     *  initializes all the componenets required for the scene to work
     */
    public void setup(){

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10, 30, 30, 30));
        GridPane playerPane = new GridPane();
        GridPane enemyPane = new GridPane();
        playerPane.setAlignment(Pos.CENTER);
        enemyPane.setAlignment(Pos.CENTER);
        root.setLeft(playerPane);
        root.setRight(enemyPane);

        StackPane pane = new StackPane();
        Image pic = new Image("/Resources/Images/Stars.png", 1000, 650, false, true);
        
        ImageView imageView = new ImageView();
        imageView.setImage(pic);
        imageView.setLayoutX(0);
        imageView.setLayoutY(0);
        pane.getChildren().add(imageView);

        Game a = getSession().getGame();
        a.getPlayerShips().boardDisplay();

        // Label that displays the ai's last shot
        Text aiTurnLabel = new Text();
        aiTurnLabel.setFont(Font.font("courier", 20));
        aiTurnLabel.setFill(Color.WHITESMOKE);
        root.setBottom(aiTurnLabel);
        Image player = new Image(getClass().getResourceAsStream("playerShip1.png"));
        Image playerD = new Image(getClass().getResourceAsStream("playerShipDestroyed.png"));
        Image playerDFinal = new Image(getClass().getResourceAsStream("playerShipFinal.png"));
        Image enemyD = new Image(getClass().getResourceAsStream("enemyShipDestroyed.png"));
        
        // Sets up the ships buttons that update in color as players board updates
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                playerShipsButtons[j][i] = new Button();
                playerShipsButtons[j][i].setPrefSize(39,39);
                playerShipsButtons[j][i].setMinSize(39,39);
                playerShipsButtons[j][i].setMaxSize(39,39);
                playerShipsButtons[j][i].setStyle("-fx-background-color: #000000");
                playerPane.add(playerShipsButtons[j][i], j, i);
                playerPane.setHalignment(playerShipsButtons[j][i],HPos.CENTER);
            }
        }



        // sets up hits buttons which update in color as you hit stuff
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                BtnAttackHandler pHandler = new BtnAttackHandler(getSession(), j, i);

                hitButtons[j][i] = new Button();
                hitButtons[j][i].setPrefSize(39,39);
                hitButtons[j][i].setMinSize(39,39);
                hitButtons[j][i].setMaxSize(39,39);
                hitButtons[j][i].setStyle("-fx-background-color: #000080");
                hitButtons[j][i].setOnAction(pHandler);

                enemyPane.add(hitButtons[j][i], j+24, i);
                enemyPane.setHalignment(hitButtons[j][i],HPos.CENTER);
            }
        }


        
        
        new AnimationTimer(){
            //Timer for the animations
            public void handle(long now){
                
                // Animates enemy radar
                frame++;
                if (frame == 49)
                    frame = 2;

                // Updates players Board as shots are fired
                Board playerShips = getSession().getGame().getPlayerShips();
                for (int i = 0; i < 10; i++){
                    for (int j = 0; j < 10; j++){
                        //System.out.println("j,i,grid: "+j+" "+i+" "+a.grid[j][i]);
                        if( playerShips.getGrid()[j][i] == "G" )
                            playerShipsButtons[j][i].setGraphic(new ImageView(player));
                        else if (playerShips.getGrid()[j][i] == "D"){
                            //if (flash > 25){
                                playerShipsButtons[j][i].setGraphic(new ImageView(playerD));
                                //Image gif = new Image("/Resources/Images/MovingFireFast.gif", 25, 25, false, true);
                                //playerShipsButtons[j][i].setGraphic(new ImageView(gif));
                            //}
                            //else
                            //    playerShipsButtons[j][i].setStyle("-fx-background-color: #008000");
                        }
                        else if (playerShips.getGrid()[j][i] == "F")
                            playerShipsButtons[j][i].setGraphic(new ImageView(playerDFinal));
                        else
                            playerShipsButtons[j][i].setStyle("-fx-background-color: #000000");
                    }
                }

                Board playerHits = getSession().getGame().getPlayerHits();
                for (int i = 0; i < 10; i++){
                    for (int j = 0; j < 10; j++){
                        //System.out.println("j,i,grid: "+j+" "+i+" "+a.grid[j][i]);
                        if(playerHits.getGrid()[j][i] == "H")
                            hitButtons[j][i].setGraphic(new ImageView(enemyD));
                        else if (playerHits.getGrid()[j][i] == "M")
                            hitButtons[j][i].setStyle("-fx-background-color: #164C72");
                        else if (playerHits.getGrid()[j][i] == " ")
                            hitButtons[j][i].setStyle("-fx-background-color: #171823");  
                    }

                }
                
                for (int a = individualFrames[(int)(frame/7)].length; a>0; a--){
                    String b = individualFrames[(int)(frame/7)][a-1];
                    if( playerHits.getGrid()[Integer.valueOf(b.substring(0,1))][Integer.valueOf(b.substring(1,2))].equals(" ") ){
                        hitButtons[Integer.valueOf(b.substring(0,1))][Integer.valueOf(b.substring(1,2))].setStyle("-fx-background-color: #262839");
                    }
            }
                
                
                // Get human and ai's ShipTeam
                ShipTeam aiTeam = getSession().getGame().getAiFleet();
                ShipTeam pOneTeam = getSession().getGame().getPlayerFleet();
                // Check if someone has won.
                if (pOneTeam.isEveryShipDestroyed()) {
                    EndScene end = new EndScene(getSession(), "You lose!");
                    end.setup();
                }
                else if (aiTeam.isEveryShipDestroyed()) {
                    EndScene end = new EndScene(getSession(), "You beat the computer!");
                    end.setup();
                }
                //
                aiTurnLabel.setText(getSession().getGame().getAiLastShot());

            }
        }.start();
        pane.getChildren().add(root);
        setScene(new Scene(pane, 1000, 575));
        display();
    }

}
