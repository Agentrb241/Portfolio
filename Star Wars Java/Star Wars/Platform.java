import greenfoot.*;

/**
 * A surface for the main actor to gravitate toward.
 */
public class Platform extends Actor
{
    /**
     * Creates a long platform for the main actor.
     */
    public Platform()
    {
        GreenfootImage road = new GreenfootImage("road.jpg");
        GreenfootImage image = new GreenfootImage(1040, road.getHeight());
        int w=road.getWidth();
        for(int offset=0; offset<1040; offset+=w) image.drawImage(road, offset, 0);
        setImage(image);
    }
}
