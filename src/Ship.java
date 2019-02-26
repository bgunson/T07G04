/*
Ship object that can take any specified length x width size and keeps track of its number of hits which can
tell us if it is destroyed or not at any certain point in the game.
 */


public class Ship{

    private int shipLength;
    private int shipWidth = 1;
    private int numberOfHits = 0;
    private String shipName;


    /**
     * Constructor with length and width arguments.
     * @param shipLength the length of the ship.
     * @param shipWidth the width of the ship.
     */
    public Ship(int shipLength, String shipName){

        this.shipLength = shipLength;
        this.shipName = shipName;

    }
    
    /**
    * Copy constructor.
    */
    public Ship(Ship shipToCopy){
        this.shipLength = shipToCopy.getShipLength();
        this.shipName = shipToCopy.getShipName();
        this.shipWidth = 1;
        this.numberOfHits = 0;
    }

    public String getShipName(){
        return this.shipName;
    }

    /**
     * Method that returns length of the ship.
     * @return shipLength
     */
    public int getShipLength(){
        return this.shipLength;
    }

    /**
     * Method returns the width of the ship.
     * @return shipWidth
     */
    public int getShipWidth(){
        return this.shipWidth;
    }

    /**
     * Method returns the number of hits.
     * @return numberOfHits
     */
    public int getNumberOfHits(){
        return this.numberOfHits;

    }

    /**
     * Method sets the number of hits to specified integer.
     * @param numberOfHits the new integer numberOfHits.
     */
    public void setNumberOfHits(int numberOfHits){
        this.numberOfHits = numberOfHits;
    }

    /**
     * checks if the ship has been hit the same amount that it is long.
     * @return true if the ship has been destroyed, false otherwise.
     */

    public boolean isDestroyed(){
        if (numberOfHits == shipLength){
            return true;
        }
        else{
            return false;
        }
    }

}