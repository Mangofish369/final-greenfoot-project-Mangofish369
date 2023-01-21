import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** Platform Class:
 * Create platforms for dinosaur to stand on.
 * 
 * 
 * @author Vincent Li
 * @version January 21, 2023
 */
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
