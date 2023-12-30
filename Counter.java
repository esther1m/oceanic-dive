import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Counter extends Actor
{
    int score;
    int energy;
    int time;
    public Counter()
    {
        setImage(new GreenfootImage("Score: " + score + "\n Energy: " + energy + "\n Time: " + time/60, 40, Color.WHITE, new Color (0,0,0,0)));
    }

    public void act()
    {
        time++;
        setImage(new GreenfootImage("Score: " + score + "\n Energy: " + energy + "\n Time: " + time/60, 40, Color.WHITE, new Color (0,0,0,0)));
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
