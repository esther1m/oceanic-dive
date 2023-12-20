import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class seaweed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Seaweed extends Actor
{
    /**
     * Act - do whatever the seaweed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int direction = -1;
    boolean checker = false;
    //MyWorld world = new MyWorld();
    public void act()
    {
        

        //move(1);
        //turn(5)
        
        movement();
        collisionChecker();


        // Add your action code here.
    }

    public void movement() {
        turn(3 * direction);
        if (getRotation() >= 45 || getRotation() <= -45) {
            direction *= -1;
            //turn(3 * direction);
        } else if (getRotation() == 0 || getRotation() < -45) {
            direction *= -1;
        }  
    }

    public void collisionChecker() {
        if (isTouching(getClass()) == true){
            int randomX2 = Greenfoot.getRandomNumber(getWorld().getWidth());
            int randomY2 = (Greenfoot.getRandomNumber(99) + 500);
            setLocation(randomX2, randomY2);
        }
        if (checker == false){
            if (getOneIntersectingObject(Diver.class) != null) {
                int randomX2 = Greenfoot.getRandomNumber(getWorld().getWidth());
                int randomY2 = (Greenfoot.getRandomNumber(99) + 500);
                setLocation(randomX2, randomY2);
            }
            checker = true;
        }

    }
}
