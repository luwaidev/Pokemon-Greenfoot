import java.util.Random;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
/**
 * This class saves all the information about save files
 * 
 * @author Nathan Thian
 * @version 06.15.22
 */
public class Storer  
{
    private static Scanner s;
    private static Scanner adder;
    private static Scanner fileNameReader = new Scanner(System.in);
    private static String fileName;
    private static boolean hasFoundFile;
    private static boolean hasMadeDecision = false;
    private static StringTokenizer tokenizer;
    private static String[] customers;
    private static String[] newCustomers;
    private static String add;
    private static int numLines;
    private static boolean moreLines;
    private static boolean addMoreLines;
    private static Scanner all = new Scanner(System.in);
    private static int decision;

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
     * This method returns the save information at the specific save number x and the index y
     */
    public static int getSave(int x, int y)
    {
        //gets the file name and makes two scanners associated with the file
        try{
            fileName = "waitlist.txt";
            s = new Scanner(new File(fileName));
            adder = new Scanner(new File(fileName));
        } catch (FileNotFoundException e)
        {
            System.out.println("File not found");
            System.exit(1);
        }
        //gets the number of lines in the text file and makes an array the size of the number of lines
        numLines = 0;
        moreLines = true;
        while(moreLines)
        {
            try{
                s.nextLine();
                numLines++;
            } catch (NoSuchElementException e)
            {
                moreLines = false;
                customers = new String[numLines];
            }
        }
        //adds each line of the text file as one string in the array
        numLines = 0;
        addMoreLines = true;
        while(addMoreLines)
        {
            try{
                customers[numLines] = adder.nextLine();
                numLines++;
            } catch (NoSuchElementException e)
            {
                addMoreLines = false;
            }
        }
        //returns the string at the specified index of the array as an integer
        value = Integer.parseInt(customers[(x-1)*3+y]);
        return value;
    }

    /**
     * This method changes a value in the specified save file x at index y to be z
     */
    public static void setSave(int x, int y, int z)
    {
        //gets the file and makes two scanners associated with it
        fileName = "waitlist.txt";
        try{
            s = new Scanner(new File(fileName));
            adder = new Scanner(new File(fileName));
        } catch (FileNotFoundException e)
        {
            System.out.println("File not found");
            System.exit(1);
        }
        //counts the number of lines in the file and makes an array the size of the number of lines
        numLines = 0;
        moreLines = true;
        int counter = 1;
        while(moreLines)
        {
            try{
                s.nextLine();
                counter++;
                numLines++;
            } catch (NoSuchElementException e)
            {
                moreLines = false;
                customers = new String[numLines];
            }
        }
        //adds each line of the file to the array
        numLines = 0;
        addMoreLines = true;
        while(addMoreLines)
        {
            try{
                customers[numLines] = adder.nextLine();
                numLines++;
            } catch (NoSuchElementException e)
            {
                addMoreLines = false;
            }
        }
        //changes the value at the specified index of the array to be z
        int toBeRemoved = (x-1)*3 + y;
        Integer num = z;
        customers[toBeRemoved] = num.toString();
        //rewrites the whole text file but with the changed value implemented
        try{
            FileWriter out = new FileWriter(fileName);
            PrintWriter output = new PrintWriter (out);
            s = new Scanner(new File(fileName));
            adder = new Scanner(new File(fileName));
            for(int i = 0;i<numLines;i++)
            {
                output.println(customers[i]);
            }
            output.close();
        } catch (IOException e)
        {
            System.out.println("Error: " + e);
        }
    }
}
