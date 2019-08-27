import java.util.HashMap;

public class FindFirstOddRepetition {


    public static void main(String[] args) {
        try {
            System.out.println("longestConsec Fixed Tests");
            testing(FindFirstOddRepetition.findIt(new int[]{1,2,2}),1);
            testing(FindFirstOddRepetition.findIt(new int[]{1}),1);
            testing(FindFirstOddRepetition.findIt(new int[]{1,1,2}),2);
            testing(FindFirstOddRepetition.findIt(new int[]{1,1,2,2,3,2}),2);

            System.out.println("TESTS PASSED!!!");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static int findIt(int[] a) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < a.length ; i++) {
            int repetitions = map.get(a[i]) == null ? 1 : map.get(a[i]) + 1;
            if (map.containsKey(a[i])) {
                map.replace(a[i], repetitions);
            } else {
                map.put(a[i],repetitions);
            }
        }
        return map.keySet().stream().filter(v -> map.get(v)%2 ==1).findFirst().get();
    }

    private static void testing(int actual, int expected) throws Exception{
        if(expected != actual) {
            throw new Exception("\nExpected:"+ expected + "\nbut found actual:"+actual);
        }
    }
}
