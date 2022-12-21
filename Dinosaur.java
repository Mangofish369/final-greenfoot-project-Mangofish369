
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dinosaur here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dinosaur extends Actor
{
    private int speed  = 5;
    private int vSpeed = 5;
    private int acceleration = 1;
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
    public int getHeight(){
        GreenfootImage image = getImage();
        image.scale(150,150);
        setImage(image);
        return image.getHeight();
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
        }
    }
    
    public void moveRight(){
        setLocation(getX() + speed, getY()); 
    }
    
    public void moveLeft(){
        setLocation(getX() - speed, getY()); 
    }
    
    public void jump(){
        vSpeed = - 10;
        fall();
    }
    
    public void fall(){
        setLocation(getX(), getY() + vSpeed);
        vSpeed = vSpeed + acceleration; 
    }
    
    public boolean onGround(){
        Actor under = getOneObjectAtOffset( 0, getHeight() /2, Platform.class);
        return under != null;
    }
    
    public void checkFall(){
        if(onGround()){
            vSpeed = 0;
        }
        else{
            fall();
        }
    }
    public void act() 
    {
        // Add your action code here.
        direction();
        checkFall();
        collision();
    }    
}
