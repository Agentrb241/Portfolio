import greenfoot.*;

/**
 * A surface for the main actor to gravitate toward.
 */
public class EXTRA extends Actor
{
    /**
     * Creates a long platform for the main actor.
     */
    public EXTRA()
    {
        GreenfootImage road = new GreenfootImage("PLATFORM.png");
        /*GreenfootImage image = new GreenfootImage(1040, road.getHeight());
        int w=road.getWidth();
        for(int offset=0; offset<1000; offset+=w) 
        image.drawImage(road, offset, 0);*/
        
        setImage(road);
    }
}
