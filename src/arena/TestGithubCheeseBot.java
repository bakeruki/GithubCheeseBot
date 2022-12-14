
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

        // Created a bot that will be representing us. I give it a name that is related to its location on the grid. I provide it with its x and y values. These bots are used to represent us and run the methods and test cases.
        // This was done to minimize the amount of code needed to be written and instead of having to create a bot inside each test I could just use it from here. 
        BotInfo meUpLeft = new BotInfo(0, 100, 0, "");
        BotInfo meUpRight = new BotInfo(450, 100, 0, "");
        BotInfo meDownRight = new BotInfo(500, 500, 0, "");
        BotInfo meDownLeft = new BotInfo(0, 600, 0, "");

        // I create the enemy bots whose x and y coordinates we will be using to search and run our methods. I provide them with their names which are relative to their positions in the arena. Again created for ease of usage.
        BotInfo[] liveBots = new BotInfo[4];
        BotInfo infoDownLeft = new BotInfo(10, 550, 0, "");
        BotInfo infoUpLeft = new BotInfo(20, 120, 0, "");
        BotInfo infoUpRight = new BotInfo(450, 120, 0, "");
        BotInfo infoDownRight = new BotInfo(500, 480, 0, "");
        liveBots[0] = infoDownLeft;
        liveBots[1] = infoUpLeft;
        liveBots[2] = infoUpRight;
        liveBots[3] = infoDownRight;
        
        // I created the bullets which are required to run one of our methods. I give them an x and y value. 
        Bullet[] bullets = new Bullet[4];
        Bullet bullet1 = new Bullet(10, 110, 0.5, 0.5);
        Bullet bullet2 = new Bullet(460, 110, 0.5, 0.5);
        Bullet bullet3 = new Bullet(10, 590, 0.5, 0.5);
        Bullet bullet4 = new Bullet(490, 490, 0.5, 0.5);
        bullets[0] = bullet1;
        bullets[1] = bullet2;
        bullets[2] = bullet3;
        bullets[3] = bullet4;
        
        // Here we start to test our first method. In this specific case, our bot has been placed Top left and the enemy bot is under it. Under these circumstances, the bot should fire down. If it does the test passes if it doesn't the test fails.
        int bulletsFired = githubCheese.fireBullets(meUpLeft, liveBots, true);
        if (bulletsFired == BattleBotArena.FIREDOWN) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        // I am doing the same test here just testing for a bot in a different position where it is firing up. 
        bulletsFired = githubCheese.fireBullets(meDownRight, liveBots, true);
        if (bulletsFired == BattleBotArena.FIREUP) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        // Checking if the bot fires down
        bulletsFired = githubCheese.fireBullets(meUpRight, liveBots, true);
        if (bulletsFired == BattleBotArena.FIREDOWN) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        //Checking if it fires up. 
        bulletsFired = githubCheese.fireBullets(meDownLeft, liveBots, true);
        if (bulletsFired == BattleBotArena.FIREUP) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        // Testing to see if our second defensive method works or not. Under the bullet Dogged method if a bullet comes closer than a certain radius the bot is supposed to avoid it by either moving up or down. or left or right. In this specific case, we have the bot's specific position and we want the bot to avoid the bullet by moving down as that is the most optimal way to avoid the bullet. If the bullet is avoided by moving down the test passes if it's not the test fails. 
        int bulletsDodged = githubCheese.dodgeBullets(meUpLeft, bullets);
        if (bulletsDodged == BattleBotArena.DOWN) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        // Same test as the last one, checking if it moves down but the bot's position is changed.
        bulletsDodged = githubCheese.dodgeBullets(meUpRight, bullets);
        if (bulletsDodged == BattleBotArena.DOWN) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        // Bot position changed and checking to see if it moves right to avoid the bullet. 
        bulletsDodged = githubCheese.dodgeBullets(meDownRight, bullets);
        if (bulletsDodged == BattleBotArena.RIGHT) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        // Same as the previous test, the bot's position is changed. 
        bulletsDodged = githubCheese.dodgeBullets(meDownLeft, bullets);
        if (bulletsDodged == BattleBotArena.RIGHT) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }
}
