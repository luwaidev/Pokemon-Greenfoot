import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * This is the titlescreen before you get into the game
 * You can change the save file you want before going into the game
 * 
 * @author Nathan Thian
 * @version June 15, 2022
 */
public class TitleScreen extends World
{
    //the font that is used for everything
    Font boringFont = new Font ("Times New Roman", false, false, 14);

    //class that stores all save information
    Storer storer = new Storer();
    
    //these variables keep track of the mouse's position on the screen
    private int mx = 0;
    private int my = 0;

    //these boxes are the boxes that show selections
    SuperTextBox saveButtonOne;
    SuperTextBox saveButtonTwo;
    SuperTextBox saveButtonThree;
    SuperTextBox saveButtonFour;
    
    //these are variables that will be used to initialize the town world
    private int locationX;
    private int locationY;
    private int pokemonHealth;

    //these arraylists keep track of all the differen types of option buttons for each type of componenet
    ArrayList<SuperTextBox> saveFiles;

    //these rectangles are the shaded boxes that show up on selected options on the screen
    Rectangle saveSelected;

    //this is the background for the titlescreen
    GreenfootImage background = new GreenfootImage("titleBackground.jpg");
    GreenfootImage pokemonPic = new GreenfootImage("Pokemonlogo.png");

    //extra instructions on screen
    Label label2;
    Label label3;

    //used to control the fading in and out of pokemon logo
    private int transparencies;

    //pokemon logo picture
    TitlePictures pokemon;

    //boolean that checks if the intro sequence is over
    private boolean doneIntro;

    //pokemon logo width and height used
    private int pokemonWidth;
    private int pokemonHeight;
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 800x500 cells with a cell size of 1x1 pixels.
        super(800, 500, 1); 

        //sets the background
        setBackground(background);

        //intro has not happened so done intro is false
        doneIntro = false;

        //intialize pokemon logo
        pokemon = new TitlePictures();
        pokemon.setImage(pokemonPic);
        //scale that works best on the picture
        pokemonPic.scale(10,5);
        //added to top left of the world
        addObject(pokemon,0,125);

        //currently logo is transparent
        transparencies = 0;

        //sets width and height of variables according to picture
        pokemonWidth = pokemonPic.getWidth();
        pokemonHeight = pokemonPic.getHeight();

        //gets all the items on screen ready
        prepare();
    }

    /**
     * This method puts pokemon logo onto the screen and makes everything visible after
     */
    public void pokemonOntoScreen()
    {
        //if the pokemon has not reached desired width and height yet...
        if(pokemonWidth < 790)
        {
            //increase width and height to simulate getting bigger
            pokemonWidth+=10;
            pokemonHeight+=5;
            //initializes the pokemon logo image and sets scale accordingly with the object
            GreenfootImage image = new GreenfootImage("Pokemonlogo.png");
            image.scale(pokemonWidth, pokemonHeight);
            pokemon.setImage(image);
        } 
        //pokemon logo gradually moves to the centre of the screen
        if(pokemon.getX() < 400)
        {
            pokemon.move(6);
        }
        //pokemon logo gradually becomes less transparent
        if(transparencies < 253)
        {
            //gradually makes everything less transparent
            transparencies+= 3;
            label2.getImage().setTransparency(transparencies);
            label3.getImage().setTransparency(transparencies);
        } else
        {
            //if all this is done then start putting in options
            doneIntro = true;
            putSelections();
        }
    }

    /**
     * Act loop here keeps track of selections for the game after the intro is done
     */
    public void act()
    {
        if(!doneIntro)
        {
            pokemonOntoScreen();
        }
        else
        {
            //method that checks for user clicking options
            checkForSelection();
            //method that darkens options that have been selected
            showSelection();
            //starts game with selected options if user presses <space>
            startMethod();
        }

    }

    public void putSelections()
    {
        //adding boxes that you can click for customizing
        //sets buttons' values according to which save file they represent
        saveButtonOne = new SuperTextBox("Save One",Color.WHITE, Color.BLACK, boringFont,true,this.getWidth()/10,1,Color.BLACK); 
        saveButtonOne.setValue(1);
        addObject(saveButtonOne, getWidth()/5, getHeight()*5/6);
        saveButtonTwo = new SuperTextBox("Save Two",Color.WHITE, Color.BLACK, boringFont,true,this.getWidth()/10,1,Color.BLACK); 
        saveButtonTwo.setValue(2);
        addObject(saveButtonTwo,getWidth()*2/5, getHeight()*5/6);
        saveButtonThree = new SuperTextBox("Save Three",Color.WHITE, Color.BLACK, boringFont,true,this.getWidth()/10,1,Color.BLACK);
        saveButtonThree.setValue(3);
        addObject(saveButtonThree, getWidth()*3/5, getHeight()*5/6);
        saveButtonFour = new SuperTextBox("Save Four",Color.WHITE, Color.BLACK, boringFont,true,this.getWidth()/10,1,Color.BLACK); 
        saveButtonFour.setValue(4);
        addObject(saveButtonFour,getWidth()*4/5, getHeight()*5/6);

        //first option default to selected
        saveButtonOne.setIsSelected(true);

        //add each button to the corresponding arraylist
        saveFiles = new ArrayList<SuperTextBox>();
        saveFiles.add(saveButtonOne);
        saveFiles.add(saveButtonTwo);
        saveFiles.add(saveButtonThree);
        saveFiles.add(saveButtonFour);

        //creates the grey box that signifies selection on top of the first button
        saveSelected = new Rectangle(saveButtonOne.getWidth(),saveButtonOne.getHeight(), 128);
        addObject(saveSelected,saveButtonOne.getX(),saveButtonOne.getY());
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the labels to show the name of the game
     * as well as how to start
     */
    private void prepare()
    {
        // labels for title and extra labels
        label2 = new Label("Press <space> to start", 40);
        addObject(label2,getWidth()/2,getHeight()*2/4);
        label2.setFillColor(Color.BLACK);
        label2.getImage().setTransparency(0);
        label3 = new Label("Choose your save file", 30);
        label3.setFillColor(Color.BLACK);
        label3.getImage().setTransparency(0);
        addObject(label3,getWidth()/2,getHeight()*3/4);
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
                    //cycle through every button that the checker rectangle is touching
                    for(SuperTextBox test : saveFiles)
                    {
                        //for every button in the world check if that is the button being clicked by the user
                        if(test.equals(box))
                        {
                            //if this specific button is being selected, deselect every  button in the world
                            for(SuperTextBox cherryLabels : saveFiles)
                            {
                                cherryLabels.setIsSelected(false);
                            }
                            //set the one selected button to be the only selected one
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
                for(SuperTextBox yes : saveFiles)
                {
                    if(yes.equals(textBox))
                    {
                        //move the rectangle that darkens the selection to this specific button
                        saveSelected.setLocation(yes.getX(),yes.getY());
                    }
                }
            }
        }
    }

    /**
     * this method will transition the simulation from title screen into the actual game when space bar is pressed
     */
    public void startMethod()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            //loop through every different array of the different components' buttons
            for(SuperTextBox selected : saveFiles)
            {
                //gets the selected box and gets the information from the corresponding save file
                if(selected.checkSelected())
                {
                    //if there is not a save on that save file use generic starting code
                    if(Storer.getSave(selected.getValue(),0) == -1)
                    {
                        locationX = 65;
                    } else
                    {
                        //sets the x location of the player to the specific save file array's index 0
                        locationX = Storer.getSave(selected.getValue(),0);
                    }
                    if(Storer.getSave(selected.getValue(),1) == -1)
                    {
                        locationY = 65;
                    } else
                    {
                        //sets the y location of the player to the specific save file array's index 1
                        locationY = Storer.getSave(selected.getValue(),1);
                    }
                    if(Storer.getSave(selected.getValue(),2) == -1)
                    {
                        pokemonHealth = 100;
                    } else
                    {
                        //sets the current health of the pokemon to the specific save file array's index 2
                        pokemonHealth = Storer.getSave(selected.getValue(),2);
                    }
                }
            }
            //initialize the world with save file/generic code's information
            Town world = new Town(locationX,locationY,pokemonHealth);
            //move to the new world
            Greenfoot.setWorld(world);
        }
    }

    /**
     * This method is called when world is started. It scales pokemon logo image properly
     */
    public void started () {
        pokemonPic.scale(200,100);
    }

    public void stopped () {
    }
}
