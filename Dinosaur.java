import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dinosaur here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dinosaur extends Actor
{
    /**
     * Act - do whatever the Dinosaur wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Dinosaur(){
        GreenfootImage image = getImage();
        image.scale(150,150);
        setImage(image);
    }
    public void collision(){
        if(isTouching(Obstacle.class)){
            removeTouching(Obstacle.class);
            GameWorld world = (GameWorld) getWorld();
            world.createObstacle();
        }
    }
    
    
    public void act() 
    {
        // Add your action code here.
        
        /*
         * Movement Keys
         */
        if(Greenfoot.isKeyDown("a")){
            move (-1);
        }
        
        else if(Greenfoot.isKeyDown("d")){
            move(1);
        }
        
        collision();
    }    
}
