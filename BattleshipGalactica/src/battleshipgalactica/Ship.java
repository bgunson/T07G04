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
import java.util.ArrayList;
/*
Ship object that can take any specified length x width size and keeps track of its number of hits which can
tell us if it is destroyed or not at any certain point in the game.
 */
public class Ship{
	
	// pretty much the same but keeps track of hits
	// so we can update board once it sinks
	
	
	// Keeps track of where it is on the board
	private ArrayList<String> coordinates;
	// Keeps track of which parts of it is destroyed
	private ArrayList<String> destroyed;

	// Keeps track of if the whole ship is destroyed
    public boolean sunk = false;

    public int shipLength;
	public String name;
	
    public Ship(int shipLength, String name){
        this.shipLength = shipLength;
		this.name = name;
		
		coordinates = new ArrayList<String>();
		destroyed = new ArrayList<String>();
		
    }

	public ArrayList<String> getCoordinates(){
		return coordinates;
	}

	public ArrayList<String> getDestroyed(){
		return destroyed;
	}	
	
	public void placedShip( String[] wherePlaced ){
		
		// Update the coordinates Array with wherePlaced
	}


	// check the array of coordinates and see if the shot landed
	// If landed, update destroyed, check isDestroyed and return true
	// else return false	
	public boolean checkHit( String xy ){
		for (String a : coordinates){
			if (a == xy){
				
				destroyed.add( xy);
				
				
				checkDestroyed();
				return true;
			}
		}
		return false;
	}
	
    public void checkDestroyed(){
		if (destroyed.size() == coordinates.size())
			sunk = true;
    }
		
    public double getShipLength()
    {
        return shipLength;
    }
    
    public String getShipName()
    {
        return name;
    }

    double getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
