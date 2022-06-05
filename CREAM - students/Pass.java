
/**
 * Write a description of class Pass here.
 *
 * @author (Chukwudi)
 * @version (12/04/2021)
 */
public class Pass
{
    // instance variables - replace the example below with your own
    private int passId;
    private String staffName;
    private int protectionRating;
    private int workHours;
    private int hoursLeft;
    private int moves;

    public Pass(int idNo, String sName, int pRating, int wHours){
        //Constructor initialises Objects
        passId = idNo;
        staffName = sName;
        protectionRating = pRating;
        workHours = wHours;
        hoursLeft = workHours;
        moves = 0;
    }

    public int getPassId(){
        return passId;
    }
    public int getRating(){
        return protectionRating;
    }
    public int getHoursLeft(){
        return hoursLeft;
    }
    public int getMoves(){
        return moves;
    }
    public void incrementMoves(){
        moves = moves + 1;
    }
    public void hourDeduct (int roomTime){
        //deduct function input roomTime from the hoursLeft
        hoursLeft = hoursLeft - roomTime;
    }
    public void resetter(){
        //reset hoursLeft and moves
        hoursLeft = workHours;
        moves = 0;
    }
    public String toString(){
        String show = "";
        // Displaying pass information
        show = show + "**Pass Information**";
        show = show + "\n**Pass ID : " + passId;
        show = show + "\n**Owner: " + staffName;
        show = show + "\n**Pass rating: " + protectionRating;
        show = show + "\n**Time left: " + hoursLeft + " of " + workHours + " initiatial hours";
        show = show + "\n**Moves made:" + moves;
        return show;
    }
    
}
