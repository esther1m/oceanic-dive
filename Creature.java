import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Muhammad Fazil) 
 * @version (v1.0)
 */

public class Creature extends Actor
{
    int health = 3; //initalizing and setting the creatures health
    
    DiverShooter player;
    Counter counter; 
    
    public Creature (DiverShooter mainPlayer, Counter counter) //provides each creature with the information of the diver and the counter
    {  
        this.counter = counter; // allows the creature to see the counter 
        player = mainPlayer; //calls on player and set it equal to the mainPlayer
    }  
    
    public void act()
    {
        moveAround(); 
        hitByBullet();
    }
    
    public void moveAround()
    {
        move(1);
        //ensure the creatures chase the diver by turning towards it's coordinates
        turnTowards(player.getX(), player.getY()); 
    }
    
    public void hitByBullet()
    {
        // Creating a reference to the bullet that is intersecting the creature
        Actor bullet = getOneIntersectingObject(Bullet.class); 
        // if the bullet intersects the creature the if statment will be executed 
        if(bullet != null) 
        {
            health--; // the creatures health decreases by 1 each time it comes into contact with
            getWorld().removeObject(bullet); // bullet will be removed
        }
        // if the creatures health is equal to 0 to code will run
        if (health == 0)
        {
            counter.score++; //the counter score increases by 1 each time a creature is killed
            counter.energy+=4; //the counter increases by 4 units of energy for each creature that is killed
            getWorld().removeObject(this); //when the creatures health is equal to 0, it will be removed from the world
        }
    }
    
}

