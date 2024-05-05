/*
ChumBot

Attributes:
boolean containsParts:  Represents if the ChumBot has the parts or not, starts as false
boolean containsChargedBattery:  Represents if the ChumBot has the battery or not, starts as false

Methods:
void attachParts(boolean userFound, boolean userParts):  The user attempts to attach the parts to the robot.  If they have the parts then containsParts will become true, otherwise it will stay false.
void insertBatter(boolean userFound, boolean userBattery):  The user attempts to insert the battery into the robot.  If they have the battery then hasBattery will become true, otherwise it will stay false.
 */

public class ChumBot
{
    private boolean containsParts;
    private boolean containsChargedBattery;

    public ChumBot()
    {
        containsParts = false;
        containsChargedBattery = false;
    }

    public String toString()
    {
        return "containsParts = " + containsParts + "\ncontainsChargedBattery = " + containsChargedBattery;
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
            if(containsParts && containsChargedBattery)
            {
                System.out.println("The ChumBot is powered on,\nall you need to do is fix the wiring to get it working.");
                System.out.println("The ChumBot has '378' spray-painted on its torso.");
            }
            else if(containsParts)
            {
                System.out.println("The ChumBot has been reassembled, but it doesn't have a battery,\nyou must insert one fully charged.");
                System.out.println("The ChumBot has '378' spray-painted on its torso.");
            }
            else if(containsChargedBattery)
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
                if(!containsParts)
                {
                    if(!containsChargedBattery)
                    {
                        System.out.println("You attached the parts, the ChumBot is fully assembled,\nhowever it is still missing a charged battery.");
                    }
                    else
                    {
                        System.out.println("You have attached the parts, the ChumBot is fully assembled!");
                        System.out.println("It has been powered on but the it is not working properly,\nthere must be something wrong with the wiring.\n");
                    }
                    containsParts = true;
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
                if(!containsChargedBattery)
                {
                    if(!containsParts)
                    {
                        System.out.println("You inserted the battery, the ChumBot is fully charged,\nhowever it is still missing some parts.");
                    }
                    else
                    {
                        System.out.println("You inserted the battery, the ChumBot is fully assembled!");
                        System.out.println("It has been powered on but it is not working properly,\nthere must be something wrong with the wiring.\n");
                    }
                    containsChargedBattery = true;
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
        return containsParts && containsChargedBattery;
    }
}