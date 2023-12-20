import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DiverShooter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DiverShooter extends Actor
{
    int speed = 3;
    int time = 0;
    /**
     * Act - do whatever the DiverShooter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public DiverShooter()
    {
        GreenfootImage myImage = getImage();
        int myNewHeight = (int)myImage.getHeight()/12;
        int myNewWidth = (int)myImage.getWidth()/12;
        myImage.scale(myNewHeight,myNewWidth);
        
        getImage().setColor(Color.BLACK);
        getImage().fillRect(30,25,70,10);
    }
    public void act()
    {
        time++;
        turnAround();
        moveAround();
        fireProjectile();
        gameOver();
    }
    public void turnAround()
    {
        if(Greenfoot.getMouseInfo() != null)
            turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
    }
    public void moveAround()
    {
        if(Greenfoot.isKeyDown("W"))
            setLocation(getX(),getY() - speed);
        if(Greenfoot.isKeyDown("A"))
            setLocation(getX()- speed, getY());
        if(Greenfoot.isKeyDown("S"))
            setLocation(getX(),getY() + speed);
        if(Greenfoot.isKeyDown("D"))
            setLocation(getX()+ speed, getY());
    }
    
    public void fireProjectile()
    {
        if(Greenfoot.mousePressed(null)){
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation());
        }
    }
    public void gameOver()
    {
        if(isTouching(Creature.class))
        {
        getWorld().showText("Game Over! - Total time lasted:" + (time/60) + " seconds", getWorld().getWidth()/2, getWorld().getHeight()/2);
        Greenfoot.stop();
        }
    }
}
