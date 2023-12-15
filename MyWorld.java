import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    //initialising the amount of shipwrecks to be repeated and the amount of seaweed to be in the game
    private static final int NUMBER_OF_SHIPWRECK = 7;
    Diver diver = new Diver();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        
        
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        populate();
    }
        
    public void populate(){

        addObject(diver, 500 ,556);

        for (int i = 0; i < NUMBER_OF_SHIPWRECK; i++){
            int x = Greenfoot.getRandomNumber(getWidth());
            addObject(new shipwreckWood(), x, 4);
        }

        for (int count = 0; count < NUMBER_OF_SEAWEED; count++){
            int randomX = Greenfoot.getRandomNumber(getWidth());
            int randomY = (Greenfoot.getRandomNumber(99) + 500);
            addObject(new seaweed(), randomX, randomY);
        }

    }
}

