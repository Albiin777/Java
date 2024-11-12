class Even extends Thread{
    public void run(){
        synchronized(System.out){
        System.out.println("Even nos.:");
        for(int i=0;i<10;i+=2){
            System.out.println(i);}
        }
    }
}
class Odd extends Thread{
    public void run(){
        synchronized(System.out){
        System.out.println("Odd nos.:");
        for(int i=1;i<10;i+=2){
            System.out.println(i);}
        }
    }
}
public class Synchroeg {
    public static void main(String[] args) {
        Odd o=new Odd();
        Even e=new Even();
        e.start();
        o.start();
    }
}
