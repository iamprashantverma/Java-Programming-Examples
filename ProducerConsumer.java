class Product {

    private int size = 0;

    public synchronized void produce() {
        size = 1;
    }

    public synchronized void consume() {
        size = 0;
    }

    public synchronized int size() {
        return size;
    }
}

class Consumer extends Thread {
    private final Product product;

    public Consumer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (product) {
                    while (product.size() == 0) {
                        product.wait();
                    }
                    product.consume();
                    System.out.println("Product consumed..");
                    product.notify();
                }
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Producer extends Thread {
    private final Product product;

    public Producer(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (product) {
                    while (product.size() == 1) {
                        product.wait();
                    }
                    product.produce();
                    System.out.println("Product Produced");
                    product.notify();
                }
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        Product product = new Product();
        Producer p = new Producer(product);
        Consumer c = new Consumer(product);
        p.start();
        c.start();
    }
}
