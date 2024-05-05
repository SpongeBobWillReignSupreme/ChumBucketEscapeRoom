import java.util.Scanner;

// required - must use this class at least once
public class CombinationLock
{
    // For ANSI color codes
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_GREEN = "\u001B[32m";

    // Instance variables
    private String hint;
    private String combination;
    private boolean openFlag;
    private boolean canceled;

    // Constructor
    // The combination is required when creating this object
    // The hint is also required.  This can be something like the format for what should be entered.
    //    For example:  (format: ##-##-##)
    //    Leave the hint blank if you don't want to use this.
    public CombinationLock(String argCombination)
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
    public CombinationLock(String argCombination, String argHint)
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

            while(!openFlag)
            {
                System.out.println("===========================================================================\n" +
                        "//==================================\\\\\n" +
                        "||       PL-TECH BIOS ver 1.4       ||\n" +
                        "||                                  ||\n" +
                        "||CHUMBOT SYSTEMS BOOTING UP...     ||\n" +
                        "||SYSTEMS BOOTED[                   ||\n" +
                        "||CHUMBOT SECURITY SYSTEM:          ||\n" +
                        "||ENTER 'cancel' TO ABORT]          ||\n" +
                        "||                                  ||\n" +
                        "||Hint: " + hint + "              ||\n" +
                        "||PLEASE ENTER THE PASSCODE:        ||\n" +
                        "||                                  ||\n" +
                        "\\\\==================================//\n");
                String enteredCombination = (in.nextLine());
                System.out.println("You entered: '" + enteredCombination + "'");

                // Check if the combination is correct
                if(enteredCombination.equals(combination))
                {
                    // The combination is correct.
                    openFlag = true;
                    System.out.println("===========================================================================\n" +
                            "//===================================\\\\\n" +
                            "||       PL-TECH BIOS ver 1.4        ||\n" +
                            "||                                   ||\n" +
                            "||CHUMBOT SYSTEMS BOOTING UP...      ||\n" +
                            "||SYSTEMS BOOTED[                    ||\n" +
                            "||CHUMBOT SECURITY SYSTEM:           ||\n" +
                            "||ENTER 'cancel' TO ABORT]           ||\n" +
                            "||                                   ||\n" +
                            "||Hint: " + hint + "               ||\n" +
                            "||PLEASE ENTER THE PASSCODE:  " + ANSI_GREEN + "378" + ANSI_RESET + "    ||\n" +
                            "||" + ANSI_GREEN + "PASSCODE ACCEPTED!" + ANSI_RESET + "                 ||\n" +
                            "\\\\===================================//\n");
                }
                else if(enteredCombination.equals("cancel"))
                {
                    // The player wants to cancel.
                    System.out.println("===========================================================================\n" +
                            "//===================================\\\\\n" +
                            "||       PL-TECH BIOS ver 1.4        ||\n" +
                            "||                                   ||\n" +
                            "||CHUMBOT SYSTEMS BOOTING UP...      ||\n" +
                            "||SYSTEMS BOOTED[                    ||\n" +
                            "||CHUMBOT SECURITY SYSTEM:           ||\n" +
                            "||ENTER 'cancel' TO ABORT]           ||\n" +
                            "||                                   ||\n" +
                            "||Hint: " + hint + "               ||\n" +
                            "||PLEASE ENTER THE PASSCODE:         ||\n" +
                            "||" + ANSI_RED + "ENTER PASSCODE ABORTED." + ANSI_RESET + "           ||\n" +
                            "\\\\===================================//\n");
                    canceled = true;
                    break;
                }
                else
                {
                    // The combination is incorrect.
                    System.out.println("===========================================================================\n" +
                            "//===================================\\\\\n" +
                            "||       PL-TECH BIOS ver 1.4        ||\n" +
                            "||                                   ||\n" +
                            "||CHUMBOT SYSTEMS BOOTING UP...      ||\n" +
                            "||SYSTEMS BOOTED[                    ||\n" +
                            "||CHUMBOT SECURITY SYSTEM:           ||\n" +
                            "||ENTER 'cancel' TO ABORT]           ||\n" +
                            "||                                   ||\n" +
                            "||Hint: " + hint + "               ||\n" +
                            "||PLEASE ENTER THE PASSCODE:         ||\n" +
                            "||" + ANSI_RED + "INVALID PASSWORD. PLEASE TRY AGAIN." + ANSI_RESET + "||\n" +
                            "\\\\===================================//\n");
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
