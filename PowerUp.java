import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerUp extends Actor
{
    final int POWER_UP_LIMIT = 100;
    int powerUpCount;
    int count;
    /**
     * Act - do whatever the PowerUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public PowerUp()
    {
        setImage(new GreenfootImage(POWER_UP_LIMIT + 2, 12));
        getImage().drawRect(0,0,POWER_UP_LIMIT + 1,11);
        getImage().setColor(Color.BLUE);
        getImage().fillRect(1,1, powerUpCount, 10);
    }

    public void act()
    {
        setImage(new GreenfootImage(POWER_UP_LIMIT + 2, 12));
        getImage().drawRect(0,0, POWER_UP_LIMIT + 1,11);
        getImage().setColor(Color.BLUE);
        getImage().fillRect(1,1, powerUpCount, 10);
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        setLocation(myWorld.getDiverShooter().getX() + 10, myWorld.getDiverShooter().getY()-80);
        usePowerUp();// Add your action code here.
    }
    public void usePowerUp()
    {
        count++;
        if(count % 5 == 0)
        {
            powerUpCount++;
        }
    }       
}
