import java.util.Scanner;
public class New {
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        System.out.println("Enter number: ");
        int i;
        int num = in.nextInt();
        System.out.println("The fators of " + num + " are:");
        for(i=1;i<=num;i++){
            if(num%i==0){
                System.out.println(i);
        }
        }   
    }
}