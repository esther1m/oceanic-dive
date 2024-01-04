import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Muhammad Fazil) 
 * @version (v1.0)
 */

//this class creates a physical counter which keeps track of score, energy, time
public class Counter extends Actor
{
    int score; 
    int energy;
    int time;
    public Counter()
    {
        //using built in methods on Greenfoot to create and show the image coded below
        setImage(new GreenfootImage("Score: " + score + "\n Energy: " + energy + "\n Time: " + time/60, 40, Color.WHITE, new Color (0,0,0,0))); 
    }

    public void act()
    {
        time++;
        // added so that the counter will update as the game continues
        setImage(new GreenfootImage("Score: " + score + "\n Energy: " + energy + "\n Time: " + time/60, 40, Color.WHITE, new Color (0,0,0,0)));  
        youWin();
    }
    public void youWin()
    {
        if (time/60 == 180)
        {
            getWorld().showText("Final score: " + score + "\n \n Press Z to see what is next... ", getWorld().getWidth()/2 , getWorld().getHeight()/2);
            Greenfoot.delay(100);
        }
        if (Greenfoot.isKeyDown("Z") && time/60 >= 180)
        {
            Greenfoot.setWorld(new YouWinScreen());
        }
    }
}
