class Money {
    private final int price;

    public Money() {
        this.price = 0;
    }

    public int value() {
        return price;
    }
}

class A extends Thread {
    private final Money aMoney;
    private final Money bMoney;

    public A(Money aMoney, Money bMoney) {
        this.aMoney = aMoney;
        this.bMoney = bMoney;
    }

    @Override
    public void run() {
        synchronized (aMoney) {
            System.out.println("A: Locked aMoney, trying to lock bMoney...");
            try { Thread.sleep(100); } catch (Exception e) {}
            synchronized (bMoney) {
                System.out.println("A: Locked bMoney too.");
            }
        }
    }
}

class B extends Thread {
    private final Money aMoney;
    private final Money bMoney;

    public B(Money aMoney, Money bMoney) {
        this.aMoney = aMoney;
        this.bMoney = bMoney;
    }

    @Override
    public void run() {
        synchronized (bMoney) {
            System.out.println("B: Locked bMoney, trying to lock aMoney...");
            try { Thread.sleep(1000); } catch (Exception e) {}
            synchronized (aMoney) {
                System.out.println("B: Locked aMoney too.");
            }
        }
    }
}

public class PracticeDeadlock {
    public static void main(String[] args) {
        Money aMoney = new Money();
        Money bMoney = new Money();

        A a = new A(aMoney, bMoney);
        B b = new B(aMoney, bMoney);

        a.start();
        b.start();
    }
}
