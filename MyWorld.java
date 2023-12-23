import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    int count = 0;
    // The Spawn speed is faster when spawnSpeed value is lowered
    int spawnSpeed = 50;
    int randomSpawn;
    public DiverShooter mainPlayer = new DiverShooter();
    Counter counter = new Counter();
    HealthBar healthBar = new HealthBar();
    GunButton gunButton = new GunButton(counter);
    PowerUp powerUp = new PowerUp();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        mainPlayer = new DiverShooter(gunButton, powerUp);
        addObject(mainPlayer, getWidth()/2, getHeight()/2);
        addObject(counter, 130, 100);
        addObject(healthBar, mainPlayer.getX() - 5, mainPlayer.getY() - 50);
        addObject(gunButton, 900, 100);
        addObject(powerUp, mainPlayer.getX() + 10, mainPlayer.getY()-80);
    }
    
    public DiverShooter getDiverShooter()
    {
        return mainPlayer;
    }

    public void act()
    {
        count++;
        while(Greenfoot.isKeyDown("P")){
            Greenfoot.delay(1);
        }
        spawnCreatures();
    }
    public void spawnCreatures()
    {
        if (count % spawnSpeed == 0)
        {
        randomSpawn = Greenfoot.getRandomNumber(8);
        switch(randomSpawn){
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

