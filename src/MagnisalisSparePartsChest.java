/*
Spare Parts Chest

Attributes:
boolean searched
boolean containsChumBotParts

Methods:
void examine():  This method changes the searched attribute to true.
boolean takeChumBotParts():  This method changes the containsChumBotParts attribute to false
*/

public class MagnisalisSparePartsChest
{
    //creating the instance variables
    private boolean searched;
    private boolean containsChumBotParts;
    
    //creating the default constructor
    public MagnisalisSparePartsChest()
    {
        searched = false;
        containsChumBotParts = true;
    }
    
    //creating the toString()
    public String toString()
    {
        return "searched = " + searched + "\ncontainsParts = " + containsChumBotParts;
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
            if(containsChumBotParts)
            {
                System.out.println("There are some spare robot parts in the chest.");
            }
            else
            {
                System.out.println("You have already searched this. Nothing to see here..");
            }
        }
        else
        {
            System.out.println("The chest is covered in barnacles and treasure.\nYou opened the chest and found some spare robot parts!");
            searched = true;
        }
    }
    
    //creating the takeChumBotParts() method
    public boolean takeChumBotParts()
    {
        if(searched)
        {
            if(containsChumBotParts)
            {
                System.out.println("You took the robot parts from the chest.");
            }
            else
            {
                System.out.println("You already have the robot parts in your hand.");
            }
            containsChumBotParts = false;
            return true;
        }
        else
        {
            System.out.println("What parts are you trying to take?");
            return false;
        }
    }
}