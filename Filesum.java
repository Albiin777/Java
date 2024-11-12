import java.io.*;
import java.util.StringTokenizer;
public class Filesum {
    public static void main(String[] args){
        try{
        FileReader f=new FileReader("f3.txt");
        BufferedReader fn=new BufferedReader(f);
            int sum=0;
            String i;
            while((i=fn.readLine())!=null){
            StringTokenizer t=new StringTokenizer(i);
            while(t.hasMoreTokens()){
                String token=t.nextToken();
                int n=Integer.parseInt(token);
                System.out.println(n);
                sum=sum+n;
            }
        }System.out.println("Sum is" +sum);
        fn.close();
        }catch(IOException e){
            System.out.println(".eee");
    }
    }
}