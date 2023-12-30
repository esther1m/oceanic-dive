import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HealthBar extends Actor
{
    int health = 50;
    public HealthBar()
    {
        setImage(new GreenfootImage(52, 12));
        getImage().drawRect(0,0,51,11);
        getImage().setColor(Color.GREEN);
        getImage().fillRect(1,1,health,10);
        
    }
    
    public void act()
    {
        setImage(new GreenfootImage(52, 12));
        getImage().drawRect(0,0,51,11);
        getImage().setColor(Color.GREEN);
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
            Greenfoot.stop(); //stops the game from continuing
        }
    }
}
