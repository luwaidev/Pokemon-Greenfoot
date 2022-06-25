import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class House here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class House extends World
{
    //objects of house 
    GreenfootImage houseBackground = new GreenfootImage("home.png"); 
    
    //objects for scroller
    Scroller scroller; 
    Player scrollActor; 
    
    //object for door
    Door door; 
    
    //X and Y coords set for player 
    static int originalX= 0, originalY = 0; 
    static int x,y; 
    private int gridX, gridY;
    private int pokemonHealth;
    //world constant 
    public static final int HIGH = 400, WIDE = 500; 
    boolean inHouse = true; 
    /**
     * Constructor for objects of class House.
     * 
     */
    public House()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 400, 1);
        this.x = x; 
        this.y = y; 
        
        setBackground(houseBackground); 
        addPlayer();  
        
        door = new Door(); 
        addObject(door, 450, 200); 
    }
    public House(int _x,int _y,int health)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 400, 1);
        this.x = x; 
        this.y = y; 
        gridX = _x;
        gridY = _y;
        setBackground(houseBackground); 
        addPlayer();  
        
        door = new Door(); 
        addObject(door, 450, 200); 
    }
    
    public void addPlayer(){
        scrollActor = new Player(); 
        addObject(scrollActor, 200, 300); 
    }
    
    public void leaveHouse(){
        if(Player.class != null){
            System.out.println("Bruh"); 
            Greenfoot.setWorld(new Town(gridX, gridY, pokemonHealth)); 
        }
    }
}
