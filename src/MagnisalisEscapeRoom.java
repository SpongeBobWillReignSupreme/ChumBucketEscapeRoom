/*
    I allowed the user to substitute the word "open" for "unlock" when using the command "unlock [noun]".
    I allowed the user to substitute the word "grab" for "take" when using the command "take [noun]".
    I allowed the user to substitute the word "exit" for "quit" when using the command "quit".
    I allowed the user to substitute the word "commands" for "help" when using the command "help".
    I allowed the user to substitute the word "around" for nothing when using the command "look [noun]".
*/

import java.util.Scanner;

public class MagnisalisEscapeRoom
{
    private boolean userKey;
    private boolean userParts;
    private boolean unchargedBattery;
    private boolean chargedBattery;
    private boolean userFoundChumBot;
    private boolean gameOver;

    private MagnisalisSparePartsChest chest;
    private MagnisalisLockedCabinet cabinet;
    private MagnisalisNastyToilet toilet;
    private MagnisalisFailedDesignsShed shed;
    private MagnisalisChumBot chumBot;

    public MagnisalisEscapeRoom()
    {
        userKey = false;
        userParts = false;
        unchargedBattery = false;
        chargedBattery = false;
        userFoundChumBot = false;
        gameOver = false;

        chest = new MagnisalisSparePartsChest();
        cabinet = new MagnisalisLockedCabinet();
        toilet = new MagnisalisNastyToilet();
        shed = new MagnisalisFailedDesignsShed();
        chumBot = new MagnisalisChumBot();
    }

    public String toString()
    {
        String output = "userKey = " + userKey + "\nuserParts = " + userParts + "\nunchargedBattery = " + unchargedBattery + "\nchargedBattery = " + chargedBattery + "\nuserFoundChumBot = " + userFoundChumBot;
        return output;
    }

    public void lookAround()
    {
        chest.look();
        cabinet.look();
        toilet.look();
        shed.look();
        if(userFoundChumBot)
            chumBot.look(true);
    }

    public void play()
    {
        String input;
        Scanner scan = new Scanner(System.in);
        String verb;
        String noun;
        int posSpace;

        System.out.println("Welcome to the ChumBucket Escape Room!");
        System.out.println("Sheldon J. Plankton has captured you and trapped you in the basement of the Chum Bucket.\nThere is a nasty toilet with a plunger next to it,\na shed, a cabinet, and a chest.\nYou must find a way to escape the Chum Bucket.\n");

        System.out.println("Type \"help\" for a list of commands.\n");

        this.lookAround();

        while(!gameOver)
        {
            System.out.println("=========================================");
            System.out.printf("Enter a command: ");

            input = scan.nextLine();
            System.out.println("You entered: " + input);
            posSpace = input.indexOf(" ");

            if(posSpace == -1)
            {
                verb = input;
                noun = "";
            }
            else
            {
                verb = input.substring(0, posSpace);
                noun = input.substring(posSpace + 1);
            }

            if(verb.equalsIgnoreCase("quit") || verb.equalsIgnoreCase("exit"))
            {
                gameOver = true;
                System.out.println("Quitting game...");
            }
            else if(verb.equalsIgnoreCase("help") || verb.equalsIgnoreCase("commands"))
            {
                System.out.println("Commands:");
                System.out.println("look [noun] - Look around or at a specific object");
                System.out.println("examine [noun] - Examine a specific object");
                System.out.println("search [noun] - Search a specific object");
                System.out.println("unlock [noun] - Unlock a specific object");
                System.out.println("charge [noun] - Charge a specific object");
                System.out.println("take [noun] - Pick up a specific object");
                System.out.println("insert [noun] - Insert a specific object");
                System.out.println("attach [noun] - Attach a specific object");
                System.out.println("plunge [noun] - Plunge a specific object");
                System.out.println("flush [noun] - Flush a specific object");
                System.out.println("fix [noun] - Fix a specific object");
                System.out.println("quit");
            }
            else if(verb.equalsIgnoreCase("look"))
            {
                if(noun.equals("") || noun.equals("around"))
                {
                    this.lookAround();
                }
                else if(noun.equalsIgnoreCase("chest"))
                {
                    chest.look();
                }
                else if(noun.equalsIgnoreCase("cabinet"))
                {
                    cabinet.look();
                }
                else if(noun.equalsIgnoreCase("toilet"))
                {
                    toilet.look();
                }
                else if(noun.equalsIgnoreCase("shed"))
                {
                    shed.look();
                }
                else if(noun.equalsIgnoreCase("chumbot"))
                {
                    chumBot.look(userFoundChumBot);
                }
                else
                {
                    System.out.println("You cannot look at that.");
                }
            }
            else if(verb.equalsIgnoreCase("examine"))
            {
                if(noun.equalsIgnoreCase("chest"))
                {
                    chest.examine();
                }
                else if(noun.equalsIgnoreCase("cabinet"))
                {
                    cabinet.examine();
                }
                else if(noun.equalsIgnoreCase("toilet"))
                {
                    toilet.examine();
                }
                else if(noun.equalsIgnoreCase("shed"))
                {
                    shed.examine();
                    userFoundChumBot = true;
                }
                else if(noun.equalsIgnoreCase("chumbot"))
                {
                    chumBot.examine(userFoundChumBot);
                }
                else
                {
                    System.out.println("You cannot examine that.");
                }
            }
            else if(verb.equalsIgnoreCase("search"))
            {
                if(noun.equalsIgnoreCase("chest"))
                {
                    chest.examine();
                }
                else if(noun.equalsIgnoreCase("shed"))
                {
                    shed.examine();
                }
                else
                {
                    System.out.println("You cannot search that.");
                }
            }
            else if(verb.equalsIgnoreCase("unlock") || verb.equalsIgnoreCase("open"))
            {
                if(noun.equalsIgnoreCase("cabinet"))
                {
                    cabinet.unlockCabinet(userKey);
                }
                else
                {
                    System.out.println("You cannot unlock that.");
                }
            }
            else if(verb.equalsIgnoreCase("charge"))
            {
                if(noun.equalsIgnoreCase("battery"))
                {
                    chargedBattery = cabinet.charge(unchargedBattery);
                }
                else
                {
                    System.out.println("You cannot charge that.");
                }
            }
            else if(verb.equalsIgnoreCase("take") || verb.equalsIgnoreCase("grab"))
            {
                if(noun.equalsIgnoreCase("battery"))
                {
                   unchargedBattery = toilet.takeBattery();
                }
                else if(noun.equalsIgnoreCase("key"))
                {
                    userKey = shed.takeKey();
                }
                else if(noun.equalsIgnoreCase("parts"))
                {
                    userParts = chest.takeChumBotParts();
                }
                else
                {
                    System.out.println("You cannot take that.");
                }
            }
            else if(verb.equalsIgnoreCase("insert"))
            {
                if(noun.equalsIgnoreCase("battery"))
                {
                    chumBot.insertBattery(chargedBattery, userFoundChumBot);
                }
                else
                {
                    System.out.println("You cannot insert that.");
                }
            }
            else if(verb.equalsIgnoreCase("attach"))
            {
                if(noun.equalsIgnoreCase("parts"))
                {
                    chumBot.attachParts(userFoundChumBot, userParts);
                }
                else
                {
                    System.out.println("You cannot attach that.");
                }
            }
            else if(verb.equalsIgnoreCase("plunge"))
            {
                if(noun.equalsIgnoreCase("toilet"))
                {
                    toilet.plunge();
                }
                else
                {
                    System.out.println("You cannot plunge that.");
                }
            }
            else if(verb.equalsIgnoreCase("flush"))
            {
                if(noun.equalsIgnoreCase("toilet"))
                {
                    toilet.flush();
                }
                else
                {
                    System.out.println("You cannot flush that.");
                }
            }
            else
            {
                System.out.println("Invalid command, you cannot '" + verb + "' that.\nType \"help\" for a list of commands.");
            }

            if(chumBot.getPuzzleSolved())
            {
                gameOver = true;
            }
        }
        if(chumBot.getPuzzleSolved())
        {
            System.out.println("Congratulations! You have escaped the Chum Bucket!");
        }
        else
        {
            System.out.println("GAME OVER: You have failed to escape the Chum Bucket.");
        }
        System.out.println("=========================================");
    }
}
