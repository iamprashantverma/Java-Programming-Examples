import java.util.*;

class Demo {
    // Accepts a list of Integer or its supertypes (e.g., Number, Object)
    public void addInteger(List<? super Integer> list) {
        list.add(10);  // Allowed
        list.add(20);  // Allowed
        // You can’t read as Integer, only as Object
        Object val = list.get(0);
        System.out.println(val);
    }
}

public class GenricDemo {
    public static void main(String[] args) {
        Demo demo = new Demo();

        List<Number> numberList = new ArrayList<>();
        demo.addInteger(numberList);  // Works with List<Number>

        List<Object> objectList = new ArrayList<>();
        demo.addInteger(objectList);  // Also works with List<Object>

        // List<Double> doubleList = new ArrayList<>();
        // demo.addInteger(doubleList); // ❌ Won’t compile (Double is not a supertype of Integer)
    }
}
