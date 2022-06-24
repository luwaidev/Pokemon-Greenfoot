import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Trainer here.
 * 
 * @author (Max) 
 * @version (a version number or a date)
 */
public class Trainer extends Battle
{
    /**
     * Act - do whatever the Trainer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int i = 0;
    boolean startAnimations = false;
    GreenfootImage image; 
    //boolean for gender
    public Trainer(){//pass parameter for gender?
        image = new GreenfootImage("images/BattleTrainerImages/boy0.png");
        setImage(image);
    }
    
    /**
     * Mainly animations for Trainer when he moves out of play and 
     * calculates when he throws the Pokeball
     */
    public void act()
    {  
        if(Greenfoot.isKeyDown("Enter")){
            startAnimations = true;
            List<SuperTextBox> textboxes = getWorld().getObjects(SuperTextBox.class);
            getWorld().removeObjects(textboxes);
            getWorld().addObject(new SuperTextBox("Go, Turtwig!", new Font(false, false, 16), 100), 250, 450);
        }
        if(startAnimations){
            move(-4);
            i++;
            if(i-10 == 0){
                image = new GreenfootImage("images/BattleTrainerImages/boy1.png");
                setImage(image);
            }
            if(i-20 == 0){
                image = new GreenfootImage("images/BattleTrainerImages/boy2.png");
                setImage(image);
                getWorld().addObject(new PokeBall(), 100, 252);
            }
            if(i-30 == 0){
                image = new GreenfootImage("images/BattleTrainerImages/boy3.png");
                setImage(image);
            }
            if(i-40 == 0){
                image = new GreenfootImage("images/BattleTrainerImages/boy4.png");
                setImage(image);
                getWorld().removeObject(this);
            }
        }
        
    }
}
