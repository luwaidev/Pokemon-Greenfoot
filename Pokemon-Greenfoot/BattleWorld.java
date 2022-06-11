import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BattleWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BattleWorld extends World
{
    public boolean playerTurn;
    private int time;
    /**
     * Constructor for objects of class BattleWorld.
     * 
     */
    public BattleWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 500, 1); 
        setBackground("images/BattleImages/routeBackground.jpeg");
        
        
         //coords for adding pokeBall
        
        addObject(new Trainer(), 300, 350);
        
        /*
         * startObjects()
         * addMenu()
         * addData()
         * setBackground(type of background pass into the image selector)
         * 
         */
        
    }
    
    public void act(){
        
    }
    
    public void StartBattle(){
        
    }
}
