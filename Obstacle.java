import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle extends Actor
{
    public float speed;
    
    public Obstacle(float speed){
        this.speed = speed;
    }
        
    public void act() 
    {
        setLocation (getX() - (int)speed, getY());  
        if (Greenfoot.mouseClicked(this) || getX() <= 0){
            GameWorld world = (GameWorld) getWorld();
            world.createObstacle();
            getWorld().removeObject(this);
        }
        
    }

}
