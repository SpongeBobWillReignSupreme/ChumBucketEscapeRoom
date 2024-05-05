/*
Wiring Puzzle

Attributes:
int wiresConnected:  Represents how many wires have been connected
boolean redWire:  Represents if the red wires have been connected
boolean blueWire:  Represents if the blue wires have been connected
boolean greenWire:  Represents if the green wires have been connected
boolean canceled:  Represents if the user has canceled the wiring puzzle

Methods:
void solvePuzzle(boolean chumBotPoweredOn):  This method will display a wiring puzzle image and prompt the user to connect wires of the same color.
*/

import java.util.Scanner;

public class MagnisalisWiringPuzzle
{
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_BLUE = "\u001B[34m";
    private final String ANSI_GREEN = "\u001B[32m";

    private int wiresConnected;
    private boolean redWire;
    private boolean blueWire;
    private boolean greenWire;
    private boolean canceled;
    public MagnisalisWiringPuzzle()
    {
        wiresConnected = 0;
        redWire = false;
        blueWire = false;
        greenWire = false;
        canceled = false;
    }

    public void solvePuzzle(boolean chumBotPoweredOn)
    {
        if(chumBotPoweredOn)
        {
            String puzzleImage = ("####################################\n" +
                    "#####                          #####\n" +
                    "####" + ANSI_BLUE + "=#=#=#=#=#{                 " + ANSI_RESET + "####\n" +
                    "####" + ANSI_BLUE + "             }#=#=#||       " + ANSI_RESET + "####\n" +
                    "####" + ANSI_RED + "   {}" + ANSI_BLUE + "              \\\\=#.    " + ANSI_RESET + "####\n" +
                    "####" + ANSI_GREEN + "#=#" + ANSI_RED + "||" + ANSI_GREEN + "#{    }#=#=\\\\          " + ANSI_RESET + "####\n" +
                    "####" + ANSI_RED + "   \\\\=#=#{      " + ANSI_GREEN + "||" + ANSI_RED + "  }#=#=#=#" + ANSI_RESET + "####\n" +
                    "####" + ANSI_GREEN + "                ||          " + ANSI_RESET + "####\n" +
                    "#####" + ANSI_GREEN + "               {}         " + ANSI_RESET + "#####\n" +
                    "####################################\n");
            Scanner scanner = new Scanner(System.in);
            String input;
            int posSpace;
            String action;
            String color;

            System.out.println("You must connect wires of the same color by using 'connect [color]'.\nEnter 'cancel' to stop fixing the wiring.");

            while(!this.checkPuzzleSolved())
            {
                System.out.println("===========================================================================");

                if(redWire && greenWire)
                {
                    puzzleImage = ("####################################\n" +
                        "#####                          #####\n" +
                        "####" + ANSI_BLUE + "=#=#=#=#=#{                 " + ANSI_RESET + "####\n" +
                        "####" + ANSI_BLUE + "             }#=#=#||       " + ANSI_RESET + "####\n" +
                        "####     " + ANSI_BLUE + "              \\\\=#.    " + ANSI_RESET + "####\n" +
                        "####" + ANSI_GREEN + "#=#=#{=}#=#=#=\\\\            " + ANSI_RESET + "####\n" +
                        "####" + ANSI_RED + "         .#=#=" + ANSI_GREEN + "||" + ANSI_RED + "=#{=}#=#=#=#" + ANSI_RESET + "####\n" +
                        "####" + ANSI_GREEN + "              {}            " + ANSI_RESET + "####\n" +
                        "#####                          #####\n" +
                        "####################################\n");
                }
                else if (redWire && blueWire)
                {
                    puzzleImage = ("####################################\n" +
                        "#####                          #####\n" +
                        "####" + ANSI_BLUE + "=#=#=#=#=#{=}#=#=#||        " + ANSI_RESET + "####\n" +
                        "####" + ANSI_BLUE + "                  \\\\=#.     " + ANSI_RESET + "####\n" +
                        "####                            ####\n" +
                        "####" + ANSI_GREEN + "#=#=#{    }#=#=\\\\           " + ANSI_RESET + "####\n" +
                        "####" + ANSI_RED + "         .#=#=#" + ANSI_GREEN + "||" + ANSI_RED + "#{=}#=#=#=#" + ANSI_RESET + "####\n" +
                        "####" + ANSI_GREEN + "               ||           " + ANSI_RESET + "####\n" +
                        "#####" + ANSI_GREEN + "              {}          " + ANSI_RESET + "#####\n" +
                        "####################################\n");
                }
                else if (greenWire && blueWire)
                {
                    puzzleImage = ("####################################\n" +
                        "#####                          #####\n" +
                        "####" + ANSI_BLUE + "=#=#=#=#=#{=}#=#=#||        " + ANSI_RESET + "####\n" +
                        "####" + ANSI_BLUE + "                  \\\\=#.     " + ANSI_RESET + "####\n" +
                        "####" + ANSI_RED + "   {}" + ANSI_BLUE + "                       " + ANSI_RESET + "####\n" +
                        "####" + ANSI_GREEN + "#=#" + ANSI_RED + "||" + ANSI_GREEN + "#{=}#=#=#=\\\\           " + ANSI_RESET + "####\n" +
                        "####" + ANSI_RED + "   \\\\=#=#{     " + ANSI_GREEN + "||" + ANSI_RED + "   }#=#=#=#" + ANSI_RESET + "####\n" +
                        "####" + ANSI_GREEN + "               {}           " + ANSI_RESET + "####\n" +
                        "#####" + ANSI_GREEN + "                          " + ANSI_RESET + "#####\n" +
                        "####################################\n");
                }
                else if(redWire)
                {
                    puzzleImage = ("####################################\n" +
                        "#####                          #####\n" +
                        "####" + ANSI_BLUE + "=#=#=#=#=#{                 " + ANSI_RESET + "####\n" +
                        "####" + ANSI_BLUE + "             }#=#=#||       " + ANSI_RESET + "####\n" +
                        "####" + ANSI_RED + "     " + ANSI_BLUE + "              \\\\=#.    " + ANSI_RESET + "####\n" +
                        "####" + ANSI_GREEN + "#=#=#{    }#=#=\\\\           " + ANSI_RESET + "####\n" +
                        "####" + ANSI_RED + "         .#=#=#" + ANSI_GREEN + "||" + ANSI_RED + "#{=}#=#=#=#" + ANSI_RESET + "####\n" +
                        "####" + ANSI_GREEN + "               ||           " + ANSI_RESET + "####\n" +
                        "#####" + ANSI_GREEN + "              {}          " + ANSI_RESET + "#####\n" +
                        "####################################\n");
                }
                else if(greenWire)
                {
                    puzzleImage = ("####################################\n" +
                        "#####                          #####\n" +
                        "####" + ANSI_BLUE + "=#=#=#=#=#{                 " + ANSI_RESET + "####\n" +
                        "####" + ANSI_BLUE + "             }#=#=#||       " + ANSI_RESET + "####\n" +
                        "####" + ANSI_RED + "   {}" + ANSI_BLUE + "              \\\\=#.    " + ANSI_RESET + "####\n" +
                        "####" + ANSI_GREEN + "#=#" + ANSI_RED + "||" + ANSI_GREEN + "#{=}#=#=#=\\\\           " + ANSI_RESET + "####\n" +
                        "####" + ANSI_RED + "   \\\\=#=#{     " + ANSI_GREEN + "||" + ANSI_RED + "   }#=#=#=#" + ANSI_RESET + "####\n" +
                        "####" + ANSI_GREEN + "               {}           " + ANSI_RESET + "####\n" +
                        "#####" + ANSI_GREEN + "                          " + ANSI_RESET + "#####\n" +
                        "####################################\n");
                }
                else if(blueWire)
                {
                    puzzleImage = ("####################################\n" +
                        "#####                          #####\n" +
                        "####" + ANSI_BLUE + "=#=#=#=#=#{=}#=#=#||        " + ANSI_RESET + "####\n" +
                        "####" + ANSI_BLUE + "                  \\\\=#.     " + ANSI_RESET + "####\n" +
                        "####" + ANSI_RED + "   {}" + ANSI_BLUE + "                       " + ANSI_RESET + "####\n" +
                        "####" + ANSI_GREEN + "#=#" + ANSI_RED + "||" + ANSI_GREEN + "#{    }#=#=\\\\          " + ANSI_RESET + "####\n" +
                        "####" + ANSI_RED + "   \\\\=#=#{      " + ANSI_GREEN + "||" + ANSI_RED + "  }#=#=#=#" + ANSI_RESET + "####\n" +
                        "####" + ANSI_GREEN + "                ||          " + ANSI_RESET + "####\n" +
                        "#####" + ANSI_GREEN + "               {}         " + ANSI_RESET + "#####\n" +
                        "####################################\n");
                }

                System.out.println(puzzleImage);
                System.out.print("Enter a command: ");

                input = scanner.nextLine();

                System.out.println("You entered: " + input);

                posSpace = input.indexOf(" ");

                if (posSpace == -1)
                {
                    action = input;
                    color = "";
                }
                else
                {
                    action = input.substring(0, posSpace);
                    color = input.substring(posSpace + 1);
                }

                if(action.equalsIgnoreCase("cancel"))
                {
                    System.out.println("You stopped fixing the wiring.");
                    canceled = true;
                    break;
                }
                else if(action.equalsIgnoreCase("connect"))
                {
                    if(color.equalsIgnoreCase("red"))
                    {
                        if(!redWire)
                        {
                            wiresConnected++;
                            System.out.println("You connected the red wire. " + wiresConnected + "/3 wires connected.");
                        }
                        redWire = true;
                    }
                    else if(color.equalsIgnoreCase("blue"))
                    {
                        if(!blueWire)
                        {
                            wiresConnected++;
                            System.out.println("You connected the blue wire. " + wiresConnected + "/3 wires connected.");
                        }
                        blueWire = true;
                    }
                    else if (color.equalsIgnoreCase("green"))
                    {
                        if (!greenWire)
                        {
                            wiresConnected++;
                            System.out.println("You connected the green wire. " + wiresConnected + "/3 wires connected.");
                        }
                        greenWire = true;
                    }
                    else if(color.equalsIgnoreCase(""))
                    {
                        System.out.println("Please enter the color you would like to connect.");
                    }
                    else
                    {
                        System.out.println("There is no " + color + " wire. There is a red, blue, and green wire.");
                    }
                }
                else
                {
                    System.out.println("Invalid action. Please enter 'connect [color]' or 'cancel'.");
                }
                if(wiresConnected >= 3)
                {
                    puzzleImage = ("####################################\n" +
                            "#####                          #####\n" +
                            "####" + ANSI_BLUE + "=#=#=#=#=#{=}#=#=#||        " + ANSI_RESET + "####\n" +
                            "####" + ANSI_BLUE + "                  \\\\=#.     " + ANSI_RESET + "####\n" +
                            "####                            ####\n" +
                            "####" + ANSI_GREEN + "#=#=#{=}#=#=#=\\\\            " + ANSI_RESET + "####\n" +
                            "####" + ANSI_RED + "        .#=#=#" + ANSI_GREEN + "||" + ANSI_RED + "=#{=}#=#=#=#" + ANSI_RESET + "####\n" +
                            "####" + ANSI_GREEN + "              {}            " + ANSI_RESET + "####\n" +
                            "#####                          #####\n" +
                            "####################################");
                    System.out.println("===========================================================================");
                    System.out.println(puzzleImage);
                    System.out.println("\nYou have successfully connected all of the wires!");
                    this.checkPuzzleSolved();
                }
            }
        }
        else
        {
            System.out.println("What wiring are you trying to fix?");
        }
    }
    public boolean checkPuzzleSolved()
    {
        return redWire && blueWire && greenWire;
    }
    public boolean checkCancelled()
    {
        return canceled;
    }
}