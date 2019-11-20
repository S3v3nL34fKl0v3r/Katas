import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JosephusSurvivor {

    public static void main(String[] args) {
        try {
            System.out.println("longestConsec Fixed Tests");
            testing(JosephusSurvivor.josephusSurvivor(7,3),4);
            testing(JosephusSurvivor.josephusSurvivor(11,19),10);
            testing(JosephusSurvivor.josephusSurvivor(40,3),28);
            testing(JosephusSurvivor.josephusSurvivor(14,2),13);
            testing(JosephusSurvivor.josephusSurvivor(100,1),100);

            System.out.println("TESTS PASSED!!!");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static int josephusSurvivor(final int n, final int k) {
        ArrayList<Integer> seq = IntStream.rangeClosed(1, n).boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        for(int i = (k-1)%seq.size(); seq.size()>1; i=(i+k-1)%seq.size()) {
            seq.remove(i);
        }
        return seq.get(0);
    }

    private static void testing(int actual, int expected) throws Exception{
        if(expected != actual) {
            throw new Exception("\nExpected:"+ expected + "\nActual:"+actual);
        }
    }

}
