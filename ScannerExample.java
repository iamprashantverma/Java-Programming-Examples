import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        Integer num = scanner.nextInt();
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Number: " + num);
        System.out.println("Name: " + name);

        scanner.close();
    }
}
