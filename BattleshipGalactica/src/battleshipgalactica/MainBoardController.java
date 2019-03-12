/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipgalactica;

import java.awt.event.ActionListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 *
 * @author Fabian Aryo Pradipto
 */
public class MainBoardController{
    private final int ROWS = 10;
    private final int COLUMNS =10;
    private int shipCounter = 0;
    private Button[][] PlayerPaneButtons = new Button[ROWS][COLUMNS];
    private Button[][] EnemyPaneButtons = new Button[ROWS][COLUMNS];

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
    private TextField RowField;
    @FXML
    private TextField ColumnField;
    @FXML
    private Button startGameButton;

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
    
    public void initialize() {
        addButtonPlayerPane();
        addButtonEnemyPane();
    }
    
    /**
     * Adds all 100 button to PlayerPane
     */
    public void addButtonPlayerPane()
    {
        for(int i = 0; i < ROWS; i++)
        {
            for(int j = 0; j < COLUMNS; j++)
            {
                PlayerPaneButtons[i][j] = new Button();
                PlayerPaneButtons[i][j].setPrefSize(39,39);
                PlayerPaneButtons[i][j].setMinSize(39,39);
                PlayerPaneButtons[i][j].setMaxSize(39,39);
                PlayerPaneButtons[i][j].setStyle("-fx-background-color: #000000");
                PlayerPane.add(PlayerPaneButtons[i][j], j, i);
                PlayerPane.setHalignment(PlayerPaneButtons[i][j],HPos.CENTER);
                
                PlayerPaneButtons[i][j].setOnAction(buttonHandler);
            }
        }
    }
    
    /**
     * Adds all 100 button to enemyPane
     */
    public void addButtonEnemyPane()
    {
        for(int i = 0; i < ROWS; i++)
        {
            for(int j = 0; j < COLUMNS; j++)
            {
                EnemyPaneButtons[i][j] = new Button();
                EnemyPaneButtons[i][j].setPrefSize(39,39);
                EnemyPaneButtons[i][j].setMinSize(39,39);
                EnemyPaneButtons[i][j].setMaxSize(39,39);
                EnemyPaneButtons[i][j].setStyle("-fx-background-color: #000000");
                EnemyPane.add(EnemyPaneButtons[i][j], j, i);   
                EnemyPane.setHalignment(EnemyPaneButtons[i][j],HPos.CENTER);
                
                EnemyPaneButtons[i][j].setOnAction(enemyButton);
            }
        }
    }
    
    public void setNullToZero(GridPane panel, ActionEvent event)
    {
        if(panel.getRowIndex((Button)event.getSource()) == null && panel.getColumnIndex((Button)event.getSource()) == null)
        {
            panel.setRowIndex((Button)event.getSource(), 0);
            panel.setColumnIndex((Button)event.getSource(), 0);
        }
        else if(panel.getRowIndex((Button)event.getSource()) == null)
        {
            panel.setRowIndex((Button)event.getSource(), 0);
        }
        else if(panel.getColumnIndex((Button)event.getSource()) == null)
        {
            panel.setColumnIndex((Button)event.getSource(), 0);
        }
    }
    
    
    EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent e) {
        boolean m = true;
        Button currButton = (Button)e.getSource();
        if(m == false)
        {
            currButton.setStyle("-fx-background-color: #109856");
        }
        else
        {
            currButton.setStyle("-fx-background-color: #CD5C5C");
        }
    }
};
    
    EventHandler<ActionEvent> enemyButton = new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        EnemyBoard enemyPos = new EnemyBoard();
        Button currButton = (Button)event.getSource();
        
        setNullToZero(EnemyPane, event);
        int rowValue = PlayerPane.getRowIndex(currButton);
        int colValue = PlayerPane.getColumnIndex(currButton);
        
        if(enemyPos.shipExist(rowValue, colValue) == true)
        {
            currButton.setStyle("-fx-background-color: #FF0000");
        }
        else
        {
            currButton.setText("M");
            currButton.setStyle("-fx-background-color: #FFFF00");
        }
    }
};

    
    @FXML
    private void startClick(ActionEvent event) {
    /**
     *
        EnemyBoard eBoard = new EnemyBoard();
        
        EnemyShip Carrier = new EnemyShip(5, "Carrier");
        EnemyShip Battleship = new EnemyShip(4, "Battleship");
        EnemyShip Cruiser = new EnemyShip(3, "Cruiser");
        EnemyShip Fighter = new EnemyShip(3, "Fighter");
        EnemyShip Destroyer = new EnemyShip(2, "Destroyer");
        
        Carrier.placeShips(5, eBoard.getEnemyShipPlacement());
        Battleship.placeShips(4, eBoard.getEnemyShipPlacement());
        Cruiser.placeShips(3, eBoard.getEnemyShipPlacement());
        Fighter.placeShips(3, eBoard.getEnemyShipPlacement());
        Destroyer.placeShips(2, eBoard.getEnemyShipPlacement());
     */
    }
   
}


