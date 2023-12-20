import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class seaweed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class seaweed extends Actor
{
    /**
     * Act - do whatever the seaweed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int direction = -1;
    public void act()
    {

        //move(1);
        //turn(5);


        turn(3 * direction);
        if (getRotation() >= 45 || getRotation() <= -45) {
            direction *= -1;
            //turn(3 * direction);
        } else if (getRotation() == 0 || getRotation() < -45) {
            direction *= -1;
        }
        
   

        

        // Add your action code here.
    }
}
