import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Creature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creature extends Actor
{
    int health = 3; //setting the creatures health
    DiverShooter player;
    Counter counter;
    public Creature (DiverShooter mainPlayer, Counter counter) //provides each creature with the information of the diver
    {  
        this.counter = counter;
        player = mainPlayer; //call on player and set it equal to the mainPayer
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
        turnTowards(player.getX(), player.getY()); //ensures the creatures turn towards the diver by finding the coordinates
    }
    public void hitByProjectile()
    {
        // Creatinga refrence to the projectile that is intersecting the creature???? reserach
        Actor projectile = getOneIntersectingObject(Projectile.class); 
        if(projectile != null) //
        {
            health--;
            getWorld().removeObject(projectile); 
        }
        if (health == 0)
        {
        counter.score++;
        counter.energy+=4;
        getWorld().removeObject(this); //removes the creature from the game
        }
    }
    
}

