import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
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
    private static int gridPosX;
    private static int gridPosY;

    Random random = new Random();

    private static int originalX;
    private static int originalY;
    public static final int HIGH = 400, WIDE = 500; //400, 500 //880 1483 - original image size 

    Scroller scroller;
    Player scrollActor;

    private SuperTextBox testBox;

    private MouseInfo m;

    private int rectCheck = 0;

    private Player player;

    private Font funFont, boringFont;
    private int counter, maxCount, countdown;

    private Rectangle pauseBox;
    private GreenfootImage pauseBoxScreen = new GreenfootImage("pauseScreen.png");

    private float[] results;

    private long start, current, elapsed;
    private int total;
    private long seconds;

    private int timer = 0;

    private boolean boy;
    private boolean moving;

    private double worldFactor = 0.1;
    private int gridX;
    private int gridY;

    private boolean paused = false;

    private int pokemonHealth;

    private GreenfootImage gridLines;

    private int[][] theMovementGrid;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Town(int x, int y, int health)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDE, HIGH, 1, false); 
        

        pokemonHealth = health;
        gridPosX = x;
        gridPosY = y;
        originalX = gridPosX * 10;
        originalY = gridPosY*10;
        //makes grid with dimensions factored into the world
        gridX = (int)(1400.00*worldFactor);
        gridY = (int)(1000.00*worldFactor);

        pauseBoxScreen.scale(500,400);
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

        for(int i = 0; i<gridX; i++)
        {
            for(int j = 0; j < 7; j++)
            {
                theMovementGrid[i][j] = 0;
            }
        }
        //random blurb thinking through logic
        //scroller uses an image and goes through that as the player moves
        //should probably make a grid over the image and use logic to convert player location into spots on the grid
        //how????
        //player area is someting like 550 x 400
        //image is like 1480 x 700
        //grid using factors and numbers from image
        //need to see code to make it work
        fillBigTree(3,59);
        fillBigTree(3,78);
        fillBigTree(24,59);
        fillBigTree(24,78);
        fillRowBigTree(43,50);
        fillRowBigTree(43,63);
        fillRowBigTree(43,76);
        fillRowBigTree(54,76);
        fillRowBigTree(65,76);
        fillRowBigTree(76,76);
        fillRowBigTree(87,76);
        fillRowBigTree(98,76);
        fillRowBigTree(109,76);
        fillRowBigTree(120,76);
        fillSmallTree(131,75);
        fillSmallTree(131,58);
        fillSmallTree(131,45);
        fillSmallTree(131,32);
        fillSmallTree(131,19);
        fillSmallTree(112,32);
        fillSmallTree(112,45);
        for(int i = 38; i<90; i++)
        {
            for(int j = 20; j < 41; j++)
            {
                theMovementGrid[i][j] = 0;
            }
        }
        for(int i = 54; i<76; i++)
        {
            for(int j = 50; j < 63; j++)
            {
                theMovementGrid[i][j] = 0;
            }
        }
        for(int i = 86; i<107; i++)
        {
            for(int j = 43; j < 63; j++)
            {
                theMovementGrid[i][j] = 0;
            }
        }
        for(int i = 25; i<37; i++)
        {
            for(int j = 72; j < 78; j++)
            {
                theMovementGrid[i][j] = 2;
            }
        }
        for(int i = 93; i<120; i++)
        {
            for(int j = 19; j < 31; j++)
            {
                theMovementGrid[i][j] = 2;
            }
        }
        for(int i = 2; i<32; i++)
        {
            for(int j = 7; j < 22; j++)
            {
                theMovementGrid[i][j] = 2;
            }
        }
        for(int i = 15; i<24; i++)
        {
            for(int j = 59; j < 71; j++)
            {
                theMovementGrid[i][j] = 2;
            }
        }
        for(int i = 15; i<24; i++)
        {
            for(int j = 78; j < 90; j++)
            {
                theMovementGrid[i][j] = 2;
            }
        }
        for(int i = 2; i<14; i++)
        {
            for(int j = 72; j < 78; j++)
            {
                theMovementGrid[i][j] = 2;
            }
        }
        for(int i = 63; i<68; i++)
        {
            for(int j = 58; j < 63; j++)
            {
                theMovementGrid[i][j] = 3;
            }
        }
        for(int i = 94; i<99; i++)
        {
            for(int j = 57; j < 63; j++)
            {
                theMovementGrid[i][j] = 3;
            }
        }
        for(int i = 123; i<127; i++)
        {
            for(int j = 2; j < 7; j++)
            {
                theMovementGrid[i][j] = 3;
            }
        }
        addPlayer(); 
    }

    /**
     * Fills tree with 0s, x y coordinate has to be upper left corner of the box 
     * surrounding a tree
     */
    public void fillBigTree(int x, int y)
    {
        for(int i = x; i<(x+12); i++)
        {
            for(int j = y; j < (y+13); j++)
            {
                theMovementGrid[i][j] = 0;
            }
        }
    }

    /**
     * Fills tree with 0s, x y coordinate has to be upper left corner of the box 
     * surrounding a tree
     */
    public void fillRowBigTree(int x, int y)
    {
        for(int i = x; i<(x+11); i++)
        {
            for(int j = y; j < (y+13); j++)
            {
                theMovementGrid[i][j] = 0;
            }
        }
    }

    public void fillSmallTree(int x, int y)
    {
        for(int i = x; i<(x+9); i++)
        {
            for(int j = y; j < (y+13); j++)
            {
                theMovementGrid[i][j] = 0;
            }
        }
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

    public void addPlayer(){
        GreenfootImage background = new GreenfootImage("map.png");
        scroller = new Scroller(this, background, 1390, 1000);
        scrollActor = new Player();
        addObject(scrollActor, originalX, originalY);
        Player.originalX = this.originalX;
        Player.originalY = this.originalY;
        Player.worldX = originalX;
        Player.worldY = originalY;
        Player.speed = 2;
        scroll();
    }

    public void scroll()
    {
        if(scrollActor != null)
        {
            int dsX = scrollActor.getX() - WIDE / 2;
            int dsY = scrollActor.getY() - HIGH / 2;
            scroller.scroll(dsX, dsY);
        }
    }

    private void checkKeys(){
        double moveX = (1400.00/gridX);
        double moveY = (1000.00/gridY);
        if(!moving){
            if (Greenfoot.isKeyDown("right")){
                try{
                    if(theMovementGrid[gridPosX+1][gridPosY] == 1 || theMovementGrid[gridPosX+1][gridPosY] == 2)
                    {
                        if(theMovementGrid[gridPosX+1][gridPosY] == 3)
                        {
                            boolean newPlace = random.nextBoolean();
                            if(newPlace)
                            {
                                //put in code to go into new world
                            }
                        }
                        moving = true;
                        scrollActor.setRotation(0);
                        scrollActor.move((int)moveX);
                        moving = false;
                        gridPosX++;
                        if(theMovementGrid[gridPosX+1][gridPosY] == 2)
                        {
                            boolean fight = random.nextBoolean();
                            if(fight)
                            {
                                //put in code to go into battle mode
                            }
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e)
                {

                }
            } else if (Greenfoot.isKeyDown("left")){
                try{
                    if(theMovementGrid[gridPosX-1][gridPosY] == 1 || theMovementGrid[gridPosX-1][gridPosY] == 2)
                    {
                        if(theMovementGrid[gridPosX-1][gridPosY] == 3)
                        {
                            boolean newPlace = random.nextBoolean();
                            if(newPlace)
                            {
                                //put in code to go into new world
                            }
                        }
                        moving = true;
                        scrollActor.setRotation(180);
                        scrollActor.move((int)moveX);
                        moving = false;
                        gridPosX--;
                        if(theMovementGrid[gridPosX-1][gridPosY] == 2)
                        {
                            boolean fight = random.nextBoolean();
                            if(fight)
                            {
                                //put in code to go into battle mode
                            }
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e)
                {

                }
            } else if (Greenfoot.isKeyDown("up")){
                try{
                    if(theMovementGrid[gridPosX][gridPosY-1] == 1 || theMovementGrid[gridPosX][gridPosY-1] == 2)
                    {
                        if(theMovementGrid[gridPosX][gridPosY-1] == 3)
                        {
                            boolean newPlace = random.nextBoolean();
                            if(newPlace)
                            {
                                //put in code to go into new world
                            }
                        }
                        moving = true;
                        scrollActor.setRotation(270);
                        scrollActor.move((int)moveY);
                        moving = false;
                        gridPosY--;
                        if(theMovementGrid[gridPosX][gridPosY-1] == 2)
                        {
                            boolean fight = random.nextBoolean();
                            if(fight)
                            {
                                //put in code to go into battle mode
                            }
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e)
                {

                }
            } else if (Greenfoot.isKeyDown("down")) {
                try{
                    if(theMovementGrid[gridPosX][gridPosY+1] == 1 || theMovementGrid[gridPosX][gridPosY+1] == 2)
                    {
                        if(theMovementGrid[gridPosX][gridPosY+1] == 3)
                        {
                            boolean newPlace = random.nextBoolean();
                            if(newPlace)
                            {
                                //put in code to go into new world
                            }
                        }
                        moving = true;
                        scrollActor.setRotation(90);
                        scrollActor.move((int)moveY);
                        moving = false;
                        gridPosY++;
                        if(theMovementGrid[gridPosX][gridPosY+1] == 2)
                        {
                            boolean fight = random.nextBoolean();
                            if(fight)
                            {
                                //put in code to go into battle mode
                            }
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e)
                {

                }
            }
        }
    }

    public void pauseScreen()
    {
        if (rectCheck==0){
            pauseBox = new Rectangle(this.getWidth(),this.getHeight(),255);
            pauseBox.setImage(pauseBoxScreen);
            addObject(pauseBox, getWidth()/2, getHeight()/2);
            rectCheck = 1;
        }
    }

    public void checkPause()
    {
        if(Greenfoot.isKeyDown("1"))
        {
            Storer.setSave(1,0,gridPosX);
            Storer.setSave(1,1,gridPosY);
            Storer.setSave(1,2,pokemonHealth);
        } else if(Greenfoot.isKeyDown("2"))
        {
            Storer.setSave(2,0,gridPosX);
            Storer.setSave(2,1,gridPosY);
            Storer.setSave(2,2,pokemonHealth);
        } else if(Greenfoot.isKeyDown("3"))
        {
            Storer.setSave(3,0,gridPosX);
            Storer.setSave(3,1,gridPosY);
            Storer.setSave(3,2,pokemonHealth);
        } else if(Greenfoot.isKeyDown("4"))
        {
            Storer.setSave(4,0,gridPosX);
            Storer.setSave(4,1,gridPosY);
            Storer.setSave(4,2,pokemonHealth);
        } else if(Greenfoot.isKeyDown("shift"))
        {
            removeObject(pauseBox);
            rectCheck = 0;
            paused = false;
        } else if(Greenfoot.isKeyDown("m"))
        {
            removeObject(pauseBox);
            rectCheck = 0;
            TitleScreen title = new TitleScreen();
            Greenfoot.setWorld(title);
        }
    }

    public void act () {
        m = Greenfoot.getMouseInfo();
        if (Greenfoot.isKeyDown("u"))
        {
            System.out.println("grid x: " + gridPosX + " grid y: " + gridPosY);
        }
        if(!paused)
        {
            if(Greenfoot.isKeyDown("space"))
            {
                paused = true;
            }
            if(timer >= 3)
            {
                checkKeys();
                timer = 0;
            }
            else
            {
                timer++;
            }
            scroll();
        } else
        {
            pauseScreen();
            checkPause();
        }
    }
}