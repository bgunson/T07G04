package gui;


import java.io.File;

import Audio.AudioController;
import drivers.BattleshipGalactica;
import handlers.BtnQuitHandler;
import handlers.BtnStartHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

/*
The first scene (main menu) is the first scene the user sees when the app. is run. User can start, quit or get help.
 */
public class FirstScene extends BaseScene{
    // Music
	private AudioController backgroundMusic;

    /**
     * Constructs a scene with the current driver.
     * @param battleshipGalactica the session in progress.
     */
    public FirstScene(BattleshipGalactica battleshipGalactica){
        super(battleshipGalactica);
    }


    /**
     * Override the parent setup method.
     */
	@Override
    public void setup(){
        Button start = new Button("Start");
        Button quit = new Button("Quit");

        VBox box = new VBox();
        box.getChildren().add(start);
        box.getChildren().add(quit);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(40);

        StackPane pane = new StackPane();
        Image pic = new Image("/Resources/Images/startMenu1.png", 800, 650, false, true);
        ImageView imageView = new ImageView();
        imageView.setImage(pic);
        imageView.setLayoutX(0);
        imageView.setLayoutY(0);
        pane.getChildren().add(imageView);
      


        pane.getChildren().add(box);
        pane.setAlignment(Pos.CENTER);

        BtnQuitHandler qHandler = new BtnQuitHandler();
        quit.setOnAction(qHandler);

        BtnStartHandler sHandler = new BtnStartHandler(getSession());
        start.setOnAction(sHandler);

        setScene(new Scene(pane, 800, 650));
        display();
    }

    /**
     * @return the music.
     */
    public AudioController getMusic() 
    {
    	return this.backgroundMusic;
    }
}

