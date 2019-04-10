
import static org.junit.Assert.*;
import org.junit.Test;
import logic.*;

public class BoardTest {

	@Test
	public void test_placeShip_allVertical() {
		ShipsBoard b = new ShipsBoard();
		ShipTeam testFleet = new ShipTeam("test fleet");
		int initX = 0;
		
		for (Ship s : testFleet.getShips()) {
			b.placeShip(initX, 0, 2, s);
			// Now check that it was placed vertically
			for (int y = 0; y < s.shipLength; y++){
				String[][] vGrid = b.getGrid();
				assertEquals("A ship was placed at " + (char)(initX + 97) + y, "G", vGrid[initX][y]);
			}

			initX++;
			
		}
		
	}
	
	@Test 
	public void test_placeShip_allHorizontal() {
		ShipsBoard b = new ShipsBoard();
		ShipTeam testFleet = new ShipTeam("test fleet");
		int initY = 0;
		
		for (Ship s : testFleet.getShips()) {
			b.placeShip(0, initY, 1, s);
			// Check all adjacent pieces to the right of top left corner.
			for (int x = 0; x < s.shipLength; x++){
				String[][] hGrid = b.getGrid();
				assertEquals("A ship was placed at " + (char)(x + 97) + initY, "G", hGrid[x][initY]);
			}

			initY++;
		}
		
	}
	
	@Test
	public void test_checkShot() {
		HitsBoard b = new HitsBoard();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				// b is an empty board (each piece = " ") so checkShot should return true.
				assertEquals("Unexpected value at " + (char)(i + 97) + j, true, b.checkShot(i, j));
			}
		}
	}
	
	@Test
	public void test_shotFired() {
		ShipsBoard b = new ShipsBoard();
		Ship s = new Ship(4, "test");
		b.placeShip(0, 0, 2, s);
		
		assertEquals("Placed a ship at [a][0] then checked if shot was good ", true, b.shotFired(0, 0));
		assertEquals("Checking an empty spot on the board ", false, b.shotFired(9, 9));
	}

	@Test
	public void test_placeShot() {
		HitsBoard hb = new HitsBoard();
		ShipsBoard sb = new ShipsBoard();
		Ship s = new Ship(3, "test ship");

		// test a shot on a ship
		sb.placeShip(0, 0, 1, s);
		hb.placeShot(sb.shotFired(0, 0), 0, 0);
		String[][] grid1 = hb.getGrid();
		assertEquals("Placed a ship at [a][0] then shot same spot ", "H", grid1[0][0]);

		// test a shot on an empty spot
		hb.placeShot(sb.shotFired(9, 9), 9, 9);
		String[][] grid2 = hb.getGrid();
		assertEquals("Took a shot at empty space ", "M", grid2[9][9]);

	}


}
