/**
 * Write a description of class Storer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Storer  
{
    private static int value;
    //note locations x and y in these arrays go off the grid not actual location
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
    
    public static int getSave(int x, int y)
    {
        if(x == 1)
        {
            value = saveOne[y];
        } else if(x == 2)
        {
            value = saveTwo[y];
        } else if(x == 3)
        {
            value = saveThree[y];
        } else if(x == 4)
        {
            value = saveFour[y];
        }
        return value;
    }
    
    public static void setSave(int x, int y, int z)
    {
        if(x == 1)
        {
            saveOne[y] = z;
        } else if(x == 2)
        {
            saveTwo[y] = z;
        } else if(x == 3)
        {
            saveThree[y] = z;
        } else if(x == 4)
        {
            saveFour[y] = z;
        }
    }
}
