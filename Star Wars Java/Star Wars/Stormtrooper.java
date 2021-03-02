  import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 import java.util.List;
/**
 * Write a description of class Stormtrooper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stormtrooper extends Character
{
    private int speed;
    private int up;
    private int shotDelay; 
    private boolean move;
    private boolean isLeft;
    private int damage;
    GreenfootImage dieR;
    GreenfootImage dieL;
    
    
    public Stormtrooper()
    {
        //health = new HealthBar();
        
        //Walk Images
        WalkR = new GreenfootImage("walk1.png");
        Walk1 = new GreenfootImage("walk1.png");
        Walk2 = new GreenfootImage("walk2.png");
        Walk3 = new GreenfootImage("walk3.png");
        Walk4 = new GreenfootImage("walk4.png");
        Walk5 = new GreenfootImage("walk5.png");
        Walk6 = new GreenfootImage("walk6.png");
        Walk7 = new GreenfootImage("walk7.png");
        Walk8 = new GreenfootImage("walk8.png");
        
        WalkL = new GreenfootImage("walk1.png");
        WalkL.mirrorHorizontally();
        Walk1L = new GreenfootImage("walk1.png");
        Walk1L.mirrorHorizontally();
        Walk2L = new GreenfootImage("walk2.png");
        Walk2L.mirrorHorizontally();
        Walk3L = new GreenfootImage("walk3.png");
        Walk3L.mirrorHorizontally();
        Walk4L = new GreenfootImage("walk4.png");
        Walk4L.mirrorHorizontally();
        Walk5L = new GreenfootImage("walk5.png");
        Walk5L.mirrorHorizontally();
        Walk6L = new GreenfootImage("walk6.png");
        Walk6L.mirrorHorizontally();
        Walk7L = new GreenfootImage("walk7.png");
        Walk7L.mirrorHorizontally();
        Walk8L = new GreenfootImage("walk8.png");
        Walk8L.mirrorHorizontally();
        
        //Die Images
        die1 = new GreenfootImage("die1.png");
        die1.mirrorHorizontally();
        die2 = new GreenfootImage("die2.png");
        die2.mirrorHorizontally();
        die3 = new GreenfootImage("die3.png");
        die3.mirrorHorizontally();
        die4 = new GreenfootImage("die4.png");
        die4.mirrorHorizontally();
        die5 = new GreenfootImage("die5.png");
        die5.mirrorHorizontally();
        die6 = new GreenfootImage("die6.png");
        die6.mirrorHorizontally();
        die7 = new GreenfootImage("die7.png");
        die7.mirrorHorizontally();
        die8 = new GreenfootImage("die8.png");
        die8.mirrorHorizontally();
        die9 = new GreenfootImage("die9.png");
        die9.mirrorHorizontally();
        die10 = new GreenfootImage("die10.png");
        die10.mirrorHorizontally();
        dieR =  new GreenfootImage("die10.png");
        dieR.mirrorHorizontally();
        
        
        die1L = new GreenfootImage("die1.png");
        die2L = new GreenfootImage("die2.png");
        die3L = new GreenfootImage("die3.png");
        die4L = new GreenfootImage("die4.png");
        die5L = new GreenfootImage("die5.png");
        die6L = new GreenfootImage("die6.png");
        die7L = new GreenfootImage("die7.png");
        die8L = new GreenfootImage("die8.png");
        die9L = new GreenfootImage("die9.png");
        die10L = new GreenfootImage("die10.png");
        dieL =  new GreenfootImage("die10.png");
        
        //Dazed images
        dazed1 = new GreenfootImage("dazed1.png");
        dazed1.mirrorHorizontally();
        dazed2 = new GreenfootImage("dazed2.png");
        dazed2.mirrorHorizontally();
        dazed3 = new GreenfootImage("dazed3.png");
        dazed3.mirrorHorizontally();
        dazed4 = new GreenfootImage("dazed4.png");
        dazed4.mirrorHorizontally();
        dazed5 = new GreenfootImage("dazed5.png");
        dazed5.mirrorHorizontally();
        dazed6 = new GreenfootImage("dazed6.png");
        dazed6.mirrorHorizontally();
        dazed7 = new GreenfootImage("dazed7.png");
        dazed7.mirrorHorizontally();

        dazed1L = new GreenfootImage("dazed1.png");
        dazed2L = new GreenfootImage("dazed2.png");
        dazed3L = new GreenfootImage("dazed3.png");
        dazed4L = new GreenfootImage("dazed4.png");
        dazed5L = new GreenfootImage("dazed5.png");
        dazed6L = new GreenfootImage("dazed6.png");
        dazed7L = new GreenfootImage("dazed7.png");        
        
        //shooting
        shotDelay=0;
        setImage(WalkR);
        move=true;
        speed = 5;
        up=5;
        //collisionCountdown=0;
        
        damage=20;
        healthBar = (new Bar("","",100,100));
    }
    
    /**
     * Act - do whatever the Stormtrooper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        ground();
        gravity();
        labelFollow();
        healthlost();
        falldown();
        revive();
        if(NearHero())
        {
            shoot();
            move=false;
        }
        else
        {
            move=true;
        }
        force();
        move();
        death();
    }
    
    public void death()
    {
        if(healthBar.getValue() == 0)
        {

        if(getImage()==WalkL || getImage()==Walk1L || getImage()==Walk2L || getImage()==Walk3L || getImage()==Walk4L || getImage()==Walk5L || getImage()==Walk6L || getImage()==Walk7L || getImage()==Walk8L)       
        {
            setImage(die1);
            //falldown();
        }
            
            else    if(getImage()==die1L)
            {
                setImage(die2L);
            }
            else if(getImage()==die2L)
            {
                setImage(die3L);
            }
            else if(getImage()==die3L)
            {
                setImage(die4L);
            }
            else if(getImage()==die4L)
            {
                setImage(die5L);
            }
            else if(getImage()==die5L)
            {
                setImage(die6L);
            }
            else if(getImage()==die6L)
            {
                setImage(die7L);
            }
            else if(getImage()==die7L)
            {
                setImage(dieL);
                setLocation(getX(),getY()+2);
            }
            if(getImage()==WalkR || getImage()==Walk1 || getImage()==Walk2 || getImage()==Walk3 || getImage()==Walk4 || getImage()==Walk5 || getImage()==Walk6 || getImage()==Walk7 || getImage()==Walk8)
        {
            setImage(die1L);
            //falldown();
        }
            else if(getImage()==die1)
            {
                setImage(die2);
            }
            else if(getImage()==die2)
            {
                setImage(die3);
            }
            else if(getImage()==die3)
            {
                setImage(die4);
            }
            else if(getImage()==die4)
            {
                setImage(die5);
            }
            else if(getImage()==die5)
            {
                setImage(die6);
            }
            else if(getImage()==die6)
            {
                setImage(die7);
            }
            else if(getImage()==die7)
            {
                setImage(dieR);
                setLocation(getX(),getY()+2);
            }
   
        }
        
        
    }
    
    public void healthlost()
    {
        Actor blast = getOneIntersectingObject(Blue.class);
        if(blast!=null)
        {
            this.healthBar.subtract(damage);
        }
    }
    
    public boolean NearHero() {
        if ( getX() != 10 || getY() != 10 ) {
            List<YODA> hero = getNeighbours(300, true, YODA.class);
            if (hero.isEmpty())//when hero dies
            {
                return false;
            }
            return true;
        }
        return false;
    }
    
    public void move()
    {
      if(isLeft==true)
      {
        animateL();
      }
      else if(isLeft==false)
      {
          animateR();
       }
        
    }
    
    protected void checkDirection() {
        List<YODA> player = getWorld().getObjects(YODA.class);
        YODA play = (YODA) player.get(0);
        if ((play.getX() - this.getX()) > 3) //3 pixels apart then lets move() know to animate left
        {
            isLeft=false;            
        } 
        else //lets move() know to animate right
        {
            isLeft=true;
        }
    }
    
    /**
     * shoots Delay
     */
    public void shoot() 
    { 
        checkDirection();
        move=false;
        if(shotDelay >= 45) 
        { 
            Actor Bullet = new Bullet();
            
            if(getImage()==WalkR || getImage()==Walk1 || getImage()==Walk2 || getImage()==Walk3 || getImage()==Walk4 || getImage()==Walk5 || getImage()==Walk6 || getImage()==Walk7 || getImage()==Walk8 )
            {
                
                getWorld().addObject(Bullet, getX()+55, getY()-18);
                Character Yoda = getWorld().getObjects(YODA.class).get(0);//get the Yoda Object
                int random = Greenfoot.getRandomNumber(100);//choses how the bullet direction shoots
                if(random<50)
                Bullet.turnTowards(Yoda.getX(), Yoda.getY());//rotate to YODA aka Target YODA
                else if (random>=50 && random<75)
                Bullet.turnTowards(-Yoda.getX(), -Yoda.getY());
                else if(random>=75  && random <=100)
                Bullet.turnTowards(Yoda.getX()*2,Yoda.getX()*3);
                
            }
            else if(getImage()==WalkL || getImage()==Walk1L || getImage()==Walk2L || getImage()==Walk3L || getImage()==Walk4L || getImage()==Walk5L || getImage()==Walk6L || getImage()==Walk7L || getImage()==Walk8L )
            {
                
                Bullet.setRotation(180);
                getWorld().addObject(Bullet, getX()-55, getY()-18);
                Character Yoda = getWorld().getObjects(YODA.class).get(0);//get the Yoda Object
                int random = Greenfoot.getRandomNumber(100);//choses how the bullet direction shoots
                if(random<30)
                Bullet.turnTowards(Yoda.getX(), Yoda.getY());//rotate to YODA aka Target YODA
                else if (random>=30 && random<75)
                Bullet.turnTowards(Yoda.getX(), Yoda.getY()-30);
                else if(random>=75  && random <=100)
                Bullet.turnTowards(Yoda.getX(),Yoda.getY()-40);
                
                
            }
            shotDelay=0;
        } 
          shotDelay++; 
    }
    
    
    public void animateL()
    {

            if(getImage()==WalkR || getImage()==Walk1 || getImage()==Walk2 || getImage()==Walk3 || getImage()==Walk4 || getImage()==Walk5 || getImage()==Walk6 || getImage()==Walk7 || getImage()==Walk8)
            {
                setImage(WalkL);
            }
            else if(getImage()==WalkL && move==true)
            { 
                setLocation(getX()-speed, getY());
                setImage(Walk1L);
            }
            else if(getImage()==Walk1L)
            {
                setLocation(getX()-speed, getY());
                setImage(Walk2L);
            }
            else if(getImage()==Walk2L)
            {
                setLocation(getX()-speed, getY());
                setImage(Walk3L);
            }
            else if(getImage()==Walk3L)
            {
                setLocation(getX()-speed, getY());
                setImage(Walk4L);
            }
            else if(getImage()==Walk4L)
            {
                setLocation(getX()-speed, getY());
                setImage(Walk5L);
            }
            else if(getImage()==Walk5L)
            {
                setLocation(getX()-speed, getY());
                setImage(Walk6L);
            }
            else if(getImage()==Walk6L)
            {
                setLocation(getX()-speed, getY());
                setImage(Walk7L);
            }
            else if(getImage()==Walk7L)
            {
                setLocation(getX()-speed, getY());
                setImage(Walk8L);
            }
            else if(getImage()==Walk8L)
            {
                setLocation(getX()-speed, getY());
                setImage(WalkL);
            }
     
    }
        public void animateR()
        {
              if(getImage()==WalkL || getImage()==Walk1L || getImage()==Walk2L || getImage()==Walk3L || getImage()==Walk4L || getImage()==Walk5L || getImage()==Walk6L || getImage()==Walk7L || getImage()==Walk8L )
              {
                  setImage(WalkR);
              }
              else if(getImage()==WalkR && move==true)
                {
                    setLocation(getX()+speed, getY());
                    setImage(Walk1);
    
                }
                else if(getImage()==Walk1)
                {
                    setImage(Walk2);
                    setLocation(getX()+speed, getY());
                }
                else if(getImage()==Walk2)
                {
                    setImage(Walk3);
                    setLocation(getX()+speed, getY());
                }
                else if(getImage()==Walk3)
                {
                    setImage(Walk4);
                    setLocation(getX()+speed, getY());
                }
                else if(getImage()==Walk4)
                {
                    setImage(Walk5);
                    setLocation(getX()+speed, getY());
                }
                else if(getImage()==Walk5)
                {
                    setImage(Walk6);
                    setLocation(getX()+speed, getY());
                }
                else if(getImage()==Walk6)
                {
                    setImage(Walk7);
                    setLocation(getX()+speed, getY());
                }
                else if(getImage()==Walk7)
                {
                    setImage(Walk8);
                    setLocation(getX()+speed, getY());
                }
                else if(getImage()==Walk8)
                {
                    setImage(Walk1);
                    setLocation(getX()+speed, getY());
                }
         
    }
    

    
    
    
    
    
    /**
     * Falls down when touched by the force
     */
    public void force()
    {
        Force actor = (Force) getOneIntersectingObject(Force.class);        
        if(actor != null && actor.getRotation()==0)
        {
            setLocation(getX()+80,getY());
            fall();
            revive();
        } 
        else if(actor != null && actor.getRotation()==180)
        {
            setLocation(getX()-80,getY());
            fall();
            revive();
        }
    }
    
   
    
    
    /**
     * Fire the Laser
     */
    public void fire()//shoot
    {
        if(Greenfoot.isKeyDown("enter"))
        {
            Actor bullet = new Bullet();
            if(getImage()==WalkR || getImage()==Walk1 || getImage()==Walk2 || getImage()==Walk3 || getImage()==Walk4 || getImage()==Walk5 || getImage()==Walk6 || getImage()==Walk7 || getImage()==Walk8 )
            {
                getWorld().addObject(bullet, getX()+55, getY()-18);
            }
            else if(getImage()==WalkL || getImage()==Walk1L || getImage()==Walk2L || getImage()==Walk3L || getImage()==Walk4L || getImage()==Walk5L || getImage()==Walk6L || getImage()==Walk7L || getImage()==Walk8L )
            {
                bullet.setRotation(180);
                getWorld().addObject(bullet, getX()-55, getY()-18);
            }
        }               
    }
    
    /**
     * Dies first
     */
    public void fall()
    {
        if(getImage()==WalkR || getImage()==Walk1 || getImage()==Walk2 || getImage()==Walk3 || getImage()==Walk4 || getImage()==Walk5 || getImage()==Walk6 || getImage()==Walk7 || getImage()==Walk8)
        {
            setImage(die1L);
            //falldown();
        }

        if(getImage()==WalkL || getImage()==Walk1L || getImage()==Walk2L || getImage()==Walk3L || getImage()==Walk4L || getImage()==Walk5L || getImage()==Walk6L || getImage()==Walk7L || getImage()==Walk8L)       
        {
            setImage(die1);
            //falldown();
        }
        
    }
    
    public void falldown()
    {
        if(getImage()==die1L)
        {
            setImage(die2L);
        }
        else if(getImage()==die2L)
        {
            setImage(die3L);
        }
        else if(getImage()==die3L)
        {
            setImage(die4L);
        }
        else if(getImage()==die4L)
        {
            setImage(die5L);
        }
        else if(getImage()==die5L)
        {
            setImage(die6L);
        }
        else if(getImage()==die6L)
        {
            setImage(die7L);
        }
        else if(getImage()==die7L)
        {
            setImage(die8L);
            setLocation(getX(),getY()+2);
        }
        
        if(getImage()==die1)
        {
            setImage(die2);
        }
        else if(getImage()==die2)
        {
            setImage(die3);
        }
        else if(getImage()==die3)
        {
            setImage(die4);
        }
        else if(getImage()==die4)
        {
            setImage(die5);
        }
        else if(getImage()==die5)
        {
            setImage(die6);
        }
        else if(getImage()==die6)
        {
            setImage(die7);
        }
        else if(getImage()==die7)
        {
            setImage(die8);
            setLocation(getX(),getY()+2);
        }
    }
    
    
    public void revive()
    {
        if(getImage()==die8L)
        {
            setImage(dazed1L);

        }
        else if(getImage()==dazed1L)
        {
            setImage(dazed2L);
            
        }
        else if(getImage()==dazed2L)
        {
            setImage(dazed3L);
            
        }
        else if(getImage()==dazed3L)
        {
            setImage(dazed4L);

        }
        else if(getImage()==dazed4L)
        {
            setImage(dazed5L);
            setLocation(getX(),getY()-up);
        }
        else if(getImage()==dazed5L)
        {
            setImage(dazed6L);
            setLocation(getX(),getY()-up);
        }
        else if(getImage()==dazed6L)
        {
            setImage(dazed7L);
             setLocation(getX(),getY()-up);
        }
        else if(getImage()==dazed7L)
        {
            setImage(WalkR);
             setLocation(getX(),getY()-up);
        }
        
        if(getImage()==die8)
        {
            setImage(dazed1);
             
        }
        else if(getImage()==dazed1)
        {
            setImage(dazed2);
             
        }
        else if(getImage()==dazed2)
        {
            setImage(dazed3);
            
        }
        else if(getImage()==dazed3)
        {
            setImage(dazed4);
  
        }
        else if(getImage()==dazed4)
        {
            setImage(dazed5);
            setLocation(getX(),getY()-up);
        }
        else if(getImage()==dazed5)
        {
            setImage(dazed6);
            setLocation(getX(),getY()-up);
        }
        else if(getImage()==dazed6)
        {
            setImage(dazed7);
             setLocation(getX(),getY()-up);
        }
        else if(getImage()==dazed7)
        {
             setLocation(getX(),getY()-up);
            setImage(WalkL);
        }
    }
    
    
    
    /**
     * Moves Back and Forth like a soldier
     */
    public void patrol()
    {
        if(getImage()==WalkR)
            {
                setImage(Walk1);
                move(speed);
            }
            else if(getImage()==Walk1)
            {
                setImage(Walk2);
                move(speed);
            }
            else if(getImage()==Walk2)
            {
                setImage(Walk3);
                move(speed);
            }
            else if(getImage()==Walk3)
            {
                setImage(Walk4);
                move(speed);
            }
            else if(getImage()==Walk4)
            {
                setImage(Walk5);
                move(speed);
            }
            else if(getImage()==Walk5)
            {
                setImage(Walk6);
                move(speed);
            }
            else if(getImage()==Walk6)
            {
                setImage(Walk7);
                move(speed);
            }
            else if(getImage()==Walk7)
            {
                setImage(Walk8);
                move(speed);
            }
            else if(getImage()==Walk8)
            {
                setImage(Walk1);
                move(speed);
            }
     if(atWorldEdge())
            {
                setImage(WalkL);
                move(-speed);
            }
        if(getImage()==WalkL)
        { 
            move(-speed);
            setImage(Walk1L);
        }
        else if(getImage()==Walk1L)
        {
            move(-speed);
            setImage(Walk2L);
        }
        else if(getImage()==Walk2L)
        {
            move(-speed);
            setImage(Walk3L);
        }
        else if(getImage()==Walk3L)
        {
            move(-speed);
            setImage(Walk4L);
        }
        else if(getImage()==Walk4L)
        {
            move(-speed);
            setImage(Walk5L);
        }
        else if(getImage()==Walk5L)
        {
           move(-speed);
            setImage(Walk6L);
        }
        else if(getImage()==Walk6L)
        {
            move(-speed);
            setImage(Walk7L);
        }
        else if(getImage()==Walk7L)
        {
            move(-speed);
            setImage(Walk8L);
        }
        else if(getImage()==Walk8L)
        {
            move(-speed);
            setImage(WalkL);
        }
        if(atWorldEdge())
            {
                setImage(WalkR);
            }
    }
    
    
    
    
}
