import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** Dinosaur Class:
 * Sets all the rules, actions and interactionof the Dinosaour 
 * 
 * @author Vincent Li
 * @version Jan 12, 2023
 */
public class Dinosaur extends Actor
{
    private int hspeed = 6;
    private int speed  = hspeed;
    private int vSpeed = 5; // Verticle speed
    private int acceleration = 1; //Acceleration downward
    private int jumpStrength = -20; // Jump Height
    private int hp = 100;

    //Animation 
    GreenfootImage[] running = new GreenfootImage[8];
    GreenfootImage[] jumping = new GreenfootImage[13];
    GreenfootImage[] dead = new GreenfootImage[8];
    
    int imageHeight = 150;
    int imageWidth = 150;
    
    SimpleTimer animationTimer = new SimpleTimer();
    public Dinosaur(){
        GreenfootImage image = getImage();
        image.scale(imageHeight,imageWidth);
        setImage(image);
        
        for(int i = 0; i<running.length; i++){
            running[i] = new GreenfootImage("images/dinosaur_sprite/png/Run ("+(i+1)+").png");
            running[i].scale(imageHeight,imageWidth);
        }
        
        for(int i = 0; i< jumping.length; i++){
            jumping[i] = new GreenfootImage("images/dinosaur_sprite/png/Jump ("+(i+1)+").png");
            jumping[i].scale(imageHeight,imageWidth);
        }
        
        for(int i = 0; i<dead.length; i++){
            dead[i] = new GreenfootImage("images/dinosaur_sprite/png/Dead (" +(i+1)+").png");
            dead[i].scale(imageHeight, imageWidth);
        }
        
        setImage(running[0]);
        animationTimer.mark();
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
            if(getX() >= 5){
                moveLeft();
            }
        }
        
        if(Greenfoot.isKeyDown("d")){
            if(getX() <= getWorldWidth() -25 ){
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
    int imageIndexRun = 0;
    public void animateDinosaurRun(){
        if(animationTimer.millisElapsed() < 100){
            return;
        }
        animationTimer.mark();

        setImage(running[imageIndexRun]);
        imageIndexRun = (imageIndexRun+1) % running.length;   
    }
    int imageIndexJump = 0;
    public void animateDinosaurJump(){
        
        if(animationTimer.millisElapsed() < 45){
            return;
        }
        animationTimer.mark();
        
        setImage(jumping[imageIndexJump]);
        imageIndexJump = (imageIndexJump+1) % jumping.length;
    }
    int imageIndexDead = 0;
    public void animateDinosaurDead(){
        if(animationTimer.millisElapsed() < 100){
            return;
        }
        animationTimer.mark();
        
        setImage(dead[imageIndexDead]);
        imageIndexDead = (imageIndexDead+1) % dead.length;
    }
    public void act() 
    {
        // Add your action code here.
        direction();
        checkFall();
        collision();
        if(!onGround()){
            animateDinosaurJump();
        }    
        else{
            animateDinosaurRun();
        }
    }    
}
