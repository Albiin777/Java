import java.util.Scanner;
import java.io.*;
public class filereverse
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    try{
	        FileReader f1=new FileReader("f1.txt");
	        StringBuilder s=new StringBuilder();
	        int i=0;
	        while((i=f1.read())!=-1){
	            s.append((char)i);
	            
	        }
	        f1.close();

	        String s1=s.toString();
	        String s2=s1.replaceAll("[\\s\\t\\n]","");
	        int length=s2.length();
	        System.out.println("no of characters in f2.txt="+ length);
	        s.reverse();

	        BufferedWriter f2 = new BufferedWriter(new FileWriter("f2.txt"));
	        String s3=s.toString();
            //System.out.println(s3);

	        f2.write(s3);
            System.out.println("File copied in reverse order succesfully.");
            f2.close();

            System.out.println("enter character to search:");
            char n1=sc.next().charAt(0);
            sc.close();
            int count=0;
            for (int j = 0; j < s3.length(); j++) {
                if (s3.charAt(j) == n1) {
                    count++;
                }
            }
            System.out.println(("occurances of character "+ n1+": "+ count));

	    }
	    catch(Exception e){
	        System.out.println("Exception occured!");
	    }
	    
	}
	
}