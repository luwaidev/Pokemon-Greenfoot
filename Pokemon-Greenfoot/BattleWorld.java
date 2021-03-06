import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class BattleWorld here.
 * 
 * @author (Lu-Wai, Max) 
 * @version (a version number or a date)
 */
public class BattleWorld extends World
{
    public boolean playerTurn;
    private int time;    
    
    SoundPlayer soundplayer = new SoundPlayer();
    
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
    public boolean attacking = false;
    
    private PlayerPokemonHpBar playerHP;
    private EnemyPokemonHpBar enemyHP;
    
    SuperTextBox startText;
    SuperTextBox sendPokemonText;
    SuperDisplayLabel pPokemonSpeciesLabel;
    SuperDisplayLabel ePokemonSpeciesLabel;
    
    int x = 0;
    int y = 0;
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
        
        ePokemon= new Pokemon(); // Turtwig base
        ePokemon.staticImg = new GreenfootImage("images/BattleImages/PidgeyFront/0.png");
        ePokemon.maxHealth = 15;
        ePokemon.health = 15;
        ePokemon.moves = new String[1];
        ePokemon.moves[0] = "Gust";
        ePokemon.moveDmg = new int[1];
        ePokemon.moveDmg[0] = 1;
        ePokemon.pokemonSpecies = "Pidgey";
        
        pPokemon = new Pokemon(); // Turtwig base
        pPokemon.staticImg = new GreenfootImage("images/BattleImages/TurtwigBack/0.png");
        pPokemon.maxHealth = 20;
        pPokemon.health = 20;
        pPokemon.moves = new String[2];
        pPokemon.moves[0] = "RazorLeaf";
        pPokemon.moves[1] = "Tackle";
        pPokemon.moveDmg = new int[2];
        pPokemon.moveDmg[0] = 2;
        pPokemon.moveDmg[1] = 1;
        pPokemon.pokemonSpecies = "Turtwig";
        
        // Scale image smaller
        e = new EnemyPokemon();
        //GreenfootImage image = new GreenfootImage(t.staticImg.toString());
        //image.mirrorHorizontally();
        //image.scale(image.getWidth()/3*2, image.getHeight()/3*2); 
        e.setImage(ePokemon.staticImg); 
        addObject(e,460,120);
        
        // Init attackButtons
        attackButtons = new BattleButton[0];
        
        startText = new SuperTextBox("A Wild "+ePokemon.pokemonSpecies+" has appeared!", new Font(false, false, 16), 250);
        sendPokemonText = new SuperTextBox("Go, Turtwig", new Font(false, false, 16), 100);
        
        addObject(startText, 250, 450);
    }
    
    public BattleWorld(int _x,  int _y, int health)
    { 
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 500, 1); 
        setBackground("images/BattleImages/routeBackground.jpeg");
        
        x = _x;
        y = _y;
        
        
        addObject(new TextBar(), 300, 450);
        addObject(new PlayerPlatform(), 200, 370);
        addObject(new EnemyPlatform(), 450, 200);
        addObject(new Trainer(), 300, 252);
        
        // Generate player and enemy pokemon data as turtwig
        
        ePokemon= new Pokemon(); // Pidgey base
        ePokemon.staticImg = new GreenfootImage("images/BattleImages/PidgeyFront/0.png");
        ePokemon.maxHealth = 15;
        ePokemon.health = 15;
        ePokemon.moves = new String[1];
        ePokemon.moves[0] = "Gust";
        ePokemon.moveDmg = new int[1];
        ePokemon.moveDmg[0] = 1;
        ePokemon.pokemonSpecies = "Pidgey";
        
        
        pPokemon = new Pokemon(); // Turtwig base
        pPokemon.staticImg = new GreenfootImage("images/BattleImages/TurtwigBack/0.png");
        pPokemon.maxHealth = 20;
        if (health == 0){
            health = 20;
        }
        pPokemon.health = health;
        pPokemon.moves = new String[2];
        pPokemon.moves[0] = "RazorLeaf";
        pPokemon.moves[1] = "Tackle";
        pPokemon.moveDmg = new int[2];
        pPokemon.moveDmg[0] = 2;
        pPokemon.moveDmg[1] = 1;
        pPokemon.pokemonSpecies = "Turtwig";
        
        // Scale image smaller
        e = new EnemyPokemon();
        //GreenfootImage image = new GreenfootImage(t.staticImg.toString());
        //image.mirrorHorizontally();
        //image.scale(image.getWidth()/3*2, image.getHeight()/3*2); 
        e.setImage(ePokemon.staticImg); 
        addObject(e,460,120);
        
        // Init attackButtons
        attackButtons = new BattleButton[0];
        
        startText = new SuperTextBox("A Wild "+ePokemon.pokemonSpecies+" has appeared!", new Font(false, false, 16), 250);
        sendPokemonText = new SuperTextBox("Go, Turtwig", new Font(false, false, 16), 100);
        
        addObject(startText, 250, 450);
    }
     
    // Add player pokemon sprite to the world
    public void addPlayerPokemon(){
        soundplayer.playWildPokemonBattle();
        p = new PlayerPokemon();
        p.setImage(pPokemon.staticImg);
        addObject(p, 200,300);
    }
    
     // Remove old menu items, place main menu items
    public void mainMenu(){
        pPokemonSpeciesLabel = new SuperDisplayLabel(80, new Font(false, false, 16));
        addObject(pPokemonSpeciesLabel, 430, 275);
        pPokemonSpeciesLabel.update(pPokemon.pokemonSpecies, true);
        ePokemonSpeciesLabel = new SuperDisplayLabel(80, new Font(false, false, 16));
        addObject(ePokemonSpeciesLabel, 100, 110);
        ePokemonSpeciesLabel.update(ePokemon.pokemonSpecies, true);
        
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
    
    // Remove old menu items, place fight menu items in
    public void fightMenu(){
        
        System.out.println("fight");
        removeObject(fightButton);
        fightButton = null;
        removeObject(bagButton);
        removeObject(pokeButton);
        removeObject(runButton);
        
        attackButtons = new BattleButton[pPokemon.moves.length];
        for (int i = 0; i < pPokemon.moves.length; i++ ){
            attackButtons[i] = new BattleButton(pPokemon.moves[i]);
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
    
    // spawn player and enemy hp bars
    public void spawnHpBar(){
        playerHP =  new PlayerPokemonHpBar(pPokemon.maxHealth, pPokemon.health);
        enemyHP = new EnemyPokemonHpBar(ePokemon.maxHealth, ePokemon.health);
        addObject(playerHP, 468, 400);
        addObject(enemyHP, 100, 37);
    }
    
    public void act(){
        // Check for buttons
        if(Greenfoot.mouseClicked(null) && !attacking){
            if (fightButton != null && fightButton.mouseHoveringOver() && !menuType){
                fightMenu();
            } // really wanted to add bag but got too busy and didn't have time
            else if(runButton!=null && runButton.mouseHoveringOver() && !menuType){
                soundplayer.stopWildPokemonBattle();
                returnToWorld();
            }
            
            for (int i = 0; i < attackButtons.length; i++){ // different attack buttons
                if (attackButtons[i] != null && attackButtons[i].mouseHoveringOver() && menuType){
                    attack(i);
                }
            }
            
        }
        
        // Main menu
        if (!attacking && Greenfoot.isKeyDown("escape") && menuType){
            mainMenu();
        }
        
        /*THIS IS FOR THE HP BAR TO WORK DONT TOUCH THIS
         *  BEING USED FOR REFERENCE WHEN ATTACKS HAPPEN 
         
        if(Greenfoot.isKeyDown("a")){
            System.out.println(enemyHP.curHealth);
            enemyHP.curHealth--;
            ePokemon.health--;
            enemyHP.hpBar.update(ePokemon.health);
        }
        */
        
    }
    
    // When attack button is pushed
    int attackCounter = 0;
    public void attack(int attack){
        // Do damage to enemy
        ePokemon.health -= pPokemon.moveDmg[attack];
        enemyHP.curHealth = ePokemon.health;
        enemyHP.hpBar.update(ePokemon.health);
        
        // Hide attack buttons
        for (int  i =0 ; i < attackButtons.length;i++){
            removeObject(attackButtons[i]);
        }
        attacking = true;
        
        // Attack prompt and animation
        SuperTextBox attackText = new SuperTextBox("Your "+ pPokemon.pokemonSpecies + " used " +  pPokemon.moves[attack], new Font(false, false, 16), 250);
        addObject(attackText, 250, 450);
        addObject(new AttackAnimation(), 300, 300);
        
        
    }
    
    
    // For the enemy to attack
    public void enemyAttack(){
        
        // called after attack, should probably be in just a different function but i'm dumb like that
        if (attackCounter >= 1){
            
            // If enemy or player health <=0, play prompt, wait for animation, and then return to menu or world as needed
            if (attackCounter >= 2 && pPokemon.health<=0){
                returnToMenu();
            }   else if (attackCounter >= 2 && ePokemon.health <=0){
                soundplayer.stopWildPokemonBattle();
                returnToWorld();
            }
            if (pPokemon.health <= 0){
                SuperTextBox endText = new SuperTextBox("Your "+ pPokemon.pokemonSpecies + " fainted" , new Font(false, false, 16), 250);
                addObject(endText, 250, 450);
                addObject(new EndBattle(), 800, 800);
                attackCounter++;
            }   else if (ePokemon.health <= 0){
                SuperTextBox endText = new SuperTextBox("The "+ ePokemon.pokemonSpecies + " fainted" , new Font(false, false, 16), 250);
                addObject(endText, 250, 450);
                
                addObject(new EndBattle(), 800, 800);
                attackCounter++;
            }   else {
                attackCounter = 0;
                mainMenu();
                attacking = false;
            }
            return;
        }
        
        
        // Enemy AI (and by ai i mean it just uses the first move)
        pPokemon.health -= ePokemon.moveDmg[0];
        playerHP.curHealth = pPokemon.health;
        playerHP.hpBar.update(pPokemon.health);
        System.out.println(pPokemon.health);
        
        // attack prompt and animation
        SuperTextBox attackText = new SuperTextBox("The "+ ePokemon.pokemonSpecies + " used " +  ePokemon.moves[0], new Font(false, false, 16), 250);
        addObject(attackText, 250, 450);
        addObject(new AttackAnimation(), 75, 500);
        attackCounter++;
        
    }
    
    public void returnToWorld(){
        //initialize the world with save file/generic code's information
        System.out.println(x+","+y);
        Town world = new Town(x,y,pPokemon.health);
        //move to the new world
        Greenfoot.setWorld(world);
    }
    
    public void returnToMenu(){
        //initialize the world with save file/generic code's information
        TitleScreen world = new TitleScreen();
        //move to the new world
        Greenfoot.setWorld(world);
    }
    
    
    
}
