import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * An Icon - a small visual object with mouseover and clicked graphics (eventually)
 * which forms an interactive part of the UI.
 * 
 * @author Jordan Cohen
 * @version 1.1.3
 */
public class SuperIcon extends UIObject
{
    private static int width, height;
    
    private GreenfootImage image;
    private GreenfootImage mouseOverImage;
    private GreenfootImage disabledImage;
    private GreenfootImage clickedImage; // Can I do this? A challenge...
    
    private boolean active;
    private boolean mouseOver;
    public SuperIcon (GreenfootImage iconImage){
        active = true;
        mouseOver = false;
        image = new GreenfootImage (iconImage);
        if (image.getWidth() > width || image.getHeight() > height){
            
        }
    }
    /**
     * Act - do whatever the SuperIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public static void setIconSize (int width, int height){
        SuperIcon.width = width;
        SuperIcon.height = height;
    }
}

/**
 * 

     * This method will <b>reclaculate scale</b> and <b>update the displayImage</b>. 
     * <p>
     * You should always update the fullImage before calling this method.
     * For example, blueify applies the blue effect and then calls this.
     * <p>
     * Note - this is a fairly new method. If you run into issues with 
     * the scaling algorithm, please let me know.

    public void redraw(){
        // Recalculate scale:
        boolean tooWide = fullImage.getWidth() > Background.MAX_WIDTH;
        boolean tooTall = fullImage.getHeight() > Background.MAX_HEIGHT;
        // Width and Height are too big:
        if (tooWide && tooTall){
            
            double widthRatio = fullImage.getWidth() / (double)Background.MAX_WIDTH;
            double heightRatio = fullImage.getHeight() / (double)Background.MAX_HEIGHT;

            if (widthRatio >= heightRatio){
                scale = 1 / widthRatio;
            }  else {
                scale = 1 / heightRatio;
            }
            
        } else if (tooWide){
            double widthRatio = fullImage.getWidth() / (double)Background.MAX_WIDTH;
            scale = 1 / widthRatio;
        } else if (tooTall){
            double heightRatio = fullImage.getHeight() / (double)Background.MAX_HEIGHT;
            scale = 1 / heightRatio;
        }
        else {
            scale = 1.0;
        }

        displayImage = new GreenfootImage (fullImage);
        // Use scale to resize image proportionally 
        displayImage.scale ((int)((fullImage.getWidth() * scale) + 0.5), (int)((fullImage.getHeight() * scale) + 0.5));

        setImage(displayImage);
    }
 * 
 */
