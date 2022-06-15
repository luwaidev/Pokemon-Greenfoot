import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BattleButton here.
 * 
 * 
 * Hovering methods: Nosson1459
 *      https://www.greenfoot.org/topics/58859/0
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BattleButton extends Battle
{
    /**
     * Act - do whatever the BattleButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Actor actorHoveredOver = null;
    private String buttonType = "";
    public BattleButton(String type){
        buttonType = type;
    }
    public void act()
    {
        if(mouseHoveringOver(this)){
            setImage("images/BattleImages/Buttons/" + buttonType + "1.png");
        }else{
            setImage("images/BattleImages/Buttons/" + buttonType + "0.png");
        }
    }
    
    /**
     * This method checks to see which button the mouse is hovering over
     */
    private void hoverOwner() {
        if ((actorHoveredOver == null || actorHoveredOver.getWorld() == null)
                && Greenfoot.mouseMoved(this)) {
            actorHoveredOver = this;
        } else if (actorHoveredOver == this && Greenfoot.mouseMoved(null)
                && !Greenfoot.mouseMoved(this)) {
            actorHoveredOver = null;
        }
    }
 
    /**
     * This methods returns true if the mouse is hovering over the specified
     * button.
     *
     * @param button the button to see if hovering over
     * @return true, if mouse is over specified button
     */
    public boolean mouseHoveringOver(Actor actor) {
        hoverOwner();
        return actorHoveredOver == actor;
    }
    
    public boolean mouseHoveringOver() {
        hoverOwner();
        return actorHoveredOver == this;
    }
 
    /**
     * Gets the button that the mouse is hovering over.
     *
     * @return the button that the mouse is over
     */
    public Actor getHoverOwner() {
        return actorHoveredOver;
    }
}
