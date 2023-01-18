import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayAgain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayAgain extends Actor
{
    Button playAgain; 
    public PlayAgain()
    {    
        if(Greenfoot.mouseClicked(playAgain)){
            Greenfoot.setWorld(new GameWorld());
        }
    }
}
