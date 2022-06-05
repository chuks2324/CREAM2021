
/**
 * Write a description of interface CREAM here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface CREAM
{
     /**
     * Returns all of the details of all rooms including the passes
     * currently in each room, or "No passes"
     * @return all of the details of all rooms including location 
     * of all passes currently in each room, or "No passes" 
     */
    public String toString();

    
    /**Returns a String representation of all the passes in all rooms
     * @return a String representation of all passes in all rooms, room code
     * and name should be included at the start of the list
     **/
    public String getAllPassesInAllRooms();
 
    
    /**Returns the name of the room which contains the specified pass or null
     * @param ps - the specified pass
     * @return the number of the Room which contains the pass, or -1
     **/
    public int findPass(int ps);
   
    
    /** Given the name of a room, returns the room code
     * or null if room does not exist
     * @param name of room
     * @return number of room, or -1 if the room does not exist
     */
    public int getRoomNo(String rm);
    
    
    /**Returns a String representation of all the passes in specified room
     * @roomCode the room code
     * @return a String representation of all passes in specified room, or
     * "No such room"
     **/
    public String getAllPassesInRoom(int rmNo);

    /** Returns a String with all of the details of a Pass
     * @param passNo is the pass number
     * @return all details of the Pass, or "No such Pass"
     */
    public String showPass(int pNo);
    
    
     /**Returns true if a Pass is allowed to move using the door, false otherwise
     * A move can be made if:  
     * the protection rating of the pass  >= the danger rating of the destination room
     * AND the destination room is not full
     * AND the pass has hours left >= limit of the destination room
     * AND the pass is currently in the source room
     * AND the pass id is for a pass in the system
     * AND the door number is the number for a door in the system
     * @param psId is the id of the pass requesting the move
     * @param doorNo is the number of the door through which the pass wants to move
     * @return true if the pass is allowed in the move, false otherwise 
     **/
    public boolean canMove(int psId, int doorNo);
    

    /**Returns the result of a pass requesting to move by Door.
     * A move will be successful if:  
     * the protection rating of the pass  >= the danger rating of the destination room
     * AND the destination room is not full
     * AND the pass has sufficient hours left >= limit of the destination room
     * AND the pass is currently in the source room
     * AND the pass id is for a pass in the system
     * AND the door number is the number for a door in the system
     * If the move can be made, the pass information is removed from the source
     * room, added to the destination room and a suitable message returned.
     * If move cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * @param psId is the id of the pass requesting the move
     * @param doorNo is the number of the door through which the pass wants to move
     * @return a String giving the result of the request 
     **/
    public String move(int psId, int doorNo );
            
    /** Resets all passes 
     */
    public void resetAllPasses();
    
   
    // These methods are for Task 7 only and not required for the Demonstration 
    // If you choose to implement them, uncomment the following
    
    
    /** Resets one passes: moves to 0, available hours left to allowable hours  
     * @param id of the pass
     */
    public void resetPass(int id);
    
    /** Moves a pass directly back to the Outside without affecting data
     *  and not using existing doors
     */
    public void moveOutside(int id);

   
    /** In an emergency, evacuates all passes directly back to the Outside without 
     * affecting information and not using existing doors
     */
    public void evacuateAll();
}
