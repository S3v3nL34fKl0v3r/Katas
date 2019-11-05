import java.util.Arrays;

class AirportFlapDisplay {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ?!@#&()|<>.:=-+*/0123456789";

    public static void main(String[] args) {
        try {
            testing(
                    flapDisplay(new String[]{}, new int[][]{}),
                    new String[]{});

            testing(
                    flapDisplay(new String[]{"CAT"}, new int[][]{{1,13,27}}),
                    new String[]{"DOG"});

            testing(
                    flapDisplay(new String[]{"HELLO "}, new int[][]{{15,49,50,48,43,13}}),
                    new String[]{"WORLD!"});

            testing(
                    flapDisplay(new String[]{"CODE"}, new int[][]{{20,20,28,0}}),
                    new String[]{"WARS"});

            testing(
                    flapDisplay(new String[]{"CAT","CODE"}, new int[][]{{1,13,27},{20,20,28,0}}),
                    new String[]{"DOG","WARS"});

            System.out.println("ALL TESTS PASSED!!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String[] flapDisplay(final String[] lines, final int[][] rotors) {
        String[] flappedLines = new String[lines.length];

        for(int i = 0; i < lines.length; i++) {
            flappedLines[i] = flapLine(lines[i], rotors[i]);
        }
        return flappedLines;
    }

    public static String flapLine(String line, int[] rotor) {
        char[] lineChars = line.toCharArray();
        for(int i = 0, cursor=0; i < line.length(); i++) {
            cursor+=rotor[i];
            int current = ALPHABET.indexOf(lineChars[i]);
            int next = (current + cursor) % ALPHABET.length();
            lineChars[i] = ALPHABET.charAt(next);
        }
        return String.valueOf(lineChars);
    }

    private static void testing(String[] actual, String[] expected) throws Exception{
        if(!Arrays.equals(actual, expected)) {
            throw new Exception("\nExpected:"+ expected + "\n  Actual:"+actual);
        }
    }
} 
