import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** GameWorld Class:
 * This class is where the world is created and all the objects are placed into
 * this world.
 * 
 * @author Vincent Li
 * @version January 21, 2023
 */
public class GameWorld extends World
{
    private int score = 0;
    private double difficulty = 3;
    Label theScore = new Label("Score: " + score, 40);
    Dinosaur dino = new Dinosaur();
    Label hpLabel = new Label ("HP: "+dino.getHp(), 40);
    Button playAgain = new Button("restart_button.png", 75, 75);
    Label gameOver = new Label("Game Over",80);
    int oddAndEven = 0;
    GreenfootSound gameOverSound = new GreenfootSound("gameOver.mp3");
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 1700x400 cells with a cell size of 1x1 pixels.
        super(1700, 400, 1, false);
        
        //Spawn game character
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
        addObject(new Platform(),getWidth(), 400);
        
        //Score label
        addObject(theScore, 100,50);
        
        //HP
        addObject (hpLabel, 400, 50);
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
    
    //Game end function
    public void updateHP(){
        hpLabel.setValue("HP: "+ dino.getHp());
    }
    
    //Increase speed of obstacle per 100 points
    public void increaseSpeed(){
        if(score%100 == 0){
            difficulty+= 1;
        }
    }
    
    public void endGame(){
        
        addObject(gameOver, getWidth()/2, getHeight()/2);
        addObject(playAgain, getWidth()/2,(getHeight()/2) +100);
        if(Greenfoot.mouseClicked(playAgain)){
            Greenfoot.setWorld(new GameWorld());
        }
        //Greenfoot.stop();
    }
    public void act(){
        
        
        if(dino.getHp() <= 0){
            gameOverSound.play();
            endGame();
        }
        
        else if(dino.getHp() > 0){
            updateScore();
        }
        increaseSpeed();
        updateHP();
    }
}
