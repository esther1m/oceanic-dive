import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int health = 50;
    public HealthBar()
    {
        setImage(new GreenfootImage(52, 12));
        getImage().drawRect(0,0,51,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health,10);
        
    }
    public void act()
    {
        setImage(new GreenfootImage(52, 12));
        getImage().drawRect(0,0,51,11);
        getImage().setColor(Color.RED);
        getImage().fillRect(1,1,health,10);
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        setLocation(myWorld.getDiverShooter().getX() - 5, myWorld.getDiverShooter().getY() - 50);
        loseHealth();
    }
    public void loseHealth()
    {
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        if (myWorld.getDiverShooter().hitByCreature())
        {
            health--;
        }
        if(health<=0)
        {
            getWorld().showText("Game Over! \n You survived for " + (myWorld.getDiverShooter().time/60) + " seconds", getWorld().getWidth()/2 , getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
}
