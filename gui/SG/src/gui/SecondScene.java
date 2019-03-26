package gui;

import logic.Game;
import logic.Board;
import drivers.BattleshipGalatica;
import handlers.BtnPlaceShipHandler;
import handlers.BtnSwitchOrientationHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.animation.AnimationTimer;
import javafx.geometry.HPos;

public class SecondScene extends BaseScene{
    
    // Stores the buttons which are used to place ships
    private final Button[][] PlayerPaneButtons = new Button[10][10];
    
    // Creates the second scene
    public SecondScene(BattleshipGalatica session){
        super(session);
    }
    
    @Override
    public void setup(){
        
        GridPane root = new GridPane();

        Game a = getSession().getGame();
        
        // Sets up the background image
        StackPane pane = new StackPane();
        Image pic = new Image("https://raw.githubusercontent.com/bgunson/T07G04/master/menupicture.png", 1000, 500, false, true);
	ImageView imageView = new ImageView();
	imageView.setImage(pic);
	imageView.setLayoutX(0);
	imageView.setLayoutY(0);
	pane.getChildren().add(imageView);
       
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
                root.add(PlayerPaneButtons[j][i], j, i);
                root.setHalignment(PlayerPaneButtons[j][i],HPos.CENTER);
            }
        }

        // sets up the blank space between the two boards
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 5; j++){
                Button q = new Button();
                q.setPrefSize(39,39);
                q.setMinSize(39,39);
                q.setMaxSize(39,39);
                q.setStyle("-fx-background-color: #FFFFFF");
                q.setVisible(false);
                root.add(q, j+12, i);
            }
        }

        // Greyed out player hits board
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                Button q = new Button();
                q.setPrefSize(39,39);
                q.setMinSize(39,39);
                q.setMaxSize(39,39);
                q.setStyle("-fx-background-color: #808080");
                root.add(q, j+24, i);
            }
        }

        // Button that changes the orientation
        BtnSwitchOrientationHandler pHandler = new BtnSwitchOrientationHandler(getSession());
        Button orientation = new Button("Switch orientation");
        
        orientation.setPrefSize(39,39);
        orientation.setMinSize(39,39);
        orientation.setMaxSize(39,39);
        
        orientation.setOnAction(pHandler);
        root.add(orientation, 0, 11);
        
        new AnimationTimer(){
            public void handle(long now){
                Board a = getSession().getGame().getPlayerOneShips();
                for (int i = 0; i < 10; i++){
                    for (int j = 0; j < 10; j++){
                        if(a.grid[j][i] == "G")
                            PlayerPaneButtons[j][i].setStyle("-fx-background-color: #109856");
                        else
                            PlayerPaneButtons[j][i].setStyle("-fx-background-color: #000000");
                    }
                }
            }
            
        }.start();
        
        //firstRow.getChildren().add(sceneA());
        pane.getChildren().add(root);
        setScene(new Scene(pane, 1000, 500));
        display();
    }

    /**
    public Node sceneA(){
        
        Group root = new Group();
        root.getChildren().add();
        
        return root;
        
    }
    */

}
