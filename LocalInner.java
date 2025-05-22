// Class demonstrating the use of local inner classes
class Outer {

    private int x = 2;

    // Method with a local inner class
    public void display() {
        class Inner {
            public void show() {
                System.out.println("Hello " + x);
            }
        }

        Inner inner = new Inner();
        inner.show();
    }

    // Another method with its own local inner class
    public void displaySecond() {
        class Inner {
            public void show() {
                System.out.println("Hello " + x);
            }
        }

        Inner inner = new Inner();
        inner.show();
    }
}

// Main class to run the example
public class LocalInner {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.display();         // Output: Hello 2
        outer.displaySecond();   // Output: Hello 2
    }
}
// LocalInner.class
// Outer.class
// Outer$1Inner.class
// Outer$2Inner.class 
// -> the above 1 and 2 are indicating the order of the local inner classes
