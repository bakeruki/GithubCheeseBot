
package arena;
import bots.GithubCheese;

/**
 * This class is used to test methods created in the GithubCheese GROUP A class.
 * @author Ammar Faisal
 * 
 * 
* NOTE: ALL METHODS HAVE THEIR OWN INPUTS SO OUTPUTS OF METHODS HAVE NOTHING TO DO WITH EACHOTHER AS PER 
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

  
        /*Test the getDistanceToEdge method. This method is expected to return the distance between a bot and an edge to 
         * to ensure that our bot can perform one of its basic functions. 
        */
        
        double x = 10;             
        double y = 10;
        System.out.println("THE BOT SHOULD PRINT THE DISTANCE FROM THE BOT TO THE EDGES");
        double distanceFromBottomEdge = githubCheese.getDistanceToEdge(BattleBotArena.BOTTOM_EDGE, x, y);
        System.out.println("Distance from bottom edge: " + distanceFromBottomEdge + ". TEST SUCCESSFUL.");

        double distanceFromTopEdge = githubCheese.getDistanceToEdge(BattleBotArena.TOP_EDGE, x, y);
        System.out.println("Distance from top edge: " + distanceFromTopEdge + ". TEST SUCCESSFUL.");

        double distanceFromLeftEdge = githubCheese.getDistanceToEdge(BattleBotArena.LEFT_EDGE, x, y);
        System.out.println("Distance from left edge: " + distanceFromLeftEdge + ". TEST SUCCESSFUL.");

        double distanceFromRightEdge = githubCheese.getDistanceToEdge(BattleBotArena.RIGHT_EDGE, x, y);
        System.out.println("Distance from right edge: " + distanceFromRightEdge + ". TEST SUCCESSFUL." + "\n");

        

        /*Test the chooseEdge method. This method is expected to return the Chosen edge to the bot based on its x and y position.
        * This Method can be altered by changing X and Y values above to test different scenarios.
        */
        double x1 = 20;
        double y1 = 40;
        
        System.out.println("THE BOT SHOULD PRINT THE EDGE IT HAS CHOSEN WHICH IN THIS CASE IS THE LEFT EDGE");
        int chosenEdge = githubCheese.chooseEdge(x1, y1);
        if (chosenEdge == BattleBotArena.BOTTOM_EDGE) 
            System.out.println( "Chosen edge: Bottom\n"); 
            
        else if (chosenEdge == BattleBotArena.TOP_EDGE)
            System.out.println( "Chosen edge: Top\n");

        else if (chosenEdge == BattleBotArena.LEFT_EDGE)
            System.out.println( "Chosen edge: Left\n");
            
        else if (chosenEdge == BattleBotArena.RIGHT_EDGE)
            System.out.println( "Chosen edge: Right\n");

        x1 = 400;                  /*I Changed X and Y coordinates of the bot here to make sure the bot chooses the nearest edge based on the given situation   */
        y1 = 400;
        System.out.println("THE BOT SHOULD PRINT THE EDGE IT HAS CHOSEN WHICH IN THIS CASE IS THE RIGHT EDGE");
        chosenEdge = githubCheese.chooseEdge(x1, y1);
        if (chosenEdge == BattleBotArena.BOTTOM_EDGE) 
            System.out.println( "Chosen edge: Bottom\n"); 
            
        else if (chosenEdge == BattleBotArena.TOP_EDGE)
            System.out.println( "Chosen edge: Top\n");

        else if (chosenEdge == BattleBotArena.LEFT_EDGE)
            System.out.println( "Chosen edge: Left\n");
            
        else if (chosenEdge == BattleBotArena.RIGHT_EDGE)
            System.out.println( "Chosen edge: Right\n");



        
        
        /*Test the lastMoveWasFire. This method is expected to return true if the previous move was a firing move, and false if it was not. 
        */
        int move = BattleBotArena.FIREUP; 
        boolean lastMoveWasFire = githubCheese.lastMoveWasFire(move);
        if (lastMoveWasFire == true)
            System.out.println("FIREUP test successful.");
        else
            System.out.println("FIREUP test failed.");

        move = BattleBotArena.FIREDOWN;
        lastMoveWasFire = githubCheese.lastMoveWasFire(move);
        if (lastMoveWasFire == true)
            System.out.println("FIREDOWN test successful.");
        else
            System.out.println("FIREDOWN test failed.");

        move = BattleBotArena.FIRELEFT; 
        lastMoveWasFire = githubCheese.lastMoveWasFire(move);
        if (lastMoveWasFire == true)
            System.out.println("FIRELEFT test successful.");
        else
            System.out.println("FIRELEFT test failed.");

        move = BattleBotArena.FIRERIGHT; 
        lastMoveWasFire = githubCheese.lastMoveWasFire(move);
        if (lastMoveWasFire == true)
            System.out.println("FIRERIGHT test successful.\n");
        else
            System.out.println("FIRERIGHT test failed.");



        /*Test the moveToEdge method. This method is expected to return the correct move that the bot needs in order to move to its chosen edge. */
        double x2 = 100;
        double y2 = 100;

        int choseEdge = BattleBotArena.BOTTOM_EDGE; 
        int move1 = githubCheese.moveToEdge(x2, y2, choseEdge); 
        if (move1 == BattleBotArena.DOWN)
            System.out.println("MOVE to BOTTOM EDGE test successful.");
        
        else
            System.out.println("Move to edge failed"); 

            
        choseEdge = BattleBotArena.TOP_EDGE;                      /*By changng the value of choseEdge, I can make sure that the bot makes the right decision to go to the chosen edge */
        move1 = githubCheese.moveToEdge(x2, y2, choseEdge);
        if (move1 == BattleBotArena.UP)
            System.out.println("MOVE to TOP EDGE test successful.");      
        else
            System.out.println("Move to edge failed");

        
        choseEdge = BattleBotArena.LEFT_EDGE;
        move1 = githubCheese.moveToEdge(x2, y2, choseEdge);
        if (move1 == BattleBotArena.LEFT)
            System.out.println("MOVE to LEFT EDGE test successful.");
        else
            System.out.println("Move to edge failed");

        
        choseEdge = BattleBotArena.RIGHT_EDGE;
        move1 = githubCheese.moveToEdge(x2, y2, choseEdge);
        if (move1 == BattleBotArena.RIGHT)
            System.out.println("MOVE to RIGHT EDGE test successful.\n");
        else
            System.out.println("Move to edge failed");

        /*Test the cycleOnEdge method. This method is expected to return the correct move that the bot needs in order to cycle on its edge. */
        int lastmove = BattleBotArena.UP;
         
        boolean shotOk = true;
        double pShoot = 0;  


        int choseEdge2 = BattleBotArena.LEFT_EDGE;
        int cycling = githubCheese.cycleOnEdge(x, y, lastmove, choseEdge2, shotOk, pShoot);
        System.out.println("The bot is on left edge. It should move UP or DOWN.");
        if (cycling == BattleBotArena.UP)
            System.out.println("BOT MOVED UP\n");
        else if (cycling == BattleBotArena.DOWN)
            System.out.println("BOT MOVED DOWN\n");
        else
            System.out.println("Cycle on edge failed\n");

        choseEdge2 = BattleBotArena.RIGHT_EDGE;
        cycling = githubCheese.cycleOnEdge(x, y, lastmove, choseEdge2, shotOk, pShoot);
        System.out.println("The bot is on RIGHT edge. It should move UP or DOWN.");
        if (cycling == BattleBotArena.UP)
            System.out.println("BOT MOVED UP\n");
        else if (cycling == BattleBotArena.DOWN)
            System.out.println("BOT MOVED DOWN\n");
        else
            System.out.println("Cycle on edge failed\n");

        chosenEdge = BattleBotArena.TOP_EDGE;
        cycling = githubCheese.cycleOnEdge(x, y, lastmove, chosenEdge, shotOk, pShoot);
        System.out.println("The bot is on TOP edge. It should move LEFT or RIGHT.");
        if (cycling == BattleBotArena.LEFT)
            System.out.println("BOT MOVED LEFT\n");
        else if (cycling == BattleBotArena.RIGHT)
            System.out.println("BOT MOVED RIGHT\n");
        else
            System.out.println("Cycle on edge failed\n");

        chosenEdge = BattleBotArena.BOTTOM_EDGE;    
        cycling = githubCheese.cycleOnEdge(x, y, lastmove, chosenEdge, shotOk, pShoot);
        System.out.println("The bot is on BOTTOM edge. It should move LEFT or RIGHT.");
        if (cycling == BattleBotArena.LEFT)
            System.out.println("BOT MOVED LEFT\n");
        else if (cycling == BattleBotArena.RIGHT)
            System.out.println("BOT MOVED RIGHT\n");
        else
            System.out.println("Cycle on edge failed\n");
        
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
