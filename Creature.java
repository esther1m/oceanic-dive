import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Creature extends Actor
{
    int health = 3; //setting the creatures health
    DiverShooter player;
    Counter counter; 
    public Creature (DiverShooter mainPlayer, Counter counter) //provides each creature with the information of the diver and the counter
    {  
        this.counter = counter; // allows the creature to see the counter 
        player = mainPlayer; //call on player and set it equal to the mainPlayer
    }  
    
    public void act()
    {
        moveAround(); 
        hitByProjectile();
    }
    
    public void moveAround()
    {
        move(1);
        turnTowards(player.getX(), player.getY()); //ensures the creatures chases the diver by turning towards the coordinates
    }
    public void hitByProjectile()
    {
        // Creating a refrence to the projectile that is intersecting the creature???? reserach
        Actor projectile = getOneIntersectingObject(Projectile.class); 
        if(projectile != null) //
        {
            health--;
            getWorld().removeObject(projectile); 
        }
        if (health == 0)
        {
            counter.score++; //the counter score increases by 1 each time a creature is killed
            counter.energy+=4; //the counter increases by 4 units of energy for each creature that is killed
            getWorld().removeObject(this); //when the creatures health is equal to 0, it will be removed from the world
        }
    }
    
}

