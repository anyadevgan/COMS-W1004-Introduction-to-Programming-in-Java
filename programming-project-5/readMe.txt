readMe.txt
PP5
Anya Devgan (ad3706)

Algorithm used to schedule talks:
    The talks are sorted in ascending order based on end time. The talk 
    with the earliest end time is scheduled first and then removed from
    the list. Because only one talk can be scheduled at a time, any talks
    that overlap with the scheduled talk are removed. Then, steps 2 and 3
    are repeated until the original list is empty and all talks have been
    removed. Lastly, the schedule is printed.


Flow of the program:
    1. User inputs a file name that is received by the ScheduleTest class.
       NOTE: this program assumes that the text file is proper if it has no
             spaces or tabs at the end of the line, rather only a newline.
             
    2. The makeTalks method of Scheduler goes through each line, gathering 
       information to make new Talk objects.
       
    3. The creation of Talk objects involves a call to the Talk constructor
       which reads a line of data and extracts the necessary information.
       NOTE: a line was passed into Talk because, in cases where the text file
             is valid, each line should contain all of the correct information.
             However, if the line does not have relevant information, a 
             RunTimeException will be passed back to Scheduler to be handled.
       
    4. After creating an ArrayList of Talks, ScheduleTest schedules the max
       number of talks as it calls the scheduleTalks method in Scheduler. 
       
    5. scheduleTalks first sorts the list and then applies the algorithm to
       schedule talks.
       
    6. Following this algorithm, the overlap method is called to ensure that 
       only one talk is scheduled for a given time and there are no conflicts.
       
    7. The optimal schedule is created and printed.
    

Design of the Talk class constructor:
    1. The constructor takes in a String of data as a parameter.
    
    2. The name of the speaker is searched for and assigned.
       A RuntimeException is thrown if the name is not valid.
       
    3. The variable timeCounter is used to track whether we're dealing with the
       start or end time (timeCounter = 0 for start time and 1 for end time).
       
    4. A while loop is used and iterated through twice to find the begining and 
       end of each timestamp, storing the values into startIndex and endIndex,
       respectively.
       
    5. The length of the timestamp is calculated.
    
    6. Checking for the correct formatting, the start time should have a length 
       of 4 and the end time should have a length of 3. The end time should have
       this length because no whitespace follows.
       
    7. An if-else if statement (lines 60-65) checks the validity of the start 
       time. If the time has proper formatting, its length is changed to value
       of 3 so that the next pass works (for end time) correctly.
       
    8. An if statement (lines 69-71) checks for a specific formatting of the 
       text file. The file is deemed proper only if the information for one talk
       is given per line. For this program, information for two talks or more
       can't be included in a line of the text file.
       
    8. An if-else if statement (lines 75-83) checks the validity of the end
       time. Also, this code assigns values to both starTime and endTime.
       
    9. Depending on the validity of the data and if any information does not
       match required standards, a RuntimeException is thrown.