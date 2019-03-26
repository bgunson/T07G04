/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipgalactica;
import java.util.Random;
/**
 *
 * @author Fabian Aryo Pradipto
 */
public class EnemyShip extends Ship {
    private static Boolean[][] enemyShipPlacement = new Boolean[10][10];
    
    
    public EnemyShip(int shipLength, String name) {
        super(shipLength, name);
    }
    
    public void placeShips(int length, boolean ship[][])
    {   
        Random randPosition = new Random();
        Random rand = new Random();
        int row = rand.nextInt(10);
        int column = rand.nextInt(10);
        
        int shipOrientation = randPosition.nextInt(4);
        if((shipOrientation == 0)) //upwards
        {
            ship[row][column] = true;
            for(int i = 0; i < length-1; i++)
            {
                
            }
        }
        else if(shipOrientation == 1) //downwards
        {
            ship[row][column] = true;
            for(int i = 0; i < length; i++)
            {
            
            }
        }
        else if(shipOrientation == 2) //left
        {
            ship[row][column] = true;
            for(int i = 0; i < length; i++)
            {
            
            }
        }
        else if(shipOrientation == 3)//right
        {
            ship[row][column] = true;
            for(int i = 0; i < length; i++)
            {
            
            }
        }
    }
    
    public double getShipLength()
    {
        return super.getName();
    }
    
    public String getShipName()
    {
        return super.getShipName();
    }
    
     public static void main(String[] args) {
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                enemyShipPlacement[i][j] = false;
                System.out.println(enemyShipPlacement[i][j]);
            }
        }
    }
    
}
