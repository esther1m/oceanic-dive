import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Creature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creature extends Actor
{
    int health = 3;
    DiverShooter player;
    Counter counter;
    public Creature (DiverShooter mainPlayer, Counter counter)
    {  
        this.counter = counter;
        player = mainPlayer;
        GreenfootImage myImage = getImage();
        int myNewHeight = (int)myImage.getHeight()/10;
        int myNewWidth = (int)myImage.getWidth()/10;
        myImage.scale(myNewHeight,myNewWidth);
    }  
    /**
     * Act - do whatever the Creature wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       moveAround(); 
       hitByProjectile();
    }
    
    public void moveAround()
    {
        move(1);
        turnTowards(player.getX(), player.getY());
    }
    public void hitByProjectile()
    {
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if(projectile != null)
        {
            health--;
            getWorld().removeObject(projectile);
        }
        if (health == 0)
        {
        counter.score++;
        counter.energy+=4;
        getWorld().removeObject(this);
        }
    }
    
}

