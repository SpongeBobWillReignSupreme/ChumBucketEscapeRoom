/*
Failed Designs Shed

Attributes:
boolean containsKey
boolean searched

Methods:
void examine():  This method changes the searched attribute to true.
boolean takeKey():  This method changes the containsKey attribute to false
*/

public class MagnisalisFailedDesignsShed
{
    private boolean containsKey;
    private boolean searched;

    public MagnisalisFailedDesignsShed()
    {
        containsKey = true;
        searched = false;
    }

    public String toString()
    {
        return "containsKey = " + containsKey + "\nsearched = " + searched;
    }

    public void look()
    {
        System.out.println("You see a shed filled with useless contraptions..");
    }
    public void examine()
    {
        if(searched)
        {
            if(containsKey)
            {
                System.out.println("There is a shed with a 'ChumBot' inside and a key under it.");
            }
            else
            {
                System.out.println("You have already searched this.. Nothing to see here!");
            }
        }
        else
        {
            System.out.println("You found an obscure robot in the shed with 'ChumBot' and the digits '378'\nspray-painted on it's torso and you found a key under the robot.");
            searched = true;
        }
    }

    public boolean takeKey()
    {
        if(searched)
        {
            if(containsKey)
            {
                System.out.println("You picked up the key.");
                containsKey = false;
            }
            else
            {
                System.out.println("You already have a key.");
            }
            return true;
        }
        else
        {
            System.out.println("What key are you trying to take?");
            return false;
        }
    }

    public boolean checkSearched()
    {
        return searched;
    }
}
