import java.util.ArrayList;

public class ShipTeam{

    private ArrayList<Ship> shipFleet = new ArrayList<Ship>();
    private String name;

    public ShipTeam(String name){
        this.name = name;
        // Add default ships with name <shipName (player_fleet_name)>
        shipFleet.add(new Ship(5, "Spacestation (" + this.name + ")"));
        shipFleet.add(new Ship(4, "BattleShip (" + this.name + ")"));
        shipFleet.add(new Ship(3, "Cruiser (" + this.name + ")"));
        shipFleet.add(new Ship(3, "Destroyer (" + this.name + ")"));
        shipFleet.add(new Ship(2, "Satellite (" + this.name + ")"));

    }

    public void placeAllShips(twoDimensionalGrid grid){
        for (Ship someShip : shipFleet){
            grid.gridDisplay();
            grid.promptToPlaceShip(someShip, someShip.getShipName());
        }
    }

    public ArrayList<Ship> getShips() {
        return shipFleet;
    }

    public String getName() {
        return name;
    }
}