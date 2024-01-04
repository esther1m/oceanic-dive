import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Muhammad Fazil) 
 * @version (v1.0)
 */

public class DiverShooter extends Actor
{
    int speed = 3; 
    int time = 0; 
    GunButton gunButton; //creating an instance of GunButton
    PowerUp powerUp; //creating an instance of PowerUp
    int powerUpTimer; // creating a power up timer that starts at 0
    
    public DiverShooter(){
        //default constructor that has no parameters 
    }
    public DiverShooter(GunButton gunButton, PowerUp powerUp)
    {
        // the diver will store the power up information that is passed
        this.powerUp = powerUp;
        // the diver will store the gun button information that is passed
        this.gunButton = gunButton; 
    }
    public void act()
    {
        time++;
        turnAround(); 
        moveAround(); 
        fireBullet();
        powerUpUsed();
        hitByCreature();
    }
    /* creating a turn around method for the diver using a conditional if statement
     * if the mouse information is not equal to nothing the diver will turn towards the mouse
     * the diver will not follow the mouse if it is not on screen as the mouse information will be equal to null and the code below will not exceute 
     */
    public void turnAround()
    {
        if(Greenfoot.getMouseInfo() != null) 
        {
            turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY()); //allows the diver to turn towards the mouse using coordinates 
        }
    }
    //allows diver to move around the screen using set location and variations of speed
    public void moveAround()
    {
        if(Greenfoot.isKeyDown("W"))
        {
            setLocation(getX(),getY() - speed);
        }
        if(Greenfoot.isKeyDown("A"))
        {
            setLocation(getX()- speed, getY());
        }
        if(Greenfoot.isKeyDown("S"))
        {
            setLocation(getX(),getY() + speed);
        }
        if(Greenfoot.isKeyDown("D"))
        {
            setLocation(getX()+ speed, getY());
        }
    }
    
    public void fireBullet()
    {
        //if the mouse is pressed and the gun button and upgrade is equal to 1 a bullet will shoot from the gun
        if(Greenfoot.mousePressed(null) && gunButton.gunUpgrade == 1)
        {
            Bullet bullet = new Bullet(); // ensures a new bullet can be fired each time the mouse is pressed
            getWorld().addObject(bullet, getX(), getY()); 
            bullet.setRotation(getRotation()); // enables the referenced bullet to have the same rotation as the diver's rotation
            bullet.move(25); // allows the bullet to move
        }
        //if the mouse is pressed and the gun button upgrade is equal to 2 then dual projectiles will be fired from the gun 
        if(Greenfoot.mousePressed(null) && gunButton.gunUpgrade == 2){
            Bullet bullet = new Bullet();
            getWorld().addObject(bullet, getX(), getY());
            bullet.setRotation(getRotation() - 5); // the referenced bullet will have the a - 5 rotation of the divers rotation 
            bullet.move(20);
            Bullet bullet2 = new Bullet();
            getWorld().addObject(bullet2, getX(), getY());
            bullet2.setRotation(getRotation() + 5); // the referenced bullet will have the a + 5 rotation of the divers rotation
            bullet2.move(20);
        }
        //if the mouse is pressed and the gun button upgrade is equal to 3 then three projectiles will be fired from the gun per click
        if(Greenfoot.mousePressed(null) && gunButton.gunUpgrade == 3){
            Bullet bullet = new Bullet();
            getWorld().addObject(bullet, getX(), getY());
            bullet.setRotation(getRotation() - 5); // the referenced bullet will have the a - 5 rotation of the divers rotation
            bullet.move(20);
            Bullet bullet2 = new Bullet();
            getWorld().addObject(bullet2, getX(), getY());
            bullet2.setRotation(getRotation() + 5); // the referenced bullet will have the a + 5 rotation of the divers rotation
            bullet2.move(20);
            Bullet bullet3 = new Bullet();
            getWorld().addObject(bullet3, getX(), getY()); // enables the referenced bullet to have the same rotation as the diver's rotation
            bullet3.setRotation(getRotation());
            bullet3.move(20);
        }
        //if the mouse is pressed and the gun button upgrade is equal to 4 then four projectiles will be fired from the gun per click
        if(Greenfoot.mousePressed(null) && gunButton.gunUpgrade == 4){
            Bullet bullet = new Bullet();
            getWorld().addObject(bullet, getX(), getY());
            bullet.setRotation(getRotation() - 5); // the referenced bullet will have the a - 5 rotation of the divers rotation
            bullet.move(20);
            Bullet bullet2 = new Bullet();
            getWorld().addObject(bullet2, getX(), getY());
            bullet2.setRotation(getRotation() + 5); // the referenced bullet will have the a + 5 rotation of the divers rotation
            bullet2.move(20);
            Bullet bullet3 = new Bullet();
            getWorld().addObject(bullet3, getX(), getY()); // enables the referenced bullet to have the same rotation as the diver's rotation
            bullet3.setRotation(getRotation());
            bullet3.move(20);
            Bullet bullet4 = new Bullet();
            getWorld().addObject(bullet4, getX(), getY()); // the referenced bullet will have + 15 of the diver's rotation
            bullet4.setRotation(getRotation() + 15);
            bullet4.move(20);
        }
    }
    /*This method creates the instant kill power up to be used 
     * So if the powerUp and powerUpCount variables are less than 99 and the powerUpTimer is less than 30 and the space bar key is down
     * then power up will be used and 6 different bullets will be fired at once
     * the 6 bullets will be spread around the diver as different rotations will be set for each projectile
     */
    public void powerUpUsed()
    {
        if(powerUp.powerUpCount > 99 && powerUpTimer < 30 && Greenfoot.isKeyDown("SPACE"))
        {
            Bullet bullet = new Bullet();
            getWorld().addObject(bullet, getX(), getY());
            bullet.setRotation(getRotation() - 60);
            bullet.move(20);
            Bullet bullet2 = new Bullet();
            getWorld().addObject(bullet2, getX(), getY());
            bullet2.setRotation(getRotation() + 60);
            bullet2.move(20);
            Bullet bullet3 = new Bullet();
            getWorld().addObject(bullet3, getX(), getY());
            bullet3.setRotation(getRotation());
            bullet3.move(20);
            Bullet bullet4 = new Bullet();
            getWorld().addObject(bullet4, getX(), getY());
            bullet4.setRotation(getRotation() - 180);
            bullet4.move(20);
            Bullet bullet5 = new Bullet();
            getWorld().addObject(bullet5, getX(), getY());
            bullet5.setRotation(getRotation() + 120);
            bullet5.move(20);
            Bullet bullet6 = new Bullet();
            getWorld().addObject(bullet6, getX(), getY());
            bullet6.setRotation(getRotation() - 120);
            bullet6.move(20);
            
            powerUpTimer++; // the power up timer increments by 1
        }
        /* once the code above has been exceuted and if the powerup timer is greater than 29 
         *  the power up bar, power up count and power up timer will all be set back equal to 0
         *  which in turn will reset the power up function to repeat again */
        if(powerUpTimer > 29)
        {
            powerUp.powerUpCount = 0;
            powerUpTimer = 0;
        }
    }
    // when the diver is hit by creature a true value will be returned
    public boolean hitByCreature()
    {
        Actor creature = getOneObjectAtOffset(0,0,Creature.class);
        //if the centre of the diver is touched directly by the creature class then true will be returned  
        if(creature != null)
        {
            return true;
        }
        else {
        return false;}
    }
}
