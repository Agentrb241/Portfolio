import greenfoot.*;

/**
 * Class MyWorld: sample world to show how to make use of my world super-class SWorld
 */
public class MyWorld extends SWorld
{

    /**
     * Creates a scrolling world using a main actor, a background, some obstacles, and a non-scrolling score.
     */
    public MyWorld()
    {    
        super(400, 400, 1, 1000); // scroll world constructor call; last parameter is scroll width
        // in the following statement, the main actor is placed in the center of the window
        setMainActor(new YODA(), 250, 300); // the int parameters are centered window x and y ranges
        // to start the main actor elsewhere
        mainActor.setLocation(100, 342);
        GreenfootImage bg = new GreenfootImage("DeathStar.png");
        setScrollingBackground(bg); // set the scolling background image
        // add other scrollable objects normally
        
        //Character Storm = new Stormtrooper();
        addObject(new Stormtrooper() , 247, 293);//spawn point of Stormtrooper
        addObject(new Stormtrooper() , 283, 90);
        addObject(new Stormtrooper() , -27, 90);
        //addObject(new Stormtrooper(), 114, 303);
        

        
        //Actor large = new EXTRA();
        //large.getImage().scale(300,10);
        
        
        addObject(new Platform(), 200, 398);
        
        addObject(new Small(), 94,311);
        addObject(new Small(), 99, 198);
        addObject(new Medium(), -50,249);
        addObject(new Medium(), 258, 147);
        addObject(new Small(), 650, 115);
        
        
        //addObject(new EXTRA(), 250, 200);
        //addObject(new Box(), 20, 345);
        // use of the following also adds scrollable objects
        ///addObject(new Box(), 380, 345, true); // the boolean determines scrollable state
        // use the following for non-scrollable objects
        //addObject(new Score(), 40, 390, false);
    }
    
}
