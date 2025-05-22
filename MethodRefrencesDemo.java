import java.util.Arrays;
import java.util.List;

public class MethodRefrencesDemo {
    static void show(int... x) {
        System.out.println("hello " );
    }

    public static void main(String[] args) {
        List<Integer> x = Arrays.asList(1, 2, 3, 4);
        x.forEach(MethodRefrencesDemo::show); 
    }
}
