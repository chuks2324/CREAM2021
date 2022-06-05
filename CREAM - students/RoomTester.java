
/**
 * Write a description of class roomTester here.
 *
 * @author (Chukwudi Amushie)
 * @version (19/04/2021)
 */
public class RoomTester
{
    // instance variables - replace the example below with your own
    private Pass pass1 = new Pass(1001, "jam", 4, 20);
    private Pass pass2 = new Pass(1002, "sandy", 4, 20);
    private Pass pass3 = new Pass(1003, "jeff", 4, 20);
    
    private Room room1 = new Room(2, "toilet", 4,2,3);
    private Room room2 = new Room(3, "kitchen", 4,8,4);
   

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void doTest()
    {
        room1.enter(pass1);
        room1.enter(pass2);
        room2.enter(pass3);
        
        System.out.println(room1.NumPasses() + " --expected 2");
        room1.leave(pass1);
        room2.enter(pass1);
        System.out.println(room1.NumPasses() + " --expected 1\n");
        
        System.out.println(room1.notFull() + " --expected true\n");
        
        System.out.println(room2.passList() + " --expected pass 1001 and 1003");
        
        System.out.println(room1.findPass(1002) + " --expected found + pass details\n");
        
        System.out.println(room2.findPass(1002) + " --expected not found\n");
        
        System.out.println(room2.isPassHere(1003) + " --expected true");
        System.out.println(room1.isPassHere(1003) + " --expected false");
        
        System.out.println(room1.toString());
        

    }
    
}
