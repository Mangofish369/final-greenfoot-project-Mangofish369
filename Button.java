import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** Button Class:
 * A class to create buttons.
 * 
 * @author Vincent Li
 * @version January 21, 2023
 */
public class Button extends Actor
{
    //Template to create any button and its size
    public Button(String picture, int x, int y)
    {    
        setImage(new GreenfootImage (picture));
        GreenfootImage image = getImage();
        image.scale(x,y);
        setImage(new GreenfootImage (image));
    }
}
