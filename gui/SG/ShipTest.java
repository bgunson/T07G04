
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import logic.Ship;

public class ShipTest {

	@Test
	public void test_constructorLengthAndName() {
		
		Ship s = new Ship(4, "test");
		assertEquals("Unexpected length: ", 4, s.shipLength);
		assertEquals("Unexpected name: ", "test", s.name);
		
	}
	
	@Test
	public void test_getCoordinates() {
		Ship s = new Ship(3, "test");
		ArrayList<String> testCoords = new ArrayList<String>();
		testCoords.add("a0");
		s.setCoordinates(testCoords);
		assertEquals("Unexpected coordinates: ", s.getCoordinates(), testCoords);
		
	}
	
	@Test
	public void test_setCoordinates() {
		
		Ship s = new Ship(3, "test");
		ArrayList<String> testCoords = new ArrayList<String>();
		testCoords.add("a0");
		s.setCoordinates(testCoords);
		testCoords.add("b5");
		s.setCoordinates(testCoords);
		assertEquals("Unexpected coordinates: ", s.getCoordinates(), testCoords);
		
	}
	
	@Test
	public void test_checkDestroyed() {
		
		Ship s = new Ship(2, "test");
		assertEquals("unexpected value for sunk: ", false, s.sunk);
		s.sunk = true;
		assertEquals("Unexpected value for sunk: ", true, s.sunk);
		
	}

}
