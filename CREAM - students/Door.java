
/**
 * A door provides a one-way connection between two rooms. It
 * has a Door number and information about both the "from" and
 * the "to" room
 * 
 * @author (Chukwudi Amushie) 
 * @version (12/04/2021)
 */
public class Door{
    //instance variables 
    int doorNumber;
    Room to;
    Room from;
   
    public Door(int doorNum, Room leadTo, Room awayFrom){
        //initialisation
        doorNumber = doorNum;
        to = leadTo;
        from = awayFrom;
    }
    
    //Returns door number
    public int getDoorNum(){
        return doorNumber;
    }
    
    //returns a Room object representing the room a door leadsto
    public Room getRoomLeadsTo(){
        return to;
    }
    
    //returns a Room object representing the room a door is going away from
    public Room getRoomAwayFrom(){
        return from;
    }
    
    /**Checks if a pass can enter a room
     * If the room danger rating is less or equal to the pass prtection rating
     * and if hours left of the pass is greater or equal to the min hours of the room
     * and if the room is not full, method return true
     * i.e pass can enter room.
     * Input Parameter p is the Pass object**/
    public boolean canAccess(Pass p){
        boolean allowed = false;
        if ((to.getDangerRating() <= p.getRating()) && (to.getAllowableHours() <= p.getHoursLeft()) && (to.notFull()) && (p.getMoves() < 5)){
            allowed = true;
        }
        
        return allowed;
    }
    
    public String passMovement(Pass p){
    String message;
    if (canAccess(p) == true){
        from.leave(p);
        to.enter(p);
        p.hourDeduct (to.getAllowableHours());
        p.incrementMoves();
        message = "Pass accepted";
    }else{
        message = "Pass use not allowed";
        
    }
    return message;
    }
    
    public String toString(){
    String doorstr = "";
    doorstr = doorstr + "The door number is " + getDoorNum();
    doorstr = doorstr + "\nThe room coming from the door has number " + from.getRoomNumber() + " and name " + from.getRoomName();
    doorstr = doorstr + "\nThe room leading out of door has number " + to.getRoomNumber() + " and name " + to.getRoomName();
    return doorstr;
    }
    
    
}
