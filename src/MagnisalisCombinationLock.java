import java.util.Scanner;

// required - must use this class at least once
public class MagnisalisCombinationLock
{
    private String hint;
    private String combination;
    private boolean openFlag;
    private boolean canceled;

    // Constructor
    // The combination is required when creating this object
    // The hint is also required.  This can be something like the format for what should be entered.
    //    For example:  (format: ##-##-##)
    //    Leave the hint blank if you don't want to use this.
    public MagnisalisCombinationLock(String argCombination)
    {
        // Set the combination.
        combination = argCombination;

        // Set the hint
        hint = "";

        // This starts out being locked.
        openFlag = false;

        canceled = false;
    } // end constructor
    // The combination is required when creating this object
    // The hint is also required.  This can be something like the format for what should be entered.
    //    For example:  (format: ##-##-##)
    //    Leave the hint blank if you don't want to use this.
    public MagnisalisCombinationLock(String argCombination, String argHint)
    {
        // Set the combination.
        combination = argCombination;

        // Set the hint
        hint = argHint;

        // This starts out being locked.
        openFlag = false;
    } // end constructor

    // This method will prompt the player for the combination and possibly unlock the combination lock.
    // It will return true if successful, false if not.
    public boolean unlock(boolean puzzleSolved)
    {
        if(puzzleSolved)
        {
            // If the lock is already open, nothing should be done.
            if(openFlag) return openFlag;

            // Prompt the player for the combination
            Scanner in = new Scanner(System.in);

            System.out.println("=================================================================");
            System.out.println("CHUMBOT SYSTEMS BOOTING UP...");
            System.out.println("SYSTEMS BOOTED[\nCHUMBOT SECURITY SYSTEM:");

            while(!openFlag)
            {
                System.out.println("=================================================================");
                System.out.print("Hint: " + hint + "\nPLEASE ENTER THE PASSCODE:  ");
                String enteredCombination = (in.nextLine());

                // Check if the combination is correct
                if(enteredCombination.equals(combination))
                {
                    // The combination is correct.
                    openFlag = true;
                    System.out.println("PASSCODE ACCEPTED!\n");
                }
                else if(enteredCombination.equals("cancel"))
                {
                    // The player wants to cancel.
                    System.out.println("ENTER PASSCODE ABORTED.");
                    canceled = true;
                    break;
                }
                else
                {
                    // The combination is incorrect.
                    System.out.println("INVALID PASSWORD. PLEASE TRY AGAIN.");
                }
            }
        }
        else
        {
            System.out.println("What passcode are you trying to enter?");
        }
        // Return the status of the lock.
        return openFlag;
    } // end unlock

    // This method will return the status of the lock.
    // TRUE if unlocked, FALSE if locked.
    public boolean isUnlocked()
    {
        return openFlag;
    } // end isUnlocked

    public boolean isCancelled()
    {
        return canceled;
    }
} // end class CombinationLock
