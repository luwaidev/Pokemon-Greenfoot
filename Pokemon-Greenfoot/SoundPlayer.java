import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



/**
 * Class that is used to play all sounds in the simulation
 * 
 * Credits: 
 * all music from: https://downloads.khinsider.com/game-soundtracks/album/pokemon-red-green-blue-yellow
 * MADE BY OFFICIAL POKEMON GAME
 *  
 * 
 * @author Nathan Thian and Ethan Wong
 * @version June 24, 2022
 */
public class SoundPlayer extends Actor
{
    public static SoundPlayer instance;
    
    private GreenfootSound titleScreenMusic = new GreenfootSound("03_Title_Screen.mp3");
    private GreenfootSound wildPokemonBattle = new GreenfootSound("14_Battle_Wild_Pokemon.mp3");

    
    /**
     * When the sound player is crated, it makes arrays for all the sounds that may be played at the same time
     */
    public SoundPlayer()
    {
        instance = this;
        
        //all index starts at 0 and all arrays have 20 copies of the sound
        
    }
    
    /**
     * Sound player does not do anything in its act method
     */
    public void act()
    {
        
    }
    
    
    /**
     * Will play the titleScreenMusic sound in an infinite loop
     */
    public void playTitleScreenMusic()
    {
        titleScreenMusic.playLoop();
    }
    
    public void stopTitleScreenMusic()
    {
        titleScreenMusic.stop();
    }
    
    
    
    public void playWildPokemonBattle()
    {
        wildPokemonBattle.playLoop();
    }
    
    public void stopWildPokemonBattle()
    {
        wildPokemonBattle.stop();
    }
    
    
    
}
