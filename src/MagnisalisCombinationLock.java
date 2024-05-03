import javax.swing.*;

// required - must use this class at least once
public class MagnisalisCombinationLock
{
    private String hint;
    private  String combination;
    private boolean openFlag;

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
    public boolean unlock()
    {
        // If the lock is already open, nothing should be done.
        if (openFlag) return openFlag;

        // Prompt the player for the combination
        while(!openFlag)
        {
            System.out.println("=================================================================");
            String enteredCombination = JOptionPane.showInputDialog("Hint: " + hint + "\nPlease enter the passcode:  ");

            // Check if the combination is correct
            if(enteredCombination != null && enteredCombination.equals(combination))
            {
                // The combination is correct.
                openFlag = true;
                System.out.println("Passcode accepted!\n");
            }
            else
            {
                // The combination is incorrect.
                System.out.println("Incorrect passcode.  Please try again.");
            }
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
} // end class CombinationLock
