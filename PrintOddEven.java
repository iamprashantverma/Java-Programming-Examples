class Counter {
    private int count = 1;
    private boolean isOdd = true;

    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
        isOdd = !isOdd;
    }

    public boolean isOddTurn() {
        return isOdd;
    }
}

class Odd extends Thread {
    
    private final Counter counter;

    public Odd(String name, Counter counter) {
        super(name);
        this.counter = counter;
    }

    public void run() {
        while (counter.getCount() <= 10) {
            synchronized (counter) {
                while (!counter.isOddTurn()) {
                    try {
                        counter.wait();
                    } catch (InterruptedException ignored) {}
                }
                if (counter.getCount() <= 10) {
                    System.out.println("Odd: " + counter.getCount());
                    counter.increment();
                    counter.notify();
                }
            }
        }
    }
}

class Even extends Thread {
    private final Counter counter;

    public Even(String name, Counter counter) {
        super(name);
        this.counter = counter;
    }

    public void run() {
        while (counter.getCount() <= 10) {
            synchronized (counter) {
                while (counter.isOddTurn()) {
                    try {
                        counter.wait();
                    } catch (InterruptedException ignored) {}
                }
                if (counter.getCount() <= 10) {
                    System.out.println("Even: " + counter.getCount());
                    counter.increment();
                    counter.notify();
                }
            }
        }
    }
}

public class PrintOddEven {
    public static void main(String[] args) {
        Counter count = new Counter();
        Thread o = new Odd("Odd Thread", count);
        Thread e = new Even("Even Thread", count);
        o.start();
        e.start();
    }
}
