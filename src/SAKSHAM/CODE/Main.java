package SAKSHAM.CODE;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static MobliePhone mobliePhone = new MobliePhone("9818633855");

    public static void main(String[] args) {
        // write your code here
        boolean quit = false;
        startphone();
        printActions();
        while (!quit) {
            System.out.println("enter action :(6 to show available actions )");
         int action=sc.nextInt();
         sc.nextLine();
         switch (action){
             case 0:
                 System.out.println("shuting down");
                 quit=true;
                 break;
             case 1:
                 printContacts();
                 break;
             case 2:
                 addNewContact();
                 break;
             case 3:
                 updateContact();
                 break;
             case 4:
                 removeContact();
                 break;
             case 5:
                 queryContact();
                 break;
             case 6:
                 printActions();
                 break;
         }
        }

    }
    private static void addNewContact(){
        System.out.println("entername");
            String name=sc.nextLine();
        System.out.println("enter number ");
        String number=sc.nextLine();
        contacts newcontact=contacts.createcontact(name,number);
        if (mobliePhone.NewContact(newcontact)){
            System.out.println("new contact added "+name+",phone="+number);
                    }
        else
        {
            System.out.println(newcontact+"already in phone" );
        }
    }
    private static void updateContact(){
        System.out.println("enter existing contact name");
     String name =sc.nextLine();
     contacts existinfContactRecord=mobliePhone.querycontact(name)  ;
     if (existinfContactRecord==null){
         System.out.println("contact not found ");
     return;
     }
        System.out.println("enter new contact name ");
     String newname=sc.nextLine();
        System.out.println("enter new contact phone number ");
        String newnumber=sc.nextLine();
        contacts newContact=contacts.createcontact(newname,newnumber);
        if (mobliePhone.updateContact(existinfContactRecord,newContact)){
            System.out.println("Contact updated successfully");
        }
        else {
            System.out.println("error upadting contact");
        }
    }
public  static   void printContacts(){
        mobliePhone.printContacts();

}
    private static void removeContact() {
        System.out.println("enter existing contact name");
        String name = sc.nextLine();
        contacts existinfContactRecord = mobliePhone.querycontact(name);
        if (existinfContactRecord == null) {
            System.out.println("contact not found ");
            return;
        }
        if (mobliePhone.removeContact(existinfContactRecord)){
            System.out.println("successfully deleted");
        }
        else {
            System.out.println("error deleting contact");
        }
    }
    private static void queryContact() {
        System.out.println("enter existing contact name");
        String name = sc.nextLine();
        contacts existinfContactRecord = mobliePhone.querycontact(name);
        if (existinfContactRecord == null) {
            System.out.println("contact not found ");
            return;
        }
        System.out.println("name : "+existinfContactRecord.getName()+"phone number is : "+existinfContactRecord.getNumber());
    }
    private static void startphone() {
        System.out.println("starting phone.......");
    }
    public static void printActions(){
        System.out.println("Actions : \npress");
        System.out.println("0- to shutdown \n"+
                "1-to print contacts\n"+
                "2-to add a new contact \n"+
                "3-to update an existing contact \n"+
                "4-to remove an existing contact \n"+
                "5-query if an existing contact exists\n"+
                "6-to print list of available actions");
        System.out.println("choose your actiion");

    }
}
