import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GunButton extends Actor
{
    Counter counter;
    int gunUpgrade = 1;
    
    //passing the counter class in the parameters so that energy can be sold to upgrade the gun
    public GunButton(Counter counter)
    {
        this.counter = counter; //ensures the counter passing information is already in the world
    }
    public void act()
    {
        if(Greenfoot.mousePressed(this) && counter.energy > 199) // ensures that 200 units of energy is required for each upgrade
        {
            counter.energy -= 200; //ensures that subtraction of occurs: energy = energy - 200
            gunUpgrade++; // the weapon will be upgraded
        }
        /* the if statement ensures that the gun does not upgrade when the gun upgrade is greater than or equal to 3
         * Once the statement proves true gun upgrade will be assigned the value 3 
         * The gun button will then be removed from the world */
        if(gunUpgrade >= 3)
        {
            gunUpgrade = 3;
            getWorld().removeObject(this); 
        }
    }
}
