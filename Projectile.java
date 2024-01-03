import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Muhammad Fazil) 
 * @version (v1.0)
 */

public class Projectile extends Actor
{
    public void act()
    {
        move(10); 
        //if statement make the projectiles disappear when they touch the edge of the screen so they do not pile up 
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
}
