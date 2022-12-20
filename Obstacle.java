import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle extends Actor
{
    /**
     * Act - do whatever the Obstacle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public void act() 
    {
        // Add your action code here.
        destroy();
        move(-1);
        
    }
    public void destroy(){
        if (Greenfoot.mouseClicked(this)){
            getWorld().removeObject(this);
            GameWorld world = (GameWorld) getWorld();
            world.createObstacle();
        }
    }
}
