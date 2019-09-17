import java.util.Arrays;

/**
 * Kata information:
 * https://www.codewars.com/kata/decode-the-morse-code/train/java
 */

public class MorseCodeDecoder {

    public static String decode(String morseCode) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(morseCode.trim().split(" ")).forEach(seq -> {
            sb.append(seq.isEmpty() ? " " : MorseCode.get(seq));
        });
        return sb.toString().replace("  ", " ");
    }

}

class MorseCode {
    public static String get(String seq) {
        // This is a static function that was made available for use in this CodeWars Kata
        // Included only for conciseness
        return seq;
    }
}
