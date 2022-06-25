import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class EndBattle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndBattle extends Battle
{
        /**
     * Act - do whatever the AttackAnimation wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int a = 0;
    public EndBattle(){
        
    }
    
    /**
     * Uses a timer to animate the attack by changing images
     */
    public void act()
    {
        a++;
        
        if(a>=160){
            List<SuperTextBox> textboxes = getWorld().getObjects(SuperTextBox.class);
            ((BattleWorld) getWorld()).enemyAttack();
            getWorld().removeObject(this);
        }
    }
}
