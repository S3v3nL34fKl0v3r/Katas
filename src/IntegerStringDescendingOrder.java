import java.util.Arrays;

public class IntegerStringDescendingOrder {

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
