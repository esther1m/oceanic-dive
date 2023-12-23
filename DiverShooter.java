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
    GunButton gunButton;
    PowerUp powerUp;
    int powerUpTimer;
    /**
     * Act - do whatever the DiverShooter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public DiverShooter()
    {
        GreenfootImage myImage = getImage();
        int myNewHeight = (int)myImage.getHeight()/10;
        int myNewWidth = (int)myImage.getWidth()/10;
        myImage.scale(myNewHeight,myNewWidth);
        
        getImage().setColor(Color.BLACK);
        getImage().fillRect(30,25,70,10);
    }
    public DiverShooter(GunButton gunButton, PowerUp powerUp)
    {
        this.powerUp = powerUp;
        this.gunButton = gunButton;
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
        powerUpUsed();
        hitByCreature();
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
        if(Greenfoot.mousePressed(null) && gunButton.gunUpgrade == 1){
            Projectile projectile = new Projectile(0);
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation());
            projectile.move(25);
        }
        if(Greenfoot.mousePressed(null) && gunButton.gunUpgrade == 2){
            Projectile projectile = new Projectile(0);
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 5);
            projectile.move(20);
            Projectile projectile2 = new Projectile(0);
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation() + 5);
            projectile2.move(20);
        }
        if(Greenfoot.mousePressed(null) && gunButton.gunUpgrade == 3){
            Projectile projectile = new Projectile(0);
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 5);
            projectile.move(20);
            Projectile projectile2 = new Projectile(0);
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation() + 5);
            projectile2.move(20);
            Projectile projectile3 = new Projectile(0);
            getWorld().addObject(projectile3, getX(), getY());
            projectile3.setRotation(getRotation());
            projectile3.move(20);
        }
    }
    public void powerUpUsed()
    {
        if(powerUp.powerUpCount > 99 && powerUpTimer < 30 && Greenfoot.isKeyDown("SPACE"))
        {
            Projectile projectile = new Projectile(0);
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 60);
            projectile.move(20);
            Projectile projectile2 = new Projectile(0);
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation() + 60);
            projectile2.move(20);
            Projectile projectile3 = new Projectile(0);
            getWorld().addObject(projectile3, getX(), getY());
            projectile3.setRotation(getRotation());
            projectile3.move(20);
            Projectile projectile4 = new Projectile(0);
            getWorld().addObject(projectile4, getX(), getY());
            projectile4.setRotation(getRotation() - 180);
            projectile4.move(20);
            Projectile projectile5 = new Projectile(0);
            getWorld().addObject(projectile5, getX(), getY());
            projectile5.setRotation(getRotation() + 120);
            projectile5.move(20);
            Projectile projectile6 = new Projectile(0);
            getWorld().addObject(projectile6, getX(), getY());
            projectile6.setRotation(getRotation() - 120);
            projectile6.move(20);
            
            powerUpTimer++;
        }
        if(powerUpTimer > 29)
        {
            powerUp.powerUpCount = 0;
            powerUpTimer = 0;
        }
    }
    public boolean hitByCreature()
    {
        Actor creature = getOneObjectAtOffset(0,0,Creature.class);
        if(creature != null)
        {
            return true;
        }
        else
        return false;
    }
}
