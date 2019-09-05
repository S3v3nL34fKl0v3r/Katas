public class PrimeDecompositionOfInteger {
    /**
     * Given a positive number n > 1 find the prime factor decomposition of n.
     * The result will be a string with the following form :
     *
     *  "(p1**n1)(p2**n2)...(pk**nk)"
     * with the p(i) in increasing order and n(i) empty if n(i) is 1.
     *
     * Example: n = 86240 should return "(2**5)(5)(7**2)(11)"
     *
     */

    public static void main(String[] args) {
        try {
            System.out.println("longestConsec Fixed Tests");
            testing(PrimeDecompositionOfInteger.factors(86240),
                    "(2**5)(5)(7**2)(11)");
            testing(PrimeDecompositionOfInteger.factors(7775460),
                    "(2**2)(3**3)(5)(7)(11**2)(17)");

            System.out.println("TESTS PASSED!!!");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static String factors(int n) {

        int iterations=0;
        int i;
        StringBuilder sb = new StringBuilder();
        for(i = 2; n>0 ; i++) {
            iterations=0;
            while(n%i==0) {
                n/=i;
                iterations++;
            }
            if(iterations>=1){
                sb.append(iterations==1 ? "("+i+")" : "("+i+"**"+iterations+")");
            }
        }
        return sb.toString();
    }

    private static void testing(String actual, String expected) throws Exception{
        if(!expected.equals(actual)) {
            throw new Exception("\nExpected:"+ expected + "\nbut found actual:"+actual);
        }
    }
}
