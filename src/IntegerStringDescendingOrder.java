import java.util.Arrays;

public class IntegerStringDescendingOrder {
    /**
     * Your task is to make a function that can take any non-negative integer as a argument and return it with its digits in descending order. Essentially, rearrange the digits to create the highest possible number.
     *
     * Examples:
     * Input: 21445 Output: 54421
     *
     * Input: 145263 Output: 654321
     *
     * Input: 1254859723 Output: 9875543221
     */

    public static void main(String[] args ) {
        try {
            testing(IntegerStringDescendingOrder.sortDesc(21445)+"", "54421");
            System.out.println("TESTS PASSED!!!");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static int sortDesc(final int num) {
        char[] numbers = Integer.toString(num).toCharArray();
        Arrays.sort(numbers);
        StringBuilder retval = new StringBuilder();
        for(int i = numbers.length-1; i >= 0; i--) {
            retval.append(numbers[i]);
        }
        return Integer.valueOf(retval.toString());
    }


    private static void testing(String actual, String expected) throws Exception {
        if (!expected.equals(actual)) {
            throw new Exception("\nExpected:" + expected + "\nbut found actual:" + actual);
        }
    }
}
