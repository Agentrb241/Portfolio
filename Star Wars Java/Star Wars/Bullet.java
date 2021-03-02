import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Shoot
{
   private int life;
    
    protected GreenfootImage muzzleflash;
    protected GreenfootImage bolt;
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        destroyEnemies();
        //checkBoundaries();
        //setRotation(direction); 
        //move(speed);
        if(life <= 5) {
            getWorld().removeObject(this);//remove the bullet
        } 
        else {
            if(getImage()==muzzleflash && life>49)//first a muzzle flash
            {
               setImage(muzzleflash);//image will be muzzleflash
            }
            if(life <= 49 &&getImage()==muzzleflash)//switches to a bolt
            setImage(bolt);
            
            move(10);//moves 10
            life--;//decreases life
        }
        
    }    
    
    /**
     * Defualt constructor of Bullet
     */
    public Bullet()
    {
        life=50;
        muzzleflash = new GreenfootImage("BOLT.png");//muzzlefalsh
        setImage(muzzleflash);
        bolt = new GreenfootImage("blaster bolt.png");//bolt image
    }
  
    public void destroyEnemies()
   {
       //"Enemy" can be any class that you want the bullet to destroy. 
       Actor enemy = getOneIntersectingObject(YODA.class);
       if(enemy != null) 
       {
            getWorld().removeObject(this);
       }
   }
}
