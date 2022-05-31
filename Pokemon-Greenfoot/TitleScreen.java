import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * This is the titlescreen before you get into the simulation
 * You can change the number of each element you want inside before the sim starts
 * 
 * @author Nathan Thian
 * @version April 24, 2022
 */
public class TitleScreen extends World
{
    //the font that is used for everything
    Font boringFont = new Font ("Times New Roman", false, false, 14);
    
    //these variables keep track of the mouse's position on the screen
    private int mx = 0;
    private int my = 0;
    
    private boolean boy;
    
    
    SuperTextBox boyButton;
    SuperTextBox girlButton;
    
    //these arraylists keep track of all the differen types of option buttons for each type of componenet
    ArrayList<SuperTextBox> gender;
    
    //these rectangles are the shaded boxes that show up on selected options on the screen
    Rectangle genderSelected;
    
    //this is the background for the titlescreen
    GreenfootImage background = new GreenfootImage("TitleBackground.png");
    
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 800x500 cells with a cell size of 1x1 pixels.
        super(800, 500, 1); 
        
        //sets the background
        //setBackground(background);
        
        //gets all the items on screen ready
        prepare();
        
        //addObject(new SoundPlayer(), 1000, 1000);
    }
    
    /**
     * The main world act loop
     * keeps track of everything that happens and allows user to interact
     */
    public void act()
    {
        //method that checks for user clicking options
        checkForSelection();
        //method that darkens options that have been selected
        showSelection();
        //starts game with selected options if user presses <space>
        startMethod();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the labels to show the name of the game
     * as well as how to start
     */
    private void prepare()
    {
        // labels for title
        Label label = new Label("(more) Trash Pokemon", 50);
        addObject(label,getWidth()/2,getHeight()/4);
        label.setFillColor(Color.BLACK);
        Label label2 = new Label("Press <space> to start", 40);
        addObject(label2,getWidth()/2,getHeight()*2/4);
        label2.setFillColor(Color.BLACK);
        Label label3 = new Label("Choose your gender(based off pokemon plz don't cancel me):", 30);
        label3.setFillColor(Color.BLACK);
        addObject(label3,getWidth()/2,getHeight()*3/4);
        
        //adding boxes that you can click for customizing
        //cherry buttons
        //sets buttons' values corresponding to the values set in the variables created during initialization
        boyButton = new SuperTextBox("Boy",Color.WHITE, Color.BLACK, boringFont,true,this.getWidth()/30,1,Color.BLACK); 
        addObject(boyButton, getWidth()/3, getHeight()*5/6);
        girlButton = new SuperTextBox("Girl",Color.WHITE, Color.BLACK, boringFont,true,this.getWidth()/30,1,Color.BLACK); 
        addObject(girlButton,getWidth()*2/3, getHeight()*5/6);
        
        //first option default to selected
        boyButton.setIsSelected(true);
        
        //add each button to the corresponding arraylist
        gender = new ArrayList<SuperTextBox>();
        gender.add(boyButton);
        gender.add(girlButton);
        
        //creates the grey box that signifies selection on top of the first button
        genderSelected = new Rectangle(boyButton.getWidth(),boyButton.getHeight(), 128);
        addObject(genderSelected,boyButton.getX(),boyButton.getY());
    }
    
    /**
     * This method with activate when the user clicks on a button they want to select
     * and deselect the options that were not chosen
     */
    public void checkForSelection()
    {
        //get all the buttons in the world
        ArrayList<SuperTextBox> allBoxes = (ArrayList<SuperTextBox>) getObjects(SuperTextBox.class);
        for(SuperTextBox here : allBoxes)
        {
            //cycles through all the buttons
            if(Greenfoot.mouseClicked(here))
            {
                //if the mouse is clicked, check where the mouse is
                MouseInfo mouse = Greenfoot.getMouseInfo();
                if(mouse!=null){
                   mx = mouse.getX();
                   my = mouse.getY();
                }
                //create a tiny invisible rectangle at the location of the mouse press 
                Rectangle checker = new Rectangle(1,1,0);
                addObject(checker,mx,my);
                //get all the buttons that the checker rectangle is currently touching; basically whatever the user is trying to select
                ArrayList<SuperTextBox> textBoxes = checker.getIntersectingTextBoxes();
                for(SuperTextBox box : textBoxes)
                {
                    //cycle thrugh every button that the checker rectangle is touching
                    for(SuperTextBox test : gender)
                    {
                        //for every cherry button in the world check if that is the button being clicked by the user
                        if(test.equals(box))
                        {
                            //if this specific cherry button is being selected, deselect every cherry button in the world
                            for(SuperTextBox cherryLabels : gender)
                            {
                                cherryLabels.setIsSelected(false);
                            }
                            //set the one selected cherry button to be the only selected one
                            box.setIsSelected(true);
                        }
                    }
                }
                //remove the rectangle doing the checking
                removeObject(checker);
            }
        }
    }
    
    /**
     * This method will check if buttons are selected and make them darker to show selection
     */
    public void showSelection()
    {
        //get all the buttons in the world
        ArrayList<SuperTextBox> allBoxes = (ArrayList<SuperTextBox>) getObjects(SuperTextBox.class);
        for(SuperTextBox textBox : allBoxes)
        {
            //cycle through every button in the world
            if(textBox.checkSelected())
            {
                //if this specific button is indeed selected...
                for(SuperTextBox yes : gender)
                {
                    //if this specific button is a cherry button
                    if(yes.equals(textBox))
                    {
                        //move the cherry rectangle that darkens the selection to this specific button
                        genderSelected.setLocation(yes.getX(),yes.getY());
                    }
                }
            }
        }
    }
    
    /**
     * this method will transition the simulation from title screen into the actual simulation when space bar is pressed
     */
    public void startMethod()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            //loop through every different array of the different components' buttons
            for(SuperTextBox selected : gender)
            {
                //get the cherry option that is selected and set that button's 
                //value as the value for cherries that will be used in the main world
                if(selected.checkSelected())
                {
                    if(selected==boyButton)
                    {
                        boy = true;
                    } else
                    {
                        boy = false;
                    }
                }
            }
        }
        MyWorld world = new MyWorld(boy);
        Greenfoot.setWorld(world);
    }
    
    public void started () {
        //SoundPlayer.instance.playBackgroundMusic();
    }
    
    
    public void stopped () {
        //SoundPlayer.instance.stopBackgroundMusic();
    }
}
