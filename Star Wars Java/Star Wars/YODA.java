import greenfoot.*;

/**
 * A user-controlled actor that walks and jumps, and is pulled down by gravity.
 * <l><li>Left arrow moves actor left (toward left scroll limit)</li>
 * <li>Right arrow moves actor right (toward right scroll limit)</li>
 * <li>Up arrow makes the actor jump</li><l>
 */
public class YODA extends Character
{
    //final int jSpeed = 20; // the initial 'jump' speed
    //int ySpeed = 0, xSpeed = 0; // the initial vertical and horizontal speeds
    //boolean aboutFace; // the direction (left or right) the actor is facing
   // boolean onGround; // the state of the actor being set on an object or not
   int damage;
    /** 
     * Checks for changes in direction and moves the main actor.
     */
    public void act()
    {
        attack();
        Right(5);
        Left(5);
        Jump(10);
        ground();
        gravity();
        fire();
        Defend();
        forceblockbullet();
        deflect();
        labelFollow();
        healthlost();
        Lose();
    }
     public YODA()
    {
        //attack Images
        AttackR1 = new GreenfootImage("attack1.png");
        AttackR2 =  new GreenfootImage("attack2.png");
        AttackR3 =  new GreenfootImage("attack3.png");
        AttackR4 =  new GreenfootImage("attack4.png");
        AttackR5 =  new GreenfootImage("attack5.png");
        AttackR6 =  new GreenfootImage("attack6.png"); 
        
        AttackL1 = new GreenfootImage("attack1.png");
        AttackL1.mirrorHorizontally();
        AttackL2 =  new GreenfootImage("attack2.png");
        AttackL2.mirrorHorizontally();
        AttackL3 =  new GreenfootImage("attack3.png");
        AttackL3.mirrorHorizontally();
        AttackL4 =  new GreenfootImage("attack4.png");
        AttackL4.mirrorHorizontally();
        AttackL5 =  new GreenfootImage("attack5.png");
        AttackL5.mirrorHorizontally();
        AttackL6 =  new GreenfootImage("attack6.png");
        AttackL6.mirrorHorizontally();
        
        //Walk Images
        WalkR = new GreenfootImage("stand2.png");
        Walk1 = new GreenfootImage("ywalk1.png");
        Walk2 = new GreenfootImage("ywalk2.png");
        Walk3 = new GreenfootImage("ywalk3.png");
        
        WalkL = new GreenfootImage("stand2.png");
        WalkL.mirrorHorizontally();
        Walk1L = new GreenfootImage("ywalk1.png");
        Walk1L.mirrorHorizontally();
        Walk2L = new GreenfootImage("ywalk2.png");
        Walk2L.mirrorHorizontally();
        Walk3L = new GreenfootImage("ywalk3.png");
        Walk3L.mirrorHorizontally();
        
        //Force Block Images
        forceblock1 = new GreenfootImage("forceblock1.png");
        forceblock2 = new GreenfootImage("forceblock2.png");
        forceblock3 = new GreenfootImage("forceblock3.png");
        forceblock4 = new GreenfootImage("forceblock4.png");
        forceblock5 = new GreenfootImage("forceblock5.png");
        
        forceblockL1 = new GreenfootImage("forceblock1.png");
        forceblockL1.mirrorHorizontally();
        forceblockL2 = new GreenfootImage("forceblock2.png");
        forceblockL2.mirrorHorizontally();
        forceblockL3 = new GreenfootImage("forceblock3.png");
        forceblockL3.mirrorHorizontally();
        forceblockL4 = new GreenfootImage("forceblock4.png");
        forceblockL4.mirrorHorizontally();
        forceblockL5 = new GreenfootImage("forceblock5.png");
        forceblockL5.mirrorHorizontally();
        
        //Force Images
        force1 = new GreenfootImage("force1.png");
        force2 = new GreenfootImage("force2.png");
        force3 = new GreenfootImage("force3.png");
        force4 = new GreenfootImage("force4.png");
        
        forceL1 = new GreenfootImage("force1.png");
        forceL1.mirrorHorizontally();
        forceL2 = new GreenfootImage("force2.png");
        forceL2.mirrorHorizontally();
        forceL3 = new GreenfootImage("force3.png");
        forceL3.mirrorHorizontally();
        forceL4 = new GreenfootImage("force4.png");
        forceL4.mirrorHorizontally();
        
        //Default Image
        setImage(WalkR);
        healthBar = (new Bar("","",100,100));
       
        damage = 10;
        
    }

    /**
     * Blocks bullet by defending
     */
    public void forceblockbullet()
    {
        if(getImage()== forceblock1 || getImage() == forceblock2 || getImage() == forceblock3 || getImage() == forceblock4 || getImage() == forceblock5 || getImage() == forceblockL1 || getImage() == forceblockL2 || getImage() == forceblockL3 || getImage() == forceblockL4 || getImage() == forceblockL5)
        {
            Actor blast = getOneIntersectingObject(Bullet.class);
            if(blast != null)
            {
                getWorld().removeObject(blast);
            }
            
        }
        
    }
    
    public void healthlost()
    {
        Actor blast = getOneIntersectingObject(Bullet.class);
        if(blast!=null)
        {
            this.healthBar.subtract(damage);
        }
    }
    
    
    
    
    
    
    /**
     * Deflects the bullet
     */
    public void deflect()
    {
        Actor blast = getOneIntersectingObject(Bullet.class);
        if(getImage() == AttackR1 || getImage() == AttackR2 || getImage() == AttackR3 || getImage() == AttackR4 || getImage() == AttackR5 || getImage() == AttackR6 || getImage() ==  AttackL1 || getImage() ==  AttackL2 || getImage() ==  AttackL3 || getImage() ==  AttackL4 || getImage() ==  AttackL5 || getImage() ==  AttackL6 )
        {
            
            if(blast != null)
            {
                Character Clone = getWorld().getObjects(Stormtrooper.class).get(1);//get Clone Object and 0 returns the first Clone element
                
                getWorld().removeObject(blast);//removes the bullet
                Actor blue = new Blue();//creates a blue bullet
                Actor deflect = new DeflectBullet();//deflect images initalized
                getWorld().addObject(deflect, this.getX(), this.getY());//deflect displayed 
                getWorld().addObject(blue, this.getX(), this.getY());//blue bullet displayed
                

                int random = Greenfoot.getRandomNumber(100);//get random Number
                //Random number so the storm trooper doesn't shoot perfectly
                if(random<50)
                blue.turnTowards(Clone.getX(), Clone.getY());//rotate to Clone
                else if (random>=50 && random<75)
                blue.turnTowards(-Clone.getX(), -Clone.getY());
                else if(random>=75  && random <=100)
                blue.turnTowards(Clone.getX()*2,Clone.getX()*3);
            }
            //make stormtrooper fall
            /*Stormtrooper storm = (Stormtrooper) getOneIntersectingObject(Stormtrooper.class);
            
            if(storm != null) 
            {
                storm.fall();
            }*/
        }
        
        
    }
    
    
    /**
     * fire the force
     */
    public void fire()//shoot
    {
        if(Greenfoot.isKeyDown("f"))
        {
            if(getImage() == WalkR || getImage()== Walk1 || getImage()== Walk2 || getImage()== Walk3)
            {
                setImage(force1);//first image of the force is shown
                Actor bullet = new Force();//force is intialized and created
                getWorld().addObject(bullet, getX(), getY());//force is displayed
            }
            else if (getImage() == force1)
            {
                setImage(force2);
            }
            else if (getImage() == force2)
            {
                setImage(force3);
            }
            else if (getImage() == force3)
            {
                setImage(force4);
            }
            else if (getImage() == force4)
            {
                setImage(WalkR);
            }
            if(getImage() == WalkL || getImage()== Walk1L || getImage()== Walk2L || getImage()== Walk3L)
            {
                setImage(forceL1);//first image of the force is shown
                Actor bullet = new Force();//force is intialized and created
                bullet.setRotation(180);//force is rotated to go other direction
                getWorld().addObject(bullet, getX(), getY());//force is displayed
            }
            else if (getImage() == forceL1)
            {
                setImage(forceL2);
            }
            else if (getImage() == forceL2)
            {
                setImage(forceL3);
            }
            else if (getImage() == forceL3)
            {
                setImage(forceL4);
            }
            else if (getImage() == forceL4)
            {
                setImage(WalkL);
            }
        }
        else if(getImage()== forceL1 || getImage()== forceL2 || getImage()== forceL3 || getImage()== forceL4)
            {
                setImage(WalkL);
            }
        else if(getImage()== force1 || getImage()== force2 || getImage()== force3 || getImage()== force4)
            {
                setImage(WalkR);
            }
    }
    
    
    public void Lose()
    {
        World w = getWorld();
        if(healthBar.getValue() == 0)
        {
            w.addObject(new Lose(),200,197);
            Greenfoot.stop();
        }
    }
}
