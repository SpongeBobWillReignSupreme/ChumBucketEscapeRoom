/*
Attributes
boolean searched
boolean hasChumBotParts

Methods
void search():  This method changes the searched attribute to true.
boolean takeChumBotParts():  This method changes the hasChumBotParts attribute to false  
*/

public class MagnisalisSparePartsChest
{
    //creating the instance variables
    private boolean searched;
    private boolean hasChumBotParts;
    
    //creating the default constructor
    public MagnisalisSparePartsChest()
    {
        searched = false;
        hasChumBotParts = true;
    }
    
    //creating the accessor and mutator methods
    public boolean getSearched()
    {
        return searched;
    }
    public boolean getHasChumBotParts()
    {
        return hasChumBotParts;
    }
    public void setSearched(boolean s)
    {
        searched = s;
    }
    public void setHasChumBotParts(boolean h)
    {
        hasChumBotParts = h;
    }
    
    //creating the toString
    public String toString()
    {
        String output = "Searched = " + searched + "\nhasParts = " + hasChumBotParts;
        return output;
    }
    
    //creating the look() method
    public void look()
    {
        System.out.println("You see a chest with no lock on it..");
    }
    
    //creating the search() method
    public void examine()
    {
        if(searched)
        {
            if(hasChumBotParts)
            {
                System.out.println("The chest has some spare robot parts in it.");
            }
            else
            {
                System.out.println("You have already searched this.. Nothing to see here!");

            }
        }
        else
        {
            System.out.println("You opened the chest and found some spare robot parts!");
            searched = true;
        }
    }
    
    //creating the takeChumBotParts() method
    public boolean takeChumBotParts()
    {
        if(searched)
        {
            if(hasChumBotParts)
            {
                System.out.println("You took the robot parts from the chest.");
            }
            else
            {
                System.out.println("You already have the robot parts in your hands.");
            }
            hasChumBotParts = false;
            return true;
        }
        else
        {
            System.out.println("What parts are you trying to take?");
            return false;
        }
    }
}