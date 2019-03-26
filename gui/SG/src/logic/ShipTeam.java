package logic;

import java.util.ArrayList;

public class ShipTeam {

    private ArrayList<Ship> shipFleet;
    private String name;
	
    /**
     * @param name - the name of the ship team
     */
    public ShipTeam(String name){

        this.name = name;
        shipFleet = new ArrayList<Ship>();
        // Add default ships with name <shipName (player fleet name)>
        shipFleet.add(new Ship(5, "Spacestation"));
        shipFleet.add(new Ship(4, "BattleShip"));
        shipFleet.add(new Ship(3, "Cruiser"));
        shipFleet.add(new Ship(3, "Destroyer"));
        shipFleet.add(new Ship(2, "Satellite"));

    }

    /**
     * Iterates through each ship in the fleet and prompts human player to choose location for the specified ship.
     * @return shipFleet, returns the ArrayList containing all of the ships.
     */
    public ArrayList<Ship> getShips(){	
        return shipFleet;
    }

    /**
     * Checks all the ships in a players fleet to see if they all have been destroyed to be used as a
     * condition for a main game loop.
     * @return true if all ships in fleet are destroyed, false otherwise.
     */
    public boolean isEveryShipDestroyed(){
	for (Ship s : shipFleet){
            if (s.sunk == false)
                return false;
        }
        return true;
    }
		
}