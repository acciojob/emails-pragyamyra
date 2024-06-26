package com.driver;

import java.util.ArrayList;
import java.util.Date;


public class Gmail extends Email {

    int inboxCapacity;//maximum number of mails inbox can store
     ArrayList<Mail> Inbox ;
     ArrayList<Mail> Trash ;
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity= inboxCapacity;
        this.Inbox= new ArrayList<>();
        this.Trash = new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        if(Inbox.size()< inboxCapacity) {
            Inbox.add(new Mail(date, sender, message));
        }
        else{
            Trash.add(Inbox.get(0));
            Inbox.remove(0);
            Inbox.add(new Mail(date,sender,message));
        }
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        if(Inbox.isEmpty())
            return;

        for(int i=0;i<Inbox.size();i++){
            String currMessage= Inbox.get(i).message;
            if(currMessage.equals(message)){
                Trash.add(new Mail(Inbox.get(i).date,Inbox.get(i).message,Inbox.get(i).sender));
                Inbox.remove(Inbox.get(i));
            }
        }

    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(Inbox.isEmpty()){
            return null;
        }
        int index= Inbox.size()-1;
        return Inbox.get(index).message;


    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        if(Inbox.isEmpty())
            return null;
        // Else, return the message of the oldest mail present in the inbox

        return Inbox.get(0).message;
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
//
        int count=0;
        for(Mail mail:Inbox)
        {
            Date date= mail.date;
            if((date.before(start) && date.after(end)) || (!date.before(start) && !date.after(end))) {
                count++;
            }
        }
        return count;

    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return Inbox.size();

    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return Trash.size();

    }

    public void emptyTrash(){
        // clear all mails in the trash
        Trash = new ArrayList<>();

    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}
 class Mail {
   public Date date;
    public String sender;
    public String message;



    public Mail(Date date, String sender, String message){
        this.date=date;
        this.sender=sender;
        this.message=message;

    }
}
