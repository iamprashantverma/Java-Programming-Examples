class SingletonClass {
    private static SingletonClass obj = null;

    public SingletonClass() {
    }
    
    static synchronized  public  SingletonClass getInstance(){
        if (obj == null) {
            obj = new SingletonClass();
        }
        return obj;
    }
}

class Singleton {
    public static void main(String... args) {
        SingletonClass a = SingletonClass.getInstance();
        SingletonClass b = SingletonClass.getInstance();
        System.out.println(a == b);
    }
}