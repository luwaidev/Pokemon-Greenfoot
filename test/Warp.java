import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Warp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Warp extends Actor
{
    String destinationWorld; 
    int destinationX, destinationY;
    
    int index; 
    /**
     * Constructor for objects of class Warp.
     * 
     */
    public Warp(String destinationWorld, int x, int y, int width, int height, int index){    
         getImage().scale(width,height);
         destinationX = x;
         destinationY = y; 
         this.destinationWorld = destinationWorld; 
         this.index = index; 
    }
    public void act(){ 
        if(isTouching(Player.class)){
            switch(destinationWorld){
                case "MyWorld": MyWorld.originalX = destinationX;
            }
        }
    }
}
