import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DeflectBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DeflectBullet extends Actor
{
    protected GreenfootImage blast1;
    protected GreenfootImage blast2;
    protected GreenfootImage blast3;
    /**
     * Act - do whatever the DeflectBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        away();
    }    
    
    
    /**
     * Default Constructor and initalizes the images
     */
    public DeflectBullet()
    {
        blast1 = new GreenfootImage("blocked1.png");
        blast2 = new GreenfootImage("blocked2.png");
        blast3 = new GreenfootImage("blocked3.png");
        setImage(blast1);
    }
      
    
    
    /**
     * Display the deflect images
     */
    public void away()
    {
        if(getImage()== blast1)
        {
            setImage(blast2);
        }
        else if(getImage()== blast2)
        {
            setImage(blast3);
        }
        else if(getImage()== blast3)
        {
            getWorld().removeObject(this);
        }
    }   
}
