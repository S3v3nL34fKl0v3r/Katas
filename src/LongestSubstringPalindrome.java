import java.util.ArrayList;

/**
 * Longest Palindrome Problem
 * banana -> anana
 * cabbage -> abba
 * racecar -> racecar
 */

class LongestSubstringPalindrome {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("banana");
        strings.add("cabbage");
        strings.add("racecar");

        for (String string : strings) {
            System.out.println(findLongestPalendrome(string));
        }
    }

    private static String findLongestPalendrome(String string) {
        String retVal = "";
        int max = -1;
        for(int i =0; i < string.length()-1; i++) {
            for(int j = string.length(); j>i; j--) {
                String substring = string.substring(i, j);
                if(isPalendrome(substring) && max < substring.length()) {
                    max=substring.length();
                    retVal=substring;
                }
            }
        }
        return retVal;
    }

    private static boolean isPalendrome(String candidate) {
        for(int i=0, j=candidate.length()-1; i<j; i++,j--) {
            if(candidate.charAt(i) != candidate.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
