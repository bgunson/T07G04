
public class startProgram {
	public static void main(String[] args) {
		
		//Runs the other class to build and display the 2d array
		twoDimensionalGrid twoDimensionalGrid = new twoDimensionalGrid();
		twoDimensionalGrid.gridBuilder();
		twoDimensionalGrid.gridDisplay();
		
		/* if you wanna test the method for yourself
		Scanner reader = new Scanner(System.in);
		for(int q = 2; q>0; q--){
			System.out.println("\n");
			
			System.out.println("input back to back in this order: x, y, width, height");
			int x = reader.nextInt();
			int y = reader.nextInt();
			int w = reader.nextInt();
			int h = reader.nextInt();
			
			twoDimensionalGrid.placeShip(x, y, w, h); 
			twoDimensionalGrid.gridDisplay();
		}
		*/
	}
}
