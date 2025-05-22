import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        // filter even Number
        List<Integer> nums = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));
        List<Integer> evenIntegers = nums.stream()
        .filter(x-> x % 2  == 0)
        .collect(Collectors.toList());
        // evenIntegers.stream().forEach(System.out::print);


        //  Convert to upper case
        List<String> names = List.of("alice", "bob", "carol");
        List<String> nameInUpperCase = names.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        // nameInUpperCase.forEach(System.out::print);

        //  find first element
        String firstName = names.stream()
        .findFirst().get();
        // System.out.println(firstName);




    }
}
