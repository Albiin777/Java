class Evenclass extends Thread{
    public void run(){
        System.out.println("Even nos.:");
        for(int i=0;i<=20;i+=2){
            System.out.println(i);}
}   }
class Oddclass implements Runnable{
    public void run(){
        System.out.println("Odd nos.:");
        for(int i=1;i<20;i+=2){
            System.out.println(i);}
}   }
class Threadexample {
    public static void main(String[] args) {
        Evenclass e=new Evenclass();
        e.start();
        try{
            e.join();}
        catch(InterruptedException ex){
            System.out.println("Interrupted Exception!");}
        Oddclass o=new Oddclass();
        Thread t=new Thread(o);
        t.start();
        try{
            t.join();}
        catch(InterruptedException ex){
            System.out.println("Interrupted Exception!");}
}    }

