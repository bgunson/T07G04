package logic;

import java.util.ArrayList;

public class Ship {
// Keeps track of where it is on the board
    private ArrayList<String> coordinates;
	
    // Keeps track of which parts of it are destroyed
    private ArrayList<String> destroyed;

    // Keeps track of if the whole ship is destroyed
    public boolean sunk = false;

    public int shipLength;
    public String name;
	
    /**
     * Constructor with length and width arguments.
     * @param shipLength the length of the ship.
     * @param name is the name of the ship.
     */	
    public Ship(int shipLength, String name){	
        this.shipLength = shipLength;
	this.name = name;
	coordinates = new ArrayList<String>();
	destroyed = new ArrayList<String>();
		
    }

    // @param newCoordinates, sets the coordinates ArrayList to this
    public void setCoordinates(ArrayList<String> newCoordinates){
	this.coordinates = newCoordinates;
    }

    // @return coordinates, returns the ArrayList of where the ship is located
    public ArrayList<String> getCoordinates(){	
	return coordinates;
    }

    // @return destroyed, returns the ArrayList of destroyed tiles
    public ArrayList<String> getDestroyed(){		
	return destroyed;
    }	
    
    // checks if the ship got hit
    public void checkHit( String xy ){	
	for (String a : coordinates){
            if (a.equals(xy)){
		destroyed.add(xy);
		checkDestroyed();
            }
	}
    }
	
    // checks if the ship is destroyed
    public void checkDestroyed(){
	System.out.println("destroyed.size(): "+destroyed.size()+" coordinates.size(): "+coordinates.size());
	if (destroyed.size() == coordinates.size())
            sunk = true;
    }   
}
