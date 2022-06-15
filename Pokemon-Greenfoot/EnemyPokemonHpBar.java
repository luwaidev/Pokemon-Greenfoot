import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyPokemonHpBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyPokemonHpBar extends Battle
{
    /**
     * Act - do whatever the EnemyPokemonHpBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image = new GreenfootImage("images/BattleImages/HPEnemy.png");
    boolean addedHpBar = false;
    int maxHealth = 300; 
    int curHealth = 300;
    SuperStatBar hpBar;
    public EnemyPokemonHpBar(){
        setImage(image);
    }
    
    public void act()
    {
        
        if(getY() < 125){
            setLocation(getX(), getY() + 3);
        }
        if(getY() >= 125){
            if(!addedHpBar){
                hpBar = new SuperStatBar(maxHealth, curHealth, this, 100, 8, 6, Color.GREEN, Color.BLACK, false, Color.BLACK, 1);
                getWorld().addObject(hpBar, 0, 0);
                //getWorld().addObject(new TextBar(), 300, 465);
                addedHpBar = true;
                
            }
            //curHealth--;
            hpBar.update(curHealth);
        }
    }
    
    /*public void updateHealth(int health){
        curHealth = health;
        // TODO: Update stat bar because i have no idea how the fuck to do that
    }
    
    
    public void updateHealth(int health, int max){
        curHealth = health;
        maxHealth = max;
        // TODO: Update stat bar because i have no idea how the fuck to do that
    }*/
}
