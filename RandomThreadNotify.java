class Counter {
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void increment(int val) {
        count += val;
    }
}

class A extends Thread {
    private final Counter counter;

    A(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (counter) {
            try {
                System.out.println("A is waiting...");
                counter.wait();
                System.out.println("Update By A");
                counter.increment(1);
                counter.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class B extends Thread {
    private final Counter counter;

    B(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (counter) {
            try {
                System.out.println("B is waiting...");
                counter.wait();
                System.out.println("Update By B");
                counter.increment(1);
                counter.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class C extends Thread {
    private final Counter counter;

    C(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (counter) {
            try {
                System.out.println("C is waiting...");
                counter.wait();
                System.out.println("Update By C");
                counter.increment(1);
                counter.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class RandomThreadNotify{
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        A a = new A(counter);
        B b = new B(counter);
        C c = new C(counter);

        a.start();
        b.start();
        c.start();

        Thread.sleep(2000); 

        synchronized (counter) {
            System.out.println("Main is notifying one thread...");
            counter.notify();  
        }

        a.join();
        b.join();
        c.join();

        System.out.println("Final count: " + counter.getCount());
    }
}
