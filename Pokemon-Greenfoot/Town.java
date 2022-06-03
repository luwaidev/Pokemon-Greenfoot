import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The World that demonstrates my Library of Resources.
 * 
 * 1.01
 * -----
 * - Multibox basic functionality working
 * - Chooses padding and spacing based on font size
 * - Allows text to be added from top or bottom, knocking extra line off appropriately
 * 
 * 1.02
 * -----
 * - Multibox now has scrolling
 * - Started improving efficiency - maintain CenteredXs array better to avoid reprocessing same text
 * 
 * 1.03
 * -----
 * - Attempting to reverse getCenteredX to start at the right (end) of the image and look backwards
 * - IT WORKED! Leaving 1.03 with both algorithms just in case, will remove in 1.04 and just use the new one. 
 *   (It was about 100% faster locally, and 200% faster on the Gallery!)
 * 
 * 1.04
 * -----
 * - Vastly improved centering algorithm, now caches the results from previous runs to avoid repetition,
 *   also slightly improved the drawing methods. 
 *   
 * 1.05
 * -----
 * - Tweaked algorithm as it was missing small characters due to too much margin of error, slowed it down
 *   a tiny bit though.
 * - Renamed SuperMultiBox to SuperTextBox, and improved support for single-line text boxes, including
 *   a number of new constructors
 * - Renamed SuperTextBox to SuperDisplayLabel (as it's now intended to be as wide as the World as an easy
 *   way to display some stats). 
 * - Documentation is now more complete
 * - More tweaks to the centering algorithm including ignoring colours and just looking for alpha, and more 
 *   constructors added and tested. 
 * 
 * 1.10
 * -----
 * - Leaving SuperTextBox (formerly SuperMultiBox) alone now - it's as good as it's going to get. 
 * 
 * @author Jordan Cohen 
 * @version 1.0.5
 */
public class Town extends World
{

    private SuperTextBox testBox;

    private MouseInfo m;

    private Player player;

    private Font funFont, boringFont;
    private int counter, maxCount, countdown;

    private Timer timer;
    private float[] results;

    private long start, current, elapsed;
    private int total;
    private long seconds;

    private boolean boy;
    private boolean moving;

    private double worldFactor = 0.3;
    private int gridX;
    private int gridY;
    
    private GreenfootImage gridLines;

    private int[][] theMovementGrid;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Town(boolean boy)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 

        this.boy = boy;
        
        //makes grid with dimensions factored into the world
        gridX = (int)(800.00*worldFactor);
        gridY = (int)(600.00*worldFactor);
        
        //this is the movement grid that we are going to use 
        //loop through and make everything a 1 for now
        //where there are objects that cannot be passed, make the value 0
        //where there are pokemon, or interactable objects we can make them 2 or 3 etc.
        theMovementGrid = new int[gridX][gridY];
        for (int i = 0; i < gridX; i++)
        {
            for (int j = 0; j < gridY; j++)
            {
                theMovementGrid[i][j] = 1;
            }
        }
        player = new Player();
        addObject(player, getWidth()/2,getHeight()/2);
    }

    /**
     * Sharing mouseInfo is important.
     * 
     * Greenfoot can only poll Greenfoot.getMouseInfo() once per act. I suggest
     * putting this in your World so that your Actors can share this. Otherwise,
     * literally only one object can access the mouse data per act, which is not ideal.
     * Note that this World's act method contains m = Greenfoot.getMouseInfo, and that
     * the act order sets the World to act first.
     * 
     * @return MouseInfo the current state of the mouse as captured by World at the start of this act
     */
    public MouseInfo getMouseInfo() {
        if (m == null){
            m = Greenfoot.getMouseInfo();
        }
        return m;
    }

    private void checkKeys(){
        double moveX = (800.00/gridX);
        double moveY = (600.00/gridY);
        int playerX = (int)(player.getX()/moveX);
        int playerY = (int)(player.getY()/moveY);
        if(!moving){
            if (Greenfoot.isKeyDown("right")){
                try{
                    if(theMovementGrid[playerX+1][playerY] == 1)
                    {
                        moving = true;
                        player.setRotation(0);
                        player.move(moveX);
                        moving = false;
                    }
                } catch (ArrayIndexOutOfBoundsException e)
                {

                }
            } else if (Greenfoot.isKeyDown("left")){
                try{
                    if(theMovementGrid[playerX-1][playerY] == 1)
                    {
                        moving = true;
                        player.setRotation(180);
                        player.move(moveX);
                        moving = false;
                    }
                } catch (ArrayIndexOutOfBoundsException e)
                {

                }
            } else if (Greenfoot.isKeyDown("up")){
                try{
                    if(theMovementGrid[playerX][playerY-1] == 1)
                    {
                        moving = true;
                        player.setRotation(270);
                        player.move(moveY);
                        moving = false;
                    }
                } catch (ArrayIndexOutOfBoundsException e)
                {

                }
            } else if (Greenfoot.isKeyDown("down")) {
                try{
                    if(theMovementGrid[playerX][playerY+1] == 1)
                    {
                        moving = true;
                        player.setRotation(90);
                        player.move(moveY);
                        moving = false;
                    }
                } catch (ArrayIndexOutOfBoundsException e)
                {

                }
            }
        }
    }

    public void act () {
        m = Greenfoot.getMouseInfo();
        checkKeys();
    }
}