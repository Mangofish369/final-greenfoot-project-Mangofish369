import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TitleScreen extends World
{
    Label title = new Label("Jumping Dinosaur" , 60);
    Button play = new Button("start_button.png", 200, 150);
    
    public TitleScreen()
    {
        super(600,400,1);
        addObject(title, 300, 150);
        addObject(play, 300, 300);
    }
    
    
    public void act(){
        // Generate world when button pressed
        if(Greenfoot.mouseClicked(play)){
            GameWorld game = new GameWorld();
            Greenfoot.setWorld(game);
        }
    }
}
