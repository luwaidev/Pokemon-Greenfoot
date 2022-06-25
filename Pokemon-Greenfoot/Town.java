import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Game world. In this world the player moves around and can fight pokemon with their own pokemon
 * There are different areas
 * 
 * @author Nathan Thian (movement grid, world background, movement, setting boundaries, save function, pausing)
 * @version 06.15.2022
 */
public class Town extends World
{
    //keeps track of which grid position the player is currently at
    private static int gridPosX;
    private static int gridPosY;

    //random class used for random interactions
    Random random = new Random();

    //variables used to place players into the world at locations on the background image
    private static int originalX;
    private static int originalY;
    public static final int HIGH = 400, WIDE = 500; //400, 500 //880 1483 - original image size 

    //both of these are used in the scrolling
    Scroller scroller;
    Player scrollActor;

    //not really sure why this is here
    private SuperTextBox testBox;

    //gets mouse info
    private MouseInfo m;

    //checks if there is already a pause rectangle in the world
    private int rectCheck = 0;

    //fonts used just in case
    private Font funFont, boringFont;
    //counters just in case
    private int counter, maxCount, countdown;

    //box that pops up when the game is paused
    private Rectangle pauseBox;
    //image for the pauseBox; contains all the instructions that are needed in a pause
    private GreenfootImage pauseBoxScreen = new GreenfootImage("pauseScreen.png");

    //not in use currently
    private float[] results;

    //not in use currently
    private long start, current, elapsed;
    private int total;
    private long seconds;

    //timer keeps movement in check...increments
    private int timer = 0;

    //boolean that keeps track of whether player is currently moving
    private boolean moving;

    //factor that represents how big the tiles are in relation to the world. don't change this
    private double worldFactor = 0.1;
    //keeps track of how many x grids and y grids there are; used when looping through grids
    private int gridX;
    private int gridY;

    //boolean that keeps track of whether the game is paused or not
    private boolean paused = false;

    //change this; this is used to keep track of the pokemon's current health
    private int pokemonHealth;

    //initialize the movement grid
    private int[][] theMovementGrid;
    /**
     * Constructor for objects of class MyWorld. In this method, everything on the world is added and boundaries are set.
     * NOTE: the x and y variables here represent the X GRID coordinate and the Y GRID coordinate, NOT the actual coordinates
     * 
     */
    public Town(int x, int y, int health)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDE, HIGH, 1, false); 
        
        //sets the pokemon health, player grid x and y to the parameters
        pokemonHealth = health;
        gridPosX = x;
        gridPosY = y;
        
        //sets the position the player will be added to on the background image to the actual location of the player
        //not just the grid position
        //remember that tiles are 10 pixels by 10 pixels
        originalX = gridPosX * 10;
        originalY = gridPosY*10;
        
        //makes grid with dimensions factored into the world
        //should be 140 grids for x and 100 grids for y
        gridX = (int)(1400.00*worldFactor);
        gridY = (int)(1000.00*worldFactor);

        //scales the pausebox screen to fit 
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

        //boundaries for movement are set here
        setBoundaries();
        
        //player and scroller are added here
        addPlayer(); 
    }
    
    /**
     * this method is what sets the boundaries for movement on the grid and also player grid interactions
     */
    public void setBoundaries()
    {
        for(int i = 0; i<gridX; i++)
        {
            for(int j = 0; j < 7; j++)
            {
                theMovementGrid[i][j] = 0;
            }
        }
        //these methods are just filling grids with trees to be 0; aka cannot move here
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
        
        //starts to fill in grass with interactions aka 2
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
        
        //fills in doors with 3, so players can move through with a method
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

    /**
     * Fills tree with 0s, x y coordinate has to be upper left corner of the box 
     * surrounding a tree
     */
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

    /**
     * This method adds the player to the world and also adds the scroller
     */
    public void addPlayer(){
        //initializes the image that is the background of the world
        GreenfootImage background = new GreenfootImage("map.png");
        
        //note everything after this in this method has not been created by us, it was made by someone else
        
        //creates a scroller that encompasses the background image
        scroller = new Scroller(this, background, 1390, 1000);
        
        //initializes player character
        scrollActor = new Player();
        
        //adds the player actor onto the background at the location specified by parameters in world contructor
        addObject(scrollActor, originalX, originalY);
        
        //keeps track of variables
        //tbh idk how important these are
        Player.originalX = this.originalX;
        Player.originalY = this.originalY;
        Player.worldX = originalX;
        Player.worldY = originalY;
        Player.speed = 2;
        
        //method that allows for scrolling i assume (not really sure what it does but it is important)
        scroll();
    }

    /**
     * Method that goes through with the scrolling in the world (NOT MADE BY US, part of scroller class)
     */
    public void scroll()
    {
        if(scrollActor != null)
        {
            int dsX = scrollActor.getX() - WIDE / 2;
            int dsY = scrollActor.getY() - HIGH / 2;
            scroller.scroll(dsX, dsY);
        }
    }

    /**
     * This method checks for key presses and moves the player correspondingly
     * also checks for interactions with boundaries, grass, doors, etc
     * this is where the movement grid comes in
     */
    private void checkKeys(){
        //move x is the amount of pixels players move for each movement
        //pixels in x dimension divided by number of grids for x
        double moveX = (1400.00/gridX);
        
        //move y is the amount of pixels players move for each movement
        //pixels in y dimension divided by number of grids for y
        double moveY = (1000.00/gridY);
        
        //if not already moving...; helps to prevent diagonal movement and makes it seems more like classic pokemon movement; robust
        if(!moving){
            //if right arrow key is pressed...
            if (Greenfoot.isKeyDown("right")){
                try{
                    //if the grid you are trying to move to is 1 (path) or 2 (grass block)...
                    if(theMovementGrid[gridPosX+1][gridPosY] == 1 || theMovementGrid[gridPosX+1][gridPosY] == 2)
                    {
                        //if the grid you are trying to move to is 3 (a door that leads to somewhere)
                        if(theMovementGrid[gridPosX+1][gridPosY] == 3)
                        {
                            //put in code to go into new world
                        }
                        //sets the currently moving to true
                        moving = true;
                        //turns the player so it faces right and moves it the appropriate amount horizontally
                        scrollActor.setRotation(0);
                        scrollActor.move((int)moveX);
                        //sets currently moving to false
                        moving = false;
                        //updates the current x grid position accordingly
                        gridPosX++;
                        //if this is a grass block (2) then randomly decide whether a battle should take place
                        if(theMovementGrid[gridPosX][gridPosY] == 2)
                        {
                            //random here
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
                //if left arrow key is pressed...
                try{
                    //if the grid you are trying to move to is 1 (path) or 2 (grass block)...
                    if(theMovementGrid[gridPosX-1][gridPosY] == 1 || theMovementGrid[gridPosX-1][gridPosY] == 2)
                    {
                        //if the grid you are trying to move to is 3 (a door that leads to somewhere)
                        if(theMovementGrid[gridPosX-1][gridPosY] == 3)
                        {
                            //put in code to go into new world
                        }
                        //sets the currently moving to true
                        moving = true;
                        //turns the player so it faces left and moves it the appropriate amount horizontally
                        scrollActor.setRotation(180);
                        scrollActor.move((int)moveX);
                        //sets currently moving to false
                        moving = false;
                        //updates the current x grid position accordingly
                        gridPosX--;
                        //if this is a grass block (2) then randomly decide whether a battle should take place
                        if(theMovementGrid[gridPosX][gridPosY] == 2)
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
                //if the up arrow key is pressed...
                try{
                    //if the grid you are trying to move to is 1 (path) or 2 (grass block)...
                    if(theMovementGrid[gridPosX][gridPosY-1] == 1 || theMovementGrid[gridPosX][gridPosY-1] == 2)
                    { 
                        enterHouse(); 
                        //if the grid you are trying to move to is 3 (a door that leads to somewhere)
                        if(theMovementGrid[gridPosX][gridPosY-1] == 3)
                        {
                            //put in code to go into new world 
                            System.out.println("hi"); 
                            enterHouse(); 
                        }
                        //sets the currently moving to true
                        moving = true;
                        //turns the player so it faces up and moves it the appropriate amount vertically
                        scrollActor.setRotation(270);
                        scrollActor.move((int)moveY);
                        //sets currently moving to false
                        moving = false;
                        //updates the current y grid position accordingly
                        gridPosY--;
                        //if this is a grass block (2) then randomly decide whether a battle should take place
                        if(theMovementGrid[gridPosX][gridPosY] == 2)
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
                //if the down arrow key is pressed...
                try{
                    //if the grid you are trying to move to is 1 (path) or 2 (grass block)...
                    if(theMovementGrid[gridPosX][gridPosY+1] == 1 || theMovementGrid[gridPosX][gridPosY+1] == 2)
                    {
                        //if the grid you are trying to move to is 3 (a door that leads to somewhere)
                        if(theMovementGrid[gridPosX][gridPosY+1] == 3)
                        {
                            //put in code to go into new world
                        }
                        //sets the currently moving to true
                        moving = true;
                        //turns the player so it faces down and moves it the appropriate amount vertically
                        scrollActor.setRotation(90);
                        scrollActor.move((int)moveY);
                        //sets currently moving to false
                        moving = false;
                        //updates the current y grid position accordingly
                        gridPosY++;
                        //if this is a grass block (2) then randomly decide whether a battle should take place
                        if(theMovementGrid[gridPosX][gridPosY] == 2)
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

    /**
     * This method will place up the pause screen onto the screen when the game is paused
     */
    public void pauseScreen()
    {
        //if there is not already a pause rectangle on the screen...
        if (rectCheck==0){
            //initializes a pause box rectangle the size of the world
            pauseBox = new Rectangle(this.getWidth(),this.getHeight(),255);
            //sets the image of the pause box to the actual pause screen
            pauseBox.setImage(pauseBoxScreen);
            //add the pause box in the middle of the world
            addObject(pauseBox, getWidth()/2, getHeight()/2);
            //keeps track that there is a pause box already on screen; prevents duplicates
            rectCheck = 1;
        }
    }

    /**
     * This method will perform functions that are possible while the game is paused
     */
    public void checkPause()
    {
        //if 1 is pressed, the first save file is updated with this current game's information
        if(Greenfoot.isKeyDown("1"))
        {
            //see storer for specifics
            Storer.setSave(1,0,gridPosX);
            Storer.setSave(1,1,gridPosY);
            Storer.setSave(1,2,pokemonHealth);
        } else if(Greenfoot.isKeyDown("2"))
        {
            //see storer for specifics
            Storer.setSave(2,0,gridPosX);
            Storer.setSave(2,1,gridPosY);
            Storer.setSave(2,2,pokemonHealth);
        } else if(Greenfoot.isKeyDown("3"))
        {
            //see storer for specifics
            Storer.setSave(3,0,gridPosX);
            Storer.setSave(3,1,gridPosY);
            Storer.setSave(3,2,pokemonHealth);
        } else if(Greenfoot.isKeyDown("4"))
        {
            //see storer for specifics
            Storer.setSave(4,0,gridPosX);
            Storer.setSave(4,1,gridPosY);
            Storer.setSave(4,2,pokemonHealth);
        } else if(Greenfoot.isKeyDown("shift"))
        {
            //if shift is pressed, the pause box is removed and the game is set to unpaused
            removeObject(pauseBox);
            rectCheck = 0;
            paused = false;
        } else if(Greenfoot.isKeyDown("m"))
        {
            //if m is pressed, the pause box is removed and the world goes back to title screen
            //used to switch between save files and also to test
            removeObject(pauseBox);
            rectCheck = 0;
            TitleScreen title = new TitleScreen();
            Greenfoot.setWorld(title);
        } else if(Greenfoot.isKeyDown("5"))
        {
            //overwrites information on first save file
            Storer.setSave(1,0,-1);
            Storer.setSave(1,1,-1);
            Storer.setSave(1,2,-1);
        } else if(Greenfoot.isKeyDown("6"))
        {
            //overwrites information on second save file
            Storer.setSave(2,0,-1);
            Storer.setSave(2,1,-1);
            Storer.setSave(2,2,-1);
        } else if(Greenfoot.isKeyDown("7"))
        {
            //overwrites information on third save file
            Storer.setSave(3,0,-1);
            Storer.setSave(3,1,-1);
            Storer.setSave(3,2,-1);
        } else if(Greenfoot.isKeyDown("8"))
        {
            //overwrites information on fourth save file
            Storer.setSave(4,0,-1);
            Storer.setSave(4,1,-1);
            Storer.setSave(4,2,-1);
        }
    }
    
    public void enterHouse(){
        Greenfoot.setWorld(new House()); 
    }

    /**
     * Act method keeps track of all the methods that go on real time
     * movement, pausing, scrolling etc.
     */
    public void act () {
        //constantly getting mouse info
        m = Greenfoot.getMouseInfo();
        //if the game is not paused...
        if(!paused)
        {
            //press space to pause
            if(Greenfoot.isKeyDown("space"))
            {
                paused = true;
            }
            //without this timer, the player moves way too fast
            //allows movement every 3 acts
            if(timer >= 3)
            {
                checkKeys();
                timer = 0;
            }
            else
            {
                timer++;
            }
            //scroll method
            scroll();
        } else
        {
            //puts up pause screen
            pauseScreen();
            //checks pause methods
            checkPause();
        }
    }
}