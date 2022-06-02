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
    int a = 0;
    GreenfootImage image = new GreenfootImage("images/BattleImages/pokeBall.png");
    public PokeBall(){
        image.scale(50,40);
        setImage(image);
        
    }
    //x 175, y 350
    public void act()
    {
        a++;
        if(getX() < 200){
            if(a % 2 == 0){
                setLocation(getX() + 1, getY() + 1);
            }
            turn(6);
        }
        if(getX() >= 200){
            setRotation(0);
        }
        if(a == 200){
            setImage("images/BattleImages/halfOpenPokeBall.png");
        }
        if(a == 245){
            setImage("images/BattleImages/openedPokeBall.png");
        }
        if(a == 270){
            getWorld().addObject(new PokeBallExplosion(), this.getX(), this.getY());
            getWorld().removeObject(this);
        }
    }
}
