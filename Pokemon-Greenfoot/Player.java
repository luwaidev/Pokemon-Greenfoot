import greenfoot.*;
/**
 * This Player demonstrates how to use the SuperSmoothMover class. See notes in 
 * SuperSmoothMover for details.
 * 
 * @author Jordan Cohen 
 * @version 1.10 (December 2021)
 */
public class Player extends SuperSmoothMover
{
    // Player size
    private final int WIDTH = 48; 
    private final int HEIGHT = 48;

    // Physics variables
    private double thrust = .08; 
    private double decay = 0.992;
    private double maxSpeed = 4.0;
    private double minSpeed = 0.1;
    private double turningSpeed = 10.0;
    private double speed;
    private double xSpeed, ySpeed;

    private int xLocation;
    private int yLocation;
    
    // Drawing variables
    private GreenfootImage normalImage, accelImage;
    private int armorRings;
    private boolean thrusting;

    private SuperStatBar stats;
    private SuperSpeechBubble bubble;
    
    public Player () {
        
    }

    public void addedToWorld (World w){
        
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {    
        
    }

    
    
    private void setXLocation(int xx)
    {
        xLocation = xx;
    }
    
    private void setYLocation(int yy)
    {
        yLocation = yy;
    }
}