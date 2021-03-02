import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Force here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Force extends Actor
{
    
    private int life;
    
    
    /**
     * Act - do whatever the BlueBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(life <= 10) {
            getWorld().removeObject(this);
        } 
        else {
            move(4);//moves 4
            life--;//life decreases and will dissapear
            //create collision check
        }
    }    
    
    /**
     * Force image to be displayed 
     */
    public Force()
    {
        GreenfootImage image = new GreenfootImage("ForceLeft.png");
        image.scale(image.getWidth()/50,image.getHeight()/50);
        setImage(image); 
        life = 20;
    }
     
}
