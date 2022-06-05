
/**
 * Test result of methods written for Pass objects. Expected answers after -- symbol
 *
 * @author (Chukwudi Amushie)
 * @version (09/04/2021)
 */
public class PassTester{
   
   
   public void PassTester(){
       Pass pass1 = new Pass(1000, "Ali", 5, 10); 
       Pass pass2 = new Pass(1001, "Bert", 3, 20); 
       Pass pass3 = new Pass(1002, "Certi", 10, 20); 
       
       System.out.println("Pass1 ID is " + pass1.getPassId() + " -- expected 1000");
       System.out.println("Pass2 ID is " + pass2.getPassId() + " -- expected 1001");
       System.out.println("Pass3 ID is " + pass3.getPassId() + " -- expected 1002");
       
       System.out.println("\nPass1 Protection rating is " + pass1.getRating() + " -- expected 5");
       System.out.println("Pass2 Protection rating is " + pass2.getRating() + " -- expected 3");
       System.out.println("Pass3 Protection rating is " + pass3.getRating() + " -- expected 10");
       
       System.out.println("\nIncrementing moves: Number of times incremented(pass1000:1, pass1001:1, pass1002:2)");
       pass1.incrementMoves();
       pass2.incrementMoves();
       pass3.incrementMoves();
       pass3.incrementMoves();

       System.out.println("Pass1 moves is " + pass1.getMoves() + " -- expected 1 moves");
       System.out.println("Pass2 moves is " + pass2.getMoves() + " -- expected 1 moves");
       System.out.println("Pass3 moves is " + pass3.getMoves() + " -- expected 2 moves");
       
       System.out.println("\nHour deduction: Number of hours deducted(pass1000:should decline, pass1001:4, pass1002:7");
       pass1.hourDeduct(11);
       pass2.hourDeduct(4);
       pass3.hourDeduct(7);
       
       System.out.println("Hours left on pass1 is " + pass1.getHoursLeft() + " -- expected -1(will check for negative hours in Door class)");
       System.out.println("Hours left on pass2 is " + pass2.getHoursLeft() + " -- expected 16");
       System.out.println("Hours left on pass3 is " + pass3.getHoursLeft() + " -- expected 13");
       
       System.out.println("\nResetting details of pass1");
       pass1.resetter();
       
       System.out.println("\nPass1 info " + pass1.toString() + " -- should reset to initiate values\n");
       System.out.println("Pass2 info" + pass2.toString() + " -- \n");
       System.out.println("Pass3 info " + pass3.toString() + " -- ");
       
   }
}
