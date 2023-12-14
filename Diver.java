import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Diver extends Actor
{
    /**
     * Act - do whatever the Diver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("Right"))
        {
            setRotation(0);
            move(1);
        }
        if(Greenfoot.isKeyDown("Down"))
        {
            setRotation(90);
            move(1);
        }
        if(Greenfoot.isKeyDown("Left"))
        {
            setRotation(180);
            move(1);
        }
        if(Greenfoot.isKeyDown("Up"))
        {
            setRotation(270);
            move(1);
        }
    }
}
