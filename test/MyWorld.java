import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    static int originalX = 300, originalY = 200;
    public static final int HIGH = 400, WIDE = 500; //400, 500 //880 1483 - original image size 
    
    Scroller scroller;
    Player scrollActor;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDE, HIGH, 1, false); 
        addPlayer(); 
    }
    
    public void act(){
        scroll();
    }
    
    public void addPlayer(){
        GreenfootImage background = new GreenfootImage("background.png");
        scroller = new Scroller(this, background, 1483, 880);
        scrollActor = new Player();
        addObject(scrollActor, originalX, originalY);
        Player.originalX = originalX;
        Player.originalY = originalY;
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
}
