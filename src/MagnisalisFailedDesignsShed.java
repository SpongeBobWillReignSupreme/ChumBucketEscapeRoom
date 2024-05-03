/*
Failed designs shed:
Attributes
boolean hasKey
boolean searched
Methods
void search():  This method changes the searched attribute to true.
boolean takeKey()
*/

public class MagnisalisFailedDesignsShed
{
    private boolean hasKey;
    private boolean searched;

    public MagnisalisFailedDesignsShed()
    {
        hasKey = true;
        searched = false;
    }

    public String toString()
    {
        String output = "hasKey = " + hasKey + "\nsearched = " + searched;
        return output;
    }

    public boolean getHasKey()
    {
        return hasKey;
    }
    public boolean getSearched()
    {
        return searched;
    }
    private void setHasKey(boolean k)
    {
        hasKey = k;
    }
    private void setSearched(boolean s)
    {
        searched = s;
    }

    public void look()
    {
        System.out.println("You see a shed filled with useless contraptions..");
    }
    public void examine()
    {
        if(searched)
        {
            if(hasKey)
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
            if(hasKey)
            {
                System.out.println("You picked up the key.");
                hasKey = false;
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
}
