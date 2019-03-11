/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipgalactica;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Fabian Aryo Pradipto
 */
public class StartMenuController {

    @FXML
    private Button startButton;
    @FXML
    private Button exitButton;

    /**
     * Opens the battleship game board
     * @param event 
     */
    @FXML
    private void openMainBoard(ActionEvent event){               
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainBoard.fxml"));
        Parent rootBoard = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Battleship Galactica");
        stage.setScene(new Scene(rootBoard));
        stage.setResizable(false);
        stage.show();
    } catch(IOException e) {
    
    }
        Stage stage = (Stage) startButton.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void exitGame(ActionEvent event){               
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
    
}
