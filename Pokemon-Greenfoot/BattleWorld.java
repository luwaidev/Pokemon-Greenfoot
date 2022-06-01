import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BattleWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BattleWorld extends World
{

    /**
     * Constructor for objects of class BattleWorld.
     * 
     */
    public BattleWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground("images/BattleImages/routeBackground.jpeg");
        
        
        addObject(new PokeBall(), 0, 175); //coords for adding pokeBall
        addObject(new PlayerPokemonHpBar(), 468, 380);
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
}
