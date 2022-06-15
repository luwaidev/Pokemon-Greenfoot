/**
 * This class saves all the information about save files
 * 
 * @author Nathan Thian
 * @version 06.15.22
 */
public class Storer  
{
    //value that is returned...just initializing
    private static int value;
    //note locations x and y in these arrays go off the grid not actual location
    //intializes every save file array to be -1 so that it be detected as empty
    private static int[] saveOne = {-1,-1,-1};
    private static int[] saveTwo = {-1,-1,-1};
    private static int[] saveThree = {-1,-1,-1};
    private static int[] saveFour = {-1,-1,-1};
    

    /**
     * Constructor for objects of class Storer
     */
    public Storer()
    {
    }
    
    /**
     * returns the save file information at specified points
     * x is the save file number (1,2,3,4)
     * y is the index of the save file's array
     * (0 is x location)
     * (1 is y location)
     * (3 is pokemon health)
     */
    public static int getSave(int x, int y)
    {
        //if the first save file is the one selected...
        if(x == 1)
        {
            //return integer stored at index y of the first array
            value = saveOne[y];
        } else if(x == 2)
        {
            //if the second save file is the one selected...
            //return integer stored at index y of the second array
            value = saveTwo[y];
        } else if(x == 3)
        {
            //if the third save file is the one selected...
            //return integer stored at index y of the third array
            value = saveThree[y];
        } else if(x == 4)
        {
            //if the fourth save file is the one selected...
            //return integer stored at index y of the fourth array
            value = saveFour[y];
        }
        return value;
    }
    
    /**
     * This method sets the integers in the specified array to the specified integer
     * used when creating/overwriting save files
     * x is the save file number (1,2,3,4)
     * y is the index of the save file (what each one represents specified above)
     * z is the integer that is being inserted
     */
    public static void setSave(int x, int y, int z)
    {
        //if first save file array is chosen
        if(x == 1)
        {
            //sets the integer at index y to be z at this array
            saveOne[y] = z;
        } else if(x == 2)
        {
            //if second save file array is chosen
            //sets the integer at index y to be z at this array
            saveTwo[y] = z;
        } else if(x == 3)
        {
            //if third save file array is chosen
            //sets the integer at index y to be z at this array
            saveThree[y] = z;
        } else if(x == 4)
        {
            //if fourth save file array is chosen
            //sets the integer at index y to be z at this array
            saveFour[y] = z;
        }
    }
}
