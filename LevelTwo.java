import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Muhammad Fazil) 
 * @version (v1.0)
 */

public class LevelTwo extends World
{
    int count = 0;
    // The spawn speed is faster when spawn speed value is lowered
    int spawnSpeed = 55;
    int randomSpawn;
    
    //making mainPlayer an instance of the new diver so a paramter can be passed
    public DiverShooter mainPlayer = new DiverShooter(); 
    //creating an instance of Counter
    Counter counter = new Counter();  
    HealthBar healthBar = new HealthBar();
    GunButton gunButton = new GunButton(counter);
    // creating an instance of power up so it can be accessed within Level Two
    PowerUp powerUp = new PowerUp(); 
    
    public LevelTwo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        mainPlayer = new DiverShooter(gunButton, powerUp);
        addObject(mainPlayer, getWidth()/2, getHeight()/2);
        //sets position of the visual counter on the game
        addObject(counter, 120, 100); 
        // adds the health bar above the diver 
        addObject(healthBar, mainPlayer.getX() - 5, mainPlayer.getY() - 50);
        // adds the gun upgrade button on the game screen
        addObject(gunButton, 900, 100); 
        // adds the power up bar above the diver and health bar 
        addObject(powerUp, mainPlayer.getX() + 10, mainPlayer.getY() - 80); 
    }
    
    //using return to be able to access the mainPlayer information from World in other classes like the HealthBar and Counter classes
    public DiverShooter getDiverShooter()
    {
        return mainPlayer;
    }

    public void act()
    {
        // incrementing count so creatures can spawn continuously
        count++; 
        //the conditional if statement ensures that the spawn speed of creatures gets faster every 10 seconds by decreasing the spawn speed value by 1
        if (count % 600 == 0)
        {
            spawnSpeed--;
        }
        // the while loop ensures that if P is down the game will be delayed and paused 
        while(Greenfoot.isKeyDown("P"))
        {
            Greenfoot.delay(1);
        }
        spawnCreatures(); 
    }
    public void spawnCreatures()
    {
        if (count % spawnSpeed == 0)
        {
            // setting creatures to spawn to another random spawn location using the random number generated
            randomSpawn = Greenfoot.getRandomNumber(8);  
            /* using a switch statement to ensure there are 8 spawn loactions 
             * passing the mainPlayer so that each creature can recieve the information of the diver
             * passing the counter so it is visible to the creatures */
            switch(randomSpawn) 
            {
                case 0: addObject(new Creature(mainPlayer,counter), 0, 0);break; 
                case 1: addObject(new Creature(mainPlayer,counter), getWidth()/2,0); break;
                case 2: addObject(new Creature(mainPlayer,counter), getWidth(), 0); break;
                case 3: addObject(new Creature(mainPlayer,counter), 0, getHeight()/2);break;
                case 4: addObject(new Creature(mainPlayer,counter), getWidth(),getHeight()/2); break;
                case 5: addObject(new Creature(mainPlayer,counter), 0, getHeight()); break;
                case 6: addObject(new Creature(mainPlayer,counter), getWidth()/2, getHeight()); break;
                case 7: addObject(new Creature(mainPlayer,counter), getWidth(), getHeight()); break;
            }
        }
    }
}

