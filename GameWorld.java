import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author Vincent 
 * @version Dec 16, 2022
 */
public class GameWorld extends World
{

    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        Dinosaur dino = new Dinosaur();
        addObject(dino, 250, 300);
        
        
        createObstacle();
    }
    
    public void createObstacle(){
        int x = 500;
        int y = 340;
        addObject(new Obstacle(), x, y);
    }
}
