package model;

public class Student {
    //variables
    private int id;
    private String name;
    private int age;
    private String address;
    private int tele;
    
    //Assign Values
    public Student(int sid, String sname, int sage, String saddress, int stele){
        this.id=sid;
        this.name=sname;
        this.age=sage;
        this.address=saddress;
        this.tele=stele;
    }
    
    public int getID(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    
    public String getAddress(){
        return address;
    }
    
    public int getTele(){
        return tele;
    }
    
}
