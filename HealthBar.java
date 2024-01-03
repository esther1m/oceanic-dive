import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HealthBar extends Actor
{
    int health = 50;
    public HealthBar()
    {
        setImage(new GreenfootImage(52, 12)); // using Greenfoot built in methods to create a transparent box 
        getImage().drawRect(0,0,51,11); // using Greenfoot built in methods to draw a rectangle
        //setting the health bar colour to green if the health is greater than or equal to 25 and if else the health bar will be red 
        if (health >= 25){
          getImage().setColor(Color.GREEN); 
        } else { getImage().setColor(Color.RED);} 
        getImage().fillRect(1,1,health,10);
    }
    public void act()
    {
        setImage(new GreenfootImage(52, 12)); 
        getImage().drawRect(0,0,51,11);
        if (health >= 25)
        {
          getImage().setColor(Color.GREEN);  
        } else { getImage().setColor(Color.RED);} //added to act method so the health bar can update as the game updates
        getImage().fillRect(1,1,health,10);
        World world = getWorld();
        LevelTwo myWorld = (LevelTwo)world;
        setLocation(myWorld.getDiverShooter().getX() - 5, myWorld.getDiverShooter().getY() - 50); //constantly sets position of the health bar above the diver 
        loseHealth();
    }
    public void loseHealth()
    {
        //allows us to access the World class and MyWorld subclass
        World world = getWorld(); 
        LevelTwo myWorld = (LevelTwo)world;
        //if the diver is hit by the creature then health will be lost
        if (myWorld.getDiverShooter().hitByCreature())
        {
            health--;
        }
        // the game will end if diver health is less than or equal to 0 and text will appear on the screen
        if(health <= 0)
        {
            getWorld().showText("Game Over! \n You survived for " + (myWorld.getDiverShooter().time/60) + " seconds", getWorld().getWidth()/2 , getWorld().getHeight()/2);
            Greenfoot.stop(); //stops the game from continuing
        }
    }
}
