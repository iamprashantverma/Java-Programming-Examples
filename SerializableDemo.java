import java.io.*;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    // 'transient' field won't be serialized
    private transient String password;

    public Person(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", password='" + password + "'}";
    }
}

public class SerializableDemo {
    public static void main(String[] args) {

        String filename = "person.ser";

        Person person = new Person("Alice", 25, "secret123");


        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(person);
            System.out.println("Object serialized to " + filename);
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println(" Object deserialized:");
            System.out.println(deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(" Error during deserialization: " + e.getMessage());
        }
    }
}
