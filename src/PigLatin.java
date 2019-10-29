import java.util.Arrays;

public class PigLatin {
    public static void main(String[] args){
        try {
            testing(pigIt("Pig latin is cool"), "igPay atinlay siay oolcay");
            testing(pigIt("Hello world !"), "elloHay orldway !");
            testing(pigIt("Hello world ! I am fun ."), "elloHay orldway !");
            testing(pigIt("Hello world !"), "elloHay orldway !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String pigIt(String str) {
        String[] retVal = {""};
        Arrays.stream(str.split(" ")).forEach(i -> {
            retVal[0] += i.length() > 1 ? i.substring(1) + i.charAt(0) + "ay " : punctuationOrPigLatin(i);
        });
        return retVal[0].trim();
    }

    public static String punctuationOrPigLatin(String c) {
        return "?!.".contains(c+"") ? c : c + "ay ";
    }

    private static void testing(String actual, String expected) throws Exception{
        if(!actual.equals(expected)) {
            throw new Exception("\nExpected:"+ expected + "\n  Actual:"+actual);
        }
    }
}
