package com.driver;

import java.util.*;

public class Gmail extends Email {

    private int inboxCapacity;
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity=inboxCapacity;
    }

    private Deque<node> inbox = new ArrayDeque<>();
    public void receiveMail(Date date, String sender, String message){
        node temp = new node(date,sender,message);
        if(this.inboxCapacity== inbox.size()){
            this.inbox.addLast(temp);
            this.inbox.removeFirst();
        }
        else{
            this.inbox.addLast(temp);
        }
    }
    private Deque<node> trash = new ArrayDeque<>();
    public void deleteMail(String message){
        Deque<node> temp = new ArrayDeque<>();
        while(!this.inbox.isEmpty()){
            if(!this.inbox.peekFirst().message.equals(message)){
                temp.addLast(this.inbox.peek());
            }
            else{
                trash.addLast(this.inbox.peek());
            }
            this.inbox.removeFirst();
        }
        this.inbox=temp;
    }

    public String findLatestMessage(){
        if(this.inbox.size()==0){
            return "null";
        }
        else {
            return this.inbox.getLast().message;
        }
    }

    public String findOldestMessage(){
        if(inbox.size()==0){
            return "null";
        }
        else {
            return this.inbox.getFirst().message;
        }
    }

    public int findMailsBetweenDates(Date start, Date end){
        Deque<node> temp = new ArrayDeque<>();
        int count = 0;
        while(!this.inbox.isEmpty()){
            if(this.inbox.getFirst().date.compareTo(start)>=0 && this.inbox.getFirst().date.compareTo(end)<=0){
                count ++;
            }
            temp.addFirst(this.inbox.getFirst());
            this.inbox.removeFirst();
        }
        this.inbox=temp;
        return count;
    }

    public int getInboxSize(){
        return this.inbox.size();

    }

    public int getTrashSize(){
        return this.trash.size();

    }

    public void emptyTrash(){
        Deque<node> temp = new ArrayDeque<>();
        this.trash=temp;
    }

    public int getInboxCapacity() {
        return this.inbox.size();
    }
}
class node{
    Date date;
    String sender;
    String message;
    public node(Date date,String sender,String message){
        this.date=date;
        this.sender=sender;
        this.message=message;
    }
}
