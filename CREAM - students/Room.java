import java.util.*;
/**
 * Each room has a name,  a protection rating, and a capacity which represents 
 * the maximum number of people(passes) who can be on the room at any one time. Each 
 * room must maintain a list of all people (passes)currently on the room. These lists 
 * are updated whenever passes enter or leave a room,so that it is always possible 
 * to say how many people (passes) are on the room and who they are.
 * 
 * @author (Chukwudi Amushie) 
 * @version (12/04/2021)
 */

public class Room 
{
    //instance variables (passes Arraylist list stores Pass objects in a room)
    private int roomNumber;
    private String roomName;
    private int dangerRating;
    private int roomCapacity;
    private int allowableHours;
    private ArrayList <Pass> passes;
   
    public Room(int rNumber, String rName, int dRating, int rCapacity, int allowedHours){
        //Constructor initialises Objects
        roomNumber = rNumber;
        roomName = rName;
        dangerRating = dRating;
        roomCapacity = rCapacity;
        allowableHours = allowedHours;
        passes = new ArrayList<Pass>();
    }
   
    public int getRoomNumber(){
        return roomNumber;
    }
    public String getRoomName(){
        return roomName;
    }
    public int getDangerRating(){
        return dangerRating;
    }
    public int getRoomCapacity(){
        return roomCapacity;
    }
    public int getAllowableHours(){
        return allowableHours;
    }
    
    public ArrayList<Pass> getPasses(){
        return passes;
    }
    
    /**Adds a pass to an Arraylist of passes
     * Pass pass1 is the specified pass**/
    public void enter(Pass pass1){
        passes.add(pass1);
    }
    
    /**Finds the position of a pass in an Arraylist of passes and removes it
    **/
    public void leave(Pass pass1){
        
        for (int i = 0; i < passes.size(); i++){
            Pass temp = passes.get(i);
            if (temp.getPassId() == pass1.getPassId()){
                passes.remove(temp);
            }
        }
    }

    /**Returns true if the number of passes in a room is less than the room capacity
    **/
    public boolean notFull(){
        boolean status = false;
        if (roomCapacity > NumPasses()){
            status = true;
        }
        else{
            status = false;
        }
        return status;
    }
    
    /**Returns string representation Listing all pass Ids in a room
    Syntax: passid1, passid2......**/
    public String passList(){
        String pList = "Pass: ";
        for (Pass temp : passes){
            pList = pList + temp.getPassId() +", ";
        }
        if (NumPasses() == 0){
            pList = "Room Empty";
        }
        return pList;
    }
    
    /**Finds a specific pass in a room and returns string representation of the pass's details
     * Input Parameter id is the id of the pass**/
    public String findPass(int id){
        for (Pass temp : passes){
            if (temp.getPassId() == id){
                return temp.toString();
            }
            
        }
        return "Pass not found"; 
    }
    
    /**Returns true if a pass is found in room and false if not found
     * Input Parameter id is the id of the pass**/
    public boolean isPassHere(int id){
        boolean isHere = false;
        for (Pass temp : passes){
            if (temp.getPassId() == id){
                isHere = true;
            }  
        }
        return isHere; 
    }
    
    //return room details in String output
    public String toString(){
        String show = "";
        // Displaying pass information
        show = show + "\n**Room Number : " + roomNumber;
        show = show + "\n**Room Name: " + roomName;
        show = show + "\n**Danger Rating: " + dangerRating;
        show = show + "\n**Room Capacity: " + roomCapacity;
        show = show + "\n**Allowed Hours: " + allowableHours;
        show = show + "\n" + passList();
        return show;
        }
    
    //I have added the following methods below as I felt they are necessary
    /**Returns a Pass object from the arraylist of Pass objects passes given the passId
     * Returns null if its not found. 
     **Will call isPassHere before this accessor so it doesn't return null**
     * Input Parameter id is the id of the pass**/  
    public Pass returnPass(int id){
        for (Pass temp : passes){
            if (temp.getPassId() == id){
                return temp;
            }
        }
        return null; 
    }
    
    //resets values of all passes in a room
    public void resetPassInRoom(){
        for (Pass temp : passes){
            temp.resetter();
        }
    }
    
   
    //Returns the number of Pass objects in arraylist passes
    public int NumPasses(){
        return passes.size();
    }

   
}
