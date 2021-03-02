import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Blue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blue extends Shoot
{
     private int life;
    protected GreenfootImage muzzleflash;
    protected GreenfootImage bolt;
    /**
     * Act - do whatever the Blue wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        destroyEnemies();
        //checkBoundaries();
        if(life <= 5) //removes blue bullet
        {
            getWorld().removeObject(this);
        } 
        else {
            if(life <= 50)
            {
                setImage(bolt);//the image is set as the blue bolt        
                move(10);//moves 10 
                life--;//bullet dissapears soon
            }
        }
        
    }    
    
    /**
     * The default constructor
     */
    public Blue()
    {
        life=50;
        bolt = new GreenfootImage("blue bolt.png");
        setImage(bolt);
    }

    /**
     * Attack the Stormtrooper
     */
    public void destroyEnemies()
   {
       //"Enemy" can be any class that you want the bullet to destroy. 
       Actor enemy = getOneIntersectingObject(Stormtrooper.class);
       if(enemy != null) 
       {
            ///getWorld().removeObject(enemy);
            //enemy.gone();
            getWorld().removeObject(this);
       }
   } 
}
