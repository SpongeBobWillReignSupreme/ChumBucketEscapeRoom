
import java.util.HashSet;
import java.util.Set;

public class MagnisalisProjDriver
{
    //writing the main
    public static void main(String[]args)
    {
        //SparePartsChest class
        
        //testing the default constructor
        MagnisalisSparePartsChest c1 = new MagnisalisSparePartsChest();
        
        //testing toString
        System.out.println(c1);
        
        //testing the accessors and mutators
        System.out.println("");
        System.out.println(c1.getSearched());
        System.out.println(c1.getHasChumBotParts());
        c1.setSearched(true);
        System.out.println(c1);
        c1.setHasChumBotParts(true);
        System.out.println(c1);
        
        //testing interesting methods
        System.out.println("");
        c1.look();
        
        c1.examine();
        c1.setSearched(false);
        c1.examine();
        
        boolean parts = c1.takeChumBotParts();
        System.out.println(parts);
        c1.setSearched(false);
        parts = c1.takeChumBotParts();
        System.out.println(parts);
        c1.examine();
        parts = c1.takeChumBotParts();
        System.out.println(parts);
        
        //LockedCabinet class
        
        //testing the default constructor
        System.out.println("");
        MagnisalisLockedCabinet lc1 = new MagnisalisLockedCabinet();
        
        //testing toString
        System.out.println("");
        System.out.println(lc1);
        
        //testing the accessors and mutators
        System.out.println("");
        System.out.println(lc1.getLocked());
        System.out.println(lc1.getChargerUsed());
        lc1.setLocked(true);
        System.out.println(lc1);
        lc1.setChargerUsed(false);
        System.out.println(lc1);
        
        //testing look() and examine() methods
        System.out.println("");
        lc1.look();
        lc1.examine();
        
        //testing the interesting methods
        System.out.println("");
        lc1.charge(true);
        lc1.unlockCabinet(false);
        lc1.unlockCabinet(true);
        lc1.examine();
        lc1.unlockCabinet(true);
        lc1.charge(false);
        lc1.charge(true);
        lc1.examine();
        
        //NastyToilet class
        
        //testing the default constructor
        System.out.println("");
        MagnisalisNastyToilet t1 = new MagnisalisNastyToilet();
        
        //testing the toString
        System.out.println("");
        System.out.println(t1);
        
        //testing the accessor and mutator methods
        System.out.println("");
        System.out.println("HasBattery: " + t1.getHasBattery());
        System.out.println("PlungeCount: " + t1.getPlungeCount());
        System.out.println("IsFlushed: " + t1.getIsFlushed());
        t1.setHasBattery(true);
        t1.setPlungeCount(0);
        t1.setIsFlushed(false);
        
        //testing the look() and examine() methods
        System.out.println("");
        t1.look();
        t1.examine();
        
        //testing the interesting methods
        System.out.println("");
        t1.flush();
        boolean tB = t1.takeBattery();
        System.out.println("tB = " + tB);
        t1.plunge();
        t1.plunge();
        t1.plunge();
        t1.flush();
        t1.plunge();
        t1.flush();
        t1.examine();
        boolean tB2 = t1.takeBattery();
        t1.examine();
        System.out.println("tB2 = " + tB2);

        //MagnisalisEscapeRoom escapeRoom = new MagnisalisEscapeRoom();
        //escapeRoom.lookAround();
        //escapeRoom.play();

        System.out.println("\n");
        MagnisalisWiringPuzzle wiringPuzzle = new MagnisalisWiringPuzzle();
        wiringPuzzle.solvePuzzle(true);
    }
}