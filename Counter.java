import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    int score;
    int energy;
    int time;
    public Counter()
    {
        setImage(new GreenfootImage("Score: " + score + "\n Energy: " + energy + "\n Time: " + time/60, 40, Color.WHITE, new Color (0,0,0,0)));
    }
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        time++;
        setImage(new GreenfootImage("Score: " + score + "\n Energy: " + energy + "\n Time: " + time/60, 40, Color.WHITE, new Color (0,0,0,0)));
    }
}
