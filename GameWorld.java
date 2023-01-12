import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author Vincent 
 * @version Dec 16, 2022
 */
public class GameWorld extends World
{
    private int score = 0;
    private float difficulty = 1;
    Label theScore = new Label("Score: " + score, 40);
    int oddAndEven = 0;
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 1700x400 cells with a cell size of 1x1 pixels.
        super(1700, 400, 1, false);
        
        //Spawn game character
        Dinosaur dino = new Dinosaur();
        addObject(dino, 250, 300);
        
        //Spawn first obstacle
        createObstacle();
        
        /* Sets oddAndEven value based on the world width being odd or even
          in the hundreds
        */
        if(getWidth()/100%2 == 0){
            oddAndEven = 1;
        }
        else{
            oddAndEven = 0;
        }
        
        // Uses oddAndEven value to properly spawn platforms and obstacles 
        for (int i = oddAndEven; i < (getWidth()/100); i+=2){
            addObject(new Platform(),i*100, 400);
        }
        
        //Score label
        addObject(theScore, 100,50);
    }
    
    public void createObstacle(){
        int x = getWidth();
        int y = 350;
        addObject(new Obstacle(difficulty), x, y);
    }
    
    public void updateScore(){
        score++;
        theScore.setValue("Score: " + score);
    }
    
    //Increase speed of obstacle per 100 points
    public void increaseSpeed(){
        if(score%100 == 0){
            difficulty+= 1;
        }
    }
    public void act(){
        updateScore();
        increaseSpeed();
    }
}
