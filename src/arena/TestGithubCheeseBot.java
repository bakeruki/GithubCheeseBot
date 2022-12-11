package arena;
import bots.GithubCheese;

/**
 * This class is used to test methods created in the GithubCheese GROUP A class.
 * @author Ammar Faisal
 * 
 * 
* NOTE: ALL METHODS HAVE THEIR INPUTS SO OUTPUTS OF METHODS HAVE NOTHING TO DO WITH EACHOTHER AS PER 
* THE REQUIREMENTS OF THE ASSIGNMENT.
 * 
 * 
 */
public class TestGithubCheeseBot {
    public static void main(String[] args){
        /*
         * These are all the methods created by Luqman in Group A that need testing.
         * getDistanceToEdge();
         * chooseEdge();
         * moveToEdge();
         * cycleOnEdge();
         * lastMoveWasFire();
         */
        GithubCheese githubCheese = new GithubCheese();

        /*x and y values of our bots location used for testing (so that they can be changed quickly) */
        double x = 10;
        double y = 10;

        /*Test the getDistanceToEdge method. This method is expected to return the distance between a bot and an edge to 
         * to ensure that our bot can perform one of its basic functions. Alter the X and Y values above to test different scenarios.
        */
        double distanceFromBottomEdge = githubCheese.getDistanceToEdge(BattleBotArena.BOTTOM_EDGE, x, y);
        System.out.println("Distance from bottom edge: " + distanceFromBottomEdge);

        double distanceFromTopEdge = githubCheese.getDistanceToEdge(BattleBotArena.TOP_EDGE, x, y);
        System.out.println("Distance from top edge: " + distanceFromTopEdge);

        double distanceFromLeftEdge = githubCheese.getDistanceToEdge(BattleBotArena.LEFT_EDGE, x, y);
        System.out.println("Distance from left edge: " + distanceFromLeftEdge);

        double distanceFromRightEdge = githubCheese.getDistanceToEdge(BattleBotArena.RIGHT_EDGE, x, y);
        System.out.println("Distance from right edge: " + distanceFromRightEdge);

        /*Test the chooseEdge method. This method is expected to return the Chosen edge to the bot based on its x and y position.
        * This Method can be altered by changing X and Y values above to test different scenarios.
        */
        int chosenEdge = githubCheese.chooseEdge(x, y);
        if (chosenEdge == BattleBotArena.BOTTOM_EDGE) 
            System.out.println( "Chosen edge: Bottom"); 
            
        else if (chosenEdge == BattleBotArena.TOP_EDGE)
            System.out.println( "Chosen edge: Top");

        else if (chosenEdge == BattleBotArena.LEFT_EDGE)
            System.out.println( "Chosen edge: Left");
            
        else if (chosenEdge == BattleBotArena.RIGHT_EDGE)
            System.out.println( "Chosen edge: Right");
        
        /*Test the lastMoveWasFire. This method is expected to return true if the previous move was a firing move, and false if it was not. 
         * int move = BattleBotArena.FIREDOWN;
         * int move = BattleBotArena.FIRELEFT;
         * int move = BattleBotArena.FIRERIGHT;
        */
        int move = BattleBotArena.FIREUP; /*This value can be altered with above value to produce different scenarios */
        boolean lastMoveWasFire = githubCheese.lastMoveWasFire(move);
        if (lastMoveWasFire == true)
            System.out.println("Last move was firing move");
        else
            System.out.println("Last move was not a firing move");

        /*Test the moveToEdge method. This method is expected to return the correct move that the bot needs in order to move to its chosen edge.
         * int choseEdge = BattleBotArena.Bottom_EDGE;
         * int choseEdge = BattleBotArena.Left_EDGE;
         * int choseEdge = BattleBotArena.Right_EDGE;
         * use the above values to test the moveToEdge method
         */
        int choseEdge = BattleBotArena.BOTTOM_EDGE; /*This value can be altered with above value to produce different scenarios */
        int move1 = githubCheese.moveToEdge(x, y, choseEdge); 
        if (move1 == BattleBotArena.UP)
            System.out.println("Move to top edge");
        else if (move1 == BattleBotArena.DOWN)
            System.out.println("Move to bottom edge");
        else if (move1 == BattleBotArena.LEFT)
            System.out.println("Move to left edge");
        else if (move1 == BattleBotArena.RIGHT)
            System.out.println("Move to right edge");
        else
            System.out.println("Move to edge failed");

        /*Test the cycleOnEdge method. This method is expected to return the correct move that the bot needs in order to cycle on its edge. */
        int lastmove = BattleBotArena.UP;
        int choseEdge2 = BattleBotArena.LEFT_EDGE; /*These values can be altered with above value to produce different scenarios */
        boolean shotOk = true;
        double pShoot = 0.3;  



        int cycling = githubCheese.cycleOnEdge(x, y, lastmove, choseEdge2, shotOk, pShoot);
        if (cycling == BattleBotArena.UP)
            System.out.println("Cycle on left edge");
        else if (cycling == BattleBotArena.DOWN)
            System.out.println("Cycle on left edge");
        else if (cycling == BattleBotArena.LEFT)
            System.out.println("Cycle on left edge");
        else if (cycling == BattleBotArena.RIGHT)
            System.out.println("Cycle on left edge");
        else
            System.out.println("Cycle on edge failed");

    }
}
