import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dinosaur here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dinosaur extends Actor
{
    private int speed  = 3;
    private int vSpeed = 3;
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
    
    /*
     * Movement Keys
     */
    public void direction(){
        if(Greenfoot.isKeyDown("a")){
            moveLeft();
        }
        
        else if(Greenfoot.isKeyDown("d")){
            moveRight();
        }
        
        else if(Greenfoot.isKeyDown("w")){
            jump();
            jump();
            fall();
        }
    }
    
    public void moveRight(){
        setLocation(getX() + speed, getY()); 
    }
    
    public void moveLeft(){
        setLocation(getX() - speed, getY()); 
    }
    
    public void jump(){
        setLocation(getX(), getY() - vSpeed);
    }
    
    public void fall(){
        setLocation(getX(), getY() + vSpeed);
    }
    public void act() 
    {
        // Add your action code here.
        direction();
        
        
        
        
        
        collision();
    }    
}
