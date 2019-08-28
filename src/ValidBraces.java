import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class ValidBraces {

    /**
     * Write a function that takes a string of braces, and determines if the order of the braces is valid. It should return true if the string is valid, and false if it's invalid.
     *
     * This Kata is similar to the Valid Parentheses Kata, but introduces new characters: brackets [], and curly braces {}. Thanks to @arnedag for the idea!
     *
     * All input strings will be nonempty, and will only consist of parentheses, brackets and curly braces: ()[]{}.
     *
     * What is considered Valid?
     * A string of braces is considered valid if all braces are matched with the correct brace.
     *
     * Examples
     * "(){}[]"   =>  True
     * "([{}])"   =>  True
     * "(}"       =>  False
     * "[(])"     =>  False
     * "[({})](]" =>  False
     */

    public static void main(String[] args ) {
        ValidBraces validBraces = new ValidBraces();
        try {
            testing(validBraces.isValid("(){}[]"), true);
            testing(validBraces.isValid("([{}])"), true);
            testing(validBraces.isValid("([{}()][])"), true);
            testing(validBraces.isValid("(}"), false);
            testing(validBraces.isValid("[(])"), false);
            testing(validBraces.isValid("[({})](]"), false);
            testing(validBraces.isValid(""), false);
            testing(validBraces.isValid("()}"), false);
            testing(validBraces.isValid("}}}"), false);
            testing(validBraces.isValid("{{}"), false);
            System.out.println("TESTS PASSED!!!");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }


    public boolean isValid(String braces) {
        HashSet<Character> opening = new HashSet<>(Arrays.asList('{','[','('));
        HashSet<Character> closing = new HashSet<>(Arrays.asList('}',']',')'));
        char[] sequence = braces.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int index = 0; index < sequence.length; index++) {
            if(opening.contains(sequence[index])) {
                stack.push(sequence[index]);
            } else if(closing.contains(sequence[index])
                    && !stack.isEmpty()
                    && isClosingForOpening(sequence[index],stack.peek())) {
                stack.pop();
            } else {
                return false; //invalid character, mis-matched closing bracket, or empty stack;
            }
        }
        return braces.length() > 0 && stack.isEmpty();
    }

    private boolean isClosingForOpening(char closing, char candidate) {
        switch (closing) {
            case ']': return candidate == '[';
            case '}': return candidate == '{';
            case ')': return candidate == '(';
            default: return false;
        }
    }

    private static void testing(boolean actual, boolean expected) throws Exception {
        if (expected != actual) {
            throw new Exception("\nExpected:" + expected + "\nbut found actual:" + actual);
        }
    }
}
