package gui;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.Game;
import logic.Board;
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

public class AttackScene extends BaseScene{

    private final Button[][] playerShipsButtons = new Button[10][10];
    private final Button[][] hitButtons = new Button[10][10];
    private int flash = 0;


    public AttackScene(BattleshipGalactica session){
        super(session);
    }

    @Override
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
        Image pic = new Image("https://raw.githubusercontent.com/bgunson/T07G04/master/Stars.png", 1000, 650, false, true);
        ImageView imageView = new ImageView();
        imageView.setImage(pic);
        imageView.setLayoutX(0);
        imageView.setLayoutY(0);
        pane.getChildren().add(imageView);

        Game a = getSession().getGame();
        a.getPlayerOneShips().boardDisplay();

        // Label that displays the ai's last shot
        Text aiTurnLabel = new Text();
        aiTurnLabel.setFont(Font.font("courier", 20));
        aiTurnLabel.setFill(Color.WHITESMOKE);
        root.setBottom(aiTurnLabel);


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
                // Get human and ai's ShipTeam
                ShipTeam aiTeam = getSession().getGame().getAiFleet();
                ShipTeam pOneTeam = getSession().getGame().getPlayerOneFleet();
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