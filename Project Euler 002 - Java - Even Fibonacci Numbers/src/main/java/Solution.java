import java.util.ArrayList;
import java.util.Scanner;

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
            int input = scanner.nextInt();

            final ArrayList<Integer> fibNumList = getFibNums(input);
        }
    }

    public static ArrayList<Integer> getFibNums(int input) {
        int n1 = 1, n2 = 2, n3;
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
            for (int i = 2; i < input; ++i) {
                n3 = n1 + n2;
                n1 = n2;
                n2 = n3;

                fibNumList.add(n3);
            }
        }

        return fibNumList;
    }
}
