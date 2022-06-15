import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BattleWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BattleWorld extends World
{
    public boolean playerTurn;
    private int time;    
    
    private Pokemon[] enemies;
    private Pokemon pPokemon;
    private Pokemon ePokemon;
    private EnemyPokemon e;
    private PlayerPokemon p;
    
    private BattleButton fightButton;
    private BattleButton bagButton;
    private BattleButton pokeButton;
    private BattleButton runButton;
    private BattleButton[] attackButtons;
    private boolean menuType = false;
    private boolean attacking = false;
    
    private PlayerPokemonHpBar playerHP;
    private EnemyPokemonHpBar enemyHP;
    
    SuperTextBox startText;
    SuperTextBox sendPokemonText;
    /**
     * Constructor for objects of class BattleWorld.
     * 
     */
    public BattleWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 500, 1); 
        setBackground("images/BattleImages/routeBackground.jpeg");
        
        
        
        addObject(new TextBar(), 300, 450);
        addObject(new PlayerPlatform(), 200, 370);
        addObject(new EnemyPlatform(), 450, 200);
        addObject(new Trainer(), 300, 252);
        
        // Generate player and enemy pokemon data as turtwig
        Pokemon t = new Pokemon(); // Turtwig base
        t.staticImg = new GreenfootImage("images/BattleImages/TurtwigBack/0.png");
        t.maxHealth = 15;
        t.health = 15;
        t.moves = new String[1];
        t.moves[0] = "Razor Leaf";
        t.moveDmg = new int[1];
        t.moveDmg[0] = 1;
        t.pokemonSpecies = "Turtwig";
        
        pPokemon = new Pokemon();
        pPokemon.staticImg = t.staticImg;
        pPokemon.maxHealth = t.maxHealth;
        pPokemon.health = t.health;
        pPokemon.moves = t.moves;
        pPokemon.moveDmg = t.moveDmg;
        pPokemon.pokemonSpecies = t.pokemonSpecies;
        
        
        ePokemon = new Pokemon();
        ePokemon.staticImg = t.staticImg;
        ePokemon.maxHealth = t.maxHealth;
        ePokemon.health = t.health;
        ePokemon.moves = t.moves;
        ePokemon.moveDmg = t.moveDmg;
        
        ePokemon.pokemonSpecies = t.pokemonSpecies;
        
        // Scale image smaller
        e = new EnemyPokemon();
        //GreenfootImage image = new GreenfootImage(t.staticImg.toString());
        //image.mirrorHorizontally();
        //image.scale(image.getWidth()/3*2, image.getHeight()/3*2); 
        e.setImage(t.staticImg); 
        addObject(e,450,100);
        
        // Init attackButtons
        attackButtons = new BattleButton[0];
        
        startText = new SuperTextBox("A Wild "+ePokemon.pokemonSpecies+" has appeared!", new Font(false, false, 16), 250);
        sendPokemonText = new SuperTextBox("Go, Turtwig", new Font(false, false, 16), 100);
        
        addObject(startText, 250, 450);
    }
    
    public void addPlayerPokemon(){
        p = new PlayerPokemon();
        p.setImage(pPokemon.staticImg);
        addObject(p, 200,300);
    }
    
    public void mainMenu(){
        
        if (fightButton != null) return;
        
        System.out.println("menu");
        for (int  i =0 ; i < attackButtons.length;i++){
            removeObject(attackButtons[i]);
        }
        fightButton = new BattleButton("Fight");
        bagButton = new BattleButton("Bag");
        pokeButton = new BattleButton("Pokemon");
        runButton = new BattleButton("Run");
        addObject(fightButton, 110, 430);
        addObject(bagButton, 340, 430);
        addObject(pokeButton, 110, 475);
        addObject(runButton, 340, 475);
        
            menuType = false;
    }
    
    public void fightMenu(){
        
        System.out.println("fight");
        removeObject(fightButton);
        fightButton = null;
        removeObject(bagButton);
        removeObject(pokeButton);
        removeObject(runButton);
        
        attackButtons = new BattleButton[pPokemon.moves.length];
        for (int i = 0; i < pPokemon.moves.length; i++ ){
            attackButtons[i] = new BattleButton("Fight");
            if (i <= 1){
                addObject(attackButtons[i], i==0?110:340,430);
            }   else {
                if (i <= 3){
                    addObject(attackButtons[i], i==2?110:340,475);
                }
            }
        }
        
        menuType = true;
    }
    
    public void spawnHpBar(){
        playerHP =  new PlayerPokemonHpBar();
        enemyHP = new EnemyPokemonHpBar();
        addObject(playerHP, 468, 400);
        addObject(enemyHP, 100, 37);
    }
    
    public void act(){
        
        if(Greenfoot.mouseClicked(null) ){
            if (fightButton != null && fightButton.mouseHoveringOver() && !menuType){
                fightMenu();
            }
            
            for (int i = 0; i < attackButtons.length; i++){
                if (attackButtons[i] != null && attackButtons[i].mouseHoveringOver() && menuType){
                    attack(i);
                }
            }
            
        }
        
        if ( attacking && Greenfoot.isKeyDown("escape") && menuType){
            mainMenu();
        }
    }
    
    public void attack(int attack){
        ePokemon.health -= pPokemon.moveDmg[attack];
        
        // Enemy AI
        pPokemon.health -= ePokemon.moveDmg[attack];
    }
    
    
}
