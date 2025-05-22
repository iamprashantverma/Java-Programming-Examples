import java.util.ArrayList;
import java.util.List;

public class StreamDemo {
    public static void main(String[] args) {
        // filter even Number

        List<Integer> nums = new ArrayList<>(List.of(1,1,2,3,4,5,6,7,8,9));
        // List<Integer> evenIntegers = nums.stream()
        // .filter(x-> x % 2  == 0)
        // .collect(Collectors.toList());
        // evenIntegers.stream().forEach(System.out::print);


        //  Convert to upper case

        List<String> names = List.of("alice", "bo", "carol");
        // List<String> nameInUpperCase = names.stream()
        //     .map(String::toUpperCase)
        //     .collect(Collectors.toList());
        // nameInUpperCase.forEach(System.out::print);

        //  find first element

        // String firstName = names.stream()
        // .findFirst().get();
        // System.out.println(firstName);

        //  remove duplicates

        // List<Integer> uniquIntegers = nums.stream()
        // .distinct()
        // .collect(Collectors.toList());
        // System.out.println(uniquIntegers);

        // sort in descending order
        
        // List<Integer> sortedIntegers = nums.stream()
        // .sorted((a,b)->b-a)
        // .distinct()
        // .collect(Collectors.toList());
        // System.out.println(sortedIntegers);

        // all elements greater then 5

        // List<Integer> greaIntegers = nums.stream()
        // .filter(x-> x > 5)
        // .toList();
        // System.out.println(greaIntegers);

     // filter name by length eg 3

    //    System.out.println(names.stream()
    //    .filter(x->x.length() >= 3)
    //    .toList());

    // find 2nd largest number

    // int secondLargest = nums.stream()
    // .sorted((a,b)->b-a)
    // .skip(1)
    // .findFirst()
    // .get();
    // System.out.println(secondLargest);

    

    }
}
