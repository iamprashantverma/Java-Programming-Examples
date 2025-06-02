public class SecondLargest {
    public int getSecondLargest(int[] arr) {
        int fl = 0 ,sl = 0;
        
        for (int x : arr) {
            if (fl < x) {
                sl = fl;
                fl = x;
            }  else if(sl < x && x != fl) {
                sl = x;
            }
        }
        return sl == 0 ? -1 :sl;
        
    }
}
