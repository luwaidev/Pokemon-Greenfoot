import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class PlayerPokemonHpBar here.
 * 
 * @author (your name) 
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
    private int maxHealth; 
    private int curHealth;
    public SuperStatBar hpBar;
    public PlayerPokemonHpBar(int maxHp, int curHp){
        setImage(image);
        maxHealth = maxHp;
        curHealth = curHp;
    }
    
    public void act()
    {
        if(getY() > 300){
            setLocation(getX(), getY() - 3);
        }
        if(getY() <= 300){
            if(Greenfoot.isKeyDown("Enter")){
                List<SuperTextBox> textboxes = getWorld().getObjects(SuperTextBox.class);
                getWorld().removeObjects(textboxes);
                ((BattleWorld) getWorld()).mainMenu();
            }
            if(!addedHpBar){
                hpBar = new SuperStatBar(maxHealth, curHealth, this, 100, 8, 0, Color.GREEN, Color.BLACK, false, Color.BLACK, 1);
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
