package logic;

import java.util.ArrayList;

/*
Ship object that keeps track of the health of its pieces and stores its properties (length, name).
 */
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

    /**
     * Sets the ships coords to specified ones.
     */
    public void setCoordinates(ArrayList<String> newCoordinates){
	this.coordinates = newCoordinates;
    }

    /**
     * @return list of the ships current coords.
     */
    public ArrayList<String> getCoordinates(){	
	return coordinates;
    }

    /**
     * Returns list of pieces that are destoyed.
     */
    public ArrayList<String> getDestroyed(){		
	return destroyed;
    }

    /**
     * Checks a position whether its been hit or not.
     */
    public void checkHit( String xy ){	
	for (String a : coordinates){
            if (a.equals(xy)){
		destroyed.add(xy);
		checkDestroyed();
            }
	}
    }

    /**
     * checks if the ship is destroyed.
     */
    public void checkDestroyed(){
	if (destroyed.size() == coordinates.size())
            sunk = true;
    }   
}
