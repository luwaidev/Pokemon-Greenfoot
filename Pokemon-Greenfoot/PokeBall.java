import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PokeBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PokeBall extends Battle
{
    /**
     * Act - do whatever the PokeBall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage image = new GreenfootImage("images/BattleImages/pokeBall.png");
    public PokeBall(){
        image.scale(50,40);
        setImage(image);
        
    }
    //x 175, y 350
    public void act()
    {
        if(getX() < 175){
            setLocation(getX() + 1, getY() + 1);
            turn(3);
        }
        
    }
}
