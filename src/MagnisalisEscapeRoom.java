/*
    I allowed the user to substitute the word "examine" for "search" when using the "examine shed" and "examine chest" commands.
    I allowed the user to substitute the word "examine" for "search" and "open" when using the "examine chest".
    I allowed the user to substitute the word "unlock" for "open" when using the "unlock" command.
    I allowed the user to substitute the word "take" for "grab" and "pickup" when using the "take" command.
    I allowed the user to substitute the word "quit" for "exit" when using the "quit" command.
    I allowed the user to substitute the word "help" for "commands", "cmds", and "howto" when using the "help" command.
    I allowed the user to substitute the word "around" for "" when using the "look around" command.
    I allowed the user to substitute the word "chumbot" for "robot" when using the "look chumbot" and "examine chumbot" commands.
    I allowed the user to substitute the word "wiring" for "wires" when using the "fix" command.
    I allowed the user to substiture the word "passcode" for "password" when using the "enter" command.
*/

import java.util.Scanner;

public class MagnisalisEscapeRoom
{
    private boolean userKey;
    private boolean userParts;
    private boolean unchargedBattery;
    private boolean chargedBattery;
    private boolean userFoundChumBot;
    private boolean chumBotPoweredOn;
    private boolean fixedWiring;
    private boolean gameOver;

    private MagnisalisSparePartsChest chest;
    private MagnisalisLockedCabinet cabinet;
    private MagnisalisNastyToilet toilet;
    private MagnisalisFailedDesignsShed shed;
    private MagnisalisChumBot chumBot;
    private MagnisalisCombinationLock lock;
    private MagnisalisWiringPuzzle wiringPuzzle;

    public MagnisalisEscapeRoom()
    {
        userKey = false;
        userParts = false;
        unchargedBattery = false;
        chargedBattery = false;
        userFoundChumBot = false;
        chumBotPoweredOn = false;
        fixedWiring = false;
        gameOver = false;

        chest = new MagnisalisSparePartsChest();
        cabinet = new MagnisalisLockedCabinet();
        toilet = new MagnisalisNastyToilet();
        shed = new MagnisalisFailedDesignsShed();
        chumBot = new MagnisalisChumBot();
        wiringPuzzle = new MagnisalisWiringPuzzle();
        lock = new MagnisalisCombinationLock("378", "3 digits (###)");
    }

    public String toString()
    {
        return "userKey = " + userKey + "\nuserParts = " + userParts + "\nunchargedBattery = " + unchargedBattery + "\nchargedBattery = " + chargedBattery + "\nuserFoundChumBot = " + userFoundChumBot + "\nchumBotPoweredOn = " + chumBotPoweredOn + "fixedWiring = " + fixedWiring + "gameOver = " + gameOver;
    }

    public void menu()
    {
        Scanner scan = new Scanner(System.in);
        String choice;

        System.out.println("Menu: ");
        System.out.println("0. Quit\n1. Play Game\n2. View Credits\n");
        System.out.print("What would you like to do: ");
        choice = scan.nextLine();
        System.out.println("");

        switch(choice)
        {
            case "0":
                System.out.println("Quitting game...");
                System.exit(0);
                break;

            case "1":
                this.play();
                break;

            case "2":
                System.out.println("Credits:");
                System.out.println("Chum Bucket Escape Room Game");
                System.out.println("Created by: Konstantinos Magnisalis\n");
                this.menu();
                break;

            default:
                System.out.println("Invalid choice.  Please try again.\n");
                this.menu();
                break;
        }
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

        System.out.println("Welcome to the Chum Bucket Escape Room!");
        System.out.println("Sheldon J. Plankton has captured you and trapped you in the basement of the Chum Bucket.\nThere is a nasty toilet with a plunger next to it,\na shed, a cabinet, and a chest.\nYou must find a way to escape the Chum Bucket.\n");

        System.out.println("Type \"help\" for a list of commands.\n");

        this.lookAround();

        while(!gameOver)
        {
            System.out.println("===========================================================================");
            System.out.print("Enter a command: ");

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
            else if(verb.equalsIgnoreCase("help") || verb.equalsIgnoreCase("commands") || verb.equalsIgnoreCase("cmds") || verb.equalsIgnoreCase("howto"))
            {
                System.out.println("Commands:");
                System.out.println("look [noun] - Look around or at a specified object");
                System.out.println("examine [noun] - Examines a specified object");
                System.out.println("explain - Explains the game's backstory");
                System.out.println("items - Lists the items you have");
                System.out.println("take [noun] - Picks up a specified object");
                System.out.println("open [noun] - Opens/unlocks a specified object");
                System.out.println("search [noun] - Searches a specified object");
                System.out.println("unlock [noun] - Unlocks a specified object");
                System.out.println("plunge [noun] - Plunges a specified object");
                System.out.println("flush [noun] - Flushes a specified object");
                System.out.println("charge [noun] - Charges a specified object");
                if(fixedWiring)
                    System.out.println("enter passcode - Enter a specific passcode");
                if(userFoundChumBot) {
                    System.out.println("insert [noun] - Inserts a specified object");
                    System.out.println("attach [noun] - Attaches a specified object");
                    System.out.println("fix [noun] - Fix a specific object");
                }
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
                else if(noun.equalsIgnoreCase("chumbot") || noun.equalsIgnoreCase("robot"))
                {
                    chumBot.look(userFoundChumBot);
                }
                else
                {
                    System.out.println("You cannot " + verb + " at '" + noun + "'.");
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
                else if(noun.equalsIgnoreCase("chumbot") || noun.equalsIgnoreCase("robot"))
                {
                    chumBot.examine(userFoundChumBot);
                }
                else
                {
                    System.out.println("You cannot " + verb + " '" + noun + "'.");
                }
            }
            else if(verb.equalsIgnoreCase("explain"))
            {
                System.out.println("You have been captured by Sheldon J. Plankton and trapped in the basement of the Chum Bucket.");
                System.out.println("You must find a way to escape.");
            }
            else if(verb.equalsIgnoreCase("items"))
            {
                System.out.println("You have the following items:");
                if(userKey)
                    System.out.println("Key");
                if(userParts)
                    System.out.println("Spare Robot Parts");
                if(unchargedBattery && !chargedBattery)
                    System.out.println("Battery");
                if(chargedBattery)
                    System.out.println("Charged Battery");
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
                    userFoundChumBot = true;
                }
                else
                {
                    System.out.println("You cannot " + verb + " '" + noun + "'.");
                }
            }
            else if(verb.equalsIgnoreCase("open"))
            {
                if(noun.equalsIgnoreCase("cabinet"))
                {
                    cabinet.unlockCabinet(userKey);
                }
                else if(noun.equalsIgnoreCase("chest"))
                {
                    chest.examine();
                }
                else
                {
                    System.out.println("You cannot " + verb + " '" + noun + "'.");
                }
            }
            else if(verb.equalsIgnoreCase("unlock"))
            {
                if(noun.equalsIgnoreCase("cabinet"))
                {
                    cabinet.unlockCabinet(userKey);
                }
                else
                {
                    System.out.println("You cannot '" + verb + "' " + noun + "'.");
                }
            }
            else if(verb.equalsIgnoreCase("charge"))
            {
                if(noun.equalsIgnoreCase("battery"))
                {
                    cabinet.charge(unchargedBattery);
                    chargedBattery = cabinet.checkCharged();
                }
                else
                {
                    System.out.println("You cannot " + verb + " '" + noun + "'.");
                }
            }
            else if(verb.equalsIgnoreCase("take") || verb.equalsIgnoreCase("grab") || verb.equalsIgnoreCase("pickup"))
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
                else if(noun.equalsIgnoreCase("charger"))
                {
                    System.out.println("You can't take the charger because.");
                }
                else if(noun.equalsIgnoreCase("plunger"))
                {
                    System.out.println("You don't need to take the plunger.");
                }
                else
                {
                    System.out.println("You cannot " + verb + " '" + noun + "'.");
                }
            }
            else if(verb.equalsIgnoreCase("enter"))
            {
                if(noun.equalsIgnoreCase("passcode") || noun.equalsIgnoreCase("password"))
                {
                    lock.unlock(fixedWiring);
                }
                else
                {
                    System.out.println("You cannot " + verb + " '" + noun + "'.");
                }
            }
            else if(verb.equalsIgnoreCase("insert"))
            {
                if(noun.equalsIgnoreCase("battery"))
                {
                    chumBot.insertBattery(chargedBattery, userFoundChumBot);
                }
                else if(noun.equalsIgnoreCase("parts"))
                {
                    System.out.println("You cannot 'insert' parts, did you mean 'attach'?");
                }
                else
                {
                    System.out.println("You cannot " + verb + " '" + noun + "'.");
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
                    System.out.println("You cannot " + verb + " '" + noun + "'.");
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
                    System.out.println("You cannot " + verb + " '" + noun + "'.");
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
                    System.out.println("You cannot " + verb + " '" + noun + "'.");
                }
            }
            else if(verb.equalsIgnoreCase("fix"))
            {
                if(noun.equalsIgnoreCase("wiring") || noun.equalsIgnoreCase("wires"))
                {
                    wiringPuzzle.solvePuzzle(chumBotPoweredOn);
                    fixedWiring = wiringPuzzle.checkPuzzleSolved();
                }
                else
                {
                    System.out.println("You cannot " + verb + " '" + noun + "'.");
                }
            }
            else
            {
                System.out.println("Invalid command, you cannot '" + verb + "' that.\nType \"help\" for a list of commands.");
            }

            if (posSpace != -1)
            {
                int secSpace = noun.indexOf(" ");
                if (secSpace != -1)
                    System.out.println("You can only enter one or two word commands.");
            }

            if(chumBot.checkPoweredOn())
            {
                chumBotPoweredOn = true;
                if(!fixedWiring && !wiringPuzzle.checkCancelled())
                {
                    wiringPuzzle.solvePuzzle(true);
                    fixedWiring = wiringPuzzle.checkPuzzleSolved();
                    wiringPuzzle.checkCancelled();
                }
            }

            if(fixedWiring && !lock.isCancelled())
            {
                lock.unlock(true);
            }

            if(lock.isUnlocked())
            {
                gameOver = true;
            }
        }
        if(lock.isUnlocked())
        {
            System.out.println("ChumBot:  HELLO, I AM CHUMBOT. I AM FULLY OPERATIONAL AND READY TO ASSIST YOU.\n");
            System.out.println("You watch as ChumBot flies straight up through the ceiling, breaking through the roof of the Chum Bucket,\nflying around and back into the ChumBucket and busts down the door enabling you to escape.\nYou walk out the door.\n");
            System.out.println("Congratulations! You have escaped the Chum Bucket!");
            System.out.println("Thank you for playing! I hope you enjoyed the game.");
        }
        else
        {
            System.out.println("GAME OVER: You have failed to escape the Chum Bucket.");
        }
        System.out.println("===========================================================================");
    }
}
