import java.awt.*;

public class TenMinWalk {
    /**
     * You live in the city of Cartesia where all roads are laid out in a perfect grid. You arrived ten minutes too early
     * to an appointment, so you decided to take the opportunity to go for a short walk. The city provides its citizens
     * with a Walk Generating App on their phones -- everytime you press the button it sends you an array of one-letter
     * strings representing directions to walk (eg. ['n', 's', 'w', 'e']). You always walk only a single block in a
     * direction and you know it takes you one minute to traverse one city block, so create a function that will return
     * true if the walk the app gives you will take you exactly ten minutes (you don't want to be early or late!) and will,
     * of course, return you to your starting point. Return false otherwise.
     *
     * Note: you will always receive a valid array containing a random assortment of
     * direction letters ('n', 's', 'e', or 'w' only). It will never give you an empty array
     * (that's not a walk, that's standing still!).
     */

    public static void main(String[] args) {
        try {
            testing(TenMinWalk.isValid(new char[] {'n','s','n','s','n','s','n','s','n','s'}), true);
            testing(TenMinWalk.isValid(new char[] {'w','e','w','e','w','e','w','e','w','e','w','e'}),false);
            testing(TenMinWalk.isValid(new char[] {'w'}),false);
            testing(TenMinWalk.isValid(new char[] {'n','n','n','s','n','s','n','s','n','s'}),false);
            System.out.println("TESTS PASSED!!!");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static boolean isValid(char[] walk) {
        Point p = new Point();
        for(char direction: walk) {
            switch (direction) {
                case 'n': p.translate(0,1); break;
                case 's': p.translate(0,-1); break;
                case 'e': p.translate(1,0); break;
                case 'w': p.translate(-1,0); break;
            }
        }
        return walk.length == 10 && p.equals(new Point(0,0));
    }

    private static void testing(Boolean actual, Boolean expected) throws Exception{
        if(!expected.equals(actual)) {
            throw new Exception("\nExpected:"+ expected + "\nbut found actual:"+actual);
        }
    }
}