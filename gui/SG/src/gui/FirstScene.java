package gui;


import java.io.File;

import Audio.AudioController;
import drivers.BattleshipGalactica;
import handlers.BtnQuitHandler;
import handlers.BtnStartHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FirstScene extends BaseScene{
	private AudioController backgroundMusic;
	
	
    public FirstScene(BattleshipGalactica battleshipGalactica){
        super(battleshipGalactica);
    }



	@Override
    public void setup(){
        Button start = new Button("Start");
        Button quit = new Button("Quit");
        Button help = new Button("Help");

        VBox box = new VBox();
        box.getChildren().add(start);
        box.getChildren().add(quit);
        box.getChildren().add(help);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(20);

        StackPane pane = new StackPane();
        Image pic = new Image("/Resources/Images/startMenu1.png", 800, 650, false, true);
        ImageView imageView = new ImageView();
        imageView.setImage(pic);
        imageView.setLayoutX(0);
        imageView.setLayoutY(0);
        pane.getChildren().add(imageView);
      


        pane.getChildren().add(box);
        pane.setAlignment(Pos.CENTER);
        
        help.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            StackPane pane = new StackPane();
            Image pic = new Image("/Resources/Images/help.png", 425, 325, false, true);
            ImageView imageView = new ImageView();
            imageView.setImage(pic);
            imageView.setLayoutX(0);
            imageView.setLayoutY(0);
            pane.getChildren().add(imageView);
            Stage stage = new Stage();
            stage.setScene(new Scene(pane));
            stage.show();
            }
        });

        BtnQuitHandler qHandler = new BtnQuitHandler();
        quit.setOnAction(qHandler);

        BtnStartHandler sHandler = new BtnStartHandler(getSession());
        start.setOnAction(sHandler);

        setScene(new Scene(pane, 800, 650));
        display();
    }
    public AudioController getMusic() 
    {
    	return this.backgroundMusic;
    }
}

