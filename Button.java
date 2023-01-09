import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Button extends Actor
{

    public Button(String picture, int x, int y)
    {    
        setImage(new GreenfootImage (picture));
        GreenfootImage image = getImage();
        image.scale(x,y);
        setImage(new GreenfootImage (image));
    }
}
