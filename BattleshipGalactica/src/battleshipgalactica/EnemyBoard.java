/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipgalactica;

/**
 *
 * @author Fabian Aryo Pradipto
 */
public class EnemyBoard {
    private static Boolean[][] enemyShipPlacement = new Boolean[10][10];
    
    public EnemyBoard()
    {
     for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                enemyShipPlacement[i][j] = false;
            }
        }
     enemyShipPlacement[0][0] = true;
     enemyShipPlacement[1][0] = true;
     enemyShipPlacement[2][0] = true;
     enemyShipPlacement[3][0] = true;
     enemyShipPlacement[4][0] = true;
     
     enemyShipPlacement[9][9] = true;
     enemyShipPlacement[9][8] = true;
     enemyShipPlacement[9][7] = true;
    }
    
    public boolean shipExist(int row, int column)
    {
        return enemyShipPlacement[row][column];
    }
    
    public Boolean[][] getEnemyShipPlacement()
    {
        return enemyShipPlacement;
    }
}
