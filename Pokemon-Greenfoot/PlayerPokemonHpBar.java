import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class PlayerPokemonHpBar here.
 * 
 * @author (Max) 
 * @version (a version number or a date)
 */
public class PlayerPokemonHpBar extends Battle
{
    /**
     * Act - do whatever the PlayerPokemonHpBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image = new GreenfootImage("images/BattleImages/HPPlayer.png");
    boolean addedHpBar = false;
    public int maxHealth; 
    public int curHealth;
    public SuperStatBar hpBar;
    public PlayerPokemonHpBar(int maxHp, int curHp){
        setImage(image);
        maxHealth = maxHp;
        curHealth = curHp;
    }
    
    /**
     * Moves the player pokemon hp bar into view when the battle starts and
     * updates the hp bar
     */
    public void act()
    {
        if(getY() > 300){
            setLocation(getX(), getY() - 3);
        }
        if(getY() <= 300){
            if(!addedHpBar){
                List<SuperTextBox> textboxes = getWorld().getObjects(SuperTextBox.class);
                getWorld().removeObjects(textboxes);
                ((BattleWorld) getWorld()).mainMenu();
                hpBar = new SuperStatBar(maxHealth, curHealth, this, 100, 8, 0, Color.GREEN, Color.LIGHT_GRAY, false, Color.BLACK, 1);
                getWorld().addObject(hpBar, 0, 0);
                addedHpBar = true;
            }
            //curHealth--;
            hpBar.update(curHealth);
        }
        
        //hpBar.update(curHealth);
        /*
         *
         * if(getY() == 370){
         *      addLabels -> for name, level, health
           }
         */
    }
    
    public void updateHealth(int health){
        curHealth = health;
        // TODO: Update stat bar because i have no idea how the fuck to do that
    }
    
    public void updateHealth(int health, int max){
        curHealth = health;
        maxHealth = max;
        // TODO: Update stat bar because i have no idea how the fuck to do that
    }
    
}
