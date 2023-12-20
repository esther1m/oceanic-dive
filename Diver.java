import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Diver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Diver extends Actor
{
    public Diver()  
    {  
        GreenfootImage myImage = getImage();
        int myNewHeight = (int)myImage.getHeight()/10;
        int myNewWidth = (int)myImage.getWidth()/10;
        myImage.scale(myNewHeight,myNewWidth);
    }  
    
    /**
     * Act - do whatever the Diver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("D"))
        {
            setRotation(0);
            move(1);
        }
        if(Greenfoot.isKeyDown("S"))
        {
            setRotation(90);
            move(1);
        }
        if(Greenfoot.isKeyDown("A"))
        {
            setRotation(180);
            move(1);
        }
        if(Greenfoot.isKeyDown("W"))
        {
            setRotation(270);
            move(1);
        }
    }
}
