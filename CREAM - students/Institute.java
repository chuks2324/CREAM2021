import java.util.*;

/**
 *
 * @author A.A.Marczyk 
 * @version 09/11/20
 **/
public class Institute implements CREAM
{
    private ArrayList<Pass> allPasses = new ArrayList<Pass>();
    private ArrayList<Room> allRooms = new ArrayList<Room>();
    private ArrayList<Door> allDoors = new ArrayList<Door>();

    /** constructor
     */
    public Institute() 
    {
          loadRooms();
          setUpDoors();
          loadPasses();
          
          getRoom(100).enter(getPass(1000));
          getRoom(100).enter(getPass(1001));
          getRoom(100).enter(getPass(1002));
          getRoom(100).enter(getPass(1003));
          getRoom(100).enter(getPass(1004));
          getRoom(100).enter(getPass(1005));
          getRoom(100).enter(getPass(1006));
          getRoom(100).enter(getPass(1007));
          getRoom(100).enter(getPass(1008));
         
          
          
    }
    
    /**
     * Returns all of the details of all rooms including the passes
     * currently in each room, or "No passes"
     * @return all of the details of all rooms including location 
     * of all passes currently in each room, or "No passes" 
     */
    public String toString()
    {
        String xyz = "Details of all Rooms: \n";
        for (Room temp : allRooms){
            xyz = xyz + temp.toString();
            xyz = xyz + "\n";
        }
        
        return xyz;
    }

    /**Returns a String representation of all the passes in all rooms
     * @return a String representation of all passes in all rooms, room code
     * and name should be included at the start of the list
     **/
    public String getAllPassesInAllRooms()
    {
        String efg = "";
        for (Room temp : allRooms){
            efg = efg + temp.getRoomName() + "(" + temp.getRoomNumber() + "): " + temp.passList();
            efg = efg + "\n";
        }
        
        return efg;
    } 
 
    
    /**Returns the name of the room which contains the specified pass or null
     * @param ps - the specified pass
     * @return the number of the Room which contains the pass, or -1
     **/
    public int findPass(int ps)
    {
        for (Room temp : allRooms){
            if (temp.isPassHere(ps) == true){
                return temp.getRoomNumber();
            } 
        }
        return -1;
    }
    
    /** Given the name of a room, returns the room code
     * or null if room does not exist
     * @param name of room
     * @return number of room, or -1 if the room does not exist
     */
    public int getRoomNo(String rm)
    {
        for (Room temp : allRooms){
            if (temp.getRoomName().equals(rm)){
                return temp.getRoomNumber();
            } 
        }
        return -1;
    }
                
    /**Returns a String representation of all the passes in specified room
     * @roomCode the room code
     * @return a String representation of all passes in specified room, or
     * "No such room"
     **/
    public String getAllPassesInRoom(int rmNo)
    {
        for (Room temp : allRooms){
            if (temp.getRoomNumber() == rmNo){
                return temp.passList();
            } 
        }
        return "No such room";
    } 

    /** Returns a String with all of the details of a Pass
     * @param passNo is the pass number
     * @return all details of the Pass, or "No such Pass"
     */
    public String showPass(int pNo)
    {
        for (Pass temp : allPasses){
            if (temp.getPassId() == pNo){
                return temp.toString();
            } 
        }
        return "No such Pass";
    }
    
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
    public boolean canMove(int psId, int doorNo)
    {   
        //Some methods below have been returned to dr, frRm and toRm objects to aid readablility. 
        Door dr = getDoor(doorNo);  // dr: Door object with parameter doorNo from arraylist
        Room frRm = dr.getRoomAwayFrom(); // frRm: Room object a door leads away from
        Room toRm = dr.getRoomLeadsTo();  // toRm: Room object a door leads to
        Pass ps = frRm.returnPass(psId);  // ps: Pass object in a room
        if ((findPass(psId) != -1) && (getDoor(doorNo) != null) && frRm.isPassHere(psId)) {
            
            if (((dr.canAccess(ps)) == true) && (frRm.isPassHere(psId)) == true)
            {
                return true;
            }
        }
        return false;
        
    }     

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
    public String move(int psId, int doorNo )
    {   
        String message;
        if (canMove(psId, doorNo) == true){
           Door dr = getDoor(doorNo);   // dr: Door object with parameter doorNo from arraylist
           Room rm = dr.getRoomAwayFrom();  // rm: Room object a door leads away from
           Pass ps = rm.returnPass(psId);   // ps: Pass object in a room
           dr.passMovement(ps); //check Class door to understand line
           
           message = "Move successful";
        }else{
            message = "Not moved";
            
        }
    
        return message;
    } 
            
    /** Resets all passes:  moves to 0, available hours left to allowable hours
     */
    public void resetAllPasses()
    {
        for (Room temp : allRooms){
           temp.resetPassInRoom();
        }
        //returnPass(int id)
    }

    // These methods are for Task 7 only and not required for the Demonstration 
    // If you choose to implement them, uncomment the following 

    /** Resets one passes: moves to 0, available hours left to allowable hours  
     * @param id of the pass
     */
    public void resetPass(int id)
    {
        //steps
        //if the pass entered is  valid pass:
        //find the room the pass is in
        //find the pass from the passes in the room
        //reset the pass
        if (getPass(id) != null){
        int roomNumberOfPass = findPass(id);
        Room rrm = getRoom(roomNumberOfPass);
        rrm.returnPass(id).resetter();
        }   
    }
    
    /** Moves a pass directly back to the Outside without affecting data
     *  and not using existing doors
     */
    public void moveOutside(int id)
    {
        //steps
        //if the pass entered is  valid pass:
        //find the room the pass is in
        //find the pass from the passes located in the room
        //return the Pass object to a variable
        //remove the pass from the room
        //add the pass to outside (roomNo 100)
        if (getPass(id) != null){
            int roomNumberOfPass = findPass(id);
            Room rrm = getRoom(roomNumberOfPass);
            Room RoomOutside = getRoom(100);
            Pass ps = rrm.returnPass(id);
            
            rrm.leave(ps);
            RoomOutside.enter(ps);
        }
    }
   
    /** In an emergency, evacuates all passes directly back to the Outside without 
     * affecting information and not using existing doors
     */
    public void evacuateAll()
    {
       for (Pass temp : allPasses){
          moveOutside(temp.getPassId());
       }
    
    }

    
   
    //***************private methods**************
    private void loadRooms()
    {
        Room r0 = new Room(100, "Outside", 0, 1000, 0);
        Room r1 = new Room(101, "Staff Room", 1, 100, 1);
        Room r2 = new Room(102, "Lab1", 3, 10, 3);
        Room r3 = new Room(103, "Virus Lab", 5, 2, 4);
        Room r4 = new Room(104, "Decontamination", 0, 1, 0);
   
   
        allRooms.add(r0);
        allRooms.add(r1);
        allRooms.add(r2);
        allRooms.add(r3);
        allRooms.add(r4);
   

    }
    
    private void setUpDoors()
    {
        Door d0 = new Door (0, getRoom(101), getRoom(100));
        Door d1 = new Door (1, getRoom(100), getRoom(101));
        Door d2 = new Door (2, getRoom(102), getRoom(101));
        Door d3 = new Door (3, getRoom(101), getRoom(102));
        Door d4 = new Door (4, getRoom(101), getRoom(103));
        Door d5 = new Door (5, getRoom(104), getRoom(101));
        Door d6 = new Door (6, getRoom(101), getRoom(104));
        Door d7 = new Door (7, getRoom(103), getRoom(102));
        Door d8 = new Door (8, getRoom(103), getRoom(101));
        
        allDoors.add(d0);
        allDoors.add(d1);
        allDoors.add(d2);
        allDoors.add(d3);
        allDoors.add(d4);
        allDoors.add(d5);
        allDoors.add(d6);
        allDoors.add(d7);
        allDoors.add(d8);
    }
    
    private void loadPasses()
    {
        Pass p0 = new Pass(1000, "Ali", 5, 10);
        Pass p1 = new Pass(1001, "Bert", 3, 20);
        Pass p2 = new Pass(1002, "Ceri", 10, 20);
        Pass p3 = new Pass(1003, "Dana", 2, 12);
        Pass p4 = new Pass(1004, "Eli", 3, 3);
        Pass p5 = new Pass(1005, "Fred", 1, 5);
        Pass p6 = new Pass(1006, "Gani", 10, 6);
        Pass p7 = new Pass(1007, "Hui", 7, 20);
        Pass p8 = new Pass(1008, "Imran", 6, 24);
        
        allPasses.add(p0);
        allPasses.add(p1);
        allPasses.add(p2);
        allPasses.add(p3);
        allPasses.add(p4);
        allPasses.add(p5);
        allPasses.add(p6);
        allPasses.add(p7);
        allPasses.add(p8);
        
    }
 
    // You may find these methods useful to simplify your code above
    /** Returns the pass with the pass id specified by the parameter
     * @return the pass with the specified name
     **/
    public Pass getPass(int id)
    {
        for (Pass temp : allPasses){
            if (temp.getPassId() == id){
                return temp;
            }  
        }
        return null;
    }
    
    
    /** Returns the room with the name specified by the parameter
     * @param roomNo is the number of the required room
     * @return the room with the specified name
     **/
    private Room getRoom(int num)
    {
        
        for (Room temp : allRooms){
            if (temp.getRoomNumber() == num){
                return temp;
            }  
        }
        return null;
    }
    
    /** Returns the room with the name specified by the parameter
     * @return the room with the specified name
     **/
    private Door getDoor(int dr)
    {
       for (Door temp : allDoors){
            if (temp.getDoorNum() == dr){
                return temp;
            }  
        }
        return null;
    }
}