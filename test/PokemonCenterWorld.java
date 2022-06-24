import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PokemonCenterWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PokemonCenterWorld extends World
{
    static int originalX = 100, originalY = 100; 
    public static final int HIGH = 256, WIDE = 164; 
    
    Scroller scroller;
    Player scrollActor; 
    
    /**
     * Constructor for objects of class PokemonCenterWorld.
     * 
     */
    public PokemonCenterWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(HIGH, WIDE, 1, false); 
        addPlayer(); 
    }
    public void addPlayer(){
        GreenfootImage background = new GreenfootImage("pokemoncenter.png");
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
