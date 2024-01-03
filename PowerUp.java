import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PowerUp extends Actor
{
    final int POWER_UP_LIMIT = 100; // initalised as a constant because the power up limit will never change
    int powerUpCount; // the powerUpCount is intiliased to 0 
    int count; // this count will be responsible for moving the powerUpCount above
    
    public PowerUp()
    {
        // using Greenfoot built in methods to create a transparent box for the power up bar
        setImage(new GreenfootImage(POWER_UP_LIMIT + 2, 12)); 
        // using Greenfoot built in methods to draw a rectangle
        getImage().drawRect(0,0,POWER_UP_LIMIT + 1,11); 
        // setting the power up bar fill colour to magenta
        getImage().setColor(Color.MAGENTA);  
        //the power up bar will fill according to the powerUpCount and will increase over time
        getImage().fillRect(1,1, powerUpCount, 10); 
    }

    public void act()
    {
        //added to act method so the health bar can update as the game updates
        setImage(new GreenfootImage(POWER_UP_LIMIT + 2, 12));
        getImage().drawRect(0,0, POWER_UP_LIMIT + 1,11);
        getImage().setColor(Color.MAGENTA);
        getImage().fillRect(1,1, powerUpCount, 10);
        World world = getWorld();
        LevelTwo myWorld = (LevelTwo)world;
        //constantly sets position of the power up bar above the diver
        setLocation(myWorld.getDiverShooter().getX() + 10, myWorld.getDiverShooter().getY()-80); 
        powerUpReady();
    }
    /* This method is created so that the power up is ready to be used
     * count variable increments by 1
     * An if statement is used to check if the count is divisble by 5
     * Once the condition has proved to be true, the method will be called upon every 5 iterations during the game
     * Then incrementation of the powerUpCount will occur to signify once the power up is ready to be used */
    public void powerUpReady()
    {
        count++; 
        if(count % 5 == 0)
        {
            powerUpCount++;
        }
    }       
}
