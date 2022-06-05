import java.util.*;
/**
 * Write a description of class InstituteIO here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstituteUI
{
    
    private Scanner reader = new Scanner(System.in);
    private CREAM corona = new Institute();
    
    private void runUI()
    {   

        int choice = getOption();        
        while (choice != 0)
        {            
            // process choice
            if      (choice == 1){listAllRooms();}
            else if (choice == 2){listAllPassesbyRoom();}
            else if (choice == 3){listOneRoom();}
            else if (choice == 4){findAPass();}
            else if (choice == 5){showAPass();}
            else if (choice == 6){tryMove();}
            else if (choice == 7){moveNow();}
            else if (choice == 8){resetAllPasses();}
            else if (choice == 9){resetAPass();}
            else if (choice == 10){movePassOutside();}
            else if (choice == 11){evacuateAll();}
            // output menu & get choice
            choice = getOption();
        }
        System.out.println("\nThank-you");
    }
    
    
    private int getOption()
    {
       System.out.println("What would you like to do ?");
       System.out.println("0. Quit");
       System.out.println("1. List all Institute information");
       System.out.println("2. List all passes on each room");
       System.out.println("3. List all passes on one room");
       System.out.println("4. Find the current room of a pass");
       System.out.println("5. Show details of a pass");
       System.out.println("6. Say if pass can move through a door");
       System.out.println("7. Move a pass through door");
       System.out.println("8. ResetAllPasses");
       System.out.println("9. ResetPass");
       System.out.println("10. Move Pass Outside");
       System.out.println("11. Evacuate All Passes");
       
       System.out.println("Enter your choice");
       // read choice
       int option = reader.nextInt();
       reader.nextLine();
       return option;
    }
    
    // This one has been done for you 
    private void listAllRooms()
    {
        System.out.println(corona.toString());
    }
    
    // provide the code here  
    private void listAllPassesbyRoom()
    {
        System.out.println(corona.getAllPassesInAllRooms());
    }
   
    // provide the code here
    private void listOneRoom()
    {
        System.out.println("Enter room number");
        int ww = reader.nextInt();
        System.out.println(corona.getAllPassesInRoom(ww));
    }
    
    // provide the code here
    private void findAPass()
    {
        System.out.println("Enter pass id");
        int ps = reader.nextInt();
        
        int ww = corona.findPass(ps);
        if(ww != -1)
        {
            System.out.println("in Room" + ww);
        }
        else
        {
            System.out.println("No such pass");
        }
    }
    
    private void showAPass()
    {
        System.out.println("Enter pass id");
        int ps = reader.nextInt();
        System.out.println(corona.showPass(ps));
    }
    
    // This one has been done for you 
    private void tryMove()
    {
        System.out.println("Enter pass id");
        int trav = reader.nextInt();
        System.out.println("Enter door number");
        int door = reader.nextInt();
        System.out.println(corona.canMove(trav,door));
    }
    
    // This one has been done for you 
    private void moveNow()
    {
        System.out.println("Enter pass id");
        int trav = reader.nextInt();
        System.out.println("Enter door number");
        int door = reader.nextInt();
        System.out.println(corona.move(trav,door));
    }
    
    // provide the code here
    private void resetAllPasses()
    {
        corona.resetAllPasses();
    }
    
    private void resetAPass()
    {
        System.out.println("Enter pass id to reset");
        int trav = reader.nextInt();
        corona.resetPass(trav);
    }
    
    private void movePassOutside()
    {
        System.out.println("Enter pass id");
        int trav = reader.nextInt();
        corona.moveOutside(trav);
    }
    
    private void evacuateAll()
    {
        corona.evacuateAll();
        System.out.println("Passes have been evacuated");
    }
    
    public static void main(String[] args)
    {
        InstituteUI xx = new InstituteUI();
        xx.runUI();
    }
}
