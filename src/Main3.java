import java.util.Arrays;

public class Main3 {
    public static void main(String[] args) {
        int[] numbers = {2, 0, 0, 0, 1, 3, 5, 6, 0};

        int i, temp, count = 0;

        for (i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                temp = numbers[count];
                numbers[count] = numbers[i];
                numbers[i] = temp;
                count = count + 1;
            }
        }
        System.out.println(Arrays.toString(numbers));
    }
}
