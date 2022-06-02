import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Trainer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trainer extends Battle
{
    /**
     * Act - do whatever the Trainer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int i = 0;
    GreenfootImage image; 
    //boolean for gender
    public Trainer(){//pass parameter for gender?
        image = new GreenfootImage("images/BattleTrainerImages/boy0.png");
        setImage(image);
    }
    
    
    public void act()
    {           
        move(-1);
        i++;
        if(i-50 == 0){
            image = new GreenfootImage("images/BattleTrainerImages/boy1.png");
            setImage(image);
        }
        if(i-70 == 0){
            image = new GreenfootImage("images/BattleTrainerImages/boy2.png");
            setImage(image);
            getWorld().addObject(new PokeBall(), 100, 350);
        }
        if(i-90 == 0){
            image = new GreenfootImage("images/BattleTrainerImages/boy3.png");
            setImage(image);
        }
        if(i-110 == 0){
            image = new GreenfootImage("images/BattleTrainerImages/boy4.png");
            setImage(image);
        }
    }
}
