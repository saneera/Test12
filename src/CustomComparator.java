import java.util.Comparator;

public class  CustomComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if ( o1 != 0) {
             return 1;
        }  else if (o2 != 0) {
             return -1;
         } else {
              return 0;
         }
      }
}
