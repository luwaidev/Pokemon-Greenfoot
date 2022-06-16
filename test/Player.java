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
    boolean openBag;
    private int xCoord;
    private int yCoord;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        move();
        checkBag(); 
    }
    
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
    public void checkBag(){
        if(Greenfoot.isKeyDown("b")){
            
            openBag = true; 
            Greenfoot.setWorld(new Bag(this.getX(), this.getY()));
        }
    }
}
