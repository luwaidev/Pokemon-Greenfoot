import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyHpBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyHpBar extends Battle
{
    /**
     * Act - do whatever the EnemyHpBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image = new GreenfootImage("images/BattleImages/HPEnemy.png");
    int a = 0;
    public EnemyHpBar(){
        setImage(image);
    }
    
    public void act()
    {
        a++;
        if(a>=2){
            a=0;
            if(getY() < 125){
                setLocation(getX(), getY() + 1);
            }
        }
    }
}
