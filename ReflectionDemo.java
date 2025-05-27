
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

class Person {
    private int income;
    private int age;
    
    Person(int age , int income) {
        this.age = age;
        this.income = income;
    }

    int getAge() {
        return age;
    }

    int getIncome() {
        return income;
    }
}

public class ReflectionDemo {
    public static void main(String[] args) throws  Exception {
        Class c = Class.forName("Person");
        // System.out.println(c.getClass());
        Field field[] = c.getDeclaredFields(); // accessing the private fields
        System.out.println(field.length);
        for (Field f : field) {
            System.out.println(f.getName());
        }
        Constructor cn [] = c.getDeclaredConstructors();
        for (Constructor cs :cn) {
            System.out.println(cs);
        }

    }
}