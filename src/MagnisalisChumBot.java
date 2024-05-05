/*
ChumBot:
Attributes
boolean hasParts: Represents if the ChumBot has the parts or not.  Starts as false.
boolean hasChargedBattery Represents if the ChumBot has the battery or not.  Starts as false.
boolean puzzleSolved: Represents if the wiring has been fixed or not.  Starts as false.
Methods
boolean puzzleSolved(): Once you solve the wiring you win the game!
void attachParts(boolean userFound, boolean userParts):  The user attempts to put the parts into the bot.  If they have the parts then hasParts will become true. Otherwise it will stay false.
void insertBatter(boolean userFound, boolean userBattery)  The user attempts to put the battery into the bot.  If they have the battery then hasBattery will become true. Otherwise it will stay false.
 */

public class MagnisalisChumBot
{
    private boolean hasParts;
    private boolean hasChargedBattery;

    public MagnisalisChumBot()
    {
        hasParts = false;
        hasChargedBattery = false;
    }

    public String toString()
    {
        return "hasParts = " + hasParts + "\nhasChargedBattery = " + hasChargedBattery;
    }

    public void look(boolean userFound)
    {
        if(userFound)
        {
            System.out.println("You see a broken robot, it seems like it has been disassembled.");
        }
        else
        {
            System.out.println("What are you trying to look at?");
        }
    }

    public void examine(boolean userFound)
    {
        if(userFound)
        {
            if(hasParts && hasChargedBattery)
            {
                System.out.println("The ChumBot is powered on,\nall you need to do is fix the wiring to get it working.");
                System.out.println("The ChumBot has '378' spray-painted on its torso.");
            }
            else if(hasParts)
            {
                System.out.println("The ChumBot has been re-assembled, but it doesn't have a battery,\nyou must insert one fully charged.");
                System.out.println("The ChumBot has '378' spray-painted on its torso.");
            }
            else if(hasChargedBattery)
            {
                System.out.println("The ChumBot is fully charged but it is missing some parts,\nyou must reassemble it.");
                System.out.println("The ChumBot has '378' spray-painted on its torso.");
            }
            else
            {
                System.out.println("The ChumBot has been disassembled,\nit is missing a charged battery and some parts.");
                System.out.println("The ChumBot has '378' spray-painted on its torso.");
            }
        }
        else
        {
            System.out.println("What are you trying to examine?");
        }
    }

    public void attachParts(boolean userFound, boolean userParts)
    {
        if(userFound)
        {
            if(userParts)
            {
                if(!hasParts)
                {
                    if(!hasChargedBattery)
                    {
                        System.out.println("You attached the parts, the ChumBot is fully assembled,\nhowever it is still missing a charged battery.");
                    }
                    else
                    {
                        System.out.println("You have attached the parts, the ChumBot is fully assembled!");
                        System.out.println("It has been powered on but the it is not working properly, there must be something wrong with the wiring.\n");
                    }
                    hasParts = true;
                }
                else
                {
                    System.out.println("You have already attached the parts,\nthe ChumBot is fully assembled.");
                }
            }
            else
            {
                System.out.println("You need to find some robot parts to reassemble the ChumBot.");
            }
        }
        else
        {
            System.out.println("What are you trying to attach?");
        }
    }
    public void insertBattery(boolean userChargedBattery, boolean userFound)
    {
        if(userFound)
        {
            if(userChargedBattery)
            {
                if(!hasChargedBattery)
                {
                    if(!hasParts)
                    {
                        System.out.println("You inserted the battery, the ChumBot is fully charged,\nhowever the robot is still missing some parts.");
                    }
                    else
                    {
                        System.out.println("You inserted the battery, the ChumBot is fully assembled!");
                        System.out.println("It has been powered on but it is not working properly,\n there must be something wrong with the wiring.\n");
                    }
                    hasChargedBattery = true;
                }
                else
                {
                    System.out.println("You have already inserted a charged battery,\nthe ChumBot is fully charged.");
                }
            }
            else
            {
                System.out.println("You don't have a charged battery.");
            }
        }
        else
        {
            System.out.println("What are you trying to insert?");
        }
    }
    public boolean checkPoweredOn()
    {
        return hasParts && hasChargedBattery;
    }
}