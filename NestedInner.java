class Outer {
    int x = 10 ;
    // Inner ir = new Inner(); accessable to the entire class
    class Inner {
        static int y = 20;
        public void innerDisplay() {
            System.out.println(x +" "+ y);
        }
    }
    // 
    
}
public class NestedInner {
   public static void main(String[] args) {
    Outer.Inner oi = new Outer().new Inner();
    oi.innerDisplay();
   }
}
