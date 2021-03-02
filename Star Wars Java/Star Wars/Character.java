import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Actor
{
    
    //images
    
    //Right Walk
    protected GreenfootImage WalkR;
    protected GreenfootImage Walk1;
    protected GreenfootImage Walk2;
    protected GreenfootImage Walk3;
    protected GreenfootImage Walk4;
    protected GreenfootImage Walk5;
    protected GreenfootImage Walk6;
    protected GreenfootImage Walk7;
    protected GreenfootImage Walk8;
    
    //Left Walk
    protected GreenfootImage WalkL;
    protected GreenfootImage Walk1L;
    protected GreenfootImage Walk2L;
    protected GreenfootImage Walk3L;
    protected GreenfootImage Walk4L;
    protected GreenfootImage Walk5L;
    protected GreenfootImage Walk6L;
    protected GreenfootImage Walk7L;
    protected GreenfootImage Walk8L;
    
    //Right Attack
    protected GreenfootImage AttackR1;
    protected GreenfootImage AttackR2;
    protected GreenfootImage AttackR3;
    protected GreenfootImage AttackR4;
    protected GreenfootImage AttackR5;
    protected GreenfootImage AttackR6;
    
    
    //Left Attack
    protected GreenfootImage AttackL1;
    protected GreenfootImage AttackL2;
    protected GreenfootImage AttackL3;
    protected GreenfootImage AttackL4;
    protected GreenfootImage AttackL5;
    protected GreenfootImage AttackL6;    
    
    //Right Defend
    protected GreenfootImage forceblock1;
    protected GreenfootImage forceblock2;
    protected GreenfootImage forceblock3;
    protected GreenfootImage forceblock4;
    protected GreenfootImage forceblock5;
    
    //Left Defend
    protected GreenfootImage forceblockL1;
    protected GreenfootImage forceblockL2;
    protected GreenfootImage forceblockL3;
    protected GreenfootImage forceblockL4;
    protected GreenfootImage forceblockL5;
    
    //Right Force
    protected GreenfootImage force1;
    protected GreenfootImage force2;
    protected GreenfootImage force3;
    protected GreenfootImage force4;
    
    //Left Force
    protected GreenfootImage forceL1;
    protected GreenfootImage forceL2;
    protected GreenfootImage forceL3;
    protected GreenfootImage forceL4;
    
    //Right Die
    protected GreenfootImage die1;
    protected GreenfootImage die2;
    protected GreenfootImage die3;
    protected GreenfootImage die4;
    protected GreenfootImage die5;
    protected GreenfootImage die6;
    protected GreenfootImage die7;
    protected GreenfootImage die8;
    protected GreenfootImage die9;
    protected GreenfootImage die10;
    
    //Left Die
    protected GreenfootImage die1L;
    protected GreenfootImage die2L;
    protected GreenfootImage die3L;
    protected GreenfootImage die4L;
    protected GreenfootImage die5L;
    protected GreenfootImage die6L;
    protected GreenfootImage die7L;
    protected GreenfootImage die8L;
    protected GreenfootImage die9L;
    protected GreenfootImage die10L;
    
    //Right Dazed
    protected GreenfootImage dazed1;
    protected GreenfootImage dazed2;
    protected GreenfootImage dazed3;
    protected GreenfootImage dazed4;
    protected GreenfootImage dazed5;
    protected GreenfootImage dazed6;
    protected GreenfootImage dazed7;
    
    //Left Dazed
    protected GreenfootImage dazed1L;
    protected GreenfootImage dazed2L;
    protected GreenfootImage dazed3L;
    protected GreenfootImage dazed4L;
    protected GreenfootImage dazed5L;
    protected GreenfootImage dazed6L;
    protected GreenfootImage dazed7L;
    
    
    //how fast
    int speed;
    
    
    public Bar healthBar;
    /**
     * Moves Left
     */
    public void Left(int speed)//controls
    {
        if(Greenfoot.isKeyDown("left"))
        {
           setLocation(getX()-speed, getY());//moves left
           if(getImage() == WalkR || getImage() == WalkL || getImage()== Walk1 || getImage()== Walk2 || getImage()== Walk3)
            {
                setImage(Walk1L);
            }
            else if (getImage() == Walk1L)
            {
                setImage(Walk2L);
            }
            else if (getImage() == Walk2L)
            {
                setImage(Walk3L);
            }
            else if (getImage() == Walk3L)
            {
                setImage(WalkL);
            }
        }
        else if(getImage()==Walk3L)
        {
            setImage(WalkL);
        }
    }
    
    /**
     * Jumps up!
     */
    public void Jump(int speed)//controls
    {
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY()-speed);//goes up
        }
    }
    
    /**
     * Moves Right
     */
    public void Right(int speed)//controls
    {
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+speed, getY());//moves right
            if(getImage() == WalkR || getImage() == WalkL || getImage()== Walk1L || getImage()== Walk2L || getImage()== Walk3L)
            {
                setImage(Walk1);
            }
            else if (getImage() == Walk1)
            {
                setImage(Walk2);
            }
            else if (getImage() == Walk2)
            {
                setImage(Walk3);
            }
            else if (getImage() == Walk3)
            {
                setImage(WalkR);
            }
        }
        else if(getImage()==Walk3)
        {
            setImage(WalkR);
        }
    }
    
    /**
     * Attack with Lightsaber
     */
    public void attack()
    {
        if(Greenfoot.isKeyDown("space"))//when space, display attack images
        {
           Character Storm = (Stormtrooper)getOneIntersectingObject(Stormtrooper.class);
            if(getImage() == WalkR || getImage()== Walk1 || getImage()== Walk2 || getImage()== Walk3)
            {
                setImage(AttackR1);
            }
            else if (getImage() == AttackR1)
            {
                setImage(AttackR2);
            }
            else if (getImage() == AttackR2)
            {
                setImage(AttackR3);
            }
            else if (getImage() == AttackR3)
            {
                setImage(AttackR4);
            }
            else if (getImage() == AttackR4)
            {
                setImage(AttackR5);
            }
            else if(getImage() == AttackR5)
            {
                setImage(AttackR6);
            }
            else if(getImage() == AttackR6)
            {
                if(Storm != null)
                {
                    Storm.healthBar.subtract(5);
                }
                setImage(WalkR);
            }
           if(getImage() == WalkL || getImage()== Walk1L || getImage()== Walk2L || getImage()== Walk3L)
            {
                setImage(AttackL1);
            }
            else if (getImage() == AttackL1)
            {
                setImage(AttackL2);
            }
            else if (getImage() == AttackL2)
            {
                setImage(AttackL3);
            }
            else if (getImage() == AttackL3)
            {
                setImage(AttackL4);
            }
            else if (getImage() == AttackL4)
            {
                setImage(AttackL5);
            }
            else if(getImage() == AttackL5)
            {
                setImage(AttackL6);
            }
            else if(getImage() == AttackL6)
            {
                if(Storm != null)
                {
                    Storm.healthBar.subtract(5);
                }
                setImage(WalkL);
            }
        }
        //when space is released, display Walk Images
        else if(getImage()== AttackL6 || getImage()== AttackL1 || getImage()== AttackL2 || getImage()== AttackL3 || getImage()== AttackL4 || getImage()== AttackL5)
            {
                setImage(WalkL);
            }
        else if(getImage()== AttackR6 || getImage()== AttackR1 || getImage()== AttackR2 || getImage()== AttackR3 || getImage()== AttackR4 || getImage()== AttackR5)
            {
                setImage(WalkR);
            }
    }
    
    /**
     * Makes sure Character Object is on the ground
     */
    public boolean ground()//creates a ground
    {
        if(getOneObjectAtOffset(0,getImage().getHeight()/2,Platform.class)!=null || getOneObjectAtOffset(0,getImage().getHeight()/2,EXTRA.class)!=null)
        return true;
        else
        return false;
    }
    
    /**
     * Forces Character object to get to the ground
     */
    public void gravity()//makes the character fall down
    {
        if(ground()==false)
        {
            setLocation(getX(), getY()+speed);
            speed++;
        }
        else
        {
            speed = 0;
        }
    }
    /**
     * Defends from lasers
     */
    public void Defend()
    {
        if(Greenfoot.isKeyDown("shift"))//when shift, display defend images
        {
            if(getImage() == WalkR || getImage()== Walk1 || getImage()== Walk2 || getImage()== Walk3)
            {
                setImage(forceblock1);
            }
            else if(getImage() == forceblock1)
            {
                setImage(forceblock2);
            }
            else if(getImage() == forceblock2)
            {
                setImage(forceblock3);
            }
            else if(getImage() == forceblock3)
            {
                setImage(forceblock4);
            }
            else if(getImage() == forceblock4)
            {
                setImage(forceblock5);
            }
            else if(getImage()== forceblock5)
            {
                setImage(WalkR);
            }
            if(getImage() == WalkL || getImage()== Walk1L || getImage()== Walk2L || getImage()== Walk3L)
            {
                setImage(forceblockL1);
            }
            else if(getImage() == forceblockL1)
            {
                setImage(forceblockL2);
            }
            else if(getImage() == forceblockL2)
            {
                setImage(forceblockL3);
            }
            else if(getImage() == forceblockL3)
            {
                setImage(forceblockL4);
            }
            else if(getImage() == forceblockL4)
            {
                setImage(forceblockL5);
            }
            else if(getImage()== forceblockL5)
            {
                setImage(WalkL);
            }
        }
        //when shift is released, display Walk Images
        else if(getImage()== forceblockL1 || getImage() == forceblockL2 || getImage() == forceblockL3 || getImage() == forceblockL4 || getImage() == forceblockL5)
            {
                setImage(WalkL);
            }
        else if(getImage()== forceblock1 || getImage() == forceblock2 || getImage() == forceblock3 || getImage() == forceblock4 || getImage() == forceblock5)
            {
                setImage(WalkR);
            }
    }

    public void labelFollow()
    {
        healthBar.setLocation(this.getX(),this.getY()-getImage().getHeight()/2-15);
    }
    
    protected void addedToWorld(World world)
    {
        world.addObject(healthBar, 5000, 300000);

    }
    
    public Bar getHealthBar()
    {
        return healthBar;
    }
    
    /**
     * World Edge
     */
    public boolean atWorldEdge()//World Edge measures
    {
        if(getX() < 20 || getX() > getWorld().getWidth()-20)
        return true;
        else
        return false;
    }
    
    
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
