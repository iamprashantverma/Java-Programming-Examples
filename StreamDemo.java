import java.util.ArrayList;
import java.util.List;

public class StreamDemo {
    public static void main(String[] args) {

        // Sample list of integers
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        // Sample list of strings
        List<String> names = List.of("alice", "bo", "carol");

        // 1. Filter even numbers
        List<Integer> evenIntegers = nums.stream()
            .filter(x -> x % 2 == 0)
            .collect(Collectors.toList());
        evenIntegers.forEach(System.out::print);

        // 2. Convert names to uppercase
        List<String> nameInUpperCase = names.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        nameInUpperCase.forEach(System.out::print);

        // 3. Find the first name in the list
        String firstName = names.stream()
            .findFirst()
            .get();
        System.out.println(firstName);

        // 4. Remove duplicates from the number list
        List<Integer> uniqueIntegers = nums.stream()
            .distinct()
            .collect(Collectors.toList());
        System.out.println(uniqueIntegers);

        // 5. Sort numbers in descending order and remove duplicates
        List<Integer> sortedIntegers = nums.stream()
            .sorted((a, b) -> b - a)
            .distinct()
            .collect(Collectors.toList());
        System.out.println(sortedIntegers);

        // 6. Filter elements greater than 5
        List<Integer> greaterThanFive = nums.stream()
            .filter(x -> x > 5)
            .toList();
        System.out.println(greaterThanFive);

        // 7. Filter names by length >= 3
        List<String> filteredNames = names.stream()
            .filter(x -> x.length() >= 3)
            .toList();
        System.out.println(filteredNames);

        // 8. Find the second largest number
        int secondLargest = nums.stream()
            .sorted((a, b) -> b - a)
            .skip(1)
            .findFirst()
            .get();
        System.out.println(secondLargest);

        // 9. Find the maximum element
        int maxElement = nums.stream()
            .max((a, b) -> a - b)
            .get();
        System.out.println(maxElement);

        // 10. Group names by their length
        Map<Integer, List<String>> gMap = names.stream()
            .collect(Collectors.groupingBy(x -> x.length()));
        System.out.println(gMap);

        // 11 Filter Names that start with 'c'
        List<String> nList = names.stream()
        .filter(x->x.startsWith("c"))
        .toList();
        System.out.println(nList);
    }
}
