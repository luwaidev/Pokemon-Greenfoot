import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class House here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class House extends World
{
    //background of house 
    GreenfootImage houseBackground = new GreenfootImage("home.png"); 
    
    //objects for scroller
    Scroller scroller; 
    Player scrollActor; 
    
    //X and Y coords set for player 
    static int originalX= 0, originalY = 0; 
    static int x,y; 
    
    //world constant 
    public static final int HIGH = 400, WIDE = 500; 
    /**
     * Constructor for objects of class House.
     * 
     */
    public House()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        this.x = x; 
        this.y = y; 
        
        setBackground(houseBackground); 
    }
    
    public void addPlayer(){
        originalX = x; 
        originalY = y; 
        scroller = new Scroller(this, houseBackground, 500, 400);
        scrollActor = new Player();
        addObject(scrollActor, x, y);
        Player.originalX = originalX;
        Player.originalY = originalY;
        Player.worldX = originalX;
        Player.worldY = originalY;
        Player.speed = 2;
        scroll();
    }
    
    public void scroll(){
        if(scrollActor != null)
        {
            int dsX = scrollActor.getX() - WIDE / 2;
            int dsY = scrollActor.getY() - HIGH / 2;
            scroller.scroll(dsX, dsY);
        }
    }
    
}
