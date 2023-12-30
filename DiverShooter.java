import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DiverShooter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DiverShooter extends Actor
{
    int speed = 3; // setting the divers speed ??research 
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
        getImage().setColor(Color.BLACK); //creating a black gun using the get image method
        getImage().fillRect(30,25,70,10); // drawing the rectangle for the gun with appropiate coordinates
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
        turnAround(); //calling the turnAroun method
        moveAround(); ////calling the moveAround method
        fireProjectile();
        powerUpUsed();
        hitByCreature();
    }
    public void turnAround()
    {
        if(Greenfoot.getMouseInfo() != null) // if the mouse is off the screen the diver will not follow the mouse
        {
            turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY()); ////allows the diver to turn towards the mouse 
        }
    }
    //allows diver to move around the screen using set location and variations of speed
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
        if(Greenfoot.mousePressed(null) && gunButton.gunUpgrade == 1)
        {
            Projectile projectile = new Projectile(); // ensures a new projectile can be fired each time the mouse is pressed
            getWorld().addObject(projectile, getX(), getY()); 
            projectile.setRotation(getRotation()); // enables the refrenced projectile to have the same rotation as the diver's rotation
            projectile.move(25); // allows the projectiles to move
        }
        if(Greenfoot.mousePressed(null) && gunButton.gunUpgrade == 2){
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 5);
            projectile.move(20);
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation() + 5);
            projectile2.move(20);
        }
        if(Greenfoot.mousePressed(null) && gunButton.gunUpgrade == 3){
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 5);
            projectile.move(20);
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation() + 5);
            projectile2.move(20);
            Projectile projectile3 = new Projectile();
            getWorld().addObject(projectile3, getX(), getY());
            projectile3.setRotation(getRotation());
            projectile3.move(20);
        }
    }
    public void powerUpUsed()
    {
        if(powerUp.powerUpCount > 99 && powerUpTimer < 30 && Greenfoot.isKeyDown("SPACE"))
        {
            Projectile projectile = new Projectile();
            getWorld().addObject(projectile, getX(), getY());
            projectile.setRotation(getRotation() - 60);
            projectile.move(20);
            Projectile projectile2 = new Projectile();
            getWorld().addObject(projectile2, getX(), getY());
            projectile2.setRotation(getRotation() + 60);
            projectile2.move(20);
            Projectile projectile3 = new Projectile();
            getWorld().addObject(projectile3, getX(), getY());
            projectile3.setRotation(getRotation());
            projectile3.move(20);
            Projectile projectile4 = new Projectile();
            getWorld().addObject(projectile4, getX(), getY());
            projectile4.setRotation(getRotation() - 180);
            projectile4.move(20);
            Projectile projectile5 = new Projectile();
            getWorld().addObject(projectile5, getX(), getY());
            projectile5.setRotation(getRotation() + 120);
            projectile5.move(20);
            Projectile projectile6 = new Projectile();
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
