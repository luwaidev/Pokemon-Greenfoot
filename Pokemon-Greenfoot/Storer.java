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
 * Write a description of class Storer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        try{
            fileName = "waitlist.txt";
            s = new Scanner(new File(fileName));
            adder = new Scanner(new File(fileName));
        } catch (FileNotFoundException e)
        {
            System.out.println("File not found");
            System.exit(1);
        }
        //counts the number of lines contained in the file and informs 
        //the user of the total number of guests waiting
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
        value = Integer.parseInt(customers[(x-1)*3+y]);
        /*
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
         */
        return value;
    }

    public static void setSave(int x, int y, int z)
    {
        fileName = "waitlist.txt";
        try{
            s = new Scanner(new File(fileName));
            adder = new Scanner(new File(fileName));
        } catch (FileNotFoundException e)
        {
            System.out.println("File not found");
            System.exit(1);
        }
        //counts the number of lines contained in the file and informs 
        //the user of the total number of guests waiting
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

        //asks the user which guest they would like to remove
        int toBeRemoved = (x-1)*3 + y;
        Integer num = z;
        customers[toBeRemoved] = num.toString();
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
        /*
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
         */
    }
}
