import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** Dinosaur Class:
 * Sets all the rules, actions and interactionof the Dinosaour 
 * 
 * @author Vincent Li
 * @version Jan 12, 2023
 */
public class Dinosaur extends Actor
{
    private int hspeed = 5;
    private int speed  = hspeed;
    private int vSpeed = 5; // Verticle speed
    private int acceleration = 1; //Acceleration downward
    private int jumpStrength = -20; // Jump Height
    private int hp = 3;

    public Dinosaur(){
        GreenfootImage image = getImage();
        image.scale(150,150);
        setImage(image);
    }
    
    public int getHp(){
        return hp;
    }
    
    public void addedToWorld(World GameWorld){
        int right_border = GameWorld.getWidth();
    }
    public void collision(){
        if(isTouching(Obstacle.class)){
            hp -= 1;
            removeTouching(Obstacle.class);
            GameWorld world = (GameWorld) getWorld();
            world.createObstacle();
            
        }
    }
    public int getDinoHeight(){
        GreenfootImage image = getImage();
        image.scale(150,150);
        setImage(image);
        return image.getHeight();
    }
    
    public int getWorldWidth(){
        World world = getWorld();
        int worldWidth = world.getWidth();
        return worldWidth;
    }
    /*
     * Movement Keys
     */
    public void direction(){
        if(Greenfoot.isKeyDown("a")){
            if(getX() != 0){
                moveLeft();
            }
        }
        
        if(Greenfoot.isKeyDown("d")){
            if(getX() != getWorldWidth() -5 ){
                moveRight();
            }
        }
        
        if(Greenfoot.isKeyDown("w")){
            if(onGround()){
                jump();
            }
        }
    }
    
    public void moveRight(){
        setLocation(getX() + speed, getY()); 
    }
    
    public void moveLeft(){
        setLocation(getX() - speed, getY()); 
    }
    
    public void jump(){
        vSpeed = jumpStrength;
        fall();
    }
    
    public void fall(){
        setLocation(getX(), getY() + vSpeed);
        vSpeed = vSpeed + acceleration; 
    }
    
    public boolean onGround(){
        Actor under = getOneObjectAtOffset( 0, getDinoHeight() /2, Platform.class);
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
