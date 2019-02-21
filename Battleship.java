import java.util.Random;

public class Battleship {
    private int shipLength = 0;
    private boolean shipStatus = true;
    private final int amtRow = 10;
    private final int amtColumn = 10;
    Battleship[] ships = new Battleship[5];
    
    public Battleship(int shipLength, boolean shipStatus)
    {
        this.shipLength = shipLength;
        this.shipStatus = shipStatus;
    }
    
    public Battleship(Battleship b)
    {   
        shipLength = b.getShipLength();
        shipStatus = b.getShipStatus();
    }
    
    public int getShipLength()
    {
       return shipLength;
    }
    
    public boolean getShipStatus()
    {
        return shipStatus;
    }
    
    public void placeShipRight(int row, int column)
    {
        if(column != 9)
        {
            
        }
    }
    
    public void placeShipLeft(int row, int column)
    {
        if(column != 0)
        {
            
        }
    }
    
    public void placeShipUp(int row, int column)
    {
        if(row != 0)
        {
            
        }    
    }
    
    public void placeShipDown(int row, int column)
    {
        if(row != 9)
        {
            
        }
    
    }
}
