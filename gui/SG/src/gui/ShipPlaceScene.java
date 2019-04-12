package gui;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.Game;
import logic.Board;
import Audio.AudioController;
import drivers.BattleshipGalactica;
import handlers.BtnPlaceShipHandler;
import handlers.BtnSwitchOrientationHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.animation.AnimationTimer;
import javafx.geometry.HPos;
import javafx.geometry.Pos;

public class ShipPlaceScene extends BaseScene {

    // Stores the buttons which are used to place ships
    private final Button[][] PlayerPaneButtons = new Button[10][10];

    // Creates the second scene
    public ShipPlaceScene(BattleshipGalactica session){
        super(session);
    }

    @Override
    public void setup(){

        BorderPane root = new BorderPane();
        GridPane playerPane = new GridPane();
        playerPane.setGridLinesVisible(true);
        playerPane.setAlignment(Pos.CENTER);
        root.setCenter(playerPane);

        Game a = getSession().getGame();

        // Sets up the background image
        StackPane pane = new StackPane();
        Image pic = new Image("/Resources/Images/background1.png", 1000, 500, false, true);
        ImageView imageView = new ImageView();
        imageView.setImage(pic);
        imageView.setLayoutX(0);
        imageView.setLayoutY(0);
        pane.getChildren().add(imageView);
        Image player = new Image(getClass().getResourceAsStream("playerShip1.png"));
        
		
		//backgroundMusic.playSong();

        // Sets up the player buttons
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                //Button b = new Button( Integer.toString(i)+Integer.toString(j) );
                BtnPlaceShipHandler pHandler = new BtnPlaceShipHandler(getSession(), j, i);
                //b.setOnAction(pHandler);

                PlayerPaneButtons[j][i] = new Button();
                PlayerPaneButtons[j][i].setPrefSize(39,39);
                PlayerPaneButtons[j][i].setMinSize(39,39);
                PlayerPaneButtons[j][i].setMaxSize(39,39);
                PlayerPaneButtons[j][i].setStyle("-fx-background-color: #FFFFFF");
                PlayerPaneButtons[j][i].setOnAction(pHandler);
                playerPane.add(PlayerPaneButtons[j][i], j, i);
                playerPane.setHalignment(PlayerPaneButtons[j][i],HPos.CENTER);
            }
        }


        // Button that changes the orientation
        BtnSwitchOrientationHandler pHandler = new BtnSwitchOrientationHandler(getSession());
        Button orientation = new Button("Switch orientation");
        // Text that labels current orientation selection.
        Text oText = new Text(a.getOrientation());
        oText.setFont(Font.font("courier", 20));
        oText.setFill(Color.WHITE);

        // Text that displays whether the last placement was valid or not... nothing if good, prompt if bad place.
        Text placeText = new Text();
        placeText.setFont(Font.font("courier", 16));
        placeText.setFill(Color.RED);

        orientation.setPrefSize(150,30);
        orientation.setMinSize(150,30);
        orientation.setMaxSize(150,30);

        orientation.setOnAction(pHandler);

        // VBox with orientation label and button.
        VBox oBox = new VBox();
        oBox.getChildren().addAll(oText, orientation, placeText);
        oBox.setAlignment(Pos.CENTER);

        root.setBottom(oBox);

        new AnimationTimer(){
            //VBox oBox = new VBox();
            public void handle(long now){
                Board a = getSession().getGame().getPlayerShips();
                for (int i = 0; i < 10; i++){
                    for (int j = 0; j < 10; j++){
                        if(a.getGrid()[j][i].equals("G"))
                            PlayerPaneButtons[j][i].setGraphic(new ImageView(player));
                        else
                            PlayerPaneButtons[j][i].setStyle("-fx-background-color: #000000");
                    }
                }
                oText.setText(getSession().getGame().getOrientation());
                placeText.setText(getSession().getGame().getGoodPlace());
            }
        }.start();

        //firstRow.getChildren().add(sceneA());
        pane.getChildren().add(root);
        setScene(new Scene(pane, 1000, 500));
        display();
    }

}

