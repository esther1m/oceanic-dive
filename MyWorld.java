import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    int count = 0;
    // The spawn speed is faster when spawn speed value is lowered
    int spawnSpeed = 60;
    int randomSpawn;
    
    public DiverShooter mainPlayer = new DiverShooter(); //making mainPlayer an instance of the new diver so a paramter can be passed
    Counter counter = new Counter(); //creating an instance of Counter as it needs to be accessed outside of MyWorld so it will be initilaized outisde of the world
    HealthBar healthBar = new HealthBar();
    GunButton gunButton = new GunButton(counter);
    PowerUp powerUp = new PowerUp(); // creating an instance of power up so it can be accessed within Level 2
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        mainPlayer = new DiverShooter(gunButton, powerUp);
        addObject(mainPlayer, getWidth()/2, getHeight()/2);
        addObject(counter, 120, 100); //sets position of counter stats
        addObject(healthBar, mainPlayer.getX() - 5, mainPlayer.getY() - 50); // adds the health bar above the diver 
        addObject(gunButton, 900, 100); //
        addObject(powerUp, mainPlayer.getX() + 10, mainPlayer.getY() - 80); // adds the power up bar above the diver and health bar 
    }
    
    //using a return to be able to access the mainPlayer information from World in other classes like the HealthBar and Counter classes
    public DiverShooter getDiverShooter()
    {
        return mainPlayer;
    }

    public void act()
    {
        count++; // making sure count is not always 0 so creatures can spawn continuously
        //the conditional if statement ensures that the spawn speed of creatures gets faster every 10 seconds by decreasing the spawn speed value by 1 e
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
            randomSpawn = Greenfoot.getRandomNumber(8); // setting creatures to spawn to another random spawn location using the random number generated 
            switch(randomSpawn) //using a switch statement to ensure there are 8 spawn loactions 
            {
                //passing the mainPlayer so that each creature can recieve the information of the diver
                //So the creatures can see the counter
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

