import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pokemon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pokemon  
{
    // Honestly not really sure how to keep stats of different pokemon, Unity has this thing called scriptable objects, but I can't use that rn
    // Could create text files to record the stats of different pokemon but I don't wanna set up a system to get that working lmao
    public GreenfootImage staticImg;
    public String name;
    
    public int health;
    public int maxHealth;
    
    
    // Completely ignoring status moves
    public String[] moves;
    public int[] moveDmg;
    public int[] moveType; // not implemented yet
    
}
