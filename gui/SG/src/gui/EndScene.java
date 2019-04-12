package gui;

import drivers.BattleshipGalactica;
import handlers.BtnQuitHandler;
import handlers.BtnReplayHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.text.*;

/*
The final scene after a game concludes, further gives the user the option to play again or quit the application.
 */
public class EndScene extends BaseScene{

    // String representing the winning message.
	private String winner;

    /**
     * Constructs the scene.
     * @param battleshipGalatica, the current driver.
     * @param winner, the message that syays who won the game.
     */
    public EndScene(BattleshipGalactica battleshipGalatica, String winner){
        super(battleshipGalatica);
        this.winner = winner;
    }

    /**
     * Override the parent setup method.
     */
    @Override
    public void setup(){
        Button replay = new Button("Replay");
        Button quit = new Button("Quit");
        
        Text winnerDisplay = new Text(winner);
        winnerDisplay.setFont(Font.font("courier", 30));
        winnerDisplay.setFill(Color.YELLOW);
        
        VBox box = new VBox();
        box.getChildren().add(winnerDisplay);
        box.getChildren().add(replay);
        box.getChildren().add(quit);
        box.setAlignment(Pos.CENTER);
        
        if(winner.equals("You lose!"))
        {
        StackPane pane = new StackPane();
		Image pic = new Image("https://raw.githubusercontent.com/bgunson/T07G04/master/endSceneLose.png", 800, 650, false, true);
		ImageView imageView = new ImageView();
		imageView.setImage(pic);
		imageView.setLayoutX(0);
		imageView.setLayoutY(0);
		pane.getChildren().add(imageView);
		
        pane.getChildren().add(box);
        pane.setAlignment(Pos.CENTER);
        
        BtnQuitHandler qHandler = new BtnQuitHandler();
        quit.setOnAction(qHandler);
                
        BtnReplayHandler sHandler = new BtnReplayHandler(getSession()); // problem here. need to make new game
        replay.setOnAction(sHandler);
	
        setScene(new Scene(pane, 800, 650));
        display();
        }
        
        else
        {
         StackPane pane = new StackPane();
		Image pic = new Image("https://raw.githubusercontent.com/bgunson/T07G04/master/endSceneWin.png", 800, 650, false, true);
		ImageView imageView = new ImageView();
		imageView.setImage(pic);
		imageView.setLayoutX(0);
		imageView.setLayoutY(0);
		pane.getChildren().add(imageView);
		
        pane.getChildren().add(box);
        pane.setAlignment(Pos.CENTER);
        
        BtnQuitHandler qHandler = new BtnQuitHandler();
        quit.setOnAction(qHandler);
                
        BtnReplayHandler sHandler = new BtnReplayHandler(getSession()); // problem here. need to make new game
        replay.setOnAction(sHandler);
	
        setScene(new Scene(pane, 800, 650));
        display();
        }
    }
}