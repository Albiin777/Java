import java.io.*;
public class Deserializationeg {
    public static void main(String[] args) {
        
        try{
            FileInputStream f=new FileInputStream("hi.txt");
            ObjectInputStream o =new ObjectInputStream(f);
            Test t=(Test)o.readObject();
            System.out.println(t.a+" "+t.b);
        }
        catch(Exception e){
            System.out.println("Exception.");
        }
    }
}
