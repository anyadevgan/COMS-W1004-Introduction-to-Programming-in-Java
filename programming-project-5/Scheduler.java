//************************************
// Schedule.java
// This class schedules talks
// Anya Devgan
// UNI: ad3706
//************************************

import java.util.ArrayList;
import java.io.*;
import java.util.Collections;
import java.util.Scanner;

public class Scheduler{
    
    // takes in a file name and returns an ArrayList of Talk objects
    public static ArrayList<Talk> makeTalks(String fileName) throws IOException
    {
        File inFile = new File(fileName);
        Scanner input = new Scanner(inFile);
        //this ArrayList holds the talks to be scheduled
        ArrayList<Talk> arr = new ArrayList<Talk>();
  
        try{
            while(input.hasNextLine()){
                Talk temp = new Talk(input.nextLine());
                arr.add(temp);
            }
            input.close();
        }
        catch(RuntimeException e){ 
            System.out.println("File has incorrect formatting.");
            System.exit(0); 
        }

        return arr;
    }
    
    // takes in an ArrayList of Talk objects and returns a maximum 
    // size subset of those talks that may be scheduled in a single room.
    public static ArrayList<Talk> scheduleTalks(ArrayList<Talk> talks) 
    {
        //holds talks and checks if they have been accounted for
        ArrayList<Talk> test = talks;
        
        //holds the schedule which is added to
        ArrayList<Talk> schedule = new ArrayList<>();
        
        //sorts Talks in ArrayList test based on endTime
        Collections.sort(test);
        
        int pointer = 0; //points newest scheduled talk
        while(test.size() > 0){
            schedule.add(test.get(0));
            test.remove(0);
            
            //if Talk overlaps with talk pointer is pointing at, then remove
            while(test.size() > 0 && 
                  test.get(0).checkOverlap(schedule.get(pointer))){
                test.remove(0);
            }
            
            pointer++; //increase value of pointer for next pass
        }
        
        return schedule;
    }

}