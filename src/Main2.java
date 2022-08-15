import java.util.HashSet;

public class Main2 {
    private static int j;

    public static void main(String[] args) {
        int i;
        //System.out.println(j);
        Main2 m = new Main2();
        //m.method1();

        HashSet set = new HashSet();
        for (short k =0 ; k<100; k++) {
           set.add(k);
           set.remove(k-1);
           System.out.println(set.size());
        }
    }

    public void method1(){
        int i;
        System.out.println(j);
    }


}
