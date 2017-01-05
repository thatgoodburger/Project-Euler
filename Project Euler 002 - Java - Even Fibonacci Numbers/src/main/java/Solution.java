import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by aaugsbur on 8/3/16.
 */
public class Solution {

    private static final Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        final int numberOfTests = scanner.nextInt();

        for (int i = 0; i < numberOfTests; ++i) {
            int sum = 0;
            int input = scanner.nextInt();

            final ArrayList<Integer> fibNumList = getFibNums(input);

            for (Integer x : fibNumList) {
                if (x % 2 == 0)
                    sum += x;
            }

            System.out.println(sum);
        }
    }

    public static ArrayList<Integer> getFibNums(int input) {
        int n1 = 1, n2 = 2, n3 = 3;
        ArrayList<Integer> fibNumList = new ArrayList<>(input);

        // TODO: remove the if / else bock
        if (input == 1) {
            fibNumList.add(n1);
        } else if (input == 2) {
            fibNumList.add(n1);
            fibNumList.add(n2);
        } else {
            fibNumList.add(n1);
            fibNumList.add(n2);

            // TODO: clean this up, submitting so it works
            while (n1 + n2 < input) {
                n3 = n1 + n2;
                n1 = n2;
                n2 = n3;

                fibNumList.add(n3);
            }
        }

        return fibNumList;
    }
}
