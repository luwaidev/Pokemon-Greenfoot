import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    
    static int speed = 2; 
    static int originalX, originalY; 
    static int worldX, worldY; 
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        //move();
    }
    
    /*
    public void move(){
        if(Greenfoot.isKeyDown("left")){
            setRotation(180);
            move(speed); 
        }
        if(Greenfoot.isKeyDown("right")){
            setRotation(0);
            move(speed); 
        }
        if(Greenfoot.isKeyDown("up")){
            setRotation(270);
            move(speed);
        }
        if(Greenfoot.isKeyDown("down")){
            setRotation(90);
            move(speed);
        }
    }
    */
    
}
