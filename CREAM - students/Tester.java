import java.util.*;
/**
 * Write a description of class OTester here.
 * 
 * @author 
 * @version 
 */
public class Tester 
{   
    private void doTest()
    {
        // write your tests here
        CREAM site1 = new Institute();
        Scanner enter = new Scanner(System.in);
        
        System.out.println("*********All Rooms**************");
        System.out.println(site1.toString());
        //enter.nextLine();
        
        // write your tests here
        System.out.println("\n**** Pass 1001 moved through door 0***");
        System.out.println(site1.move(1001,0) + " --expected: Move successful (pass1000 in room101)\n");
        
        System.out.println("\n**** check if pass 1001 can move through door 8***");
        System.out.println(site1.canMove(1001,8) + " --expected: false");
        System.out.println("**** check to see if move is declined***");
        System.out.println(site1.move(1001,8) + " --expected: Not moved (pass1000 remains in room101[why? Its pRating])\n");
        
        System.out.println("\n**** check if pass 1004 can move through door 0***");
        System.out.println(site1.canMove(1004,0) + " --expected: true");
        System.out.println("**** Moving pass 1004 through door 0***");
        System.out.println(site1.move(1004,0) + " --expected: Move successful (pass1004 in room101)\n");
        
        System.out.println("\n**** check if pass 1004 can move through door 6***");
        System.out.println(site1.canMove(1004,6) + " --expected: false");
        System.out.println("**** check to see if move is declined***");
        System.out.println(site1.move(1004,6) + " --expected: Not moved (pass1004 in room101)\n");
        
        System.out.println("\n**** check if pass 1003 can move through door 0***");
        System.out.println(site1.canMove(1003,0) + " --expected: true");
        System.out.println("**** Moving pass 1003 through door 0***");
        System.out.println(site1.move(1003,0) + " --expected: Move successful *pass1003 in room101\n");
        
        System.out.println("\n**** check if pass 1003 can move through door 5***");
        System.out.println(site1.canMove(1003,5) + " --expected: true");
        System.out.println("**** Moving pass 1003 through door 5***");
        System.out.println(site1.move(1003,5) + " --expected: Move successful *pass1003 in room104\n");

        System.out.println("\n**** Printing all Passes in all Rooms***");
        System.out.println(site1.getAllPassesInAllRooms() + "--expected: Room 100: 1000, 1002, 1005, 1006, 1007, 1008\n"
                                                            + "\t\tRoom 101: 1001, 1004 \n"
                                                            + "\t\tRoom 102: Empty\n"
                                                            + "\t\tRoom 103: Empty\n"
                                                            + "\t\tRoom 104: 1003");
                                                            
        System.out.println("\n**** Show passes in Room 104***");
        System.out.println(site1.getAllPassesInRoom(104) + " --expected: 1003");
    
        System.out.println("\n**** Show room number Pass 1004 is in***");
        System.out.println("Pass in Room " + site1.findPass(1004) + " --expected: Room 101");
        
        System.out.println("**** \nResetting details of Pass 1004***");
        site1.resetPass(1004);
        System.out.println("**** Pass 104 reset***");
        
        System.out.println("**** Show pass 1004 details***");
        System.out.println(site1.showPass(1004) + " \n--expected after reset: passid-1004, name-Eli, pRating-3, hours-3, moves-0\n");
        
        System.out.println("\n**** Resetting details of all passes***");
        site1.resetAllPasses();
        System.out.println("**** All passes reset***");
        
        System.out.println("\n**** Moving pass 1004 outside***");
        site1.moveOutside(1004);
        
        System.out.println("**** Showing room pass 104 is in***");
        System.out.println("in Room" + site1.findPass(1004) + " --expected: Room 100 (after move outside)\n");

        System.out.println("\n**** Evacuating all passes(moving to outside)***");
        site1.evacuateAll();
        System.out.println("**** Showing all passes are outside***");
        System.out.println(site1.getAllPassesInRoom(100) + " --after evacuate expected: Room 100: 1000,1001,1002,1003,1004,1005,1006,1007,1008");

        

    }
     
     
    
    public static void main(String[] args)
    {
        Tester xx = new Tester();
        xx.doTest();
    }
}
