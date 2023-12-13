import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class shipwreckWood here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class shipwreckWood extends Actor
{
    /**
     * Act - do whatever the shipwreckWood wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkCollision();
        move(1);
        setRotation(90);
        checkEdge();
        
       // int startTime = Greenfoot.getRandomNumber(61);
      //  Greenfoot.delay (startTime);
        // Add your action code here.
    }

    private void checkEdge(){
        if (isAtEdge()){
            int randX = Greenfoot.getRandomNumber(getWorld().getWidth());
            setLocation(randX, 4);
        }
    }

    private void checkCollision(){
        if (isTouching(getClass()) == true){
            int randX2 = Greenfoot.getRandomNumber(getWorld().getWidth());
            setLocation(randX2, 4);
        }
    }

    private void checkEdge(){
        if (isAtEdge()){
            int randX = Greenfoot.getRandomNumber(getWorld().getWidth());
            setLocation(randX, 4);
        }
    }

    private void checkCollision(){
        if (isTouching(getClass()) == true){
            int randX2 = Greenfoot.getRandomNumber(getWorld().getWidth());
            setLocation(randX2, 4);
        }
    }
}
