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
        super(600, 400, 1, false);
        
        Dinosaur dino = new Dinosaur();
        addObject(dino, 250, 300);
        
        createObstacle();
        
        addObject(new Platform(), 100,400);
        addObject(new Platform(), 300,400);
        addObject(new Platform(), 500,400);
    }
    
    public void createObstacle(){
        int x = 500;
        int y = 350;
        addObject(new Obstacle(), x, y);
    }
}
