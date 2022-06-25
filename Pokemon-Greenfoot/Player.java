import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player does not really do much. It just sits there while the world performs movements with it
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
        movePlayer(); 
    }
    
    public void movePlayer(){
        
        if(Greenfoot.isKeyDown("right")){
            setRotation(0); 
            move(2); 
        }
        if(Greenfoot.isKeyDown("down")){
            setRotation(90); 
            move(2); 
        }
        if(Greenfoot.isKeyDown("up")){
            setRotation(270); 
            move(2); 
        }
        if(Greenfoot.isKeyDown("left")){
            setRotation(180); 
            move(2); 
        }
        /*if(Player.class != null){
            System.out.println("bruh"); 
        }*/
        if(isTouching(Door.class)){
            System.out.println("Touched door"); 
            Greenfoot.setWorld(new Town(300, 200, 1)); 
        }
        
    }
    
}
