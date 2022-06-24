import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bag here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Bag extends World
{
    Color clear = new Color(0,0,0,0); 
    public int xCoord;
    public int yCoord;
    /**
     * Constructor for objects of class Bag.
     * 
     */
    public Bag(int x, int y)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 400, 1); 
        xCoord = x;
        yCoord= y;
        getBackground().drawImage(new GreenfootImage("Items: ", 64, Color.WHITE, clear), 250, 40);
    }
    public void act(){
        checkBag(); 
    }
    public void checkBag(){
        if(Greenfoot.mouseClicked(null)){
            Greenfoot.setWorld(new MyWorld(xCoord, yCoord));
        }
    }
}
