import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            FileReader f1 = new FileReader("f1.txt");
            StringBuilder s = new StringBuilder();
            int i = 0;
            while ((i = f1.read()) != -1) {
                s.append((char) i);
            }
            f1.close();

            String s1 = s.toString();
            String s2 = s1.replaceAll("[\\s\\t\\n]", "");
            int length = s2.length();
            System.out.println("No of characters in f2.txt (without spaces and newlines): " + length);

            // Reverse the content
            s.reverse();

            // Use BufferedWriter for efficient writing
            BufferedWriter f2 = new BufferedWriter(new FileWriter("f2.txt"));
            f2.write(s.toString());
            System.out.println("File copied in reverse order successfully.");
            f2.close();

            System.out.println("Enter character to search:");
            char n1 = sc.next().charAt(0);
            sc.close();

            int count = 0;
            for (int j = 0; j < s.toString().length(); j++) {
                if (s.toString().charAt(j) == n1) {
                    count++;
                }
            }
            System.out.println("Occurrences of character " + n1 + ": " + count);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}
