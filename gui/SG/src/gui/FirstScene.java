package gui;

import drivers.BattleshipGalatica;
import handlers.BtnQuitHandler;
import handlers.BtnStartHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

public class FirstScene extends BaseScene{
    
    public FirstScene(BattleshipGalatica battleshipGalatica){
        super(battleshipGalatica);
    }
    
    @Override
    public void setup(){
        Button start = new Button("Start");
        Button quit = new Button("Quit");
        
        VBox box = new VBox();
        box.getChildren().add(start);
        box.getChildren().add(quit);
        box.setAlignment(Pos.CENTER);
        
        StackPane pane = new StackPane();
		Image pic = new Image("https://raw.githubusercontent.com/bgunson/T07G04/master/startMenu1.png", 1000, 500, false, true);
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
	
        setScene(new Scene(pane, 1000, 500));
        display();
    }
}