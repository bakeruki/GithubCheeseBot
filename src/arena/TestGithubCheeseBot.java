package arena;
import bots.GithubCheese;

/*
 * This class is used to test methods created in the GithubCheese class.
 */
public class TestGithubCheeseBot {
    public static void main(String[] args){
        /*
         * These are all the methods created by Luqman that need testing.
         * getDistanceToEdge();
         * chooseEdge();
         * moveToEdge();
         * cycleOnEdge();
         * lastMoveWasFire();
         */
        GithubCheese githubCheese = new GithubCheese();

        /*x and y values used for testing (so that they can be changed quickly) */
        double x = 20;
        double y = 30;

        /*Test the getDistanceToEdge method. This method is expected to return the distance between a bot and an edge */
        double distanceFromBottomEdge = githubCheese.getDistanceToEdge(BattleBotArena.BOTTOM_EDGE, x, y);
        System.out.println("Distance from bottom edge: " + distanceFromBottomEdge);

        double distanceFromTopEdge = githubCheese.getDistanceToEdge(BattleBotArena.TOP_EDGE, x, y);
        System.out.println("Distance from bottom edge: " + distanceFromTopEdge);

        double distanceFromLeftEdge = githubCheese.getDistanceToEdge(BattleBotArena.LEFT_EDGE, x, y);
        System.out.println("Distance from bottom edge: " + distanceFromLeftEdge);

        double distanceFromRightEdge = githubCheese.getDistanceToEdge(BattleBotArena.RIGHT_EDGE, x, y);
        System.out.println("Distance from bottom edge: " + distanceFromRightEdge);

        /*Test the chooseEdge method. This method is expected to return the closest edge to the bot based on its x and y position. */
        int closestEdge = githubCheese.chooseEdge(x, y);
        if (closestEdge == BattleBotArena.BOTTOM_EDGE) 
            System.out.println("Closest edge: Bottom"); 

        else if (closestEdge == BattleBotArena.TOP_EDGE)
            System.out.println("Closest edge: Top");

        else if (closestEdge == BattleBotArena.LEFT_EDGE)
            System.out.println("Closest edge: Left");
            
        else if (closestEdge == BattleBotArena.RIGHT_EDGE)
            System.out.println("Closest edge: Right");

        /*Test the lastMoveWasFire method. This method is expected to return true if the previous move was a firing move, and false if it was not. */
        
        /*Test the moveToEdge method. This method is expected to return the correct move that the bot needs in order to move to its chosen edge */
        
        /*Test the cycleOnEdge method. This method is expected to return the correct move that the bot needs in order to cycle on its edge. */
    }
}
