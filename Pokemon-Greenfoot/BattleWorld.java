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
        
        
        
        addObject(new TextBar(), 300, 450);
        addObject(new PlayerPlatform(), 200, 370);
        addObject(new EnemyPlatform(), 450, 200);
        addObject(new Trainer(), 300, 252);
        
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
