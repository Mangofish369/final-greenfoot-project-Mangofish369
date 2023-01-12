import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** Obstacle Class:
 *  Controls the behaviour of the obstacle when it interacts with other things.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle extends Actor
{
    public float speed;
    
    // Obstacle speed is changed in GameWorld through parameter
    public Obstacle(float speed){
        this.speed = speed;
    }
        
    public void act() 
    {
        setLocation (getX() - (int)speed, getY());
        //When clicked or at edge of the world, delete and spawn a new one
        if (Greenfoot.mouseClicked(this) || getX() <= 0){
            GameWorld world = (GameWorld) getWorld();
            world.createObstacle();
            getWorld().removeObject(this);
        }
        
    }

}
