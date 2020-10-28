//************************************
// Talk.java
// This class models a talk object
// Anya Devgan
// UNI: ad3706
//************************************

import java.io.*;
import java.util.Scanner;
import java.lang.Character;

public class Talk implements Comparable<Talk>{
    
    private String speakerName;
    private int startTime;
    private int endTime;
    
    //constructor for Talk object
    //throws exception if input is invalid
    public Talk(String data) throws IOException, RuntimeException{
        Scanner sc = new Scanner(data);
        
        //FIND SPEAKER NAME
        if(sc.hasNext()){
            speakerName = sc.next();
        }
        else{
            throw new RuntimeException();
        }
        
        //FIND START & END TIME
        
        //marks whether looking at start or end time in data input.
        //timeCounter = 0 when looking at start time. 
        //timeCounter = 1 when looking at end time.
        int timeCounter = 0; 
        
        //marks index for the beginning of timestamp in data input.
        int startIndex = 0;
        
        //iterates twice through while loop to find the start and end time
        while(timeCounter < 2){
            
            //finds beginning of timestamp at the end non-digit characters 
            while(!Character.isDigit(data.charAt(startIndex))){
                startIndex++;
            }

            int endIndex = startIndex; //marks index for end of timestamp.
            
            //finds end of timestamp where there is white space
            while(!Character.isWhitespace(data.charAt(endIndex)) && 
                  endIndex != (data.length()-1)){
                endIndex++;
            }
            
            int length = endIndex - startIndex; //calculate timestamp length
            
            //checks for valid input for first timestamp
            if(timeCounter == 0 && length != 4){
                throw new RuntimeException();
            }
            else if(timeCounter == 0 && length == 4){
                length = 3;
            }
            
            //checks for formatting of file to be such that each line only
            //has info for one talk. Incorrect if 2+ talks' info on line.
            if(timeCounter == 1 && endIndex != data.length()-1){
                throw new RuntimeException();
            }
            
            //validity of second timestamp checked
            //and assigns values to start and end time
            if(length != 3 || !sc.hasNextInt()){
                throw new RuntimeException();
            }
            else if(timeCounter == 0){
                startTime = sc.nextInt();
            }
            else{
                endTime = sc.nextInt();
            }
            
            //while loop to iterates for the second timestamp (i.e. end time)
            timeCounter++;
            startIndex = endIndex;
            
        }
        
        //print message regarding validity of timestamps and throws exceptions
        if(startTime < 0000 || startTime > 2400){
            System.out.println("Start time is invalid. It is either less " + 
                               "than 0 or greater than 2400.");
            throw new RuntimeException();
        }
        if(endTime < 0000 || endTime > 2400){
            System.out.println("End time is invalid. It is either less " + 
                               "than 0 or greater than 2400.");
            throw new RuntimeException();
        }

    }
    
    //method compares Talks based on end time
    //Talks with earlier end times come first
    public int compareTo(Talk a){
        int value = 0;
        
        if(this.endTime < a.endTime){
            value = -1;
        }
        else if(this.endTime == a.endTime){
            value = 0;
        }
        else if(this.endTime > a.endTime){
            value = 1;
        }
        
        return value;
    }
    
    public int getStartTime(){
        return startTime;
    }
    
    public int getEndTime(){
        return endTime;
    }
    
    
    //method takes checks if talks overlap
    //returns true if overlap; returns false if don't overlap
    public boolean checkOverlap(Talk a){
        boolean overlap = false;
        int sTime; //start time
        int eTime; //end time
        
        //set start time
        if(this.getStartTime() > a.getStartTime()){
            sTime = this.getStartTime();
        }
        else{
            sTime = a.getStartTime();
        }
        
        //set end time
        if(this.getEndTime() < a.getEndTime()){
            eTime = this.getEndTime();
        }
        else{
            eTime = a.getEndTime();
        }
        
        //check for intersection
        if(sTime < eTime){
            overlap = true;
        }
        
        return overlap;
    }
    
    
    public String toString(){
        String temp = speakerName + " ";
        
        if(startTime < 1200){
            temp = temp + String.format("%04d", startTime) + "AM";
        }
        else if(startTime >= 1200){
            temp = temp + String.format("%04d", startTime) + "PM";
        }
        
        if(endTime < 1200){
            temp = temp + "-" + String.format("%04d", endTime) + "AM";
        }
        else if(endTime >= 1200){
            temp = temp + "-" + String.format("%04d", endTime) + "PM";
        }

        return temp;
    }
    
    
}