import java.util.ArrayList;

public class ShipTeam{

    private ArrayList<Ship> shipFleet;
    private String name;
    int amountHit;

    /**
     * Constructs a ship team with a given name for the fleet. Then adds the 5 default ships with names according
     * to the player that the fleet belongs to.
     * @param name, the string tha the fleet is to be named when constructed.
     */
    public ShipTeam(String name){

        this.name = name;
        amountHit = 0;
        shipFleet = new ArrayList<Ship>();
        // Add default ships with name <shipName (player fleet name)>
        shipFleet.add(new Ship(5, "Spacestation (" + this.name + ")"));
        shipFleet.add(new Ship(4, "BattleShip (" + this.name + ")"));
        //shipFleet.add(new Ship(3, "Cruiser (" + this.name + ")"));
        shipFleet.add(new Ship(3, "Destroyer (" + this.name + ")"));
        //shipFleet.add(new Ship(2, "Satellite (" + this.name + ")"));

    }

    /**
     * Iterates through each ship in the fleet and promts human player to choose location for the specifeid ship.
     * @param grid, the game board for the players grid.
     */
    public void placeAllShips(Board grid){
        for (Ship someShip : shipFleet){
            grid.gridDisplay();
            grid.promptToPlaceShip(someShip, someShip.getShipName());
            System.out.println("");
        }
    }

    public ArrayList<Ship> getShips() {
        return shipFleet;
    }

    public String getName() {
        return name;
    }

    public void goodHit(){
        this.amountHit += 1;
    }

    /**
     * Checks all the ships in a players fleet to see if they all have been destroyed to be used as a
     * condition for a main game loop.
     * @return true if all ships in fleet are destoyed, false otherwise.
     */
    public boolean isEveryShipDestroyed(){
        int totalHitsAllowed = 0;
        for (Ship s : shipFleet){
            totalHitsAllowed += s.getShipLength();
        }
        if (totalHitsAllowed == amountHit)
            return true;
        else
            return false;
    }
}