package SAKSHAM.CODE;

import java.util.ArrayList;

public class MobliePhone {
    private String myNumber;
private ArrayList<contacts> myContacts;

    public MobliePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts=new ArrayList<contacts>();
    }

    public boolean NewContact(contacts contact){
        if(findContact(contact.getName())>=0){
            System.out.println("contact is already in phone");
        return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(contacts oldcontact,contacts newContact){
        int foundPosition=findContact(oldcontact);
        if (foundPosition<0){
            System.out.println(oldcontact.getName()+"not found");
            return false;
        }
         this.myContacts.set(foundPosition,newContact);
        System.out.println(oldcontact.getName()+"is replaced with+"+newContact.getName());
        return true;
    }
    public boolean removeContact(contacts contact){
        int foundPosition=findContact(contact);
        if (foundPosition<0) {
            System.out.println(contact.getName() + "not found");
            return false;
        }
this.myContacts.remove(foundPosition);
        System.out.println(contact.getName()+"is removed ");
        return true;
        }

    private int findContact(contacts contact){
        return this.myContacts.indexOf(contact);
    }
    private int findContact(String contactName){
        for(int i=0;i<this.myContacts.size();i++){
            contacts contact=this.myContacts.get(i);
            if (contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }
public String queryContact(contacts contact){
        if (findContact(contact )>=0){
            return contact.getName();
        }
        return null;
}
public void printContacts(){
    System.out.println("contact list");
    for (int i=0;i<this.myContacts.size();i++){
        System.out.println((i+1)+"."+this.myContacts.get(i).getName()+"-->"+this.myContacts.get(i).getNumber());
    }
}
public contacts querycontact(String name){
        int position=findContact(name);
        if (position>0){
            return this.myContacts.get(position);

        }
        return null;


}


}
