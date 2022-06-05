import java.util.Scanner;
/**
 * Create and user interface to create a pass and perform certain operations on it.
 *
 * @author (Chukwudi Amushie)
 * @version (09/04/2021)
 */
public class PassCheckerUI
{
    private Pass pass1000;
    private Scanner newInput = new Scanner(System.in);
    
    public void passCoder(){
        System.out.println("Pass Creation process...");
        System.out.println("Enter first name: ");
        String name = newInput.nextLine();
        System.out.println("Enter pass ID(1000 - 1100): ");
        int id = newInput.nextInt();
        System.out.println("Enter Protection Rating(1 - 10): ");
        int ratings = newInput.nextInt();
        System.out.println("Enter Work Hours: ");
        int initiatialHours = newInput.nextInt();
        System.out.println("Pass created\n***************");
        pass1000 = new Pass(id, name, ratings, initiatialHours);
        System.out.println(pass1000.toString());
        int choice = getOption();
        
        while (choice != 9){
            if (choice == 1){
                System.out.println("Enter min Hour of next room(1 - 4): ");
                int nextRoomHrs = newInput.nextInt(); 
                System.out.println("to be implemented");
            }
            else if (choice == 2){
                System.out.println("Protection Rating is " + pass1000.getRating());
            }
            else if (choice == 3){
                System.out.println("Hours left is " + pass1000.getHoursLeft() + " hours");
            }
            else if (choice == 4){
                System.out.println(pass1000.getMoves() + " moves made");
            }
            else if (choice == 5){
                System.out.println("Pass ID is " + pass1000.getPassId());
            }
            else if (choice == 6){
                pass1000.resetter();
                System.out.println("Pass has being reset");
            }
            choice = getOption();
        }
    }
    
    private int getOption()
    {
        System.out.println("\nSelect Operation");
        System.out.println("1. Move to another room");
        System.out.println("2. View Protection Rating");
        System.out.println("3. View Hours Left");
        System.out.println("4. View number of moves");
        System.out.println("5. View Pass ID");
        System.out.println("6. Reset Pass");
        System.out.println("9. finish");
        System.out.println("Chose option: ");
        int option = newInput.nextInt(); 
        
        while (option<1 || option > 9 || option == 7 || option == 8 )
        {
           System.out.println("Invalid: Chose Option:");
           option = newInput.nextInt(); 
        }
        return option;
    }
  
    
    public static void main(String[] args){   
        PassCheckerUI pass1000 = new PassCheckerUI();
        pass1000.passCoder();
    }
}
