import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

//physical counter which keeps track of score, energy, time
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
        setImage(new GreenfootImage("Score: " + score + "\n Energy: " + energy + "\n Time: " + time/60, 40, Color.WHITE, new Color (0,0,0,0))); // added so that the counter will update as the game continues 
        youWin();
    }
    public void youWin()
    {
        if (time/60 == 180)
        {
            getWorld().showText("You win! \n Final score: " + score, getWorld().getWidth()/2 , getWorld().getHeight()/2);
            Greenfoot.stop();   
        }
    }
}
