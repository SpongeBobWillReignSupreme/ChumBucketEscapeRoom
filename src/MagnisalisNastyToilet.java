/*
Attributes
boolean hasBattery
boolean badChum
int plungeCount
boolean isFlushed

Methods
void plunge()  increases plunge count by 1.
void flush():  Will change isFlushed to true if the user has plunged at least twice.
boolean takeBattery():   It first checks isFlushed is true and if plunge count == 2. if true then returns true to imply that the battery was taken and sets hasBattery to false. 
*/

public class MagnisalisNastyToilet
{
    //creating the instance variables
    private boolean hasBattery;
    private int plungeCount;
    private boolean isFlushed;
    
    //creating the default constructor
    public MagnisalisNastyToilet()
    {
        hasBattery = true;
        plungeCount = 0;
        isFlushed = false;
    }
    
    //creating the toString
    public String toString()
    {
        String output = "HasBattery = " + hasBattery + "\nPlungeCount = " + plungeCount + "\nisFlushed = " + isFlushed;
        return output;
    }
    
    //creating the accessor and mutator
    public boolean getHasBattery()
    {
        return hasBattery;
    }
    public int getPlungeCount()
    {
        return plungeCount;
    }
    public boolean getIsFlushed()
    {
        return isFlushed;
    }
    public void setHasBattery(boolean b)
    {
        hasBattery = b;
    }
    public void setPlungeCount(int p)
    {
        plungeCount = p;
    }
    public void setIsFlushed(boolean f)
    {
        isFlushed = f;
    }
    
    //creating the look() and examine() methods
    public void look()
    {
        System.out.println("You see a nasty toilet, it is clogged with spoiled chum.\nThere is a usable plunger right next to it. Don't make it overflow!");
    }
    public void examine()
    {
        if(!isFlushed)
            System.out.println("This toilet is clogged with nasty chum. It has been plunged " + plungeCount + " times.");
        else
        {
            if(hasBattery)
                System.out.println("This is an empty toilet, there is a battery at the bottom of the toilet bowl.");
            else
                System.out.println("This is an empty toilet.");
        }
    }
    
    //creating the interesting methods
    public void plunge()
    {
        if(plungeCount < 2)
        {
            plungeCount++;
            if(plungeCount == 1)
            {
                System.out.println("You've plunged the toilet once.");
            }
            else
            {
                System.out.println("You've plunged the toilet twice, you should probably flush.");
            }
        }
        else
        {
            if(!isFlushed)
            {
                System.out.println("You already plunged this toilet twice, you might want to flush now.");
            }
            else
            {
                System.out.println("You already cleared the toilet.");
            }
        }
    }
    public void flush()
    {
        if(!isFlushed)
        {
            if(plungeCount == 2)
            {
                isFlushed = true;
                System.out.println("You cleared the toilet! You see a uncharged battery at the bottom.");
            }
            else
            {
                System.out.println("You flushed the toilet, the spoiled chum water is rising now.");
            }
        }
        else
        {
            System.out.println("You already flushed the toilet, the water in the tank is filling back up.");
        }
    }
    public boolean takeBattery()
    {
        if(isFlushed)
        {
            if(hasBattery)
            {
                System.out.println("You took the battery from the toilet bowl, it is out of charge.");
                hasBattery = false;
            }
            else
            {
                System.out.println("You already took the battery from the toilet bowl.");
            }
            return true;
        }
        else
        {
            System.out.println("What battery are you trying to take?");
            return false;
        }
    }
}