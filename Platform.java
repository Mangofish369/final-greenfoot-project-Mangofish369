import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Platform extends Actor
{
    public Platform(){
        GreenfootImage dirt = getImage();
        dirt.scale(200,55);
        setImage(dirt);
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
