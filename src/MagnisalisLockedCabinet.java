/*
Attributes
boolean locked
boolean chargerUsed

Methods
void unlockCabinet(boolean userKey) This method changes locked to false
void charge() This method changes the chargerUsed attribute to true
*/

public class MagnisalisLockedCabinet
{
    //creating instance variables
    private boolean locked;
    private boolean chargerUsed;
    
    //creating default constructor
    public MagnisalisLockedCabinet()
    {
        locked = true;
        chargerUsed = false;
    }
    
    //creating accessor and mutator methods
    public boolean getLocked()
    {
        return locked;
    }
    public boolean getChargerUsed()
    {
        return chargerUsed;
    }
    public void setLocked(boolean l)
    {
        locked = l;
    }
    public void setChargerUsed(boolean c)
    {
        chargerUsed = c;
    }
    
    //creating the toString() method
    public String toString()
    {
        return "locked = " + locked + "\nChargerUsed = " + chargerUsed;
    }
    
    //creating the look and examine methods
    public void look()
    {
        if(locked)
            System.out.println("You see a cabinet with a lock on it..");
        else
        {
            System.out.println("You see an unlocked cabinet..");
        }
    }
    public void examine()
    {
        if(locked)
        {
            System.out.println("This is a cabinet with a lock on it. You need to find a key somewhere to unlock it.");
        }
        else
        {
            if(chargerUsed)
            {
                System.out.println("This is an opened cabinet with a used battery charger inside.");
            }
            else
            {
                System.out.println("This is an opened cabinet with an unused battery charger inside. ");
            }
        }
    }
    
    //creating interesting methods
    public void unlockCabinet(boolean userKey)
    {
        if(locked)
        {
            if(userKey)
            {
                System.out.println("You have unlocked the cabinet! You found a large battery charger inside the cabinet.");
                locked = false;
            }
            else
            {
                System.out.println("You cannot open this cabinet because you dont have the key. Look around.");
            }
        }
        else
        {
            System.out.println("You have already opened this.");
        }
    }
    
    public void charge(boolean unchargedBattery)
    {
        if(unchargedBattery)
        {
            if(!locked)
            {
                if(chargerUsed)
                {
                    System.out.println("You have already charged this battery to max.");
                }
                else
                {
                    System.out.println("You charged the large battery.");
                }
                chargerUsed = true;
            }
            else
            {
                System.out.println("You don't have a charger.");
            }
        }
        else
        {
            System.out.println("You don't have a battery to charge.");
        }
    }
    public boolean checkCharged()
    {
        return chargerUsed;
    }
}
