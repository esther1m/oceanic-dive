import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GunButton extends Actor
{
    Counter counter;
    int gunUpgrade = 1;
    public GunButton(Counter counter)
    {
        this.counter = counter;
    }
    public void act()
    {
        if(Greenfoot.mousePressed(this) && counter.energy > 199) // go back and change - only for testing purposes
        {
            counter.energy -= 200; 
            gunUpgrade++;
        }
        if(gunUpgrade >= 3)
        {
            gunUpgrade = 3;
            getWorld().removeObject(this);
        }
    }
}
