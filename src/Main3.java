import java.util.Arrays;
import java.util.stream.IntStream;

public class Main3 {


    private static boolean isPalindromeInJava8(String input) {

        return IntStream.range(0, input.length() / 2)
                .noneMatch(index -> input.charAt(index) != input.charAt(input.length() - index - 1));

    }


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

        String input2 = "abcba";
        boolean isPalindrome = isPalindromeInJava8(input2);
        System.out.println("Is " + input2 + " palindrome? " + isPalindrome);


    }
}
