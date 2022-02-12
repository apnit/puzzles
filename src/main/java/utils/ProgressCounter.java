package utils;

/**
 * Simple progress counter
 *
 * <p>It counts and print the current iteration number.</p>
 */
public class ProgressCounter {

    /**
     * Prints the appropriate form of the current iteration
     *
     * @param number the current iteration number
     * @param target the target number
     */
    public static void count(int number, int target) {
        if (number == 0) {
            // First iteration
            System.out.printf("0/%d", target);
            return;
        }

        String previousNumber = String.valueOf(number - 1);
        String numberString = String.valueOf(number);
        String targetString = String.valueOf(target);

        for (int i = 0; i <= targetString.length() + previousNumber.length(); i++) {
            System.out.print("\b");
        }

        System.out.printf("%s/%s", numberString, targetString);

        // Last iteration
        if (number == target) {
            System.out.println(" Done");
        }
    }

}
