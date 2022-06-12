import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BattleButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BattleButton extends Battle
{
    /**
     * Act - do whatever the BattleButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public BattleButton(String type, boolean isHovering){
        if(isHovering){
            setImage("images/BattleImages/Buttons/" + type + "1.png");
        } else{
            setImage("images/BattleImages/Buttons/" + type + "0.png");
        }
    }
    public void act()
    {
        // Add your action code here.
    }
}
