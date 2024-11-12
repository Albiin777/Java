import java.io.*;
class Test implements Serializable{
    int a;
    String b;
    Test(int a,String b){
        this.a=a;
        this.b=b;
    }
}
public class Serializationeg {
    public static void main(String[] args) {
        
    
    Test t=new Test(1,"hi");
    try{
    FileOutputStream f=new FileOutputStream("hi.txt");
    ObjectOutputStream o= new ObjectOutputStream(f);
    o.writeObject(t);
    o.close();
    f.close();
    System.out.println("Object has been Serialized");}
    catch(FileNotFoundException e){
        System.out.println("Eception!");
    }
    catch(Exception e){
        System.out.println("Exception.");
    }
}}
