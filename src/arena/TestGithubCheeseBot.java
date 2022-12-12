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
        
        //Waheed Defensive code tester
        //---------------------------------------------------------------------------------------------
        //

        /*Creating a the bot it self and giving its it location. Using this I am able to simulate different bot positions without having to change the psoition i just need to uncomment them. */
        BotInfo meUpLeft = new BotInfo(0, 100, 0, "");
        //BotInfo meUpRight = new BotInfo(425, 500, 0, "");
        //BotInfo meDownRight= new BotInfo(425, 75, 0, "");

        /* I am creating the enemy bot for which I am gonna be calling it the methods for. I am first stating how many bots there are alive and then creating the bots with their positions. */
        BotInfo[] liveBots = new BotInfo[2];
        BotInfo infoDownLeft = new BotInfo(10, 110, 0, "");
        BotInfo infoUpLeft = new BotInfo(20, 120, 0, "");
        // BotInfo infoUpRight = new BotInfo(425, 425, 0, "");
        // BotInfo infoDownRight = new BotInfo(425, 150, 0, "");
        liveBots[0] = infoDownLeft;
        liveBots[1] = infoUpLeft;
        // liveBots[2] = infoUpRight;
        // liveBots[3] = infoDownRight;

        /* Not currently in use but could be used to simulate dead bots left it in the code in case we had future plans to simulate dead bots. */
        //BotInfo[] deadBots = new BotInfo[0];
        
        /* Creating the bullet it self. First we state how many bullets there are. Which currenly is set to one as we dont need more that for our test but this allows for us to have multiple bullets incoming. */
        Bullet[] bullets = new Bullet[1];
        Bullet bullet = new Bullet(10, 110, 0.5, 0.5);
        bullets[0] = bullet;
        
        /* Here we are calling on the methods that has been created for our bot and provinding it with our simulated input to see it the method works as intended. In this specific case if a bot is in a radius of 100 pixels the bot should say that a bullet has been shot. */
        int bulletsFired = githubCheese.fireBullets(meUpLeft, liveBots, true);
        System.out.println(bulletsFired);
        if (bulletsFired == BattleBotArena.FIREDOWN) {
            System.out.println("Bullets have been fired down");
        } else {
            System.out.println("bullet fired up test case failed");
        }
        /* These are the other cases that could be run using the multiple bots and enemy bots I have created above as this is simpler to uncomment than to change variables. */
        // int bulletsFired = githubCheese.fireBullets(meDownRight, liveBots, true);
        // System.out.println(bulletsFired);
        // if (bulletsFired == BattleBotArena.FIREUP) {
        //     System.out.println("Bullets have been fired down");
        // } else {
        //     System.out.println("bullet fired up test case failed");
        // }

        // int bulletsFired = githubCheese.fireBullets(meUpRight, liveBots, true);
        // System.out.println(bulletsFired);
        // if (bulletsFired == BattleBotArena.FIREDOWN) {
        //     System.out.println("Bullets have been fired down");
        // } else {
        //     System.out.println("bullet fired up test case failed");
        // }

        /* Here we are doing something similar to the pervious test case. We call on the method to dodge bullets and then give it the values for our bot and the bullet. If it takes the predetermined action then it passes. */
        int bulletsDodged = githubCheese.dodgeBullets(meUpLeft, bullets);
        if (bulletsDodged == BattleBotArena.DOWN) {
            System.out.println("Bullet dodged by moving down");
        } else {
            System.out.println("test case failed");
        }
        /* Again same thing as before it is easier to have them preset for different cases rather than to change variables. */
        // int bulletsDodged = githubCheese.dodgeBullets(meUpRight, bullets);
        // if (bulletsDodged == BattleBotArena.DOWN) {
        //     System.out.println("Bullet dodged by moving down");
        // } else {
        //     System.out.println("test case failed");
        // }

        // int bulletsDodged = githubCheese.dodgeBullets(meDownRight, bullets);
        // if (bulletsDodged == BattleBotArena.UP) {
        //     System.out.println("Bullet dodged by moving down");
        // } else {
        //     System.out.println("test case failed");
        // }
       
    }
}
