package logic;

public class HitsBoard extends Board{
    
    public HitsBoard(){
        super();
    }
    
    /**
     * placeShot takes a true or false value, which is whether or not the shot is hitting anything, along with
     * x and y position and changes the board based on that information
     * @param hit, whether the shot hit or not
     * @param x, the x position of the shot
     * @param y, the y position of the shot
     */
    public void placeShot(boolean hit, int x, int y){
        if (hit == true)
            grid[x][y] = "H";
        else
            grid[x][y] = "M";
    }
    
    /**
     * AI uses method
     * @param x, the x position of the shot.
     * @param y, the y position of the shot.
     * @return, true if the shot is going to hit an unmarked spot, false if not.
     */
    public boolean checkShot(int x, int y){
        if (grid[x][y] == " "){
            return true;
        }
        return false;
    }
    
}
