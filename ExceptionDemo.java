import java.util.Scanner;

// Unchecked custom Exception
class InvalidAgeException extends RuntimeException  {

    public InvalidAgeException(String m){
        super(m);
    }
}

// checked custom exception
class InvalidGradesException extends Exception {
    public InvalidGradesException(String m) {
        super(m);
    }
}
public class ExceptionDemo {

    public static void vote() {
        System.out.println("Enter your age to vote :");
        Scanner sc = new Scanner(System.in);
        int age  = sc.nextInt();
        if (age < 18) 
            throw new InvalidAgeException("Your age is below 18 not eligible for voting");
        System.out.println("Voted Successfully");
    }
    public static void apply() throws InvalidGradesException {
        System.out.println("Enter Your CGPA: ");
        Scanner sc = new Scanner(System.in);
        float cgpa = sc.nextFloat();
        // try {
            if (cgpa < 7.5) 
                throw new InvalidGradesException("Your are not eligible , CGPA is below 7.5");
            else 
                System.out.println("applied");
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // } finally{
        //     System.out.println("applied");
        // }
    }
    public static void main(String[] args) {
        try {
            vote();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            System.out.println("Voting accomplished");
        }
        apply();
    }
}
