import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GunButton extends Actor
{
    /**
     * Act - do whatever the Gun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Counter counter;
    int gunUpgrade = 1;
    public GunButton(Counter counter)
    {
        this.counter = counter;
        setImage(new GreenfootImage("Gun \n Upgrade", 25, Color.WHITE, new Color(0,0,0,0)));
        
    }
    public void act()
    {
        if(Greenfoot.mousePressed(this) && counter.energy > 79) // go back and change - only for testing purposes
        {
            counter.energy -= 80;
            gunUpgrade++;
        }
        if(gunUpgrade > 3)
        gunUpgrade = 3;
    }
}
