import java.util.Scanner;

public class MagnisalisWiringPuzzle
{
    private String ASNI_RESET = "\u001B[0m";
    private String ANSI_RED = "\u001B[31m";
    private String ANSI_BLUE = "\u001B[34m";
    private String ANSI_GREEN = "\u001B[32m";

    private boolean redWire;
    private boolean blueWire;
    private boolean greenWire;
    private boolean canceled;

    public MagnisalisWiringPuzzle()
    {
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
                    "####" + ANSI_BLUE + "=#=#=#=#=#⁅                 " + ASNI_RESET + "####\n" +
                    "####" + ANSI_BLUE + "             ⁆#=#=#||       " + ASNI_RESET + "####\n" +
                    "####" + ANSI_RED + "   {}" + ANSI_BLUE + "              \\\\=#.    " + ASNI_RESET + "####\n" +
                    "####" + ANSI_GREEN + "#=#" + ANSI_RED + "||" + ANSI_GREEN + "#⁅    ⁆#=#=\\\\          " + ASNI_RESET + "####\n" +
                    "####" + ANSI_RED + "   \\\\=#=#⁅      " + ANSI_GREEN + "||" + ANSI_RED + "  ⁆#=#=#=#" + ASNI_RESET + "####\n" +
                    "####" + ANSI_GREEN + "                ||          " + ASNI_RESET + "####\n" +
                    "#####" + ANSI_GREEN + "               {}         " + ASNI_RESET + "#####\n" +
                    "####################################\n");
            Scanner scanner = new Scanner(System.in);
            String input;
            int posSpace;
            String action;
            String color;
            int wiresConnected = 0;

            System.out.println("You must connect wires of the same color by using 'connect [color]'.\nEnter 'cancel' to stop fixing the wiring.");

            while (chumBotPoweredOn)
            {
                System.out.println("=======================================================================");
                System.out.println(puzzleImage);
                System.out.printf("Enter a command: ");

                input = scanner.nextLine();
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

                if (action.equalsIgnoreCase("cancel"))
                {
                    System.out.println("You stopped fixing the wiring.");
                    canceled = true;
                    break;
                }
                else if (action.equalsIgnoreCase("connect"))
                {
                    if (color.equalsIgnoreCase("red"))
                    {
                        if (!redWire)
                            wiresConnected++;
                        redWire = true;
                    } else if (color.equalsIgnoreCase("blue")) {
                        if (!blueWire)
                            wiresConnected++;
                        blueWire = true;
                    } else if (color.equalsIgnoreCase("green")) {
                        if (!greenWire)
                            wiresConnected++;
                        greenWire = true;
                    } else {
                        System.out.println("There is no " + color + " wire.");
                    }
                } else {
                    System.out.println("You can't do that.");
                }

                if (wiresConnected == 3) {
                    puzzleImage = ("####################################\n" +
                            "#####                          #####\n" +
                            "####" + ANSI_BLUE + "=#=#=#=#=#⁅=⁆#=#=#||        " + ASNI_RESET + "####\n" +
                            "####" + ANSI_BLUE + "                  \\\\=#.     " + ASNI_RESET + "####\n" +
                            "####                            ####\n" +
                            "####" + ANSI_GREEN + "#=#=#⁅=⁆#=#=#=\\\\            " + ASNI_RESET + "####\n" +
                            "####" + ANSI_RED + "        .#=#=#" + ANSI_GREEN + "||" + ANSI_RED + "=#⁅=⁆#=#=#=#" + ASNI_RESET + "####\n" +
                            "####" + ANSI_GREEN + "              {}            " + ASNI_RESET + "####\n" +
                            "#####                          #####\n" +
                            "####################################\n");
                    System.out.println(puzzleImage);
                    break;
                } else if (redWire && greenWire) {
                    puzzleImage = ("####################################\n" +
                            "#####                          #####\n" +
                            "####" + ANSI_BLUE + "=#=#=#=#=#⁅                 " + ASNI_RESET + "####\n" +
                            "####" + ANSI_BLUE + "             ⁆#=#=#||       " + ASNI_RESET + "####\n" +
                            "####     " + ANSI_BLUE + "              \\\\=#.    " + ASNI_RESET + "####\n" +
                            "####" + ANSI_GREEN + "#=#=#⁅=⁆#=#=#=\\\\            " + ASNI_RESET + "####\n" +
                            "####" + ANSI_RED + "         .#=#=" + ANSI_GREEN + "||" + ANSI_RED + "=#⁅=⁆#=#=#=#" + ASNI_RESET + "####\n" +
                            "####" + ANSI_GREEN + "              {}            " + ASNI_RESET + "####\n" +
                            "#####                          #####\n" +
                            "####################################\n");
                } else if (redWire && blueWire) {
                    puzzleImage = ("####################################\n" +
                            "#####                          #####\n" +
                            "####" + ANSI_BLUE + "=#=#=#=#=#⁅=⁆#=#=#||        " + ASNI_RESET + "####\n" +
                            "####" + ANSI_BLUE + "                  \\\\=#.     " + ASNI_RESET + "####\n" +
                            "####                            ####\n" +
                            "####" + ANSI_GREEN + "#=#=#⁅    ⁆#=#=\\\\           " + ASNI_RESET + "####\n" +
                            "####" + ANSI_RED + "         .#=#=#" + ANSI_GREEN + "||" + ANSI_RED + "#⁅=⁆#=#=#=#" + ASNI_RESET + "####\n" +
                            "####" + ANSI_GREEN + "               ||           " + ASNI_RESET + "####\n" +
                            "#####" + ANSI_GREEN + "              {}          " + ASNI_RESET + "#####\n" +
                            "####################################\n");
                } else if (greenWire && blueWire) {
                    puzzleImage = ("####################################\n" +
                            "#####                          #####\n" +
                            "####" + ANSI_BLUE + "=#=#=#=#=#⁅=⁆#=#=#||        " + ASNI_RESET + "####\n" +
                            "####" + ANSI_BLUE + "                  \\\\=#.     " + ASNI_RESET + "####\n" +
                            "####" + ANSI_RED + "   {}" + ANSI_BLUE + "                       " + ASNI_RESET + "####\n" +
                            "####" + ANSI_GREEN + "#=#" + ANSI_RED + "||" + ANSI_GREEN + "#⁅=⁆#=#=#=\\\\           " + ASNI_RESET + "####\n" +
                            "####" + ANSI_RED + "   \\\\=#=#⁅     " + ANSI_GREEN + "||" + ANSI_RED + "   ⁆#=#=#=#" + ASNI_RESET + "####\n" +
                            "####" + ANSI_GREEN + "               {}           " + ASNI_RESET + "####\n" +
                            "#####" + ANSI_GREEN + "                          " + ASNI_RESET + "#####\n" +
                            "####################################\n");
                } else if (redWire) {
                    puzzleImage = ("####################################\n" +
                            "#####                          #####\n" +
                            "####" + ANSI_BLUE + "=#=#=#=#=#⁅                 " + ASNI_RESET + "####\n" +
                            "####" + ANSI_BLUE + "             ⁆#=#=#||       " + ASNI_RESET + "####\n" +
                            "####" + ANSI_RED + "     " + ANSI_BLUE + "              \\\\=#.    " + ASNI_RESET + "####\n" +
                            "####" + ANSI_GREEN + "#=#=#⁅    ⁆#=#=\\\\           " + ASNI_RESET + "####\n" +
                            "####" + ANSI_RED + "         .#=#=#" + ANSI_GREEN + "||" + ANSI_RED + "#⁅=⁆#=#=#=#" + ASNI_RESET + "####\n" +
                            "####" + ANSI_GREEN + "               ||           " + ASNI_RESET + "####\n" +
                            "#####" + ANSI_GREEN + "              {}          " + ASNI_RESET + "#####\n" +
                            "####################################\n");
                } else if (greenWire) {
                    puzzleImage = ("####################################\n" +
                            "#####                          #####\n" +
                            "####" + ANSI_BLUE + "=#=#=#=#=#⁅                 " + ASNI_RESET + "####\n" +
                            "####" + ANSI_BLUE + "             ⁆#=#=#||       " + ASNI_RESET + "####\n" +
                            "####" + ANSI_RED + "   {}" + ANSI_BLUE + "              \\\\=#.    " + ASNI_RESET + "####\n" +
                            "####" + ANSI_GREEN + "#=#" + ANSI_RED + "||" + ANSI_GREEN + "#⁅=⁆#=#=#=\\\\           " + ASNI_RESET + "####\n" +
                            "####" + ANSI_RED + "   \\\\=#=#⁅     " + ANSI_GREEN + "||" + ANSI_RED + "   ⁆#=#=#=#" + ASNI_RESET + "####\n" +
                            "####" + ANSI_GREEN + "               {}           " + ASNI_RESET + "####\n" +
                            "#####" + ANSI_GREEN + "                          " + ASNI_RESET + "#####\n" +
                            "####################################\n");
                } else if (blueWire) {
                    puzzleImage = ("####################################\n" +
                            "#####                          #####\n" +
                            "####" + ANSI_BLUE + "=#=#=#=#=#⁅=⁆#=#=#||        " + ASNI_RESET + "####\n" +
                            "####" + ANSI_BLUE + "                  \\\\=#.     " + ASNI_RESET + "####\n" +
                            "####" + ANSI_RED + "   {}" + ANSI_BLUE + "                       " + ASNI_RESET + "####\n" +
                            "####" + ANSI_GREEN + "#=#" + ANSI_RED + "||" + ANSI_GREEN + "#⁅    ⁆#=#=\\\\          " + ASNI_RESET + "####\n" +
                            "####" + ANSI_RED + "   \\\\=#=#⁅      " + ANSI_GREEN + "||" + ANSI_RED + "  ⁆#=#=#=#" + ASNI_RESET + "####\n" +
                            "####" + ANSI_GREEN + "                ||          " + ASNI_RESET + "####\n" +
                            "#####" + ANSI_GREEN + "               {}         " + ASNI_RESET + "#####\n" +
                            "####################################\n");
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
    public boolean checkCanceled()
    {
        return canceled;
    }
}
