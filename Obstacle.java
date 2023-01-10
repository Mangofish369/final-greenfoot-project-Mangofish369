import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle extends Actor
{
    public static int speed = 5;
    public void act() 
    {
        if (Greenfoot.mouseClicked(this) || getX() == 0){
            GameWorld world = (GameWorld) getWorld();
            world.createObstacle();
            getWorld().removeObject(this);
        } else {
            setLocation (getX() - speed, getY());    
        }
        
        
    }

}
