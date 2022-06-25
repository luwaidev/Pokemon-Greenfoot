import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Animator
{
    public static Player instance;
    
    static int speed = 2; 
    static int originalX, originalY; 
    static int worldX, worldY; 
    
    public Player() {
        ///// Setting up animations /////
       
        instance = this;
        
        
        GreenfootImage img = new GreenfootImage("player.png");
        addAnimation(AnimationManager.createAnimation(img, 1 * 64, 2 * 64, 1, 1, 1, 64, 64, "Idle Left"));
        addAnimation(AnimationManager.createAnimation(img, 2 * 64, 2 * 64, 1, 1, 1, 64, 64, "Idle Right"));
        addAnimation(AnimationManager.createAnimation(img, 0 * 64, 2 * 64, 1, 1, 1, 64, 64, "Idle Down"));
        addAnimation(AnimationManager.createAnimation(img, 3 * 64, 2 * 64, 1, 1, 1, 64, 64, "Idle Up"));

        addAnimation(AnimationManager.createAnimation(img, 1 * 64, 0 * 64, 1, 4, 4, 64, 64, "Walk Left"));
        addAnimation(AnimationManager.createAnimation(img, 2 * 64, 0 * 64, 1, 4, 4, 64, 64, "Walk Right"));
        addAnimation(AnimationManager.createAnimation(img, 0 * 64, 0 * 64, 1, 4, 4, 64, 64, "Walk Down"));
        addAnimation(AnimationManager.createAnimation(img, 3 * 64, 0 * 64, 1, 4, 4, 64, 64, "Walk Up"));
        
        setImage(animations[1].getImage(0));

        playAnimation("Walk Side");

    
    }
    
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    
    public void walkLeft()
    {
        playAnimation("Walk Left");
        
    }
    
    public void walkRight()
    {
        playAnimation("Walk Right");
        
    }
    
    public void walkUp()
    {
        playAnimation("Walk Up");
        
    }
    
    public void walkDown()
    {
        playAnimation("Walk Down");
        
    }
    
    public void setIdle()
    {
        if(curAnim == 4){
            playAnimation("Idle Left");
            
        } else if(curAnim == 5){
            playAnimation("Idle Right");
            
        } else if(curAnim == 6){
            playAnimation("Idle Up");
            
        } else if(curAnim == 7){
            playAnimation("Idle Down");
            
        }
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
