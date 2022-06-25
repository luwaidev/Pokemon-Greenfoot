import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class AttackAnimation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AttackAnimation extends Battle
{
    /**
     * Act - do whatever the AttackAnimation wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int a = 0;
    public AttackAnimation(){
        
    }
    
    /**
     * Uses a timer to animate the attack by changing images
     */
    public void act()
    {
        a++;
        if(a==60){
            GreenfootImage image = new GreenfootImage("images/BattleImages/PlayerTackle/0.png");
            setImage(image);
        }
        if(a==65){
            GreenfootImage image = new GreenfootImage("images/BattleImages/PlayerTackle/1.png");
            setImage(image);
        }
        if(a==70){
            GreenfootImage image = new GreenfootImage("images/BattleImages/PlayerTackle/2.png");
            setImage(image);
        }
        if(a==75){
            GreenfootImage image = new GreenfootImage("images/BattleImages/PlayerTackle/3.png");
            setImage(image);
        }
        if(a==80){
            GreenfootImage image = new GreenfootImage("images/BattleImages/PlayerTackle/4.png");
            setImage(image);
        }
        if(a==85){
            GreenfootImage image = new GreenfootImage("images/BattleImages/PlayerTackle/5.png");
            setImage(image);
        }
        if(a==90){
            GreenfootImage image = new GreenfootImage("images/BattleImages/PlayerTackle/6.png");
            setImage(image);
        }
        if(a==95){
            GreenfootImage image = new GreenfootImage("images/BattleImages/PlayerTackle/7.png");
            setImage(image);
        }
        if(a==100){
            GreenfootImage image = new GreenfootImage("images/BattleImages/PlayerTackle/8.png");
            setImage(image);
        }
        if(a==105){
            GreenfootImage image = new GreenfootImage("images/BattleImages/PlayerTackle/9.png");
            setImage(image);
        }
        if(a==110){
            GreenfootImage image = new GreenfootImage("images/BattleImages/PlayerTackle/10.png");
            setImage(image);
        }
        if(a==115){
            List<SuperTextBox> textboxes = getWorld().getObjects(SuperTextBox.class);
            getWorld().removeObjects(textboxes);
            ((BattleWorld) getWorld()).enemyAttack();
            getWorld().removeObject(this);
        }
    }
}
