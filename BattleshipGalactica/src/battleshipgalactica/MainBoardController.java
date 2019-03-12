/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipgalactica;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

/**
 *
 * @author Fabian Aryo Pradipto
 */
public class MainBoardController {
    private final int ROWS = 10;
    private final int COLUMNS =10;
    private int shipCounter = 0;

    @FXML
    private SplitPane SplitPane;
    @FXML
    private GridPane PlayerPane;
    @FXML
    private GridPane EnemyPane;
    
    @FXML
    private Button fiveShipButton;
    @FXML
    private Button fourShipButton;
    @FXML
    private Button threeShip1Button;
    @FXML
    private Button threeShip2Button;
    @FXML
    private Button twoShipButton;
    @FXML
    private Button JButton;
    @FXML
    private TextField RowField;
    @FXML
    private TextField ColumnField;
    @FXML
    private Button JButton1;
    @FXML
    private Button JButton2;
    @FXML
    private Button JButton3;
    @FXML
    private Button JButton4;
    @FXML
    private Button JButton5;
    @FXML
    private Button JButton6;
    @FXML
    private Button JButton7;
    @FXML
    private Button JButton8;
    @FXML
    private Button JButton9;
    @FXML
    private Button JButton11;
    @FXML
    private Button JButton12;
    @FXML
    private Button JButton13;
    @FXML
    private Button JButton14;
    @FXML
    private Button JButton15;
    @FXML
    private Button JButton16;
    @FXML
    private Button JButton17;
    @FXML
    private Button JButton18;
    @FXML
    private Button JButton19;
    @FXML
    private Button JButton20;
    @FXML
    private Button JButton22;
    @FXML
    private Button JButton23;
    @FXML
    private Button JButton24;
    @FXML
    private Button JButton25;
    @FXML
    private Button JButton26;
    @FXML
    private Button JButton27;
    @FXML
    private Button JButton28;
    @FXML
    private Button JButton29;
    @FXML
    private Button JButton30;
    @FXML
    private Button JButton31;
    @FXML
    private Button JButton33;
    @FXML
    private Button JButton34;
    @FXML
    private Button JButton35;
    @FXML
    private Button JButton36;
    @FXML
    private Button JButton37;
    @FXML
    private Button JButton38;
    @FXML
    private Button JButton39;
    @FXML
    private Button JButton40;
    @FXML
    private Button JButton41;
    @FXML
    private Button JButton42;
    @FXML
    private Button JButton44;
    @FXML
    private Button JButton45;
    @FXML
    private Button JButton46;
    @FXML
    private Button JButton47;
    @FXML
    private Button JButton48;
    @FXML
    private Button JButton49;
    @FXML
    private Button JButton50;
    @FXML
    private Button JButton51;
    @FXML
    private Button JButton52;
    @FXML
    private Button JButton53;
    @FXML
    private Button JButton55;
    @FXML
    private Button JButton56;
    @FXML
    private Button JButton57;
    @FXML
    private Button JButton58;
    @FXML
    private Button JButton59;
    @FXML
    private Button JButton60;
    @FXML
    private Button JButton61;
    @FXML
    private Button JButton62;
    @FXML
    private Button JButton63;
    @FXML
    private Button JButton64;
    @FXML
    private Button JButton66;
    @FXML
    private Button JButton67;
    @FXML
    private Button JButton68;
    @FXML
    private Button JButton69;
    @FXML
    private Button JButton70;
    @FXML
    private Button JButton71;
    @FXML
    private Button JButton72;
    @FXML
    private Button JButton73;
    @FXML
    private Button JButton74;
    @FXML
    private Button JButton75;
    @FXML
    private Button JButton77;
    @FXML
    private Button JButton78;
    @FXML
    private Button JButton79;
    @FXML
    private Button JButton80;
    @FXML
    private Button JButton81;
    @FXML
    private Button JButton82;
    @FXML
    private Button JButton83;
    @FXML
    private Button JButton84;
    @FXML
    private Button JButton85;
    @FXML
    private Button JButton86;
    @FXML
    private Button JButton88;
    @FXML
    private Button JButton10;
    @FXML
    private Button JButton21;
    @FXML
    private Button JButton32;
    @FXML
    private Button JButton43;
    @FXML
    private Button JButton54;
    @FXML
    private Button JButton65;
    @FXML
    private Button JButton76;
    @FXML
    private Button JButton87;
    @FXML
    private Button JButton89;
    @FXML
    private Button JButton90;
    @FXML
    private Button JButton91;
    @FXML
    private Button JButton92;
    @FXML
    private Button JButton93;
    @FXML
    private Button JButton94;
    @FXML
    private Button JButton95;
    @FXML
    private Button JButton96;
    @FXML
    private Button JButton97;
    @FXML
    private Button JButton98;
    @FXML
    private Button JButton99;

    @FXML
    private void placeShip5(ActionEvent event) {
        
    }

    @FXML
    private void placeShip4(ActionEvent event) {
    }

    @FXML
    private void placeShip1_3(ActionEvent event) {
    }

    @FXML
    private void PlaceShip2_3(ActionEvent event) {
    }

    @FXML
    private void placeShip2(ActionEvent event) {
    }

    @FXML
    private void ClickButton(ActionEvent event) {
    if(shipCounter < 17)
    {   
        if(PlayerPane.getRowIndex((Button)event.getSource()) == null && PlayerPane.getColumnIndex((Button)event.getSource()) == null)
        {
            PlayerPane.setRowIndex((Button)event.getSource(), 0);
            PlayerPane.setColumnIndex((Button)event.getSource(), 0);
        }
        else if(PlayerPane.getRowIndex((Button)event.getSource()) == null)
        {
            PlayerPane.setRowIndex((Button)event.getSource(), 0);
        }
        else if(PlayerPane.getColumnIndex((Button)event.getSource()) == null)
        {
            PlayerPane.setColumnIndex((Button)event.getSource(), 0);
        }
        
        int rowValue = PlayerPane.getRowIndex((Button)event.getSource());
        int colValue = PlayerPane.getColumnIndex((Button)event.getSource());
        
        Button currButton = (Button)event.getSource();
        
        int currRow = PlayerPane.getRowIndex(currButton);
        int currColumn = PlayerPane.getColumnIndex(currButton);
        currButton.setStyle("-fx-background-color: #109856");
        
        RowField.setText(String.valueOf(rowValue));
        ColumnField.setText(String.valueOf(colValue));
        shipCounter++;
    }
    }
}

