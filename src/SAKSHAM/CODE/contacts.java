package SAKSHAM.CODE;

public class contacts {
    private String name ;
    private String number;

    public contacts(String name,String number){
        this.name=name;
        this.number=number;
    }
    public String getName(){
        return name;
    }
    public String getNumber(){
        return number;
    }
public static contacts createcontact(String name,String number){
        return new contacts(name,number);
}
}
