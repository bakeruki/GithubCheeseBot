package bots;

import java.awt.Graphics;
import java.awt.Image;

import arena.BattleBotArena;
import arena.BotInfo;
import arena.Bullet;

/*
 * GithubCheese is a Bot that implements a strategy called cycling.
 * It will pick the closest and safest edge and move towards it. Once it has reached that edge, it will
 * cycle from one side of that chosen edge to the other side of that chosen edge. While moving back and forth,
 * it will randomly fire in the opposite direction of the edge that it is cycling on.
 */
public class GithubCheese extends Bot {
    /*
     * Keeps track of the last directional cycle move that was performed (move that was not firing). 
     */
    private int lastCycleMove = 0;

    @Override
    public void newRound() {

    }

    @Override
    public int getMove(BotInfo me, boolean shotOK, BotInfo[] liveBots, BotInfo[] deadBots, Bullet[] bullets) {
        //sean put ur code up here so that mine only executes if yours is not executing
        int dodgeBullets = dodgeBullets(me, bullets);
        int fireBullets = fireBullets(me, liveBots, shotOK);
        /*
         * Dodging bullets is the priority, so this is the first move that will be executed.
         * If there is not a bullet to dodge, it proceeds to the next move.
         */
        // if(dodgeBullets != 0){
        //     return dodgeBullets;
        // }

        /*
         * Firing bullets at nearby bots is the second priorty, so this is the second move that will be executed.
         * If there are no bots to shoot at, it proceeds to the next move.
         */
        if(fireBullets != 0){
            return fireBullets;
        }
    
        int chosenEdge = chooseEdge(me.getX(), me.getY());
        int moveToEdge = moveToEdge(me.getX(), me.getY(), chosenEdge);
        int cycleMove = cycleOnEdge(me.getX(), me.getY(), me.getLastMove(), chosenEdge, shotOK, 0.05);

        /*
         * If we are not already at our chosen cycleEdge, we must first get there.
         * If we are already there, it proceeds to the next move.
         */
        if(moveToEdge != 0){
            return moveToEdge;
        }

        /*
         * Cycling across the edge is the backbone of our strategy, however it takes the least priority. 
         */
        if(cycleMove != 0){
                return cycleMove;
        }
        
        /*
         * If the bot does not move, we know there is a bug in our code somewhere.
         */
        return BattleBotArena.STAY;
    }

    /**
     * Calculates the distance to a specified edge
     * @author Luqman Patel
     * @param edge The edge that you want the distance calculated from
     * @param x The x coordinate of our bot
     * @param y The y coordinate of our bot
     * @return Returns the distance between our bot and the specified edge
     */
    public double getDistanceToEdge(int edge, double x, double y){
        switch(edge){
            case BattleBotArena.LEFT_EDGE:
                return x - BattleBotArena.LEFT_EDGE;
            case BattleBotArena.RIGHT_EDGE:
                return BattleBotArena.RIGHT_EDGE - x;
            case BattleBotArena.TOP_EDGE:
                return y - BattleBotArena.TOP_EDGE;
            case BattleBotArena.BOTTOM_EDGE:
                return BattleBotArena.BOTTOM_EDGE - y;
        }

        return 0;
    }

    /** 
     * Chooses which edge the bot will cycle on based on its distance from each edge.
     * @author Luqman Patel
     * @param me The BotInfo of our bot. 
     * @return Integer of the chosen edge that the bot will cycle on.
     */
    public int chooseEdge(double x, double y){
        double distanceToClosestEdge = 1000;
        int chosenEdge = 0;

        double tempDist = getDistanceToEdge(BattleBotArena.LEFT_EDGE, x, y);
        if(tempDist < distanceToClosestEdge){
            distanceToClosestEdge = tempDist;
            chosenEdge = BattleBotArena.LEFT_EDGE;
        }
        tempDist = getDistanceToEdge(BattleBotArena.RIGHT_EDGE, x, y);
        if(tempDist < distanceToClosestEdge){
            distanceToClosestEdge = tempDist;
            chosenEdge = BattleBotArena.RIGHT_EDGE;
        }
        tempDist = getDistanceToEdge(BattleBotArena.TOP_EDGE, x, y);
        if(tempDist < distanceToClosestEdge){
            distanceToClosestEdge = tempDist;
            chosenEdge = BattleBotArena.TOP_EDGE;
        }
        tempDist = getDistanceToEdge(BattleBotArena.RIGHT_EDGE, x, y);
        if(tempDist < distanceToClosestEdge){
            distanceToClosestEdge = tempDist;
            chosenEdge = BattleBotArena.BOTTOM_EDGE;
        }
        return chosenEdge;
    }

    /**
     * Moves directly towards a chosen edge if the bot is not already at that edge.
     * @author Luqman Patel
     * @param x The x coordinate of our bot.
     * @param y The y coordinate of our bot.
     * @param chosenEdge The edge that the bot needs to move to.
     * @return The move required to move to the specified edge. Returns a 0 if already at the edge.
     */
    public int moveToEdge(double x, double y, int chosenEdge){
        switch(chosenEdge){
            case BattleBotArena.RIGHT_EDGE:
                if(x <= BattleBotArena.RIGHT_EDGE - 30){
                    return BattleBotArena.RIGHT;
                }else{
                    return 0;
                }
            case BattleBotArena.LEFT_EDGE:
                if(x >= BattleBotArena.LEFT_EDGE + 30){
                    return BattleBotArena.LEFT;
                }else{
                    return 0;
                }
            case BattleBotArena.BOTTOM_EDGE:
                if(y <= BattleBotArena.BOTTOM_EDGE - 30){
                    return BattleBotArena.DOWN;
                }else{
                    return 0;
                }

            case BattleBotArena.TOP_EDGE:
                if(y >= BattleBotArena.TOP_EDGE + 30){
                    return BattleBotArena.UP;
                }else{
                    return 0;
                }
            default:
                return 0;
        }
    }

    /**
     * Chooses a move to execute based on the edge that the bot is cycling at.
     * @param x The x coordinate of our bot.
     * @param y The y coordinate of our bot.
     * @param lastMove The last move that our bot executed.
     * @param chosenEdge The edge that we will be performing the cycle action at.
     * @param shotOK Boolean that determines whether it is ok for the bot to shoot so that it does not overheat.
     * @param pShoot Probability that the bot will fire a bullet each frame.
     * @return The appropriate move to execute the cycle strategy. Returns 0 in the case that it can't make a decision (something went wrong).
     */
    public int cycleOnEdge(double x, double y, int lastMove, int chosenEdge, boolean shotOK, double pShoot){
        double coinFlip = Math.random();

        if(coinFlip <= pShoot && shotOK){
            lastCycleMove = lastMove;
            switch(chosenEdge){
                case BattleBotArena.RIGHT_EDGE:
                    return BattleBotArena.FIRELEFT;
                case BattleBotArena.LEFT_EDGE:
                    return BattleBotArena.FIRERIGHT;
                case BattleBotArena.BOTTOM_EDGE:
                    return BattleBotArena.FIREUP;
                case BattleBotArena.TOP_EDGE:
                    return BattleBotArena.FIREDOWN;
                default:
                    return 0;
            }
        }else{
            switch(chosenEdge){
                case BattleBotArena.RIGHT_EDGE:
                    if(y <= BattleBotArena.TOP_EDGE + 50){
                        return BattleBotArena.DOWN;
                    }else if(y >= BattleBotArena.BOTTOM_EDGE - 50){
                        return BattleBotArena.UP;
                    }else{
                        if(lastMoveWasFire(lastMove)){
                            return lastCycleMove;
                        }
                        if(lastMove != BattleBotArena.UP && lastMove != BattleBotArena.DOWN){
                            return BattleBotArena.UP;
                        }
                        return lastMove;
                    }
                case BattleBotArena.LEFT_EDGE:
                    if(y <= BattleBotArena.TOP_EDGE + 50){
                        return BattleBotArena.DOWN;
                    }else if(y >= BattleBotArena.BOTTOM_EDGE - 50){
                        return BattleBotArena.UP;
                    }else{
                        if(lastMoveWasFire(lastMove)){
                            return lastCycleMove;
                        }
                        if(lastMove != BattleBotArena.UP && lastMove != BattleBotArena.DOWN){
                            return BattleBotArena.UP;
                        }
                        return lastMove;
                    }
    
                case BattleBotArena.BOTTOM_EDGE:
                    if(x <= BattleBotArena.LEFT_EDGE + 50){
                        return BattleBotArena.RIGHT;
                    }else if(x >= BattleBotArena.RIGHT_EDGE - 50){
                        return BattleBotArena.LEFT;
                    }else{
                        if(lastMoveWasFire(lastMove)){
                            return lastCycleMove;
                        }
                        if(lastMove != BattleBotArena.LEFT && lastMove != BattleBotArena.RIGHT){
                            return BattleBotArena.LEFT;
                        }
                        return lastMove;
                    }
    
                case BattleBotArena.TOP_EDGE:
                    if(x <= BattleBotArena.LEFT_EDGE + 50){
                        return BattleBotArena.RIGHT;
                    }else if(x >= BattleBotArena.RIGHT_EDGE - 50){
                        return BattleBotArena.LEFT;
                    }else{
                        if(lastMoveWasFire(lastMove)){
                            return lastCycleMove;
                        }
                        if(lastMove != BattleBotArena.LEFT && lastMove != BattleBotArena.RIGHT){
                            return BattleBotArena.LEFT;
                        }
                        return lastMove;
                    }
    
                default:
                    return 0;
            }
        }
    }

    /**
     * Checks whether the bot's move on the previous turn was a firing move.
     * @author Luqman Patel
     * @param lastMove The move that our bot executed on the previous turn (use botInfo.getLastMove()).
     * @return Returns true if the move executed on the previous turn was any of the 4 firing moves. Returns false if
     * the bot did not fire on the last move.
     */
    public boolean lastMoveWasFire(int lastMove){
        switch(lastMove){
            case BattleBotArena.FIREDOWN:
                return true;
            case BattleBotArena.FIRELEFT:
                return true;
            case BattleBotArena.FIRERIGHT:
                return true;
            case BattleBotArena.FIREUP:
                return true;
            default:
                return false;
        }
    }

    /**
     * Dodges bullets in the x-axis motion if bullet is a certain radius away from the relative position of the bot 
     * or dodges bullets in the y-axis motion if the bullet is certain radius from the relative position from the bot.
     * @author Sean
     * @param me
     * @param bullets
     * @return
     */
    public int dodgeBullets(BotInfo me, Bullet[] bullets){
        double bulletsFromYToBot = 0;
        double bulletsFromXToBot = 0;
        double centerX,centerY = 0;
        double absDistY = 0;
        double absDistX = 0;
        
        
        for(int i=0;i<bullets.length;i++){
            // Calculate the y-coord distance (pixels) of the bot and bullest on screen
            bulletsFromYToBot = me.getY() - bullets[i].getY();
            // Calculate the x-coord distance (pixels) of the bot and bullest on screen
            bulletsFromXToBot = me.getX() - bullets[i].getX();
        
            // If the absolute value (in pixel) of the bullets relative to the bot is less than < 20 pixels, break out of loop
            if(Math.abs(bulletsFromXToBot) < 20 && (bullets[i].getY() < me.getY() + 10 && bullets[i].getY() > me.getY() - 10)){
                break;
            } else if(Math.abs(bulletsFromYToBot) < 20 && (bullets[i].getY() < me.getX() + 10 && bullets[i].getY() > me.getX() - 10)){
                break;
                // If not, continue
            } else{
                continue; 
            } 
        }

        // Calculate 
        centerX = me.getX() - bulletsFromXToBot + 25;
        centerY = me.getY() - bulletsFromYToBot + 25;

        absDistY = Math.abs(centerY - bulletsFromYToBot);
        absDistX = Math.abs(centerX - bulletsFromXToBot);

        if(centerY > bulletsFromYToBot && absDistY < 25){
            return BattleBotArena.LEFT;
        } else if(centerY < bulletsFromYToBot && absDistY < 25){
            return BattleBotArena.RIGHT;
        } else if(centerX > bulletsFromXToBot && absDistX < 25){
            return BattleBotArena.DOWN;
        } else if(centerX < bulletsFromXToBot && absDistX < 25){
            return BattleBotArena.UP;
        }

        return 0;
    }
    
    /**
     * Fires bullets towards enemy bots when they are close
     * @author Sean
     * @param me
     * @param liveBots
     * @param shotOk
     * @return
     */
    public int fireBullets(BotInfo me, BotInfo[] liveBots, boolean shotOk){
        double botsFromXToBot = 0;
        double botsFromYToBot = 0;
        double opposite = 0;
        double adjacent = 0;
        BotInfo closeBot = null;
        
        for(int i=0;i<liveBots.length;i++){
            botsFromYToBot = me.getY() - liveBots[i].getY();
            botsFromXToBot = me.getX() - liveBots[i].getX();

            if(Math.abs(botsFromXToBot) < 75 && me.getY() - 100 < liveBots[i].getY() && me.getY() + 100 > liveBots[i].getY() && shotOk){
                closeBot = liveBots[i];
                break;
            } else if(Math.abs(botsFromYToBot) < 75 && me.getX() - 100 < liveBots[i].getX() && me.getX() + 100 > liveBots[i].getX() && shotOk){
                closeBot = liveBots[i];
                break;
            } else{
                continue; 
            } 
        }

        if(closeBot == null){
            return 0;
        }
        
        //some trig magic
        opposite = closeBot.getY() - me.getY();
        adjacent = closeBot.getX() - me.getX();
        //oooo more trig magic 
        double divide = opposite / adjacent;
        double angle = Math.atan(divide);
        double toDegrees = angle * (180 / Math.PI);

        if(closeBot.getX() > me.getX() && closeBot.getY() < me.getY()){
            toDegrees += 360;
        }else if(closeBot.getX() < me.getX() && closeBot.getY() < me.getY()){
            toDegrees += 180;
        }else if(closeBot.getX() < me.getX() && closeBot.getY() > me.getY()){
            toDegrees += 180;
        }else if (closeBot.getX() == me.getX() && closeBot.getY() < me.getY()){
            toDegrees = 270;
        }
        else if (closeBot.getX() == me.getX() && closeBot.getY() > me.getY()){
            toDegrees = 90;
        }
        else if (closeBot.getY() == me.getY() && closeBot.getX() < me.getX()){
            toDegrees = 180;
        }

        System.out.println(toDegrees);

        if(toDegrees >= 45 && toDegrees < 135){
            return BattleBotArena.FIREDOWN;
        }else if(toDegrees >= 135 && toDegrees < 215){
            return BattleBotArena.FIRELEFT;
        }else if(toDegrees >= 215 && toDegrees < 305){
            return BattleBotArena.FIREUP;
        }else if((toDegrees >= 305 && toDegrees < 360) || (toDegrees >= 0 && toDegrees < 45)){
            return BattleBotArena.FIRERIGHT;
        }

        return 0;

        }


    @Override
    public void draw(Graphics g, int x, int y) {

    }

    @Override
    public String getName() {
        return "GithubCheese";
    }

    @Override
    public String getTeamName() {
        return null;
    }

    @Override
    public String outgoingMessage() {
        return null;
    }

    @Override
    public void incomingMessage(int botNum, String msg) {

    }

    @Override
    public String[] imageNames() {
        return null;
    }

    @Override
    public void loadedImages(Image[] images) {

    }

}