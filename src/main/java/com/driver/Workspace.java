package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId,Integer.MAX_VALUE);
        this.calendar= new ArrayList<>();

    }



    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);

    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can atten
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

        calendar.sort((m1, m2) -> m1.getEndTime().compareTo( m2.getEndTime()));
        int count=0;
//        int currEndTime=-1;
//        for(int i=0;i<calendar.size();i++){
//            if(currEndTime<calendar.get(i).getStartTime()){
//                currEndTime= calendar.get(i).getEndTime();
//                count++;
//            }
//        }
        Meeting previousMeeting = null;

        for (Meeting meeting : calendar) {
            if (previousMeeting == null || !meeting.getStartTime().isBefore(previousMeeting.getEndTime())) {
                // If current meeting starts after or at the same time as the end time of the previous meeting
                count++;
                previousMeeting = meeting;
            }
        }
        return count;

    }
}
