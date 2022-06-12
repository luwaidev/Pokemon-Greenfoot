import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PokeBallExplosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PokeBallExplosion extends Battle
{
    /**
     * Act - do whatever the PokeBallExplosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int a = 0;
    int b = 0;
    GreenfootImage image = new GreenfootImage("images/PokeBallExplosion/0.png");
    public PokeBallExplosion(){
        setImage(image);
    }
    
    public void act()
    {
        a++;
        //System.out.println(a%20);
        if(a%5 == 0){
            b++;
            image = new GreenfootImage("images/PokeBallExplosion/" + b + ".png");
            setImage(image);
            if(a/5 == 6){
                getWorld().addObject(new PlayerPokemonHpBar(), 468, 400);
                getWorld().addObject(new EnemyPokemonHpBar(), 100, 37);
                getWorld().removeObject(this);
            }
        }
    }
}
