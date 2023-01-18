import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Actor
{
    Button playAgain = new Button("start_button.png", 200, 150);
    public GameOver()
    {    
        setImage(new GreenfootImage("GAMEOVER", 80, Color.WHITE, new Color(0,0,0,50)));
    }
}
