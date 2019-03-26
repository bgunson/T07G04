import java.util.Random;
import java.util.ArrayList;

public class AiPlayer{

    /**
     * shipPlacer will randomly place the default ships for the computer player n its own board.
     * @param board the board object representing the AI's ship locations.
     * @param fleet, the ShipTeam object containing the AI's ship objects.
     */
    public void shipPlacer(Board board, ShipTeam fleet){

        ArrayList<Ship> theShips = fleet.getShipFleet();

        int randomX, randomY;
        for (Ship s : theShips){
            System.out.println(s.name);
            boolean goodPlace = false;
            while (goodPlace == false){
                Random rand = new Random();
                randomX = rand.nextInt(10);
                randomY = rand.nextInt(10);
                if (randomX % 2 == 0)
                    goodPlace = board.placeShip(randomX, randomY, s.getShipLength, 1);
                else
                    goodPlace = board.placeShip(randomX, randomY, s.getShipLength, 2);
            }
        }


    }

    /**
     * When called, computer player will shoot on the board (randomly?)...
     */
    public void turn(Board board){

    }


}
